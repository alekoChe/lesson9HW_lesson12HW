package ru.gdAleko.lesson9HW.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gdAleko.lesson9HW.models.entities.Product;
//import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;
//import ru.gdAleko.lesson9HW.models.entities.

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Component
@Scope("session")
public class Cart {

    private PurchaseProducts purchaseProducts;
    private List<PurchaseProducts> purchaseList;

    @PostConstruct
    public void init() {
        purchaseList = new ArrayList<>();
    }

    public void deleteProductFromCart(PurchaseProducts purchaseProducts) {
        purchaseList.remove(purchaseProducts);
    }

    public PurchaseProducts changeQuantityProduct(PurchaseProducts purchaseProducts, int newQuantity) {
        return purchaseProducts.changeQuantity(purchaseProducts, newQuantity);
    }

    public void addProductIntoCart(PurchaseProducts purchaseProducts) {
        purchaseList.add(purchaseProducts);
    }

    public List<PurchaseProducts> getPurchaseList() {
        return purchaseList;
    }

}
