package com.driver;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;

    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        String arr[] = deliveryTime.split(":");
        int hours = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int timeOfDelivery = hours*60 + min;

        this.id = id;
        this.deliveryTime = timeOfDelivery;
    }

    public String getId() {
        return id;
    }

    public void setDeliveryTime(String deliveryTime){
        String arr[] = deliveryTime.split(":");
        int hours = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int timeOfDelivery = hours*60 + min;

        this.deliveryTime = timeOfDelivery;
    }
    public int getDeliveryTime() {return deliveryTime;}
}
