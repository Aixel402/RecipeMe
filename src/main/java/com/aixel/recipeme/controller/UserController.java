package com.aixel.recipeme.controller;

import com.aixel.recipeme.core.CrudController;
import com.aixel.recipeme.document.UserDocument;
import com.aixel.recipeme.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController extends CrudController<UserDocument, String> {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDocument>> getMovies() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
