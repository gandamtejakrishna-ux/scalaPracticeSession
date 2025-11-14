object q32ImplicitOrderingPerson {

  case class Person(name: String, age: Int)

  implicit class PersonOrdering(p1: Person) {
    def >(p2: Person): Boolean = p1.age > p2.age
    def <(p2: Person): Boolean = p1.age < p2.age
    def >=(p2: Person): Boolean = p1.age >= p2.age
    def <=(p2: Person): Boolean = p1.age <= p2.age
  }

  def main(args: Array[String]): Unit = {
    val p1 = Person("Ravi", 25)
    val p2 = Person("Meena", 30)

    println(p1 < p2)
    println(p1 >= p2)
    println(p2 > p1)
    println(p2 <= p1)

    if (p2 > p1)
      println(s"${p2.name} is older than ${p1.name}")
  }
}
