package org.harsha.tacocloud.util;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.harsha.tacocloud.repository.TacoRepository;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TacoCountInfoContributor implements InfoContributor {
  private final TacoRepository tacoRepository;

  @Override
  public void contribute(Info.Builder builder) {
    Map<String, Long> tacoMap = new HashMap<>();
    tacoMap.put("count", tacoRepository.count());
    builder.withDetail("taco-status", tacoMap);
  }
}
