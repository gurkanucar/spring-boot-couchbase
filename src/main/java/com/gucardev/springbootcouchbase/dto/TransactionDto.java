package com.gucardev.springbootcouchbase.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
  private String id;
  private String transactionId;
  private String accountId;
  private BigDecimal amount;
  private String description;
}
