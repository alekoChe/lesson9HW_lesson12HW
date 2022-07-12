package ru.gdAleko.lesson9HW.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gdAleko.lesson9HW.converters.ProductConverter;
import ru.gdAleko.lesson9HW.converters.ProductMapper;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.exceptions.ResourceNotFoundException;
import ru.gdAleko.lesson9HW.models.entities.Product;
import ru.gdAleko.lesson9HW.services.CartService;
import ru.gdAleko.lesson9HW.services.ProductsService;
import ru.gdAleko.lesson9HW.validators.ProductValidator;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductsController {

    //@Autowired //
    private final ProductsService productsService;
    //@Autowired  //
    //private final ProductConverter productConverter;
    //@Autowired //
    private final ProductValidator productValidator;
    //@Autowired  //
    private final ProductMapper productMapper;

    private final CartService cartService;

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productsService.findAll(minPrice, maxPrice, titlePart, page).map(
                //p -> productConverter.entityToDto(p)
                p -> productMapper.MAPPER.fromProduct(p)
        );
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        //return productConverter.entityToDto(product);
        return productMapper.MAPPER.fromProduct(product);
    }

    @GetMapping("/cart/{id}")         //@PostMapping
    public void addProductInCartPost(@RequestParam Long productId, @RequestParam(defaultValue = "1") Integer quantity) {
        cartService.addProductIntoCart(productId, quantity);
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        //Product product = productConverter.dtoToEntity(productDto);
        Product product = productMapper.MAPPER.toProduct(productDto);
        product = productsService.save(product);
        //return productConverter.entityToDto(product);
        return productMapper.MAPPER.fromProduct(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productsService.update(productDto);
        //return productConverter.entityToDto(product);
        return productMapper.MAPPER.fromProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsService.deleteById(id);
    }
}
