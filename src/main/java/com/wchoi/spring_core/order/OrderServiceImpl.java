package com.wchoi.spring_core.order;

import com.wchoi.spring_core.discount.DiscountPolicy;
import com.wchoi.spring_core.discount.FixDiscountPolicy;
import com.wchoi.spring_core.discount.RateDiscountPolicy;
import com.wchoi.spring_core.member.Member;
import com.wchoi.spring_core.member.MemberRepository;
import com.wchoi.spring_core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자 주입을 통해 Member객체 저장소로 Memory저장소를, discount 정책으로 Fix구현체를 가져온다
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int  discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
