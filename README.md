# spark-scala
A very basic wrapper class for the great [SparkJava](http://www.sparkjava.com/index.html) project by [Per Wendel](https://github.com/perwendel).

I'm getting used to Scala, the syntax and functional concepts so I've put this together with minimal effort, it shows!

[![License](http://img.shields.io/:license-Apache%202-red.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)

# Running the example
Type `sbt run` to run the example.

# Example configuration
The com.example.Main class has the configuration from the Spark website:

    get("/hello"){ (_, _) => "Got a get" }
    post("/hello") { (_,_) => "Got a post" }
    put("/hello") { (_,_) => "Got a put" }
    delete("/hello") { (_,_) => "Got a delete" }
    get("/hello/:name") { (_,_) => "Hello $name" }
    get("/debug") { (_,_) => "shows debug stuff" }
    get("/ping") { (_,_) => pingactor ? "ping" }
    
# Actors
This example shows communicating with Actors, but if you don't need that, you only need the Spark.scala class and 
the spark-core library. 

# Httpie
Install [httpie](https://github.com/jakubroztocil/httpie), a great tool by [Jakub Roztočil](https://github.com/jakubroztocil) 
for testing your REST services, like spray or in this case, SparkJava! 

    http GET http://localhost:8080/ping
    
# Conclusion
Spark is a micro web framework (ie. very small) and it shows. Using a wrapper Java class and a Scala trait to call
the Spark methods gives a very quick way to create RESTful web services, with just a footprint of 8MB in a one jar. 

For most solutions the blocking nature of Jetty should not be a problem.
    
Have fun!