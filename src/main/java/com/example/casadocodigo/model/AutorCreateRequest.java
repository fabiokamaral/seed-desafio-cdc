package com.example.casadocodigo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import validators.UniqueValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorCreateRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be a valid format")
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 400, message = "Description must be less than 400 characters")
    private String description;

    public Autor toModel() {
        return Autor.builder()
                .name(this.name)
                .email(this.email)
                .description(this.description)
                .build();
    }

}
