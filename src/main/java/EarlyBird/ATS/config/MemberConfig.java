package EarlyBird.ATS.config;

import EarlyBird.ATS.repository.MemberRepository;
import EarlyBird.ATS.repository.MemoryMemberRepository;
import EarlyBird.ATS.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class MemberConfig {

    DataSource dataSource;
    EntityManager em;


    public MemberConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(em);
    }
}