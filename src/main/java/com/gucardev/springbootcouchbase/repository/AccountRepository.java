package com.gucardev.springbootcouchbase.repository;

import com.gucardev.springbootcouchbase.model.Account;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CouchbaseRepository<Account, String> {}
