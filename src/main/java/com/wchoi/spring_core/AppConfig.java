package com.wchoi.spring_core;

import com.wchoi.spring_core.discount.DiscountPolicy;
import com.wchoi.spring_core.discount.FixDiscountPolicy;
import com.wchoi.spring_core.discount.RateDiscountPolicy;
import com.wchoi.spring_core.member.*;
import com.wchoi.spring_core.order.OrderService;
import com.wchoi.spring_core.order.OrderServiceImpl;

public class AppConfig {

    // 생성자를 통해 원하는 구현체 객체를 넣어준다 (생성자 주입)
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 생성자를 통해 원하는 구현체 객체를 넣어준다 (생성자 주입)
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
