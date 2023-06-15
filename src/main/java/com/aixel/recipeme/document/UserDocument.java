package com.aixel.recipeme.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class UserDocument {

    @Id
    private Long id;

    private String username;

    @NotNull(message = "The user must have a password")
    private String password;

    @NotNull(message = "The user must have an email")
    private String email;
}
