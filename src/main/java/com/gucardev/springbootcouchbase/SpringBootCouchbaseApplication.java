package com.gucardev.springbootcouchbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
@EnableCouchbaseRepositories(basePackages = {"com.gucardev.springbootcouchbase.repository"})
@ComponentScan(basePackages = "com.gucardev.springbootcouchbase")
public class SpringBootCouchbaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCouchbaseApplication.class, args);
  }

}
