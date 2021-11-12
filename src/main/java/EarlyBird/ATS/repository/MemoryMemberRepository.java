package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private final EntityManager em;
    long sequence = 0L;

    @Autowired
    public MemoryMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        member.setCount(++sequence);
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findId(String name) {
        Member member = em.find(Member.class,name);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findPassword(String id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> result = em.createQuery("select m from Member m where m.id = :id",Member.class)
                .setParameter("id",id)
                .getResultList();
        return result.stream().findAny();
    }
}
