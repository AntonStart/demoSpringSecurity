package ge.pozdniakov.firstsecurityapp.services;

import ge.pozdniakov.firstsecurityapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonService personService, PasswordEncoder passwordEncoder) {
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personService.addNewPerson(person);
    }

}
