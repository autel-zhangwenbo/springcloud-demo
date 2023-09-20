package com.example.shoporder.controller;

import com.example.model.Order;
import com.example.model.Product;
import com.example.shoporder.service.OrderService;
import com.example.shopproduct.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;
    //准备买1件商品
    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");

          // 1、通过restTemplate调用商品微服务
//        //从nacos中获取服务地址
//        // 自定义规则实现随机挑选服务
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        int index = new Random().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(index);
//        String url = serviceInstance.getHost() + ":" +
//                serviceInstance.getPort();
//        log.info(">>从nacos中获取到的微服务地址为:" + url);
//        //通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject("http://" + url +
//                "/product/" + pid, Product.class);
//        log.info(">>商品信息，查询结果:" + JSON.toJSONString(product));

        // 2、通过ribbon实现负载均衡调用商品微服务
//        //直接使用微服务名字， 从nacos中获取服务地址
//        String url = "service-product";
//        // 通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject(
//                "http://" + url + "/product/" + pid, Product.class);
//        log.info(">>商品信息，查询结果:" + JSON.toJSONString(product));

        // 3、通过feign实现负载均衡调用商品微服务
        Product product = productService.findByPid(pid);
        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));

        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }

    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }
    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
