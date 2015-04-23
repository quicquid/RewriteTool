package at.searles.kart.terms

import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.mockito.Matchers._

@RunWith( classOf[JUnitRunner] )
class TermTest extends SpecificationWithJUnit {
  "The term library" should {
    "create basic terms with the parser" in {
      val tl = new TermList
      val z = Var("z", tl)

      val x = LambdaVar(0, tl)
      val y = LambdaVar(1, tl)

      val lxzx = Lambda(App(z,x, tl),tl)
      val lyxy = Lambda(Lambda(y,tl), tl)

      println(lxzx)
      println(lyxy)

      

      ok("done")
    }
  }
}


