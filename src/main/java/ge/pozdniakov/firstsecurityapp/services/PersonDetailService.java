package ge.pozdniakov.firstsecurityapp.services;

import ge.pozdniakov.firstsecurityapp.models.Person;
import ge.pozdniakov.firstsecurityapp.repositories.PersonRepository;
import ge.pozdniakov.firstsecurityapp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User with name " + username + "is not found!");
        return new PersonDetails(person.get());
    }
}
