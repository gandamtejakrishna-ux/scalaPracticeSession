import java.sql.{Connection, DriverManager}

object TestSqlConnection {
  def main(args: Array[String]): Unit = {
    Class.forName("com.mysql.cj.jdbc.Driver")
     val url =
    "*********3306/teja_krishna"
  val user =
    "*****"
  val password = "*****"


    val conn = DriverManager.getConnection(url, user, pass)
    println("Connected successfully!")
    conn.close()
  }
}
