package pages.grids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

public class AccountActivityGrid extends Page {

    @FindBy(id = "transactionTable")
    private WebElement transactionTable;

    public AccountActivityGrid() {
        PageFactory.initElements(driver, this);
    }

    public int getRowsCount() {
        return waitForAllElements(By.cssSelector("#transactionTable tbody tr"), 5).size();
    }

    public String getFieldByIndex(String columnName, int index) {
        if (columnName.equalsIgnoreCase("Date")) {
            return getText(transactionTable.findElement(By.cssSelector("tbody tr:nth-child(" + index + ") td:nth-child(1)")));
        } else if (columnName.equalsIgnoreCase("Transaction")) {
            return getText(transactionTable.findElement(By.cssSelector("tbody tr:nth-child(" + index + ") td:nth-child(2) a")));
        } else if (columnName.equalsIgnoreCase("Debit")) {
            return getText(transactionTable.findElement(By.cssSelector("tbody tr:nth-child(" + index + ") td:nth-child(3)")));
        } else if (columnName.equalsIgnoreCase("Credit")) {
            return getText(transactionTable.findElement(By.cssSelector("tbody tr:nth-child(" + index + ") td:nth-child(4)")));
        } else {
            throw new IllegalArgumentException(columnName);
        }
    }
}
