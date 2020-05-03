package addComputer

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddNewComputer extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7",
		"Origin" -> "http://computer-database.gatling.io",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("AddNewComputer")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/assets/stylesheets/bootstrap.min.css"),
            http("request_2")
			.get("/assets/stylesheets/main.css")))
		.pause(1)
		.exec(http("request_3")
			.get("/computers/new")
			.headers(headers_0)
			.resources(http("request_4")
			.get("/assets/stylesheets/bootstrap.min.css"),
            http("request_5")
			.get("/assets/stylesheets/main.css")))
		.pause(28)
		.exec(http("request_6")
			.post("/computers")
			.headers(headers_6)
			.formParam("name", "GatlingLearning")
			.formParam("introduced", "2019-05-06")
			.formParam("discontinued", "2020-04-30")
			.formParam("company", "4")
			.resources(http("request_7")
			.get("/assets/stylesheets/bootstrap.min.css"),
            http("request_8")
			.get("/assets/stylesheets/main.css")))
		.pause(10)
		.exec(http("request_9")
			.get("/computers?f=GatlingLearning")
			.headers(headers_0)
			.resources(http("request_10")
			.get("/assets/stylesheets/bootstrap.min.css"),
            http("request_11")
			.get("/assets/stylesheets/main.css")))
		.pause(2)
		.exec(http("request_12")
			.get("/computers/4171")
			.headers(headers_0)
			.resources(http("request_13")
			.get("/assets/stylesheets/bootstrap.min.css"),
            http("request_14")
			.get("/assets/stylesheets/main.css")))
		.pause(3)
		.exec(http("request_15")
			.get("/computers")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}