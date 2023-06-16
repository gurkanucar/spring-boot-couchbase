package com.gucardev.springbootcouchbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

  @Value("${spring.couchbase.connection-string}")
  private String connectionString;

  @Value("${spring.couchbase.username}")
  private String userName;

  @Value("${spring.couchbase.password}")
  private String password;

  @Value("${spring.couchbase.bucket.name}")
  private String bucketName;

  @Override
  public String getConnectionString() {
    return this.connectionString;
  }

  @Override
  public String getUserName() {
    return this.userName;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getBucketName() {
    return this.bucketName;
  }
}
