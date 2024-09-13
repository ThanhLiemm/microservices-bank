package com.thanhliem.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator TL_BankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/tl_bank/accounts/**")
						.filters( f -> f.rewritePath("/tl_bank/accounts/(?<segment>.*)","/${segment}"))
//								.circuitBreaker(config -> config.setName("accountsCircuitBreaker").setFallbackUri("forward:/contactSupport"))
//								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))
				.route(p -> p
						.path("/tl_bank/loans/**")
						.filters( f -> f.rewritePath("/tl_bank/loans/(?<segment>.*)","/${segment}"))
//								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
//								.retry(retryConfig -> retryConfig.setRetries(2)
//										.setMethods(HttpMethod.GET)
//										.setBackoff(Duration.ofMillis(100), Duration.ofMillis(500), 2,true)))
						.uri("lb://LOANS"))
				.route(p -> p
						.path("/tl_bank/cards/**")
						.filters( f -> f.rewritePath("/tl_bank/cards/(?<segment>.*)","/${segment}"))
//								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
//								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
//								.requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter()).setKeyResolver(userKeyResolver())))
						.uri("lb://CARDS")).build();
	}

	@Bean
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(1,1,1);
	}

	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}
}
