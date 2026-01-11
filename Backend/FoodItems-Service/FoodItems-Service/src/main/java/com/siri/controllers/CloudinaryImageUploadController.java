package com.siri.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.siri.services.CloudinaryImageService;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/cloudinary/upload")
public class CloudinaryImageUploadController {
  
  @Autowired
  public CloudinaryImageService cloudinaryImageService;


  @PostMapping
  public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file){
    String data = cloudinaryImageService.upload(file);
    //return new ResponseEntity<>(data, HttpStatus.OK);
    return ResponseEntity.ok(Map.of("url", data));
  } 
  
}
