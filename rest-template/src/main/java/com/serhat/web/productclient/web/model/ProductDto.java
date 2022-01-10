package com.serhat.web.productclient.web.model;

import lombok.*;

import java.math.*;
import java.util.*;


@Builder
@Data
@Getter
public class ProductDto {

    private Long id;

    private String productName;

    private  String productType;

    private BigDecimal price;

    private Long productCode;

    private Date createdTime;
}
