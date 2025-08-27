package org.harsha.tacocloud.exception;

public class IngredientNotFoundException extends RuntimeException {
  public IngredientNotFoundException(String msg) {
    super(msg);
  }
}
