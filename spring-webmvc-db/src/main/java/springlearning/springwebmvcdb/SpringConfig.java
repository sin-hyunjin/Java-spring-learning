package springlearning.springwebmvcdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springlearning.springwebmvcdb.repository.JdbcMemberRepository;
import springlearning.springwebmvcdb.repository.MemberRepository;
import springlearning.springwebmvcdb.repository.MemoryMemberRepository;
import springlearning.springwebmvcdb.service.MemberService;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configurable
public class SpringConfig {

    // application.properties 에서 자동으로 접근하게 해준다
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    @Bean // 내가 Bean을 등록한다고 생각하면 된다.
    public MemberService memberService() throws SQLException {
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() throws SQLException {
        return new JdbcMemberRepository(dataSource);
    }
}

