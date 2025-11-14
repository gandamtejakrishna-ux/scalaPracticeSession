object q22ShapeAnalyzer {
  final case class Circle(r: Double)
  final case class Rectangle(w: Double, h: Double)

  def area(shape: Any): Double = shape match {
    case Circle(r)       => math.Pi * r * r
    case Rectangle(w, h) => w * h
    case _               => -1.0
  }

  def main(args: Array[String]): Unit = {
    println(area(Circle(3)))
    println(area(Rectangle(4, 5)))
    println(area("not a shape"))
  }
}
