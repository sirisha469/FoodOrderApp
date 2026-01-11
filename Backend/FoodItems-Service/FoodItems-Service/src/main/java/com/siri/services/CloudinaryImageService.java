package com.siri.services;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryImageService {
  
  public String upload(MultipartFile file);
}
