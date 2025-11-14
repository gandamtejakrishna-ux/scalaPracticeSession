object q15TheArrowPuzzle {
  def main(args: Array[String]): Unit = {
    val animals = Map(
      "dog" -> "bark",
      "cat" -> "meow",
      "cow" -> "moo"
    )
    val updatingAnimals = animals + ("lion" -> "roar")
    val retreivingCowSound = updatingAnimals("cow")
    val fetchingAnimalsSafely =
      updatingAnimals.getOrElse("tiger", "tiger went missing")

    println(s"Updated Animals Map: $updatingAnimals")
    println(s"Added Cow Sound: $retreivingCowSound")
    println(s"Fetching missing animal sound safely: $fetchingAnimalsSafely")

  }
}
