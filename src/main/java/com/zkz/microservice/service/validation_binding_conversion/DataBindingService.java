package com.zkz.microservice.service.validation_binding_conversion;

import com.zkz.microservice.dto.Company;
import com.zkz.microservice.dto.Employee;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * @author Jason Zhuang
 * @created 2024.03.24 13:42
 * @project SpringbootMicroservicesTemplate
 * @description:
 * Reference:
 * https://docs.spring.io/spring-framework/reference/core/validation/beans-beans.html
 */
public class DataBindingService {

    // Manipulate == operation 操作
    private void  retrieveAndManipulateProperties(){
        BeanWrapper company = new BeanWrapperImpl(new Company());
        // setting the company name..
        company.setPropertyValue("name", "Some Company Inc.");

        // ... can also be done like this:
        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);

        // ok, let's create the director and tie it to the company:
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        // retrieving the salary of the managingDirector through the company
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
    }

    private void handlePropertyEditor() {
        // https://docs.spring.io/spring-framework/reference/core/validation/beans-beans.html#beans-beans-conversion
    }
}
