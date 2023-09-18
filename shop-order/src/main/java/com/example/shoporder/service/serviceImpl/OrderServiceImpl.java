package com.example.shoporder.service.serviceImpl;

import com.example.model.Order;
import com.example.shoporder.dao.OrderDao;
import com.example.shoporder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}
