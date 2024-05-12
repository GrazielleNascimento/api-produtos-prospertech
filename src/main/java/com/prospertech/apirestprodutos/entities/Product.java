package com.prospertech.apirestprodutos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Name is requerid!")
    private String name;

    @NotBlank(message = "Price is required!")
    @Positive(message = "The price must be greater than zero!")
    private BigDecimal price;

    @Column(length = 500)
    @Size(max=500)
    private String description;

}
