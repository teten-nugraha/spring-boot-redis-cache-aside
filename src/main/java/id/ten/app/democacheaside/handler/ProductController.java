package id.ten.app.democacheaside.handler;

import id.ten.app.democacheaside.dto.ProductDto;
import id.ten.app.democacheaside.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id){
        return this.productService.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PatchMapping("/product")
    public void updateProduct(@RequestBody ProductDto dto){
        this.productService.updateProduct(dto);
    }

}
