<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for ZoneForm form</title>
	</head>
	<body>
	
	<p align="center">
	<font size="6" color="#000080">Zone Create</font>
	</p>
		<html:form action="/zoneCreate">
		
		<table align="center">
		<tr>
		<td><bean:message key="floorId"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:select property="floorId">
		<html:option value="0">select</html:option>
		<html:optionsCollection name="floorList" label="floorId" value="floorId"/>
		</html:select>
		<html:errors property="floorId"/></td>
		</tr>
		<tr>
		<td><bean:message key="zoneId"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:text property="zoneId"/><html:errors property="zoneId"/></td>
		</tr>
		<tr>
		<td><bean:message key="zoneName"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:text property="zoneName"/><html:errors property="zoneName"/></td>
		</tr>
		<tr>
		<td><bean:message key="zoneDesc"/></td>
		<td><bean:message key="colon"/></td>
		<td><html:text property="zoneDesc"/><html:errors property="zoneDesc"/></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td><html:submit/><html:cancel/></td>
		</tr>
		</table>
			
		</html:form>
	</body>
</html>

