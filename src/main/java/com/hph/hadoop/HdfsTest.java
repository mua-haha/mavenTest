package com.hph.hadoop;

import java.io.FileInputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsTest {
	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.10.68:9000");
		conf.set("fs.default.name", "hdfs://192.168.10.68:9000");
		conf.set("dfs.replication", "2");// 默认为3
		FileSystem fileSystem = FileSystem.get(conf);

		boolean success = fileSystem.mkdirs(new Path("/hepenghui333"));
		System.out.println("创建文件是否成功:" + success);

		success = fileSystem.exists(new Path("/yucong"));
		System.out.println("文件是否存在:" + success);

//		success = fileSystem.delete(new Path("/yucong"), true);
//		System.out.println("删除文件是否成功：" + success);

//		FSDataOutputStream out = fileSystem.create(new Path("/test2.data"));
//		FileInputStream in = new FileInputStream("c:/test.txt");
//		byte[] buf = new byte[4096];
//		int len = in.read(buf);
//		while (len != -1) {
//			out.write(buf, 0, len);
//			len = in.read(buf);
//		}
//		in.close();
//		out.close();

//		FileStatus[] statuses = fileSystem.listStatus(new Path("/"));
//		System.out.println(statuses.length);
//		for (FileStatus status : statuses) {
//			System.out.println(status.getPath());
//			System.out.println(status.getPermission());
//			System.out.println(status.getReplication());
//		}
	}

}
