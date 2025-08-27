package org.harsha.tacocloud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @NotNull
  @Size(min = 1, message = "You must choose at least 1 ingredient")
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "taco_ingredients",
      joinColumns = @JoinColumn(name = "taco_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
  private List<Ingredient> ingredients = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "taco_order_id")
  private TacoOrder tacoOrder;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser appUser;

  private Date createdAt = new Date();
}
