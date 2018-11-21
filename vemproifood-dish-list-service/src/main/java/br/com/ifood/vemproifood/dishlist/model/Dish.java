package br.com.ifood.vemproifood.dishlist.model;


import java.util.UUID;

public class Dish {

  private UUID dishId;
  private String name;

  public UUID getDishId() {
    return dishId;
  }

  public void setDishId(UUID dishId) {
    this.dishId = dishId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
