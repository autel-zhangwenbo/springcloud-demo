package com.example.shopproduct.controller;


import com.example.model.Product;
import com.example.shopproduct.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        Product product = productService.findByPid(pid);
        log.info("查询到商品:" + JSON.toJSONString(product));
        return product;
    }
}