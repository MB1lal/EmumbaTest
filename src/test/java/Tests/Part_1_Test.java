package Tests;

import Base.*;
import Pages.SearchPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.ExcelReader;


public class Part_1_Test {

    private boolean status = false;

    @BeforeClass
    void setup()
    {
        Utilities.ExcelReader excelReader = Utilities.ExcelReader.getInstance();
        try
        {
            BaseUtil.sheetData = excelReader.readExcel("Input");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


 @Test(priority = 0)
    void openGoogle()
 {
    BaseUtil.webDriver.get(BaseUtil.sheetData.get(0).get(1));
 }

 @Test(priority = 1)
    void searchString()
 {
     SearchPage page = new SearchPage(BaseUtil.webDriver);
     page.search(BaseUtil.sheetData.get(1).get(1));
 }

    @Test(priority = 2)
    void clickSearch()
    {
        SearchPage page = new SearchPage(BaseUtil.webDriver);
        page.clickSearch();
    }

    @Test(priority = 3)
    void openSearchLink()
    {
        SearchPage page = new SearchPage(BaseUtil.webDriver);
        page.openDesiredResult();
    }

    @Test(priority = 4)
    void castFetch()
    {
        SearchPage page = new SearchPage(BaseUtil.webDriver);
        page.getAllCast();
    }
}
