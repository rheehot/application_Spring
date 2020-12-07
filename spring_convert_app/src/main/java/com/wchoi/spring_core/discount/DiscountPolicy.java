package com.wchoi.spring_core.discount;

import com.wchoi.spring_core.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
