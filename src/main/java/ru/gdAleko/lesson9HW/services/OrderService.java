package ru.gdAleko.lesson9HW.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gdAleko.lesson9HW.models.entities.Order;
import ru.gdAleko.lesson9HW.repositories.OrderDetailRepository;
import ru.gdAleko.lesson9HW.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    //@Autowired  //
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

//    public Order getOrderByUserId(Long userId) {
//        return orderRepository.findB
//    }
}
