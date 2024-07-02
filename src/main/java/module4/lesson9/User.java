package module4.lesson9;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
public class User extends Person{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public User( String firstName, String lastName, String email, String phoneNumber) {
        super(null);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Builder(builderMethodName = "childBuilder")
    public User(String b) {
        super(b);
    }
}
