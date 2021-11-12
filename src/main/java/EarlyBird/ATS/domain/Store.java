package EarlyBird.ATS.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Store {

    @Id
    private Long count;
    private String businessName;
    private String storeName;
    private String type;
    private String address;
    private String detailAddress;
    private String phone;

}
