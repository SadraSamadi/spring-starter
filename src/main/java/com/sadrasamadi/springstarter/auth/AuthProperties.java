package com.sadrasamadi.springstarter.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {

  private Jwt jwt;

  @Data
  public static class Jwt {

    private String prefix;

    private String secret;

    private long expiration;

  }

}
