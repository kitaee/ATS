package EarlyBird.ATS.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StoreForm {

    private String id;
    private String businessName;
    private String storeName;
    private String type;
    private String address;
    private String detailAddress;
    private String phone;
    private List<String> positionIndex;
    private Long totalSeat;
}
