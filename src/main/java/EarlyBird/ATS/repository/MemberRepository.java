package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findId(String name);
    Optional<Member> findPassword(String id);
    Optional<Member> findById(String id);
}
