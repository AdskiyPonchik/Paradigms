package Blatt_6;

object BubbleSort {

  def bubblePass(lst: List[Int]): (List[Int], Boolean) = lst match {
    case a :: b :: tail =>
      if (a > b) {
        val (rest, swapped) = bubblePass(a :: tail)
        (b :: rest, true)
      } else {
        val (rest, swapped) = bubblePass(b :: tail)
        (a :: rest, swapped)
      }
    case _ => (lst, false)
  }

  def bubbleSort(lst: List[Int]): List[Int] = {
    def sortHelper(lst: List[Int]): List[Int] = {
      val (newList, swapped) = bubblePass(lst)
      if (swapped) sortHelper(newList)
      else newList
    }
    sortHelper(lst)
  }
/*
  def bubbleSort(arr: Array[Int]): Array[Int] = {
    for (n <- arr.length - 1 to 0 by -1) {
      for (i <- 0 to n - 1 by 1) {
        if (arr(i) > arr(i + 1)) {
          swap(arr, i, i + 1)
        }
      }
    }
    arr
  }*/


  def main(args: Array[String]): Unit = {
    printf("Something");
  }
}

