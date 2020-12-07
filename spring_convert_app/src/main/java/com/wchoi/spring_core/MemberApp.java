package com.wchoi.spring_core;

import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;
import com.wchoi.spring_core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member memberA = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(memberA);
        Member findedMem = memberService.findMember(1L);

        System.out.println(memberA.getName());
        System.out.println(findedMem.getName());
        if (memberA == findedMem)
            System.out.println("right ! same obj");
    }
}
