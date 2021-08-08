package com.example.multidatasource.controller;

import com.example.multidatasource.jpa.customer.entity.Customer;
import com.example.multidatasource.jpa.product.entity.Product;
import com.example.multidatasource.service.BackendService;
import com.example.multidatasource.service.CustomerService;
import com.example.multidatasource.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    BackendService backendService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public void saveCustomerAndProduct() throws Exception {
        Customer customer = new Customer();
        customer.setId(7l);
        customer.setFirstName("chandu1");
        customer.setLastName("boosa");

        Product product = new Product();
        product.setId(7l);
        product.setProductName("Laptop1");
        product.setPrice(new BigDecimal("135000.89"));

        backendService.saveIntoDataBase(customer, product);
    }
}
