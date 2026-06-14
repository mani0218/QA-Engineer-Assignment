package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	private Workbook wb;
	private Sheet sh;
	String testDataPath=System.getProperty("user.dir")+"/src/test/resources/testData/TestData.xlsx";
	
	public ExcelUtils()
	{
		try {
			FileInputStream fis=new FileInputStream(new File(testDataPath));
			wb=new XSSFWorkbook(fis);
			sh=wb.getSheet("TestData");
		} catch (IOException e) {
			throw new RuntimeException("File Not found"+testDataPath);
		}
	}
	public Map<String, String> getTestData()
	{
	    Map<String, String> data = new LinkedHashMap<>();
	    DataFormatter formatter = new DataFormatter();

	    int rowCount = sh.getPhysicalNumberOfRows();
	    // skip header and loop to find respective key
	    for (int i = 1; i < rowCount; i++)
	    {
	        Row row = sh.getRow(i);
	        if (row == null)
	        {
	            continue;
	        }

	        Cell keyCell = row.getCell(0);
	        Cell valueCell = row.getCell(1);

	        String key = formatter.formatCellValue(keyCell);
	        String value = formatter.formatCellValue(valueCell);

	        if (!key.isEmpty())
	        {
	            data.put(key.trim(), value.trim());
	        }
	    }

	    return data;
	}

	public void closeExcel() throws IOException {
		wb.close();
	}

}
