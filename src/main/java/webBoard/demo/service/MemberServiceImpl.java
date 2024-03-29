package webBoard.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webBoard.demo.domain.Member;
import webBoard.demo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(Member member) {
        checkingDuplicate(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findOne(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public void checkingDuplicate(Member member) {
        memberRepository.findByNick(member.getNickname())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원명입니다.");
                });
        memberRepository.findByUserId((member.getUserid()))
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원ID입니다.");
                });
    }
}
