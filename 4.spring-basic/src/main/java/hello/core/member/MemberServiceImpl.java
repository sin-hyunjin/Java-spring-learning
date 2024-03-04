package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /** 이렇게 설계할시  MemberServiceImpl 는 MemberService의 추상화의 의존과 MemoryMemberRepository 구체화도 의존 중이다
     *  -> 이것은 DIP 의존관계 역전 원칙에 위반된다.
     */
    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
