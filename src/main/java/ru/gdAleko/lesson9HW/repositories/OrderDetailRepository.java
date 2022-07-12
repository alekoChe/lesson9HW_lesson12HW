package ru.gdAleko.lesson9HW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gdAleko.lesson9HW.models.entities.Order;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}
