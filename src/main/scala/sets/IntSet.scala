package sets

trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(another: IntSet): IntSet
  def intersection(another: IntSet): IntSet
  def excl(x: Int): IntSet
}
