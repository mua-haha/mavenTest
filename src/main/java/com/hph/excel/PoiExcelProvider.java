package com.hph.excel;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiExcelProvider implements Iterator<Map<String, String>> {

	private Workbook book = null;
	private Sheet sheet = null;
	private int rowNum = 0;
	private int currentRowNo = 0;
	private short columnNum = 0;
	private String[] columnnName;

	/** 获取第一行的所有单元格里面的类容：即key值 */
	public PoiExcelProvider(String filePath) {

		try {

			book = WorkbookFactory.create(new File(filePath));
			// 取sheet
			sheet = book.getSheetAt(0);
			rowNum = sheet.getLastRowNum() + 1;// 获取最后一行的行号,即获取一共有多少行
			// 获取当前sheet的第一行数据
			Row row = sheet.getRow(0);
			// 第一行数据的一共有多少个单元格
			columnNum = row.getLastCellNum();
			// 声明一个数组，长度为第一行所有单元格的长度
			columnnName = new String[columnNum];

			for (int i = 0; i < columnNum; i++) {
				// 获取第一行所有单元格的内容，存放到数组columnnName中
				Cell cell = row.getCell(i);
				if(cell == null){
					columnnName[i] = "";
				}else{
					cell.setCellType(CellType.STRING);
					columnnName[i] = cell.getStringCellValue();
				}
			}
			this.currentRowNo++;// 指向下一行
		} catch (Exception e) {
			e.printStackTrace();
			// Assert.fail("unable to read Excel data");
		}
	}

	/* 判断Excel是否还有内容 */
	@Override
	public boolean hasNext() {
		// 如果一行数据也没有或者当前行号超出最大行号，就关闭Excel
		if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {

			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else {
			// sheet下一行内容为空判定结束
			if ((sheet.getRow(currentRowNo)).getCell(0).equals("")) {
				return false;
			}

			return true;
		}
	}

	/** 读取除key之外的Excel的所有内容 */
	@Override
	public Map<String, String> next() {

		// 获取当前行对象
		Row row = sheet.getRow(this.currentRowNo);
		Map<String, String> data = new LinkedHashMap<String, String>();

		for (int i = 0; i < this.columnNum; i++) {

			String temp = "";

			try {
				Cell cell = row.getCell(i);
				cell.setCellType(CellType.STRING);
				temp = cell.getStringCellValue();
			} catch (ArrayIndexOutOfBoundsException ex) {
				temp = "";
			}
			data.put(this.columnnName[i], temp);
		}
		this.currentRowNo++;
		return data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove unsupported.");
	}

}
