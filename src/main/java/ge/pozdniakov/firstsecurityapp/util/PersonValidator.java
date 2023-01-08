package ge.pozdniakov.firstsecurityapp.util;

import ge.pozdniakov.firstsecurityapp.models.Person;
import ge.pozdniakov.firstsecurityapp.services.PersonDetailService;
import ge.pozdniakov.firstsecurityapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;
    private final PersonDetailService personDetailService;

    @Autowired
    public PersonValidator(PersonService personService, PersonDetailService personDetailService) {
        this.personService = personService;
        this.personDetailService = personDetailService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Person person = (Person) target;

        if (personService.findByUserName(person.getUsername()).isEmpty()){
            System.out.println("validation username complete");
            return;
        }

        errors.rejectValue("username", "", "Duplicate userName");
    }
}
