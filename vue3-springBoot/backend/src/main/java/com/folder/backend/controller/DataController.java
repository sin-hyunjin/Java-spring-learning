package com.folder.backend.controller;

import com.folder.backend.dto.ResultDTO;
import com.folder.backend.dto.UserDTO;
import com.folder.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8800")
@RestController // Data만 보낼때 사용
public class DataController {
    @Autowired
    UserService uService;

    @GetMapping("/")
    public String home() {
        return "Data 준비 중";
    }

    @GetMapping("/api")
    public String api() {
        return "API Data 준비 중";
    }
    // 사용자 정보페이지  SelectView.vue "/user/findById"

    // 사용자 정보 조회 페이지 - SelectView.vue "/user/findById"
    @PostMapping("/findAll")
    public ResultDTO findAll() {
        return uService.findAll();
    }


    // 업데이트  UpdateView.vue "/user/editById"
    @PostMapping("/editById")
    public ResultDTO editById(@RequestBody UserDTO uDto) {
        System.out.println("uDto = " + uDto);
        return uService.editById(uDto);
    }
    // 사용자 정보 삭제
    @DeleteMapping("/delete")
    public ResultDTO delete(@RequestParam("no") int no){
        return uService.delete(no);
    }
    // 사용자 정보 등록 CreateView.vue "/user/save"
    @PutMapping("/save")
    public ResultDTO save(@RequestBody  UserDTO uDto) {
        return uService.save(uDto);
    }
}
