package com.gucardev.springbootcouchbase.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTransactionRequest {
  private String transactionId;
  private String accountId;
  private BigDecimal amount;
  private String description;
}
