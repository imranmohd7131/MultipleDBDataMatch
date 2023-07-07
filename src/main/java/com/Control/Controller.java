package com.Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Flow.Subscriber;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.Excel.Excel_File;
import com.db1.config.entity.Promotion_base;
import com.db1.config.repo.Promotion_base_Repo;
import com.db2.config.entity.Subscription;
import com.db2.config.repo.Subscription_Repo;

@RestController
public class Controller {

	@Autowired
	Promotion_base_Repo promotion_base_Repo;

	@Autowired
	Subscription_Repo subscription_Repo;

//	@Autowired
//	Excel_File excel_File;

	@GetMapping("/pat")
	public void get() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
//		for(int i=0;i<=5;i++) {
//			System.out.println(" ");
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}
//		}

	}

	@PostMapping("/com")
	public Map<String, Integer> com(@RequestBody String req) {
		Map<String, Integer> map = new HashMap<>();
		try {
			JSONObject json = new JSONObject(req);
			String date = json.getString("date");
			System.out.println(date);

//		String excelFilePath = "/home/ashu/Count.xlsx";
//		String excelFilePath = "Count.xlsx";
//		XSSFWorkbook workbook = new XSSFWorkbook(); // create workbook in .xlsx format

//		XSSFSheet sheet = workbook.createSheet("1"); // create sheet

//		XSSFSheet sheet2 = workbook.createSheet("2");

//		XSSFCellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();

//		font.setFontHeightInPoints((short) 15);
//		font.setBold(true);
//		style.setFont(font);
//		int r = 1;
//		XSSFRow row = sheet.createRow(0);
//		XSSFCell cell = row.createCell(0);
//		cell.setCellValue("Date");
//		cell.setCellStyle(style);
//		
//		cell=row.createCell(1);  
//		cell.setCellValue("Total Subscribers");
//		cell.setCellStyle(style);

//		XSSFRow roww = sheet.createRow(1);

//		XSSFCell celll = roww.createCell(0);
//		cell=row.createCell(2);  
//		cell.setCellValue("Charged successfully");
//		cell.setCellStyle(style);
//		cell = row.createCell(1);
//		cell.setCellValue("Total_base");
//		cell.setCellStyle(style);
//		List<Promotion_base> li = promotion_base_Repo.getData();
			List<Promotion_base> li = promotion_base_Repo.findAll();
			List<Subscription> sub_li = subscription_Repo.getData(date);

			int count = 0;
			int count2 = 0;
			for (Subscription sub : sub_li) {

				for (Promotion_base list : li) {
					if (list.getMsisdn().equals(sub.getAni())) {

						String charged = sub.getLast_billed_date();
						if (charged != null) {
							count2++;
							promotion_base_Repo.updateDate(date, sub.getAni());
//						promotion_base_Repo.updateData(charged.getAni());
//						list.setStatus("ChargedNumber");
//						promotion_base_Repo.save(list);
//						break;

						} else {
							count++;
							promotion_base_Repo.updateDate(date, sub.getAni());
							// promotion_base_Repo.updateAllData(sub.getAni());
//						list.setStatus("SubscriberNumber");
//						promotion_base_Repo.save(list);
//						break;
						}
					}
				}

			}

			System.out.println(count);
			System.out.println(count2);

			map.put("total subscriber count", count);
			map.put("charged", count2);
			return map;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

//		for (Promotion_base list : li) {
//			promotionDate=list.getPromotionDate();
//			
//			Subscription subscribe = subscription_Repo.getAllData(list.getMsisdn());
//			
//			if (subscribe != null) {
//				promotion_base_Repo.updateAllData(subscribe.getAni());
//				promotion_base_Repo.updateDate(subscribe.getAni());
//				count++;
//				
//				Subscription charged = subscription_Repo.getData(subscribe.getAni());
//
//				if (charged != null) {
//				promotion_base_Repo.updateData(charged.getAni());
//				promotion_base_Repo.updateDate(charged.getAni());
//					count2++;
//					
//				}
//
//			}
//		}
//		roww.createCell(0).setCellValue(promotionDate);
//		roww.createCell(1).setCellValue(count);
//		roww.createCell(2).setCellValue(count2);

//		FileOutputStream outputStream;
//		try {
//			outputStream = new FileOutputStream(excelFilePath);
//			workbook.write(outputStream);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

//	@GetMapping("/get")
//	public void getdata() {
//		List<Promotion_base> l=promotion_base_Repo.getData();
//		String msisdn="";
//		for(Promotion_base li:l) {
//			msisdn=li.getMsisdn();
//			
//			System.out.println("ani :-"+msisdn);
//			
//			Subscription getList=subscription_Repo.getAllData(msisdn);
//			
//			
//			if(getList !=null) {
//				li.setStatus("Subscribe");
//				promotion_base_Repo.save(li);
//				
//			}
	// List<Subscription> list=subscription_Repo.getData(msisdn);

	// excel_File.getFile(getList);
//			excel_File.getFile(getList,list);

//			String excelFilePath = "chk.xlsx";
//			XSSFWorkbook workbook = new XSSFWorkbook(); // create workbook in .xlsx format
//			XSSFSheet sheet = workbook.createSheet("Subscribe"); // create sheet
//			XSSFSheet sheet2 = workbook.createSheet("Charged");
//			XSSFCellStyle style = workbook.createCellStyle();
//			XSSFFont font = workbook.createFont();
//
//			int r = 1;
////		int r2=1;
//
//			font.setFontHeightInPoints((short) 15);
//			font.setBold(true);
//			style.setFont(font);
//
//			XSSFRow roww = sheet.createRow(0);
//			XSSFCell celll = roww.createCell(0);
//			celll.setCellValue("ANI");
//			celll.setCellStyle(style);
//
////			int r4 = 0;
//			int count=0;
//			for (Subscription tr : getList) {
////				roww = sheet.createRow(r++);
////				r4++;
//				System.out.println("ob subscribe  "+tr);
//				
//				count=count+1;
//				System.out.println("count subscribe "+count);
////				roww.createCell(0).setCellValue(count);
//			}
//			roww = sheet.createRow(r++);
//			roww.createCell(0).setCellValue(count);
//			
//			XSSFRow row = sheet2.createRow(0); // second sheet in excel file
//
//			XSSFCell cell = row.createCell(0);
//			cell.setCellValue("Successfully Charged");
//			cell.setCellStyle(style);
//
//			cell = row.createCell(1);
//			cell.setCellValue("Amount");
//			cell.setCellStyle(style);
//
////			int r33 = 0;
////			int total_ba = 0;
//
////			int r44 = 0;
//			int r2 = 1;
//			int count2=0;
//			for (Subscription tr : list) {
//				// r44++;
////				row = sheet2.createRow(r2++);
//				System.err.println("ob charged "+tr);
//				count2=count2+1;
//				System.out.println("count charged "+count2);
////				row.createCell(0).setCellValue(count2);
////				row.createCell(0).setCellValue(tr.getAni());
////				row.createCell(1).setCellValue(tr.getDefault_amount());
//			}
//			row = sheet2.createRow(r2++);
//			row.createCell(0).setCellValue(count2);
//			
//			FileOutputStream outputStream;
//			try {
//				outputStream = new FileOutputStream(excelFilePath);
//				workbook.write(outputStream);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	
//	}

	@GetMapping("/update")
	public void updatedata() {

		File file = new File("/home/ashu/Book1.xlsx");
//		File file=new File("Book1.xlsx");
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);

			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);

			for (Row row : sheet) {

				// promotion_base_Repo.updateData(row.getCell(0).getStringCellValue());

				// promotion_base_Repo.updateAllData(row.getCell(0).getStringCellValue());
				DataFormatter formatter = new DataFormatter();
				String val = formatter.formatCellValue(row.getCell(0));
				promotion_base_Repo.updateData(val);
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
