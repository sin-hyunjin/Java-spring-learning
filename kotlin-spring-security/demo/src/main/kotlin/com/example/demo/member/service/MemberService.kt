package com.example.demo.member.service

import com.example.demo.common.exception.InvalidInputException
import com.example.demo.common.status.ROLE
import com.example.demo.member.dto.MemberDtoRequest
import com.example.demo.member.entity.Member
import com.example.demo.member.entity.MemberRole
import com.example.demo.member.repository.MemberRepository
import com.example.demo.member.repository.MemberRoleRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository
){
    /** *
     * 회원가입
     */
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        // ID 중복검사
        var member: Member? = memberRepository
            .findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            throw InvalidInputException("loginId", "이미 등록된 ID입니다,")
        }
        // 사용자 정보 저장
        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        // 권한저장
        val memberRole = MemberRole(null, ROLE.MEMBER, member)
        memberRoleRepository.save(memberRole)
        return "회원가입이 완료 되었습니다"
    }
}