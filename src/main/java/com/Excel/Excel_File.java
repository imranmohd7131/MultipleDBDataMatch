//package com.Excel;
//
//import org.springframework.stereotype.Component;
//
//import com.db2.config.entity.Subscription;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//@Component
//public class Excel_File {
////, List<Subscription> data
//	public String getFile(Subscription getData) {
//
////		String excelFilePath = "/home/ashu/Data.xlsx";
//		String excelFilePath = "chk.xlsx";
//		XSSFWorkbook workbook = new XSSFWorkbook(); // create workbook in .xlsx format
//		XSSFSheet sheet = workbook.createSheet("Subscribe"); // create sheet
//		XSSFSheet sheet2 = workbook.createSheet("Charged");
//		XSSFCellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//
//		int r = 1;
//		
//		int r2=1;
//		
////			if(getData.isEmpty()) {
////				
////			}else {
//				
//				font.setFontHeightInPoints((short) 15);
//				font.setBold(true);
//				style.setFont(font);
//				
//				XSSFRow row=sheet.createRow(0);
//				XSSFCell cell=row.createCell(0);
//				cell.setCellValue("ANI");
//				cell.setCellStyle(style);
//				
//				
//				
//				for(Subscription tr : getData) {
//					
//					row=sheet.createRow(r++);
//					
//					System.out.println(tr.getAni());
//					
//				 
//					row.createCell(0).setCellValue(tr.getAni());	
//		
//				}
//				
//				
////				XSSFRow roww=sheet2.createRow(0);
////				
////				XSSFCell celll=roww.createCell(0);
////				celll=roww.createCell(1);
////				celll.setCellValue("Successfully Charged");
////				
////				celll=roww.createCell(2);
////				celll.setCellValue("Amount");
////				
////				
////		
////				
////				for(Subscription tr : getData) {
////					roww=sheet.createRow(r2++);
////				 
////					roww.createCell(1).setCellValue(tr.getAni());	
////					roww.createCell(2).setCellValue(tr.getDefault_amount());
////				}
//				
//				
//			FileOutputStream outputStream;
//			try {
//				outputStream = new FileOutputStream(excelFilePath);
//				workbook.write(outputStream);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
////			}
//			return "success";
//
//		}
//		
//		
//		
//		
//		
////	int r2=1;
//
////		font.setFontHeightInPoints((short) 15);
////		font.setBold(true);
////		style.setFont(font);
////
////		XSSFRow roww = sheet.createRow(0);
////		XSSFCell celll = roww.createCell(0);
////		celll.setCellValue("ANI");
////		celll.setCellStyle(style);
////
//////		int r4 = 0;
//////		int count=0;
////		for (Subscription tr : getData) {
////			
////			roww = sheet.createRow(r++);
////			roww.createCell(0).setCellValue(tr.getAni());
//////			roww = sheet.createRow(r++);
//////			r4++;
//////			System.out.println("ob subscribe  "+tr);
//////			
//////			count=count+1;
//////			System.out.println("count subscribe "+count);
//////			roww.createCell(0).setCellValue(count);
////		}
////		
////		//roww.createCell(0).setCellValue(count);
////		
//////		XSSFRow row = sheet2.createRow(0); // second sheet in excel file
//////
//////		XSSFCell cell = row.createCell(0);
//////		cell.setCellValue("Successfully Charged");
//////		cell.setCellStyle(style);
//////
//////		cell = row.createCell(1);
//////		cell.setCellValue("Amount");
//////		cell.setCellStyle(style);
//////
////////		int r33 = 0;
////////		int total_ba = 0;
//////
////////		int r44 = 0;
//////		int r2 = 1;
//////		int count2=0;
//////		for (Subscription tr : data) {
//////			// r44++;
////////			row = sheet2.createRow(r2++);
//////			System.err.println("ob charged "+tr);
//////			System.out.println("count charged "+count2++);
////////			row.createCell(0).setCellValue(count2);
////////			row.createCell(0).setCellValue(tr.getAni());
////////			row.createCell(1).setCellValue(tr.getDefault_amount());
//////		}
//////		row = sheet2.createRow(r2++);
//////		row.createCell(0).setCellValue(count2);
////		
////		FileOutputStream outputStream;
////		try {
////			outputStream = new FileOutputStream(excelFilePath);
////			workbook.write(outputStream);
////		} catch (FileNotFoundException e) {
////			e.printStackTrace();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		return "success";
////
////	}
//
//}
