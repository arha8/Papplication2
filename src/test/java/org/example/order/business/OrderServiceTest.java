package org.example.order.business;

import org.example.order.rest.OrderLController;
import org.example.order.view.OrderRequest;
import org.example.order.view.OrderResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class OrderServiceTest {

    //private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceTest.class);

    @Autowired
    private OrderLController orderController;

    @Test
    public void studentInfo() {
        OrderRequest req = new OrderRequest();

        req.setFirstName("ivan");
        req.setLastName("ivanov");
        req.setPatronymic("ivanovich");
        req.setDateOfBirth(LocalDate.of(1985, 5, 17));


        List<OrderResponse> info = orderController.getOrderInfo(req);
        Assert.assertTrue(info.size() > 0);
    }
}