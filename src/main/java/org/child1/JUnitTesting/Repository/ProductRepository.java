package org.child1.JUnitTesting.Repository;

import org.child1.JUnitTesting.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    void save(Product product);
}
