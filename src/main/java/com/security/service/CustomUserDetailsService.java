package com.security.service;

import com.domain.Member;
import com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member byUsername = memberRepository.findByUsername(username);
        if(byUsername ==null){
            throw new UsernameNotFoundException("Username not found");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        /**
         * 1. ROLE_USER
         * SecurityContext에 보관되는 Role정보는 현재 이용자에대한 설계가 완료되지 않았으므로, 임시로 ROLE_USER를 부여한다.
         */
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        MemberContext memberContext = new MemberContext(byUsername,roles);


        return memberContext;
    }
}
