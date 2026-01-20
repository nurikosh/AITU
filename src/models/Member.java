package models;

public class Member implements Displayable {

    private final String memberId;
    private String name;
    private int age;
    private String email;
    private double weight; // in kg
    private int sessionsAttended;

    // Constructor
    public Member(String memberId, String name, int age, String email) {
        if (memberId == null || memberId.trim().isEmpty()) {
            System.out.println("Error: models.Member ID cannot be null or empty");
            this.memberId = "INVALID";
        } else {
            this.memberId = memberId;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be null or empty");
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (age <= 0) {
            System.out.println("Error: Age must be greater than 0");
            this.age = 18;
        } else {
            this.age = age;
        }

        if (email == null || email.trim().isEmpty()) {
            System.out.println("Error: Email cannot be null or empty");
            this.email = "invalid@email.com";
        } else if (!email.contains("@")) {
            System.out.println("Error: Email must contain '@'");
            this.email = "invalid@email.com";
        } else {
            this.email = email;
        }

        this.weight = 0.0;
        this.sessionsAttended = 0;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public double getWeight() {
        return weight;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    // Setters
    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        this.age = age;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@'");
        }
        this.email = email;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.weight = weight;
    }

    // Logic methods
    public void attendSession() {
        this.sessionsAttended++;
        System.out.println(name + " attended a session. Total sessions: " + sessionsAttended);
    }

    public double calculateBMI(double heightInMeters) {
        if (heightInMeters <= 0 || weight <= 0) {
            System.out.println("Invalid height or weight");
            return 0.0;
        }
        double bmi = weight / (heightInMeters * heightInMeters);
        System.out.println(name + "'s BMI: " + String.format("%.2f", bmi));
        return bmi;
    }

    @Override
    public void displayInfo() {
        System.out.println("models.Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Sessions Attended: " + sessionsAttended);
    }
}
