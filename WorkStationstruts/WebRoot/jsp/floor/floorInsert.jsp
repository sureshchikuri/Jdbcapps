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
		    <bean:message key="floorId"/>   : <html:text property="floorId"/><html:errors property="floorId"/><br/>
			<bean:message key="floorName"/> : <html:text property="floorName"/><html:errors property="floorName"/><br/>
			<bean:message key="floorDesc"/> : <html:text property="floorDesc"/><html:errors property="floorDesc"/><br/>
			<html:submit/><html:cancel/><br/>
			<br/>
			<logic:messagesPresent name="status">
			<bean:write name="status"/>
			</logic:messagesPresent>
		</html:form>
	</body>
</html>

