package webBoard.demo.repository;

import webBoard.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByUserId(String id);
    Optional<Member> findByNick(String nickName);
    List<Member> findAll();
}
