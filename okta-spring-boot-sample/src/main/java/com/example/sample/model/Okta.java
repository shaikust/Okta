package com.example.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "okta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Okta {
    @Id
    private  String id;
private String name;
private String email;

}
