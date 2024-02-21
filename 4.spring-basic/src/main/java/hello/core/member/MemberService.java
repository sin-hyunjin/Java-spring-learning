package hello.core.member;

public interface MemberService {

    /** 회원가입 */
    void join(Member member);

    /** 회원정보 찾기 */
    Member findMember(Long memberId);
}
