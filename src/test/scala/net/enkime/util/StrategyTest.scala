package net.enkime.util

object StrategyTest extends Test {
	try {
		val my = new HashStrategy
		val p = (s: String) => println(s)
		p("ref to function")

		my += ("p", p)
		val l = my("p")
		l.asInstanceOf[String => Unit] ("ref to function from hash")

		my -= ("p")
		val k = my("p")
		k.asInstanceOf[String => Unit] ("ref to function from hash")
	} catch {
		case e: Exception => println (e toString (), e)
	}

}