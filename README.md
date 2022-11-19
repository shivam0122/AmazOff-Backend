# SpringBoot Project: AmazOff-Backend

## Description of Project:

Amazoff is the new and coming delivery service started by Beff Jezos. At the end of each day, the delivery schedule for the next day is decided.

There are some orders that need to be delivered and some delivery partners who will deliver the orders. Following points will help you understand the working of Amazoff.

### 1. Orders:

_Each order has a unique orderId and a delivery time (in the 24-hour HH:MM format). This means that the order with the given Id needs to be delivered exactly at HH:MM on the next day._

_Each order is assigned to at most one delivery partner. This means that either the order is assigned to exactly one delivery partner or it is left unassigned._

### 2. Delivery Partner:

_Each delivery partner has a unique partnerId._

_Any (possibly zero) number of orders can be assigned to a delivery partner._

### Developed a simple spring boot application which supports all of the given CRUD operations.

*Created a MVC architecture with Order and DeliveryPartner as model classes,
which have some fields as their properties, constructors, and getters-setters.
Created a controller, service, and repository class with appropriate annotations. To keep it simple, I used HashMap(s) as Database.*

## functionalities are:

1. Add an Order: POST /orders/add-order  Pass the Order object as request body  Return success message wrapped in a ResponseEntity object  _Controller Name - addOrder_

2. Add a Delivery Partner: POST /orders/add-partner/{partnerId}  Pass the partnerId string as path variable  Return success message wrapped in a ResponseEntity object  _Controller Name - addPartner_

3. Assign an order to a partner: PUT /orders/add-order-partner-pair  Pass orderId and partnerId strings as request parameters  Return success message wrapped in a ResponseEntity object   _Controller Name - addOrderPartnerPair_

4. Get Order by orderId: GET /orders/get-order-by-id/{orderId}  Pass orderId string as path variable  Return Order object wrapped in a ResponseEntity object  _Controller Name - getOrderById_

5. Get Partner by partnerId: GET /orders/get-partner-by-id/{partnerId}  Pass partnerId string as path variable  Return DeliveryPartner object wrapped in a ResponseEntity object  _Controller Name - getPartnerById_

6. Get number of orders assigned to given partnerId: GET /orders/get-order-count-by-partner-id/{partnerId}  Pass partnerId as path variable  Return Integer wrapped in a ResponseEntity object  _Controller Name - getOrderCountByPartnerId_

7. Get List of all orders assigned to given partnerId: GET /orders/get-orders-by-partner-id/{partnerId}  Pass partnerId as path variable  Return List of Order object wrapped in a ResponseEntity object   _Controller Name - getOrdersByPartnerId_

8. Get List of all orders in the system: GET /orders/get-all-orders  No params or body required Return List of Order object wrapped in a ResponseEntity object   _Controller Name - getAllOrders_

9. Get count of orders which are not assigned to any partner: GET /orders/get-count-of-unassigned-orders  No params or body required  Return Integer wrapped in a ResponseEntity object  _Controller Name - getCountOfUnassignedOrders_

10. Get count of orders which are left undelivered by partnerId after given time: GET /orders/get-count-of-orders-left-after-given-time  Pass time string (in HH:MM format) and partnerId string as path variable  Return Integer wrapped in a ResponseEntity object   _Controller Name - getOrdersLeftAfterGivenTimeByPartnerId_

11. Get the time at which the last delivery is made by given partner: GET /orders/get-last-delivery-time/{partnerId}  Pass partnerId string as path variable  Return String with format HH:MM wrapped in a ResponseEntity object   _Controller Name - getLastDeliveryTimeByPartnerId_

12. Delete a partner and the corresponding orders should be unassigned: DELETE /orders/delete-partner-by-id/{partnerId}  Pass partnerId as path variable  Return success message wrapped in a ResponseEntity object  _Controller Name - deletePartnerById_

13. Delete an order and the corresponding partner should be unassigned: DELETE /orders/delete-order-by-id/{orderId}  Pass orderId as path variable  Return success message wrapped in a ResponseEntity object  _Controller Name - deleteOrderById_

