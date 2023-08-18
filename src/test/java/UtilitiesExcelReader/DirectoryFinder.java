package UtilitiesExcelReader;

import org.testng.annotations.Test;

public class DirectoryFinder {
    @Test
    public void findDirectory(){
        System.out.println(System.getProperty("user.dir"));
    }
}
