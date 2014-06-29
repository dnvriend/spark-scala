package spark;

import spark.*;
import spark.exception.ExceptionHandlerImpl;
import spark.exception.ExceptionMapper;
import spark.route.HttpMethod;
import spark.utils.SparkUtils;

public class SparkJava extends SparkBase {

    /**
     * Set the port that Spark should listen on. If not called the default port is 4567.
     * This has to be called before any route mapping is done. If provided port = 0 then the an
     * arbitrary available port will be used.
     * @param port
     */
    public void setServerPort(int port) {
        setPort(port);
    }

    /**
     * Stops the Spark server and clears all routes
     */
    public void stopServer() {
        stop();
    }

    /**
     *Set the IP address that Spark should listen on. If not called the default address is '0.0.0.0'. This has to be called before any route mapping is done.
     * @param ipAddress
     */
    public void setListenIpAddress(String ipAddress) {
        setIpAddress(ipAddress);
    }


    /**
     * Map the route for HTTP GET requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void get(final String path, final Route route) {
        addRoute(HttpMethod.get.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void post(String path, Route route) {
        addRoute(HttpMethod.post.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void put(String path, Route route) {
        addRoute(HttpMethod.put.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void patch(String path, Route route) {
        addRoute(HttpMethod.patch.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void delete(String path, Route route) {
        addRoute(HttpMethod.delete.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void head(String path, Route route) {
        addRoute(HttpMethod.head.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void trace(String path, Route route) {
        addRoute(HttpMethod.trace.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void connect(String path, Route route) {
        addRoute(HttpMethod.connect.name(), wrap(path, route));
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path  the path
     * @param route The route
     */
    public  synchronized void options(String path, Route route) {
        addRoute(HttpMethod.options.name(), wrap(path, route));
    }

    /**
     * Maps a filter to be executed before any matching routes
     *
     * @param path   the path
     * @param filter The filter
     */
    public  synchronized void before(String path, Filter filter) {
        addFilter(HttpMethod.before.name(), wrap(path, filter));
    }

    /**
     * Maps a filter to be executed after any matching routes
     *
     * @param path   the path
     * @param filter The filter
     */
    public  synchronized void after(String path, Filter filter) {
        addFilter(HttpMethod.after.name(), wrap(path, filter));
    }

    //////////////////////////////////////////////////
    // BEGIN route/filter mapping with accept type
    //////////////////////////////////////////////////

    /**
     * Map the route for HTTP GET requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void get(String path, String acceptType, Route route) {
        addRoute(HttpMethod.get.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void post(String path, String acceptType, Route route) {
        addRoute(HttpMethod.post.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void put(String path, String acceptType, Route route) {
        addRoute(HttpMethod.put.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void patch(String path, String acceptType, Route route) {
        addRoute(HttpMethod.patch.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void delete(String path, String acceptType, Route route) {
        addRoute(HttpMethod.delete.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void head(String path, String acceptType, Route route) {
        addRoute(HttpMethod.head.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void trace(String path, String acceptType, Route route) {
        addRoute(HttpMethod.trace.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void connect(String path, String acceptType, Route route) {
        addRoute(HttpMethod.connect.name(), wrap(path, acceptType, route));
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     */
    public  synchronized void options(String path, String acceptType, Route route) {
        addRoute(HttpMethod.options.name(), wrap(path, acceptType, route));
    }


    /**
     * Maps a filter to be executed before any matching routes
     *
     * @param filter The filter
     */
    public  synchronized void before(Filter filter) {
        addFilter(HttpMethod.before.name(), wrap(SparkUtils.ALL_PATHS, filter));
    }

    /**
     * Maps a filter to be executed after any matching routes
     *
     * @param filter The filter
     */
    public  synchronized void after(Filter filter) {
        addFilter(HttpMethod.after.name(), wrap(SparkUtils.ALL_PATHS, filter));
    }

    /**
     * Maps a filter to be executed before any matching routes
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param filter     The filter
     */
    public  synchronized void before(String path, String acceptType, Filter filter) {
        addFilter(HttpMethod.before.name(), wrap(path, acceptType, filter));
    }

    /**
     * Maps a filter to be executed after any matching routes
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param filter     The filter
     */
    public  synchronized void after(String path, String acceptType, Filter filter) {
        addFilter(HttpMethod.after.name(), wrap(path, acceptType, filter));
    }

    //////////////////////////////////////////////////
    // END route/filter mapping with accept type
    //////////////////////////////////////////////////

    //////////////////////////////////////////////////
    // BEGIN Template View Routes
    //////////////////////////////////////////////////

    /**
     * Map the route for HTTP GET requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void get(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.get.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP GET requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void get(String path,
                                        String acceptType,
                                        TemplateViewRoute route,
                                        TemplateEngine engine) {
        addRoute(HttpMethod.get.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void post(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.post.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void post(String path,
                                         String acceptType,
                                         TemplateViewRoute route,
                                         TemplateEngine engine) {
        addRoute(HttpMethod.post.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void put(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.put.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void put(String path,
                                        String acceptType,
                                        TemplateViewRoute route,
                                        TemplateEngine engine) {
        addRoute(HttpMethod.put.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void delete(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.delete.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void delete(String path,
                                           String acceptType,
                                           TemplateViewRoute route,
                                           TemplateEngine engine) {
        addRoute(HttpMethod.delete.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void patch(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.patch.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void patch(String path,
                                          String acceptType,
                                          TemplateViewRoute route,
                                          TemplateEngine engine) {
        addRoute(HttpMethod.patch.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void head(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.head.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void head(String path,
                                         String acceptType,
                                         TemplateViewRoute route,
                                         TemplateEngine engine) {
        addRoute(HttpMethod.head.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void trace(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.trace.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void trace(String path,
                                          String acceptType,
                                          TemplateViewRoute route,
                                          TemplateEngine engine) {
        addRoute(HttpMethod.trace.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void connect(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.connect.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void connect(String path,
                                            String acceptType,
                                            TemplateViewRoute route,
                                            TemplateEngine engine) {
        addRoute(HttpMethod.connect.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path   the path
     * @param route  The route
     * @param engine the template engine
     */
    public  synchronized void options(String path, TemplateViewRoute route, TemplateEngine engine) {
        addRoute(HttpMethod.options.name(), TemplateViewRouteImpl.create(path, route, engine));
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path       the path
     * @param acceptType the accept type
     * @param route      The route
     * @param engine     the template engine
     */
    public  synchronized void options(String path,
                                            String acceptType,
                                            TemplateViewRoute route,
                                            TemplateEngine engine) {
        addRoute(HttpMethod.options.name(), TemplateViewRouteImpl.create(path, acceptType, route, engine));
    }

    //////////////////////////////////////////////////
    // END Template View Routes
    //////////////////////////////////////////////////

    //////////////////////////////////////////////////
    // BEGIN Response Transforming Routes
    //////////////////////////////////////////////////

    /**
     * Map the route for HTTP GET requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void get(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.get.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP GET requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void get(String path, String acceptType, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.get.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void post(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.post.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP POST requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void post(String path, String acceptType, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.post.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void put(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.put.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP PUT requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void put(String path, String acceptType, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.put.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void delete(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.delete.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP DELETE requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void delete(String path,
                                           String acceptType,
                                           Route route,
                                           ResponseTransformer transformer) {
        addRoute(HttpMethod.delete.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void head(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.head.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP HEAD requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void head(String path, String acceptType, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.head.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void connect(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.connect.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP CONNECT requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void connect(String path,
                                            String acceptType,
                                            Route route,
                                            ResponseTransformer transformer) {
        addRoute(HttpMethod.connect.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void trace(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.trace.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP TRACE requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void trace(String path,
                                          String acceptType,
                                          Route route,
                                          ResponseTransformer transformer) {
        addRoute(HttpMethod.trace.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void options(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.options.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP OPTIONS requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void options(String path,
                                            String acceptType,
                                            Route route,
                                            ResponseTransformer transformer) {
        addRoute(HttpMethod.options.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path        the path
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void patch(String path, Route route, ResponseTransformer transformer) {
        addRoute(HttpMethod.patch.name(), ResponseTransformerRouteImpl.create(path, route, transformer));
    }

    /**
     * Map the route for HTTP PATCH requests
     *
     * @param path        the path
     * @param acceptType  the accept type
     * @param route       The route
     * @param transformer the response transformer
     */
    public  synchronized void patch(String path,
                                          String acceptType,
                                          Route route,
                                          ResponseTransformer transformer) {
        addRoute(HttpMethod.patch.name(), ResponseTransformerRouteImpl.create(path, acceptType, route, transformer));
    }

    //////////////////////////////////////////////////
    // END Response Transforming Routes
    //////////////////////////////////////////////////

    //////////////////////////////////////////////////
    // EXCEPTION mapper
    //////////////////////////////////////////////////

    /**
     * Maps an exception handler to be executed when an exception occurs during routing
     *
     * @param exceptionClass the exception class
     * @param handler        The handler
     */
    public synchronized void exception(Class<? extends Exception> exceptionClass, ExceptionHandler handler) {
        // wrap
        ExceptionHandlerImpl wrapper = new ExceptionHandlerImpl(exceptionClass) {
            @Override
            public void handle(Exception exception, Request request, Response response) {
                handler.handle(exception, request, response);
            }
        };

        ExceptionMapper.getInstance().map(exceptionClass, wrapper);
    }

    //////////////////////////////////////////////////
    // HALT methods
    //////////////////////////////////////////////////

    /**
     * Immediately stops a request within a filter or route
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     */
    public void halt() {
        throw new HaltException();
    }

    /**
     * Immediately stops a request within a filter or route with specified status code
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     *
     * @param status the status code
     */
    public  void halt(int status) {
        throw new HaltException(status);
    }

    /**
     * Immediately stops a request within a filter or route with specified body content
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     *
     * @param body The body content
     */
    public  void halt(String body) {
        throw new HaltException(body);
    }

    /**
     * Immediately stops a request within a filter or route with specified status code and body content
     * NOTE: When using this don't catch exceptions of type HaltException, or if catched, re-throw otherwise
     * halt will not work
     *
     * @param status The status code
     * @param body   The body content
     */
    public  void halt(int status, String body) {
        throw new HaltException(status, body);
    }


}
