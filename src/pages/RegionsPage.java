
package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage extends Page {
    
    private void clickOnAddRegion(){
        clickOnElement(By.className("pull-right"));
    }
    
    private void clickOnEditButton(WebElement row){
        clickOnElement(row.findElement(By.cssSelector(".ui-sortable a[title='Edit']")));
    }
    
    private void clickOnSaveRegionButton(){
        clickOnElement(By.id("save-region-button"));
    }

    private void sendTextOnTitleField(){
        sendTextOnField(By.id("title"));
    }
    
    private void sendTextOnTitleFieldWithClear(){
        sendTextOnField(By.id("title"));
    }
    
     private List<WebElement> getRowsFromTable() {
        WebElement tableBody = waitForElementVisibility(By.className("ui-sortable"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        return rows;
    }
     
    private WebElement chooseFirstRow() {
        List<WebElement> rows = getRowsFromTable();
        WebElement firstRow = rows.get(0);

        return firstRow;
    }

    private WebElement chooseRandomRow() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));

        return randomRow;
    }

    private WebElement chooseLastRow() {
        List<WebElement> rows = getRowsFromTable();
        
        return rows.get(rows.size() - 1);
    }
    
    private void clickOnDisableButton(WebElement row){
        clickOnElement(row.findElement(By.cssSelector("button[title='Disable']")));
    }
    
    private void clickOnConfirmButtonDisable(){
        waitForElementVisibility(By.cssSelector("#regionDisableDialog button[data-task='confirm']"));
    }
    
    private void clickOnEnableButton(WebElement row){
        clickOnElement(row.findElement(By.cssSelector("button[title='Enable']")));
    }
    
    private void clickOnConfirmButtonEnable(){
        waitForElementVisibility(By.cssSelector("#regionEnableDialog button[data-task='confirm']"));
    }
    
    private void clickOnDeleteButton(WebElement row){
        clickOnElement(row.findElement(By.cssSelector("button[title='Delete']")));
    }
    
    private void clickOnConfirmButton(){
         waitForElementVisibility(By.cssSelector("#regionDeleteDialog button[data-task='confirm']"));
     }
    
    //    -- PUBLIC METHODS --

    public void addNewRegion(){
        clickOnAddRegion();
        sendTextOnTitleField();
        clickOnSaveRegionButton();
    }
    
    public void editFirstRegion(){
        WebElement firstRow = chooseFirstRow();
        clickOnEditButton(firstRow);
        sendTextOnTitleFieldWithClear();
        clickOnSaveRegionButton();
    }
    
    public void editRandomRegion(){
        WebElement randomRow = chooseRandomRow();
        clickOnEditButton(randomRow);
        sendTextOnTitleFieldWithClear();
        clickOnSaveRegionButton();
    }
    
    public void editLastRegion(){
        WebElement lastRow = chooseLastRow();
        clickOnEditButton(lastRow);
        sendTextOnTitleFieldWithClear();
        clickOnSaveRegionButton();
    }
}
