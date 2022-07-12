package ru.gdAleko.lesson9HW.models;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gdAleko.lesson9HW.models.entities.Product;

import java.util.List;

@Component
@Scope("session")
//@Data
public class PurchaseProducts {

    private Product product;
    private  int quantity;

    public PurchaseProducts(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PurchaseProducts changeQuantity(PurchaseProducts purchaseProducts, int newQuantity) {
        return new  PurchaseProducts(purchaseProducts.getProduct(), newQuantity);
    }
}
