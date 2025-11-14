//> using dep "mysql:mysql-connector-java:8.0.33"

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}
import scala.io.StdIn

object DatabaseConnection {

  val url =
    "*********3306/teja_krishna"
  val user =
    "*****"
  val password = "*****"

  try Class.forName("com.mysql.cj.jdbc.Driver")
  catch {
    case e: Exception => println("MySQL Driver load error: " + e.getMessage)
  }

  def getConnection(): Connection =
    DriverManager.getConnection(url, user, password)

  /** Create tables if missing * */
  def initializeTables(): Unit = {
    val conn = getConnection()
    val stmt = conn.createStatement()

    stmt.execute(
      """
        CREATE TABLE IF NOT EXISTS Vehicles (
          vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
          license_plate VARCHAR(20),
          vehicle_type VARCHAR(20),
          owner_name VARCHAR(100)
        )
      """
    )

    stmt.execute(
      """
        CREATE TABLE IF NOT EXISTS TrafficSignals (
          signal_id INT AUTO_INCREMENT PRIMARY KEY,
          location VARCHAR(100),
          status VARCHAR(10)
        )
      """
    )

    stmt.execute(
      """
        CREATE TABLE IF NOT EXISTS Violations (
          violation_id INT AUTO_INCREMENT PRIMARY KEY,
          vehicle_id INT,
          signal_id INT,
          violation_type VARCHAR(50),
          timestamp DATETIME,
          FOREIGN KEY (vehicle_id) REFERENCES Vehicles(vehicle_id),
          FOREIGN KEY (signal_id) REFERENCES TrafficSignals(signal_id)
        )
      """
    )

    stmt.close()
    conn.close()
    println("✔ Tables verified/created.")
  }
}

object TrafficDAO {

  def addVehicle(): Unit = {
    val plate = StdIn.readLine("License Plate: ")
    val vtype = StdIn.readLine("Vehicle Type: ")
    val owner = StdIn.readLine("Owner Name: ")

    val sql =
      "INSERT INTO Vehicles (license_plate, vehicle_type, owner_name) VALUES (?, ?, ?)"

    val conn = DatabaseConnection.getConnection()
    val ps = conn.prepareStatement(sql)

    ps.setString(1, plate)
    ps.setString(2, vtype)
    ps.setString(3, owner)

    ps.executeUpdate()
    println("✔ Vehicle added!")

    ps.close()
    conn.close()
  }

  def addTrafficSignal(): Unit = {
    val loc = StdIn.readLine("Signal Location: ")
    val status = StdIn.readLine("Status (green/yellow/red): ")

    val sql = "INSERT INTO TrafficSignals (location, status) VALUES (?, ?)"

    val conn = DatabaseConnection.getConnection()
    val ps = conn.prepareStatement(sql)

    ps.setString(1, loc)
    ps.setString(2, status)

    ps.executeUpdate()
    println("✔ Traffic signal added!")

    ps.close()
    conn.close()
  }

  def recordViolation(): Unit = {
    val vidStr = StdIn.readLine("Vehicle ID (number): ")
    val sidStr = StdIn.readLine("Signal ID (number): ")
    val vtype = StdIn.readLine("Violation Type: ")

    // Validate integer input
    if (!vidStr.matches("\\d+") || !sidStr.matches("\\d+")) {
      println("❌ Vehicle ID and Signal ID must be valid numbers!")
      return
    }

    val vid = vidStr.toInt
    val sid = sidStr.toInt

    // Check if vehicle exists
    val conn = DatabaseConnection.getConnection()
    val check = conn.prepareStatement(
      "SELECT vehicle_id FROM Vehicles WHERE vehicle_id = ?"
    )
    check.setInt(1, vid)
    val rs = check.executeQuery()

    if (!rs.next()) {
      println(s"❌ Vehicle ID $vid does NOT exist. Add the vehicle first.")
      rs.close()
      check.close()
      conn.close()
      return
    }

    // Now insert violation
    val sql =
      "INSERT INTO Violations (vehicle_id, signal_id, violation_type, timestamp) VALUES (?, ?, ?, NOW())"

    val ps = conn.prepareStatement(sql)
    ps.setInt(1, vid)
    ps.setInt(2, sid)
    ps.setString(3, vtype)

    ps.executeUpdate()
    println("✔ Violation recorded!")

    ps.close()
    check.close()
    conn.close()
  }

  def updateSignalStatus(): Unit = {
    val sid = StdIn.readLine("Signal ID: ").toInt
    val status = StdIn.readLine("New Status: ")

    val sql = "UPDATE TrafficSignals SET status = ? WHERE signal_id = ?"

    val conn = DatabaseConnection.getConnection()
    val ps = conn.prepareStatement(sql)

    ps.setString(1, status)
    ps.setInt(2, sid)

    ps.executeUpdate()
    println("✔ Signal status updated!")

    ps.close()
    conn.close()
  }

  def viewVehicles(): Unit = {
    val sql = "SELECT * FROM Vehicles"

    val conn = DatabaseConnection.getConnection()
    val rs = conn.prepareStatement(sql).executeQuery()

    println("\n--- Vehicles ---")
    while rs.next() do println(
      s"${rs.getInt("vehicle_id")} | ${rs.getString("license_plate")} | ${rs
          .getString("vehicle_type")} | ${rs.getString("owner_name")}"
    )

    rs.close()
    conn.close()
  }

  def viewSignals(): Unit = {
    val sql = "SELECT * FROM TrafficSignals"

    val conn = DatabaseConnection.getConnection()
    val rs = conn.prepareStatement(sql).executeQuery()

    println("\n--- Traffic Signals ---")
    while rs.next() do println(
      s"${rs.getInt("signal_id")} | ${rs.getString("location")} | ${rs.getString("status")}"
    )

    rs.close()
    conn.close()
  }

  def viewViolations(): Unit = {
    val sql = "SELECT * FROM Violations"

    val conn = DatabaseConnection.getConnection()
    val rs = conn.prepareStatement(sql).executeQuery()

    println("\n--- Violations ---")
    while rs.next() do println(
      s"${rs.getInt("violation_id")} | Vehicle:${rs
          .getInt("vehicle_id")} | Signal:${rs.getInt("signal_id")} | ${rs
          .getString("violation_type")} | ${rs.getTimestamp("timestamp")}"
    )

    rs.close()
    conn.close()
  }
}

object TrafficMain {

  def main(args: Array[String]): Unit = {

    DatabaseConnection.initializeTables() // IMPORTANT: create tables first

    var loop = true

    while (loop) {
      println(
        """
--- Smart Traffic System ---
1. Add Vehicle
2. Add Traffic Signal
3. Record Violation
4. Update Signal Status
5. View Vehicles
6. View Traffic Signals
7. View Violations
8. Exit
"""
      )

      val choice = StdIn.readLine("Enter choice: ")

      choice match {
        case "1" => TrafficDAO.addVehicle()
        case "2" => TrafficDAO.addTrafficSignal()
        case "3" => TrafficDAO.recordViolation()
        case "4" => TrafficDAO.updateSignalStatus()
        case "5" => TrafficDAO.viewVehicles()
        case "6" => TrafficDAO.viewSignals()
        case "7" => TrafficDAO.viewViolations()
        case "8" => loop = false
        case _   => println("Invalid choice!")
      }
    }

    println("Exiting...")
  }
}
