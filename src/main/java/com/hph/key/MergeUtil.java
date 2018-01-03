package com.hph.key;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;

/**
 * 把系统导出的秘钥文件与 人口数据文件 合并为一个文件
 * 
 * @author hepenghui
 *
 */
public class MergeUtil {

	public static void main(String[] args) throws Exception {
		MergeUtil test = new MergeUtil();
		File pathFile = new File("C:/data/files/batch");
		File[] files = pathFile.listFiles();
		List<String> fileNameList = new ArrayList<>();
		for (File f : files) {
			fileNameList.add(f.getAbsolutePath());
		}
		int needNum = 32745;
		int hasNum = test.getAllKey(fileNameList);
//		System.out.println("总共："+needNum+"，现有："+hasNum+"，再生成："+(needNum-hasNum));
		test.dealKeyFile(fileNameList,test.getAllKey(fileNameList));

	}

	/**
	 * 
	 * 合并人口数据
	 * 
	 * @throws Exception
	 */
	public int dealPeopleFile(List<String> fileNameList) throws Exception {
		String fileName0 = fileNameList.get(1);
		String path = fileName0.substring(0, fileName0.lastIndexOf(File.separator)).concat("/done");
		File pathFile = new File(path);
		if (!pathFile.exists() && !pathFile.isDirectory()) {
			pathFile.mkdir();
		}
		// 先合并 人口文件
		int i = 0;
		// 得到总数
		for (String filePath : fileNameList) {
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
			if (fileName.startsWith("pc")) {
				String[] ss = fileName.split("_");
				i += Integer.parseInt(ss[2]);
			}
		}
		String newFileName = path.concat("/pc_" + i + "_info.txt");
		// 写入
		for (String filePath : fileNameList) {
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
			if (fileName.startsWith("pc")) {
				List<String> clist = readFileByLines(filePath);
				fileWriter(newFileName, clist);
				System.out.println("完成！ 文件名：" + fileName);
			}
		}
		return i;
	}

	/**
	 * 
	 * 合并秘钥数据
	 * 
	 * @throws Exception
	 */
	public void dealKeyFile(List<String> fileNameList,int num) throws Exception {
		String fileName0 = fileNameList.get(1);
		String path = fileName0.substring(0, fileName0.lastIndexOf(File.separator)).concat("/done");
		File pathFile = new File(path);
		if (!pathFile.exists() && !pathFile.isDirectory()) {
			pathFile.mkdir();
		}
		System.out.println("秘钥数据：" + num + "条");
		String dateString = DateTime.now().toString("yyyyMMdd");
		String newFileName = path.concat("/许都通项目_大唐_" + dateString + "_PC0066_" + num + "张.txt");
		File newFile = new File(newFileName);
		if(!newFile.exists()){
			newFile.createNewFile();
		}
		// 写入吗，秘钥文件
		for (String filePath : fileNameList) {
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
			if ( fileName.endsWith("txt")) {
				// 待写入list
				List<String> clist = readFileByLines(filePath);
				// 已写入list
				List<String> olist = readFileByLines(newFileName);
				if(olist.size() +clist.size() > num){
					// 需要的数目
					int  n = num - olist.size();
					fileWriter(newFileName, clist.subList(0, n));
					break;
				}else{
					fileWriter(newFileName, clist);
				}
				System.out.println("完成！ 文件名：" + fileName);
			}
		}

	}
	/**
	 * 
	 * 得到总共多少条秘钥
	 * 
	 * @throws Exception
	 */
	public int getAllKey(List<String> fileNameList) throws Exception {
		int all = 0;
		// 写入吗，秘钥文件
		for (String filePath : fileNameList) {
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
			if ( fileName.endsWith("txt")) {
				// 待写入list
				List<String> clist = readFileByLines(filePath);
				all +=clist.size();
			}
		}
		return all;
	}

	/**
	 * 按行写入
	 * 
	 * @param fileName
	 * @param clist
	 * @throws IOException
	 */
	public void fileWriter(String fileName, List<String> clist) throws IOException {
		// true 表示追加
		FileWriter fw = new FileWriter(fileName, true);
		BufferedWriter writer = new BufferedWriter(fw);
		Iterator<String> iterator = clist.iterator();

		while (iterator.hasNext()) {
			String next = iterator.next().toString();
			if (!"".equals(next)) {
				writer.write(next);
				writer.newLine();// 换行
			}
		}
		// 刷新缓冲区
		fw.flush();
		// 关闭文件流对象
		writer.close();
		fw.close();
	}

	/**
	 * 按行 读取
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<String> readFileByLines(String fileName) throws Exception {
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		// 创建一个集合
		List<String> nums = new ArrayList<String>();
		// 按行读取文件内容，并存放到集合
		while ((tempString = reader.readLine()) != null) {
			nums.add(tempString);
		}
		reader.close();
		// 返回集合变量
		return nums;
	}

}
