package com.aixel.recipeme.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@Service
@NoArgsConstructor
public abstract class CrudService<E, ID> {

    protected MongoTemplate mongoTemplate;

    protected MongoDatabase mongoDatabase;

    @Autowired
    public void setMongoTemplate(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        if (mongoTemplate != null) {
            setMongoDatabase(mongoTemplate.getDb());
        }
    }

    public void setMongoDatabase(final MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public E insert(final E object) {
        return mongoTemplate.insert(object);
    }

    public E findById(final ID id) throws ClassNotFoundException {
        return mongoTemplate.findById(id, getClazz());
    }

    public E update(final E object) {
        return mongoTemplate.save(object);
    }

    public E update(final ID id, final E object) throws ClassNotFoundException {
        Query query = new Query().addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        //missing update set
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(object, Map.class);
        for (String key : map.keySet()) {
            update = update.addToSet(key, map.get(key));
        }
        return mongoTemplate.findAndModify(query, update, getClazz());
    }

    private Class<E> getClazz() throws ClassNotFoundException {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type t = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        return (Class<E>) Class.forName(t.getTypeName());
    }
}
