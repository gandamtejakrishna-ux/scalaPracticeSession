import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util._

object q42SafeComposition {

  def main(args: Array[String]): Unit = {

    def riskyOperation(): Future[Int] = Future {
      val n = scala.util.Random.nextInt(3)
      if (n == 0) throw new RuntimeException("Failed!")
      n
    }

    println("=== Using recover (fallback value) ===")
    val f1 = riskyOperation().recover { case _: Throwable =>
      println("Operation failed, using fallback value -1")
      -1
    }

    val res1 = Await.result(f1, 2.seconds)
    println(s"Result: $res1")

    println("\n=== Using recoverWith (retry once) ===")
    val f2 = riskyOperation().recoverWith { case _: Throwable =>
      println("First attempt failed, retrying...")
      riskyOperation()
    }

    val res2 = Await.result(f2, 2.seconds)
    println(s"Result after retry: $res2")
  }
}
