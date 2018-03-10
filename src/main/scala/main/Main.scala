package main

trait User {
  def name: String
  def score: Int
}
class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
  extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] =
    Some((user.name, user.score, user.upgradeProbability))
}
object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}

object Main {

  def main (args: Array[String] ): Unit = {

    val daniel: User = new FreeUser("Daniel", 3000, 0.7d)
    val david: User = new FreeUser("David", 2000, 0.8d)
    val dieter: User = new PremiumUser("Dieter", 1000)

    println(s"user: $daniel")

    val danielMsg: String = message(daniel)
    val davidMsg: String = message(david)

    println(s"done:  $danielMsg")
    println(s"done:  $davidMsg")
    println(s"done:  ${message(dieter)}")
    println(s"done:  ${message(new PremiumUser("Wilhelm", 1000))}")
  }

  private def message(user: User) = {
    val response = user match {
      case FreeUser(name, _, p) =>
        if (p > 0.75) name + ", what can we do for you today?"
        else "Hello " + name
      case PremiumUser(name, _) => "Welcome back, dear " + name
    }
    response
  }
}
