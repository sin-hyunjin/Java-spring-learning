package com.folder.backend.dto;

import lombok.Data;


/* vue 쪽으로 return 하기 위한 데이터
     @PostMapping("/findAll")
    public void findAll() {

    }여기로 넘어갈꺼임
 */

@Data
public class ResultDTO {

    private Boolean state; // 유저 상태값
    private Object result; // result 값
    private String message; // 특정 메세지값

    public void setState(Boolean state) {
        this.state = state;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getState() {
        return state;
    }

    public Object getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
