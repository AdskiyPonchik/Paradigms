package practice

object Scala extends App {
  val meaningOflife: Int = 42 //const int meaningOfLife = 42;
  //Int, Boolean, Char, Double, Float, String
  val aBoolean: Boolean = false
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOflife"
  println(anInterpolatedString)
}