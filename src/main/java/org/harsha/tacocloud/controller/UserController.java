package org.harsha.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.harsha.tacocloud.dto.SuccessResponse;
import org.harsha.tacocloud.dto.UserRequestDto;
import org.harsha.tacocloud.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
  private final AppUserService appUserService;

  @PostMapping
  public ResponseEntity<SuccessResponse<String>> registerUser(
      @RequestBody @Valid UserRequestDto userRequestDto) {
    appUserService.registerUser(userRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("user created"));
  }
}
