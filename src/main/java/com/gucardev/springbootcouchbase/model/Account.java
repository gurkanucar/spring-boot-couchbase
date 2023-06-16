package com.gucardev.springbootcouchbase.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Getter
@Setter
@Document
public class Account {
  @Id private String id;

  @Field private String accountNumber;

  @Field private String userId;

  @Field private List<Transaction> transactions;
}
