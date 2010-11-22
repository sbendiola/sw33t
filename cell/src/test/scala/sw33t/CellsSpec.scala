package sw33t

import sw33t.cells._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class CellsSpec extends FlatSpec with ShouldMatchers {
  "cell"  should "cache value" in {
    val c = cell(System.currentTimeMillis)
    c() should be (c())
  }

  "cell values" should "be composable" in {
    val d = cell(2)
    val c = cell(3 * d)
    c() should be (6)
  }

  "cell values" should "clear cached value on dependent changeupdatebe composable" in {
    val d = cell(2)
    val c = cell(3 * d)    
    c() should be (6)
    d.update(3)
    c() should be (9)
  }
}
