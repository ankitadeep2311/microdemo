package com.example.user.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserServiceController {
  private final Counter counter;

  public UserServiceController(MeterRegistry registry) {
    this.counter = Counter.builder("user.requests.total").description("Total UserServiceController requests").register(registry);
  }

  @GetMapping("/{id}")
  public Map<String,String> get(@PathVariable("id") String id) {
    counter.increment();
    return Map.of( "id", id,
            "name", "user-" + id);
  }

  @GetMapping("/health")
  public String health() { return "ok"; }
}
