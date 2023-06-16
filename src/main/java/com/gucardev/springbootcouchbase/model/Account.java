package com.gucardev.springbootcouchbase.model;

import java.util.List;
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
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
  private String id;

  @Field private String accountNumber;

  @Field private String accountName;

  @Field private String userId;

  @Field private List<Transaction> transactions;
}
