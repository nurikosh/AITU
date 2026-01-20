package models;

public class PremiumMembership extends Membership {

    public PremiumMembership(String membershipId, int durationMonths) {
        super(membershipId, "Premium", 35000, durationMonths);
    }

    @Override
    public void showBenefits() {
        System.out.println("=== Premium models.Membership Benefits ===");
        System.out.println("- Access to gym facilities");
        System.out.println("- All equipment access including premium machines");
        System.out.println("- Locker room with premium amenities");
        System.out.println("- 2 free personal training sessions per month");
        System.out.println("- Access to group classes");
    }
}
