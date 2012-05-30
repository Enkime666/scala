package net.enkime.implicits

import net.enkime.exception.YourArgumentIsInvalidException

trait Perl {

	// metody automatycznej konwersji 
	implicit def to_b(self: String) = self != null && !self.isEmpty && self != "" && self != "0"
	implicit def to_i(self: String) = Integer.parseInt(self)
	implicit def to_b(self: Int) = self != 0
	implicit def to_b(self: Any) = self != null

	implicit def coalescing[T <: Perl](self: => T) = new Perl {
		def ?|(default: () => T) = if (self) self else default()
		def ?&(default: () => Any) = if (self) self else default()
	}

	//metody które moge sam wywoływać
	implicit def string(self: String) = new {
		//		def to_b = self != null && !self.isEmpty && self != "" && self != "0"
		def to_i = Integer.parseInt(self)
		def apply() = self
	}
	implicit def list(self: List[Any]) {}

	//kontekst skalarny
	implicit def scalar(self: Int) = new {
		def +(other: String) = self + other.to_i
		def -(other: String) = self - other.to_i
		def *(other: String) = self * other.to_i
		def /(other: String) = self / other.to_i
		def %(other: String) = self % other.to_i
	}

	implicit def scalar(self: Double) = new {
		def +(other: String) = self + other.to_i
		def -(other: String) = self - other.to_i
		def *(other: String) = self * other.to_i
		def /(other: String) = self / other.to_i
		def %(other: String) = self % other.to_i
	}

	def tcl(s: String) = s match {
		case "0" | "false" | "no" => false
		case "1" | "true" | "yes" => true
		case _ => throw new YourArgumentIsInvalidException(s)
	}

}