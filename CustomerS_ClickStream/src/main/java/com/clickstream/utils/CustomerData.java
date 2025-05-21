package com.clickstream.utils;

public class CustomerData {
    private String shoppingId;
    private String customerName;
    private int age;
    private String gender;
    private String incomeLevel;
    private String purchaseFrequency;
    private String loyaltyLevel;
    private String region;
    private String lifestyle;
    private String productPreference;
    private int pagesVisited;
    private int timeOnSite;
    private int productsClicked;
    private String categoriesExplored;
    private String exitPage;
    private int purchaseIntent;

    public CustomerData(String[] data) {
        this.shoppingId = data[0];
        this.customerName = data[1];
        this.age = Integer.parseInt(data[2]);
        this.gender = data[3];
        this.incomeLevel = data[4];
        this.purchaseFrequency = data[5];
        this.loyaltyLevel = data[6];
        this.region = data[7];
        this.lifestyle = data[8];
        this.productPreference = data[9];
        this.pagesVisited = Integer.parseInt(data[10]);
        this.timeOnSite = Integer.parseInt(data[11]);
        this.productsClicked = Integer.parseInt(data[12]);
        this.categoriesExplored = data[13];
        this.exitPage = data[14];
        this.purchaseIntent = Integer.parseInt(data[15]);
    }

	public String getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(String shoppingId) {
		this.shoppingId = shoppingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIncomeLevel() {
		return incomeLevel;
	}

	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	public String getPurchaseFrequency() {
		return purchaseFrequency;
	}

	public void setPurchaseFrequency(String purchaseFrequency) {
		this.purchaseFrequency = purchaseFrequency;
	}

	public String getLoyaltyLevel() {
		return loyaltyLevel;
	}

	public void setLoyaltyLevel(String loyaltyLevel) {
		this.loyaltyLevel = loyaltyLevel;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}

	public String getProductPreference() {
		return productPreference;
	}

	public void setProductPreference(String productPreference) {
		this.productPreference = productPreference;
	}

	public int getPagesVisited() {
		return pagesVisited;
	}

	public void setPagesVisited(int pagesVisited) {
		this.pagesVisited = pagesVisited;
	}

	public int getTimeOnSite() {
		return timeOnSite;
	}

	public void setTimeOnSite(int timeOnSite) {
		this.timeOnSite = timeOnSite;
	}

	public int getProductsClicked() {
		return productsClicked;
	}

	public void setProductsClicked(int productsClicked) {
		this.productsClicked = productsClicked;
	}

	public String getCategoriesExplored() {
		return categoriesExplored;
	}

	public void setCategoriesExplored(String categoriesExplored) {
		this.categoriesExplored = categoriesExplored;
	}

	public String getExitPage() {
		return exitPage;
	}

	public void setExitPage(String exitPage) {
		this.exitPage = exitPage;
	}

	public int getPurchaseIntent() {
		return purchaseIntent;
	}

	public void setPurchaseIntent(int purchaseIntent) {
		this.purchaseIntent = purchaseIntent;
	}

    // Getters and setters for each field (omitted for brevity)
    
    
    
}

