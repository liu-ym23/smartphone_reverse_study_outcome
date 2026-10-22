package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology INSTANCE = null;
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return ExifInterface.TAG_RW2_ISO;
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
    public /* bridge */ /* synthetic */ ChronoLocalDateTime localDateTime(TemporalAccessor r1) {
        return localDateTime(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map r1, ResolverStyle r2) {
        return resolveDate(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoZonedDateTime zonedDateTime(Instant r1, ZoneId r2) {
        return zonedDateTime(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoZonedDateTime zonedDateTime(TemporalAccessor r1) {
        return zonedDateTime(r1);
    }

    static {
        INSTANCE = new IsoChronology();
    }

    private IsoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(Era r1, int r2, int r3, int r4) {
        return date(prolepticYear(r1, r2), r3, r4);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(int r1, int r2, int r3) {
        return LocalDate.of(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateYearDay(Era r1, int r2, int r3) {
        return dateYearDay(prolepticYear(r1, r2), r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateYearDay(int r1, int r2) {
        return LocalDate.ofYearDay(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateEpochDay(long r1) {
        return LocalDate.ofEpochDay(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(TemporalAccessor r1) {
        return LocalDate.from(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDateTime localDateTime(TemporalAccessor r1) {
        return LocalDateTime.from(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ZonedDateTime zonedDateTime(TemporalAccessor r1) {
        return ZonedDateTime.from(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ZonedDateTime zonedDateTime(Instant r1, ZoneId r2) {
        return ZonedDateTime.ofInstant(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow(ZoneId r1) {
        return dateNow(Clock.system(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow(Clock r2) {
        Jdk8Methods.requireNonNull(r2, "clock");
        return date(LocalDate.now(r2));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long r5) {
        if ((3 & r5) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r5 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r5 % 400) != 0) goto L9;
        goto L8
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era r1, int r2) {
        if ((r1 instanceof IsoEra) == false) goto L10;
        if (r1 != IsoEra.CE) goto L8;
        return r2;
    L8:
        return 1 - r2;
    L10:
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public IsoEra eraOf(int r1) {
        return IsoEra.of(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField r1) {
        return r1.range();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate resolveDate(Map<TemporalField, Long> r11, ResolverStyle r12) {
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
        if (r11.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L107;
        if (r11.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L77;
        int r10 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        int r2 = Jdk8Methods.safeToInt(r11.remove(ChronoField.MONTH_OF_YEAR).longValue());
        int r13 = Jdk8Methods.safeToInt(r11.remove(ChronoField.DAY_OF_MONTH).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L58;
        long r3 = Jdk8Methods.safeSubtract(r2, 1);
        return LocalDate.of(r10, 1, 1).plusMonths(r3).plusDays(Jdk8Methods.safeSubtract(r13, 1));
    L58:
        if (r12 != ResolverStyle.SMART) goto L75;
        ChronoField.DAY_OF_MONTH.checkValidValue(r13);
        if (r2 != 4) goto L62;
    L71:
        r13 = Math.min(r13, 30);
    L73:
        return LocalDate.of(r10, r2, r13);
    L62:
        if (r2 == 6) goto L71;
        if (r2 == 9) goto L71;
        if (r2 == 11) goto L71;
        if (r2 != 2) goto L73;
        r13 = Math.min(r13, Month.FEBRUARY.length(Year.isLeap(r10)));
        goto L73
    L75:
        return LocalDate.of(r10, r2, r13);
    L77:
        if (r11.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH) == false) goto L107;
        if (r11.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) == false) goto L93;
        int r14 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L84;
        long r8 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
        long r9 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
        return LocalDate.of(r14, 1, 1).plusMonths(r8).plusWeeks(r9).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), 1));
    L84:
        int r15 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.MONTH_OF_YEAR).longValue());
        LocalDate r16 = LocalDate.of(r14, r15, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.checkValidIntValue(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue()) - 1));
        if (r12 == ResolverStyle.STRICT) goto L87;
    L91:
        return r16;
    L87:
        if (r16.get(ChronoField.MONTH_OF_YEAR) == r15) goto L91;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L93:
        if (r11.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L107;
        int r17 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L98;
        long r18 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
        long r19 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
        return LocalDate.of(r17, 1, 1).plusMonths(r18).plusWeeks(r19).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_WEEK).longValue(), 1));
    L98:
        int r20 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.MONTH_OF_YEAR).longValue());
        LocalDate r110 = LocalDate.of(r17, r20, 1).plusWeeks(ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue()) - 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(r11.remove(ChronoField.DAY_OF_WEEK).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L101;
    L105:
        return r110;
    L101:
        if (r110.get(ChronoField.MONTH_OF_YEAR) == r20) goto L105;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L107:
        if (r11.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L115;
        int r111 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L113;
        return LocalDate.ofYearDay(r111, 1).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_YEAR).longValue(), 1));
    L113:
        return LocalDate.ofYearDay(r111, ChronoField.DAY_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.DAY_OF_YEAR).longValue()));
    L115:
        if (r11.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR) == true) goto L117;
        return null;
    L117:
        if (r11.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == false) goto L131;
        int r112 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L122;
        long r21 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
        return LocalDate.of(r112, 1, 1).plusWeeks(r21).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), 1));
    L122:
        LocalDate r113 = LocalDate.of(r112, 1, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.checkValidIntValue(r11.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue()) - 1));
        if (r12 == ResolverStyle.STRICT) goto L125;
    L129:
        return r113;
    L125:
        if (r113.get(ChronoField.YEAR) == r112) goto L129;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L131:
        if (r11.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L147;
        int r114 = ChronoField.YEAR.checkValidIntValue(r11.remove(ChronoField.YEAR).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L136;
        long r22 = Jdk8Methods.safeSubtract(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
        return LocalDate.of(r114, 1, 1).plusWeeks(r22).plusDays(Jdk8Methods.safeSubtract(r11.remove(ChronoField.DAY_OF_WEEK).longValue(), 1));
    L136:
        LocalDate r115 = LocalDate.of(r114, 1, 1).plusWeeks(ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(r11.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue()) - 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(r11.remove(ChronoField.DAY_OF_WEEK).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L139;
    L143:
        return r115;
    L139:
        if (r115.get(ChronoField.YEAR) == r114) goto L143;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L147:
        return null;
    L25:
        r6 = Jdk8Methods.safeSubtract(1, r1.longValue());
        goto L26
    L27:
        r11.put(ChronoField.YEAR_OF_ERA, r1);
        goto L48
    L28:
        ChronoField r23 = ChronoField.YEAR;
        if (r5 != null) goto L31;
    L34:
        long r24 = r1.longValue();
    L35:
        updateResolveMap(r11, r23, r24);
        goto L48
    L31:
        if (r5.longValue() > 0) goto L34;
        r24 = Jdk8Methods.safeSubtract(1, r1.longValue());
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
        return LocalDate.ofEpochDay(r11.remove(ChronoField.EPOCH_DAY).longValue());
    }
}
