public class BasicMembership extends Membership {

    public BasicMembership(String membershipId, int durationMonths) {
        super(membershipId, "Basic", 19990, durationMonths);
    }

    @Override
    public void showBenefits() {
        System.out.println("=== Basic Membership Benefits ===");
        System.out.println("- Access to gym facilities");
        System.out.println("- Standard equipment access");
        System.out.println("- Locker room access");
    }
}
