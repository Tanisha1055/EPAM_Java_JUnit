package org.child1.JUnitTesting.service.TestPrivateMethods;

public class Main {
    public static void main(String[] args) {
        //Now we have a private method inside ProductService, I will make use of it inside
        //addProduct that I have to verify the name, so I will call this method with
        //product.getName() as the parameter and I will catch this result in the boolean
        //variable b. And then I can add a condition that if validation is true then only
        //save the product, otherwise throw exception. So If I execute my add product test,
        //it should work fine. But if I remove this setName to set it empty, this test will
        // and throw runtime Exception as specified. So basically this private product will
        //in the flow of public method (as it is a helper function, only concerned with the
        //class, and not with the obj. (If it is not coming then it is not used, if it is
        //unused then what is the use of writing it. So we need to add a negative scenario
        //as well that if the name is not matching, that is why validated it first and threw
        //error (exception), in case of negation, inside the addProduct test. But if the
        //interviewer wants to test the private method separately (outside of public, how will
        //do it). So the problem arises that how will you call this method in the test file
        //directly, you can't call it as it is private, and not public(how will you access it).
        //so you can do that with the help of Java Reflections.
    }
}
