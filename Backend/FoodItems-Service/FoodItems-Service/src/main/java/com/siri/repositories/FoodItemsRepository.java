package com.siri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siri.entity.FoodItems;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,String>{
  
}
