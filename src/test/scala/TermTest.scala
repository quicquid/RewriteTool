package at.searles.kart.terms

import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.mockito.Matchers._

@RunWith( classOf[JUnitRunner] )
class TermTest extends SpecificationWithJUnit {
  "The term library" should {
    val tl = new TermList

    //shortcuts
    val app = tl.createApp(_,_)
    val freevar = tl.createVar(_)
    val boundvar = tl.createLambdaVar(_)
    val lambda = tl.createLambda(_)


    "create basic terms" in {
      val z = freevar("z")

      val x = boundvar(0)
      val y = boundvar(1)

      val lxzx = lambda(app(z,x))
      val lyxy = lambda(lambda(y))
      val lxx = lambda(x)

      println(lxzx)
      println(lyxy)

      val app1 = app(lxzx, z)
      println(app1)

      ok("done")
    }

    "perform replacement" in {
      val z = freevar("z")

      val x = boundvar(0)

      val lxzx = lambda( app(z, x) )
      val lxx = lambda(x)

      val r1 = lxzx.replace(lxx, List(0,0))


      println(r1)

      //check if the term is like we expected
      val expect1 = lambda(app(lambda(x),x))
      r1 must_== expect1

      // check if the db-Indices are always 0, since they refer to the next binder
      r1 match {
        case Lambda(
               App(Lambda(LambdaVar(x,_),_),
                   LambdaVar(y,_),
                   _),
               _
             ) =>
              ("inner index: "+x,"outer index: "+y) must_== ("inner index: 0","outer index: 0")

        case _ =>
          ko("result is not of shape Lambda(App(Lambda(LambdaVar(_), LambdaVar(_)))!")
      }

    }
  }
}
