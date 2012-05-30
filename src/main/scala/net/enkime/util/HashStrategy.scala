package net.enkime.util
import scala.collection.mutable.HashTable
import scala.collection.mutable.HashMap

/**
 * klasa strategii
 */
class HashStrategy {
	val map = new HashMap[String, Any]()
	def +=(key: String, value: Any) = map += ((key, value))
	def -=(key: String) = map -= key
	def apply(key: String) = map.get(key).get
}
