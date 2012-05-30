package net.enkime.implicits

trait Genie {
  implicit def v_to_b(self: AnyVal) = self != 0
  implicit def r_to_b(self: AnyRef) = self != null
  implicit def to_b(self: String) = self != null && self != ""

  implicit def coalescing_val[T <: AnyVal](self: => T) = new {
    implicit def v_to_b(self: AnyVal) = self != 0
    def ??[A >: T](default: () => A) = if (self) self else default
    def ??[A >: T](default: A) = if (self) self else default
  }

  implicit def coalescing_ref[T <: AnyRef](self: => T) = new {
    implicit def r_to_b(self: AnyRef) = self != null
    implicit def to_b(self: String) = self != null && self != ""
    def ??[A >: T](default: () => A) = if (self) self else default
    def ??[A >: T](default: A) = if (self) self else default
  }

}

