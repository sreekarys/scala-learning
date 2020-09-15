package string

class StringOperations(private val s: String) {

  private val splits: List[String] = s.split(" ").toList
  def longestWord: String = splits.map(x => (x.length, x)).max._2
  def mostCommonWord: String = splits.groupBy(x => x).map(kv => (kv._1, kv._2.length)).maxBy(_._2)._1
  def mostCommonLetter: Char = splits.flatten.groupBy(x => x).map(kv => (kv._1, kv._2.length)).maxBy(_._2)._1
  def wordsToLetters: List[Char] = splits.flatten
}
