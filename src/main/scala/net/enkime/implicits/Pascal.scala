package net.enkime.implicits

trait Pascal {
	implicit def boolean(self: Boolean) = new {
		def implies(other: Boolean) = !self || other
		def and(other: Boolean) = self && other
		def or(other: Boolean) = self || other
		def unary_not = !self
		def xor(other: Boolean) = {}
		def unary_# = !self
		def ->(other: Boolean) = implies (other)
	}
}