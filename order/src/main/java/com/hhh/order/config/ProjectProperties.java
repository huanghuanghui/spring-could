package com.hhh.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2020/2/25 15:37
 * @description
 */
@ConfigurationProperties(prefix = "project")
@Data
@Component
@RefreshScope
public class ProjectProperties {
  private String name;
  private String url;
}
