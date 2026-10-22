package android.icu.number;

import android.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberRangeFormatter {

    public static final enum RangeCollapse extends Enum<RangeCollapse> {
        private static final /* synthetic */ RangeCollapse[] $VALUES = null;
        public static final RangeCollapse ALL = null;
        public static final RangeCollapse AUTO = null;
        public static final RangeCollapse NONE = null;
        public static final RangeCollapse UNIT = null;

        public static RangeCollapse valueOf(String r1) {
            return (RangeCollapse) Enum.valueOf(RangeCollapse.class, r1);
        }

        public static RangeCollapse[] values() {
            return (RangeCollapse[]) $VALUES.clone();
        }

        private RangeCollapse(String r1, int r2) {
            super(r1, r2);
        }

        static {
            RangeCollapse r0 = new RangeCollapse("AUTO", 0);
            AUTO = r0;
            RangeCollapse r1 = new RangeCollapse("NONE", 1);
            NONE = r1;
            RangeCollapse r3 = new RangeCollapse("UNIT", 2);
            UNIT = r3;
            RangeCollapse r5 = new RangeCollapse("ALL", 3);
            ALL = r5;
            $VALUES = new RangeCollapse[]{r0, r1, r3, r5};
        }
    }

    public static final enum RangeIdentityFallback extends Enum<RangeIdentityFallback> {
        private static final /* synthetic */ RangeIdentityFallback[] $VALUES = null;
        public static final RangeIdentityFallback APPROXIMATELY = null;
        public static final RangeIdentityFallback APPROXIMATELY_OR_SINGLE_VALUE = null;
        public static final RangeIdentityFallback RANGE = null;
        public static final RangeIdentityFallback SINGLE_VALUE = null;

        public static RangeIdentityFallback valueOf(String r1) {
            return (RangeIdentityFallback) Enum.valueOf(RangeIdentityFallback.class, r1);
        }

        public static RangeIdentityFallback[] values() {
            return (RangeIdentityFallback[]) $VALUES.clone();
        }

        private RangeIdentityFallback(String r1, int r2) {
            super(r1, r2);
        }

        static {
            RangeIdentityFallback r0 = new RangeIdentityFallback("SINGLE_VALUE", 0);
            SINGLE_VALUE = r0;
            RangeIdentityFallback r1 = new RangeIdentityFallback("APPROXIMATELY_OR_SINGLE_VALUE", 1);
            APPROXIMATELY_OR_SINGLE_VALUE = r1;
            RangeIdentityFallback r3 = new RangeIdentityFallback("APPROXIMATELY", 2);
            APPROXIMATELY = r3;
            RangeIdentityFallback r5 = new RangeIdentityFallback("RANGE", 3);
            RANGE = r5;
            $VALUES = new RangeIdentityFallback[]{r0, r1, r3, r5};
        }
    }

    public static final enum RangeIdentityResult extends Enum<RangeIdentityResult> {
        private static final /* synthetic */ RangeIdentityResult[] $VALUES = null;
        public static final RangeIdentityResult EQUAL_AFTER_ROUNDING = null;
        public static final RangeIdentityResult EQUAL_BEFORE_ROUNDING = null;
        public static final RangeIdentityResult NOT_EQUAL = null;

        public static RangeIdentityResult valueOf(String r1) {
            return (RangeIdentityResult) Enum.valueOf(RangeIdentityResult.class, r1);
        }

        public static RangeIdentityResult[] values() {
            return (RangeIdentityResult[]) $VALUES.clone();
        }

        private RangeIdentityResult(String r1, int r2) {
            super(r1, r2);
        }

        static {
            RangeIdentityResult r0 = new RangeIdentityResult("EQUAL_BEFORE_ROUNDING", 0);
            EQUAL_BEFORE_ROUNDING = r0;
            RangeIdentityResult r1 = new RangeIdentityResult("EQUAL_AFTER_ROUNDING", 1);
            EQUAL_AFTER_ROUNDING = r1;
            RangeIdentityResult r3 = new RangeIdentityResult("NOT_EQUAL", 2);
            NOT_EQUAL = r3;
            $VALUES = new RangeIdentityResult[]{r0, r1, r3};
        }
    }

    private NumberRangeFormatter() {
        throw new RuntimeException("Stub!");
    }

    public static UnlocalizedNumberRangeFormatter with() {
        throw new RuntimeException("Stub!");
    }

    public static LocalizedNumberRangeFormatter withLocale(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocalizedNumberRangeFormatter withLocale(ULocale r1) {
        throw new RuntimeException("Stub!");
    }
}
