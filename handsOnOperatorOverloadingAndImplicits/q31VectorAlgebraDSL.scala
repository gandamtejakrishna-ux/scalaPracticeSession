object q31VectorAlgebraDSL {

  case class Vec2D(x: Int, y: Int) {
    def +(that: Vec2D): Vec2D = Vec2D(x + that.x, y + that.y)
    def -(that: Vec2D): Vec2D = Vec2D(x - that.x, y - that.y)
    def *(scalar: Int): Vec2D = Vec2D(x * scalar, y * scalar)
    override def toString: String = s"Vec2D($x, $y)"
  }

  implicit class IntToVecOps(n: Int) {
    def *(v: Vec2D): Vec2D = v * n
  }

  def main(args: Array[String]): Unit = {
    val v1 = Vec2D(2, 3)
    val v2 = Vec2D(4, 1)

    println(v1 + v2)
    println(v1 - v2)
    println(v1 * 3)
    println(3 * v1)
  }
}
