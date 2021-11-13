package EarlyBird.ATS.controller;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;
import EarlyBird.ATS.form.StoreForm;
import EarlyBird.ATS.service.StoreService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/registerStore")
    public String registerStoreView(){
        return "registerStore";
    }

    @PostMapping("/registerStore")
    public String registerStore(StoreForm storeForm, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        Store store = new Store();
        store.setBusinessName(storeForm.getBusinessName());
        store.setStoreName(storeForm.getStoreName());
        store.setType(storeForm.getType());
        store.setAddress(storeForm.getAddress());
        store.setDetailAddress(storeForm.getDetailAddress());
        store.setPhone(storeForm.getPhone());

        storeService.register(store);
        model.addAttribute("member", member.getName());
        return "mypage";
    }
}
