package Main;

public class Main {
  public static void main(String[] args) {
  }

  public static class ALU {
    private int A, B, S;
    public int OVR, CN, CN4;
    String F = "";
    public ALU(int a, int b, int c, int cn) {
      if (a < 0b10000 && b < 0b10000 && c < 0b1000) {
        A = a;
        B = b;
        S = c;
        CN = cn;
      } else {
        System.out.println("Invalid Input");
        System.exit(0);
      }
    }

    public String select() {
      switch (S) {
        case 0b000:
          F = toBinary(0b0000);
          break;
        case 0b001:
          F = toBinary(subtract(B, A));
          break;
        case 0b010:
          F = toBinary(subtract(A, B));
          break;
        case 0b011:
          F = toBinary(add(A, B));
          break;
        case 0b100:
          F = toBinary(A ^ B);
          break;
        case 0b101:
          F = toBinary(A | B);
          break;
        case 0b110:
          F = toBinary(A & B);
          break;
        case 0b111:
          F = toBinary(0b1111);
          break;
      }
      if (OVR == 1){
        System.out.println("Because overflow has occurred, the value of F may be incorrect");
      }
      System.out.println("Value of F: " + F + "\nValue of CN4: " + CN4 + "\nValue of OVR: " + OVR);
      return F;
    }

    public int subtract(int a, int b) {
      if (CN == 1) {
        boolean negA = false;
        boolean negB = false;
        if (a > 7) {
          negA = true;
          a = -1 * (15 - a + 1);
        } else if (a < 0) {
          negA = true;
        }
        if (b > 7) {
          negB = true;
          b = -1 * (15 - b + 1);
        } else if (b < 0) {
          negB = true;
        }
        int newB = -b;
        int sum = a + newB;
        if ((!negA && !negB) || (negA && negB)) {
          OVR = 0;
          if (sum >= 0) {
            CN4 = 1;
          } else {
            CN4 = 0;
          }
        } else if (!negA && negB) {
          CN4 = 0;
          if (sum >= 8) {
            OVR = 1;
          } else {
            OVR = 0;
          }
        } else if (negA && !negB) {
          CN4 = 1;
          if (sum < -8) {
            OVR = 1;
          } else {
            OVR = 0;
          }
        }
        return sum;
      }
      System.out.println("Invalid Input");
      System.exit(0);
      return 0;
    }

    public int add(int a, int b) {
      if (CN == 0) {
        int newB;
        if (b > 7) {
          newB = (15 - b + 1);
        } else {
          newB = -b;
        }
        CN = 1;
        return subtract(a, newB);
      }
      System.out.println("Invalid Input");
      System.exit(0);
      return 0;
    }

    public String toBinary(int x) {
      int power = 8;
      String f = "";
      int digit = 1;
      if (x < 0) {
        x = -x - 1;
        digit = 0;
      }
      while (power != 0) {
        if ((x / power) != 0) {
          f += digit;
          x -= power;
        } else {
          f += (1 - digit);
        }
        power /= 2;
      }
      return f;
    }
  }
}


