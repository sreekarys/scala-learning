package timer

import org.junit.{Assert, Test}

class TimerTestSuite {

  @Test def `timer test`: Unit = {
    val t = new Timer[Int, String]()
    Assert.assertEquals("2", t.measureTime(x => x.toString)(2))
  }
}
