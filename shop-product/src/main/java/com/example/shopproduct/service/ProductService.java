package com.example.shopproduct.service;

import com.example.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-product")    //声明调用的提供者的name
public interface ProductService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping 就是一个完整的请求路径 http://service-product/product/{pid}
    @GetMapping(value = "/product/{pid}")
    public Product findByPid(Integer pid);
}
