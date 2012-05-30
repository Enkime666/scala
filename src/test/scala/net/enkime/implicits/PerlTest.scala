package net.enkime.implicits
import com.weiglewilczek.slf4s.Logging

object PerlTest extends Perl with App with Logging {

	val s = "11"
	val i :Int = 2 * s
	println (i)
	println (12 + s)
	println (12 + "25")
	i.+("1")
	
	var r: scala.runtime.RichInt =0
	r.+("")

}

