package com.hph.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;


public class WordReader {
	public static void main(String[] args) throws Exception {
		File file = new File("c:/11/aa.docx");
		getContent(file);
	}

	public static void getContent(File f) throws Exception {
		OPCPackage opcPackage = POIXMLDocument.openPackage("c:/11/aa.docx");  
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);  
        String text2007 = extractor.getText();  
        System.out.println(text2007);  
	}
	public static void getContent1(File f) throws Exception {
		InputStream is = new FileInputStream(new File("c:/11/aa.docx"));  
        WordExtractor ex = new WordExtractor(is);  
        String text2003 = ex.getText();  
        System.out.println(text2003);
	}

}
