package com.gucardev.springbootcouchbase;

import com.gucardev.springbootcouchbase.dto.AccountDto;
import com.gucardev.springbootcouchbase.dto.UserDto;
import com.gucardev.springbootcouchbase.dto.request.CreateAccountRequest;
import com.gucardev.springbootcouchbase.dto.request.CreateTransactionRequest;
import com.gucardev.springbootcouchbase.dto.request.CreateUserRequest;
import com.gucardev.springbootcouchbase.service.AccountService;
import com.gucardev.springbootcouchbase.service.TransactionService;
import com.gucardev.springbootcouchbase.service.UserService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitialDataLoader {
  private final UserService userService;
  private final AccountService accountService;
  private final TransactionService transactionService;

  public InitialDataLoader(
      UserService userService,
      AccountService accountService,
      TransactionService transactionService) {
    this.userService = userService;
    this.accountService = accountService;
    this.transactionService = transactionService;
  }

  @PostConstruct
  public void loadInitialData() {
    List<String> names = Arrays.asList("gurkan", "ali", "metin", "sezai", "kartal");

    if (userService.existsByName(names.get(0))) {
      return;
    }

    Random rnd = new Random();
    names.forEach(
        name -> {
          CreateUserRequest userRequest = new CreateUserRequest();
          userRequest.setName(name);
          userRequest.setEmail(name + "@example.com");
          UserDto userDto = userService.create(userRequest);

          for (int i = 0; i < 3; i++) {
            CreateAccountRequest accountRequest = new CreateAccountRequest();
            accountRequest.setUserId(userDto.getId());
            accountRequest.setAccountName(name + "'s account " + (i + 1));
            accountRequest.setAccountNumber("ACC_" + (i + 1));
            AccountDto accountDto = accountService.create(accountRequest);

            for (int j = 0; j < 5; j++) {
              CreateTransactionRequest transactionRequest = new CreateTransactionRequest();
              transactionRequest.setAccountId(accountDto.getId());
              transactionRequest.setTransactionId("TRANSACT_" + (j + 1));
              transactionRequest.setDescription("Transaction " + (j + 1));
              transactionRequest.setAmount(new BigDecimal(10 * (rnd.nextInt(50) + 1)));
              transactionService.create(transactionRequest);
            }
          }
        });

    log.info(Arrays.toString(userService.getAll().toArray()));
  }
}
