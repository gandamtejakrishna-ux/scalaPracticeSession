object q30LazyPipelineBuilder {

  def main(args: Array[String]): Unit = {

    def pipeline[T](block: => T): (() => T) = () => block

    def map[A, B](source: () => A)(f: A => B): () => B = () => f(source())

    val step1 = pipeline {
      println("Step 1: Preparing data")
      List(1, 2, 3)
    }

    val step2 = map(step1) { xs =>
      println("Step 2: Transforming data")
      xs.map(_ * 2)
    }

    println("Before accessing pipeline...")
    println("Result: " + step2())
  }
}
