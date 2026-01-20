package org.child1.JUnitTesting.service.TestPrivateMethods;

import org.child1.JUnitTesting.Entity.Product;
import org.child1.JUnitTesting.Repository.ProductRepository;
import org.child1.JUnitTesting.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTestPrivate {

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
        //We need to get that method from the class first, so we can't call it using the obj
        //or mocks of the class as not public but private. So we need yo get that first, we
        //can do that with the help of reflections. So we can do ProductService,class(so
        //we have got a class now), after that I can use the getDeclaredmethods func and pass
        //the req func name , so that DeclaredMethod takes 2 arg, 1st the method name, then
        //the parameter type, here it is String, so I will do String.class(so at runtime an
        //obj of String class will be injected(Reflections). Now we need to handle the exceptions
        //as if the method is not present it will throw NoSuchMethodException so handle that
        //So I catched this method in a variable of Method type (this Method comes from
        //java.lang.reflect which one kind of reflections that we have.
         Method validateProductName= ProductService.class.getDeclaredMethod("validateProductName", String.class);
         //Done by Reflection
         validateProductName.setAccessible(true);
        //Now once I have that method(as a variable), I can do invoke on it(call it), with what
        //parameter. Let's see what parameter does invoke needs, it needs to 2 arg, 1st is the
        //obj so that is ProductService(as obj of that needed), 2nd is the parameter, so pass
        //"Book" as the string. So this invoke method also throws some excepotion by deafult
        //so add it in method signature (auto add) . Now this method will also return us
        //something , so just catch it in a variable of Boolean type , and convert the result
        //to boolean type only(type cast it), as we will be working with the boolean type of
        //result only (assertions onl that).(The variableName and the obj in the arg are 2
        //different thing).
        Boolean book= (Boolean) validateProductName.invoke(productService,"Book");
        //now I have a book which is a boolean obj, so just pass it in assertTrue.
        assertTrue(book);
        //still it will fail , as the ProductService will still not be able to access the
        //obj of Product class, so to overcome that we will do setAccessible as true(passed
        //as an arg). This is a functionality provided by your Java Reflections, that you
        //can make this private method accessible for testing purpose.
    }

    //The above one is a positive case to make neg case test , we can change the method name
    //same code inside , just give empty string instead of "Book". And I will do assertFalse
    //in place of true , as I am asserting for the false (so in order to make the test case
    //pass , as all the test case defined for custom purpose should pass, indicating that
    //they are passing the defined functionality as expected , so if passed wrong string
    //we are checking that by defining the failing condition that it should fail ,and
    //yes it i sfailing (we don't do half pass , half fail as then I won't know whether
    //the test defined are worjing correctly or failing purposefully , so pass of all
    //would indicate that all testa are working fine as expected(beg=haviour)).
}
