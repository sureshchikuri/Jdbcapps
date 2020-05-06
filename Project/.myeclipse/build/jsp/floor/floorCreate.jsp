<html>
	<head>
		<title>Work Station</title>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/FloorCreateServlet"
			method="get">

			<table align="center">
				<tr>
					<h2 align="center">
						Floor Details
					</h2>
				</tr>
				<tr>
					<td>
						Floor Id
					</td>
					<td>
						<input type="text" name="id" />
					</td>
				</tr>
				<tr>
					<td>
						Floor Name
					</td>
					<td>
						<input type="text" name="name" />
					</td>
				</tr>
				<tr>
					<td>
						Floor Description
					</td>
					<td>
						<input type="text" name="desc" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="submit" />
						<input type="reset" value="submit" />
					</td>
				</tr>
				<tr>
				<td>Status </td>
				<td><%=request.getAttribute("status") %></td>
				</tr>

			</table>
		</form>
	</body>
</html>