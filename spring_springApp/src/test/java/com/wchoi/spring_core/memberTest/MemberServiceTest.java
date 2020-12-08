package com.wchoi.spring_core.memberTest;

import com.wchoi.spring_core.AppConfig;
import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;
import com.wchoi.spring_core.member.MemberService;
import com.wchoi.spring_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "woonsik", Gradle.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
