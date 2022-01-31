package org.example.order.rest;


import org.example.order.business.OrderService;
import org.example.order.view.OrderRequest;
import org.example.order.view.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orderl")
public class OrderLController {

    @Autowired
    private OrderService orderService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrderResponse> getOrderInfo(@RequestBody OrderRequest request) {
        return orderService.getInfo(request);
    }

    @GetMapping(path = "/check")
    public String helloCheck() {
        return "Rest service is working";
    }
}
