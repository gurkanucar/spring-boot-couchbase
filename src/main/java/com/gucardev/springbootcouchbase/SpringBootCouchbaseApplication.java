package com.gucardev.springbootcouchbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
@EnableCouchbaseRepositories(basePackages = {"com.gucardev.springbootcouchbase.repository"})
public class SpringBootCouchbaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCouchbaseApplication.class, args);
  }

}
