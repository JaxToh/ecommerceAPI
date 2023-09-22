package com.ecommerceAPI.apiproject.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "product_tbl")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "short_description", nullable = false)
  private String shortDescription;

  @Column(name = "long_description")
  private String longDescription;

  @Column(name = "price", nullable = false)
  private Double price;

  // @NotBlank(message = "Stock cannot be 0")
  // @Column(name = "stock", nullable = false)
  // private int stock;


}