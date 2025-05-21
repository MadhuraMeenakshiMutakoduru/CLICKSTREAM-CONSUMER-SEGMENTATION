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

<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .iframe-style {
            width: 100%;
            height: 600px; /* Adjust height as needed */
            border: 2px solid #007bff; /* Border to mimic iframe */
            border-radius: 5px;
            overflow: hidden; /* Hide overflow */
        }

        .table-container {
            width: 100%;
            height: 100%;
            overflow: auto; /* Enable scrolling */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0;
            box-shadow: none; /* Remove shadow */
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #dddddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        h2 {
            text-align: center;
            margin: 10px 0; /* Space above and below header */
        }
    </style>

</head>
<body>
	<!--navbar -->
	<%@include file="Components/navbar.jsp"%>
	<%@include file="Components/alert_message.jsp"%>
	
	<div class="container-fluid px-5 py-3">
		<div class="row">
			
						<h1>Customer Segmentation Dataset</h1>
    <table>
        <tr>
            <th>Shopping ID</th>
            <th>Customer Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Income Level</th>
            <th>Purchase Frequency</th>
            <th>Loyalty Level</th>
            <th>Region</th>
            <th>Lifestyle</th>
            <th>Product Preference</th>
            <th>Pages Visited</th>
            <th>Time on Site (mins)</th>
            <th>Products Clicked</th>
            <th>Categories Explored</th>
            <th>Exit Page</th>
            <th>Purchase Intent</th>
        </tr>
        <%
            List<CustomerData> customerList = (List<CustomerData>) request.getAttribute("customerList");
					            for (CustomerData customer : customerList) {
					        %>
					        <tr>
					            <td><%= customer.getShoppingId() %></td>
					            <td><%= customer.getCustomerName() %></td>
					            <td><%= customer.getAge() %></td>
					            <td><%= customer.getGender() %></td>
					            <td><%= customer.getIncomeLevel() %></td>
					            <td><%= customer.getPurchaseFrequency() %></td>
					            <td><%= customer.getLoyaltyLevel() %></td>
					            <td><%= customer.getRegion() %></td>
					            <td><%= customer.getLifestyle() %></td>
					            <td><%= customer.getProductPreference() %></td>
					            <td><%= customer.getPagesVisited() %></td>
					            <td><%= customer.getTimeOnSite() %></td>
					            <td><%= customer.getProductsClicked() %></td>
					            <td><%= customer.getCategoriesExplored() %></td>
					            <td><%= customer.getExitPage() %></td>
					            <td><%= customer.getPurchaseIntent() %></td>
					        </tr>
					        <%
					            }
					        %>
					    </table>
					</div>
				</div>
			
</body>
</html>