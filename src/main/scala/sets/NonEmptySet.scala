package sets

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this

  def union(another: IntSet): IntSet = left.union(right).union(another).incl(elem)

  def intersection(another: IntSet): IntSet = {
    val leftResult = left.intersection(another)
    val rightResult = right.intersection(another)
    if(another.contains(elem))
      new NonEmptySet(elem, leftResult, rightResult)
    else leftResult.union(rightResult)
  }

  def excl(x: Int): IntSet = {
    if(x == elem)
      left.union(right)
    else if (x < elem)
      new NonEmptySet(elem, left.excl(x), right)
    else new NonEmptySet(elem, left, right.excl(x))
  }
}