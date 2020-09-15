package sets

class EmptySet extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
  def union(another: IntSet): IntSet = another
  def intersection(another: IntSet): IntSet = new EmptySet
  def excl(x: Int): IntSet = this
}
