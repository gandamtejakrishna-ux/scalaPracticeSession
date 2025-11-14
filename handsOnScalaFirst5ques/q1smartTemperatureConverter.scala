package handsOnScalaFirst5ques
class q1smartTemperatureConverter {
  // Q1. Smart Temperature Converter (Conditionals & Basic Functions)
  def convertTemp(value: Double, scale: String): Double = {
    if (scale.equalsIgnoreCase("C")) return (value * 9 / 5) + 32
    else if (scale.equalsIgnoreCase("F")) return ((value - 32) * 5 / 9)
    else return value
  }
}

// object main {
//   def main(args: Array[String]): Unit = {
//     val obj = q1smartTemperatureConverter()
//     println(
//       s"Converted 40.0 C to ${obj.convertTemp(40.0, "C")} F"
//     )
//     println(
//       s"Converted 104.0 F to ${obj.convertTemp(104.0, "F")} C"
//     )
//     println(obj.convertTemp(100.0, "V"))
//   }
// }
