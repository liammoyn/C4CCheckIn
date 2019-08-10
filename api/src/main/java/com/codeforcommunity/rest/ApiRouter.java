package com.codeforcommunity.rest;

import com.codeforcommunity.api.IProcessor;

public class ApiRouter {
  private final IProcessor processor;

  public ApiRouter(IProcessor processor) {
    this.processor = processor;
  }
}
