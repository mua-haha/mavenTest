package com.hph.jmx;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class MessageEngineAgent {
	public void start() {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		try {
			ObjectName mxbeanName = new ObjectName("我的JMX:type=属性操作");
			MessageEngineMXBean mxbean = new MessageEngine();
			mbs.registerMBean(mxbean, mxbeanName);

			ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
			HtmlAdaptorServer adapter = new HtmlAdaptorServer();
			mbs.registerMBean(adapter, adapterName);
			adapter.start();

			// 这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
			LocateRegistry.createRegistry(9999);
			// URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
			JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
			System.out.println("begin rmi start");
			jcs.start();
			System.out.println("rmi start");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
