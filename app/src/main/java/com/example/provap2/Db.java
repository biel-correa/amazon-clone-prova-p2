package com.example.provap2;

import com.example.provap2.models.Product;

import java.util.List;

public class Db {
    private static Db instance;
    private List<Product> products;
    
    private Db() {
        products = List.of(
                new Product(1, "Placa de video RTX 3090", 1200, 5, "A placa de video mais poderosa do mercado"),
                new Product(2, "Placa de video RTX 3080", 1000, 4, "Uma placa de video muito poderosa"),
                new Product(3, "Placa mae B450", 500, 4, "Uma placa mae de otima qualidade"),
                new Product(4, "Processador Ryzen 5 3600", 400, 2, "Um processador de otimo custo beneficio"),
                new Product(5, "Memoria RAM 8GB DDR4", 200, 3, "Uma memoria RAM de otima qualidade"),
                new Product(6, "Fonte 600W", 300, 5, "Uma fonte de otima qualidade"),
                new Product(7, "Gabinete Gamer", 250, 2, "Um gabinete de otima qualidade"),
                new Product(8, "HD 1TB", 150, 4, "Um HD de otima qualidade"),
                new Product(9, "SSD 240GB", 100, 5, "Um SSD de otima qualidade"),
                new Product(10, "Cooler RGB", 50, 3, "Um cooler de otima qualidade")
        );
    }

    public static synchronized Db getInstance() {
        if (instance == null) {
            instance = new Db();
        }
        return instance;
    }

    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
