package com.siri.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;


@Configuration
public class CloudinaryConfig {
  
  @Bean
  public Cloudinary getCloudinary(){
    Map<String,String> config = new HashMap<>();
    config.put("cloud_name","dlyosjmsp");
    config.put("api_key","932671857212894");
    config.put("api_secret","ks07B67m0PeePVdgtjU3y8_0i-o");
    //config.put("","");
    return new Cloudinary(config);
  }
}
