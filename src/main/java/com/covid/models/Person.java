package com.covid.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

//import javax.validation.constraints.Email;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Person")
public class Person {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private String email;

    private String cpf;
    private Boolean isVaccinated;

}