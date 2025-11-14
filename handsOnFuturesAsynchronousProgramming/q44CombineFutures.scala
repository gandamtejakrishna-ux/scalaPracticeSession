import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object q44CombineFutures {

  def main(args: Array[String]): Unit = {

    val f1 = Future { Thread.sleep(1000); 10 }
    val f2 = Future { Thread.sleep(800); 20 }
    val f3 = Future { Thread.sleep(500); 30 }

    val combined = for {
      a <- f1
      b <- f2
      c <- f3
    } yield {
      val sum = a + b + c
      val avg = sum / 3
      s"Sum = $sum, Average = $avg"
    }

    combined.foreach(println)

    Thread.sleep(2000)
  }
}
