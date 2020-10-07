package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParameter
 */
//@WebServlet("/initParameter.do")
public class InitParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String company ;
	String singer ;
	String manager ;
	String title ;
	String title_config ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParameter() {
        super();
       System.out.println("InitParameter()");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		
		//ServletContext 객체 : 프로젝트 당 1개밖에 만들어지지 않는다!!!
		//xml의 context-param에서 설정한 변수는 context객체를 통해서 출력한다
		ServletContext context = config.getServletContext();
		
		company = context.getInitParameter("company");
		singer = context.getInitParameter("singer");
		manager = context.getInitParameter("manager");
		title = context.getInitParameter("title"); 
		//null 
		
		//ServletConfig 객체 : 서블릿 당 1개밖에 만들어지지 않는다!!!
		//xml의 servlet안에서 init-param을 통해 설정한 변수는 config객체를 통해서 출력한다
		title_config = config.getInitParameter("title");
		
		System.out.println("회사 : " +company);
		System.out.println("가수 : " +singer);
		System.out.println("매니저 : " +manager);
		System.out.println("제목 : " +title);
		System.out.println("제목_config : " +title_config);
			
		
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
	response.setContentType("text/html; charset=UTF-8");
	
	PrintWriter pw = response.getWriter();
		
	pw.print("회사명 : " + company + "<br>");
	pw.print("가수명 : " + singer + "<br>");
	pw.print("매니저 : " + manager + "<br>");
	pw.print("제목 : " + title + "<br>");
	pw.print("제목_config : " + title_config + "<br>");
	pw.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
