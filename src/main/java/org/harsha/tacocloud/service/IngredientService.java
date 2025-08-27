package org.harsha.tacocloud.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.entity.Ingredient;
import org.harsha.tacocloud.exception.IngredientNotFoundException;
import org.harsha.tacocloud.repository.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IngredientService {
  private final IngredientRepository ingredientRepository;

  public void loadIngredients() {
    List<Ingredient> ingredients =
        Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
            new Ingredient("GRBF", "Ground Beer", Ingredient.Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
    ingredientRepository.saveAll(ingredients);
    log.info("{} ingredients loaded", ingredients.size());
  }

  public Map<Ingredient.Type, List<Ingredient>> getIngredients() {
    return ingredientRepository.findAll().stream()
        .collect(Collectors.groupingBy(Ingredient::getType));
  }

  public Ingredient getIngredientById(String ingredientId) {
    log.info("getting ingredient with id:{}", ingredientId);
    return ingredientRepository
        .findById(ingredientId)
        .orElseThrow(
            () ->
                new IngredientNotFoundException(
                    "ingredient with id:" + ingredientId + " not found"));
  }
}
