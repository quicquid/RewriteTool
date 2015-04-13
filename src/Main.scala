/**
 * Created by searles on 09.04.15.
 */
object Main extends scala.App {
	val tl = new TermList;

	val trs = RuleFactory.trs(
		"+(x,0) -> x" +
		"+(x,s(y)) -> s(+(x,y))" +
		"-(s(x),s(y)) -> -(x,y)" +
		"-(x,0) -> x" +
		"*(x,0) -> 0" +
		"*(x,s(y)) -> +(x, *(x,y))" +
		"^(x,0) -> s(0)" +
		"^(x,s(y)) -> *(x, ^(x, y))" +
		"/(x,y) -> :(0,x) <= <(x, y) -> true()" +
		"/(x,y) -> :(s(q),r) <= <(x, y) -> false(), /(-(x, y),y) -> :(q,r)" +
		"<(s(x),s(y)) -> <(x,y)" +
		"<(0,s(y)) -> true()" +
		"<(x,0) -> false()"
		).get;

	//val t = new TermList().term("/(^(s(s(s(s(s(0))))),s(s(s(s(s(0)))))),^(s(s(s(s(s(0))))),s(s(s(s(0))))))").get
	val t = new TermList().term("/(^(s(s(s(s(0)))),s(s(s(s(s(0)))))),^(s(s(s(s(0)))),s(s(s(s(0))))))").get

	val now = System.nanoTime()
	println(t map trs) ;

	val delay = System.nanoTime() - now;
	println(delay / 1000000.);

	//println((new TermList().term("/(^(s(s(s(s(s(0))))),s(s(s(s(0))))),^(s(s(s(s(s(0))))),s(s(s(0)))))").get) map trs) ;
	//println((new TermList().term("/(^(s(s(s(s(s(0))))),s(s(s(s(s(0)))))),^(s(s(s(s(s(0))))),s(s(s(s(0))))))").get) map trs) ;
	//println((new TermList().term("/(s(s(0)),s(s(0)))").get) map trs) ;
}

