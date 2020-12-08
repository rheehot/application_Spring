package com.wchoi.spring_core;

import com.wchoi.spring_core.member.*;
import com.wchoi.spring_core.order.Order;
import com.wchoi.spring_core.order.OrderService;
import com.wchoi.spring_core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member memberWS = new Member(memberId, "woonsik", Gradle.VIP);
        memberService.join(memberWS);

        Order order = orderService.createOrder(memberId, "iPhone 12 pro", 12000);
        System.out.println(order);
        System.out.println(order.calculaterPrice());
    }
}
