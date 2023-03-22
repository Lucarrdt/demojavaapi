package Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UsersEntity {
    @Id
    @GeneratedValue
    private int UserId;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
}
