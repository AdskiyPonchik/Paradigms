package Blatt_6;

object Currying {
  def concatThree(a: String)(b:String)(c:String): String = {
    a+b+c;
  }
  def prefix(): String => String =
    concatThree(">>>")(_)("")

  def postfix(): String => String =
    concatThree("")(_)("<<<")

  def preAndPostfix(): String => String =
    concatThree(">>>")(_)("<<<")

  def main(args: Array[String]): Unit = {
    val txt = "Scala"
    println("Prefix: " + prefix()(txt))
    println("Postfix: " + postfix()(txt))
    println("Pre & Postfix: " + preAndPostfix()(txt))
  }
}