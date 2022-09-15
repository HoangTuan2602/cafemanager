package com.cafe.cafemanager.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_detail_tbl")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToMany(mappedBy = "orderDetail")
    private List<ProductEntity> products = new ArrayList<>();

    private int num; // số lượng đặt
    private double price;

    public OrderDetail() {}

    public OrderDetail(Long id, OrderEntity order, List<ProductEntity> products, int num, double price) {
        this.id = id;
        this.order = order;
        this.products = products;
        this.num = num;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
