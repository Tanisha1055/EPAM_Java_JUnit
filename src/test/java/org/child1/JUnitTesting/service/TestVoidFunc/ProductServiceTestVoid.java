package org.child1.JUnitTesting.service.TestVoidFunc;

import org.child1.JUnitTesting.Entity.Product;
import org.child1.JUnitTesting.Repository.ProductRepository;
import org.child1.JUnitTesting.Service.ProductService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTestVoid {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    void addProductShouldAddSuccessfully()
    {
        Product product=new Product();
        product.setId(1);
        product.setName("Harry Potter");

        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product addedproduct=productService.addProduct(product);

        Assertions.assertNotNull(addedproduct);
        Assertions.assertTrue(product.getId()==1);
    }

    @Test
    public void ProductShouldDeleteSuccessfully()
    {
        doNothing().when(productRepository).deleteById(1);
        //for that I need to call this
        productService.deleteProduct(1);
        //here what we can assert that ProductRepository.deteleById is called atleast once
        //for that we can use verify() which is a method which comes from Mockito , which basically
        //which takes 2 arg, i.e. what is called and the verification mode . So it is called on
        //productRepository,(it's deleteBYId) and the verification mode is the no. of times which
        //it is called that is 1, so times(1).(This times function returns a VerificationMode
        //obj which is req by this verify method. That is not over, I have to define on which
        //method of productRepository this verification is called , so chain that method after
        //verify with the req parameter , id in this case.
        Mockito.verify(productRepository,Mockito.times(1)).deleteById(1);
        //(as above this I am calling this deleteById)
        //so with the above deleteProduct method called what to do , as prev func, I was doing
        //when and thenReturn to perform assertions.
        //but as it is returning nothing so we can make use of doNothing. So doNothing , when
        //productRepository, .deleteById() is called with Id(1), (defined the course of action
        //,as this is what is supposed to be performed
        //and now we can verify that whether this deleteById function is called once, with the
        //help of verify function.

        //so to test void returning method we use do nothing and verify functions (of Mockito).


    }
}
