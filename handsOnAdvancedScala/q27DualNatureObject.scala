object q27DualNatureObject {

  object Email {
    def apply(username: String, domain: String): String = {
      s"$username@$domain"
    }

    def unapply(fullEmail: String): Option[(String, String)] = {
      val parts = fullEmail.split("@")
      if (parts.size == 2) Some((parts(0), parts(1))) else None
    }
  }

  def main(args: Array[String]): Unit = {
    val officeMail = Email("teja", "company.org")
    println(s"Created Email: $officeMail")

    officeMail match {
      case Email(user, domain) =>
        println(s"Extracted User: $user")
        println(s"Extracted Domain: $domain")
      case _ =>
        println("Invalid email format!")
    }

    val brokenMail = "invalidEmailFormat"
    brokenMail match {
      case Email(user, domain) => println(s"$user - $domain")
      case _                   => println("Invalid email caught safely.")
    }
  }
}
