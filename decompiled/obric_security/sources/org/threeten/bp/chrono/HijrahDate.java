package org.threeten.bp.chrono;

import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    private static final Long[] ADJUSTED_CYCLES = null;
    private static final HashMap<Integer, Integer[]> ADJUSTED_CYCLE_YEARS = null;
    private static final Integer[] ADJUSTED_LEAST_MAX_VALUES = null;
    private static final Integer[] ADJUSTED_MAX_VALUES = null;
    private static final Integer[] ADJUSTED_MIN_VALUES = null;
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_DAYS = null;
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_LENGTHS = null;
    private static final int[] CYCLEYEAR_START_DATE = null;
    private static final String DEFAULT_CONFIG_FILENAME = "hijrah_deviation.cfg";
    private static final String DEFAULT_CONFIG_PATH = null;
    private static final Integer[] DEFAULT_CYCLE_YEARS = null;
    private static final Integer[] DEFAULT_LEAP_MONTH_DAYS = null;
    private static final Integer[] DEFAULT_LEAP_MONTH_LENGTHS = null;
    private static final Integer[] DEFAULT_MONTH_DAYS = null;
    private static final Integer[] DEFAULT_MONTH_LENGTHS = null;
    private static final char FILE_SEP = 0;
    private static final int HIJRAH_JAN_1_1_GREGORIAN_DAY = -492148;
    private static final int[] LEAP_MONTH_LENGTH = null;
    private static final int[] LEAP_NUM_DAYS = null;
    private static final int[] LEAST_MAX_VALUES = null;
    private static final int MAX_ADJUSTED_CYCLE = 334;
    private static final int[] MAX_VALUES = null;
    public static final int MAX_VALUE_OF_ERA = 9999;
    private static final int[] MIN_VALUES = null;
    public static final int MIN_VALUE_OF_ERA = 1;
    private static final int[] MONTH_LENGTH = null;
    private static final int[] NUM_DAYS = null;
    private static final String PATH_SEP = null;
    private static final int POSITION_DAY_OF_MONTH = 5;
    private static final int POSITION_DAY_OF_YEAR = 6;
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient int dayOfMonth;
    private final transient DayOfWeek dayOfWeek;
    private final transient int dayOfYear;
    private final transient HijrahEra era;
    private final long gregorianEpochDay;
    private final transient boolean isLeapYear;
    private final transient int monthOfYear;
    private final transient int yearOfEra;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.HijrahDate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ Chronology getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ Era getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r1) {
        return plusDays(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r1) {
        return plusMonths(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r1) {
        return plusYears(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal r1, TemporalUnit r2) {
        return super.until(r1, r2);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ ChronoPeriod until(ChronoLocalDate r1) {
        return super.until(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    static {
        int[] r1 = {0, 30, 59, 89, 118, 148, 177, HttpStatus.SC_MULTI_STATUS, 236, 266, 295, 325};
        NUM_DAYS = r1;
        LEAP_NUM_DAYS = new int[]{0, 30, 59, 89, 118, 148, 177, HttpStatus.SC_MULTI_STATUS, 236, 266, 295, 325};
        MONTH_LENGTH = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
        LEAP_MONTH_LENGTH = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
        MIN_VALUES = new int[]{0, 1, 0, 1, 0, 1, 1};
        LEAST_MAX_VALUES = new int[]{1, 9999, 11, 51, 5, 29, 354};
        MAX_VALUES = new int[]{1, 9999, 11, 52, 6, 30, 355};
        CYCLEYEAR_START_DATE = new int[]{0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
        char r0 = File.separatorChar;
        FILE_SEP = r0;
        PATH_SEP = File.pathSeparator;
        DEFAULT_CONFIG_PATH = "org" + r0 + "threeten" + r0 + "bp" + r0 + "chrono";
        ADJUSTED_MONTH_DAYS = new HashMap();
        ADJUSTED_MONTH_LENGTHS = new HashMap();
        ADJUSTED_CYCLE_YEARS = new HashMap();
        DEFAULT_MONTH_DAYS = new Integer[r1.length];
        int r2 = 0;
        int r3 = 0;
    L3:
        int[] r4 = NUM_DAYS;
        if (r3 >= r4.length) goto L6;
        DEFAULT_MONTH_DAYS[r3] = new Integer(r4[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        DEFAULT_LEAP_MONTH_DAYS = new Integer[LEAP_NUM_DAYS.length];
        int r5 = 0;
    L7:
        int[] r6 = LEAP_NUM_DAYS;
        if (r5 >= r6.length) goto L10;
        DEFAULT_LEAP_MONTH_DAYS[r5] = new Integer(r6[r5]);
        r5 = r5 + 1;
        goto L7
    L10:
        DEFAULT_MONTH_LENGTHS = new Integer[MONTH_LENGTH.length];
        int r7 = 0;
    L11:
        int[] r8 = MONTH_LENGTH;
        if (r7 >= r8.length) goto L14;
        DEFAULT_MONTH_LENGTHS[r7] = new Integer(r8[r7]);
        r7 = r7 + 1;
        goto L11
    L14:
        DEFAULT_LEAP_MONTH_LENGTHS = new Integer[LEAP_MONTH_LENGTH.length];
        int r9 = 0;
    L15:
        int[] r10 = LEAP_MONTH_LENGTH;
        if (r9 >= r10.length) goto L18;
        DEFAULT_LEAP_MONTH_LENGTHS[r9] = new Integer(r10[r9]);
        r9 = r9 + 1;
        goto L15
    L18:
        DEFAULT_CYCLE_YEARS = new Integer[CYCLEYEAR_START_DATE.length];
        int r11 = 0;
    L19:
        int[] r12 = CYCLEYEAR_START_DATE;
        if (r11 >= r12.length) goto L22;
        DEFAULT_CYCLE_YEARS[r11] = new Integer(r12[r11]);
        r11 = r11 + 1;
        goto L19
    L22:
        ADJUSTED_CYCLES = new Long[MAX_ADJUSTED_CYCLE];
        int r13 = 0;
    L23:
        Long[] r14 = ADJUSTED_CYCLES;
        if (r13 >= r14.length) goto L26;
        r14[r13] = new Long(r13 * 10631);
        r13 = r13 + 1;
        goto L23
    L26:
        ADJUSTED_MIN_VALUES = new Integer[MIN_VALUES.length];
        int r15 = 0;
    L27:
        int[] r16 = MIN_VALUES;
        if (r15 >= r16.length) goto L30;
        ADJUSTED_MIN_VALUES[r15] = new Integer(r16[r15]);
        r15 = r15 + 1;
        goto L27
    L30:
        ADJUSTED_LEAST_MAX_VALUES = new Integer[LEAST_MAX_VALUES.length];
        int r17 = 0;
    L31:
        int[] r18 = LEAST_MAX_VALUES;
        if (r17 >= r18.length) goto L34;
        ADJUSTED_LEAST_MAX_VALUES[r17] = new Integer(r18[r17]);
        r17 = r17 + 1;
        goto L31
    L34:
        ADJUSTED_MAX_VALUES = new Integer[MAX_VALUES.length];
    L35:
        int[] r19 = MAX_VALUES;
        if (r2 >= r19.length) goto L41;
        ADJUSTED_MAX_VALUES[r2] = new Integer(r19[r2]);
        r2 = r2 + 1;
        goto L35
    L41:
        readDeviationConfig();     // Catch: Throwable -> L40
        return;
    }

    public static HijrahDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static HijrahDate now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static HijrahDate now(Clock r1) {
        return HijrahChronology.INSTANCE.dateNow(r1);
    }

    public static HijrahDate of(int r2, int r3, int r4) {
        if (r2 < 1) goto L6;
        return of(HijrahEra.AH, r2, r3, r4);
    L6:
        return of(HijrahEra.BEFORE_AH, 1 - r2, r3, r4);
    }

    static HijrahDate of(HijrahEra r1, int r2, int r3, int r4) {
        Jdk8Methods.requireNonNull(r1, "era");
        checkValidYearOfEra(r2);
        checkValidMonth(r3);
        checkValidDayOfMonth(r4);
        return new HijrahDate(getGregorianEpochDay(r1.prolepticYear(r2), r3, r4));
    }

    private static void checkValidYearOfEra(int r1) {
        if (r1 < 1) goto L8;
        if (r1 > 9999) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid year of Hijrah Era");
    }

    private static void checkValidDayOfYear(int r1) {
        if (r1 < 1) goto L8;
        if (r1 > getMaximumDayOfYear()) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid day of year of Hijrah date");
    }

    private static void checkValidMonth(int r1) {
        if (r1 < 1) goto L8;
        if (r1 > 12) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid month of Hijrah date");
    }

    private static void checkValidDayOfMonth(int r3) {
        if (r3 < 1) goto L8;
        if (r3 > getMaximumDayOfMonth()) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid day of month of Hijrah date, day " + r3 + " greater than " + getMaximumDayOfMonth() + " or less than 1");
    }

    static HijrahDate of(LocalDate r2) {
        return new HijrahDate(r2.toEpochDay());
    }

    static HijrahDate ofEpochDay(long r1) {
        return new HijrahDate(r1);
    }

    public static HijrahDate from(TemporalAccessor r1) {
        return HijrahChronology.INSTANCE.date(r1);
    }

    private HijrahDate(long r7) {
        int[] r0 = getHijrahDateInfo(r7);
        checkValidYearOfEra(r0[1]);
        checkValidMonth(r0[2]);
        checkValidDayOfMonth(r0[3]);
        checkValidDayOfYear(r0[4]);
        this.era = HijrahEra.of(r0[0]);
        int r1 = r0[1];
        this.yearOfEra = r1;
        this.monthOfYear = r0[2];
        this.dayOfMonth = r0[3];
        this.dayOfYear = r0[4];
        this.dayOfWeek = DayOfWeek.of(r0[5]);
        this.gregorianEpochDay = r7;
        this.isLeapYear = isLeapYear(r1);
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public HijrahChronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public HijrahEra getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r5) {
        if ((r5 instanceof ChronoField) == false) goto L27;
        if (isSupported(r5) == false) goto L25;
        ChronoField r6 = (ChronoField) r5;
        int r0 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r6.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        return getChronology().range(r6);
    L17:
        return ValueRange.of(1, 1000);
    L19:
        return ValueRange.of(1, 5);
    L21:
        return ValueRange.of(1, lengthOfYear());
    L23:
        return ValueRange.of(1, lengthOfMonth());
    L25:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L27:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L25;
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        int r2 = this.era.getValue();
    L10:
        return r2;
    L11:
        r2 = this.yearOfEra;
        goto L10
    L12:
        r2 = this.monthOfYear;
        goto L10
    L13:
        int r4 = (this.dayOfYear - 1) / 7;
    L14:
        r2 = r4 + 1;
        goto L10
    L17:
        r4 = (this.dayOfYear - 1) % 7;
        goto L14
    L18:
        r4 = (this.dayOfMonth - 1) % 7;
        goto L14
    L19:
        r2 = this.dayOfWeek.getValue();
        goto L10
    L20:
        r2 = this.yearOfEra;
        goto L10
    L21:
        r4 = (this.dayOfMonth - 1) / 7;
        goto L14
    L22:
        r2 = this.dayOfYear;
        goto L10
    L23:
        r2 = this.dayOfMonth;
        goto L10
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    L16:
        return toEpochDay();
    L25:
        return r3.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public HijrahDate with(TemporalAdjuster r1) {
        return (HijrahDate) super.with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public HijrahDate with(TemporalField r6, long r7) {
        if ((r6 instanceof ChronoField) == false) goto L37;
        ChronoField r0 = (ChronoField) r6;
        r0.checkValidValue(r7);
        int r1 = (int) r7;
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()]) {
            case 1: goto L35;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            default: goto L7;
        };
    L32:
        int r2 = r1 - 1;
        return resolvePreviousValid(this.yearOfEra, (r2 / 30) + 1, (r2 % 30) + 1);
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r6);
    L9:
        return resolvePreviousValid(1 - this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    L11:
        return resolvePreviousValid(r1, this.monthOfYear, this.dayOfMonth);
    L13:
        return resolvePreviousValid(this.yearOfEra, r1, this.dayOfMonth);
    L15:
        return plusDays((r7 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
    L17:
        return new HijrahDate(r1);
    L19:
        return plusDays(r7 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L21:
        return plusDays(r7 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L23:
        return plusDays(r7 - ((long) this.dayOfWeek.getValue()));
    L25:
        if (this.yearOfEra >= 1) goto L29;
        r1 = 1 - r1;
    L29:
        return resolvePreviousValid(r1, this.monthOfYear, this.dayOfMonth);
    L31:
        return plusDays((r7 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
    L35:
        return resolvePreviousValid(this.yearOfEra, this.monthOfYear, r1);
    L37:
        return (HijrahDate) r6.adjustInto(this, r7);
    }

    private static HijrahDate resolvePreviousValid(int r1, int r2, int r3) {
        int r0 = getMonthDays(r2 - 1, r1);
        if (r3 <= r0) goto L6;
        r3 = r0;
    L6:
        return of(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public HijrahDate plus(TemporalAmount r1) {
        return (HijrahDate) super.plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public HijrahDate plus(long r1, TemporalUnit r3) {
        return (HijrahDate) super.plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public HijrahDate minus(TemporalAmount r1) {
        return (HijrahDate) super.minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public HijrahDate minus(long r1, TemporalUnit r3) {
        return (HijrahDate) super.minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<HijrahDate> atTime(LocalTime r1) {
        return super.atTime(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return getGregorianEpochDay(this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    HijrahDate plusYears(long r3) {
        if (r3 != 0) goto L5;
        return this;
    L5:
        int r4 = Jdk8Methods.safeAdd(this.yearOfEra, (int) r3);
        return of(this.era, r4, this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    HijrahDate plusMonths(long r3) {
        if (r3 != 0) goto L5;
        return this;
    L5:
        int r0 = (this.monthOfYear - 1) + ((int) r3);
        int r4 = r0 / 12;
        int r1 = r0 % 12;
    L6:
        if (r1 >= 0) goto L8;
        r1 = r1 + 12;
        r4 = Jdk8Methods.safeSubtract(r4, 1);
        goto L6
    L8:
        int r5 = Jdk8Methods.safeAdd(this.yearOfEra, r4);
        return of(this.era, r5, r1 + 1, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    HijrahDate plusDays(long r4) {
        return new HijrahDate(this.gregorianEpochDay + r4);
    }

    private static int[] getHijrahDateInfo(long r9) {
        long r10 = r9 - (-492148);
        if (r10 < 0) goto L5;
        int r0 = getCycleNumber(r10);
        int r2 = getDayOfCycle(r10, r0);
        int r3 = getYearInCycle(r0, r2);
        int r4 = getDayOfYear(r0, r2, r3);
        int r1 = ((r0 * 30) + r3) + 1;
        int r5 = getMonthOfYear(r4, r1);
        int r6 = getDayOfMonth(r4, r5, r1) + 1;
        int r7 = HijrahEra.AH.getValue();
    L13:
        int r11 = (int) ((r10 + 5) % 7);
        if (r11 > 0) goto L16;
        int r8 = 7;
    L18:
        return new int[]{r7, r1, r5 + 1, r6, r4 + 1, r11 + r8};
    L16:
        r8 = 0;
        goto L18
    L5:
        int r12 = (int) r10;
        int r13 = r12 / 10631;
        int r14 = r12 % 10631;
        if (r14 != 0) goto L8;
        r13 = r13 + 1;
        r14 = -10631;
    L8:
        int r15 = getYearInCycle(r13, r14);
        int r16 = getDayOfYear(r13, r14, r15);
        int r17 = 1 - ((r13 * 30) - r15);
        if (isLeapYear(r17) == false) goto L11;
        int r18 = r16 + 355;
    L12:
        r5 = getMonthOfYear(r18, r17);
        r6 = getDayOfMonth(r18, r5, r17) + 1;
        r7 = HijrahEra.BEFORE_AH.getValue();
        r4 = r18;
        r1 = r17;
        goto L13
    L11:
        r18 = r16 + 354;
        goto L12
    }

    private static long getGregorianEpochDay(int r2, int r3, int r4) {
        return (yearToGregorianEpochDay(r2) + ((long) getMonthDays(r3 - 1, r2))) + ((long) r4);
    }

    private static long yearToGregorianEpochDay(int r4) {
        int r5 = r4 - 1;
        int r0 = r5 / 30;
        int r6 = r5 % 30;
        int r1 = getAdjustedCycle(r0)[Math.abs(r6)].intValue();
        if (r6 >= 0) goto L12;
        r1 = -r1;
    L12:
        Long r7 = ADJUSTED_CYCLES[r0];     // Catch: ArrayIndexOutOfBoundsException -> L7
    L8:
        if (r7 != null) goto L11;
        r7 = new Long(r0 * 10631);
    L11:
        return ((r7.longValue() + ((long) r1)) - 492148) - 1;
    L7:
        r7 = null;
        goto L8
    }

    private static int getCycleNumber(long r4) {
        Long[] r0 = ADJUSTED_CYCLES;
        int r1 = 0;
    L14:
        if (r1 >= r0.length) goto L17;
        if (r4 < r0[r1].longValue()) goto L8;
        r1 = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L12
        goto L14
    L8:
        return r1 - 1;
    L17:
        return ((int) r4) / 10631;
    L13:
        return ((int) r4) / 10631;
    }

    private static int getDayOfCycle(long r3, int r5) {
        Long r0 = ADJUSTED_CYCLES[r5];     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r0 != null) goto L8;
        r0 = new Long(r5 * 10631);
    L8:
        return (int) (r3 - r0.longValue());
    L4:
        r0 = null;
        goto L5
    }

    private static int getYearInCycle(int r5, long r6) {
        Integer[] r7 = getAdjustedCycle(r5);
        int r1 = 0;
        if (r6 != 0) goto L6;
        return 0;
    L6:
        if (r6 > 0) goto L8;
        long r8 = -r6;
    L17:
        if (r1 >= r7.length) goto L23;
        if (r8 <= r7[r1].intValue()) goto L21;
        r1 = r1 + 1;
        goto L17
    L21:
        return r1 - 1;
    L23:
        return 29;
    L8:
        if (r1 >= r7.length) goto L14;
        if (r6 < r7[r1].intValue()) goto L12;
        r1 = r1 + 1;
        goto L8
    L12:
        return r1 - 1;
    L14:
        return 29;
    }

    private static Integer[] getAdjustedCycle(int r2) {
        Integer[] r3 = ADJUSTED_CYCLE_YEARS.get(new Integer(r2));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r3 == null) goto L7;
        return r3;
    L7:
        return DEFAULT_CYCLE_YEARS;
    L4:
        r3 = null;
        goto L5
    }

    private static Integer[] getAdjustedMonthDays(int r2) {
        Integer[] r0 = ADJUSTED_MONTH_DAYS.get(new Integer(r2));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        if (isLeapYear(r2) == false) goto L10;
        return DEFAULT_LEAP_MONTH_DAYS;
    L10:
        return DEFAULT_MONTH_DAYS;
    L4:
        r0 = null;
        goto L5
    }

    private static Integer[] getAdjustedMonthLength(int r2) {
        Integer[] r0 = ADJUSTED_MONTH_LENGTHS.get(new Integer(r2));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        if (isLeapYear(r2) == false) goto L10;
        return DEFAULT_LEAP_MONTH_LENGTHS;
    L10:
        return DEFAULT_MONTH_LENGTHS;
    L4:
        r0 = null;
        goto L5
    }

    private static int getDayOfYear(int r0, int r1, int r2) {
        Integer[] r3 = getAdjustedCycle(r0);
        if (r1 <= 0) goto L7;
        return r1 - r3[r2].intValue();
    L7:
        return r3[r2].intValue() + r1;
    }

    private static int getMonthOfYear(int r5, int r6) {
        Integer[] r0 = getAdjustedMonthDays(r6);
        int r2 = 0;
        if (r5 < 0) goto L13;
    L5:
        if (r2 >= r0.length) goto L11;
        if (r5 < r0[r2].intValue()) goto L9;
        r2 = r2 + 1;
        goto L5
    L9:
        return r2 - 1;
    L11:
        return 11;
    L13:
        if (isLeapYear(r6) == false) goto L15;
        int r7 = r5 + 355;
    L17:
        if (r2 >= r0.length) goto L23;
        if (r7 < r0[r2].intValue()) goto L21;
        r2 = r2 + 1;
        goto L17
    L21:
        return r2 - 1;
    L23:
        return 11;
    L15:
        r7 = r5 + 354;
        goto L17
    }

    private static int getDayOfMonth(int r3, int r4, int r5) {
        Integer[] r0 = getAdjustedMonthDays(r5);
        if (r3 < 0) goto L9;
        if (r4 <= 0) goto L15;
        int r6 = r0[r4].intValue();
    L7:
        return r3 - r6;
    L15:
        return r3;
    L9:
        if (isLeapYear(r5) == false) goto L11;
        r3 = r3 + 355;
    L12:
        if (r4 <= 0) goto L14;
        r6 = r0[r4].intValue();
        goto L7
    L14:
        return r3;
    L11:
        r3 = r3 + 354;
        goto L12
    }

    static boolean isLeapYear(long r4) {
        if (r4 > 0) goto L7;
        r4 = -r4;
    L7:
        if ((((r4 * 11) + 14) % 30) >= 11) goto L9;
        return true;
    L9:
        return false;
    }

    private static int getMonthDays(int r0, int r1) {
        return getAdjustedMonthDays(r1)[r0].intValue();
    }

    static int getMonthLength(int r0, int r1) {
        return getAdjustedMonthLength(r1)[r0].intValue();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return getMonthLength(this.monthOfYear - 1, this.yearOfEra);
    }

    static int getYearLength(int r4) {
        int r0 = r4 - 1;
        int r1 = r0 / 30;
        Integer[] r2 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(r1));     // Catch: ArrayIndexOutOfBoundsException -> L5
    L6:
        if (r2 == null) goto L14;
        int r3 = r0 % 30;
        if (r3 != 29) goto L12;
        Long[] r5 = ADJUSTED_CYCLES;
        return (r5[r1 + 1].intValue() - r5[r1].intValue()) - r2[r3].intValue();
    L12:
        return r2[r3 + 1].intValue() - r2[r3].intValue();
    L14:
        if (isLeapYear(r4) == false) goto L16;
        return 355;
    L16:
        return 354;
    L5:
        r2 = null;
        goto L6
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return getYearLength(this.yearOfEra);
    }

    static int getMaximumDayOfMonth() {
        return ADJUSTED_MAX_VALUES[5].intValue();
    }

    static int getSmallestMaximumDayOfMonth() {
        return ADJUSTED_LEAST_MAX_VALUES[5].intValue();
    }

    static int getMaximumDayOfYear() {
        return ADJUSTED_MAX_VALUES[6].intValue();
    }

    static int getSmallestMaximumDayOfYear() {
        return ADJUSTED_LEAST_MAX_VALUES[6].intValue();
    }

    private static void addDeviationAsHijrah(int r16, int r17, int r18, int r19, int r20) {
        if (r16 < 1) goto L157;
        if (r18 < 1) goto L155;
        if (r17 < 0) goto L153;
        if (r17 > 11) goto L153;
        if (r19 < 0) goto L151;
        if (r19 > 11) goto L151;
        if (r18 > 9999) goto L149;
        if (r18 < r16) goto L147;
        if (r18 != r16) goto L18;
        if (r19 >= r17) goto L18;
        throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
    L18:
        boolean r7 = isLeapYear(r16);
        Integer[] r8 = ADJUSTED_MONTH_DAYS.get(new Integer(r16));
        if (r8 != null) goto L29;
        if (r7 == false) goto L25;
        r8 = new Integer[LEAP_NUM_DAYS.length];
        int r10 = 0;
    L22:
        int[] r11 = LEAP_NUM_DAYS;
        if (r10 >= r11.length) goto L29;
        r8[r10] = new Integer(r11[r10]);
        r10 = r10 + 1;
        goto L22
    L25:
        r8 = new Integer[NUM_DAYS.length];
        int r12 = 0;
    L26:
        int[] r13 = NUM_DAYS;
        if (r12 >= r13.length) goto L29;
        r8[r12] = new Integer(r13[r12]);
        r12 = r12 + 1;
    L29:
        Integer[] r14 = new Integer[r8.length];
        int r15 = 0;
    L31:
        if (r15 >= 12) goto L36;
        if (r15 <= r17) goto L34;
        r14[r15] = new Integer(r8[r15].intValue() - r20);
    L35:
        r15 = r15 + 1;
        goto L31
    L34:
        r14[r15] = new Integer(r8[r15].intValue());
        goto L35
    L36:
        ADJUSTED_MONTH_DAYS.put(new Integer(r16), r14);
        Integer[] r9 = ADJUSTED_MONTH_LENGTHS.get(new Integer(r16));
        if (r9 != null) goto L47;
        if (r7 == false) goto L43;
        r9 = new Integer[LEAP_MONTH_LENGTH.length];
        int r21 = 0;
    L40:
        int[] r110 = LEAP_MONTH_LENGTH;
        if (r21 >= r110.length) goto L47;
        r9[r21] = new Integer(r110[r21]);
        r21 = r21 + 1;
        goto L40
    L43:
        r9 = new Integer[MONTH_LENGTH.length];
        int r22 = 0;
    L44:
        int[] r111 = MONTH_LENGTH;
        if (r22 >= r111.length) goto L47;
        r9[r22] = new Integer(r111[r22]);
        r22 = r22 + 1;
    L47:
        Integer[] r23 = new Integer[r9.length];
        int r112 = 0;
    L48:
        if (r112 >= 12) goto L53;
        if (r112 != r17) goto L51;
        r23[r112] = new Integer(r9[r112].intValue() - r20);
    L52:
        r112 = r112 + 1;
        goto L48
    L51:
        r23[r112] = new Integer(r9[r112].intValue());
        goto L52
    L53:
        ADJUSTED_MONTH_LENGTHS.put(new Integer(r16), r23);
        if (r16 == r18) goto L86;
        int r24 = r16 - 1;
        int r25 = r24 / 30;
        int r26 = r24 % 30;
        Integer[] r113 = ADJUSTED_CYCLE_YEARS.get(new Integer(r25));
        if (r113 != null) goto L61;
        int r114 = CYCLEYEAR_START_DATE.length;
        Integer[] r115 = new Integer[r114];
        int r116 = 0;
    L58:
        if (r116 >= r114) goto L60;
        r115[r116] = new Integer(CYCLEYEAR_START_DATE[r116]);
        r116 = r116 + 1;
        goto L58
    L60:
        r113 = r115;
    L61:
        int r27 = r26 + 1;
    L63:
        if (r27 >= CYCLEYEAR_START_DATE.length) goto L65;
        r113[r27] = new Integer(r113[r27].intValue() - r20);
        r27 = r27 + 1;
        goto L63
    L65:
        ADJUSTED_CYCLE_YEARS.put(new Integer(r25), r113);
        int r28 = r18 - 1;
        int r117 = r28 / 30;
        if (r25 == r117) goto L75;
        int r29 = r25 + 1;
    L68:
        Long[] r118 = ADJUSTED_CYCLES;
        if (r29 >= r118.length) goto L71;
        r118[r29] = new Long(r118[r29].longValue() - ((long) r20));
        r29 = r29 + 1;
        goto L68
    L71:
        int r5 = r117 + 1;
    L72:
        Long[] r6 = ADJUSTED_CYCLES;
        if (r5 >= r6.length) goto L75;
        r6[r5] = new Long(r6[r5].longValue() + ((long) r20));
        r5 = r5 + 1;
        r117 = r117;
    L75:
        int r119 = r117;
        int r30 = r28 % 30;
        Integer[] r31 = ADJUSTED_CYCLE_YEARS.get(new Integer(r119));
        if (r31 != null) goto L81;
        int r32 = CYCLEYEAR_START_DATE.length;
        Integer[] r33 = new Integer[r32];
        int r34 = 0;
    L78:
        if (r34 >= r32) goto L80;
        r33[r34] = new Integer(CYCLEYEAR_START_DATE[r34]);
        r34 = r34 + 1;
        goto L78
    L80:
        r31 = r33;
    L81:
        int r35 = r30 + 1;
    L83:
        if (r35 >= CYCLEYEAR_START_DATE.length) goto L85;
        r31[r35] = new Integer(r31[r35].intValue() + r20);
        r35 = r35 + 1;
        goto L83
    L85:
        ADJUSTED_CYCLE_YEARS.put(new Integer(r119), r31);
    L86:
        boolean r36 = isLeapYear(r18);
        Integer[] r37 = ADJUSTED_MONTH_DAYS.get(new Integer(r18));
        if (r37 != null) goto L97;
        if (r36 == false) goto L93;
        r37 = new Integer[LEAP_NUM_DAYS.length];
        int r38 = 0;
    L90:
        int[] r39 = LEAP_NUM_DAYS;
        if (r38 >= r39.length) goto L97;
        r37[r38] = new Integer(r39[r38]);
        r38 = r38 + 1;
        goto L90
    L93:
        r37 = new Integer[NUM_DAYS.length];
        int r40 = 0;
    L94:
        int[] r41 = NUM_DAYS;
        if (r40 >= r41.length) goto L97;
        r37[r40] = new Integer(r41[r40]);
        r40 = r40 + 1;
    L97:
        Integer[] r42 = new Integer[r37.length];
        int r43 = 0;
    L98:
        if (r43 >= 12) goto L103;
        if (r43 <= r19) goto L101;
        r42[r43] = new Integer(r37[r43].intValue() + r20);
    L102:
        r43 = r43 + 1;
        goto L98
    L101:
        r42[r43] = new Integer(r37[r43].intValue());
        goto L102
    L103:
        ADJUSTED_MONTH_DAYS.put(new Integer(r18), r42);
        Integer[] r44 = ADJUSTED_MONTH_LENGTHS.get(new Integer(r18));
        if (r44 != null) goto L114;
        if (r36 == false) goto L110;
        r44 = new Integer[LEAP_MONTH_LENGTH.length];
        int r45 = 0;
    L107:
        int[] r46 = LEAP_MONTH_LENGTH;
        if (r45 >= r46.length) goto L114;
        r44[r45] = new Integer(r46[r45]);
        r45 = r45 + 1;
        goto L107
    L110:
        r44 = new Integer[MONTH_LENGTH.length];
        int r47 = 0;
    L111:
        int[] r48 = MONTH_LENGTH;
        if (r47 >= r48.length) goto L114;
        r44[r47] = new Integer(r48[r47]);
        r47 = r47 + 1;
    L114:
        Integer[] r49 = new Integer[r44.length];
        int r50 = 0;
    L115:
        if (r50 >= 12) goto L120;
        if (r50 != r19) goto L118;
        r49[r50] = new Integer(r44[r50].intValue() + r20);
    L119:
        r50 = r50 + 1;
        goto L115
    L118:
        r49[r50] = new Integer(r44[r50].intValue());
        goto L119
    L120:
        HashMap<Integer, Integer[]> r4 = ADJUSTED_MONTH_LENGTHS;
        r4.put(new Integer(r18), r49);
        Integer[] r51 = r4.get(new Integer(r16));
        Integer[] r52 = r4.get(new Integer(r18));
        HashMap<Integer, Integer[]> r53 = ADJUSTED_MONTH_DAYS;
        Integer[] r0 = r53.get(new Integer(r16));
        Integer[] r2 = r53.get(new Integer(r18));
        int r1 = r51[r17].intValue();
        int r3 = r52[r19].intValue();
        int r54 = r0[11].intValue() + r51[11].intValue();
        int r55 = r2[11].intValue() + r52[11].intValue();
        Integer[] r56 = ADJUSTED_MAX_VALUES;
        int r57 = r56[5].intValue();
        Integer[] r58 = ADJUSTED_LEAST_MAX_VALUES;
        int r59 = r58[5].intValue();
        if (r57 >= r1) goto L123;
        r57 = r1;
    L123:
        if (r57 >= r3) goto L125;
        r57 = r3;
    L125:
        r56[5] = new Integer(r57);
        if (r59 > r1) goto L129;
        r1 = r59;
    L129:
        if (r1 > r3) goto L132;
        r3 = r1;
    L132:
        r58[5] = new Integer(r3);
        int r60 = r56[6].intValue();
        int r61 = r58[6].intValue();
        if (r60 >= r54) goto L135;
        r60 = r54;
    L135:
        if (r60 >= r55) goto L137;
        r60 = r55;
    L137:
        r56[6] = new Integer(r60);
        if (r61 > r54) goto L141;
        r54 = r61;
    L141:
        if (r54 > r55) goto L144;
        r55 = r54;
    L144:
        r58[6] = new Integer(r55);
        return;
    L147:
        throw new IllegalArgumentException("startYear > endYear");
    L149:
        throw new IllegalArgumentException("endYear > 9999");
    L151:
        throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
    L153:
        throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
    L155:
        throw new IllegalArgumentException("endYear < 1");
    L157:
        throw new IllegalArgumentException("startYear < 1");
    }

    private static void readDeviationConfig() throws IOException, ParseException {
        InputStream r0 = getConfigFileInputStream();
        if (r0 == null) goto L18;
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r0));     // Catch: Throwable -> L14
        int r3 = 0;
    L19:
        String r4 = r2.readLine();     // Catch: Throwable -> L12
        if (r4 == null) goto L11;
        r3 = r3 + 1;     // Catch: Throwable -> L12
        parseLine(r4.trim(), r3);     // Catch: Throwable -> L12
        goto L19
    L11:
        r2.close();
        return;
    L12:
        th = th;
        r1 = r2;
    L15:
        if (r1 == null) goto L17;
        r1.close();
    L17:
        throw th;
    L14:
        th = th;
        goto L15
    }

    private static void parseLine(String r10, int r11) throws ParseException {
        StringTokenizer r0 = new StringTokenizer(r10, ";");
    L4:
        if (r0.hasMoreTokens() == false) goto L45;
        String r12 = r0.nextToken();
        int r1 = r12.indexOf(58);
        if (r1 == (-1)) goto L44;
        int r4 = Integer.parseInt(r12.substring(r1 + 1, r12.length()));     // Catch: NumberFormatException -> L41
        int r5 = r12.indexOf(45);
        if (r5 == (-1)) goto L40;
        String r7 = r12.substring(0, r5);
        String r13 = r12.substring(r5 + 1, r1);
        int r6 = r7.indexOf(47);
        int r2 = r13.indexOf(47);
        if (r6 == (-1)) goto L38;
        String r8 = r7.substring(0, r6);
        String r9 = r7.substring(r6 + 1, r7.length());
        int r14 = Integer.parseInt(r8);     // Catch: NumberFormatException -> L35
        int r15 = Integer.parseInt(r9);     // Catch: NumberFormatException -> L33
        if (r2 == (-1)) goto L32;
        String r16 = r13.substring(0, r2);
        String r17 = r13.substring(r2 + 1, r13.length());
        int r3 = Integer.parseInt(r16);     // Catch: NumberFormatException -> L29
        int r18 = Integer.parseInt(r17);     // Catch: NumberFormatException -> L27
        if (r14 == (-1)) goto L26;
        if (r15 == (-1)) goto L26;
        if (r3 == (-1)) goto L26;
        if (r18 == (-1)) goto L26;
        addDeviationAsHijrah(r14, r15, r3, r18, r4);
    L26:
        throw new ParseException("Unknown error at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L28:
        throw new ParseException("End month is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L30:
        throw new ParseException("End year is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L32:
        throw new ParseException("End year/month has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L34:
        throw new ParseException("Start month is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L36:
        throw new ParseException("Start year is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L38:
        throw new ParseException("Start year/month has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L40:
        throw new ParseException("Start and end year/month has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L42:
        throw new ParseException("Offset is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L44:
        throw new ParseException("Offset has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    }

    private static InputStream getConfigFileInputStream() throws IOException {
        String r0 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (r0 != null) goto L5;
        r0 = DEFAULT_CONFIG_FILENAME;
    L5:
        String r1 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (r1 != null) goto L8;
        StringTokenizer r3 = new StringTokenizer(System.getProperty("java.class.path"), PATH_SEP);
    L21:
        if (r3.hasMoreTokens() == false) goto L49;
        String r2 = r3.nextToken();
        File r4 = new File(r2);
        if (r4.exists() == false) goto L21;
        if (r4.isDirectory() == true) goto L26;
        ZipFile r5 = new ZipFile(r4);     // Catch: IOException -> L34
    L35:
        if (r5 == null) goto L21;
        StringBuilder r6 = new StringBuilder().append(DEFAULT_CONFIG_PATH);
        char r7 = FILE_SEP;
        String r8 = r6.append(r7).append(r0).toString();
        ZipEntry r9 = r5.getEntry(r8);
        if (r9 == null) goto L39;
    L44:
        if (r9 == null) goto L21;
        return r5.getInputStream(r9);
    L47:
        e = move-exception;
        throw e;
    L39:
        if (r7 != '/') goto L41;
        r8 = r8.replace(IOUtils.DIR_SEPARATOR_UNIX, IOUtils.DIR_SEPARATOR_WINDOWS);
    L43:
        r9 = r5.getEntry(r8);
        goto L44
    L41:
        if (r7 != '\\') goto L43;
        r8 = r8.replace(IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_UNIX);
    L34:
        r5 = null;
        goto L35
    L26:
        StringBuilder r10 = new StringBuilder().append(r2);
        char r11 = FILE_SEP;
        StringBuilder r12 = r10.append(r11);
        String r13 = DEFAULT_CONFIG_PATH;
        if (new File(r12.append(r13).toString(), r0).exists() == false) goto L21;
        return new FileInputStream(r2 + r11 + r13 + r11 + r0);
    L30:
        e = move-exception;
        throw e;
    L49:
        return null;
    L8:
        if (r1.length() == 0) goto L10;
    L11:
        r1 = r1 + System.getProperty("file.separator");
    L12:
        File r14 = new File(r1 + FILE_SEP + r0);
        if (r14.exists() == true) goto L54;
        return null;
    L54:
        return new FileInputStream(r14);
    L16:
        e = move-exception;
        throw e;
    L10:
        if (r1.endsWith(System.getProperty("file.separator")) == true) goto L12;
        goto L11
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    void writeExternal(DataOutput r2) throws IOException {
        r2.writeInt(get(ChronoField.YEAR));
        r2.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r2.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static ChronoLocalDate readExternal(DataInput r3) throws IOException {
        int r0 = r3.readInt();
        byte r1 = r3.readByte();
        byte r4 = r3.readByte();
        return HijrahChronology.INSTANCE.date(r0, r1, r4);
    }
}
