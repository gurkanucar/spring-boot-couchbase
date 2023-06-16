package com.gucardev.springbootcouchbase.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
  private String name;
  private String email;
}
