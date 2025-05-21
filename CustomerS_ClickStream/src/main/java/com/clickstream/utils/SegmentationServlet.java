package com.clickstream.utils;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/segment")
public class SegmentationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = Constants.DATASET_PATH; // Update this path
        System.out.println("---");
        List<Customer> customers = CsvReader.readCsv(filePath);
        System.out.println(customers);
        // Perform segmentations
        request.setAttribute("segmentByAge", segmentByAge(customers));
        System.out.println("1");
        request.setAttribute("segmentByIncome", segmentByIncome(customers));
        System.out.println("2");
        request.setAttribute("segmentByPurchaseFrequency", segmentByPurchaseFrequency(customers));
        System.out.println("3");
        request.setAttribute("segmentByProductCategory", segmentByProductCategory(customers));
        System.out.println("4");
        
        request.getRequestDispatcher("customer_seg_result.jsp").forward(request, response);
    }

    private Map<String, Long> segmentByAge(List<Customer> customers) {
        Map<String, Long> ageGroups = new HashMap<>();
        ageGroups.put("18-24", customers.stream().filter(c -> c.getAge() >= 18 && c.getAge() <= 24).count());
        ageGroups.put("25-34", customers.stream().filter(c -> c.getAge() >= 25 && c.getAge() <= 34).count());
        ageGroups.put("35-44", customers.stream().filter(c -> c.getAge() >= 35 && c.getAge() <= 44).count());
        ageGroups.put("45-54", customers.stream().filter(c -> c.getAge() >= 45 && c.getAge() <= 54).count());
        ageGroups.put("55-60", customers.stream().filter(c -> c.getAge() >= 55 && c.getAge() <= 60).count());
        System.out.println(ageGroups);

        return ageGroups;
    }

    private Map<String, Long> segmentByIncome(List<Customer> customers) {
        Map<String, Long> incomeGroups = new HashMap<>();
        for (String level : new String[] {"Low", "Middle", "High"}) {
            incomeGroups.put(level, customers.stream().filter(c -> c.getIncomeLevel().equals(level)).count());
        }
        System.out.println(incomeGroups);

        return incomeGroups;
    }

    private Map<String, Long> segmentByPurchaseFrequency(List<Customer> customers) {
        Map<String, Long> frequencyGroups = new HashMap<>();
        for (String frequency : new String[] {"Frequent", "Occasional", "One-time"}) {
            frequencyGroups.put(frequency, customers.stream().filter(c -> c.getPurchaseFrequency().equals(frequency)).count());
        }
        System.out.println(frequencyGroups);

        return frequencyGroups;
    }

    private Map<String, Long> segmentByProductCategory(List<Customer> customers) {
        Map<String, Long> categoryGroups = new HashMap<>();
        for (String category : new String[] {"Electronics", "Fitness Equipment", "Clothing", "Home Appliances", "Outdoor Gear", "Health Supplements", "Fashion", "Travel", "Sports"}) {
            categoryGroups.put(category, customers.stream().filter(c -> c.getProductPreference().equals(category)).count());
        }
        System.out.println(categoryGroups);

        return categoryGroups;
    }
}
