package com.folder.backend.dao;

import com.folder.backend.dto.UserDTO;

import java.util.List;

/* DAO (Data Access Object)
    -
 */
public interface UserDao {
    public List<UserDTO> findAll();
    public int editById(UserDTO uDto);
    public int delete(int no);

    public int save(UserDTO uDto);
}
