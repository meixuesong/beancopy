package cn.meixs.beancopy.domain;

import java.math.BigDecimal;

public class OrderItem {
    private String productId;
    private BigDecimal price;
    private BigDecimal quantity;
    private String comment;

    public OrderItem(String productId, BigDecimal price, BigDecimal quantity, String comment) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.comment = comment;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getComment() {
        return comment;
    }
}
