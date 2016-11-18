package com.beauchef.service.impl;

import com.beauchef.data.MultiDataSourceJdbcTemplate;
import com.beauchef.domain.User;
import com.beauchef.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author beauchef on 2016-11-18.
 */
@Service
public class UserServiceImpl implements UserService {

  private MultiDataSourceJdbcTemplate jdbcTemplate;

  private RowMapper<User> mapper = (rs, rowNum) -> {
    User user = new User();
    user.setId(rs.getLong("id"));
    user.setEmail(rs.getString("email"));
    user.setFirstName(rs.getString("first_name"));
    user.setLastName(rs.getString("last_name"));
    return user;
  };

  @Autowired
  public UserServiceImpl(List<DriverManagerDataSource> dataSources) {
    this.jdbcTemplate = new MultiDataSourceJdbcTemplate(dataSources);
  }

  @Override
  public List<User> getUsers() {
    return jdbcTemplate.query("select id, email, first_name, last_name from users", this.mapper);
  }

}
