package com.hhh.order.controller;

import com.hhh.order.config.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhh
 * @date 2020/2/25 15:38
 * @description
 */
@RestController
@RequestMapping("/v1")
public class PropertiesController {

  private final ProjectProperties projectProperties;

  @Autowired
  public PropertiesController(ProjectProperties projectProperties) {
    this.projectProperties = projectProperties;
  }

  @GetMapping("/get-properties")
  public String getProperties(){
    return projectProperties.getName()+" "+projectProperties.getUrl();
  }
}
