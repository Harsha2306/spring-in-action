package org.harsha.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.harsha.tacocloud.dto.SuccessResponse;
import org.harsha.tacocloud.entity.TacoOrder;
import org.harsha.tacocloud.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  public ResponseEntity<SuccessResponse<String>> processOrder(@RequestBody @Valid TacoOrder order) {
    orderService.processOrder(order);
    return ResponseEntity.ok().body(new SuccessResponse<>("order created"));
  }
}
