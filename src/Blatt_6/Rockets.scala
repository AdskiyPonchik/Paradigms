package Blatt_6

object Rockets {

  // TODO: case class ???
  case class Rocket(name: String, stages: Int, fuel: String)

  def printIf2Stages(rocket: Rocket): Unit = rocket match {
    //TODO: Filter based on if a rocket has 2 stages
    case Rocket(name, 2, _) => println(name)
    case _ => ()
  }

  def printIfLH2LOX(rocket: Rocket): Unit = rocket match {
    //TODO: Filter based on if a rocket uses LH2/LOX as fuel
    case Rocket(name, _, "LH2/LOX") => println(name)
    case _ => ()
  }

  def printIfLOX(rocket: Rocket): Unit = rocket match {
    //TODO: Filter based on if a rocket uses LOX in its fuel
    case Rocket(name, _, fuel) if fuel.contains("LOX") => println(name)
    case _ => ()
  }
  def main(args: Array[String]): Unit = {
    val rockets = List(
      Rocket("Falcon 9", 2, "LOX"),
      Rocket("Ariane 5", 2, "LH2/LOX"),
      Rocket("USSR", 2, "something"),
      Rocket("Proton", 3, "something"),
      Rocket("Zvezda 1", 2, "LH2/LOX")
    )

    println("All rockets with 2 stages:")
    rockets.foreach(printIf2Stages)

    println("All rockets with LH2/LOX:")
    rockets.foreach(printIfLH2LOX)

    println("All rockets that use LOX as oxidizer:")
    rockets.foreach(printIfLOX)
  }
}
