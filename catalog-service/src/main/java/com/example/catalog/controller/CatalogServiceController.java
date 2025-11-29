package com.example.catalog.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/catalog")
public class CatalogServiceController {
  private final Counter counter;

  public CatalogServiceController(MeterRegistry registry) {
    this.counter = Counter.builder("catalog.requests.total").description("Total CatalogServiceController requests").register(registry);
  }

  @GetMapping("/{id}")
  public Map<String,String> get(@PathVariable("id") String id) {
    counter.increment();
    return Map.of("id", id,
            "title", "product-"+id,
            "price","99.99");
  }

  @GetMapping("/health")
  public String health() { return "ok"; }
}
