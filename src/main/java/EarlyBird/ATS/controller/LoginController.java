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

import java.util.Optional;

@Controller
public class LoginController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public LoginController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String Main() {
        return "index";
    }

    @PostMapping("/")
    public String Join(JoinForm joinform, Model model) {
        Member member = new Member();
        member.setId(joinform.getId());
        member.setPassword(joinform.getPassword());
        member.setName(joinform.getName());
        member.setEmail(joinform.getEmail());
        if (joinform.getId() != null) {
            if (memberService.UniqueName(member) == 1) {
                model.addAttribute("flag", 1);
            } else
                memberService.join(member);
        }
        else {
            Member loginMember = new Member();
            loginMember.setId(joinform.getLoginId());
            loginMember.setPassword(joinform.getLoginPassword());
            System.out.println(loginMember.getId());
            Optional<Member> find_member = memberRepository.findById(loginMember.getId());
            if (find_member.isPresent()) {
                return "mypage";
            } else {
                model.addAttribute("noneId", 1);
            }
        }
        return "index";
    }
}
