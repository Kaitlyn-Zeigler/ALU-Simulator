import Main.Main;
import org.junit.Test;
import Main.Main.ALU;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class test {

  @Test
  public void testClear() {
    ALU alu = new ALU(0b1010, 0b0110, 0b000, 0);
    assertEquals("0000", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(0, alu.OVR);
  }

  @Test
  public void testEXOR() {
    ALU alu = new ALU(0b1010, 0b0110, 0b100, 0);
    assertEquals("1100", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(0, alu.OVR);
  }

  @Test
  public void testOR() {
    ALU alu = new ALU(0b1010, 0b0110, 0b101, 0);
    assertEquals("1110", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(0, alu.OVR);
  }

  @Test
  public void testAND() {
    ALU alu = new ALU(0b1010, 0b0110, 0b110, 0);
    assertEquals("0010", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(0, alu.OVR);
  }

  @Test
  public void testPreset() {
    ALU alu = new ALU(0b1010, 0b0110, 0b111, 0);
    assertEquals("1111", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(0, alu.OVR);
  }

  @Test
  public void testSubBFromA() {
    ALU alu = new ALU(0b0011, 0b0110, 0b001, 1);
    assertEquals("0011", alu.select());
    assertEquals(1, alu.CN4);
    assertEquals(0, alu.OVR);
    ALU alu2 = new ALU(0b0110, 0b0011, 0b001, 1);
    assertEquals("1101", alu2.select());
    assertEquals(0, alu2.CN4);
    assertEquals(0, alu2.OVR);
  }

  @Test
  public void testSubBFromA2() {
    ALU alu = new ALU(0b1101, 0b1010, 0b001, 1);
    assertEquals("1101", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(0, alu.OVR);
    ALU alu2 = new ALU(0b1010, 0b1101, 0b001, 1);
    assertEquals("0011", alu2.select());
    assertEquals(1, alu2.CN4);
    assertEquals(0, alu2.OVR);
  }

  @Test
  public void testSubBFromA3() {
    ALU alu = new ALU(0b0011, 0b1010, 0b001, 1);
    assertEquals("0111", alu.select());
    assertEquals(1, alu.CN4);
    assertEquals(1, alu.OVR);
    ALU alu2 = new ALU(0b0010, 0b1101, 0b001, 1);
    assertEquals("1011", alu2.select());
    assertEquals(1, alu2.CN4);
    assertEquals(0, alu2.OVR);
  }

  @Test
  public void testSubBFromA4() {
    ALU alu = new ALU(0b1101, 0b0110, 0b001, 1);
    assertEquals("1001", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(1, alu.OVR);
    ALU alu2 = new ALU(0b1101, 0b0010, 0b001, 1);
    assertEquals("0101", alu2.select());
    assertEquals(0, alu2.CN4);
    assertEquals(0, alu2.OVR);
  }

  @Test
  public void testSubAFromB() {
    ALU alu = new ALU(0b0110, 0b1101, 0b010, 1);
    assertEquals("1001", alu.select());
    assertEquals(0, alu.CN4);
    assertEquals(1, alu.OVR);
    ALU alu2 = new ALU(0b0010, 0b1101, 0b010, 1);
    assertEquals("0101", alu2.select());
    assertEquals(0, alu2.CN4);
    assertEquals(0, alu2.OVR);
  }

  @Test
  public void testAdd() {
    ALU alu = new ALU(0b0110, 0b1101, 0b011, 0);
    assertEquals("0011", alu.select());
    assertEquals(1, alu.CN4);
    assertEquals(0, alu.OVR);
    ALU alu2 = new ALU(0b0010, 0b0110, 0b011, 0);
    assertEquals("1000", alu2.select());
    assertEquals(0, alu2.CN4);
    assertEquals(1, alu2.OVR);
    ALU alu3 = new ALU(0b1101, 0b0110, 0b011, 0);
    assertEquals("0011", alu3.select());
    assertEquals(1, alu3.CN4);
    assertEquals(0, alu3.OVR);
    ALU alu4 = new ALU(0b1110, 0b1010, 0b011, 0);
    assertEquals("1000", alu4.select());
    assertEquals(1, alu4.CN4);
    assertEquals(0, alu4.OVR);
  }
}

