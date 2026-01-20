package org.child1.JUnitTesting.service.AnnoationUnitTestLifeCycle;

public class Main {
    public static void main(String[] args) {
        //The test LifeCycle involves:
        //Annotations- Use
        //1.BeforeAll- Class Level SetUp
        //2.BeforeEach- SetUp
        //3.Test- Test Execution
        //4.AfterEach- CleanUp
        //5.AfterAll- Class Level CleanUp

        //@BeforeAll this method will run before any of the tests run , so used to do
        //setup when the class loads , so static, hence variables used inside of it will
        //also be static. Before execution of all the tests , inside the test class , if
        //we want to do some sort of setup. And this method will be involed only once.
        //@BeforeEach this method will executed before each test , in your test class, and
        //this will not be static.
        //@Test , after the execution of the above 2 annotation , the execution of test will
        //start
        //@After each and @After all is similar to the above 2 , it's just it's a negative case
        //as before you were doing setup, now you will do cleanup. After each is called after
        //execution of each tests , and after all is called , at the end of all the tests execution
        //@After all is used for cleaning up class level data
    }
}

