package net.enkime.util
import com.weiglewilczek.slf4s.Logging

trait Test extends App with Logging {
  override def main(args: Array[String]) = {
    try {
      super.main(args)
    } catch {
      case e: RuntimeException => log("RuntimeException", e)
      case e: Exception => log("Exception", e)
      case e: Error => log("Error", e)
    }
  }
  def log(s: String, t: Throwable) {
    println("catch " + s + " " + t)
    t.printStackTrace
    logger.error(t toString, t)
  }
}