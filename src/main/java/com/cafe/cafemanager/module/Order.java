package com.cafe.cafemanager.module;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;

    @Column(name = "total_price")
    private double totalPrice;


    public Order() {}

    public Order(Long id, double totalPrice, Staff staff, Customer customer, OrderDetail orderDetail) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.staff = staff;
        this.customer = customer;
        this.orderDetail = orderDetail;
    }

    public Long getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
