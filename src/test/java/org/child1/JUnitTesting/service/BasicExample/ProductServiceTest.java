package org.child1.JUnitTesting.service.BasicExample;

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

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    //Obj of ProductService created.
    @InjectMocks
    ProductService productService;   //but this is null as not initialised, it depends
    //on ProductRepository as well so initialise that as well
    //Now this InjectMock , injects the dependency needed by productService if present
    //here the mock obj of Product Repo is present , so injects that, while still keeping
    //productService as mock obj.(So a MockitoMock obj is inserted amd is capable of doing
    //the save function). But that save is giving null as it is mock obj so not actually
    //performing db save,as some rubbish data would then have been saved,so returns null obj.
    // if we do :
    //ProductService productService=new ProductService(new ProductRepository()); // and
    //lot other things as service needs obj of Repository m which itself is an interface
    // so creating a real world obj is not feasible here . So we need to create a Mock obj.
    // so this mock obj of ProductService is created with the help of Mockito. So the
    //@Mock annotation, helps it to be treated as mock object, but only this much is not
    //enough as Mock obj are not initialed unless extend with Mockito Extension, only then
    //initialed with dummy values .
    @Test
    //this annotation makes the function as a test, and enables it to run as a test and
    //do stuffs for you (like debug and all). The name of the test should be meaningful.
    //this method is to test addProducts method in the service class

    //In order to test this addProduct method we need to call this method inside our test
    //and in order to call we first need to create obj of ProductService class as inside this
    //class. So create that.
    void addProductShouldAddSuccessfully()
    {
        Product product=new Product();
        product.setId(1);
        product.setName("Harry Potter");
        //now we can call this method by this obj, but see it is expecting obj of Product
        //so create one and add
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product addedproduct=productService.addProduct(product);
        //so this addedproduct which we have captured is null
        //so what is the actual test logic:
        //so using that addedproduct you could have test that the product which we are
        //adding is corrected or not, i.e. matching with the one we have created, and the
        //one which is returning (but here it is returning null)
        //tested product==matched product , so that is what you want to assert(test) , if
        //that is true then it is passed otherwise it is failed .
        //so we need some kind of obj to assert, so we can mock this save method from this
        //ProductRepository in our test(so that it returns an obj), for that we can do Mockito
        //with a cond, so .when() method will specify when this is Mock will be created
        //so I will do when this save method is called with the help of the productRepo, with
        //the product that we are adding, thenReturn() (another func), the same product. So,
        //by mocking the save method we returned the same product, so now this addedproduct,
        //contains the same product.(some random id). So that's how you add data , and mock
        //db calls and test it . Let's add few details inside product. Now see use of assertions
        //so our checking condition is converted to assertions.
        //so do Assertions. so coming from junit lib.
        Assertions.assertEquals(product.getId(),addedproduct.getId());
        //so has 2 arg, 1st is expected , so my product.getId whatever it is returning,
        //should be matched with , my addedProduct.getId() as both are equal(I actually have
        //this). So this func should return true. Assertions has a lot more we will see later.
        //If I purposely pass diff id the test will fail , saying expected different from
        //actual , so like this in future if you do some change in the code , it may fail
        //saying assertions didn't pass.
        Assertions.assertNotNull(addedproduct); //when I don't want my addproduct to be null
        //assertEquals , can be used to check names and other feilds as well.
        Assertions.assertTrue(product.getId()==1); // the condition inside this
        //should be true , s o the productId that I m passing should be equals to one.(If
        //true, then pass , otherwise fail) .
        //All tests should pass in order to make it pass as a whole.
        //(You can do static insertion of Assertions, so that you don't have to write Assertions
        // .func() , you can directly write func(). same for Mockito
        //So we have our code divided into 4 parts, obj initialisation(setting), then we
        //have mocking calls , then actual func and db calls, then assertuions, so write
        //them in 1 line separations.
    }
}
