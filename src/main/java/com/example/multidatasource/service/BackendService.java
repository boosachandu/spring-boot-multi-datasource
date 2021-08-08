package com.example.multidatasource.service;

import com.example.multidatasource.jpa.customer.entity.Customer;
import com.example.multidatasource.jpa.customer.repository.CustomerRepository;
import com.example.multidatasource.jpa.product.entity.Product;
import com.example.multidatasource.jpa.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BackendService {

    //hsql database
    @Autowired
    private CustomerRepository customerRepository;

    //h2 data base
    @Autowired
    private ProductRepository productRepository;

    @Transactional(value = "chainedTransactionManager")
    public void saveIntoDataBase(Customer customer, Product product) throws Exception {
        customerRepository.save(customer);
        //To testing  purpose raise the exception
        //  int i = 1/0;
        productRepository.save(product);


    }

}
