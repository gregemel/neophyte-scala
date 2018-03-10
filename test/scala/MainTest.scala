import main.Main
import org.scalatest.{FlatSpec, Matchers}

/** @version created manually **/
class MainTest extends FlatSpec with Matchers {

  it should "allow Main to be Tested" in {
    val main = new Main
    true should be(true)
  }
}
