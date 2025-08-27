package org.harsha.tacocloud.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.dto.TacoResponseDto;
import org.harsha.tacocloud.entity.AppUser;
import org.harsha.tacocloud.mapper.TacoMapper;
import org.harsha.tacocloud.repository.TacoRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TacoService {
  private final TacoRepository tacoRepository;

  private final AppUserService appUserService;

  private final TacoMapper tacoMapper;

  public List<TacoResponseDto> getTacosOrderedByUser() {
    AppUser appUser = appUserService.getCurrentUserPrinciple();
    log.info("getting tacos ordered by user:{}", appUser.getUsername());
    return tacoRepository.findByAppUserOrderByCreatedAtDesc(appUser).stream()
        .map(tacoMapper::mapToTacoResponseDto)
        .toList();
  }
}
