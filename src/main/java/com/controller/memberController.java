package com.controller;

import com.domain.Member;
import com.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class memberController {
    private final MemberService memberService;

    @PostMapping
    public void addMember(@RequestBody Member member) {
        //TODO: add member save logic
        memberService.save(member);
    }

    @GetMapping
    public void getMember(@RequestBody Member member) {
        //TODO: add member get logic

    }

    @PutMapping
    public void updateMember(@RequestBody Member member) {
        //TODO: add member update logic

    }
    @DeleteMapping
    public void deleteMember(@RequestBody Member member) {
        //TODO: add member delete logic

    }


}
