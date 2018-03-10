import main.Main
import org.scalatest.{FlatSpec, Matchers}

class MainTest extends FlatSpec with Matchers {

  it should "be a valid object" in {
    val target = Main
    target should not be Nil
  }
}
