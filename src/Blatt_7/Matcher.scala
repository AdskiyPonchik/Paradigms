package Blatt_7;

object Matcher {
  abstract class Message {
    val content: String
  }

  case class Error(time: Long, content: String) extends Message {
    override def toString() = {
      s"$content happened at $time"
    }
  }

  case class Info(content: String) extends Message {
    override def toString() = {
      s"$content"
    }
  }

  case class Warn(severity: String, content: String) extends Message {
    override def toString() = {
      s"$severity: $content"
    }
  }

  case class Debug(events: List[String], content: String) extends Message {
    override def toString() = {
      s"$content with $events"
    }
  }


  def msg_format(msg: Any): String = {
    msg match {
      case Info(content) => s"Info: $content"
      case Error(time, content) => s"Error: $content happened at $time"
      case Warn(severity, content) => s"Warn[$severity]: $content"
      case Debug(events, content) => s"Debug: $content with ${events.mkString("[", ", ", "]")}"
      case _ => "Unknown message type"
    }
  }

  def debug_filter(msg: Debug): String = {
    msg.events match {
      case Nil => msg.content
      case List("Initialization") => msg.content
      case events if events.length <= 1 => events.last
      case _ => msg.content
    }
  }

  def main(Args: Array[String]) = {
    val error: Error = Error(System.currentTimeMillis(), "Foo")
    val info: Info = Info("More")
    val warn: Warn = Warn("Minor", "Bar")
    val debug: Debug = Debug(List("Initialization", "Bar", "FooBar"), "Some Events happened")
    val debug_short: Debug = Debug(List("Foo"), "Some Event happened")

    val mgs = List(Error(System.currentTimeMillis(), "Foo"), Info("More"), Warn("Minor", "Bar"), Debug(List("Initialization", "Bar", "FooBar"), "Some Events happened"), Debug(List("Foo"), "Some Event happened"))

    mgs.foreach(msg => println(msg_format(msg)))

    println(debug_filter(debug))
    println(debug_filter(debug_short))
  }
}