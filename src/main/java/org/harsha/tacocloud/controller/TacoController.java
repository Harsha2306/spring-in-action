package org.harsha.tacocloud.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.dto.SuccessResponse;
import org.harsha.tacocloud.entity.Ingredient;
import org.harsha.tacocloud.service.TacoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tacos")
@RequiredArgsConstructor
@Slf4j
public class TacoController {
  private final TacoService tacoService;

  @GetMapping
  public ResponseEntity<SuccessResponse<Map<Ingredient.Type, List<String>>>> getIngredients() {
    return ResponseEntity.ok(new SuccessResponse<>(tacoService.getIngredients()));
  }
}
