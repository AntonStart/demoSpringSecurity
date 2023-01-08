package ge.pozdniakov.firstsecurityapp.services;

import ge.pozdniakov.firstsecurityapp.models.Person;
import ge.pozdniakov.firstsecurityapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PersonService personService;

    @Autowired
    public RegistrationService(PersonService personService) {
        this.personService = personService;
    }

    @Transactional
    public void register(Person person){
        System.out.println("begin register");
        personService.addNewPerson(person);
        System.out.println("end register");
    }

}
