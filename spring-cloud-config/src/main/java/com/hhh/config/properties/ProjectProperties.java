package com.hhh.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2020/2/23 13:57
 * @description
 */
@Data
@RefreshScope
@Component
@ConfigurationProperties("project")
public class ProjectProperties {
  private String name;
  private String version;
}
