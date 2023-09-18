package com.example.shopproduct.service.serviceImpl;

import com.example.model.Product;
import com.example.shopproduct.dao.ProductDao;
import com.example.shopproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

}
