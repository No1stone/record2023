package com.example.refreshtoken.domain.V1.service;

import com.example.refreshtoken.jpa.entity.Member;
import com.example.refreshtoken.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//UserDetailsService : Database에서 유저정보 권한을 검색하는 역할 이후 AuthenticationProvider 으로 전달한다.
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    //UserDetails : Security에서 사용자 정보를 답는다. Vo역할 사용자 정보를 모두 담아둠.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByMemberEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    // DB 에 User 값이 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(Member member) {

        //GrantedAuthority : 부여된 권한
        //SimpleGrantedAuthority : 단순 부여된 권한
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthority().toString());
/*
        User.builder()
                .accountExpired(true) // 계정만료
                .accountLocked(false) // 계정잠금
                .authorities("검색된권한") //권한 1개
                .authorities(Collections.singleton("aa")) //권한 리스트 가능
                .credentialsExpired(true) //자격 만료
                .disabled(false) // 사용불가처리
                .password("유저비밀번호 암호화한거")
                .roles("유저 롤")
                .username("name")
                .build();
*/
        return new User(
                String.valueOf(member.getMemberId()),
                member.getMemberPassword(),
                //Collections.singleton : set<String>
                //Collections.singletonList : List<String>
                //Collections.singletonMap : Map<String>
                Collections.singleton(grantedAuthority)
        );
    }

}
