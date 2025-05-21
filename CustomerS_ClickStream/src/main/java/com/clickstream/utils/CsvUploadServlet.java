package com.clickstream.utils;
import com.opencsv.CSVReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/uploadCsv")
@MultipartConfig // Add this annotation

public class CsvUploadServlet extends HttpServlet {
    private List<CustomerData> customerList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("csvFile"); // Get the uploaded file
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(filePart.getInputStream(), StandardCharsets.UTF_8))) {
            String[] nextLine;
            boolean isHeader = true;

            while ((nextLine = csvReader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header line
                    continue;
                }
                // Create a new CustomerData object for each line
                CustomerData customer = new CustomerData(nextLine);
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error reading CSV: " + e.getMessage());
            return;
        }

        // Redirect to a result page or display the segmentation
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("segmentationResult1.jsp").forward(request, response);
    }

    // Optionally, implement a method to filter or segment customers based on criteria
    // This could be done based on different attributes such as age, income level, etc.
}

