package com.siri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siri.dto.FoodItemsRequest;
import com.siri.dto.FoodItemsResponse;
import com.siri.services.FoodItemsService;


@RestController
@RequestMapping("/api/fooditems")
public class FoodItemsController {
  
  @Autowired
  public FoodItemsService foodItemsService;

  @Autowired(required=true)
  public ObjectMapper objectMapper;

  @PostMapping
  public ResponseEntity<FoodItemsResponse> addFood(@RequestPart("food") String food, @RequestPart("file") MultipartFile file){

    
    FoodItemsRequest foodItems = null;
      try {
        foodItems = objectMapper.readValue(food, FoodItemsRequest.class);
      }  catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    
    FoodItemsResponse response = foodItemsService.addFood(foodItems, file);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
