package com.example.demo.member.dto

import com.example.demo.common.status.Gender
import java.time.LocalDate
// 회원가입시 입력받을 정보
data class MemberDtoRequest(
    val id: Long?,
    val loginId: String,
    val password: String,
    val name: String,
    val birthDate: LocalDate,
    val gender: Gender,
    val email: String,
)
