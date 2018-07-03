
package pages;

import framework.Page;
import org.openqa.selenium.By;

public class RegionsPage extends Page {
    
    public void clickOnAddRegion(){
        clickOnElement(By.className("pull-right"));
    }
    
    
}
