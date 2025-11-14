//Implicit usage in operator overloading
case class Meter(value: Double)
case class Centimeter(value: Double)

implicit def cmToMeter(cm: Centimeter): Meter = Meter(cm.value / 100)

@main def run(): Unit = {
  val m = Meter(2)
  val c = Centimeter(100)
  val total = m.value + c.value / 100
  println(total)
  println(s"m: $m, c: $c")

  implicit class MeterOps(m: Meter) {
    def +(cm: Centimeter): Meter = Meter(m.value + cm.value / 100)
  }

  val sum = m + c
  println(sum)
}
