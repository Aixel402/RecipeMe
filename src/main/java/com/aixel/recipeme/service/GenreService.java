package com.aixel.recipeme.service;

import com.aixel.recipeme.core.CrudService;
import com.aixel.recipeme.document.GenreDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService extends CrudService<GenreDocument, String> {

}
