<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
/* 이 안에는 자바코드가 들어올 수 있다 */
	String name = request.getParameter("name")+" 님";
	String age = request.getParameter("age")+" 세";
	Date now = new Date();
%>

{
	"name" : "<%=name %>",
	"age" : "<%=age %>",
	"now" : "<%=now %>"
}
