package iuh.fit.orderservice.service;

import iuh.fit.orderservice.dto.OrderCreateRequest;
import iuh.fit.orderservice.entity.Order;
import iuh.fit.orderservice.entity.OrderItem;
import iuh.fit.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderCreateRequest request) {
 
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus("PENDING");
        order.setTotalPrice(BigDecimal.ZERO);
        order.setItems(new ArrayList<>());

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (OrderCreateRequest.OrderItemRequest itemRequest : request.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setFoodId(itemRequest.getFoodId());
            orderItem.setQuantity(itemRequest.getQuantity());
            // Use price from request if provided, otherwise use 0
            orderItem.setUnitPrice(itemRequest.getPrice() != null ? itemRequest.getPrice() : BigDecimal.ZERO);
            
            order.getItems().add(orderItem);
            totalPrice = totalPrice.add(orderItem.getTotalItemPrice());
        }

        order.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(order);
        log.info("Order created with id: {}, total: {}", savedOrder.getId(), savedOrder.getTotalPrice());
        
        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            order = orderRepository.save(order);
        }
        return order;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
