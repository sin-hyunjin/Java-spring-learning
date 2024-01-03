/* member repository


 */
package springlearning.springwebmvcdb.repository;

import org.springframework.stereotype.Repository;
import springlearning.springwebmvcdb.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장
    // null값이 예측된다면 optional<> 감싼다
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트를 가져옴

}
