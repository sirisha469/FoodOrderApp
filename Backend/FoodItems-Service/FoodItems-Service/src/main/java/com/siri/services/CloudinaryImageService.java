package com.siri.services;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryImageService {
  
  public String upload(MultipartFile file);

  public Map<?, ?> uploadTest(MultipartFile file);

  String deleteFile(String url);

  public String extractPublicIdFromUrl(String url);
}
