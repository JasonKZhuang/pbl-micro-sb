package com.zkz.microservice.service.validation_binding_conversion;

import com.zkz.microservice.dto.Person;
import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    /**
     * This Validator validates only Person instances
     */
    public boolean supports(@NonNull Class clazz) {
        return Person.class.equals(clazz);
    }

    public void validate(@NonNull Object obj, @NonNull Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old");
        }
    }
}