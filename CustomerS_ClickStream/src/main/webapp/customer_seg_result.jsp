<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Segmentations</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <h1>Customer Segmentations</h1>

    <h2>Segment by Age (Bar Chart)</h2>
    <canvas id="ageBarChart" width="400" height="200"></canvas>

    <h2>Segment by Income Level (Pie Chart)</h2>
    <canvas id="incomePieChart" width="400" height="200"></canvas>

    <h2>Segment by Purchase Frequency (Line Chart)</h2>
    <canvas id="frequencyLineChart" width="400" height="200"></canvas>

    <h2>Segment by Product Category (Radar Chart)</h2>
    <canvas id="categoryRadarChart" width="400" height="200"></canvas>

    <script>
    try {
        // Static Data
        var ageLabels = ['18-24', '25-34', '35-44', '45-54', '55-60'];
        var ageData = [10, 20, 15, 5, 8];

        var incomeLabels = ['Low', 'Middle', 'High'];
        var incomeData = [5, 30, 15];

        var frequencyLabels = ['Frequent', 'Occasional', 'One-time'];
        var frequencyData = [15, 25, 10];

        var categoryLabels = ['Electronics', 'Fitness Equipment', 'Clothing', 'Home Appliances', 'Outdoor Gear'];
        var categoryData = [20, 15, 10, 8, 5];

        // Bar Chart for Age Segmentation
        var ageBarCtx = document.getElementById('ageBarChart').getContext('2d');
        new Chart(ageBarCtx, {
            type: 'bar',
            data: {
                labels: ageLabels,
                datasets: [{
                    label: 'Number of Customers',
                    data: ageData,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        // Pie Chart for Income Level Segmentation
        var incomePieCtx = document.getElementById('incomePieChart').getContext('2d');
        new Chart(incomePieCtx, {
            type: 'pie',
            data: {
                labels: incomeLabels,
                datasets: [{
                    label: 'Number of Customers',
                    data: incomeData,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }]
            }
        });

        // Line Chart for Purchase Frequency Segmentation
        var frequencyLineCtx = document.getElementById('frequencyLineChart').getContext('2d');
        new Chart(frequencyLineCtx, {
            type: 'line',
            data: {
                labels: frequencyLabels,
                datasets: [{
                    label: 'Number of Customers',
                    data: frequencyData,
                    fill: false,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    tension: 0.1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        // Radar Chart for Product Category Segmentation
        var categoryRadarCtx = document.getElementById('categoryRadarChart').getContext('2d');
        new Chart(categoryRadarCtx, {
            type: 'radar',
            data: {
                labels: categoryLabels,
                datasets: [{
                    label: 'Number of Customers',
                    data: categoryData,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            }
        });

    } catch (error) {
        console.error(error.message);
        alert(error.message);
    }

    </script>
    
</body>
</html>
