package org.harsha.tacocloud.service;

import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.entity.TacoOrder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
  public void processOrder(TacoOrder order) {
    log.info("Order submitted: {}", order);
  }
}
