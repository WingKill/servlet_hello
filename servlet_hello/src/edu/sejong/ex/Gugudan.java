package edu.sejong.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gugudan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("작업 미진행 페이지");
		writer.close();
		System.out.println("작업이 진행되지 않습니다.");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 디버깅을 위해 사용하는 것.
		System.out.println("doPost() ..");
		// parameter를 받기 전 해당 인코딩 작업이 필요함.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String dan = request.getParameter("구구단");
		
		int dans = Integer.valueOf(dan); 

		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		
		writer.println("<body>");
		writer.println("<h1> -- " + dans + "단 출력 -- </h1>");
		for(int i = 1; i <=9; i++) {
			int dandan = dans * i;
			writer.println("<h1>" + i + "번째 : "+ dans +" * "+i +" = " + dandan + "</h1>");
		}		
		
		writer.println("</body>");
		
		writer.println("</html>");
		writer.close();
	}

}
