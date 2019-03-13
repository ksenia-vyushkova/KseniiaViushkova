package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(parallel = true)
    public Object[][] benefitTextDataProvider() {
        return new Object[][]{
                {"To include good practices\nand ideas from successful\nEPAM project", 0},
                {"To be flexible and\ncustomizable", 1},
                {"To be multiplatform", 2},
                {"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…", 3}
        };
    }
}