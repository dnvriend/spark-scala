package com.example

import spark._

trait Spark extends SparkJava {
  def convertToRequest(path: String, f: (Request, Response) => AnyRef): Route = {
    new Route() {
      override def handle(request: Request, response: Response): AnyRef = {
        f(request, response)
      }
    }
  }

  def convertToFilter(path: String, f: (Request, Response) => Unit): Filter = {
    new Filter() {
      override def handle(request: Request, response: Response): Unit = {
        f(request, response)
      }
    }
  }

  def get(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    get(path, convertToRequest(path, f))
  }

  def post(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    post(path, convertToRequest(path, f))
  }

  def put(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    put(path, convertToRequest(path, f))
  }

  def patch(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    patch(path, convertToRequest(path, f))
  }

  def delete(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    delete(path, convertToRequest(path, f))
  }

  def head(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    head(path, convertToRequest(path, f))
  }

  def trace(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    trace(path, convertToRequest(path, f))
  }

  def connect(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    connect(path, convertToRequest(path, f))
  }

  def options(path: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    options(path, convertToRequest(path, f))
  }

  def before(path: String)(implicit f: (Request, Response) => Unit): Unit = {
    before(path, convertToFilter(path, f))
  }

  def after(path: String)(implicit f: (Request, Response) => Unit): Unit = {
    after(path, convertToFilter(path, f))
  }

  def get(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    get(path, acceptType, convertToRequest(path, f))
  }

  def post(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    post(path, acceptType, convertToRequest(path, f))
  }

  def put(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    put(path, acceptType, convertToRequest(path, f))
  }

  def patch(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    patch(path, acceptType, convertToRequest(path, f))
  }

  def delete(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    delete(path, acceptType, convertToRequest(path, f))
  }

  def head(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    head(path, acceptType, convertToRequest(path, f))
  }

  def trace(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    trace(path, acceptType, convertToRequest(path, f))
  }

  def connect(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    connect(path, acceptType, convertToRequest(path, f))
  }

  def options(path: String, acceptType: String)(implicit f: (Request, Response) => AnyRef): Unit = {
    options(path, acceptType, convertToRequest(path, f))
  }

  def before(path: String, acceptType: String)(implicit f: (Request, Response) => Unit): Unit = {
    before(path, acceptType, convertToFilter(path, f))
  }

  def after(path: String, acceptType: String)(implicit f: (Request, Response) => Unit): Unit = {
    after(path, acceptType, convertToFilter(path, f))
  }
}
