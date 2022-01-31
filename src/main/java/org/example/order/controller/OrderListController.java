package org.example.order.controller;

import org.example.order.business.OrderService;
import org.example.order.business.OrderedAutoService;
import org.example.order.domain.OrderList;
import org.example.order.domain.OrderedAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(path = "/orderlist")
public class OrderListController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderedAutoService orderedAutoService;

    @GetMapping
    public String findOrders(Model model) {
        List<OrderList> list = orderService.getOrdersList();

        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("orders", list);

        return "orderList_jstl";

    }

    @GetMapping(path = "/allcars")
    public String findAllCars(Model model) {
        List<OrderedAuto> list = orderedAutoService.findCars();
        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("cars", list);

        return "carsList_jstl";
    }

}
