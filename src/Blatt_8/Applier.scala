package Blatt_8

object Applier {
  def applyFuncs(fList: List[Double => Double], arg: Double): Double = {
    fList.foldLeft(arg)((acc, f) =>f(acc))
  }

  def applyFuncsReverse(fList: List[Double => Double], arg: Double): Double = {
    fList.foldRight(arg)((f, acc) => f(acc))
  }

  def applyFuncsArgs(fList: List[Double => Double], args: List[Double]): List[Double] = {
    fList.zip(args).map { case (f, arg) => f(arg) }
  }

  def main(Args: Array[String]) = {
    val f = (x: Double) => 2 * x
    val fList = List( f, f )
    println(applyFuncs(fList, 2))        // 8.0 (2 * 2 * 2)
    println(applyFuncsReverse(fList, 2)) // 8.0 (2 * 2 * 2)
    println(applyFuncsArgs(fList, List(1,2))) // List(2.0, 4.0)
  }
}
