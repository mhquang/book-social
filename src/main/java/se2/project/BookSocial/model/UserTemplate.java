package se2.project.BookSocial.model;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserTemplate {
    @Length(min = 6, max = 25)
    private String username;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,60}$",
            message = "6 chars min (at least 1" +
                    "digit & 1 uppercase letter)")
    private String password;

    @Length(min = 3, max = 30)
    private String fullname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
