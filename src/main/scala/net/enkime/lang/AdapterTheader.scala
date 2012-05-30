package net.enkime.lang

import java.util.concurrent.Callable

trait AdapterThread {
	implicit def toRunnable[T](lambda: => T) = new Runnable() {
		def run() = lambda
	}
	implicit def toCallable[T](lambda: => T) = new Callable[T]() {
		def call() = lambda
	}
}