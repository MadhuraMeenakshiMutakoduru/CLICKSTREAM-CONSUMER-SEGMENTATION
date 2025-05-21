CLICKSTREAM CONSUMER SEGMENTATION
Revealing Consumer Behavior Using K-Means Clustering on Clickstream Data

Overview
This project focuses on analyzing customer behavior using clickstream data collected from an e-commerce platform. By applying K-Means clustering (implemented manually in Java), users are segmented into distinct behavioral groups based on their interactions with the website. This approach aids businesses in identifying user engagement patterns and tailoring marketing strategies accordingly.

Objectives
Understand user navigation patterns and engagement metrics.

Group users with similar behavioral traits using clustering.

Implement the K-Means clustering algorithm from scratch.

Analyze and interpret customer segments for actionable insights.

Technologies Used
Technology	                   Purpose
Java	                         Core implementation
Eclipse IDE	                   Development environment
CSV                            Input dataset
K-Means Clustering	           Unsupervised machine learning technique

Algorithm: K-Means Clustering (Manual Implementation)
This project does not use any external machine learning libraries. All components of the K-Means algorithm were manually coded in Java to demonstrate an in-depth understanding of its working principles.

Key Steps:
Load clickstream data from a CSV file.

Initialize centroids randomly from the dataset.

Calculate the Euclidean distance manually between each data point and the centroids.

Assign each data point to the nearest cluster.

Recalculate centroids based on the mean of all points in each cluster.

Repeat steps 3–5 until convergence is achieved.

Features
Manual implementation of Euclidean distance calculation.

Cluster assignment based on minimal distance to centroids.

Iterative recalculation of centroids until convergence.

No use of external ML libraries (e.g., Weka, scikit-learn).

Final cluster allocations are printed as output.

File Structure

CustomerS_ClickStream/
├── clickstream_data.csv            # Input dataset
├── Consumer_Segmentation.java      # Core clustering logic
├── .project / .classpath           # Eclipse project configuration
└── src/                            # Source directory
Sample Output
css
Copy
Edit
Data Point (115.0, 4.2) assigned to Cluster 2
Data Point (72.0, 1.8) assigned to Cluster 0
...
Applications
Customer segmentation

Personalized advertising

User engagement analysis

Conversion rate optimization

Behavioral targeting

How to Run
Clone this repository:


git clone https://github.com/MadhuraMeenakshiMutakoduru/CLICKSTREAM-CONSUMER-SEGMENTATION.git
Open the project in Eclipse IDE.

Ensure that clickstream_data.csv is located in the root directory of the project.

Execute the Consumer_Segmentation.java file.

Author
Madhura Meenakshi Mutakoduru
LinkedIn: Madhura Meenakshi Mutakoduru
