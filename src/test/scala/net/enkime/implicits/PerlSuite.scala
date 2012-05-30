package net.enkime.implicits
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PerlSuite extends Perl with FunSuite {
	test("coalescing ?? null string") {
	}
}