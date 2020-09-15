package queue

trait IQueue {
  def enQueue(s: String): Boolean

  def deQueue: String

  def isEmpty: Boolean

  def isFull: Boolean
}
