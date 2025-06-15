package Blatt_7

object Main {
  def charCount(list: List[String]): Int = {
    list match {
      case Nil => 0
      case head :: tail => head.length + charCount(tail)
    }
  }

  def length[A](list: List[A]): Int = {
    list match {
      case Nil => 0
      case _ :: tail => 1 + length(tail)
    }
  }

  def reverse[A](list: List[A]): List[A] = {
    def reverseAcc(remaining: List[A], acc: List[A]): List[A] = {
      remaining match {
        case Nil => acc
        case head :: tail => reverseAcc(tail, head :: acc)
      }
    }
    reverseAcc(list, Nil)
  }

  def concat[A](list1: List[A], list2: List[A]): List[A] = {
    list1 match {
      case Nil => list2
      case head :: tail => head :: concat(tail, list2)
    }
  }

  def enumerate[A](list: List[A]): List[(Int, A)] = {
    def enumerateAcc(remaining: List[A], index: Int, acc: List[(Int, A)]): List[(Int, A)] = {
      remaining match {
        case Nil => reverse(acc)
        case head :: tail => enumerateAcc(tail, index + 1, (index, head) :: acc)
      }
    }
    enumerateAcc(list, 0, Nil)
  }

  def main(args: Array[String]): Unit = {
    val l0: List[Int] = List()
    val l1: List[Int] = List(1, 2, 3, 4, 5, 6)
    val l2: List[Int] = List(7, 8, 9, 10, 11)

    println(reverse(l0))
    println(reverse(l1))
    println(reverse(l2))
    println(length(l0))
    println(length(l1))
    println(length(l2))
    println(concat(l1, l2))
    println(enumerate(l2))
    println(enumerate(l0))
    println(charCount(List("Lorem", "ipsum", "dolor", "sit", "amet")))
  }
}