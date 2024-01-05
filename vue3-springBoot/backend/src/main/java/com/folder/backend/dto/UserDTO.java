package com.folder.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

/*DTO(DATA Transfer Object) method
    - 유저정보 테이블 컬럼 가져오기
 */
@Data
public class UserDTO {

    private int no;
    private String name;
    private String email;
    private String pwd;
    private Boolean gender;
    private Boolean del;
    private LocalDateTime regDate;
}
