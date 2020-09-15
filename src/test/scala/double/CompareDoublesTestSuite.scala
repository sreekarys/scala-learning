package double

import org.junit.{Assert, Test}

class CompareDoublesTestSuite {

  @Test def `compare doubles`: Unit = {
    val c: CompareDoubles = new CompareDoubles();
    Assert.assertTrue(c.compare(1.0001, 1.0002))
    Assert.assertFalse(c.compare(1.001, 1.002))
    Assert.assertFalse(c.compare(1,2))
    Assert.assertTrue(c.compare(100, 100))
    Assert.assertTrue(c.compare(100, 100.0001))
    Assert.assertFalse(c.compare(100, 100.001))

    val c1: CompareDoubles = new CompareDoubles(2);
    Assert.assertTrue(c1.compare(1.001, 1.002))
    Assert.assertFalse(c1.compare(1.01, 1.02))
    Assert.assertFalse(c1.compare(1,2))
    Assert.assertTrue(c1.compare(100, 100))
    Assert.assertTrue(c1.compare(100, 100.001))
    Assert.assertFalse(c1.compare(100, 100.01))
  }
}
