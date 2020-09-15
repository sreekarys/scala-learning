package sets

import org.junit.{Assert, Test}

class SetsTestSuite {

  @Test def `contains and incl`: Unit = {
    Assert.assertFalse(new EmptySet().contains(1))
    Assert.assertTrue(new EmptySet().incl(1).contains(1))
    Assert.assertFalse(new EmptySet().incl(1).contains(2))
    Assert.assertTrue(new EmptySet().incl(1).incl(2).contains(2))
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
    val result = (new EmptySet().incl(1).incl(2).incl(3).incl(4).incl(5))
      .intersection(new EmptySet().incl(10).incl(9).incl(8).incl(3).incl(2).incl(1))
    Assert.assertTrue(result.contains(1))
    Assert.assertTrue(result.contains(2))
    Assert.assertTrue(result.contains(3))
    Assert.assertFalse(result.contains(4))
    Assert.assertFalse(result.contains(10))
  }

  @Test def `exclude cases`: Unit = {
    Assert.assertTrue(new EmptySet().excl(1).isInstanceOf[EmptySet])
    Assert.assertTrue(new EmptySet().incl(1).excl(1).isInstanceOf[EmptySet])
    Assert.assertTrue(new EmptySet().incl(1).incl(2).excl(1).contains(2))
    Assert.assertFalse(new EmptySet().incl(1).incl(2).excl(1).contains(1))
    Assert.assertFalse(new EmptySet().incl(10).incl(9).incl(8).incl(3).incl(2).incl(1).excl(9).contains(9))
    Assert.assertTrue(new EmptySet().incl(10).incl(9).incl(8).incl(3).incl(2).incl(1).excl(9).contains(10))
    Assert.assertTrue(new EmptySet().incl(10).incl(9).incl(8).incl(3).incl(2).incl(1).excl(9).contains(1))
  }
}
