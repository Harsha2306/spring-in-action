package org.harsha.tacocloud.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.dto.SuccessResponse;
import org.harsha.tacocloud.entity.Ingredient;
import org.harsha.tacocloud.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tacos")
@RequiredArgsConstructor
@Slf4j
public class TacoController {
  private final IngredientService ingredientService;

  @GetMapping
  public ResponseEntity<SuccessResponse<Map<Ingredient.Type, List<Ingredient>>>> getIngredients() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new SuccessResponse<>(ingredientService.getIngredients()));
  }
}
