<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String vehicleType = request.getParameter("vehicleType");
	String res = "";
	if (vehicleType.equals("SUV")) {
		res="OR02AT1234-BR02AT1234-KA02AT1234";
	} else if (vehicleType.equals("Hatchback")) {
		res="OR02AT4321-BR02AT4321-KA02AT4321";
	} else if (vehicleType.equals("Sedan")) {
		res="OR02AT9876-BR02AT9876-KA02AT9876";
	} else if (vehicleType.equals("Luxury")) {
		res="OR02AT6789-BR02AT6789-KA02AT6789";
	}
	out.println(res);
%>