package ru.gdAleko.lesson9HW.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.models.PurchaseProducts;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
@Data
//@NoArgsConstructor  // javax.persistence.Entity
//@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;
    //private List<PurchaseProducts> purchaseProductsList;

}
