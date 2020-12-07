package com.wchoi.spring_core.order;

import com.wchoi.spring_core.AppConfig;
import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;
import com.wchoi.spring_core.member.MemberService;
import com.wchoi.spring_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "woonsik", Gradle.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iPhone 12 pro", 16000);
        Assertions.assertThat(order.getDiscountPirce()).isEqualTo(1600);
    }
}
