package com.gucardev.springbootcouchbase.repository;

import com.gucardev.springbootcouchbase.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {}
