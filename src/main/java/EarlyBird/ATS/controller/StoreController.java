package EarlyBird.ATS.controller;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;
import EarlyBird.ATS.form.StoreForm;
import EarlyBird.ATS.service.StoreService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/addStore")
    public String registerStoreView(Model model) throws IOException {
        return "addStore";
    }

//    @PostMapping("/addStore")
//    public String registerStore(StoreForm storeForm, HttpServletRequest request, Model model){
//        HttpSession session = request.getSession();
//        Member member = (Member)session.getAttribute("member");
//        Store store = new Store();
//        store.setBusinessName(storeForm.getBusinessName());
//        store.setStoreName(storeForm.getStoreName());
//        store.setType(storeForm.getType());
//        store.setAddress(storeForm.getAddress());
//        store.setDetailAddress(storeForm.getDetailAddress());
//        store.setPhone(storeForm.getPhone());
//
//        storeService.register(store);
//        model.addAttribute("member",member.getName());
//
//        return "mypage";
//    }

    @RequestMapping(value = "/addStore", method = { RequestMethod.POST })
    public String test(@RequestParam("totalSeat") Long totalSeat , @RequestParam("positionIndex") List<String> positionIndex,
                     StoreForm storeForm, @RequestParam("businessName") String businessName,
                     @RequestParam("storeName") String storeName,
                     @RequestParam("phone") String phone,
                     @RequestParam("introduce") String introduce,
                     @RequestParam("type") String type,
                     @RequestParam("address") String address,
                     @RequestParam("detailAddress") String detailAddress,
                     HttpServletRequest request, Model model) throws  Exception{

//        System.out.println(totalSeat);
//        for(int i=0;i<positionIndex.size();i++){
//            System.out.println(positionIndex.get(i));
//        }

        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");

//        Thread.sleep(3000);
        Store store = new Store();
        store.setId(member.getId());
        store.setBusinessName(businessName);
        store.setStoreName(storeName);
        store.setIntroduce(introduce);
        store.setPhone(phone);
        store.setTotalSeat(totalSeat);
        store.setAddress(address);
        store.setType(type);
        store.setDetailAddress(detailAddress);
        store.setPositionIndex(positionIndex);
        storeService.register(store);

        return "mypage";
    }
}