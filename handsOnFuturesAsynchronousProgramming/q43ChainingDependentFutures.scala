import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util._

object q43ChainingDependentFutures {

  def main(args: Array[String]): Unit = {

    def getUser(id: Int): Future[String] = Future {
      println(s"Fetching user with ID: $id")
      Thread.sleep(500)
      s"User$id"
    }

    def getOrders(user: String): Future[List[String]] = Future {
      println(s"Fetching orders for $user")
      Thread.sleep(700)
      List(s"$user-order1", s"$user-order2")
    }

    def getOrderTotal(order: String): Future[Double] = Future {
      println(s"Calculating total for $order")
      Thread.sleep(400)
      scala.util.Random.between(10.0, 100.0)
    }

    val result = for {
      user <- getUser(42)
      orders <- getOrders(user)
      totals <- Future.sequence(orders.map(getOrderTotal))
    } yield {
      val totalAmount = totals.sum
      println(f"Total order amount for $user = ₹$totalAmount%.2f")
      totalAmount
    }

    val finalAmount = Await.result(result, 5.seconds)
    println(s"Final computed total: ₹$finalAmount%.2f")
  }
}
