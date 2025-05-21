package com.clickstream.utils;
import com.opencsv.CSVReader;
import com.google.gson.Gson;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/uploadCsv1")
@MultipartConfig
public class CsvUploadServlet1 extends HttpServlet {
    private List<CustomerData> customerList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("csvFile");
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

        // Segment the data
        Map<String, Long> ageDistribution = segmentByAge();
        Map<String, Long> incomeDistribution = segmentByIncomeLevel();
        Map<String, Long> purchaseFrequencyDistribution = segmentByPurchaseFrequency();

        // Pass segmented data to JSP
        request.setAttribute("ageDistribution", new Gson().toJson(ageDistribution));
        request.setAttribute("incomeDistribution", new Gson().toJson(incomeDistribution));
        request.setAttribute("purchaseFrequencyDistribution", new Gson().toJson(purchaseFrequencyDistribution));
        request.getRequestDispatcher("customer_seg_result.jsp").forward(request, response);
    }

    private Map<String, Long> segmentByAge() {
        Map<String, Long> ageDistribution = new HashMap<>();
        for (CustomerData customer : customerList) {
            String ageGroup = (customer.getAge() < 30) ? "Under 30" :
                             (customer.getAge() < 40) ? "30-39" :
                             (customer.getAge() < 50) ? "40-49" : "50 and above";
            ageDistribution.put(ageGroup, ageDistribution.getOrDefault(ageGroup, 0L) + 1);
        }
        return ageDistribution;
    }

    private Map<String, Long> segmentByIncomeLevel() {
        Map<String, Long> incomeDistribution = new HashMap<>();
        for (CustomerData customer : customerList) {
            incomeDistribution.put(customer.getIncomeLevel(), incomeDistribution.getOrDefault(customer.getIncomeLevel(), 0L) + 1);
        }
        return incomeDistribution;
    }

    private Map<String, Long> segmentByPurchaseFrequency() {
        Map<String, Long> purchaseFrequencyDistribution = new HashMap<>();
        for (CustomerData customer : customerList) {
            purchaseFrequencyDistribution.put(customer.getPurchaseFrequency(), purchaseFrequencyDistribution.getOrDefault(customer.getPurchaseFrequency(), 0L) + 1);
        }
        return purchaseFrequencyDistribution;
    }
}

