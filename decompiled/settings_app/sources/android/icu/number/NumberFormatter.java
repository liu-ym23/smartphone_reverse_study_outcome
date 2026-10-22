package android.icu.number;

import android.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class NumberFormatter {

    public static final enum DecimalSeparatorDisplay extends Enum<DecimalSeparatorDisplay> {
        private static final /* synthetic */ DecimalSeparatorDisplay[] $VALUES = null;
        public static final DecimalSeparatorDisplay ALWAYS = null;
        public static final DecimalSeparatorDisplay AUTO = null;

        public static DecimalSeparatorDisplay valueOf(String r1) {
            return (DecimalSeparatorDisplay) Enum.valueOf(DecimalSeparatorDisplay.class, r1);
        }

        public static DecimalSeparatorDisplay[] values() {
            return (DecimalSeparatorDisplay[]) $VALUES.clone();
        }

        private DecimalSeparatorDisplay(String r1, int r2) {
            super(r1, r2);
        }

        static {
            DecimalSeparatorDisplay r0 = new DecimalSeparatorDisplay("AUTO", 0);
            AUTO = r0;
            DecimalSeparatorDisplay r1 = new DecimalSeparatorDisplay("ALWAYS", 1);
            ALWAYS = r1;
            $VALUES = new DecimalSeparatorDisplay[]{r0, r1};
        }
    }

    public static final enum GroupingStrategy extends Enum<GroupingStrategy> {
        private static final /* synthetic */ GroupingStrategy[] $VALUES = null;
        public static final GroupingStrategy AUTO = null;
        public static final GroupingStrategy MIN2 = null;
        public static final GroupingStrategy OFF = null;
        public static final GroupingStrategy ON_ALIGNED = null;
        public static final GroupingStrategy THOUSANDS = null;

        public static GroupingStrategy valueOf(String r1) {
            return (GroupingStrategy) Enum.valueOf(GroupingStrategy.class, r1);
        }

        public static GroupingStrategy[] values() {
            return (GroupingStrategy[]) $VALUES.clone();
        }

        private GroupingStrategy(String r1, int r2) {
            super(r1, r2);
        }

        static {
            GroupingStrategy r0 = new GroupingStrategy("OFF", 0);
            OFF = r0;
            GroupingStrategy r1 = new GroupingStrategy("MIN2", 1);
            MIN2 = r1;
            GroupingStrategy r3 = new GroupingStrategy("AUTO", 2);
            AUTO = r3;
            GroupingStrategy r5 = new GroupingStrategy("ON_ALIGNED", 3);
            ON_ALIGNED = r5;
            GroupingStrategy r7 = new GroupingStrategy("THOUSANDS", 4);
            THOUSANDS = r7;
            $VALUES = new GroupingStrategy[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum SignDisplay extends Enum<SignDisplay> {
        private static final /* synthetic */ SignDisplay[] $VALUES = null;
        public static final SignDisplay ACCOUNTING = null;
        public static final SignDisplay ACCOUNTING_ALWAYS = null;
        public static final SignDisplay ACCOUNTING_EXCEPT_ZERO = null;
        public static final SignDisplay ALWAYS = null;
        public static final SignDisplay AUTO = null;
        public static final SignDisplay EXCEPT_ZERO = null;
        public static final SignDisplay NEVER = null;

        public static SignDisplay valueOf(String r1) {
            return (SignDisplay) Enum.valueOf(SignDisplay.class, r1);
        }

        public static SignDisplay[] values() {
            return (SignDisplay[]) $VALUES.clone();
        }

        private SignDisplay(String r1, int r2) {
            super(r1, r2);
        }

        static {
            SignDisplay r0 = new SignDisplay("AUTO", 0);
            AUTO = r0;
            SignDisplay r1 = new SignDisplay("ALWAYS", 1);
            ALWAYS = r1;
            SignDisplay r3 = new SignDisplay("NEVER", 2);
            NEVER = r3;
            SignDisplay r5 = new SignDisplay("ACCOUNTING", 3);
            ACCOUNTING = r5;
            SignDisplay r7 = new SignDisplay("ACCOUNTING_ALWAYS", 4);
            ACCOUNTING_ALWAYS = r7;
            SignDisplay r9 = new SignDisplay("EXCEPT_ZERO", 5);
            EXCEPT_ZERO = r9;
            SignDisplay r11 = new SignDisplay("ACCOUNTING_EXCEPT_ZERO", 6);
            ACCOUNTING_EXCEPT_ZERO = r11;
            $VALUES = new SignDisplay[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static final enum UnitWidth extends Enum<UnitWidth> {
        private static final /* synthetic */ UnitWidth[] $VALUES = null;
        public static final UnitWidth FORMAL = null;
        public static final UnitWidth FULL_NAME = null;
        public static final UnitWidth HIDDEN = null;
        public static final UnitWidth ISO_CODE = null;
        public static final UnitWidth NARROW = null;
        public static final UnitWidth SHORT = null;
        public static final UnitWidth VARIANT = null;

        public static UnitWidth valueOf(String r1) {
            return (UnitWidth) Enum.valueOf(UnitWidth.class, r1);
        }

        public static UnitWidth[] values() {
            return (UnitWidth[]) $VALUES.clone();
        }

        private UnitWidth(String r1, int r2) {
            super(r1, r2);
        }

        static {
            UnitWidth r0 = new UnitWidth("NARROW", 0);
            NARROW = r0;
            UnitWidth r1 = new UnitWidth("SHORT", 1);
            SHORT = r1;
            UnitWidth r3 = new UnitWidth("FULL_NAME", 2);
            FULL_NAME = r3;
            UnitWidth r5 = new UnitWidth("ISO_CODE", 3);
            ISO_CODE = r5;
            UnitWidth r7 = new UnitWidth("FORMAL", 4);
            FORMAL = r7;
            UnitWidth r9 = new UnitWidth("VARIANT", 5);
            VARIANT = r9;
            UnitWidth r11 = new UnitWidth("HIDDEN", 6);
            HIDDEN = r11;
            $VALUES = new UnitWidth[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    private NumberFormatter() {
        throw new RuntimeException("Stub!");
    }

    public static UnlocalizedNumberFormatter with() {
        throw new RuntimeException("Stub!");
    }

    public static LocalizedNumberFormatter withLocale(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocalizedNumberFormatter withLocale(ULocale r1) {
        throw new RuntimeException("Stub!");
    }
}
