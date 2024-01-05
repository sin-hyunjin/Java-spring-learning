package com.folder.backend.service;

import com.folder.backend.dto.ResultDTO;
import com.folder.backend.dto.UserDTO;



/* 유저 관리를 위한 파일

 */

public interface UserService {

    ResultDTO findAll();
    ResultDTO editById(UserDTO uDto);
    ResultDTO delete(int no);
    ResultDTO save(UserDTO uDto);




}
