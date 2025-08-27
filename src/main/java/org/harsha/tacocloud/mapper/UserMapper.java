package org.harsha.tacocloud.mapper;

import org.harsha.tacocloud.dto.UserRequestDto;
import org.harsha.tacocloud.entity.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public AppUser mapToUer(UserRequestDto userRequestDto) {
    return AppUser.builder()
        .username(userRequestDto.username())
        .password(userRequestDto.password())
        .fullName(userRequestDto.fullName())
        .street(userRequestDto.street())
        .city(userRequestDto.city())
        .state(userRequestDto.state())
        .zip(userRequestDto.zip())
        .phoneNumber(userRequestDto.phone())
        .build();
  }
}
