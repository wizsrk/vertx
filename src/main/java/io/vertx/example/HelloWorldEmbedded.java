package io.vertx.example;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;


/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class HelloWorldEmbedded {

  public static void main(String[] args) {
    // Create an HTTP server which simply returns "Hello World!" to each request.
    VertxOptions options = new VertxOptions();
    options.setEventLoopPoolSize(10);
    options.setWorkerPoolSize(100);
    Vertx ver = Vertx.vertx(options);
    ver.createHttpServer().requestHandler(req -> {
   
      ver.executeBlocking(future ->{
        
        try {
          Thread.sleep(1500);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        future.complete();
      }, res -> {
        req.response().end("Hello Improved Delay!");
      });
    }).listen(8080);
  }

}
