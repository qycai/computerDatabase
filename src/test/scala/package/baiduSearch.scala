package package

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class baiduSearch extends Simulation {

	val httpProtocol = http
		.baseUrl("https://www.baidu.com")
		.inferHtmlResources()
		.acceptHeader("image/webp,*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:72.0) Gecko/20100101 Firefox/72.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("baiduSearch")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/img/bd_logo1.png"),
            http("request_2")
			.get("/img/baidu_jgylogo3.gif"),
            http("request_3")
			.get("/img/baidu_resultlogo@2.png"),
            http("request_4")
			.get("/favicon.ico")))
		.pause(7)
		.exec(http("request_5")
			.get("/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&ch=&tn=baidu&bar=&wd=gatling&rn=&fenlei=256&oq=&rsv_pq=9176db25000153a8&rsv_t=1d4bDVVgXt5H8aKS6Lf1QWg2dWXsDDx0Bv554T8gNoh0Xv3sUtYfTk0WCng&rqlang=cn")
			.headers(headers_0)
			.resources(http("request_6")
			.get("/aladdin/tpl/right_toplist1/refresh.png"),
            http("request_7")
			.get("/aladdin/tpl/dict3/repeat_small.c6d62112.png"),
            http("request_8")
			.get("/aladdin/img/dic3/iconall.gif")))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}