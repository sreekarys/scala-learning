package string

import scala.collection.mutable

class StringOperations(private val s: String) {

  private val splits: List[String] = s.split(" ").toList
  def longestWord: String = splits.map(x => (x.length, x)).max._2
  def mostCommonWord: String = splits.groupBy(x => x).map(kv => (kv._1, kv._2.length)).maxBy(_._2)._1
  def mostCommonLetter: Char = splits.flatten.groupBy(x => x).map(kv => (kv._1, kv._2.length)).maxBy(_._2)._1
//  def mapCharToWords: Map[Char, List[String]] = splits.map(_.groupBy(x => x)).foldLeft((x: Map[Char, List[String]], y: Map[Char, String]) => {
//    y.foreach(kv => x ++ (kv._1 -> kv._2 :: x.getOrElse(kv._1, List())))
//  })
  def wordsToLetters: List[Char] = splits.flatten
}
