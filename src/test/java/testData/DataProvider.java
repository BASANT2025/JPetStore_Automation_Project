package testData;

import static Utilities.U03_Data.getJsonDataAsObjectArray;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "loginDataProvider")
    public Object[][] getData() {
        // "loginData" is the name of the file without the .json extension
        return getJsonDataAsObjectArray("Login_TestCases");
    }
}
