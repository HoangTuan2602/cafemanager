package com.cafe.cafemanager.module;

import javax.persistence.*;

@Entity
@Table(name = "order_tbl")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;

    @Column(name = "total_price")
    private double totalPrice;


    public OrderEntity() {}

    public OrderEntity(Long id, double totalPrice, StaffEntity staff, CustomerEntity customer, OrderDetail orderDetail) {
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

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
