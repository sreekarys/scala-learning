package double

class CompareDoubles(private val precision: Int = 3) {
  def compare(v1: Double, v2: Double): Boolean = math.abs(v1 - v2) < math.pow(10, -1*precision)
}
