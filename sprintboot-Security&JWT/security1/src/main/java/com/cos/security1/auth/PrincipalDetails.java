package com.cos.security1.auth;


import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/** PrincipalDetails
 * 1. 시큐리시티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
 * 2. 로그인을 진행이 완료가 되면 시큐리티 session을 만들어준다. (Security ContextHolder)
 * 3. 오브젝트 => Authentication 타입 객체
 * 4. Authentication 안에 User 정보가 있어야 됨.
 * 5. User 오브젝트타입 => UserDetails 타입 객체 여야함
 * 6. Security Session => Authentication => UserDetails
 */
public class PrincipalDetails implements UserDetails {

    private User user;

    // 일반 시큐리티 로그인시 사용
    public PrincipalDetails(User user) {
        this.user = user;
    }

    /**  해당 User의 권한을 리턴하는 곳 */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
        collection.add(() -> user.getRole());
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 우리사이트에서 1년동안 회원이 로그인을 안하면 휴면 계정으로 하기로 함
        // 현제시간 - 로그인시간 => 1년을 초과하면 return false

        return true;
    }
}
