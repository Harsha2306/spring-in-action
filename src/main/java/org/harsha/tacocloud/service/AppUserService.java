package org.harsha.tacocloud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.tacocloud.dto.UserRequestDto;
import org.harsha.tacocloud.entity.AppUser;
import org.harsha.tacocloud.mapper.UserMapper;
import org.harsha.tacocloud.repository.AppUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
  private final AppUserRepository appUserRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return appUserRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("user with name: " + username + "not found"));
  }

  public void registerUser(UserRequestDto userRequestDto) {
    AppUser appUser = userMapper.mapToUer(userRequestDto);
    appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
    appUserRepository.save(appUser);
    log.info("user: {} saved", appUser);
  }

  public AppUser getCurrentUserPrinciple() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return (AppUser) authentication.getPrincipal();
  }
}
