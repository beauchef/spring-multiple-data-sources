package com.beauchef.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;

/**
 * @author beauchef on 2016-11-18.
 */
@Data
@Configuration
@ConfigurationProperties("multi.database")
public class DataSourceList implements Serializable {

  private static final long serialVersionUID = 84593420054847766L;

  private String driverClassName;
  private String username;
  private String password;
  private List<String> urls;

}
