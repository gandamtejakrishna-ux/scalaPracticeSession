package main

import library.items._
import library.users._
import library.operations.Operations._

object LibraryMain extends App {

  val alice = new Member("Alice")
  val book1: Book = Book("Scala Programming")

  borrow(book1)(alice) // explicit

  val dvd1 = DVD("Inception")
  borrow(dvd1) // uses default implicit member

  borrow("Harry Potter") // implicit conversion: String → Book

  println("\n--- Item Descriptions ---")
  val items: List[ItemType] = List(
    Book("FP in Scala"),
    Magazine("Science Today"),
    DVD("Matrix")
  )

  items.foreach(itemDescription)
}

//output
// Alice borrowed 'Scala Programming'
// Default Member borrowed 'Inception'
// Default Member borrowed 'Harry Potter'

// --- Item Descriptions ---
// Book: FP in Scala
// Magazine: Science Today
// DVD: Matrix