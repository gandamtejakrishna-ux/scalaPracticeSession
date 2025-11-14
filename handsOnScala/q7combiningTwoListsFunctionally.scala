object q7combiningTwoListsFunctionally {
  def main(args: Array[String]): Unit = {
    val students = List("Asha", "Bala", "Chitra")
    val subjects = List("Math", "Physics")
    val results = for {
      student <- students
      subject <- subjects
      if (student == "Asha" && subject == "Math") || student == "Chitra"
    } yield (student, subject)
    println(results)
  }
}
