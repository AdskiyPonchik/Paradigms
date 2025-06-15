package Blatt_8

object Zahlenfolgen {
  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else if (n <= 3) true
    else if (n % 2 == 0 || n % 3 == 0) false
    else {
      def checkDivisor(i: Int): Boolean = {
        if (i * i > n) true
        else if (n % i == 0 || n % (i + 2) == 0) false
        else checkDivisor(i + 6)
      }

      checkDivisor(5)
    }
  }

  def primeStream(): Stream[Int] = { //everywhere warning about Stream. Should use LazyList instead?
    Stream.from(2).filter(isPrime)
  }

  def distanceNumberStream(): Stream[Int] = {
    def f(x: Int): Int = if (x == 0) 1 else 2 * x - 1

    Stream.from(1).map { n =>
      math.abs(f(n + 1) - f(n))
    }
  }

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b == 0) {
      a.abs
    } else {
      gcd(b, a % b)
    }
  }

  def kgv(numbers: List[Int]): BigInt = {
    numbers.map(BigInt(_)).reduce((a, b) => (a * b) / gcd(a, b))
  }

  def mangoldtExpStream(): Stream[Int] = {
    Stream.from(1).map { n =>
      val kgv_n = kgv((1 to n).toList)
      val exp = kgv_n.toString.length - 1
      exp.toInt
    }
  }

  def main(args: Array[String]): Unit = {
    println("First 10 prime numbers:")
    println(primeStream().take(10).toList)

    println("\nFirst 10 distances:")
    println(distanceNumberStream().take(10).toList)

    println("\nFirst 10 Mangold's exponents:")
    println(mangoldtExpStream().take(10).toList)
  }
}