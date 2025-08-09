package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Data provider 1:Userlogin

	@DataProvider(name = "LoginData")
	public String[][] getLoginCellData() throws IOException {
		String path = ".//testData/userlogindetails(Validandinvalid).xlsx";

		ExcelUtils xldata = new ExcelUtils(path);

		int totalrows = xldata.getRowCount("Sheet1");     // e.g. 4 rows (0 to 3, with header)
		int totalcols = xldata.getCellCount("Sheet1", 1); // assume 3 columns

		String[][] loginData = new String[totalrows-1][totalcols]; // remove header

		for (int i = 1; i <totalrows; i++) { // i starts from 1 to skip header
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xldata.getCellData("Sheet1", i, j);
				System.out.println("Row " + (i - 1) + ", Col " + j + " = " + loginData[i - 1][j]);
			}
		}

		return loginData;
	}
}