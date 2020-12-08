package com.wchoi.spring_core.discount;

import com.wchoi.spring_core.AppConfig;
import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;
import com.wchoi.spring_core.member.MemberService;
import com.wchoi.spring_core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    MemberService memberService;
    OrderService orderService;
    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야 한다")
    void vip_o()
    {
        // given
        Member member = new Member(1L, "vip", Gradle.VIP);
        // when

        int discount = discountPolicy.discount(member, 13000);
        // then
        assertThat(discount).isEqualTo(1300);

    }

    @Test
    @DisplayName("VIP가 아니면 할인을 적용하지 않아야한다")
    void vip_x()
    {
        // given
        Member member = new Member(1L, "basic", Gradle.BASIC);
        // when
        int discount = discountPolicy.discount(member, 13000);
        // then
        assertThat(discount).isEqualTo(0);
    }

}