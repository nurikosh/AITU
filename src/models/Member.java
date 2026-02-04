package models;

public class Member implements Displayable {

    private String name;
    private int age;
    private String email;

    // Constructor
    public Member(String name, int age, String email) throws IllegalArgumentException {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Name cannot be null or empty");
        }
        this.name = name;

        if (age <= 0) {
            throw new IllegalArgumentException("Error: Age must be greater than 0");
        }
        this.age = age;

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Error: Email must contain '@'");
        }
        this.email = email;

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



    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}
