package UtilitiesExcelReader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginData {

    public static ExcelReader excel = new ExcelReader(
            // System.out.println(System.getProperty("user.dir"));
            System.getProperty ("user.dir")+"\\src\\resources\\TestData.xlsx");
    String SheetName = "LoginData";

    @DataProvider(name = "browserdata")
    public Object[][] dataProviderMethod() {
        int rows = excel.getRowCount(SheetName);
        int cols = excel.getColumnCount(SheetName);
        Object[][] data = new Object[rows - 1][cols];
        for (int rowNum=2;rowNum<=rows;rowNum++)
        {
            for (int colNum=0;colNum<cols;colNum++)
            {
                //System.out.println(excel.getCellData(SheetName, colNum, rowNum));
                data[rowNum-2][colNum]=excel.getCellData(SheetName,colNum,rowNum);
            }
        }

        return data;
    }

    @Test(dataProvider = "browserdata")
    public void testReadExcelData(String firstname, String lastname,String postcode) {
        System.out.println("firstname :" + firstname);
        System.out.println("lastname :" + lastname);
        System.out.println("postalcode :" + postcode);

    }

}
