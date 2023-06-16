package com.gucardev.springbootcouchbase.service;

import com.gucardev.springbootcouchbase.dto.AccountDto;
import com.gucardev.springbootcouchbase.dto.request.CreateAccountRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateAccountRequest;
import com.gucardev.springbootcouchbase.mapper.AccountMapper;
import com.gucardev.springbootcouchbase.model.Account;
import com.gucardev.springbootcouchbase.model.Transaction;
import com.gucardev.springbootcouchbase.repository.AccountRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;
  private final UserService userService;
  private final TransactionService transactionService;

  public AccountService(
      AccountRepository accountRepository,
      AccountMapper accountMapper,
      UserService userService,
      @Lazy TransactionService transactionService) {
    this.accountRepository = accountRepository;
    this.accountMapper = accountMapper;
    this.userService = userService;
    this.transactionService = transactionService;
  }

  public boolean existsById(String id) {
    return accountRepository.existsById(id);
  }

  public AccountDto create(CreateAccountRequest request) {
    if (!userService.existsById(request.getUserId())) {
      throw new RuntimeException("User not found");
    }
    Account account = accountMapper.fromCreateRequest(request);
    Account savedAccount = accountRepository.save(account);
    return accountMapper.toDto(savedAccount);
  }

  public List<AccountDto> getAll() {
    List<Account> accounts = accountRepository.findAll();
    return accounts.stream()
        .map(accountMapper::toDtoIgnoreTransactions)
        .collect(Collectors.toList());
  }

  public AccountDto getById(String id) {
    Account account =
        accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

    List<Transaction> transactions = transactionService.getByAccountId(id);
    account.setTransactions(transactions);

    return accountMapper.toDto(account);
  }

  public AccountDto update(String id, UpdateAccountRequest request) {
    Account account =
        accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    accountMapper.fromUpdateRequest(request, account);
    Account updatedAccount = accountRepository.save(account);
    return accountMapper.toDto(updatedAccount);
  }

  public void delete(String id) {
    accountRepository.deleteById(id);
  }

  public List<Account> getByUserId(String userId) {
    return accountRepository.findByUserId(userId);
  }

  public List<AccountDto> getDtoByUserId(String userId) {
    return getByUserId(userId).stream()
        .map(accountMapper::toDtoIgnoreTransactions)
        .collect(Collectors.toList());
  }
}
