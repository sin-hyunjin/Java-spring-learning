package springlearning.springwebmvcdb.repository;

import ch.qos.logback.classic.Logger;
import springlearning.springwebmvcdb.domain.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// option + enter 로 implements를 해주면 된다.
public class JdbcMemberRepository implements MemberRepository{


    //DB에 접근하기 위한 방법으로 DataSource가 필요하다
    private final DataSource dataSource;
    public JdbcMemberRepository(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        dataSource.getConnection(); // sql문을 db에 전달해야한다.
    }
    @Override
    public Member save(Member member) throws SQLException {
        // SQL 쿼리문을 정의합니다. 회원 이름을 받아와서 member 테이블에 삽입하는 쿼리입니다.
        String sql = "insert into member(name) values(?)";

// 데이터베이스 연결을 위한 Connection 객체를 획득합니다. (dataSource는 어딘가에서 주입된 DataSource입니다.)
        Connection connection = dataSource.getConnection();

// PreparedStatement는 SQL 쿼리를 실행하기 위한 인터페이스로, 특정 파라미터를 설정할 수 있습니다.
        PreparedStatement pstmt = connection.prepareStatement(sql);

// 쿼리의 물음표(?)에 실제 값(member.getName())을 설정합니다.
        pstmt.setString(1, member.getName());

// 쿼리를 실행하고 데이터베이스에 변경을 적용합니다.
        pstmt.executeUpdate();

// 리턴 값이 없으므로 null을 반환합니다.
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
