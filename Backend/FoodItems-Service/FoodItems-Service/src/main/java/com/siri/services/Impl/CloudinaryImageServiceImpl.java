package com.siri.services.Impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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

  @Override
  public Map<?,?> uploadTest(MultipartFile file) {
    
    try {
      Map<?,?> data = cloudinary.uploader().upload(file.getBytes(), Map.of());
      return data;
    } catch (IOException e) {
      throw new RuntimeException("Image uploading fail!!");
    }
    
  }

  @Override
  public String deleteFile(String url) {
    String public_id = extractPublicIdFromUrl(url);
    // System.out.println(public_id);
    try {
      Map<?,?> result = cloudinary.uploader().destroy(public_id, ObjectUtils.emptyMap());
      Object status = result.get("result");
      if (status == null) {
          return result.toString();
      }

      return status.toString();
    } catch (IOException e) {
      throw new RuntimeException("Error deleting image: " + e.getMessage());
    }
  }

  @Override
  public String extractPublicIdFromUrl(String url) {
    String part = url.split("/upload/")[1];               
    String withoutExtension = part.substring(0, part.lastIndexOf('.')); 
    return withoutExtension.substring(withoutExtension.indexOf('/') + 1); 
  }
  
}
