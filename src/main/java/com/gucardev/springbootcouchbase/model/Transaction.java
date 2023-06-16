package com.gucardev.springbootcouchbase.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Getter
@Setter
@Document
public class Transaction {
  @Id private String id;

  @Field private String transactionId;

  @Field private String accountId;

  @Field private BigDecimal amount;

  @Field private String description;
}
