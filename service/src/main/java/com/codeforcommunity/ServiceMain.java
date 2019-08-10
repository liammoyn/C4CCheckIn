package com.codeforcommunity;

import com.codeforcommunity.api.IProcessor;
import com.codeforcommunity.processor.ProcessorImpl;
import com.codeforcommunity.rest.ApiRouter;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import org.jooq.DSLContext;

public class ServiceMain {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

    router.route().handler(ctx -> {
      HttpServerResponse response = ctx.response();
      response.putHeader("content-type", "text/plain");
      response.end("What it do babi");
    });

    server.requestHandler(router).listen(8081);
  }

  public void initialize() {
    connectDb();
    initializeServer();
  }

  private DSLContext connectDb() {
    //TODO: Do stuff
    return null;
  }

  private void initializeServer() {
    IProcessor processor = new ProcessorImpl(connectDb());
    ApiRouter router = new ApiRouter(processor);

    startApiServer(router);
  }

  private void startApiServer(ApiRouter router) {
    ApiMain apiMain = new ApiMain(router);
    apiMain.startApi();
  }
}
