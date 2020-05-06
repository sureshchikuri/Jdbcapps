<form action="#">
			<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
			<c:if test="${not empty floorList}">
				<table align="center">
					<tr>
						<td>
							<h4>
								Floor Id
							</h4>
						</td>
					</tr>
					<tr>
						<td>
							<h4>
								Floor Name
							</h4>
						</td>
					</tr>
					<tr>
						<td>
							<h4>
								Floor Desc
							</h4>
						</td>
					</tr>
					<c:forEach items="${floorList}" var="Floor">
						<tr>
							<td>
								<c:out value="${Floor.floorId}"></c:out>
							</td>
						</tr>
						<tr>
							<td>
								<c:out value="${Floor.floorName}"></c:out>
							</td>
						</tr>
						<tr>
							<td>
								<c:out value="${Floor.floorDesc}"></c:out>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${empty floorList}">
				<c:out value="${status}"></c:out>
			</c:if>
			<table>
				<tr>
					<td colspan="1">
						&nbsp;
					</td>
				  	<c:if test="${currentPage gt 1}">
						<td>
							<a href="FloorSearchServlet?page=${currentPage-1}">Previous</a>
						</td>
					</c:if>
					<c:if test="${currentPage lt noOfPages}">
						<td>
							<a href="FloorSearchServlet?page=${currentPage+1}">Next</a>
						</td>
					</c:if>
					<c:if test="${noOfRecords!=1}">
						<c:forEach begin="1" end="${noOfPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>
										${i}
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<a href="FloorSearchServlet?page="${i}">${i}</a>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</tr>
			</table>
			</form>