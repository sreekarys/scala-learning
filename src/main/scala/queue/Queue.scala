package queue

class Queue(private val capacity: Int) extends IQueue {
  private val arr: Array[String] = new Array[String](capacity)
  private var front: Int = -1
  private var rear: Int = 0
  def enQueue(s: String): Boolean = {
    if (isFull) false
    else if (isEmpty) {
      front = 0; rear = 0
      arr(rear) = s
      true
    } else {
      if(rear == capacity - 1) rear = 0
      else rear = rear + 1
      arr(rear) = s
      true
    }
  }

  def deQueue: String = {
    if(isEmpty)
      throw new Error("Queue.deQueue done on an empty queue!!!")

    val result = front
    if (front == rear){
      front = -1; rear = 0
    } else {
      if(front == capacity - 1) front = 0
      else front = front + 1
    }
    arr(result)
  }

  def isEmpty: Boolean = front == -1
  def isFull: Boolean = (rear + 1) == front || (front == 0 && rear == capacity - 1)
}
