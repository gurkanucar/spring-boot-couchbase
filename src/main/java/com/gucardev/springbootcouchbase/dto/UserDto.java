package com.gucardev.springbootcouchbase.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  private String id;
  private String name;
  private String email;
  private List<AccountDto> accounts;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
