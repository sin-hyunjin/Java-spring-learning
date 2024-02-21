package hello.core.member;

public interface MemberRepository {

    /** 회원 저장 */
    void save(Member member);

    /** id로 회원 ID 찾기*/
    Member findById(Long memberId);


}
