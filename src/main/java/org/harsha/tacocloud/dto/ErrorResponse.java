package org.harsha.tacocloud.dto;

import java.util.Map;

public record ErrorResponse(String message, Map<String, String> errors) {}
