package webBoard.demo.repository;

import org.springframework.stereotype.Repository;
import webBoard.demo.domain.Member;

import java.util.*;
@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return store.values().stream()
                .filter(member -> member.getUserId().equals(userId))
                .findAny();
    }

    @Override
    public Optional<Member> findByNick(String nickName) {
        return store.values().stream()
                .filter(member -> member.getNickName().equals(nickName))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
