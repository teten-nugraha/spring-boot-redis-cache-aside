package id.ten.app.democacheaside.dto;

import lombok.Data;

@Data
public class ProductDto {

    private long id;
    private String description;
    private double price;
    private long quantityAvailable;

}
