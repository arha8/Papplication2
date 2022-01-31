package org.example.order.business;

import org.example.order.dao.ClientRepository;
import org.example.order.dao.OrderListRepository;
import org.example.order.domain.Client;
import org.example.order.domain.OrderList;
import org.example.order.domain.OrderedAuto;
import org.example.order.view.OrderRequest;
import org.example.order.view.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderListRepository orderListRepository;



    @Transactional
    public List<OrderResponse> getInfo(OrderRequest orderRequest) {

        List<Client> client = clientRepository.findClient(
                orderRequest.getFirstName(),
                orderRequest.getLastName(),
                orderRequest.getPatronymic(),
                orderRequest.getDateOfBirth()
        );
        if (client.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<OrderList> orderLists = client.get(0).getOrders();
        List<OrderResponse> result = orderLists.stream().map(d -> getResponse(d)).collect(Collectors.toList());
        return result;
    }

    private OrderResponse getResponse (OrderList orderList) {
        OrderResponse response = new OrderResponse();
        response.setOrderName(orderList.getOrderName());
        response.setOrderDate(orderList.getOrderDate());
        List<OrderedAuto> orderedAutoList = orderList.getOrderedAutoList();
        response.setAutoModel(orderedAutoList.get(0).getAutoModel());

        return response;
    }

    @Transactional(readOnly = true)
    public List<OrderList> getOrdersList() {
        return orderListRepository.findAll();
    }
}
