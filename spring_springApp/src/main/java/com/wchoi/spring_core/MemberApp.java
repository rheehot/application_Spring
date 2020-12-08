package com.wchoi.spring_core;

import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;
import com.wchoi.spring_core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //AppConfig.class에 있는 애노테이션 Config들을 모두 가져와서 관리해준다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 가지고 있는 Config 중에서 내가 원하는 memberService를 찾아서 MemberService형으로 반환해준다 (기본적으로 메서드 명으로 갖는다)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(memberA);
        Member findedMem = memberService.findMember(1L);

        System.out.println(memberA.getName());
        System.out.println(findedMem.getName());
        if (memberA == findedMem)
            System.out.println("right ! same obj");
    }
}
