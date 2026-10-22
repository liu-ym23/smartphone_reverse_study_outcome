package org.threeten.bp.temporal;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import obric.bluetooth.SmartBluetoothBinderClient;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes6.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = null;
    public static final WeekFields ISO = null;
    public static final WeekFields SUNDAY_START = null;
    private static final long serialVersionUID = -1177360819670808121L;
    private final transient TemporalField dayOfWeek;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField weekBasedYear;
    private final transient TemporalField weekOfMonth;
    private final transient TemporalField weekOfWeekBasedYear;
    private final transient TemporalField weekOfYear;

    static class ComputedDayOfField implements TemporalField {
        private static final ValueRange DAY_OF_WEEK_RANGE = null;
        private static final ValueRange WEEK_BASED_YEAR_RANGE = null;
        private static final ValueRange WEEK_OF_MONTH_RANGE = null;
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = null;
        private static final ValueRange WEEK_OF_YEAR_RANGE = null;
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields r7) {
            return new ComputedDayOfField("DayOfWeek", r7, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields r7) {
            return new ComputedDayOfField("WeekOfMonth", r7, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields r7) {
            return new ComputedDayOfField("WeekOfYear", r7, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields r7) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", r7, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields r7) {
            return new ComputedDayOfField("WeekBasedYear", r7, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, WEEK_BASED_YEAR_RANGE);
        }

        private ComputedDayOfField(String r1, WeekFields r2, TemporalUnit r3, TemporalUnit r4, ValueRange r5) {
            this.name = r1;
            this.weekDef = r2;
            this.baseUnit = r3;
            this.rangeUnit = r4;
            this.range = r5;
        }

        static {
            DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
            WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
            WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
            WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);
            WEEK_BASED_YEAR_RANGE = ChronoField.YEAR.range();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long getFrom(TemporalAccessor r4) {
            int r0 = Jdk8Methods.floorMod(r4.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L7;
            return r0;
        L7:
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L12;
            int r5 = r4.get(ChronoField.DAY_OF_MONTH);
            int r3 = computeWeek(startOfWeekOffset(r5, r0), r5);
        L10:
            return r3;
        L12:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L15;
            int r6 = r4.get(ChronoField.DAY_OF_YEAR);
            r3 = computeWeek(startOfWeekOffset(r6, r0), r6);
            goto L10
        L15:
            if (this.rangeUnit != IsoFields.WEEK_BASED_YEARS) goto L18;
            r3 = localizedWOWBY(r4);
            goto L10
        L18:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L21;
            r3 = localizedWBY(r4);
            goto L10
        L21:
            throw new IllegalStateException("unreachable");
        }

        private int localizedDayOfWeek(TemporalAccessor r1, int r2) {
            return Jdk8Methods.floorMod(r1.get(ChronoField.DAY_OF_WEEK) - r2, 7) + 1;
        }

        private long localizedWeekOfMonth(TemporalAccessor r2, int r3) {
            int r4 = r2.get(ChronoField.DAY_OF_MONTH);
            return computeWeek(startOfWeekOffset(r4, r3), r4);
        }

        private long localizedWeekOfYear(TemporalAccessor r2, int r3) {
            int r4 = r2.get(ChronoField.DAY_OF_YEAR);
            return computeWeek(startOfWeekOffset(r4, r3), r4);
        }

        private int localizedWOWBY(TemporalAccessor r6) {
            int r0 = Jdk8Methods.floorMod(r6.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long r1 = localizedWeekOfYear(r6, r0);
            if (r1 != 0) goto L7;
            return ((int) localizedWeekOfYear(Chronology.from(r6).date(r6).minus(1, ChronoUnit.WEEKS), r0)) + 1;
        L7:
            if (r1 < 53) goto L17;
            int r2 = startOfWeekOffset(r6.get(ChronoField.DAY_OF_YEAR), r0);
            if (Year.isLeap(r6.get(ChronoField.YEAR)) == false) goto L11;
            int r7 = 366;
        L12:
            int r5 = computeWeek(r2, r7 + this.weekDef.getMinimalDaysInFirstWeek());
            if (r1 < r5) goto L17;
            return (int) (r1 - ((long) (r5 - 1)));
        L11:
            r7 = SmartBluetoothBinderClient.PRODUCT_1;
        L17:
            return (int) r1;
        }

        private int localizedWBY(TemporalAccessor r7) {
            int r0 = Jdk8Methods.floorMod(r7.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            int r1 = r7.get(ChronoField.YEAR);
            long r2 = localizedWeekOfYear(r7, r0);
            if (r2 != 0) goto L7;
            return r1 - 1;
        L7:
            if (r2 >= 53) goto L9;
            return r1;
        L9:
            int r8 = startOfWeekOffset(r7.get(ChronoField.DAY_OF_YEAR), r0);
            if (Year.isLeap(r1) == false) goto L12;
            int r3 = 366;
        L14:
            if (r2 >= computeWeek(r8, r3 + this.weekDef.getMinimalDaysInFirstWeek())) goto L16;
            return r1;
        L16:
            return r1 + 1;
        L12:
            r3 = SmartBluetoothBinderClient.PRODUCT_1;
            goto L14
        }

        private int startOfWeekOffset(int r3, int r4) {
            int r5 = Jdk8Methods.floorMod(r3 - r4, 7);
            int r0 = -r5;
            if ((r5 + 1) > this.weekDef.getMinimalDaysInFirstWeek()) goto L5;
            return r0;
        L5:
            return 7 - r5;
        }

        private int computeWeek(int r1, int r2) {
            return ((r1 + 7) + (r2 - 1)) / 7;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r6, long r7) {
            int r0 = this.range.checkValidIntValue(r7, this);
            int r1 = r6.get(this);
            if (r0 != r1) goto L6;
            return r6;
        L6:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L19;
            int r2 = r6.get(WeekFields.access$000(this.weekDef));
            Temporal r8 = r6.plus((long) ((r7 - ((long) r1)) * 52.1775d), ChronoUnit.WEEKS);
            if (r8.get(this) <= r0) goto L11;
            return (R) r8.minus(r8.get(WeekFields.access$000(this.weekDef)), ChronoUnit.WEEKS);
        L11:
            if (r8.get(this) >= r0) goto L13;
            r8 = r8.plus(2, ChronoUnit.WEEKS);
        L13:
            R r9 = (R) r8.plus(r2 - r8.get(WeekFields.access$000(this.weekDef)), ChronoUnit.WEEKS);
            if (r9.get(this) <= r0) goto L17;
            return (R) r9.minus(1, ChronoUnit.WEEKS);
        L17:
            return r9;
        L19:
            return (R) r6.plus(r0 - r1, this.baseUnit);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> r12, TemporalAccessor r13, ResolverStyle r14) {
            int r0 = this.weekDef.getFirstDayOfWeek().getValue();
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L7;
            r12.put(ChronoField.DAY_OF_WEEK, Long.valueOf(Jdk8Methods.floorMod((r0 - 1) + (this.range.checkValidIntValue(r12.remove(this).longValue(), this) - 1), 7) + 1));
            return null;
        L7:
            if (r12.containsKey(ChronoField.DAY_OF_WEEK) == true) goto L10;
            return null;
        L10:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L28;
            if (r12.containsKey(WeekFields.access$000(this.weekDef)) == true) goto L14;
            return null;
        L14:
            Chronology r15 = Chronology.from(r13);
            int r1 = Jdk8Methods.floorMod(ChronoField.DAY_OF_WEEK.checkValidIntValue(r12.get(ChronoField.DAY_OF_WEEK).longValue()) - r0, 7) + 1;
            int r2 = range().checkValidIntValue(r12.get(this).longValue(), this);
            if (r14 != ResolverStyle.LENIENT) goto L17;
            ChronoLocalDate r16 = r15.date(r2, 1, this.weekDef.getMinimalDaysInFirstWeek());
            long r3 = r12.get(WeekFields.access$000(this.weekDef)).longValue();
            int r4 = localizedDayOfWeek(r16, r0);
            long r5 = localizedWeekOfYear(r16, r4);
        L18:
            ChronoLocalDate r17 = r16.plus(((r3 - r5) * 7) + ((long) (r1 - r4)), ChronoUnit.DAYS);
            if (r14 == ResolverStyle.STRICT) goto L21;
        L25:
            r12.remove(this);
            r12.remove(WeekFields.access$000(this.weekDef));
            r12.remove(ChronoField.DAY_OF_WEEK);
            return r17;
        L21:
            if (r17.getLong(this) == r12.get(this).longValue()) goto L25;
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        L17:
            r16 = r15.date(r2, 1, this.weekDef.getMinimalDaysInFirstWeek());
            r3 = WeekFields.access$000(this.weekDef).range().checkValidIntValue(r12.get(WeekFields.access$000(this.weekDef)).longValue(), WeekFields.access$000(this.weekDef));
            r4 = localizedDayOfWeek(r16, r0);
            r5 = localizedWeekOfYear(r16, r4);
            goto L18
        L28:
            if (r12.containsKey(ChronoField.YEAR) == true) goto L30;
            return null;
        L30:
            int r6 = Jdk8Methods.floorMod(ChronoField.DAY_OF_WEEK.checkValidIntValue(r12.get(ChronoField.DAY_OF_WEEK).longValue()) - r0, 7) + 1;
            int r7 = ChronoField.YEAR.checkValidIntValue(r12.get(ChronoField.YEAR).longValue());
            Chronology r18 = Chronology.from(r13);
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L49;
            if (r12.containsKey(ChronoField.MONTH_OF_YEAR) == true) goto L35;
            return null;
        L35:
            long r8 = r12.remove(this).longValue();
            if (r14 != ResolverStyle.LENIENT) goto L38;
            ChronoLocalDate r19 = r18.date(r7, 1, 1).plus(r12.get(ChronoField.MONTH_OF_YEAR).longValue() - 1, ChronoUnit.MONTHS);
            int r9 = localizedDayOfWeek(r19, r0);
            long r10 = ((r8 - localizedWeekOfMonth(r19, r9)) * 7) + ((long) (r6 - r9));
        L39:
            ChronoLocalDate r110 = r19.plus(r10, ChronoUnit.DAYS);
            if (r14 == ResolverStyle.STRICT) goto L42;
        L46:
            r12.remove(this);
            r12.remove(ChronoField.YEAR);
            r12.remove(ChronoField.MONTH_OF_YEAR);
            r12.remove(ChronoField.DAY_OF_WEEK);
            return r110;
        L42:
            if (r110.getLong(ChronoField.MONTH_OF_YEAR) == r12.get(ChronoField.MONTH_OF_YEAR).longValue()) goto L46;
            throw new DateTimeException("Strict mode rejected date parsed to a different month");
        L38:
            r19 = r18.date(r7, ChronoField.MONTH_OF_YEAR.checkValidIntValue(r12.get(ChronoField.MONTH_OF_YEAR).longValue()), 8);
            int r11 = localizedDayOfWeek(r19, r0);
            r10 = ((((long) this.range.checkValidIntValue(r8, this)) - localizedWeekOfMonth(r19, r11)) * 7) + ((long) (r6 - r11));
            goto L39
        L49:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L64;
            long r20 = r12.remove(this).longValue();
            ChronoLocalDate r111 = r18.date(r7, 1, 1);
            if (r14 != ResolverStyle.LENIENT) goto L53;
            int r21 = localizedDayOfWeek(r111, r0);
            long r22 = ((r20 - localizedWeekOfYear(r111, r21)) * 7) + ((long) (r6 - r21));
        L54:
            ChronoLocalDate r112 = r111.plus(r22, ChronoUnit.DAYS);
            if (r14 == ResolverStyle.STRICT) goto L57;
        L61:
            r12.remove(this);
            r12.remove(ChronoField.YEAR);
            r12.remove(ChronoField.DAY_OF_WEEK);
            return r112;
        L57:
            if (r112.getLong(ChronoField.YEAR) == r12.get(ChronoField.YEAR).longValue()) goto L61;
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        L53:
            int r23 = localizedDayOfWeek(r111, r0);
            r22 = ((((long) this.range.checkValidIntValue(r20, this)) - localizedWeekOfYear(r111, r23)) * 7) + ((long) (r6 - r23));
            goto L54
        L64:
            throw new IllegalStateException("unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor r3) {
            if (r3.isSupported(ChronoField.DAY_OF_WEEK) == true) goto L5;
            return false;
        L5:
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L9;
            return true;
        L9:
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L13;
            return r3.isSupported(ChronoField.DAY_OF_MONTH);
        L13:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L17;
            return r3.isSupported(ChronoField.DAY_OF_YEAR);
        L17:
            if (this.rangeUnit != IsoFields.WEEK_BASED_YEARS) goto L21;
            return r3.isSupported(ChronoField.EPOCH_DAY);
        L21:
            if (this.rangeUnit == ChronoUnit.FOREVER) goto L23;
            return false;
        L23:
            return r3.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor r7) {
            if (this.rangeUnit != ChronoUnit.WEEKS) goto L7;
            return this.range;
        L7:
            if (this.rangeUnit != ChronoUnit.MONTHS) goto L10;
            ChronoField r0 = ChronoField.DAY_OF_MONTH;
        L12:
            int r1 = startOfWeekOffset(r7.get(r0), Jdk8Methods.floorMod(r7.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1);
            ValueRange r8 = r7.range(r0);
            return ValueRange.of(computeWeek(r1, (int) r8.getMinimum()), computeWeek(r1, (int) r8.getMaximum()));
        L10:
            if (this.rangeUnit != ChronoUnit.YEARS) goto L15;
            r0 = ChronoField.DAY_OF_YEAR;
            goto L12
        L15:
            if (this.rangeUnit != IsoFields.WEEK_BASED_YEARS) goto L19;
            return rangeWOWBY(r7);
        L19:
            if (this.rangeUnit != ChronoUnit.FOREVER) goto L23;
            return r7.range(ChronoField.YEAR);
        L23:
            throw new IllegalStateException("unreachable");
        }

        private ValueRange rangeWOWBY(TemporalAccessor r9) {
            int r0 = Jdk8Methods.floorMod(r9.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long r1 = localizedWeekOfYear(r9, r0);
            if (r1 == 0) goto L5;
            int r2 = startOfWeekOffset(r9.get(ChronoField.DAY_OF_YEAR), r0);
            if (Year.isLeap(r9.get(ChronoField.YEAR)) == false) goto L9;
            int r3 = 366;
        L10:
            int r4 = computeWeek(r2, r3 + this.weekDef.getMinimalDaysInFirstWeek());
            if (r1 < r4) goto L15;
            return rangeWOWBY(Chronology.from(r9).date(r9).plus(2, ChronoUnit.WEEKS));
        L15:
            return ValueRange.of(1, r4 - 1);
        L9:
            r3 = SmartBluetoothBinderClient.PRODUCT_1;
            goto L10
        L5:
            return rangeWOWBY(Chronology.from(r9).date(r9).minus(2, ChronoUnit.WEEKS));
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale r2) {
            Jdk8Methods.requireNonNull(r2, "locale");
            if (this.rangeUnit != ChronoUnit.YEARS) goto L7;
            return "Week";
        L7:
            return toString();
        }

        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }

    static /* synthetic */ TemporalField access$000(WeekFields r0) {
        return r0.weekOfWeekBasedYear;
    }

    static {
        CACHE = new ConcurrentHashMap(4, 0.75f, 2);
        ISO = new WeekFields(DayOfWeek.MONDAY, 4);
        SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    }

    public static WeekFields of(Locale r4) {
        Jdk8Methods.requireNonNull(r4, "locale");
        GregorianCalendar r5 = new GregorianCalendar(new Locale(r4.getLanguage(), r4.getCountry()));
        return of(DayOfWeek.SUNDAY.plus(r5.getFirstDayOfWeek() - 1), r5.getMinimalDaysInFirstWeek());
    }

    public static WeekFields of(DayOfWeek r3, int r4) {
        String r0 = r3.toString() + r4;
        ConcurrentMap<String, WeekFields> r1 = CACHE;
        WeekFields r2 = r1.get(r0);
        if (r2 != null) goto L6;
        r1.putIfAbsent(r0, new WeekFields(r3, r4));
        return r1.get(r0);
    L6:
        return r2;
    }

    private WeekFields(DayOfWeek r2, int r3) {
        this.dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
        this.weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
        this.weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
        this.weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
        this.weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);
        Jdk8Methods.requireNonNull(r2, "firstDayOfWeek");
        if (r3 < 1) goto L9;
        if (r3 > 7) goto L9;
        this.firstDayOfWeek = r2;
        this.minimalDays = r3;
        return;
    L9:
        throw new IllegalArgumentException("Minimal number of days is invalid");
    }

    private Object readResolve() throws InvalidObjectException {
        return of(this.firstDayOfWeek, this.minimalDays);
    L4:
        e = move-exception;
        throw new InvalidObjectException("Invalid WeekFields" + e.getMessage());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof WeekFields) == true) goto L8;
        return false;
    L8:
        if (hashCode() != r4.hashCode()) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + ',' + this.minimalDays + ']';
    }
}
