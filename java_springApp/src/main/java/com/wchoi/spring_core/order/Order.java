package com.wchoi.spring_core.order;

public class Order {
    private Long memberId;
    private String itmeName;
    private int itemPrice;
    private int discountPirce;

    public Order(Long memberId, String itmeName, int itemPrice, int discountPirce) {
        this.memberId = memberId;
        this.itmeName = itmeName;
        this.itemPrice = itemPrice;
        this.discountPirce = discountPirce;
    }

    public int calculaterPrice() {
        return itemPrice - discountPirce;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItmeName() {
        return itmeName;
    }

    public void setItmeName(String itmeName) {
        this.itmeName = itmeName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPirce() {
        return discountPirce;
    }

    public void setDiscountPirce(int discountPirce) {
        this.discountPirce = discountPirce;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itmeName='" + itmeName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPirce=" + discountPirce +
                '}';
    }
}
