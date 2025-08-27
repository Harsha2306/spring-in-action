package org.harsha.tacocloud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.entity.TacoOrder;
import org.harsha.tacocloud.repository.TacoOrderRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
  private final TacoOrderRepository tacoOrderRepository;

  public void processOrder(TacoOrder order) {
    tacoOrderRepository.save(order);
    log.info("Order submitted: {}", order);
  }
}
