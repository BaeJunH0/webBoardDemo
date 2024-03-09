package webBoard.demo.service;

import org.springframework.stereotype.Service;
import webBoard.demo.domain.Member;
import webBoard.demo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String join(Member member) {
        checkingDuplicate(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findOne(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public void checkingDuplicate(Member member) {
        memberRepository.findByNick(member.getNickName())
                .ifPresent(m -> {
                    System.out.println("Error Occur");
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}