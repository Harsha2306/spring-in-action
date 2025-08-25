package org.harsha.tacocloud.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.entity.Ingredient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TacoService {
  private final List<Ingredient> ingredients =
      Arrays.asList(
          new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
          new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
          new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
          new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
          new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
          new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
          new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
          new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
          new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
          new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

  public Map<Ingredient.Type, List<String>> getIngredients() {
    return ingredients.stream()
        .collect(
            Collectors.groupingBy(
                Ingredient::getType, Collectors.mapping(Ingredient::getName, Collectors.toList())));
  }
}
