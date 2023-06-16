package com.gucardev.springbootcouchbase.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
  private String id;
  private String accountNumber;
  private String accountName;
  private String userId;
  private List<TransactionDto> transactions;
}
