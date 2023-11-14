package model;

import static java.lang.Math.abs;

public class Badge {
    private final String BADGE_SANTA = "산타";
    private final String BADGE_TREE = "트리";
    private final String BADGE_STAR = "별";
    private final String NOTHING = "없음";

    public String getBadge(int totalBenefitPrice) {
        if (abs(totalBenefitPrice) >= 20000) {
            return BADGE_SANTA;
        }
        if (abs(totalBenefitPrice) >= 10000) {
            return BADGE_TREE;
        }
        if (abs(totalBenefitPrice) >= 5000) {
            return BADGE_STAR;
        }
        return NOTHING;
    }
}
