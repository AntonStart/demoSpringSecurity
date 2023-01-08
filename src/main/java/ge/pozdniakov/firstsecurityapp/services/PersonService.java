package ge.pozdniakov.firstsecurityapp.services;

import ge.pozdniakov.firstsecurityapp.models.Person;
import ge.pozdniakov.firstsecurityapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findByUserName(String username){
        return personRepository.findByUsername(username);
    }

    @Transactional
    public void addNewPerson(Person person) {
        System.out.println("begin save person");
        personRepository.save(person);
        System.out.println("end save person");
    }
}
