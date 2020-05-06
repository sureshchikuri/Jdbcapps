<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
	<head>
		<title>ZoneSearch</title>
		<link rel="stylesheet" lang="text/css" href="workstation.css" />
	</head>
	<body>
		<p align="center">
			<font size="7" color="darkgreen">Zone Search</font>
		</p>

		<html:form action="/zoneSearch">
			<table align="center">
				<tr>
					<td>
						<bean:message key="zoneId" />
						:
					</td>
					<td>
						<html:text property="zoneId" />
					</td>
					<td>
						<html:submit />
						<html:errors property="zoneId" />
					</td>
				</tr>
			</table>

			<logic:notEmpty name="zoneList">
				<table align="center" id="table1" border="2" bordercolor="black">
					<tr>
						<th>
							<bean:message key="floorId" />
						</th>

						<th>
							<bean:message key="zoneId" />
						</th>
						<th>
							<bean:message key="zoneName" />
						</th>
						<th>
							<bean:message key="zoneDesc" />
						</th>
					</tr>

					<logic:iterate id="zone" name="zoneList">
						<tr>
							<td>
								<bean:write name="zone" property="floor.floorId" />
							</td>
							<td>
								<bean:write name="zone" property="zoneId" />
							</td>
							<td>
								<bean:write name="zone" property="zoneName" />
							</td>
							<td>
								<bean:write name="zone" property="zoneDesc" />
							</td>
						</tr>
					</logic:iterate>
				</table>
			</logic:notEmpty>

			<logic:empty name="zoneList">
				<logic:messagesPresent name="status">
					<bean:write name="status" />
				</logic:messagesPresent>
			</logic:empty>

			<table align="center">
				<tr>
					<td colspan="1">
						&nbsp;
					</td>
					<logic:greaterThan name="currentPage" value="1">
						<td>
							<html:link action="zoneSearch.do?page=${currentPage-1}">Previous</html:link>
						</td>
					</logic:greaterThan>
					<logic:lessThan name="currentPage" value="${noOfPages}">
						<td>
							<html:link action="zoneSearch.do?page=${currentPage+1}">Next</html:link>
						</td>
					</logic:lessThan>

					<logic:notEqual name="noOfRecords" value="1">
						<c:forEach begin="1" end="${noOfPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>
										${i}
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<a href="zoneSearch.do?page=${i}">${i}</a>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</logic:notEqual>
				</tr>
			</table>
		</html:form>
	</body>
</html>

