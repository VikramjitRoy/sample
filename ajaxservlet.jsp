<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
System.out.println(request.getQueryString());
String topicName = request.getParameter("topicName");
System.out.println(topicName);

StringBuffer returnData = null;
if(topicName.equals("java")){
	returnData =new StringBuffer("{\"topic\":{");
	returnData.append("\"name\":\"java\",");
	returnData.append("\"tutorials\":[");
	returnData.append("{\"name\":\"Introduction to java sockets.\"},");
	returnData.append("{\"name\":\"java the complete reference\"}]}}");
	
}
else{
	returnData =new StringBuffer("{\"topic\":{");
	returnData.append("\"name\":\""+topicName+"\",");
	returnData.append("\"tutorials\":[");
	returnData.append("{\"name\":\"No tutorials found.\"}");
	returnData.append("]}}");
}
out.println(returnData.toString());


%>