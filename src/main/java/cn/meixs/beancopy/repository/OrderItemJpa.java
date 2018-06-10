package cn.meixs.beancopy.repository;

import java.math.BigDecimal;

public class OrderItemJpa {
    private String productId;
    private BigDecimal price;
    private BigDecimal quantity;
    private String comment;

    public OrderItemJpa(String productId, BigDecimal price, BigDecimal quantity, String comment) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.comment = comment;
    }

    public OrderItemJpa() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
