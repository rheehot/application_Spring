package com.wchoi.spring_core;

import com.wchoi.spring_core.discount.DiscountPolicy;
import com.wchoi.spring_core.discount.FixDiscountPolicy;
import com.wchoi.spring_core.discount.RateDiscountPolicy;
import com.wchoi.spring_core.member.*;
import com.wchoi.spring_core.order.OrderService;
import com.wchoi.spring_core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    // 생성자를 통해 원하는 구현체 객체를 넣어준다 (생성자 주입)
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    // 생성자를 통해 원하는 구현체 객체를 넣어준다 (생성자 주입)
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
