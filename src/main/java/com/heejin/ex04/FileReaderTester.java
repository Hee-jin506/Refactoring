package com.heejin.ex04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {
  FileReader _input;
  FileReader _empty;
  
  public FileReaderTester(String name) {
    super(name);
  }
  
  
  @Override
  protected void setUp() {
    try {
      _input = new FileReader("data.txt");
      _empty = newEmptyFile();
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
  }
  
  private FileReader newEmptyFile() throws IOException {
    File empty = new File("empty.txt");
    FileOutputStream out = new FileOutputStream(empty);
    out.close();
    return new FileReader(empty);
  }
  
  public void testEmptyRead() throws IOException {
    assertEquals(-1, _empty.read());
  }
  
  @Override
  protected void tearDown() {
    try {
      _input.close();
    } catch (IOException e) {
      throw new RuntimeException("error on closing test.file");
    }
  }
  
  public void testRead() throws IOException {
    char ch = '$';
    for (int i = 0; i < 4; i++)
      ch = (char)_input.read();
    System.out.println(ch);
    assert('2'==ch);
  }
  
  public static TestSuite suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new FileReaderTester("testRead"));
    suite.addTest(new FileReaderTester("testReadAtEnd"));
    return suite;
  }
  
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
  }
  
  
  public void testReadBoundaries() throws IOException {
    assertEquals("read first char", 'B', _input.read());
    int ch = -1234;
    for (int i = 0; i < 149; i++)
      ch = _input.read();
    assertEquals("read last char", '6', ch);
    assertEquals("read at end", -1, _input.read());
    assertEquals("read at end", -1, _input.read());
  }
  
  public void testReadClose() throws Exception {
    _input.close();
    try {
      _input.read();
      fail("no exception for read past end");
    } catch (IOException e) {}
  }
}
