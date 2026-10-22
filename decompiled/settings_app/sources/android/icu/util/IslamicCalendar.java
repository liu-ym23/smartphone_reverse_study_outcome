package android.icu.util;

import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class IslamicCalendar extends Calendar {
    public static final int DHU_AL_HIJJAH = 11;
    public static final int DHU_AL_QIDAH = 10;
    public static final int JUMADA_1 = 4;
    public static final int JUMADA_2 = 5;
    public static final int MUHARRAM = 0;
    public static final int RABI_1 = 2;
    public static final int RABI_2 = 3;
    public static final int RAJAB = 6;
    public static final int RAMADAN = 8;
    public static final int SAFAR = 1;
    public static final int SHABAN = 7;
    public static final int SHAWWAL = 9;

    public static final enum CalculationType extends Enum<CalculationType> {
        private static final /* synthetic */ CalculationType[] $VALUES = null;
        public static final CalculationType ISLAMIC = null;
        public static final CalculationType ISLAMIC_CIVIL = null;
        public static final CalculationType ISLAMIC_TBLA = null;
        public static final CalculationType ISLAMIC_UMALQURA = null;

        public static CalculationType valueOf(String r1) {
            return (CalculationType) Enum.valueOf(CalculationType.class, r1);
        }

        public static CalculationType[] values() {
            return (CalculationType[]) $VALUES.clone();
        }

        private CalculationType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CalculationType r0 = new CalculationType("ISLAMIC", 0);
            ISLAMIC = r0;
            CalculationType r1 = new CalculationType("ISLAMIC_CIVIL", 1);
            ISLAMIC_CIVIL = r1;
            CalculationType r3 = new CalculationType("ISLAMIC_UMALQURA", 2);
            ISLAMIC_UMALQURA = r3;
            CalculationType r5 = new CalculationType("ISLAMIC_TBLA", 3);
            ISLAMIC_TBLA = r5;
            $VALUES = new CalculationType[]{r0, r1, r3, r5};
        }
    }

    public IslamicCalendar() {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(TimeZone r1) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(TimeZone r1, Locale r2) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(TimeZone r1, ULocale r2) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(Date r1) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(int r1, int r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public IslamicCalendar(int r1, int r2, int r3, int r4, int r5, int r6) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetLimit(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetMonthLength(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetYearLength(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleComputeMonthStart(int r1, int r2, boolean r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected int handleGetExtendedYear() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    protected void handleComputeFields(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setCalculationType(CalculationType r1) {
        throw new RuntimeException("Stub!");
    }

    public CalculationType getCalculationType() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Calendar
    public String getType() {
        throw new RuntimeException("Stub!");
    }
}
