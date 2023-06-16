package com.gucardev.springbootcouchbase.service;

import com.gucardev.springbootcouchbase.dto.TransactionDto;
import com.gucardev.springbootcouchbase.dto.request.CreateTransactionRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateTransactionRequest;
import com.gucardev.springbootcouchbase.mapper.TransactionMapper;
import com.gucardev.springbootcouchbase.model.Transaction;
import com.gucardev.springbootcouchbase.repository.TransactionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
  private final AccountService accountService;

  public TransactionService(
      TransactionRepository transactionRepository,
      TransactionMapper transactionMapper,
      AccountService accountService) {
    this.transactionRepository = transactionRepository;
    this.transactionMapper = transactionMapper;
    this.accountService = accountService;
  }

  public TransactionDto create(CreateTransactionRequest request) {
    if (!accountService.existsById(request.getAccountId())) {
      throw new RuntimeException("Account not found");
    }
    Transaction transaction = transactionMapper.fromCreateRequest(request);
    Transaction savedTransaction = transactionRepository.save(transaction);
    return transactionMapper.toDto(savedTransaction);
  }

  public List<TransactionDto> getAll() {
    List<Transaction> transactions = transactionRepository.findAll();
    return transactions.stream().map(transactionMapper::toDto).collect(Collectors.toList());
  }

  public TransactionDto getById(String id) {
    Transaction transaction =
        transactionRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found"));
    return transactionMapper.toDto(transaction);
  }

  public TransactionDto update(String id, UpdateTransactionRequest request) {
    Transaction transaction =
        transactionRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found"));
    transactionMapper.fromUpdateRequest(request, transaction);
    Transaction updatedTransaction = transactionRepository.save(transaction);
    return transactionMapper.toDto(updatedTransaction);
  }

  public void delete(String id) {
    transactionRepository.deleteById(id);
  }

  public List<Transaction> getByAccountId(String accountId) {
    return transactionRepository.findByAccountId(accountId);
  }

  public List<TransactionDto> getDtoByAccountId(String accountId) {
    List<Transaction> transactions = getByAccountId(accountId);
    return transactions.stream().map(transactionMapper::toDto).collect(Collectors.toList());
  }
}
