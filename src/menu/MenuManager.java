package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.*;
import database.MemberDAO;

public class MenuManager implements Menu {
    private MemberDAO memberDAO;
    private ArrayList<Trainer> trainers;
    private ArrayList<Membership> memberships;
    private Scanner scanner;

    public MenuManager() {
        this.memberDAO = new MemberDAO();
        this.trainers = new ArrayList<>();
        this.memberships = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("=== GYM SYSTEM ===");
        System.out.println("1. Add models.Member");
        System.out.println("2. View All Members");
        System.out.println("3. Update models.Member");
        System.out.println("4. Delete models.Member");
        System.out.println("5. Search models.Member by ID");
        System.out.println("6. Search models.Member by Name");
        System.out.println("7. Search models.Member by Age");
        System.out.println("8. Add models.Trainer");
        System.out.println("9. View All Trainers");
        System.out.println("10. Add models.Membership");
        System.out.println("11. View All Memberships");
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
                        updateMember();
                        break;
                    case 4:
                        deleteMember();
                        break;
                    case 5:
                        searchMemberById();
                        break;
                    case 6:
                        searchMemberByName();
                        break;
                    case 7:
                        searchMemberByAge();
                        break;
                    case 8:
                        addTrainer();
                        break;
                    case 9:
                        viewAllTrainers();
                        break;
                    case 10:
                        addMembership();
                        break;
                    case 11:
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
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    public void addMember() {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter an email: ");
            String email = scanner.nextLine();

            Member member = new Member(name, age, email);
            memberDAO.InsertMember(member);
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
        List<Member> members = memberDAO.getAllMembers();
        if (members == null || members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("\n=== ALL MEMBERS ===");
        for (Member member : members) {
            member.displayInfo();
            System.out.println("-------------------");
        }
    }

    public void addTrainer(){
        try{
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();
            System.out.println("Enter Years of Experience: ");
            int years = scanner.nextInt();

            Trainer trainer = new Trainer(id, name, specialization, years);
            trainers.add(trainer);
            System.out.println("Trainer added successfully!");
        }catch(NumberFormatException e){
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine();
        }catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    public void viewAllTrainers(){
        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        System.out.println("=== ALL TRAINERS ===");
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

    public void updateMember() {
        try {
            System.out.print("Enter Member ID to update: ");
            int memberId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter New Email: ");
            String email = scanner.nextLine();

            Member member = new Member(name, age, email);
            memberDAO.updateMember(memberId, member);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    public void deleteMember() {
        try {
            System.out.print("Enter Member ID to delete: ");
            int memberId = scanner.nextInt();
            scanner.nextLine();

            memberDAO.deleteMember(memberId);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    public void searchMemberById() {
        try {
            System.out.print("Enter Member ID to search: ");
            int memberId = scanner.nextInt();
            scanner.nextLine();

            Member member = memberDAO.searchById(memberId);
            if (member != null) {
                System.out.println("\n=== MEMBER FOUND ===");
                member.displayInfo();
            } else {
                System.out.println("No member found with ID: " + memberId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    public void searchMemberByName() {
        try {
            System.out.print("Enter Name to search: ");
            String name = scanner.nextLine();

            List<Member> members = memberDAO.searchByName(name);
            if (members.isEmpty()) {
                System.out.println("No members found with name containing: " + name);
            } else {
                System.out.println("\n=== SEARCH RESULTS ===");
                for (Member member : members) {
                    member.displayInfo();
                    System.out.println("-------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchMemberByAge() {
        try {
            System.out.print("Enter Age to search: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            List<Member> members = memberDAO.searchByAge(age);
            if (members.isEmpty()) {
                System.out.println("No members found with age: " + age);
            } else {
                System.out.println("\n=== SEARCH RESULTS ===");
                for (Member member : members) {
                    member.displayInfo();
                    System.out.println("-------------------");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
}

