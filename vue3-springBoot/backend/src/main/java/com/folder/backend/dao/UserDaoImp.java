package com.folder.backend.dao;

import com.folder.backend.dto.ResultDTO;
import com.folder.backend.dto.UserDTO;
import com.folder.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/* UserDao interface 추상메서드 구현

 */
@Repository // 데이터베이스 데이터를 엑세스 할수 있는 Bean
public class UserDaoImp implements UserDao{

    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserDTO> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int editById(UserDTO uDto) {
        return userMapper.editById(uDto);
    }

    @Override
    public int delete(int no) {
        return userMapper.delete(no);
    }



    @Override
    public ResultDTO save(UserDTO uDto){
        ResultDTO result = new ResultDTO();
        int state = userMapper.save(uDto);
        if(state == 1) {
            System.out.println(uDto);
            result.setState(true);
            result.setResult(uDto);
        } else {
            result.setState(false);
        }
        return result;
    }

}
