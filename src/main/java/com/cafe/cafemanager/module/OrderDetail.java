package com.cafe.cafemanager.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "orderDetail")
    private List<Product> products = new ArrayList<>();

    private int num; // số lượng đặt
    private double price;

    public OrderDetail() {}

    public OrderDetail(Long id, Order order, List<Product> products, int num, double price) {
        this.id = id;
        this.order = order;
        this.products = products;
        this.num = num;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
