package net.enkime.implicits
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import com.weiglewilczek.slf4s.Logging

@RunWith(classOf[JUnitRunner])
class GenieSuite extends Genie with FunSuite with Logging {
  test("coalescing ?? null string") {
    var s: String = null
    assert(s ?? "value" === "value")

    val f = () => { "" }
    assert(s ?? (() => {
      //logger.info("lazy")
      val sb = new StringBuilder("function")
      sb.toString()
    })() === "function")
  }

  test("coalescing ?? null not string") {
    var s = "init"
    assert(s ?? "value" === "init")
    assert(s ?? { () =>
      {
        logger.info("lazy")
        val sb = new StringBuilder("function")
        sb.toString()
      }
    } === "init")
  }

  test("coalescing ?? const string") {
    val s = "init"
    assert(s ?? "value" === "init")
    assert(s ?? { () =>
      {
        logger.info("lazy")
        val sb = new StringBuilder("function")
        sb.toString()
      }
    } === "init")
  }
}