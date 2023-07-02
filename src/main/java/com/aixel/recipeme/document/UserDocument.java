package com.aixel.recipeme.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class UserDocument {

    @MongoId
    private String id;

    private String username;

    @NotNull(message = "The user must have a password")
    private String password;

    @NotNull(message = "The user must have an email")
    private String email;

    private Calendar dateOfBith;


}
