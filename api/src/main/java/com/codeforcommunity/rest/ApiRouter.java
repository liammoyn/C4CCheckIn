package com.codeforcommunity.rest;

import com.codeforcommunity.JacksonMapper;
import com.codeforcommunity.api.IProcessor;
import com.codeforcommunity.dto.MemberReturn;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

public class ApiRouter {
  private final IProcessor processor;

  public ApiRouter(IProcessor processor) {
    this.processor = processor;
  }

  public Router initializeRouter(Vertx vertx) {
    Router router = Router.router(vertx);

    Route getMemberRoute = router.route().path("/api/v1/members");
    getMemberRoute.handler(this::handleGetMemberRoute);

    return router;
  }

  private void handleGetMemberRoute(RoutingContext ctx) {
    HttpServerResponse response = ctx.response();
    response.putHeader("content-type", "application/json");
    List<MemberReturn> members = processor.getAttendees();

    String memberJson = null;
    try {
      memberJson = JacksonMapper.mapper.writeValueAsString(members);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    response.end(memberJson);
  }
}
