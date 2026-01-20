package org.child1.JUnitTesting.Service;

import org.child1.JUnitTesting.Entity.Product;
import org.child1.JUnitTesting.Repository.ProductRepository;

public class ProductService {
    public final ProductRepository productRepository;
    public Product addProduct(Product product)
    {
        System.out.println("adding product to db");
        boolean validation=validateProductName(product.getName());
        if(validation)
        {
            Product saveProduct=productRepository.save(product);
            return  saveProduct;
        }
        else
            throw new RuntimeException("Invalid Name of Product");
    }
    public void deleteProduct(Integer id)
    {
        productRepository.deleteById(id);
    }
    private boolean validateProductName(String name)
    {
       return name!=null && !name.isEmpty();
    }
}
