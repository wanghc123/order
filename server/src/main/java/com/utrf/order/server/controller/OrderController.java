package com.utrf.order.server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.utrf.product.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

/**
 * @Description:
 * @author: wanghongchun
 * @date: 2019/2/25
 */
@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    ProductClient productClient;
    @HystrixCommand(fallbackMethod = "helloFallBack")
    @GetMapping("/listForOrder")
    public String listForOrder(String id){
        return productClient.listForOrder("1");
    };
    public String helloFallBack(String id){
        return "error";
    }
}
