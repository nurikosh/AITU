package models;

public abstract class Membership {
    // Protected fields (accessible by subclasses)
    protected final String membershipId;
    protected String planType;
    protected int monthlyFee;
    protected int durationMonths;
    protected boolean isActive;
    protected String startDate;

    // Constructor
    public Membership(String membershipId, String planType, int monthlyFee, int durationMonths) {
        if (membershipId == null || membershipId.trim().isEmpty()) {
            System.out.println("Error: models.Membership ID cannot be null or empty");
            this.membershipId = "INVALID";
        } else {
            this.membershipId = membershipId;
        }

        if (planType == null || planType.trim().isEmpty()) {
            System.out.println("Error: Plan type cannot be null or empty");
            this.planType = "Basic";
        } else {
            this.planType = planType;
        }

        if (monthlyFee < 0) {
            System.out.println("Error: Monthly fee cannot be negative");
            this.monthlyFee = 0;
        } else {
            this.monthlyFee = monthlyFee;
        }

        if (durationMonths <= 0) {
            System.out.println("Error: Duration must be greater than 0");
            this.durationMonths = 1;
        } else {
            this.durationMonths = durationMonths;
        }

        this.isActive = true;
        this.startDate = "2025-12-26"; // Default start date
    }

    public abstract void showBenefits();

    // Getters
    public String getMembershipId() {
        return membershipId;
    }

    public String getPlanType() {
        return planType;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getStartDate() {
        return startDate;
    }

    // Setters
    public void setPlanType(String planType) throws IllegalArgumentException {
        if (planType == null || planType.trim().isEmpty()) {
            throw new IllegalArgumentException("Plan type cannot be null or empty");
        }
        this.planType = planType;
    }

    public void setMonthlyFee(int monthlyFee) throws IllegalArgumentException {
        if (monthlyFee < 0) {
            throw new IllegalArgumentException("Monthly fee cannot be negative");
        }
        this.monthlyFee = monthlyFee;
    }

    public void setDurationMonths(int durationMonths) throws IllegalArgumentException {
        if (durationMonths <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.durationMonths = durationMonths;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setStartDate(String startDate) throws IllegalArgumentException {
        if (startDate == null || startDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Start date cannot be null or empty");
        }
        this.startDate = startDate;
    }

    // Logic methods
    public double calculateTotalCost() {
        int totalCost = monthlyFee * durationMonths;
        System.out.println("Total cost for " + planType + " plan (" + durationMonths + " months): " + totalCost);
        return totalCost;
    }

    public double applyDiscount(int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            System.out.println("Invalid discount percentage");
            return monthlyFee;
        }
        int discountedFee = monthlyFee - (monthlyFee * discountPercent / 100);
        System.out.println("Original fee:" + monthlyFee);
        System.out.println("Discount: " + discountPercent + "%");
        System.out.println("New monthly fee:" + discountedFee);
        this.monthlyFee = discountedFee;
        return discountedFee;
    }

    public void cancelMembership() {
        this.isActive = false;
        System.out.println("models.Membership " + membershipId + " has been cancelled");
    }

    public void displayInfo() {
        System.out.println("models.Membership ID: " + membershipId);
        System.out.println("Plan Type: " + planType);
        System.out.println("Monthly Fee: " + monthlyFee);
        System.out.println("Duration: " + durationMonths + " months");
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("Start Date: " + startDate);
    }
}
