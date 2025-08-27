package org.harsha.tacocloud.mapper;

import org.harsha.tacocloud.dto.TacoResponseDto;
import org.harsha.tacocloud.entity.Taco;
import org.springframework.stereotype.Component;

@Component
public class TacoMapper {
  public TacoResponseDto mapToTacoResponseDto(Taco taco) {
    return TacoResponseDto.builder()
        .name(taco.getName())
        .ingredients(taco.getIngredients())
        .build();
  }
}
