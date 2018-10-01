package com.my.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 요청 값의 인코딩
		response.setContentType("text/html; charset=utf-8"); // 응답 값의 인코딩
		PrintWriter out = response.getWriter();
		String bnum = request.getParameter("bnum");
		String name = request.getParameter("name");
		String kind = request.getParameter("kind");
		String country = "";
		if (request.getParameter("country").equals("inner")) {
			country = "국내";
		} else if (request.getParameter("country").equals("outter")) {
			country = "국외";
		}
		String date = request.getParameter("date");
		String publish = request.getParameter("publish");
		String author = request.getParameter("author");
		String price = request.getParameter("price");

		out.println("<h1>도서 등록 성공</h1>");
		out.println("<h3>등록된 도서 정보는 다음과 같습니다.</h3>");
		out.println("<table border='1'>" + "<tr><td>도서번호</td><td>" + bnum + "</td></tr>" + "<tr><td>도서명</td><td>" + name
				+ "</td></tr>" + "<tr><td>종류</td><td>" + kind + "</td></tr>" + "<tr><td>출판국가</td><td>" + country
				+ "</td></tr>" + "<tr><td>출판일</td><td>" + date + "</td></tr>" + "<tr><td>출판사</td><td>" + publish
				+ "</td></tr>" + "<tr><td>저자</td><td>" + author + "</td></tr><tr>" + "<td>가격</td><td>" + price
				+ "</td></tr></table>");
	}

}
