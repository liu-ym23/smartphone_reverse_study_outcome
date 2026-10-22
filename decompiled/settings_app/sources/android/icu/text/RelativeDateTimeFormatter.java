package android.icu.text;

import android.icu.util.ULocale;
import java.text.AttributedCharacterIterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class RelativeDateTimeFormatter {

    public static final enum AbsoluteUnit extends Enum<AbsoluteUnit> {
        private static final /* synthetic */ AbsoluteUnit[] $VALUES = null;
        public static final AbsoluteUnit DAY = null;
        public static final AbsoluteUnit FRIDAY = null;
        public static final AbsoluteUnit HOUR = null;
        public static final AbsoluteUnit MINUTE = null;
        public static final AbsoluteUnit MONDAY = null;
        public static final AbsoluteUnit MONTH = null;
        public static final AbsoluteUnit NOW = null;
        public static final AbsoluteUnit QUARTER = null;
        public static final AbsoluteUnit SATURDAY = null;
        public static final AbsoluteUnit SUNDAY = null;
        public static final AbsoluteUnit THURSDAY = null;
        public static final AbsoluteUnit TUESDAY = null;
        public static final AbsoluteUnit WEDNESDAY = null;
        public static final AbsoluteUnit WEEK = null;
        public static final AbsoluteUnit YEAR = null;

        public static AbsoluteUnit valueOf(String r1) {
            return (AbsoluteUnit) Enum.valueOf(AbsoluteUnit.class, r1);
        }

        public static AbsoluteUnit[] values() {
            return (AbsoluteUnit[]) $VALUES.clone();
        }

        private AbsoluteUnit(String r1, int r2) {
            super(r1, r2);
        }

        static {
            AbsoluteUnit r0 = new AbsoluteUnit("SUNDAY", 0);
            SUNDAY = r0;
            AbsoluteUnit r1 = new AbsoluteUnit("MONDAY", 1);
            MONDAY = r1;
            AbsoluteUnit r3 = new AbsoluteUnit("TUESDAY", 2);
            TUESDAY = r3;
            AbsoluteUnit r5 = new AbsoluteUnit("WEDNESDAY", 3);
            WEDNESDAY = r5;
            AbsoluteUnit r7 = new AbsoluteUnit("THURSDAY", 4);
            THURSDAY = r7;
            AbsoluteUnit r9 = new AbsoluteUnit("FRIDAY", 5);
            FRIDAY = r9;
            AbsoluteUnit r11 = new AbsoluteUnit("SATURDAY", 6);
            SATURDAY = r11;
            AbsoluteUnit r13 = new AbsoluteUnit("DAY", 7);
            DAY = r13;
            AbsoluteUnit r15 = new AbsoluteUnit("WEEK", 8);
            WEEK = r15;
            AbsoluteUnit r14 = new AbsoluteUnit("MONTH", 9);
            MONTH = r14;
            AbsoluteUnit r12 = new AbsoluteUnit("YEAR", 10);
            YEAR = r12;
            AbsoluteUnit r10 = new AbsoluteUnit("NOW", 11);
            NOW = r10;
            AbsoluteUnit r8 = new AbsoluteUnit("QUARTER", 12);
            QUARTER = r8;
            AbsoluteUnit r6 = new AbsoluteUnit("HOUR", 13);
            HOUR = r6;
            AbsoluteUnit r4 = new AbsoluteUnit("MINUTE", 14);
            MINUTE = r4;
            $VALUES = new AbsoluteUnit[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        }
    }

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction LAST = null;
        public static final Direction LAST_2 = null;
        public static final Direction NEXT = null;
        public static final Direction NEXT_2 = null;
        public static final Direction PLAIN = null;
        public static final Direction THIS = null;

        public static Direction valueOf(String r1) {
            return (Direction) Enum.valueOf(Direction.class, r1);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Direction r0 = new Direction("LAST_2", 0);
            LAST_2 = r0;
            Direction r1 = new Direction("LAST", 1);
            LAST = r1;
            Direction r3 = new Direction("THIS", 2);
            THIS = r3;
            Direction r5 = new Direction("NEXT", 3);
            NEXT = r5;
            Direction r7 = new Direction("NEXT_2", 4);
            NEXT_2 = r7;
            Direction r9 = new Direction("PLAIN", 5);
            PLAIN = r9;
            $VALUES = new Direction[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static class FormattedRelativeDateTime implements FormattedValue {
        private FormattedRelativeDateTime() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue, java.lang.CharSequence
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public int length() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public <A extends Appendable> A appendTo(A r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public boolean nextPosition(ConstrainedFieldPosition r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.FormattedValue
        public AttributedCharacterIterator toCharacterIterator() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final enum RelativeDateTimeUnit extends Enum<RelativeDateTimeUnit> {
        private static final /* synthetic */ RelativeDateTimeUnit[] $VALUES = null;
        public static final RelativeDateTimeUnit DAY = null;
        public static final RelativeDateTimeUnit FRIDAY = null;
        public static final RelativeDateTimeUnit HOUR = null;
        public static final RelativeDateTimeUnit MINUTE = null;
        public static final RelativeDateTimeUnit MONDAY = null;
        public static final RelativeDateTimeUnit MONTH = null;
        public static final RelativeDateTimeUnit QUARTER = null;
        public static final RelativeDateTimeUnit SATURDAY = null;
        public static final RelativeDateTimeUnit SECOND = null;
        public static final RelativeDateTimeUnit SUNDAY = null;
        public static final RelativeDateTimeUnit THURSDAY = null;
        public static final RelativeDateTimeUnit TUESDAY = null;
        public static final RelativeDateTimeUnit WEDNESDAY = null;
        public static final RelativeDateTimeUnit WEEK = null;
        public static final RelativeDateTimeUnit YEAR = null;

        public static RelativeDateTimeUnit valueOf(String r1) {
            return (RelativeDateTimeUnit) Enum.valueOf(RelativeDateTimeUnit.class, r1);
        }

        public static RelativeDateTimeUnit[] values() {
            return (RelativeDateTimeUnit[]) $VALUES.clone();
        }

        private RelativeDateTimeUnit(String r1, int r2) {
            super(r1, r2);
        }

        static {
            RelativeDateTimeUnit r0 = new RelativeDateTimeUnit("YEAR", 0);
            YEAR = r0;
            RelativeDateTimeUnit r1 = new RelativeDateTimeUnit("QUARTER", 1);
            QUARTER = r1;
            RelativeDateTimeUnit r3 = new RelativeDateTimeUnit("MONTH", 2);
            MONTH = r3;
            RelativeDateTimeUnit r5 = new RelativeDateTimeUnit("WEEK", 3);
            WEEK = r5;
            RelativeDateTimeUnit r7 = new RelativeDateTimeUnit("DAY", 4);
            DAY = r7;
            RelativeDateTimeUnit r9 = new RelativeDateTimeUnit("HOUR", 5);
            HOUR = r9;
            RelativeDateTimeUnit r11 = new RelativeDateTimeUnit("MINUTE", 6);
            MINUTE = r11;
            RelativeDateTimeUnit r13 = new RelativeDateTimeUnit("SECOND", 7);
            SECOND = r13;
            RelativeDateTimeUnit r15 = new RelativeDateTimeUnit("SUNDAY", 8);
            SUNDAY = r15;
            RelativeDateTimeUnit r14 = new RelativeDateTimeUnit("MONDAY", 9);
            MONDAY = r14;
            RelativeDateTimeUnit r12 = new RelativeDateTimeUnit("TUESDAY", 10);
            TUESDAY = r12;
            RelativeDateTimeUnit r10 = new RelativeDateTimeUnit("WEDNESDAY", 11);
            WEDNESDAY = r10;
            RelativeDateTimeUnit r8 = new RelativeDateTimeUnit("THURSDAY", 12);
            THURSDAY = r8;
            RelativeDateTimeUnit r6 = new RelativeDateTimeUnit("FRIDAY", 13);
            FRIDAY = r6;
            RelativeDateTimeUnit r4 = new RelativeDateTimeUnit("SATURDAY", 14);
            SATURDAY = r4;
            $VALUES = new RelativeDateTimeUnit[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        }
    }

    public static final enum RelativeUnit extends Enum<RelativeUnit> {
        private static final /* synthetic */ RelativeUnit[] $VALUES = null;
        public static final RelativeUnit DAYS = null;
        public static final RelativeUnit HOURS = null;
        public static final RelativeUnit MINUTES = null;
        public static final RelativeUnit MONTHS = null;
        public static final RelativeUnit SECONDS = null;
        public static final RelativeUnit WEEKS = null;
        public static final RelativeUnit YEARS = null;

        public static RelativeUnit valueOf(String r1) {
            return (RelativeUnit) Enum.valueOf(RelativeUnit.class, r1);
        }

        public static RelativeUnit[] values() {
            return (RelativeUnit[]) $VALUES.clone();
        }

        private RelativeUnit(String r1, int r2) {
            super(r1, r2);
        }

        static {
            RelativeUnit r0 = new RelativeUnit("SECONDS", 0);
            SECONDS = r0;
            RelativeUnit r1 = new RelativeUnit("MINUTES", 1);
            MINUTES = r1;
            RelativeUnit r3 = new RelativeUnit("HOURS", 2);
            HOURS = r3;
            RelativeUnit r5 = new RelativeUnit("DAYS", 3);
            DAYS = r5;
            RelativeUnit r7 = new RelativeUnit("WEEKS", 4);
            WEEKS = r7;
            RelativeUnit r9 = new RelativeUnit("MONTHS", 5);
            MONTHS = r9;
            RelativeUnit r11 = new RelativeUnit("YEARS", 6);
            YEARS = r11;
            $VALUES = new RelativeUnit[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style LONG = null;
        public static final Style NARROW = null;
        public static final Style SHORT = null;

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Style r0 = new Style("LONG", 0);
            LONG = r0;
            Style r1 = new Style("SHORT", 1);
            SHORT = r1;
            Style r3 = new Style("NARROW", 2);
            NARROW = r3;
            $VALUES = new Style[]{r0, r1, r3};
        }
    }

    private RelativeDateTimeFormatter() {
        throw new RuntimeException("Stub!");
    }

    public static RelativeDateTimeFormatter getInstance() {
        throw new RuntimeException("Stub!");
    }

    public static RelativeDateTimeFormatter getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static RelativeDateTimeFormatter getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static RelativeDateTimeFormatter getInstance(ULocale r0, NumberFormat r1) {
        throw new RuntimeException("Stub!");
    }

    public static RelativeDateTimeFormatter getInstance(ULocale r0, NumberFormat r1, Style r2, DisplayContext r3) {
        throw new RuntimeException("Stub!");
    }

    public static RelativeDateTimeFormatter getInstance(Locale r0, NumberFormat r1) {
        throw new RuntimeException("Stub!");
    }

    public String format(double r1, Direction r3, RelativeUnit r4) {
        throw new RuntimeException("Stub!");
    }

    public FormattedRelativeDateTime formatToValue(double r1, Direction r3, RelativeUnit r4) {
        throw new RuntimeException("Stub!");
    }

    public String formatNumeric(double r1, RelativeDateTimeUnit r3) {
        throw new RuntimeException("Stub!");
    }

    public FormattedRelativeDateTime formatNumericToValue(double r1, RelativeDateTimeUnit r3) {
        throw new RuntimeException("Stub!");
    }

    public String format(Direction r1, AbsoluteUnit r2) {
        throw new RuntimeException("Stub!");
    }

    public FormattedRelativeDateTime formatToValue(Direction r1, AbsoluteUnit r2) {
        throw new RuntimeException("Stub!");
    }

    public String format(double r1, RelativeDateTimeUnit r3) {
        throw new RuntimeException("Stub!");
    }

    public FormattedRelativeDateTime formatToValue(double r1, RelativeDateTimeUnit r3) {
        throw new RuntimeException("Stub!");
    }

    public String combineDateAndTime(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public NumberFormat getNumberFormat() {
        throw new RuntimeException("Stub!");
    }

    public DisplayContext getCapitalizationContext() {
        throw new RuntimeException("Stub!");
    }

    public Style getFormatStyle() {
        throw new RuntimeException("Stub!");
    }
}
