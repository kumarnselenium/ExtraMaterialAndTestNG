package utilities;

import org.junit.Test;

public class ExForDataTable {

	@Test
	public void example()
	{
		DataTable oDT = new DataTable("/Users/narkandukuri/Documents/Personal/Sel/P3C1/Deal4Loan.xls", "emiCalc");
		System.out.println(oDT.columnCount());
		System.out.println(oDT.rowCount());
		System.out.println(oDT.getCellData(1, 1));
		System.out.println(oDT.getCellData("LoanAmount", 1));
	}
	
}
