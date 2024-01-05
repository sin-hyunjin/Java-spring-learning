package com.folder.backend.mapper;

import com.folder.backend.dto.UserDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select no, name, email, pwd, gender, del, date_format(regDate, '%Y-%m-%d %T' ) as regDate from user3 where del = false order by no desc")
    public List<UserDTO> findAll();

    @Update("update user3 set name = #{name}, pwd = #{pwd}, gender = #{gender} where no = #{no}")
    public int editById(UserDTO uDto);

    @Update("update user3 set del = true where no = #{no}")
    public int delete(int no);
}
