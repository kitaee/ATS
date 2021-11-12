package EarlyBird.ATS.service;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    public int UniqueName(Member member){
        Optional<Member> result = memberRepository.findById(member.getId());
        if(result.isPresent())
            return 1;
        else return 0;
    }
    public Optional<Member> findMember(String id){
        Member member = new Member();
        member = memberRepository.findById(id).get();
        return Optional.ofNullable(member);
    }
}
