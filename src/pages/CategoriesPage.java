
package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage extends Page {
    //    -- ClickOn methods

    private void clickOnAddCategoryButton() {
        clickOnElement(By.className("pull-right"));
    }

    private void clickOnDeleteButton(WebElement row) {
        row.findElement(By.cssSelector("button[title='Delete']")).click();

    }

    private void clickOnConfirmButton() {
        clickOnElement(By.cssSelector("#categoryDeleteDialog button[data-task='confirm']"));
    }

    private void clickOnSaveCategoryButton() {
        clickOnElement(By.id("save-category-button"));
    }

    private void clickOnEditButton(WebElement row) {
        WebElement editButton = row.findElement(By.className("btn-default"));
        editButton.click();
    }

//    -- SendText methods
    private void sendTextOnTitleField() {
        sendTextOnField(By.id("title"));
    }

    private void sendTextOnTitleFieldWithClear() {
        sendTextOnField(By.id("title"));
//        WebElement titleField = driver.findElement(By.id("title"));
//        titleField.clear();
//        titleField.sendKeys(Helper.getRandomText());
    }

//    -- Finding row
    
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

        WebElement randomRow = rows.get(Helper.getRandomIntiger(rows.size()));

        return randomRow;
    }

    private WebElement chooseLastRow() {
        List<WebElement> rows = getRowsFromTable();

//        WebElement lastRow = rows.get(rows.size() - 1);
//        return lastRow;
        return rows.get(rows.size() - 1);
    }

//    -- PUBLIC METHODS --
    
    public void addNewCategoy() {
        clickOnAddCategoryButton();
        sendTextOnTitleField();
        clickOnSaveCategoryButton();
    }

    public void editLastCategory() {

        WebElement lastRow = chooseLastRow();
        clickOnEditButton(lastRow);
        sendTextOnField(By.id("title"));
        clickOnSaveCategoryButton();

    }

    public void editRandomCategory() {

        WebElement randomRow = chooseRandomRow();
        clickOnEditButton(randomRow);
        sendTextOnField(By.id("title"));
        clickOnSaveCategoryButton();

    }

    public void editFirstCategory() {
        WebElement firstRow = chooseFirstRow();
        clickOnEditButton(firstRow);
        sendTextOnField(By.id("title"));
        clickOnSaveCategoryButton();
    }

    public void deleteFirstCategory(WebDriverWait wait) {
        WebElement firstRow = chooseFirstRow();
        clickOnDeleteButton(firstRow);
        clickOnConfirmButton();
    }

    public void deleteRandomCategory(WebDriverWait wait) {
        WebElement randomRow = chooseRandomRow();
        clickOnDeleteButton(randomRow);
        clickOnConfirmButton();
    }

    public void deleteLastCategory(WebDriverWait wait) {
        WebElement lastRow = chooseLastRow();
        clickOnDeleteButton(lastRow);
        clickOnConfirmButton();
    }
}
