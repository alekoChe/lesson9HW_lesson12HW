package ru.gdAleko.lesson9HW.converters;

import org.springframework.stereotype.Component;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.models.entities.Product;

@Component
public class ProductConverter {

//    public Product dtoToEntity(ProductDto productDto) {
//        //return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice(), product.getPurchasePrice());
//        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice(), 0);
//    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
