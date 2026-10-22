package android.icu.text;

import android.icu.util.Freezable;
import android.icu.util.ULocale;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DateTimePatternGenerator implements Freezable<DateTimePatternGenerator>, Cloneable {
    public static final int DAY = 7;
    public static final int DAYPERIOD = 10;
    public static final int DAY_OF_WEEK_IN_MONTH = 9;
    public static final int DAY_OF_YEAR = 8;
    public static final int ERA = 0;
    public static final int FRACTIONAL_SECOND = 14;
    public static final int HOUR = 11;
    public static final int MATCH_ALL_FIELDS_LENGTH = 65535;
    public static final int MATCH_HOUR_FIELD_LENGTH = 2048;
    public static final int MATCH_NO_OPTIONS = 0;
    public static final int MINUTE = 12;
    public static final int MONTH = 3;
    public static final int QUARTER = 2;
    public static final int SECOND = 13;
    public static final int WEEKDAY = 6;
    public static final int WEEK_OF_MONTH = 5;
    public static final int WEEK_OF_YEAR = 4;
    public static final int YEAR = 1;
    public static final int ZONE = 15;

    public static final enum DisplayWidth extends Enum<DisplayWidth> {
        private static final /* synthetic */ DisplayWidth[] $VALUES = null;
        public static final DisplayWidth ABBREVIATED = null;
        public static final DisplayWidth NARROW = null;
        public static final DisplayWidth WIDE = null;

        public static DisplayWidth valueOf(String r1) {
            return (DisplayWidth) Enum.valueOf(DisplayWidth.class, r1);
        }

        public static DisplayWidth[] values() {
            return (DisplayWidth[]) $VALUES.clone();
        }

        private DisplayWidth(String r1, int r2) {
            super(r1, r2);
        }

        static {
            DisplayWidth r0 = new DisplayWidth("WIDE", 0);
            WIDE = r0;
            DisplayWidth r1 = new DisplayWidth("ABBREVIATED", 1);
            ABBREVIATED = r1;
            DisplayWidth r3 = new DisplayWidth("NARROW", 2);
            NARROW = r3;
            $VALUES = new DisplayWidth[]{r0, r1, r3};
        }
    }

    public static final class PatternInfo {
        public static final int BASE_CONFLICT = 1;
        public static final int CONFLICT = 2;
        public static final int OK = 0;
        public String conflictingPattern;
        public int status;

        public PatternInfo() {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ DateTimePatternGenerator cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ DateTimePatternGenerator freeze() {
        return freeze();
    }

    protected DateTimePatternGenerator() {
        throw new RuntimeException("Stub!");
    }

    public static DateTimePatternGenerator getEmptyInstance() {
        throw new RuntimeException("Stub!");
    }

    public static DateTimePatternGenerator getInstance() {
        throw new RuntimeException("Stub!");
    }

    public static DateTimePatternGenerator getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static DateTimePatternGenerator getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getBestPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getBestPattern(String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public String getBestPattern(String r1, int r2, boolean r3) {
        throw new RuntimeException("Stub!");
    }

    public DateTimePatternGenerator addPattern(String r1, boolean r2, PatternInfo r3) {
        throw new RuntimeException("Stub!");
    }

    public String getSkeleton(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getBaseSkeleton(String r1) {
        throw new RuntimeException("Stub!");
    }

    public Map<String, String> getSkeletons(Map<String, String> r1) {
        throw new RuntimeException("Stub!");
    }

    public Set<String> getBaseSkeletons(Set<String> r1) {
        throw new RuntimeException("Stub!");
    }

    public String replaceFieldTypes(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public String replaceFieldTypes(String r1, String r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public void setDateTimeFormat(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDateTimeFormat() {
        throw new RuntimeException("Stub!");
    }

    public void setDecimal(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDecimal() {
        throw new RuntimeException("Stub!");
    }

    public void setAppendItemFormat(int r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public String getAppendItemFormat(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setAppendItemName(int r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public String getAppendItemName(int r1) {
        throw new RuntimeException("Stub!");
    }

    public DateFormat.HourCycle getDefaultHourCycle() {
        throw new RuntimeException("Stub!");
    }

    public String getFieldDisplayName(int r1, DisplayWidth r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public DateTimePatternGenerator freeze() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public DateTimePatternGenerator cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }
}
