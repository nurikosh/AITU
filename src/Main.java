import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Trainer> trainers = new ArrayList<>();
    static ArrayList<Membership> memberships = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
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
        }
    }

    static void displayMenu() {
        System.out.println("=== GYM SYSTEM ===");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("5. Add Membership");
        System.out.println("6. View All Memberships");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    static void addMember() {
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
        System.out.println("Member added successfully!");
    }

    static void viewAllMembers() {
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

    static void addTrainer() {
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
        System.out.println("Trainer added successfully!");
    }

    static void viewAllTrainers() {
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

    static void addMembership() {
        System.out.println("\n=== SELECT MEMBERSHIP TYPE ===");
        System.out.println("1. Basic Membership (19,990 tenge/month)");
        System.out.println("2. Premium Membership (35,000 tenge/month)");
        System.out.println("3. VIP Membership (100,000 tenge/month)");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Membership ID: ");
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
        System.out.println("\nMembership added successfully!");
        membership.showBenefits();
    }

    static void viewAllMemberships() {
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

