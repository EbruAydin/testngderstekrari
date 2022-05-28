package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    /*
    @BeforeMetod ile @AfterMethod JUnit gibi @Before ve @After gibi her test
    methodundan once ve sonra calisir
     */
    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void teachProTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
