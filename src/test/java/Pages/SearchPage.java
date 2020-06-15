package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class SearchPage
{
    private WebDriver webDriver;
    private Actions actions;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
        actions = new Actions(driver);
    }

    @FindBy(how = How.NAME, using = "q")
    public WebElement txtSearch;

    @FindBy(how = How.NAME, using = "btnK")
    public WebElement btnSearch;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "After Life (TV Series 2019– ) - IMDb") // I wasn't able to make it accept dynamic text.
    public WebElement searchResult;

    @FindBy(how = How.XPATH, using = "//*[@class='cast_list']")
    public WebElement castList;

    public void search(String searchString)
    {
        txtSearch.sendKeys(searchString);
    }

    public void clickSearch()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        btnSearch.submit();
    }

    public void openDesiredResult()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));

        searchResult.click();
        /*
        I was unable to click open in new tab after right clicking.
         */

    }

    public void getAllCast()
    {
        int listSize = 43;
        WebDriverWait wait = new WebDriverWait(webDriver, 25);
        wait.until(ExpectedConditions.visibilityOf(castList));

        List<String> cast = new ArrayList<>();

        for(int i = 2; i<listSize; i=i+2 )
        {
            String xpath =   "//*[@class='cast_list']/tbody/tr[" + i +"]/td[2]";
            cast.add(webDriver.findElement(By.xpath(xpath)).getAttribute("innerText"));
        }

    }
}
