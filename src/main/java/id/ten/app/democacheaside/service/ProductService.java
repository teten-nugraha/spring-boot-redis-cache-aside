package id.ten.app.democacheaside.service;

import id.ten.app.democacheaside.domain.Product;
import id.ten.app.democacheaside.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> getProduct(long id);
    void updateProduct(ProductDto productDto);
    List<Product> getAll();
}