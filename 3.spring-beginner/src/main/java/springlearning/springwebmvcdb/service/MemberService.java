/* 회원 서비스 개발
    - 회원서비스는 회원 리포지터리랑 도메인을 활용해 실제 비즈니스 로직을 작성하는 쪽
    - cmd + t
 */
package springlearning.springwebmvcdb.service;

import org.springframework.stereotype.Service;
import springlearning.springwebmvcdb.domain.Member;
import springlearning.springwebmvcdb.repository.MemberRepository;
import springlearning.springwebmvcdb.repository.MemoryMemberRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// cmd + shift + t 를 하면 테스트 케이스 자동으로 만들어짐

@Service
public class MemberService {
    // 서비스를 만들기위해 리포지토리가 필요
    private final MemberRepository memberRepository;

    // cmd + n = Constructor
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) throws SQLException {
        // 같은 이름이 있는 중복 회원X
        valdateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void valdateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

