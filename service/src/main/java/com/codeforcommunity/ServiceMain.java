package com.codeforcommunity;

import com.codeforcommunity.api.IProcessor;
import com.codeforcommunity.processor.ProcessorImpl;
import com.codeforcommunity.rest.ApiRouter;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class ServiceMain {
  private DSLContext db;

  public static void main(String[] args) {
    ServiceMain serviceMain = new ServiceMain();
    serviceMain.initialize();
  }

  public void initialize() {
    connectDb();
    initializeServer();
  }

  private void connectDb() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    DSLContext db = DSL.using("jdbc:mysql://localhost:3306/checkin?useSSL=false",
        "root", "apple");
    this.db = db;
  }

  private void initializeServer() {
    IProcessor processor = new ProcessorImpl(this.db);
    ApiRouter router = new ApiRouter(processor);

    startApiServer(router);
  }

  private void startApiServer(ApiRouter router) {
    ApiMain apiMain = new ApiMain(router);
    apiMain.startApi();
  }
}
