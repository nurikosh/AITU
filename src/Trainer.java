public class Trainer {
    // Private fields
    private final String trainerId;
    private String name;
    private String specialization;
    private int yearsOfExperience;
    private int hourlyRate;
    private int clientsAssigned;

    // Constructor
    public Trainer(String trainerId, String name, String specialization, int yearsOfExperience) {
        if (trainerId == null || trainerId.trim().isEmpty()) {
            System.out.println("Error: Trainer ID cannot be null or empty");
            this.trainerId = "INVALID";
        } else {
            this.trainerId = trainerId;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be null or empty");
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (specialization == null || specialization.trim().isEmpty()) {
            System.out.println("Error: Specialization cannot be null or empty");
            this.specialization = "General";
        } else {
            this.specialization = specialization;
        }

        if (yearsOfExperience < 0) {
            System.out.println("Error: Years of experience cannot be negative");
            this.yearsOfExperience = 0;
        } else {
            this.yearsOfExperience = yearsOfExperience;
        }

        this.hourlyRate = 0;
        this.clientsAssigned = 0;
    }

    // Getters
    public String getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getClientsAssigned() {
        return clientsAssigned;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be null or empty");
            return;
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            System.out.println("Error: Specialization cannot be null or empty");
            return;
        }
        this.specialization = specialization;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            System.out.println("Error: Years of experience cannot be negative");
            return;
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0) {
            System.out.println("Error: Hourly rate cannot be negative");
            return;
        }
        this.hourlyRate = hourlyRate;
    }

    // Logic methods
    public void assignClient() {
        this.clientsAssigned++;
        System.out.println("Client assigned to " + name + ". Total clients: " + clientsAssigned);
    }

    public double calculateMonthlyEarnings(int hoursWorkedPerWeek) {
        if (hoursWorkedPerWeek <= 0 || hourlyRate <= 0) {
            System.out.println("Invalid hours or rate");
            return 0.0;
        }
        int monthlyEarnings = hourlyRate * hoursWorkedPerWeek * 4;
        System.out.println(name + "'s estimated monthly earnings:" + monthlyEarnings + "tenge");
        return monthlyEarnings;
    }

    public void displayInfo() {
        System.out.println("Trainer ID: " + trainerId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Clients Assigned: " + clientsAssigned);
    }
}
