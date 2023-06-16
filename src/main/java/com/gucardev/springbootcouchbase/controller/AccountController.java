package com.gucardev.springbootcouchbase.controller;

import com.gucardev.springbootcouchbase.dto.AccountDto;
import com.gucardev.springbootcouchbase.dto.request.CreateAccountRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateAccountRequest;
import com.gucardev.springbootcouchbase.service.AccountService;
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
@RequestMapping("/account")
public class AccountController {
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  public AccountDto create(@RequestBody CreateAccountRequest request) {
    return accountService.create(request);
  }

  @GetMapping
  public List<AccountDto> getAll() {
    return accountService.getAll();
  }

  @GetMapping("/{id}")
  public AccountDto getById(@PathVariable String id) {
    return accountService.getById(id);
  }

  @PutMapping("/{id}")
  public AccountDto update(@PathVariable String id, @RequestBody UpdateAccountRequest request) {
    return accountService.update(id, request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    accountService.delete(id);
  }

  @GetMapping("/user/{userId}")
  public List<AccountDto> getByUserId(@PathVariable String userId) {
    return accountService.getDtoByUserId(userId);
  }
}
