import java.time.LocalDate;
import java.time.Period;

class Person(
              val firstname: String,
              val lastname: String,
              val dayOfBirth: LocalDate
            ) {
  override def toString(): String = {
    firstname + " " + lastname
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val persons = List(
      new Person("Kerstin", "Herz", LocalDate.of(1995, 5, 31)),
      new Person("Matthias", "Zimmermann", LocalDate.of(1950, 1, 23)),
      new Person("Jana", "Schultheiss", LocalDate.of(1973, 10, 10)),
      new Person("Jennifer", "Fischer", LocalDate.of(1944, 12, 4)),
      new Person("Andreas", "Kaufmann", LocalDate.of(1964, 4, 3))
    );

    // TODO
    var nachnamen_liste:List[String] = persons.map(p=>p.lastname)
    var geburtsdatum:List[Person] = persons.filter(p=>p.dayOfBirth.getMonthValue==10)
    var ages:List[Int] = persons.map(p=>Period.between(p.dayOfBirth, LocalDate.now()).getYears)
    var durchschnitt_alter:Double = ages.sum.toDouble/ages.size
    printf(s"List of the lastnames: %s\n", nachnamen_liste)
    printf(s"List of dates of birth: %s\n", geburtsdatum)
    printf(s"List of ages: %s\n", ages)
    printf(f"Average age: $durchschnitt_alter%2.2f\n")
  }
}