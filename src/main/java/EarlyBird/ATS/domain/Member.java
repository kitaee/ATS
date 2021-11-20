package EarlyBird.ATS.domain;

import lombok.Getter;
import lombok.Setter;



@Setter @Getter
public class Member {

    private Long type;
    private String id;
    private String password;
    private String name;
    private String email;
}
