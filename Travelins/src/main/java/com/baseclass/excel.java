package com.baseclass;

import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
		
	public void writeToExcel(String[] stringArray)
	{
		//Load workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Load sheet - Here we are loading first sheet only
        XSSFSheet sheet = workbook.createSheet("sheet1"); 
    
        int rownum = 0; 
        for (String s : stringArray) { 
            Row row = sheet.createRow(rownum++); 
            int cellnum = 0; 
                Cell cell = row.createCell(cellnum++); 
                    cell.setCellValue((String)s); 
        }
        try { 
        	//here we need to specify where you want to save file
            FileOutputStream out = new FileOutputStream(new File("E:\\srikanth\\ecl\\Travelins\\new.xlsx")); 
            
            //finally write content
            workbook.write(out); 
            
            //close the file
            out.close(); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        
	}}