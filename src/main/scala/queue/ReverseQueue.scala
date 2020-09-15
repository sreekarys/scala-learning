package queue

class ReverseQueue(private val capacity: Int) extends Queue(capacity) {
  override def enQueue(s: String): Boolean = super.enQueue(s.reverse)
}
