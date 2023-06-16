package com.gucardev.springbootcouchbase.controller;

import com.gucardev.springbootcouchbase.dto.TransactionDto;
import com.gucardev.springbootcouchbase.dto.request.CreateTransactionRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateTransactionRequest;
import com.gucardev.springbootcouchbase.service.TransactionService;
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
@RequestMapping("/transaction")
public class TransactionController {
  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping
  public TransactionDto create(@RequestBody CreateTransactionRequest request) {
    return transactionService.create(request);
  }

  @GetMapping
  public List<TransactionDto> getAll() {
    return transactionService.getAll();
  }

  @GetMapping("/{id}")
  public TransactionDto getById(@PathVariable String id) {
    return transactionService.getById(id);
  }

  @PutMapping("/{id}")
  public TransactionDto update(
      @PathVariable String id, @RequestBody UpdateTransactionRequest request) {
    return transactionService.update(id, request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    transactionService.delete(id);
  }

  @GetMapping("/account/{accountId}")
  public List<TransactionDto> getByAccountId(@PathVariable String accountId) {
    return transactionService.getDtoByAccountId(accountId);
  }
}
