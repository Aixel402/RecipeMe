package com.aixel.recipeme.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class GenreDocument {

    @MongoId
    private String id;

    private String title;

    private String description;

}
