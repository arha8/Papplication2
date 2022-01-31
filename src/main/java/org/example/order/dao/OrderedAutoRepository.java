package org.example.order.dao;

import org.example.order.domain.OrderedAuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedAutoRepository extends JpaRepository<OrderedAuto, Long> {
}
