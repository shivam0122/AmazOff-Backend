package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    private HashMap<String, Order> orderDetails;

    private HashMap<String, DeliveryPartner> deliveryPartnerDetails;

    //hashMap of partner and list of orders(partnerid, order List)
    private HashMap<String, List<String>> assignedOrdersToPartner;

//   private HashMap<String, List<String>> unAssignedOrdersToPartner;


   public OrderRepository(){
       this.orderDetails = new HashMap<>();
       this.deliveryPartnerDetails = new HashMap<>();
       this.assignedOrdersToPartner = new HashMap<>();
//       this.unAssignedOrdersToPartner = new HashMap<>();
   }

    public void addOrder(Order order) {
        orderDetails.put(order.getId(), order);
    }

    public void addPartner(String partnerId) {
       DeliveryPartner deliveryPartner = new DeliveryPartner(partnerId);
       deliveryPartnerDetails.put(deliveryPartner.getId(), deliveryPartner);
    }

    //assigning an order to partner
    public void addOrderPartnerPair(String orderId, String partnerId) {
       List<String> orderList = new ArrayList<>();
       if(orderDetails.containsKey(orderId) && deliveryPartnerDetails.containsKey(partnerId)){
//           List<String> orderList = new ArrayList<>();
           if(assignedOrdersToPartner.containsKey(partnerId)){
               orderList = assignedOrdersToPartner.get(partnerId);
           }
           orderList.add(orderId);

           assignedOrdersToPartner.put(partnerId, orderList);
           DeliveryPartner deliveryPartner = deliveryPartnerDetails.get(partnerId);
           deliveryPartner.setNumberOfOrders(deliveryPartner.getNumberOfOrders()+1);
       }
    }

    public Order findOrderById(String orderId) {

       return orderDetails.get(orderId);
    }

    public DeliveryPartner findPartnerById(String partnerId) {
        return deliveryPartnerDetails.get(partnerId);
    }

    public Integer findOrderCountByPartnerId(String partnerId) {

       DeliveryPartner deliveryPartner = deliveryPartnerDetails.get(partnerId);

       return deliveryPartner.getNumberOfOrders();
    }

    public List<String> findOrdersByPartnerId(String partnerId) {
       List<String> orderList = new ArrayList<>();
       if(assignedOrdersToPartner.containsKey(partnerId)){
           orderList = assignedOrdersToPartner.get(partnerId);
       }
       return orderList;
    }

    //if we have to return objectlist then change this String to object
    public List<String> allOrdersList() {

       List<String> orderList = new ArrayList<>();
       for(String orderId : orderDetails.keySet()){
           orderList.add(orderId);
       }
       return orderList;
    }

    public Integer findCountOfUnassignedOrders() {
       int totalOrders = orderDetails.size();
       int assignedOrders = 0;
//       for(String orderId: orderDetails.keySet()){
//           totalOrders++;
//       }
       for(String partnerId: assignedOrdersToPartner.keySet()){

           assignedOrders += assignedOrdersToPartner.get(partnerId).size();
       }

       int unassignedOrders = totalOrders - assignedOrders;
       return unassignedOrders;
    }

    public Integer findOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {

       Integer totalOrderPending = 0;

       List<String> orderList = new ArrayList<>();
       if(assignedOrdersToPartner.containsKey(partnerId)){
           orderList = assignedOrdersToPartner.get(partnerId);
       }

       //converting String time to int
        String arr[] = time.split(":");
        int hours = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int deliveryTime = hours*60 + min;

        List<Order> orderListObj = new ArrayList<>();
        for(String orderId: orderList){
            Order orderObj = orderDetails.get(orderId);
            if(orderObj.getDeliveryTime() > deliveryTime){
                totalOrderPending++;
            }
        }

       return totalOrderPending;
    }

    public String findLastDeliveryTimeByPartnerId(String partnerId) {

       List<String> orderList = new ArrayList<>();
       if(assignedOrdersToPartner.containsKey(partnerId)){
           orderList = assignedOrdersToPartner.get(partnerId);
       }

       int orderListSize = orderList.size();
       String orderId = orderList.get(orderListSize-1);

       Order orderObj = orderDetails.get(orderId);
       int time = orderObj.getDeliveryTime();

       int hours = time/60;
       int min = time%60;

       String lastDeliveryTime = hours + ":"+min;

       return lastDeliveryTime;
    }

    public void deletePartnerById(String partnerId) {
        if(deliveryPartnerDetails.containsKey(partnerId)){
            deliveryPartnerDetails.remove(partnerId);
        }

        if(assignedOrdersToPartner.containsKey(partnerId)) {
            assignedOrdersToPartner.remove(partnerId);
        }
    }

    public void deleteOrderById(String orderId) {
       if(orderDetails.containsKey(orderId)){
           orderDetails.remove(orderId);
       }

       for(String partnerId: assignedOrdersToPartner.keySet()){
           List<String> orderList = assignedOrdersToPartner.get(partnerId);
           for(String oID: orderList){
               if(oID == orderId){
                   orderList.remove(Integer.valueOf(oID));
                   return;
               }
           }
       }

    }


}
