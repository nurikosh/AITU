package models;

public class VIPMembership extends Membership {

    public VIPMembership(String membershipId, int durationMonths) {
        super(membershipId, "VIP", 100000, durationMonths);
    }

    @Override
    public void showBenefits() {
        System.out.println("=== VIP models.Membership Benefits ===");
        System.out.println("- 24/7 access to all gym facilities");
        System.out.println("- All equipment access including exclusive VIP zone");
        System.out.println("- Private locker room with spa amenities");
        System.out.println("- Unlimited personal training sessions");
        System.out.println("- Access to all group classes with priority booking");
        System.out.println("- Free nutritionist consultation");
        System.out.println("- Complimentary guest passes (2 per month)");
        System.out.println("- Free fitness assessment and body composition analysis");
    }
}
