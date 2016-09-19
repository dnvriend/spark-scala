/*
 * Copyright 2015 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example

import akka.actor.{ Props, Actor, ActorSystem }
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

  get("/hello") { (_, _) ⇒ "Got a get" }
  post("/hello") { (_, _) ⇒ "Got a post" }
  put("/hello") { (_, _) ⇒ "Got a put" }
  delete("/hello") { (_, _) ⇒ "Got a delete" }

  get("/hello/:name") { (request, response) ⇒
    "Hello " + request.params(":name")
  }

  get("/debug") { (request, response) ⇒
    s"""Response: Body: ${request.body}
       |Cookies: ${request.cookies.asScala}
       |Length: ${request.contentLength}
       |ContentType: ${request.contentType}
       |HeaderList ${request.headers.asScala}
       |AttributeList: ${request.attributes.asScala}
       |Host: ${request.host}
       |Port: ${request.port}
       |Ip: ${request.ip}
       |ClientPort: ${request.raw.getRemotePort}
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
  get("/ping") { (request, response) ⇒
    Await.result(pingActor ? "ping", 1 second).asInstanceOf[String]
  }
}

object PingActor {
  def props = Props(new PingActor)
}

class PingActor extends Actor {
  override def receive: Receive = {
    case _ ⇒
      val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
      sender ! s"pong ${sdf.format(new Date)}"
  }
}
