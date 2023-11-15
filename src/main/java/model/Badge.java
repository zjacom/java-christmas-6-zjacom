package model;

import static java.lang.Math.abs;

public enum Badge {
    BADGE_SANTA("산타"),
    BADGE_TREE("트리"),
    BADGE_STAR("별"),
    NOTHING("없음");

    private final String badgeName;

    Badge(String badgeName) {
        this.badgeName = badgeName;
    }

    public static String getBadgeName(int totalBenefitPrice) {
        if (abs(totalBenefitPrice) >= 20000) {
            return BADGE_SANTA.badgeName;
        }
        if (abs(totalBenefitPrice) >= 10000) {
            return BADGE_TREE.badgeName;
        }
        if (abs(totalBenefitPrice) >= 5000) {
            return BADGE_STAR.badgeName;
        }
        return NOTHING.badgeName;
    }
}
