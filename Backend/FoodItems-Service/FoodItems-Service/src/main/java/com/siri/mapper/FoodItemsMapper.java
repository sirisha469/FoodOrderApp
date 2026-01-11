package com.siri.mapper;

import org.springframework.stereotype.Component;

import com.siri.dto.FoodItemsRequest;
import com.siri.dto.FoodItemsResponse;
import com.siri.entity.FoodItems;

@Component
public class FoodItemsMapper {

  public FoodItems convertToEntity(FoodItemsRequest request){
    return FoodItems.builder()
      .name(request.getName())
      .description(request.getDescription())
      .category(request.getCategory())
      .price(request.getPrice())
      .build();
  }

  public FoodItemsResponse convertToResponse(FoodItems foodEntity){
    return FoodItemsResponse.builder()
      .id(foodEntity.getId())
      .name(foodEntity.getName())
      .description(foodEntity.getDescription())
      .category(foodEntity.getCategory())
      .price(foodEntity.getPrice())
      .imageUrl(foodEntity.getImageUrl())
      .build();
  }
  
}
