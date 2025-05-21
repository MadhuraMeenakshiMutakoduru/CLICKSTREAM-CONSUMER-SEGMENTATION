<%@page import="com.clickstream.utils.CustomerData"%>
<%@page import="com.eazydeals.dao.AdminDao"%>
<%@page errorPage="error_exception.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Admin activeAdmin = (Admin) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("adminlogin.jsp");
	return;
}
AdminDao adminDao = new AdminDao(ConnectionProvider.getConnection());
List<Admin> adminList = adminDao.getAllAdmin();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Admin's</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
label {
	font-weight: bold;
}
</style>
</head>
<body>
	<!--navbar -->
	<%@include file="Components/navbar.jsp"%>

	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body px-3" al>
						
						<%@include file="Components/alert_message.jsp"%>

						<!--admin-form-->
						
					</div>

				</div>
			</div>
			
		</div>
		
		<div class="container">
			<div class="row px-3">
				<div class="col-md-4 offset-md-2">
					
						<div class="card text-bg-light mb-3 text-center">
							<div class="card-body">
								<form action="uploadCsv" method="post" enctype="multipart/form-data">
					        <label for="csvFile">Choose CSV file:</label>
					        <input type="file" id="csvFile" name="csvFile" accept=".csv" required>
					        <button type="submit">Upload</button>
					    </form>
							</div>
						</div>
				</div>
				</div>
	</div>
</body>
</html>