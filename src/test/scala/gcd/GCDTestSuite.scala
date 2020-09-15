package gcd

import org.junit.{Assert, Test}

class GCDTestSuite {

  @Test def `gcd`: Unit = {
    val gcd = new GCD()
    Assert.assertEquals(2, gcd.gcd(2,4))
    Assert.assertEquals(2, gcd.gcd(4,6))
    Assert.assertEquals(1, gcd.gcd(2,3))
  }
}
