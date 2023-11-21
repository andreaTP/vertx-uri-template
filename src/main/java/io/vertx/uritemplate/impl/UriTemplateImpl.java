package io.vertx.uritemplate.impl;

import io.github.stduritemplate.StdUriTemplate;
import io.vertx.uritemplate.ExpandOptions;
import io.vertx.uritemplate.UriTemplate;
import io.vertx.uritemplate.Variables;

import java.util.HashMap;
import java.util.Map;

public class UriTemplateImpl implements UriTemplate {
  private String uri;

  public UriTemplateImpl(String uri) {
    this.uri = uri;
  }

  @Override
  public String expandToString(Variables variables) {
    Map<String, Object> substs = new HashMap<>();
    for (String key: variables.names()) {
      substs.put(key, variables.get(key));
    }
    return StdUriTemplate.expand(uri, substs);
  }

  @Override
  public String expandToString(Variables variables, ExpandOptions options) {
    return expandToString(variables);
  }
}
