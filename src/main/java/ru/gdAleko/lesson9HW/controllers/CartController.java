package ru.gdAleko.lesson9HW.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.models.PurchaseProducts;
import ru.gdAleko.lesson9HW.models.entities.Product;
import ru.gdAleko.lesson9HW.services.CartService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<PurchaseProducts> getCartList() {
        return cartService.getPurchaseProductsList();
    }
}
