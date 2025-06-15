object Numbers {

  def relativePrimes(num: Int, current: Int = 1): Unit = {
    if (current < num) {
      if (gcd(num, current) == 1) println(current)
      relativePrimes(num, current + 1)
    }
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def main(args: Array[String]): Unit = {
    println(s"NOD for numbers: ${gcd(18, 30)}")
    println("Alle teilerfremd: ")
    relativePrimes(10)
  }
}
