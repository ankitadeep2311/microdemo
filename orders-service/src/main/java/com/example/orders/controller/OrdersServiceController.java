package com.example.orders.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrdersServiceController {
  private final Counter counter;

  public OrdersServiceController(MeterRegistry registry) {
    this.counter = Counter.builder("orders.requests.total").description("Total OrdersServiceController requests").register(registry);
  }

  @GetMapping("/{id}")
  public Map<String,String> get(@PathVariable("id") String id) {
    counter.increment();
    return Map.of(
            "id", id,
            "item", "item-" + id,
            "status", "CREATED"
    );  }

  @GetMapping("/health")
  public String health() { return "ok"; }
}
