package com.clickstream.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchCustomer")
public class SearchCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        
        // Simulate searching the customer from a data source (CSV or database)
        List<Customer> customers = CsvReader.readCsv(Constants.DATASET_PATH); // Update with your actual path
        Customer foundCustomer = null;

        for (Customer customer : customers) {
            if (String.valueOf(customer.getShoppingId()).equals(customerId)) {
                foundCustomer = customer;
                break;
            }
        }

        // Set the found customer to the request scope
        request.setAttribute("customer", foundCustomer);
        
        // Forward to the JSP page to display the results
        request.getRequestDispatcher("displayCustomer.jsp").forward(request, response);
    }
}
