package ge.pozdniakov.firstsecurityapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationDTO {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 6,max = 30, message = "Name should be between 6 and 30 characters")
    private String userName;

    @Min(value = 1900, message = "Year of birt should be more than 1900")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
