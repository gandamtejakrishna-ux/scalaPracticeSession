import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util._

object q41FutureSequencing {

  def main(args: Array[String]): Unit = {

    def task(name: String, delay: Int): Future[String] = Future {
      Thread.sleep(delay)
      s"$name done"
    }

    val startSeq = System.currentTimeMillis()

    val seqResult = task("Task 1", 1000).flatMap { r1 =>
      println(r1)
      task("Task 2", 800).flatMap { r2 =>
        println(r2)
        task("Task 3", 600).map { r3 =>
          println(r3)
          List(r1, r2, r3)
        }
      }
    }

    val seqOutput = Await.result(seqResult, 5.seconds)
    val seqTime = System.currentTimeMillis() - startSeq
    println(s"Sequential took: $seqTime ms")

    val startPar = System.currentTimeMillis()

    val futures = List(
      task("\nTask A", 1000),
      task("Task B", 800),
      task("Task C", 600)
    )

    val parResult = Future.sequence(futures)
    val parOutput = Await.result(parResult, 5.seconds)

    parOutput.foreach(println)
    val parTime = System.currentTimeMillis() - startPar
    println(s"Parallel took: $parTime ms")
  }
}
