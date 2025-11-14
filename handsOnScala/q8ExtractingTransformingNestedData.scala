object q8ExtractNestedData {
  def main(args: Array[String]): Unit = {

    val departments = List(
      ("IT", List("Ravi", "Meena")),
      ("HR", List("Anita")),
      ("Finance", List("Vijay", "Kiran"))
    )

    val result = for {
      (dept, employees) <- departments
      emp <- employees
    } yield s"$dept: $emp"

    val expandedVersion = departments.flatMap { case (dept, employees) =>
      employees.map(emp => s"$dept: $emp")
    }

    println("Formatted Department-Employee List:")
    result.foreach(println)

    println("\nDepartment-Employee List Using FlatMap + Map:")
    expandedVersion.foreach(println)
  }
}
