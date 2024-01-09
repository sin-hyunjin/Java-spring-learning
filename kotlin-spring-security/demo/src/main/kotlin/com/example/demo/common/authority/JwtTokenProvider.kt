package com.example.demo.common.authority

import com.example.demo.common.dto.CustomUser
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

// 토큰 만료 시간 상수
const val EXPIRATION_MILLISECONDS: Long = 1000 * 60 * 60 * 12

@Component
class JwtTokenProvider {
    // application.properties에서 주입되는 비밀 키
    @Value("\${jwt.secret}")
    lateinit var secretKey: String

    // 비밀 키를 Base64 디코딩한 값으로 초기화
    private val key by lazy {
        Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    }

    /**
     * 사용자 인증 정보를 기반으로 JWT 토큰을 생성하는 메서드
     */
    fun createToken(authentication: Authentication): TokenInfo {
        // 권한 정보를 쉼표로 구분하여 문자열로 변환
        val authorities: String = authentication
            .authorities
            .joinToString(",", transform = GrantedAuthority::getAuthority)

        val now = Date()
        val accessExpiration = Date(now.time + EXPIRATION_MILLISECONDS)

        // Access Token 생성
        val accessToken = Jwts.builder()
            .setSubject(authentication.name)
            .claim("auth", authorities)
            .claim("userId", (authentication.principal as CustomUser).userId)
            .setIssuedAt(now)
            .setExpiration(accessExpiration)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
        return TokenInfo("Bearer", accessToken)
    }

    /**
     * JWT 토큰에서 사용자 정보를 추출하여 인증 객체를 반환하는 메서드
     */
    fun getAuthentication(token: String): Authentication {
        val claims: Claims = getClaims(token)

        val auth = claims["auth"] as? String ?: throw RuntimeException("Invalid or empty 'auth' claim in JWT token")
        val userId = claims["userId"]?.toString()

        if (userId.isNullOrBlank()) {
            throw RuntimeException("Invalid or empty 'userId' claim in JWT token")
        }

        // 권한 문자열을 분리하여 SimpleGrantedAuthority로 변환
        val authorities: Collection<GrantedAuthority> = auth
            .takeIf { it.isNotBlank() }
            ?.split(",")
            ?.filter { it.isNotBlank() }
            ?.map { SimpleGrantedAuthority(it) }
            ?: throw RuntimeException("Invalid or empty 'auth' claim in JWT token")

        // UserDetails 객체 생성
        val principal: UserDetails = CustomUser(userId.toLong(), claims.subject, "", authorities)

        // UsernamePasswordAuthenticationToken을 사용하여 Authentication 객체 반환
        return UsernamePasswordAuthenticationToken(principal, "", authorities)
    }

    /**
     * JWT 토큰의 유효성을 검증하는 메서드
     */
    fun validateToken(token: String): Boolean {
        try {
            getClaims(token)
            return true
        } catch (e: Exception) {
            // 발생한 예외에 따라 적절한 처리 수행
            when (e) {
                is SecurityException -> {}  // 유효하지 않은 JWT 토큰
                is MalformedJwtException -> {}  // 유효하지 않은 JWT 토큰
                is ExpiredJwtException -> {}    // 만료된 JWT 토큰
                is UnsupportedJwtException -> {}
                is IllegalArgumentException -> {}
                else -> {}  // 기타 예외
            }
            println(e.message)
        }
        return false
    }

    // JWT 토큰에서 클레임(클레임을 포함한 부분)을 추출하는 메서드
    private fun getClaims(token: String): Claims =
        Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
}
