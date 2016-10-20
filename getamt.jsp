<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
String fromDate = request.getParameter("fromDate");
String toDate = request.getParameter("toDate");
//System.out.println(fromDate+" "+toDate);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

Date fdate = sdf.parse(fromDate);
Date tdate = sdf.parse(toDate);
long diff = (tdate.getTime() - fdate.getTime())/(1000*60*60*24);



out.println(diff);

%>