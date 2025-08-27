package org.harsha.tacocloud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
    @NotBlank(message = "Username is required")
        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
        String username,
    @NotBlank(message = "Password is required")
        @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
        String password,
    @NotBlank(message = "Full name is required")
        @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
        String fullName,
    @NotBlank(message = "Street address is required")
        @Size(max = 200, message = "Street address cannot exceed 200 characters")
        String street,
    @NotBlank(message = "City is required")
        @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
        String city,
    @NotBlank(message = "State is required")
        @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
        String state,
    @NotBlank(message = "ZIP code is required")
        @Pattern(
            regexp = "^\\d{5}(-\\d{4})?$",
            message = "ZIP code must be in format 12345 or 12345-6789")
        String zip,
    @NotBlank(message = "Phone number is required")
        @Pattern(
            regexp = "^\\d{10,15}$",
            message =
                "Phone number must be valid")
        String phone) {}
