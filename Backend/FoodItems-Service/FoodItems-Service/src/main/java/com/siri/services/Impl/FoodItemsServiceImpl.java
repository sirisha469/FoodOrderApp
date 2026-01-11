package com.siri.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.siri.dto.FoodItemsRequest;
import com.siri.dto.FoodItemsResponse;
import com.siri.entity.FoodItems;
import com.siri.mapper.FoodItemsMapper;
import com.siri.repositories.FoodItemsRepository;
import com.siri.services.CloudinaryImageService;
import com.siri.services.FoodItemsService;

@Service
public class FoodItemsServiceImpl implements FoodItemsService{

  @Autowired
  public FoodItemsMapper foodItemsMapper;

  @Autowired
  public CloudinaryImageService cloudinaryImageService;

  @Autowired
  public FoodItemsRepository foodItemsRepository;

  @Override
  public FoodItemsResponse addFood(FoodItemsRequest request, MultipartFile file) {
    FoodItems foodItems = foodItemsMapper.convertToEntity(request);
    String imageUrl = cloudinaryImageService.upload(file);
    foodItems.setImageUrl(imageUrl);
    foodItems = foodItemsRepository.save(foodItems);

    return foodItemsMapper.convertToResponse(foodItems);
  }
  
}
