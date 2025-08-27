package org.harsha.tacocloud.dto;

import java.util.List;
import lombok.Builder;
import org.harsha.tacocloud.entity.Ingredient;

@Builder
public record TacoResponseDto(String name, List<Ingredient> ingredients) {}
