<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<html> 
	<head>
		<title>FloorCreate</title>
	</head>
	<body>
	<p align="center">
	<font size="6" color="#000080">Floor Create</font>
	</p>
	
		<html:form action="/floorInsert">
		<table align="center">
		<tr>
		<td><bean:message key="floorId"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:text property="floorId"/><html:errors property="floorId"/></td>
		</tr>
		<tr>
		<td><bean:message key="floorName"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:text property="floorName"/><html:errors property="floorName"/></td>
		</tr>
		<tr>
		<td><bean:message key="floorDesc"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:text property="floorDesc"/><html:errors property="floorDesc"/></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td><html:submit/><html:cancel/></td>
		</tr>
		</table>
		    
			<logic:messagesPresent name="status">
			<bean:write name="status"/>
			</logic:messagesPresent>
		</html:form>
	</body>
</html>

