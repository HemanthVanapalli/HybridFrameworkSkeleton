package com.testCases;

import com.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginDD_002 {

    @Test
    public void loginDDT(String username , String password){

    }

    @DataProvider(name = "TestDataProvider")
    public Object[][] TestDataProvider() {
        Object[][] testData= ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+"/src/main/resources/testData/TestData.xlsx","Sheet1");

        return testData;
    }
}
