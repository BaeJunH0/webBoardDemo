package webBoard.demo.service;

import webBoard.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    String join(Member member);
    List<Member> findMembers();
    Optional<Member> findOne(String id);
    void checkingDuplicate(Member member);
}
