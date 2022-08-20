package runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.Before;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    public class Runner {

        @Before
        public void setup(){
            System.out.print("este es mi hook before");
        }

        @After
        public void cleanup(){
            System.out.print("este es mi HOOK after");
        }
}
