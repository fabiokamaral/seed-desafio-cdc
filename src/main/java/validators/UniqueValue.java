package validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueValue {
    String message() default "{com.example.casadocodigo.beanValidation.UniqueValue}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
