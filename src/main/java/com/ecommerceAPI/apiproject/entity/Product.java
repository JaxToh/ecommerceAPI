package com.ecommerceAPI.apiproject.entity;
import lombok.Setter;
import lombok.Builder;
import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter



@Entity
@Table(name="product")
public class Product {



//define fields
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)

@Column(name="id")
private Long productId;

@Column(name="product_name")
@NotBlank(message = "Product name is mandatory")
private String productName;

@Column(name="product_category")
@NotBlank(message = "Product category is mandatory")
private String productCat;

@Column(name="description")
@NotBlank(message = "Product description is mandatory")
private String productDesc;

@Column(name="product_stock")
@Size(min = 0, message = "Product stock left")
private String productStock;

@Column(name="price")
private Double productPrice;
@Size(min = 0, message = "Price")


//Define constructors

@Builder
public Product(String productName, String productCat, String productDesc, String productStock, Double productPrice) {
    this.productName = productName;
    this.productCat = productCat;
    this.productDesc = productDesc;
    this.productStock = productStock;
    this.productPrice = productPrice;
}



//Define getters and setters
//lombok



//Define toString() methods
@Override
public String toString() {
    return "Product [productId=" + productId + ", productName=" + productName + ", productCat=" + productCat
            + ", productDesc=" + productDesc + ", productStock=" + productStock + ", productPrice=" + productPrice
            + "]";
}

public void add(Product product) {
}








}