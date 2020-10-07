package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet(
		urlPatterns= {"/ThirdServlet"},
		initParams = {
				@WebInitParam(name="singer" , value="��ź�ҳ��"),
				@WebInitParam(name="title" , value="Dynamite")	
		}		
		) //urlmapping��û�� ������ ���� ��밡���� ������ �����ϴ� ���
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String company;
       String singer;
       String title;
	
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		ServletContext context = config.getServletContext();
		company = context.getInitParameter("company");
		//singer = context.getInitParameter("singer"); => �¿��� ���´�
		
		singer = config.getInitParameter("singer");
		title = config.getInitParameter("title");
		
		System.out.println("ȸ��_context : " + company);
		System.out.println("����_config : " + singer);
		System.out.println("����_config : " + title);
		
		
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
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.write("ȸ���_context : " + company + "<br>");
		pw.write("������_config : " + singer + "<br>");
		pw.write("�����_config : " + title + "<br>");
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
