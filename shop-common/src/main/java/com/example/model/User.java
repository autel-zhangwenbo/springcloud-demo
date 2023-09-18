package com.example.model;

import lombok.Data;

import javax.persistence.*;

//用户
@Entity(name = "shop_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;//主键
    @Column(name = "username")
    private String username;//用户名
    @Column(name = "password")
    private String password;//密码
    @Column(name = "telephone")
    private String telephone;//手机号

}