package android.icu.util;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeZone implements Serializable, Cloneable, Freezable<TimeZone> {
    public static final int GENERIC_LOCATION = 7;
    public static final TimeZone GMT_ZONE = null;
    public static final int LONG = 1;
    public static final int LONG_GENERIC = 3;
    public static final int LONG_GMT = 5;
    public static final int SHORT = 0;
    public static final int SHORT_COMMONLY_USED = 6;
    public static final int SHORT_GENERIC = 2;
    public static final int SHORT_GMT = 4;
    public static final int TIMEZONE_ICU = 0;
    public static final int TIMEZONE_JDK = 1;
    public static final TimeZone UNKNOWN_ZONE = null;
    public static final String UNKNOWN_ZONE_ID = "Etc/Unknown";

    public static final enum SystemTimeZoneType extends Enum<SystemTimeZoneType> {
        private static final /* synthetic */ SystemTimeZoneType[] $VALUES = null;
        public static final SystemTimeZoneType ANY = null;
        public static final SystemTimeZoneType CANONICAL = null;
        public static final SystemTimeZoneType CANONICAL_LOCATION = null;

        public static SystemTimeZoneType valueOf(String r1) {
            return (SystemTimeZoneType) Enum.valueOf(SystemTimeZoneType.class, r1);
        }

        public static SystemTimeZoneType[] values() {
            return (SystemTimeZoneType[]) $VALUES.clone();
        }

        private SystemTimeZoneType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            SystemTimeZoneType r0 = new SystemTimeZoneType("ANY", 0);
            ANY = r0;
            SystemTimeZoneType r1 = new SystemTimeZoneType("CANONICAL", 1);
            CANONICAL = r1;
            SystemTimeZoneType r3 = new SystemTimeZoneType("CANONICAL_LOCATION", 2);
            CANONICAL_LOCATION = r3;
            $VALUES = new SystemTimeZoneType[]{r0, r1, r3};
        }
    }

    static {
    }

    public abstract int getOffset(int r1, int r2, int r3, int r4, int r5, int r6);

    public abstract int getRawOffset();

    public abstract boolean inDaylightTime(Date r1);

    public abstract void setRawOffset(int r1);

    public abstract boolean useDaylightTime();

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ TimeZone cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ TimeZone freeze() {
        return freeze();
    }

    public TimeZone() {
        throw new RuntimeException("Stub!");
    }

    public int getOffset(long r1) {
        throw new RuntimeException("Stub!");
    }

    public void getOffset(long r1, boolean r3, int[] r4) {
        throw new RuntimeException("Stub!");
    }

    public String getID() {
        throw new RuntimeException("Stub!");
    }

    public void setID(String r1) {
        throw new RuntimeException("Stub!");
    }

    public final String getDisplayName() {
        throw new RuntimeException("Stub!");
    }

    public final String getDisplayName(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public final String getDisplayName(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public final String getDisplayName(boolean r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayName(boolean r1, int r2, Locale r3) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayName(boolean r1, int r2, ULocale r3) {
        throw new RuntimeException("Stub!");
    }

    public int getDSTSavings() {
        throw new RuntimeException("Stub!");
    }

    public boolean observesDaylightTime() {
        throw new RuntimeException("Stub!");
    }

    public static TimeZone getTimeZone(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZone getFrozenTimeZone(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZone getTimeZone(String r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    public static Set<String> getAvailableIDs(SystemTimeZoneType r0, String r1, Integer r2) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getAvailableIDs(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getAvailableIDs(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getAvailableIDs() {
        throw new RuntimeException("Stub!");
    }

    public static int countEquivalentIDs(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getEquivalentID(String r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZone getDefault() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasSameRules(TimeZone r1) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public static String getTZDataVersion() {
        throw new RuntimeException("Stub!");
    }

    public static String getCanonicalID(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getCanonicalID(String r0, boolean[] r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getRegion(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getWindowsID(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getIDForWindowsID(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public TimeZone freeze() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public TimeZone cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }
}
