package com.aixel.recipeme.repository;

import com.aixel.recipeme.document.GenreDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends MongoRepository<GenreDocument, String> {
}
