package com.gucardev.springbootcouchbase.service;

import com.gucardev.springbootcouchbase.dto.UserDto;
import com.gucardev.springbootcouchbase.dto.request.CreateUserRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateUserRequest;
import com.gucardev.springbootcouchbase.mapper.UserMapper;
import com.gucardev.springbootcouchbase.model.Account;
import com.gucardev.springbootcouchbase.model.User;
import com.gucardev.springbootcouchbase.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final AccountService accountService;

  public UserService(
      UserRepository userRepository, UserMapper userMapper, @Lazy AccountService accountService) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.accountService = accountService;
  }

  public UserDto create(CreateUserRequest request) {
    User user = userMapper.fromCreateRequest(request);
    User savedUser = userRepository.save(user);
    return userMapper.toDto(savedUser);
  }

  public UserDto getById(String id) {
    User user =
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    List<Account> accounts = accountService.getByUserId(id);

    user.setAccounts(accounts);

    return userMapper.toDtoWithAccounts(user);
  }

  public List<UserDto> getAll() {
    return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
  }

  public UserDto update(String id, UpdateUserRequest request) {
    User user =
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    userMapper.fromUpdateRequest(request, user);
    User updatedUser = userRepository.save(user);
    return userMapper.toDto(updatedUser);
  }

  public void delete(String id) {
    userRepository.deleteById(id);
  }

  public boolean existsById(String id) {
    return userRepository.existsById(id);
  }

  public boolean existsByName(String name) {
    return userRepository.existsByName(name);
  }
}
