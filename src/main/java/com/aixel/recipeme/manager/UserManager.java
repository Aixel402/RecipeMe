package com.aixel.recipeme.manager;

import com.aixel.recipeme.core.exceptions.ValidationException;
import com.aixel.recipeme.document.UserDocument;
import lombok.SneakyThrows;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class UserManager {

    @SneakyThrows
    public void validateInsert(final UserDocument user) {
        StringBuilder error = new StringBuilder();

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            error.append("Username not valid\n");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            error.append("Email not valid\n");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            error.append("Password not valid\n");
        }

        if (!error.isEmpty()) {
            throw new ValidationException(error.toString());
        }
    }
}
