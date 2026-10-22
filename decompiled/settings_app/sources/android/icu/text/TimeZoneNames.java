package android.icu.text;

import android.icu.util.ULocale;
import java.io.Serializable;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeZoneNames implements Serializable {

    public static final enum NameType extends Enum<NameType> {
        private static final /* synthetic */ NameType[] $VALUES = null;
        public static final NameType EXEMPLAR_LOCATION = null;
        public static final NameType LONG_DAYLIGHT = null;
        public static final NameType LONG_GENERIC = null;
        public static final NameType LONG_STANDARD = null;
        public static final NameType SHORT_DAYLIGHT = null;
        public static final NameType SHORT_GENERIC = null;
        public static final NameType SHORT_STANDARD = null;

        public static NameType valueOf(String r1) {
            return (NameType) Enum.valueOf(NameType.class, r1);
        }

        public static NameType[] values() {
            return (NameType[]) $VALUES.clone();
        }

        private NameType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NameType r0 = new NameType("LONG_GENERIC", 0);
            LONG_GENERIC = r0;
            NameType r1 = new NameType("LONG_STANDARD", 1);
            LONG_STANDARD = r1;
            NameType r3 = new NameType("LONG_DAYLIGHT", 2);
            LONG_DAYLIGHT = r3;
            NameType r5 = new NameType("SHORT_GENERIC", 3);
            SHORT_GENERIC = r5;
            NameType r7 = new NameType("SHORT_STANDARD", 4);
            SHORT_STANDARD = r7;
            NameType r9 = new NameType("SHORT_DAYLIGHT", 5);
            SHORT_DAYLIGHT = r9;
            NameType r11 = new NameType("EXEMPLAR_LOCATION", 6);
            EXEMPLAR_LOCATION = r11;
            $VALUES = new NameType[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public abstract Set<String> getAvailableMetaZoneIDs();

    public abstract Set<String> getAvailableMetaZoneIDs(String r1);

    public abstract String getMetaZoneDisplayName(String r1, NameType r2);

    public abstract String getMetaZoneID(String r1, long r2);

    public abstract String getReferenceZoneID(String r1, String r2);

    public abstract String getTimeZoneDisplayName(String r1, NameType r2);

    TimeZoneNames() {
        throw new RuntimeException("Stub!");
    }

    public static TimeZoneNames getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZoneNames getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZoneNames getTZDBInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public final String getDisplayName(String r1, NameType r2, long r3) {
        throw new RuntimeException("Stub!");
    }

    public String getExemplarLocationName(String r1) {
        throw new RuntimeException("Stub!");
    }
}
