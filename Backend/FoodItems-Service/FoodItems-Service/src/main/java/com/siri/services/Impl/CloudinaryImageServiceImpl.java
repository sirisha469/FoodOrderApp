package com.siri.services.Impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.siri.services.CloudinaryImageService;

@Service
public class CloudinaryImageServiceImpl implements CloudinaryImageService{

  @Autowired
  private Cloudinary cloudinary;

  @Override
  public String upload(MultipartFile file) {
    
    try {
      Map<?,?> data = cloudinary.uploader().upload(file.getBytes(), Map.of());
      return data.get("secure_url").toString();
    } catch (IOException e) {
      throw new RuntimeException("Image uploading fail!!");
    }
    
  }
  
}
