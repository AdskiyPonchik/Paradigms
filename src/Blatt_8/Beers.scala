package Blatt_8
object Main {
  def flatten(coolList: List[Any]): List[Any] = {
    coolList.flatMap {
      case innerList: List[_] => flatten(innerList.asInstanceOf[List[Any]])
      case element => List(element)
    }
  }
  def flatten2(coolList: List[Any]): List[Any] = {
    //TODO: This function should flatten Lists of depth 2

    //HINT: You can also first implement flatten and then call it here, so you
    //      won't have to implement it twice
    //lol thanks
    coolList.flatMap {
      case innerList: List[_] => flatten(innerList.asInstanceOf[List[Any]])
      case element => List(element)
    }
  }

  def main(Args: Array[String]): Unit = {
    val lager = List("Pale Lager", "Dark Lager")
    val pale_ale = List("India Pale Ale", "Amercian Pale Ale",
      "West Coast Pale Ale", "Island Pale Ale")
    val ales = List("Brown ale", "Scotch ale", pale_ale)
    val beers = List(ales, lager, "Pilsner")

    println(beers)
    println(flatten(beers))
  }
}