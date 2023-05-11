package com.example.sample.service;

import com.example.sample.model.Okta;
import com.example.sample.repository.OktaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class OktaService {
    @Autowired
    private OktaRepo repository;
    public Okta addTask(OAuth2AuthenticationToken authentication) {
//        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        Okta okta=new Okta();
        okta.setName(authentication.getPrincipal().getAttributes().get("name").toString());
      okta.setEmail(authentication.getPrincipal().getAttributes().get("email").toString());
        return repository.save(okta);
    }
}
