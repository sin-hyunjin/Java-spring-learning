package com.example.demo.common.dto

import com.example.demo.common.status.ResultCode
import org.aspectj.bridge.Message

data class BaseResponse<T> (
    // 결과코드
    val resultCode: String = ResultCode.SUCCESS.name,
    // 조희 처리시 data property에 값을 넣어서 반환해줄 꺼임
    val data: T? = null,
    // 처리메시지
    val message: String = ResultCode.SUCCESS.msg,

    )


