package com.beauchef.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author beauchef on 2016-11-18.
 */
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 63073537332475028L;

  private Long id;
  private String email;
  private String firstName;
  private String lastName;

}
