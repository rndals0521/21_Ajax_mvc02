package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.TextCommnad;

@WebServlet("/MyController01")
public class MyController01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyController01() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 해당 문서의 타입 설정 : text 일경우
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 정보를 여기서 출력
		// ajax에게 정보를 전달하는 페이지 
		
		// 자바에서 처리하고 보낸 결과를 받는다.
		// out.println("1,홍길동,24,서울/2,둘리,14,경기도/3,도우너,64,강원도/4,또치,34,제주도");
		TextCommnad tc = new TextCommnad();
		String msg = tc.exec(request, response);
		out.println(msg);
		
	}
}










