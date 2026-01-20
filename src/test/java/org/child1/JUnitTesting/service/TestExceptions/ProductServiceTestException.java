package org.child1.JUnitTesting.service.TestExceptions;

import org.child1.JUnitTesting.Entity.Product;
import org.child1.JUnitTesting.Repository.ProductRepository;
import org.child1.JUnitTesting.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTestException {
    //we need to make static also, in order to be able to access it in the static
    //BeforeAll() method.
    private static Product product=null ;
    @BeforeAll
    public static void init()     //it should be static, as class level loading
    {
        //so that's how you initialise your data in init.
        product=new Product();
        product.setId(1);
        product.setName("Harry Potter");
    }
    //same for beforeEach as well, to be more exact this beforeEach is used when
    //you have to frame a new product of Product each test is expecting product with
    // different no. of arguments, as each test is modifying the parameters and each
    //tests is needing separate parameters, like in the recent case ,it needed
    //setName("") , with empty parameter. So you can do that in beforeEach as well.
    //So that is the usecase of using beforeEach and beforeAll as well.
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    void addProductShouldAddSuccessfully()
    {

        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product addedproduct=productService.addProduct(product);

        Assertions.assertNotNull(addedproduct);
        assertTrue(product.getId()==1);
    }

    @Test
    public void ProductShouldDeleteSuccessfully()
    {
        doNothing().when(productRepository).deleteById(1);
        productService.deleteProduct(1);
        Mockito.verify(productRepository,Mockito.times(1)).deleteById(1);
    }
    @Test
    public void TestPrivateValidateName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         Method validateProductName= ProductService.class.getDeclaredMethod("validateProductName", String.class);

         validateProductName.setAccessible(true);

        Boolean book= (Boolean) validateProductName.invoke(productService,"Book");

        assertTrue(book);

    }
    @Test
    void addProductShouldTestException()
    {
        //as before in initialisation we were specifying that it was empty, but here
        //we have set it to something globally , so here we have to manually set it
        //to empty in order for it , to pass this particular test.
        product.setName("");

        productService.addProduct(product);
        //rest of the normal code of add Product it won't go only as mid way exception
        //so only write the req part.
        //here we can make use of assertThrows, so we are checking whether exception is
        //thrown. Now assertThrows expect 2 arg, 1st is expected type and 2nd is executable.
        //So what is this guy expecting, it is expecting a runtime exception, so that is
        //the first arg, then the 2nd arg is executable, that is on what execution do you
        //want to throw this Runtime exception, i.e. on the addProduct(), so how do you
        //throw the executable, we add a lambda expression and paste the exact thing , that
        //means on the execution of the ProductService .addProduct() , I want to check whether
        //runtime exception is thrown. If that is thrown then this particular test will pass.
        RuntimeException runtime=assertThrows(RuntimeException.class,()->productService.addProduct(product));
        //so when I am passing empty string, it is throwing Runtime Exception, so assertThrows
        //is successful, hence the overall test. (If given some string then this test would
        //fail, but I have to check for neg scenario, that whether it is able to handle that
        //or not , so check for failing condition is passing that is throwing exceptions). So
        //this neg condition is checked. We can catch the return type of this in a variable
        //as well.
        //We can also check if the message passed by this exception is the exact one as we are
        //expecting, as Runtime Exception is a very generalised one. So we can make use of
        //assertEquals and in the arg pass the expected message in the expected feild (the
        //exact you want to check with and in the 2nd one the actual one you are getting
        //that is the message field of the RuntimeException variable runtime.
        assertEquals("Invalid Name of Product",runtime.getMessage());
        //so if the excat message is coming then this test passes. If some other exception
        //or some other message comes then this test fails , as any exception can come.
        //But we are expecting this particular one to come or show up . So we want to assert
        //that only this particular exception should be thrown if the book feild is missing.
        //and we also want to cjheck thst this productRepository.save() method is not called.
        //So we can use the same method(to check whether a method is called and how many times)
        //i.e. verify(). So productRepository method is called 0 times , on this save method.
        //Now this save() method needs parameters right , we see it needs an entity  so obj
        // of Product, and we have product, so we will give this product product to the save
        //method .
        Mockito.verify(productRepository,times(0)).save(product);
        //But let's say you don't have product available at this time,(in some scenario, or
        //if not created obj of product in the class , as not req). Then you can make use of
        //Mockito.any() , which says , let any product be there of Product.class . For any
        //obj of Product.class , check this productRepository.save() is called 0 times.
        Mockito.verify(productRepository,times(0)).save(any(Product.class));
        //Now this verification mode can also be converted to never(), that means this method
        //is never called. So instead use of 0 times you can make use of never(), it will
        //return the same .
        Mockito.verify(productRepository,never()).save(any(Product.class));

        //Now I see that I am doing this Product initialisation, in each tests , so I will
        //add it in BeforeAll method (As we need to initialise the product only once and we
        //can make use of it everywhere (optimum)),and make this obj of Product global so
        //it is accessible to all. So remove(extract) that portion of code and do that.
        //As this method is static so I will make this variable as static as well. And
        //initialise that product with null in the global portion initially and it will be
        //getting initialised in the BeforeAll block.
    }

}
