package com.siri.services;

import org.springframework.web.multipart.MultipartFile;

import com.siri.dto.FoodItemsRequest;
import com.siri.dto.FoodItemsResponse;

public interface FoodItemsService {
  
  FoodItemsResponse addFood(FoodItemsRequest request, MultipartFile file);
}
