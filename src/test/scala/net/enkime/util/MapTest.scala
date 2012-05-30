package net.enkime.util

import scala.collection.mutable.HashMap

object MapTest extends Test {
  val m = new HashMap[String,String]
  val k = "klucz"
  val v = "wartosc"
  val p= k->v
  m+=p
  println(p)
  println(p getClass)
  println (p->p)
  println (p->p getClass)
  
  
}