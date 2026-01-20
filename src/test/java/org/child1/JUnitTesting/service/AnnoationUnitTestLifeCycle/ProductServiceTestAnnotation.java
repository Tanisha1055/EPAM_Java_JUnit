package org.child1.JUnitTesting.service.AnnoationUnitTestLifeCycle;

import org.child1.JUnitTesting.Entity.Product;
import org.child1.JUnitTesting.Repository.ProductRepository;
import org.child1.JUnitTesting.Service.ProductService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTestAnnotation {
    //runs before any method, used for initialisation setup (if run some other tests then
    //also this beforeAll is executed).(Printed only once). This method can be used when
    // you are dealing with db connections, let's say you want mock db connections.
    @BeforeAll
    public static void init()     //it should be static, as class level loading
    {
        System.out.println("Before all");
    }
    //Before each test before each is called . It is used for preparing test surroundings
    //as there might be some dynamic obj for your tests, which may be different for each
    //of the test , so you can tweak tehe data before each test and you can run this particular
    //method , before each test and oprepare that kind of data setup
    @BeforeEach
    public void initEach()
    {
        System.out.println("Before each");
    }
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
    //after all can be used to destroy db connections
    @AfterAll
    public static void Destroy()
    {
        System.out.println("AfterAll");
    }
    //This after each can be used to reset some values as you may be having variables
    @AfterEach
    public void cleanup()
    {
        System.out.println("AfterEach");
    }
}
