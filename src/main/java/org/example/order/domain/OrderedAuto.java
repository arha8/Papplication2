package org.example.order.domain;

import javax.persistence.*;

@Entity
@Table(name = "ordered_auto")
public class OrderedAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordered_auto_id")
    private Long orderedAutoId;
    @Column(name = "auto_model")
    private String autoModel;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private OrderList order;

    public Long getOrderedAutoId() {
        return orderedAutoId;
    }

    public void setOrderedAutoId(Long orderedAutoId) {
        this.orderedAutoId = orderedAutoId;
    }

    public String getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(String autoModel) {
        this.autoModel = autoModel;
    }

    public OrderList getOrder() {
        return order;
    }

    public void setOrder(OrderList order) {
        this.order = order;
    }
}
