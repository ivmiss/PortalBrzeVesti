
package pages;

import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage extends Page{
    
    public SignaturesPage goToSignatures(){
        clickOnElement(By.linkText("Signatures"));
        return PageFactory.initElements(getDriver(), SignaturesPage.class);

    }
    
    public CategoriesPage goToCategories(){
        clickOnElement(By.linkText("Categories"));
            return PageFactory.initElements(getDriver(), CategoriesPage.class);

    }
    
    public RegionsPage goToRegions(){
        clickOnElement(By.linkText("Regions"));
        return PageFactory.initElements(getDriver(), RegionsPage.class);

    }
    
    public PortalsPage goToPortals(){
        clickOnElement(By.linkText("Portals"));
        return PageFactory.initElements(getDriver(), PortalsPage.class);

    }

    public SourcesPage goToSources(){
        clickOnElement(By.linkText("Sources"));
        return PageFactory.initElements(getDriver(), SourcesPage.class);

    }
    
    public void goToLogOut(){
        clickOnElement(By.linkText("Cubes QA"));
        clickOnElement(By.linkText("Logout"));
    }
}
