import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._
import scala.concurrent.duration._

object q45CoordinatedRetry {

  def main(args: Array[String]): Unit = {

    def fetchDataFromServer(server: String): Future[String] = Future {
      val success = scala.util.Random.nextBoolean()
      if (success) s" Data fetched successfully from $server"
      else throw new RuntimeException(s" Failed to fetch from $server")
    }

    def fetchWithRetry(server: String, maxRetries: Int): Future[String] = {
      fetchDataFromServer(server).recoverWith {
        case ex if maxRetries > 0 =>
          println(s"Retrying... Remaining attempts: $maxRetries")
          fetchWithRetry(server, maxRetries - 1)
      }
    }

    fetchWithRetry("Server-1", 3).onComplete {
      case Success(data)  => println(data)
      case Failure(error) => println(s"All retries failed: ${error.getMessage}")
    }

    Thread.sleep(3000)
  }
}
