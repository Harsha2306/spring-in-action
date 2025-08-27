package org.harsha.tacocloud;

import org.harsha.tacocloud.service.IngredientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TacoCloudApplication {
  public static void main(String[] args) {
    SpringApplication.run(TacoCloudApplication.class, args);
  }

  @Bean
  @Profile("!prod")
  CommandLineRunner commandLineRunner(IngredientService ingredientService) {
    return arg -> ingredientService.loadIngredients();
  }
}
