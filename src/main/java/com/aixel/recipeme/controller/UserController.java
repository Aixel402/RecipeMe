package com.aixel.recipeme.controller;

import com.aixel.recipeme.core.CrudController;
import com.aixel.recipeme.document.UserDocument;
import com.aixel.recipeme.manager.UserManager;
import com.aixel.recipeme.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController extends CrudController<UserDocument, String> {

    private final UserService userService;

    private final UserManager userManager;

    @Override
    @PostMapping(value = {"/"})
    @SneakyThrows
    public ResponseEntity<UserDocument> insert(@Valid @RequestBody final UserDocument user) {
        userManager.validateInsert(user);
        return new ResponseEntity<>(crudService.insert(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDocument>> getMovies() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
