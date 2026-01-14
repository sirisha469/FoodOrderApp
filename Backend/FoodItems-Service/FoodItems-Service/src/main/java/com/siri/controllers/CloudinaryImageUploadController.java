package com.siri.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.siri.services.CloudinaryImageService;

import org.springframework.web.bind.annotation.DeleteMapping;
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

  @PostMapping("/test")
  public ResponseEntity<Map<?,?>> uploadImageTest(@RequestParam("image") MultipartFile file){
    Map<?,?> data = cloudinaryImageService.uploadTest(file);
    //return new ResponseEntity<>(data, HttpStatus.OK);
    return ResponseEntity.ok(data);
  } 
  

  @DeleteMapping
  public ResponseEntity<String> deleteFile(@RequestParam("image") String url){
    String result = cloudinaryImageService.deleteFile(url);
    if("ok".equals(result)){
      return ResponseEntity.ok("Image deleted successfully");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
  }
}
