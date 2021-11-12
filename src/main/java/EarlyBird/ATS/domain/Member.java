package EarlyBird.ATS.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter @Getter
public class Member {

    @Id
    private Long count;
    private String id;
    private String password;
    private String name;
    private String email;
}
