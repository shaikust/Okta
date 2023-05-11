package com.example.sample.repository;

import com.example.sample.model.Okta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OktaRepo extends MongoRepository<Okta,String> {

}
