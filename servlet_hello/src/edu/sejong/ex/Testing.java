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
@WebServlet("/testing")
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
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
		
		String kor = request.getParameter("국어");
		String eng = request.getParameter("영어");
		String math = request.getParameter("수학");
		
		// 첫 작성 시 까먹어서, 검색을 통해 parseInt를 활용. 챗 gpt에서는 약간의 차이가 있다고 표현함.
		// parseInt 는 숫자로만 이루어진 문자열 반환시, valueOf 는 숫자가 아닌 문자열도 포함하여 정수 객체로 반환 
		int kors = Integer.valueOf(kor); 
		int engs = Integer.valueOf(eng);
		int maths = Integer.valueOf(math);
		
		int sum = kors + engs + maths;
		double avg = sum / 3.0;
		double avglittle = (int)(avg * 100) / 100.0;

		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		
		writer.println("<body>");
		writer.println("<h1> 총점 " + String.valueOf(sum) + "</h1>");
		writer.println("<h1> 평균 " + String.valueOf(avglittle) + "</h1>");
		
		writer.println("</body>");
		
		writer.println("</html>");
		writer.close();
	}

}
