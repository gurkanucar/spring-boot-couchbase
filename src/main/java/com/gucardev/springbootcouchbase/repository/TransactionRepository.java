package com.gucardev.springbootcouchbase.repository;

import com.gucardev.springbootcouchbase.model.Transaction;
import java.util.List;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CouchbaseRepository<Transaction, String> {
  List<Transaction> findByAccountId(String accountId);
}
