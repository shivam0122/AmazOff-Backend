package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderRepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId, partnerId);
    }

    public Order findOrderById(String orderId) {
       return orderRepository.findOrderById(orderId);
    }

    public DeliveryPartner findPartnerById(String partnerId) {
       return orderRepository.findPartnerById(partnerId);
        
    }

    public Integer findOrderCountByPartnerId(String partnerId) {
       return orderRepository.findOrderCountByPartnerId(partnerId);
    }

    public List<String> findOrdersByPartnerId(String partnerId) {
        return orderRepository.findOrdersByPartnerId(partnerId);
    }

    public List<String> allOrdersList() {
        return orderRepository.allOrdersList();
    }

    public Integer findCountOfUnassignedOrders() {
        return orderRepository.findCountOfUnassignedOrders();
    }

    public Integer findOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
       return orderRepository.findOrdersLeftAfterGivenTimeByPartnerId(time, partnerId);
    }

    public String findLastDeliveryTimeByPartnerId(String partnerId) {
       return orderRepository.findLastDeliveryTimeByPartnerId(partnerId);
    }

    public void deletePartnerById(String partnerId) {
        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteOrderById(orderId);
    }
}
