package ru.gdAleko.lesson9HW.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gdAleko.lesson9HW.models.Cart;
import ru.gdAleko.lesson9HW.models.PurchaseProducts;
import ru.gdAleko.lesson9HW.models.entities.Order;
import ru.gdAleko.lesson9HW.models.entities.Product;
import ru.gdAleko.lesson9HW.models.entities.User;
import ru.gdAleko.lesson9HW.repositories.ProductsRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private ProductsRepository productsRepository;
    private Cart cart;
    //private PurchaseProducts purchaseProducts;

    private List<Product> cartLList;
    //private Map<Product, Integer> orderList;
    //private List<Map.Entry<Product, Integer>> orderMapList;
    private List<PurchaseProducts> purchaseProductsList;

    public void createOrder(User user, List<Product> productList) {
        Order order = new Order();
        order.setUser(user);
        order.setProductList(productList);
    }

    public void deleteProductFromCartList(Long id) {
        cartLList.removeIf(x -> x.getId().equals(id));
    }

    public void addProductIntoCart(Long id, Integer quantity) {
        Product product = productsRepository.findById(id).orElseThrow();
        PurchaseProducts purchaseProducts = new PurchaseProducts(product, quantity);
        cart.addProductIntoCart(purchaseProducts);
    }

    public void addProductIntoCart(PurchaseProducts purchaseProducts) {
        cart.addProductIntoCart(purchaseProducts);
    }

    public List<PurchaseProducts> getPurchaseProductsList() {
        return cart.getPurchaseList();
    }
}
