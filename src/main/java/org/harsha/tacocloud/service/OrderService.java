package org.harsha.tacocloud.service;

import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.entity.Ingredient;
import org.harsha.tacocloud.entity.Taco;
import org.harsha.tacocloud.entity.TacoOrder;
import org.harsha.tacocloud.repository.IngredientRepository;
import org.harsha.tacocloud.repository.TacoOrderRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
  private final TacoOrderRepository tacoOrderRepository;

  private final IngredientRepository ingredientRepository;

  private final AppUserService appUserService;

  public void processOrder(TacoOrder order) {
    for (Taco taco : order.getTacos()) {
      List<String> ingredientIds = taco.getIngredients().stream().map(Ingredient::getId).toList();
      List<Ingredient> persistentIngredients = ingredientRepository.findAllById(ingredientIds);

      if (persistentIngredients.size() != ingredientIds.size()) {
        throw new IllegalArgumentException("Some ingredients were not found in the database");
      }

      taco.setIngredients(persistentIngredients);
      taco.setTacoOrder(order);
      taco.setAppUser(appUserService.getCurrentUserPrinciple());

      if (taco.getCreatedAt() == null) taco.setCreatedAt(new Date());
    }
    order.setPlacedAt(new Date());
    tacoOrderRepository.save(order);
    log.info("Order submitted: {}", order.getId());
  }
}
