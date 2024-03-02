package com.cos.security1.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {


    /** 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
     * 구글 로그인시 userRequest = org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest@587648de
     * */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration() = " + userRequest.getClientRegistration());
        System.out.println("getAccessToken() = " + userRequest.getAccessToken().getTokenValue());
        System.out.println("getClientId() = " + userRequest.getClientRegistration().getClientId());
        /** userRequest 정보
         * 구글 로그인 버튼 클릭 -> 구글 로그인창 -> 로그인 완료 -> code를 리턴(OAuth-client라이브러리) -> AccessToken요청
         * userRequest정보 -> loadUser함수 호출 -> 구글로부터 회원프로필을 받아준다.
         * */
        System.out.println("super.loadUser(userRequest).getAttributes() = " + super.loadUser(userRequest).getAttributes());

        OAuth2User auth2User = super.loadUser(userRequest);
        //회원가입을 강제로 진행
        return super.loadUser(userRequest);
    }
}
