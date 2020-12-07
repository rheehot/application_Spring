package com.wchoi.spring_core.discount;

import com.wchoi.spring_core.member.Gradle;
import com.wchoi.spring_core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGradle() == Gradle.VIP) {
            return price * discountRate / 100;
        } else
            return 0;
    }
}
