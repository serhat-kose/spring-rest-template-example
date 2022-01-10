package com.serhat.web.productclient.web.client;

import com.serhat.web.productclient.web.model.*;
import org.springframework.boot.context.properties.*;
import org.springframework.boot.web.client.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.net.*;

@Component
@ConfigurationProperties(value = "sk.product",ignoreUnknownFields = false)
public class ProductClient {

    private final RestTemplate restTemplate;
    private String apihost;
    public final String PRODUCT_PATH="/api/v1/product";

    public  ProductClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }

    public ProductDto getProductById(Long productId){
        return  restTemplate.getForObject(apihost + PRODUCT_PATH + productId.toString(),ProductDto.class);
    }

    public URI saveProduct(ProductDto productDto){
        return  restTemplate.postForLocation(apihost + PRODUCT_PATH,productDto);
    }

    public void updateProduct(Long productId,ProductDto productDto){
        restTemplate.put(apihost + PRODUCT_PATH + "/" + productId.toString(),productDto);
    }

    public void deleteProduct(Long productId){
        restTemplate.delete(apihost + PRODUCT_PATH + "/" + productId.toString());
    }

    public  void setApihost(String apihost){
        this.apihost=apihost;
    }
}
