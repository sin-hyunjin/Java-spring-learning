/* 회원 도메인
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */

package springlearning.springwebmvcdb.domain;

public class Member {

    private long id; // 데이터를 구분하기 위한 id
    private String name; // 회원 이름

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
