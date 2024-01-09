package com.example.demo.common.authority

data class TokenInfo (
    //grantType : JWT권한 인증 타입  (ex. Bearer) accessToken :
    val grantType: String,
    // 실제 검증할때 확인할 토큰
    val accessToken: String,

)