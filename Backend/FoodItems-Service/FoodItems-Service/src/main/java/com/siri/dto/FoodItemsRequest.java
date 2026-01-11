package com.siri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsRequest {
  
  private String name;
  private String description;
  private double price;
  private String category;
}
