package app;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;

public class Readxlsx {
    public XSSFWorkbook wb;
    public void read_xlsx(){
        try(InputStream in = new FileInputStream("pacifier.xlsx")){
            wb = new XSSFWorkbook(in);   
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void write_xlsx(){
        try(FileOutputStream out = new FileOutputStream("out.xlsx")){
            wb.write(out);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void head(int rows){
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            XSSFSheet sht = wb.getSheetAt(i);
            System.out.println(sht.getSheetName());

			for (int r = 0; r <= Math.min(rows, sht.getLastRowNum()); r++) {
                XSSFRow row = sht.getRow(r);
                for (int c = 0 ; c < row.getLastCellNum(); c++){
                    XSSFCell cell = row.getCell(c);
                    System.out.print(cell);
                    System.out.print("\t");
                }
                System.out.print("\n");
			}
		}
    }
    public static void main(String[] args) throws Exception {
        Readxlsx a = new Readxlsx();
        a.read_xlsx();
        a.head(3);
        a.write_xlsx();
    }
}