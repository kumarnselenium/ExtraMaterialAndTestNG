package demo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGEx {

String message = "Manisha";

   

   @Test(dependsOnMethods = { "initEnvironmentTest" })
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
     
   }

   @Test
   public void initEnvironmentTest() {
      System.out.println("This is initEnvironmentTest");
   }
}
