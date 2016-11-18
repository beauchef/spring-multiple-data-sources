package com.beauchef.data;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author beauchef on 2016-11-18.
 */
public class MultiDataSourceJdbcTemplate {

  private List<JdbcTemplate> jdbcTemplates;

  public MultiDataSourceJdbcTemplate(List<DriverManagerDataSource> dataSources) {
    this.jdbcTemplates = dataSources.stream().map(ds -> new JdbcTemplate(ds)).collect(Collectors.toList());
  }

  public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
    List<T> result = new ArrayList<>();
    for (JdbcTemplate jdbcTemplate : this.jdbcTemplates) {
      result.addAll(jdbcTemplate.query(sql, rowMapper));
    }
    return result;
  }

}
