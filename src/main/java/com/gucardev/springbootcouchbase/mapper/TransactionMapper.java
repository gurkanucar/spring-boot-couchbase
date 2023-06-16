package com.gucardev.springbootcouchbase.mapper;

import com.gucardev.springbootcouchbase.dto.TransactionDto;
import com.gucardev.springbootcouchbase.dto.request.CreateTransactionRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateTransactionRequest;
import com.gucardev.springbootcouchbase.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

  TransactionDto toDto(Transaction transaction);

  Transaction fromDto(TransactionDto transactionDto);

  @Mapping(target = "id", ignore = true)
  Transaction fromCreateRequest(CreateTransactionRequest request);

  Transaction fromUpdateRequest(
      UpdateTransactionRequest request, @MappingTarget Transaction transaction);
}
