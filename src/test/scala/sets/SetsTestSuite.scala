package sets

import org.junit.{Assert, Test}

class SetsTestSuite {

  @Test def `contains and incl`: Unit = {
    Assert.assertFalse(new EmptySet().contains(1))
    Assert.assertTrue(new EmptySet().incl(1).contains(1))
    Assert.assertFalse(new EmptySet().incl(1).contains(2))
    Assert.assertFalse(new EmptySet().incl(1).incl(2).contains(2))
    Assert.assertFalse(new EmptySet().incl(1).incl(2).contains(3))
  }

  @Test def `union`: Unit = {
    Assert.assertTrue(new EmptySet().incl(1).union(new EmptySet).contains(1))
    Assert.assertTrue(new EmptySet().incl(1).union(new EmptySet().incl(2)).contains(1))
    Assert.assertTrue(new EmptySet().incl(1).union(new EmptySet().incl(2)).contains(2))
  }

  @Test def `intersection`: Unit = {
    Assert.assertFalse(new EmptySet().incl(1).intersection(new EmptySet).contains(1))
    Assert.assertFalse(new EmptySet().incl(1).intersection(new EmptySet().incl(2)).contains(1))
    Assert.assertFalse(new EmptySet().incl(1).intersection(new EmptySet().incl(2)).contains(2))
    Assert.assertTrue(new EmptySet().incl(1).intersection(new EmptySet().incl(1)).contains(1))
    Assert.assertEquals(new EmptySet().incl(1).incl(2).incl(3),
        new EmptySet().incl(1).incl(2).incl(3).incl(4).incl(5)
          intersection new EmptySet().incl(10).incl(9).incl(8).incl(3).incl(2).incl(1))
  }
}
