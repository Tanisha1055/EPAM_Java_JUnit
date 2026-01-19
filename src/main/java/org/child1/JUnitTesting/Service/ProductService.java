package org.child1.JUnitTesting.Service;

import org.child1.JUnitTesting.Entity.Product;
import org.child1.JUnitTesting.Repository.ProductRepository;

public class ProductService {
    public final ProductRepository productRepository;
    public Product addProduct(Product product)
    {
        System.out.println("adding product to db");
        Product saveProduct=productRepository.save(product);
        return  saveProduct;
    }
}
