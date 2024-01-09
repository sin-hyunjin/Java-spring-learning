package com.example.demo.member.entity

import com.example.demo.common.status.Gender
import com.example.demo.common.status.ROLE
import com.example.demo.member.dto.MemberDtoResponse
import jakarta.persistence.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])
    ]
)
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // 로그인 ID는 고유해야하며 길이는 30자로 제한됩니다.
    @Column(nullable = false, length = 30, updatable = false)
    val loginId: String,

    // 비밀번호는 문자열로 저장되어 있으며 보안을 위해 해시된 비밀번호를 저장하는 것이 권장됩니다.
    @Column(nullable = false, length = 100)
    val password: String,

    // 최대 10자의 길이로 사용자 이름
    @Column(nullable = false, length = 10)
    val name: String,

    // 사용자의 생년월일
    @Column(nullable = false)
    val birthDate: LocalDate,

    // 성별은 EnumType.STRING으로 저장됩니다.
    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    val gender: Gender,

    // 최대 30자의 길이로 사용자 이메일
    @Column(nullable = false, length = 30)
    val email: String,
){
    //
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    val memberRole: List<MemberRole>? = null

    private fun LocalDate.formatDate(): String =
        this.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    fun toDto(): MemberDtoResponse =
        MemberDtoResponse(
            id!!,
            loginId,
            name,
            birthDate.formatDate(),
            gender.desc,
            email
        )
}
// 추가
@Entity
class MemberRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    val role: ROLE,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "fk_user_role_member_id"))
    val member: Member,
)