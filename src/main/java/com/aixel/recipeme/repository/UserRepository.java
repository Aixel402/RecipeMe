package com.aixel.recipeme.repository;

import com.aixel.recipeme.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, Long> {

}
