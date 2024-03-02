package com.cos.security1.config.oauth;

import com.cos.security1.auth.PrincipalDetails;
import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;
    /** 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
     * 구글 로그인시 userRequest = org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest@587648de
     * */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration() = " + userRequest.getClientRegistration());
        System.out.println("getAccessToken() = " + userRequest.getAccessToken().getTokenValue());
        System.out.println("getClientId() = " + userRequest.getClientRegistration().getClientId());

        OAuth2User auth2User = super.loadUser(userRequest);
        /** userRequest 정보
         * 구글 로그인 버튼 클릭 -> 구글 로그인창 -> 로그인 완료 -> code를 리턴(OAuth-client라이브러리) -> AccessToken요청
         * userRequest정보 -> loadUser함수 호출 -> 구글로부터 회원프로필을 받아준다.
         * */
        System.out.println("super.loadUser(userRequest).getAttributes() = " + auth2User.getAttributes());
        String provider = userRequest.getClientRegistration().getClientId(); // google
        String providerId = auth2User.getAttribute("sub");
        String username = provider + "_" + providerId; // google_1095812382138
        System.out.println("username = " + username);
        String password = bCryptPasswordEncoder.encode("겟인데어");
        String email = auth2User.getAttribute("email");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        if(userEntity == null) {
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }
        //회원가입을 강제로 진행
        return new PrincipalDetails(userEntity, auth2User.getAttributes());
    }
}
