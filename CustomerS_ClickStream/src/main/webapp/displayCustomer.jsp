<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Details</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            text-align: left;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h1>Customer Details</h1>

    <c:if test="${not empty customer}">
        <table>
            <tr>
                <th>Attribute</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>Shopping ID</td>
                <td>${customer.shoppingId}</td>
            </tr>
            <tr>
                <td>Customer Name</td>
                <td>${customer.customerName}</td>
            </tr>
            <tr>
                <td>Age</td>
                <td>${customer.age}</td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>${customer.gender}</td>
            </tr>
            <tr>
                <td>Income Level</td>
                <td>${customer.incomeLevel}</td>
            </tr>
            <tr>
                <td>Purchase Frequency</td>
                <td>${customer.purchaseFrequency}</td>
            </tr>
            <tr>
                <td>Loyalty Level</td>
                <td>${customer.loyaltyLevel}</td>
            </tr>
            <tr>
                <td>Region</td>
                <td>${customer.region}</td>
            </tr>
            <tr>
                <td>Lifestyle</td>
                <td>${customer.lifestyle}</td>
            </tr>
            <tr>
                <td>Product Preference</td>
                <td>${customer.productPreference}</td>
            </tr>
            <tr>
                <td>Pages Visited</td>
                <td>${customer.pagesVisited}</td>
            </tr>
            <tr>
                <td>Time on Site (mins)</td>
                <td>${customer.timeOnSite}</td>
            </tr>
            <tr>
                <td>Products Clicked</td>
                <td>${customer.productsClicked}</td>
            </tr>
            <tr>
                <td>Categories Explored</td>
                <td>${customer.categoriesExplored}</td>
            </tr>
            <tr>
                <td>Exit Page</td>
                <td>${customer.exitPage}</td>
            </tr>
            <tr>
                <td>Purchase Intent</td>
                <td>${customer.purchaseIntent}</td>
            </tr>
        </table>
    </c:if>

    <c:if test="${empty customer}">
        <p>No customer found with ID: ${param.customerId}</p>
    </c:if>

    
</body>
</html>