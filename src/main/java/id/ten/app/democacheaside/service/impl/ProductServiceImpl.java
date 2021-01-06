package id.ten.app.democacheaside.service.impl;

import id.ten.app.democacheaside.domain.Product;
import id.ten.app.democacheaside.dto.ProductDto;
import id.ten.app.democacheaside.repository.ProductRepository;
import id.ten.app.democacheaside.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDto> getProduct(long id) {
        return this.productRepository
                .findById(id)
                .map(this::entityToDto);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        this.productRepository
                .findById(productDto.getId())
                .map(p -> this.setQuantityAvailable(p, productDto))
                .ifPresent(this.productRepository::save);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    private ProductDto entityToDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantityAvailable(product.getQtyAvailable());
        return dto;
    }

    private Product setQuantityAvailable(Product product, ProductDto dto){
        product.setQtyAvailable(dto.getQuantityAvailable());
        return product;
    }
}
