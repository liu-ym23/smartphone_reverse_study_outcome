package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class ThaiBuddhistChronology extends Chronology implements Serializable {
    private static final HashMap<String, String[]> ERA_FULL_NAMES = null;
    private static final HashMap<String, String[]> ERA_NARROW_NAMES = null;
    private static final HashMap<String, String[]> ERA_SHORT_NAMES = null;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final ThaiBuddhistChronology INSTANCE = null;
    private static final String TARGET_LANGUAGE = "th";
    static final int YEARS_DIFFERENCE = 543;
    private static final long serialVersionUID = 2775954514031616474L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ThaiBuddhistChronology$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "buddhist";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "ThaiBuddhist";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate date(int r1, int r2, int r3) {
        return date(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate date(Era r1, int r2, int r3, int r4) {
        return date(r1, r2, r3, r4);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate date(TemporalAccessor r1) {
        return date(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateEpochDay(long r1) {
        return dateEpochDay(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow() {
        return dateNow();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow(Clock r1) {
        return dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow(ZoneId r1) {
        return dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateYearDay(int r1, int r2) {
        return dateYearDay(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateYearDay(Era r1, int r2, int r3) {
        return dateYearDay(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ Era eraOf(int r1) {
        return eraOf(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map r1, ResolverStyle r2) {
        return resolveDate(r1, r2);
    }

    static {
        INSTANCE = new ThaiBuddhistChronology();
        HashMap<String, String[]> r0 = new HashMap();
        ERA_NARROW_NAMES = r0;
        HashMap<String, String[]> r1 = new HashMap();
        ERA_SHORT_NAMES = r1;
        HashMap<String, String[]> r2 = new HashMap();
        ERA_FULL_NAMES = r2;
        r0.put(FALLBACK_LANGUAGE, new String[]{"BB", "BE"});
        r0.put(TARGET_LANGUAGE, new String[]{"BB", "BE"});
        r1.put(FALLBACK_LANGUAGE, new String[]{"B.B.", "B.E."});
        r1.put(TARGET_LANGUAGE, new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        r2.put(FALLBACK_LANGUAGE, new String[]{"Before Buddhist", "Budhhist Era"});
        r2.put(TARGET_LANGUAGE, new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private ThaiBuddhistChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate date(Era r1, int r2, int r3, int r4) {
        return (ThaiBuddhistDate) super.date(r1, r2, r3, r4);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate date(int r1, int r2, int r3) {
        return new ThaiBuddhistDate(LocalDate.of(r1 - 543, r2, r3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate dateYearDay(Era r1, int r2, int r3) {
        return (ThaiBuddhistDate) super.dateYearDay(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate dateYearDay(int r1, int r2) {
        return new ThaiBuddhistDate(LocalDate.ofYearDay(r1 - 543, r2));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate dateEpochDay(long r1) {
        return new ThaiBuddhistDate(LocalDate.ofEpochDay(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate date(TemporalAccessor r1) {
        if ((r1 instanceof ThaiBuddhistDate) == false) goto L7;
        return (ThaiBuddhistDate) r1;
    L7:
        return new ThaiBuddhistDate(LocalDate.from(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<ThaiBuddhistDate> localDateTime(TemporalAccessor r1) {
        return super.localDateTime(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<ThaiBuddhistDate> zonedDateTime(TemporalAccessor r1) {
        return super.zonedDateTime(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<ThaiBuddhistDate> zonedDateTime(Instant r1, ZoneId r2) {
        return super.zonedDateTime(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate dateNow() {
        return (ThaiBuddhistDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate dateNow(ZoneId r1) {
        return (ThaiBuddhistDate) super.dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate dateNow(Clock r2) {
        Jdk8Methods.requireNonNull(r2, "clock");
        return (ThaiBuddhistDate) super.dateNow(r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long r3) {
        return IsoChronology.INSTANCE.isLeapYear(r3 - 543);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era r1, int r2) {
        if ((r1 instanceof ThaiBuddhistEra) == false) goto L10;
        if (r1 != ThaiBuddhistEra.BE) goto L8;
        return r2;
    L8:
        return 1 - r2;
    L10:
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistEra eraOf(int r1) {
        return ThaiBuddhistEra.of(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(ThaiBuddhistEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField r10) {
        int r9 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r10.ordinal()];
        if (r9 != 1) goto L5;
        ValueRange r11 = ChronoField.PROLEPTIC_MONTH.range();
        return ValueRange.of(r11.getMinimum() + 6516, r11.getMaximum() + 6516);
    L5:
        if (r9 != 2) goto L7;
        ValueRange r12 = ChronoField.YEAR.range();
        return ValueRange.of(1, (-(r12.getMinimum() + 543)) + 1, r12.getMaximum() + 543);
    L7:
        if (r9 != 3) goto L9;
        ValueRange r13 = ChronoField.YEAR.range();
        return ValueRange.of(r13.getMinimum() + 543, r13.getMaximum() + 543);
    L9:
        return r10.range();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ThaiBuddhistDate resolveDate(Map<TemporalField, Long> r11, ResolverStyle r12) {
        if (r11.containsKey(ChronoField.EPOCH_DAY) == true) goto L5;
        Long r0 = r11.remove(ChronoField.PROLEPTIC_MONTH);
        if (r0 != null) goto L9;
    L12:
        Long r1 = r11.remove(ChronoField.YEAR_OF_ERA);
        if (r1 == null) goto L45;
        if (r12 == ResolverStyle.LENIENT) goto L17;
        ChronoField.YEAR_OF_ERA.checkValidValue(r1.longValue());
    L17:
        Long r4 = r11.remove(ChronoField.ERA);
        if (r4 != null) goto L37;
        Long r5 = r11.get(ChronoField.YEAR);
        if (r12 != ResolverStyle.STRICT) goto L28;
        if (r5 == null) goto L27;
        ChronoField r7 = ChronoField.YEAR;
        if (r5.longValue() <= 0) goto L25;
        long r6 = r1.longValue();
    L26:
        updateResolveMap(r11, r7, r6);
    L48:
        if (r11.containsKey(ChronoField.YEAR) == true) goto L50;
        return null;
    L50:
        if (r11.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L95;
        if (r11.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L65;
        int r2 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L57;
        long r8 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
        return date(r2, 1, 1).plusMonths(r8).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_MONTH).longValue(), 1));
    L57:
        int r3 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(r11.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        int r13 = range(ChronoField.DAY_OF_MONTH).checkValidIntValue(r11.remove(ChronoField.DAY_OF_MONTH).longValue(), ChronoField.DAY_OF_MONTH);
        if (r12 != ResolverStyle.SMART) goto L63;
        if (r13 <= 28) goto L63;
        r13 = Math.min(r13, date(r2, r3, 1).lengthOfMonth());
    L63:
        return date(r2, r3, r13);
    L65:
        if (r11.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH) == false) goto L95;
        if (r11.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) == false) goto L81;
        int r9 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L72;
        long r10 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
        long r14 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
        return date(r9, 1, 1).plus(r10, ChronoUnit.MONTHS).plus(r14, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), 1), ChronoUnit.DAYS);
    L72:
        int r15 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.MONTH_OF_YEAR).longValue());
        ThaiBuddhistDate r16 = date(r9, r15, 1).plus(((ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.checkValidIntValue(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue()) - 1), ChronoUnit.DAYS);
        if (r12 == ResolverStyle.STRICT) goto L75;
    L79:
        return r16;
    L75:
        if (r16.get(ChronoField.MONTH_OF_YEAR) == r15) goto L79;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L81:
        if (r11.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L95;
        int r17 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L86;
        long r18 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
        long r19 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
        return date(r17, 1, 1).plus(r18, ChronoUnit.MONTHS).plus(r19, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_WEEK).longValue(), 1), ChronoUnit.DAYS);
    L86:
        int r20 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.MONTH_OF_YEAR).longValue());
        ThaiBuddhistDate r110 = date(r17, r20, 1).plus(ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue()) - 1, ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(r11.remove(ChronoField.DAY_OF_WEEK).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L89;
    L93:
        return r110;
    L89:
        if (r110.get(ChronoField.MONTH_OF_YEAR) == r20) goto L93;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L95:
        if (r11.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L103;
        int r21 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L101;
        return dateYearDay(r21, 1).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_YEAR).longValue(), 1));
    L101:
        return dateYearDay(r21, ChronoField.DAY_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.DAY_OF_YEAR).longValue()));
    L103:
        if (r11.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR) == true) goto L105;
        return null;
    L105:
        if (r11.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == false) goto L119;
        int r22 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L110;
        long r23 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
        return date(r22, 1, 1).plus(r23, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), 1), ChronoUnit.DAYS);
    L110:
        ThaiBuddhistDate r111 = date(r22, 1, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.checkValidIntValue(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue()) - 1));
        if (r12 == ResolverStyle.STRICT) goto L113;
    L117:
        return r111;
    L113:
        if (r111.get(ChronoField.YEAR) == r22) goto L117;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L119:
        if (r11.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L135;
        int r24 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L124;
        long r25 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
        return date(r24, 1, 1).plus(r25, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_WEEK).longValue(), 1), ChronoUnit.DAYS);
    L124:
        ThaiBuddhistDate r112 = date(r24, 1, 1).plus(ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue()) - 1, ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(r11.remove(ChronoField.DAY_OF_WEEK).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L127;
    L131:
        return r112;
    L127:
        if (r112.get(ChronoField.YEAR) == r24) goto L131;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L135:
        return null;
    L25:
        r6 = Jdk8Methods.safeSubtract(1, r1.longValue());
        goto L26
    L27:
        r11.put(ChronoField.YEAR_OF_ERA, r1);
        goto L48
    L28:
        ChronoField r26 = ChronoField.YEAR;
        if (r5 != null) goto L31;
    L34:
        long r27 = r1.longValue();
    L35:
        updateResolveMap(r11, r26, r27);
        goto L48
    L31:
        if (r5.longValue() > 0) goto L34;
        r27 = Jdk8Methods.safeSubtract(1, r1.longValue());
        goto L35
    L37:
        if (r4.longValue() != 1) goto L40;
        updateResolveMap(r11, ChronoField.YEAR, r1.longValue());
        goto L48
    L40:
        if (r4.longValue() != 0) goto L43;
        updateResolveMap(r11, ChronoField.YEAR, Jdk8Methods.safeSubtract(1, r1.longValue()));
        goto L48
    L43:
        throw new DateTimeException("Invalid value for era: " + r4);
    L45:
        if (r11.containsKey(ChronoField.ERA) == false) goto L48;
        ChronoField.ERA.checkValidValue(r11.get(ChronoField.ERA).longValue());
        goto L48
    L9:
        if (r12 == ResolverStyle.LENIENT) goto L11;
        ChronoField.PROLEPTIC_MONTH.checkValidValue(r0.longValue());
    L11:
        updateResolveMap(r11, ChronoField.MONTH_OF_YEAR, Jdk8Methods.floorMod(r0.longValue(), 12) + 1);
        updateResolveMap(r11, ChronoField.YEAR, Jdk8Methods.floorDiv(r0.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(r11.remove(ChronoField.EPOCH_DAY).longValue());
    }
}
