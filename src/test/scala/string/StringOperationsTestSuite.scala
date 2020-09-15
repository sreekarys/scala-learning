package string

import org.junit.{Assert, Test}

class StringOperationsTestSuite {

  @Test def `longest word tests`: Unit = {
    Assert.assertEquals("here", new StringOperations("I am here").longestWord)
    Assert.assertEquals("am", new StringOperations("I am").longestWord)
    Assert.assertEquals("I", new StringOperations("I").longestWord)
    Assert.assertEquals("", new StringOperations("").longestWord)
  }

  @Test def `most common word tests`: Unit = {
    Assert.assertEquals("I", new StringOperations("I am here I").mostCommonWord)
    var result = new StringOperations("I am here").mostCommonWord
    Assert.assertTrue(result.equals("I") || result.equals("am") || result.equals("here"))
    result = new StringOperations("I am here am I").mostCommonWord
    Assert.assertTrue(result.equals("I") || result.equals("am"))
  }

  @Test def `most common letter tests`: Unit = {
    Assert.assertEquals('a', new StringOperations("a ba a").mostCommonLetter)
    Assert.assertEquals('a', new StringOperations("a").mostCommonLetter)
    val result = new StringOperations("a bcd ef").mostCommonLetter
    Assert.assertTrue(result >= 'a' && result <= 'f')
  }

  @Test def `words to chars`: Unit = {
    Assert.assertEquals(List('a','b','a','a'), new StringOperations("a ba a").wordsToLetters)
  }
}
