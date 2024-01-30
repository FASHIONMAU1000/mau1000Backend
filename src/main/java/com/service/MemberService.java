package com.service;

import com.domain.Member;
import com.domain.Post;
import com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(Member member){
        memberRepository.save(member);
    }
    public void delete(Member member){
        memberRepository.delete(member);
    }
}
