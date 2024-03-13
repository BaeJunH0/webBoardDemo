package webBoard.demo.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import webBoard.demo.domain.Member;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAMemberRepository implements MemberRepository{
    private final EntityManager em;
    public JPAMemberRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByUserId(String userid) {
        List<Member> result = em.createQuery("select m from Member m where m.userid = :userid", Member.class)
                .setParameter("userid", userid)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByNick(String nickName) {
        List<Member> result = em.createQuery("select m from Member m where m.nickname = :nickName", Member.class)
                .setParameter("nickName", nickName)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
