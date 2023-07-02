package com.aixel.recipeme.controller;

import com.aixel.recipeme.core.CrudController;
import com.aixel.recipeme.document.GenreDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/genre")
@RequiredArgsConstructor
public class GenreController extends CrudController<GenreDocument, String> {



}
