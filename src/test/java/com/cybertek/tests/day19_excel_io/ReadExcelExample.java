package com.cybertek.tests.day19_excel_io;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelExample {
    // path to the location of the excel file.
    private String filePath = "src/test/resources/Vytrack testusers.xlsx";
    // creates connection between jvm and the file.
    private FileInputStream fileInputStream;
    // represents the excel file
    private Workbook workbook;
    // represents the sheet that contains the actual data
    private Sheet workSheet;

    @BeforeMethod
    public void setUp() throws IOException {
        // initialize the input stream by giving the file location
        fileInputStream = new FileInputStream(filePath);
        // create the workbook the input stream
        // WorkbookFactory.create --> this is used to create workbook from inputstream
        workbook = WorkbookFactory.create(fileInputStream);
        // workbook.getSheetAt --> get the sheet from excel based on 0 based count
//        workSheet = workbook.getSheetAt(5);
        // workbook.getSheet --> get sheet using name
        workSheet = workbook.getSheet("QA3-short"); }

    @Test
    public void rowAndColumnCount() {
        System.out.println(workSheet.getSheetName());/////////////////////////////////////////
        // returns the last row num based on 0 count
        int lastRownIndex = workSheet.getLastRowNum();////////////////////////////////////////
        System.out.println("last row index = " + lastRownIndex);//////////////////////////////
        // gives us the number of rows
        int rowCount = workSheet.getPhysicalNumberOfRows();
        System.out.println("rowCount = " + rowCount);
        // there is no direct way to get the number of cols.
        // workSheet.getRow(0) --> we will get the  first row and
        // getLastCellNum(); --> get number cells in that row
        int colCount = workSheet.getRow(0).getLastCellNum();////////////////////////////////////////////////
        System.out.println("colCount = " + colCount); }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close(); }

    @Test
    public void readSingleCell() {
        // to read data from cell:
        // workSheet.getRow(7)--> get the row using 0 based index
        // represents a row in worksheet
        Row row = workSheet.getRow(11);/////////////////////////////////////////////////////////////
        // row.getCell(2); --> get specific cell from that row, 0 based count
        // Cell --> represents a cell from a row
        Cell cell = row.getCell(2);/////////////////////////////////////////////////////////////////
        // get data from the cell
        String value = cell.toString();////////////////////////////////////////////////////
        System.out.println("value = " + value); }

    @Test
    public void printWholeRow(){
        // get the row
        Row row = workSheet.getRow(0);
        int colCount = row.getLastCellNum();/////////////////////////////////////////////////////
        System.out.println("colCount = " + colCount);

        for (int i = 0; i < colCount; i++) {
            Cell cell = row.getCell(i);/////////////////////////////////////////////////////////
            System.out.println("cell "+i+": = " + cell.toString()); } }

    @Test
    public void readWholeSheet(){
        // i use nested for loop to get all excel data. outer loops gets the rows, inner loop get cells from specific row
        int rowCount = workSheet.getPhysicalNumberOfRows();//row sayi
        int colCount = workSheet.getRow(0).getLastCellNum();//cell sayi
        System.out.println("rowCount = " + rowCount);
        System.out.println("colCount = " + colCount);
        // iterate through the table
        for (int i = 0; i < rowCount; i++) {
            // get row with current index
            Row currentRow = workSheet.getRow(i);////////////////////////////////////////////////////
            // iterate through the row
            for (int j = 0; j < colCount; j++) {
                // get current cell
                Cell cell = currentRow.getCell(j);//////////////////////////////////////////////////
                // get cell value
                String value = cell.toString();
                System.out.print("row "+i+ ", col: "+ j+": " + value+"\t");
            }
            System.out.println();
            System.out.println(); } }}





