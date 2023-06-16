package com.gucardev.springbootcouchbase.controller;

import com.gucardev.springbootcouchbase.dto.UserDto;
import com.gucardev.springbootcouchbase.dto.request.CreateUserRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateUserRequest;
import com.gucardev.springbootcouchbase.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public UserDto create(@RequestBody CreateUserRequest request) {
    return userService.create(request);
  }

  @GetMapping
  public List<UserDto> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  public UserDto getById(@PathVariable String id) {
    return userService.getById(id);
  }

  @PutMapping("/{id}")
  public UserDto update(@PathVariable String id, @RequestBody UpdateUserRequest request) {
    return userService.update(id, request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    userService.delete(id);
  }
}
