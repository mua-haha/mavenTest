package com.hph.test.websocket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RunWebSockectServlet
 */
public class RunWebSockectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunWebSockectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("接收到请求了！");
		HttpSession s = request.getSession();
		System.out.println(s.getId());
		
		for(int i=0;i<10;i++){
			try {
				System.out.println(i);
				ChatAnnotation.broadcast("-----"+i);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("打断了··");
				e.printStackTrace();
			}
		}
		request.setAttribute("name", "hepenghui");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
