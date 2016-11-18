package com.beauchef.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beauchef on 2016-11-18.
 */
@Configuration
public class DatabaseConfig {

  @Bean(name = "dataSources")
  @Autowired
  public List<DriverManagerDataSource> dataSources(DataSourceList dataSourceList) {
    List<DriverManagerDataSource> dataSources = new ArrayList<>();
    for (String url : dataSourceList.getUrls()) {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(dataSourceList.getDriverClassName());
      dataSource.setUsername(dataSourceList.getUsername());
      dataSource.setPassword(dataSourceList.getPassword());
      dataSource.setUrl(url);
      dataSources.add(dataSource);
    }
    return dataSources;
  }

}
