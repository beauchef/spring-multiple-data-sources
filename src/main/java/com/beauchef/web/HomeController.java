package com.beauchef.web;

import com.beauchef.service.UserService;
import com.beauchef.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author beauchef on 2016-11-17.
 */
@Controller
public class HomeController {

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private UserService userService;

  @RequestMapping("/")
  public String index(@RequestParam(value="config", required=false) String config, Model model) throws JsonProcessingException {
    if (config == null) {
      config = objectMapper.writeValueAsString(userService.getUsers());
    }
    model.addAttribute("config", config);
    return "index";
  }

}
