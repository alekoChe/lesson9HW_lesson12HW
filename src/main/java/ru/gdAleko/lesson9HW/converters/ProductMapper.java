package ru.gdAleko.lesson9HW.converters;

import lombok.RequiredArgsConstructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.models.entities.Product;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);

    @InheritInverseConfiguration
    ProductDto fromProduct(Product product);

    List<Product> toProductList(List<ProductDto> productDtos);
    List<ProductDto> fromProductList(List<Product> products);

    //List<Map.Entry<Product, Integer>> orderMapList;

}
