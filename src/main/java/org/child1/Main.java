package org.child1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Unit testing is the way to test the smallest part of your code , such as
        //individual methods or classes, to ensure that they work as expected.
        //for ex, we have controllers, in that I have individual methods as '/api/get' ,
        // '/api/post/' etc. In services I have method as 'get()','add()', similarly I have
        //in repository layer. So unit testing, is testing that particular method, it is not
        //concerned about any other resources or methods, it just tests that particular
        //method, it has a name similar to that method plus test, in the test package. The
        //amount of code covered in the unit test is called code coverage ,so tools like
        //SONAR will show like 80% of your lines of code are covered your unit tests.
        //Why we need unit testing ?
        //1.Fast Feedback- You made some changes in your codebase and ran your unit tests,
        //and immediately know if something is breaking.
        //2.Early bug detection- By running unit tests, you would immediately know if something
        //in your code is breaking, even before it is going to the production level.
        //3.Increase your confidence- You immediately get an idea that atleast my unit tests,
        //or the functionalities are not breaking .


        //for assert few left examples :
        // User user = userService.findUser("alice");
        //        assertNull(user);

        //Also on imp note: The obj of test class gets created for every test annotation
        //written inside the class(by default) . If you want 1 test instance for the entire
        //class , give this annotation on top of the test class:
        //@TestInstance(TestInstance.Lifecycle.PER_CLASS)
        //and in this case as we would be having only 1 instance of class , so no need to write
        //static before @BeforeAll and @AfterAll annotation classes .
    }
}