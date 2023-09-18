package com.example.model;

import lombok.Data;

import javax.persistence.*;

//订单
@Entity
@Table(name = "shop_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;//订单id

    private Integer uid;//用户id
    private String username;//用户名
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价

    private Integer number;//购买数量

}