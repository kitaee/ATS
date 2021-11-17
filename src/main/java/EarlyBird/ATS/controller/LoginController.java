package EarlyBird.ATS.controller;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.form.JoinForm;
import EarlyBird.ATS.repository.MemberRepository;
import EarlyBird.ATS.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public LoginController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String Main(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        if(member==null){
            return "index";
        }
        else{
            model.addAttribute("member", member.getName());
            return "mypage";
        }
    }

    @PostMapping("/")
    public String Join(JoinForm joinform, Model model, HttpServletRequest request) throws Exception{
        Member member = new Member();
        member.setId(joinform.getId());
        member.setPassword(joinform.getPassword());
        member.setName(joinform.getName());
        member.setEmail(joinform.getEmail());
        member.setType(1L);
        if (joinform.getId() != null) {  //회원가입 창
            if (memberService.UniqueName(member) == 1) {
                model.addAttribute("flag", 1);
            } else
                memberService.join(member);
        }
        else {
            Member loginMember = new Member();
            loginMember.setId(joinform.getLoginId());
            loginMember.setPassword(joinform.getLoginPassword());
            Optional<Member> find_member = memberService.findMember(loginMember.getId());
            if (find_member.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute("member", find_member.get());
                model.addAttribute("member", find_member.get().getName());
                return "mypage";
            } else {
                model.addAttribute("noneId", 1);
            }
        }
        return "index";
    }

    //    @RequestMapping(value="/mypage", method={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/mypage")
    public String myPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        if(member==null){
            System.out.println(member.getName());
            return "index";
        }
        else{
            model.addAttribute("member", member.getName());
            model.addAttribute("memberId",member.getId());
            return "mypage";
        }
    }
}