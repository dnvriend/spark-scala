package com.example

import akka.actor.{Props, Actor, ActorLogging, ActorSystem}
import akka.util.Timeout
import akka.pattern.ask
import java.text.SimpleDateFormat
import java.util.Date
import scala.concurrent._
import scala.concurrent.duration._

/**
 * Lightweight REST service using SparkJava!
 */
object Main extends Spark with App {
  import scala.collection.JavaConverters._
  implicit val system = ActorSystem("my-system")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(60 seconds)
  val pingActor = system.actorOf(PingActor.props)

  setServerPort(8080)

  get("/hello"){ (_, _) => "Got a get" }
  post("/hello") { (_,_) => "Got a post" }
  put("/hello") { (_,_) => "Got a put" }
  delete("/hello") { (_,_) => "Got a delete" }

  get("/hello/:name") { (request, response) =>
    s"""Response: Hello: ${request.params(":name")}
       |Body: ${request.body}
       |Cookies: ${request.cookies.asScala}
       |Length: ${request.contentLength}
       |ContentType: ${request.contentType}
       |HeaderList ${request.headers.asScala}
       |AttributeList: ${request.attributes.asScala}
       |Host: ${request.host}
       |Ip: ${request.ip}
       |Port: ${request.port}
       |PathInfo: ${request.pathInfo}
       |Parameters: ${request.params.asScala}
       |QueryMap: ${request.queryMap.toMap.asScala}
       |QueryParamList: ${request.queryParams.asScala}
       |HttpServletRequest Handled By Jetty: ${request.raw}
       |RequestMethod: ${request.requestMethod}
       |Scheme: ${request.scheme}
       |Session Management: ${request.session.toString}
       |Splat (*) parameters: ${request.splat.toList}
       |Url: ${request.url}
       |User Agent: ${request.userAgent}
       |Headers: ${request.headers.asScala}""".stripMargin
  }

  // we can talk to Actors
  get("/ping") { (_,_) =>
    Await.result(pingActor ? "ping", 1 second).asInstanceOf[String]
  }
}

object PingActor {
  val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
  def props = Props(new PingActor(sdf))
}

class PingActor(sdf: SimpleDateFormat) extends Actor {
  override def receive: Receive = {
    case _ =>
      sender ! s"pong ${sdf.format(new Date)}"
  }
}

