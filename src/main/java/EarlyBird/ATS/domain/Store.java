package EarlyBird.ATS.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Store {

    private String id;
    private String businessName;
    private String storeName;
    private String type;
    private String address;
    private String detailAddress;
    private String phone;
    private List<String> positionIndex; // 차있는지 안차있는지도 체크
    private Long totalSeat;
    private String introduce;

}
