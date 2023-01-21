package com.mjc.stage2;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;
import com.mjc.stage2.impl.MaxPriceFilteringStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Manufacture1Product1", 101, "Manufacture1");
        Product product2 = new Product("Manufacture1Product2", 111, "Manufacture1");
        Product product3 = new Product("Manufacture1Product3", 121, "Manufacture1");

        Product product4 = new Product("Manufacture2Product1", 102, "Manufacture2");
        Product product5 = new Product("Manufacture2Product2", 112, "Manufacture2");
        Product product6 = new Product("Manufacture2Product3", 122, "Manufacture2");

        List<Product> productList = new ArrayList<>();
        List<Product> filteredProductList;

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);

        ShopStock shopStock = new ShopStock(productList);

        filteredProductList = shopStock.executeFilteringStrategy(new ManufactureFilteringStrategy("manufacture2"));
        System.out.println("Filtering by Manufacture");
        for (Product product : filteredProductList) {
            System.out.println(product.getName());
        }

        filteredProductList = shopStock.executeFilteringStrategy(new MaxPriceFilteringStrategy(110));
        System.out.println("Filtering by Maximum price");
        for (Product product : filteredProductList) {
            System.out.println(product.getName() + " >> " + product.getPrice());
        }

    }
}
