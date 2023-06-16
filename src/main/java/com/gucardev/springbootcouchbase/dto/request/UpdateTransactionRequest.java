package com.gucardev.springbootcouchbase.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTransactionRequest {
  private String description;
  private BigDecimal amount;
}
