package com.gucardev.springbootcouchbase.mapper;

import com.gucardev.springbootcouchbase.dto.AccountDto;
import com.gucardev.springbootcouchbase.dto.request.CreateAccountRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateAccountRequest;
import com.gucardev.springbootcouchbase.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(
    componentModel = "spring",
    uses = {TransactionMapper.class})
public interface AccountMapper {

  @Named("toDtoWithTransactions")
  AccountDto toDto(Account account);

  @Mapping(target = "transactions", ignore = true)
  AccountDto toDtoIgnoreTransactions(Account account);

  Account fromDto(AccountDto accountDto);

  @Mapping(target = "id", ignore = true)
  Account fromCreateRequest(CreateAccountRequest request);

  Account fromUpdateRequest(UpdateAccountRequest request, @MappingTarget Account account);
}
