package springlearning.springwebmvcdb.repository;

import org.springframework.stereotype.Repository;
import springlearning.springwebmvcdb.domain.Member;

import java.util.*;

// implements 로 MemberRepository를 가져옴 ( option + enter )
//@Repository // component scan 방식
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null값이 예측된다면 optional<> 감싼다
        return Optional.ofNullable(store.get(id));
    }

    // user name
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    // 스토어를 비움
    public void clearStore() {
        store.clear();
    }
}
