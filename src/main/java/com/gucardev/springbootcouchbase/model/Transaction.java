package com.gucardev.springbootcouchbase.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Getter
@Setter
@Document
@NoArgsConstructor
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
  private String id;

  @Field private String transactionId;

  @Field private String accountId;

  @Field private BigDecimal amount;

  @Field private String description;
}
