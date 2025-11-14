import scala.util.Try

object q40CleanDataPipeline {

  def main(args: Array[String]): Unit = {

    val data = List("10", "20", "x", "30")

    // Step 1 → safely try converting each to Int
    // Step 2 → flatMap removes failed conversions automatically (None)
    // Step 3 → square the valid ones
    val result = data.flatMap(str => Try(str.toInt).toOption).map(x => x * x)

    println(s"Original data: $data")
    println(s"Clean transformed data: $result")
  }
}
