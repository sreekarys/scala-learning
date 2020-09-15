package timer

class Timer[T, U] {
  def measureTime(f: T => U)(t: T): U = {
    val start: Long = System.currentTimeMillis()
    val result = f(t)
    println(System.currentTimeMillis() - start)
    result
  }
}
