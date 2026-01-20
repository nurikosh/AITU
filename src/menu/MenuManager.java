package menu;

import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class MenuManager implements Menu {
    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;
    private ArrayList<Membership> memberships;
    private Scanner scanner;

    public MenuManager() {
        this.members = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.memberships = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("=== GYM SYSTEM ===");
        System.out.println("1. Add models.Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add models.Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("5. Add models.Membership");
        System.out.println("6. View All Memberships");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run() {
        while (true) {
            try {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        viewAllMembers();
                        break;
                    case 3:
                        addTrainer();
                        break;
                    case 4:
                        viewAllTrainers();
                        break;
                    case 5:
                        addMembership();
                        break;
                    case 6:
                        viewAllMemberships();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public void addMember() {
        try {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter an email: ");
            String membershipType = scanner.nextLine();

            Member member = new Member(id, name, age, membershipType);
            members.add(member);
            System.out.println("models.Member added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("\n=== ALL MEMBERS ===");
        for (Member member : members) {
            member.displayInfo();
            System.out.println("-------------------");
        }
    }

    public void addTrainer() {
        try {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Enter Experience (years): ");
            int experience = scanner.nextInt();
            scanner.nextLine();

            Trainer trainer = new Trainer(id, name, specialization, experience);
            trainers.add(trainer);
            System.out.println("models.Trainer added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void viewAllTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        System.out.println("\n=== ALL TRAINERS ===");
        for (Trainer trainer : trainers) {
            trainer.displayInfo();
            System.out.println("-------------------");
        }
    }

    public void addMembership() {
        try {
            System.out.println("\n=== SELECT MEMBERSHIP TYPE ===");
            System.out.println("1. Basic models.Membership (19,990 tenge/month)");
            System.out.println("2. Premium models.Membership (35,000 tenge/month)");
            System.out.println("3. VIP models.Membership (100,000 tenge/month)");
            System.out.print("Enter choice: ");
            int type = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter models.Membership ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Duration (months): ");
            int duration = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Membership membership;
            switch (type) {
                case 1:
                    membership = new BasicMembership(id, duration);
                    break;
                case 2:
                    membership = new PremiumMembership(id, duration);
                    break;
                case 3:
                    membership = new VIPMembership(id, duration);
                    break;
                default:
                    System.out.println("Invalid membership type!");
                    return;
            }

            memberships.add(membership);
            System.out.println("\nmodels.Membership added successfully!");
            membership.showBenefits();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void viewAllMemberships() {
        if (memberships.isEmpty()) {
            System.out.println("No memberships found.");
            return;
        }

        System.out.println("\n=== ALL MEMBERSHIPS ===");
        for (Membership membership : memberships) {
            membership.displayInfo();
            membership.showBenefits();
            System.out.println("-------------------");
        }
    }
}

