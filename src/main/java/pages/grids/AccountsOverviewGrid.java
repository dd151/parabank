package pages.grids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

public class AccountsOverviewGrid extends Page {

    @FindBy(id = "accountTable")
    private WebElement accountTable;

    public AccountsOverviewGrid() {
        PageFactory.initElements(driver, this);
    }

    public int getRowsCount() {
        return waitForAllElements(By.cssSelector("#accountTable tbody tr"), 5).size();
    }

    public String getFieldByAccountNumber(String columnName, String accountNumber) {
        if (columnName.equalsIgnoreCase("Account Number")) {
            return getText(accountTable.findElement(By.xpath(".//a[contains(text(),'" + accountNumber + "')]")));
        } else if (columnName.equalsIgnoreCase("Balance")) {
            return getText(accountTable.findElement(By.xpath(".//a[contains(text(),'" + accountNumber + "')]//following::td[1]")));
        } else if (columnName.equalsIgnoreCase("Available Amount")) {
            return getText(accountTable.findElement(By.xpath(".//a[contains(text(),'" + accountNumber + "')]//following::td[2]")));
        } else {
            throw new IllegalArgumentException(columnName);
        }
    }
}
