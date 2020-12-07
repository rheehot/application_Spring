package com.wchoi.spring_core.discount;

import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    // 고정 할인 금액 1000원
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGradle() == Gradle.VIP) {
            return discountFixAmount;
        } else
            return 0;
    }
}
