package ge.pozdniakov.firstsecurityapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final PersonService personService;

    @Autowired
    public AdminService(PersonService personService) {
        this.personService = personService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePersonFromUserName(String username){
        personService.deletePerson(username);
    }

    //аннотация пускает к выполнению метода только пользователеё с ролью ADMIN
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdminStuff(){
        System.out.println("Only admin here");
    }
}
