package com.example.casadocodigo.controller;

import com.example.casadocodigo.model.Autor;
import com.example.casadocodigo.model.AutorCreateRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/autores")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid AutorCreateRequest autorCreateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        Autor autor = autorCreateRequest.toModel();
        entityManager.persist(autor);
        return ResponseEntity.ok(autor.toString());
    }
}
