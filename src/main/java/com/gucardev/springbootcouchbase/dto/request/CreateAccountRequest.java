package com.gucardev.springbootcouchbase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
  private String accountNumber;
  private String accountName;
  private String userId;
}
