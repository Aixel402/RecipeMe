package com.aixel.recipeme.core;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@NoArgsConstructor
public abstract class CrudController<E, ID> {

    protected CrudService<E, ID> crudService;

    @Autowired
    protected void setCrudService(final CrudService<E, ID> crudService) {
        this.crudService = crudService;
    }

    @PostMapping(value = {"/"})
    public E insert(@RequestBody final E object) {
        return crudService.insert(object);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<E> findById(@NotNull @PathVariable final ID id) {
        try {
            return new ResponseEntity<>(crudService.findById(id), HttpStatus.OK);
        } catch (ClassNotFoundException ignored) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = {"/{id}"})
    public ResponseEntity<E> update(@PathVariable final ID id, @RequestBody final E object) {
        try {
            return new ResponseEntity<>(crudService.update(object), HttpStatus.OK);
        } catch (Exception ignored) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<E> put(@PathVariable final ID id, @RequestBody final E object) {
        return null;
    }
}
