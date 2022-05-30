package Pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoGuru {

    public DemoGuru(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    //(//*[text()='Consent'])[1]
}
