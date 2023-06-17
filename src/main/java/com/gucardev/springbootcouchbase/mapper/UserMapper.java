package com.gucardev.springbootcouchbase.mapper;

import com.gucardev.springbootcouchbase.dto.UserDto;
import com.gucardev.springbootcouchbase.dto.request.CreateUserRequest;
import com.gucardev.springbootcouchbase.dto.request.UpdateUserRequest;
import com.gucardev.springbootcouchbase.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {AccountMapper.class})
public interface UserMapper {

  @Mapping(target = "accounts", ignore = true)
  UserDto toDto(User user);

  // Explicitly tell MapStruct which method to use for mapping accounts
  @Mapping(target = "accounts", source = "accounts", qualifiedByName = "toDtoWithTransactions")
  UserDto toDtoWithAccounts(User user);

  User fromDto(UserDto userDto);

  @Mapping(target = "id", ignore = true)
  User fromCreateRequest(CreateUserRequest request);

  User fromUpdateRequest(UpdateUserRequest request, @MappingTarget User user);
}
