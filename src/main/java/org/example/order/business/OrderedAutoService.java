package org.example.order.business;

import org.example.order.dao.OrderedAutoRepository;
import org.example.order.domain.OrderedAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderedAutoService {

    @Autowired
    private OrderedAutoRepository orderedAutoRepository;

    @Transactional()
    public List<OrderedAuto> findCars() {
        return orderedAutoRepository.findAll();
    }
}
