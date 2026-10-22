package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
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

/* JADX INFO: loaded from: classes6.dex */
public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    static final LocalDate MIN_DATE = null;
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final LocalDate isoDate;
    private transient int yearOfEra;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.JapaneseDate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.DAY_OF_YEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
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
        MIN_DATE = LocalDate.of(1873, 1, 1);
    }

    public static JapaneseDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static JapaneseDate now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static JapaneseDate now(Clock r1) {
        return new JapaneseDate(LocalDate.now(r1));
    }

    public static JapaneseDate of(JapaneseEra r4, int r5, int r6, int r7) {
        Jdk8Methods.requireNonNull(r4, "era");
        if (r5 < 1) goto L13;
        LocalDate r1 = r4.startDate();
        LocalDate r2 = r4.endDate();
        LocalDate r8 = LocalDate.of((r1.getYear() - 1) + r5, r6, r7);
        if (r8.isBefore(r1) == true) goto L11;
        if (r8.isAfter(r2) == true) goto L11;
        return new JapaneseDate(r4, r5, r8);
    L11:
        throw new DateTimeException("Requested date is outside bounds of era " + r4);
    L13:
        throw new DateTimeException("Invalid YearOfEra: " + r5);
    }

    static JapaneseDate ofYearDay(JapaneseEra r4, int r5, int r6) {
        Jdk8Methods.requireNonNull(r4, "era");
        if (r5 < 1) goto L20;
        LocalDate r1 = r4.startDate();
        LocalDate r2 = r4.endDate();
        if (r5 != 1) goto L11;
        r6 = r6 + (r1.getDayOfYear() - 1);
        if (r6 <= r1.lengthOfYear()) goto L11;
        throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + r4);
    L11:
        LocalDate r7 = LocalDate.ofYearDay((r1.getYear() - 1) + r5, r6);
        if (r7.isBefore(r1) == true) goto L18;
        if (r7.isAfter(r2) == true) goto L18;
        return new JapaneseDate(r4, r5, r7);
    L18:
        throw new DateTimeException("Requested date is outside bounds of era " + r4);
    L20:
        throw new DateTimeException("Invalid YearOfEra: " + r5);
    }

    public static JapaneseDate of(int r1, int r2, int r3) {
        return new JapaneseDate(LocalDate.of(r1, r2, r3));
    }

    public static JapaneseDate from(TemporalAccessor r1) {
        return JapaneseChronology.INSTANCE.date(r1);
    }

    JapaneseDate(LocalDate r3) {
        if (r3.isBefore(MIN_DATE) == true) goto L7;
        JapaneseEra r0 = JapaneseEra.from(r3);
        this.era = r0;
        this.yearOfEra = r3.getYear() - (r0.startDate().getYear() - 1);
        this.isoDate = r3;
        return;
    L7:
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    JapaneseDate(JapaneseEra r2, int r3, LocalDate r4) {
        if (r4.isBefore(MIN_DATE) == true) goto L7;
        this.era = r2;
        this.yearOfEra = r3;
        this.isoDate = r4;
        return;
    L7:
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
        r2.defaultReadObject();
        JapaneseEra r3 = JapaneseEra.from(this.isoDate);
        this.era = r3;
        this.yearOfEra = this.isoDate.getYear() - (r3.startDate().getYear() - 1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public JapaneseEra getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfYear() {
        Calendar r0 = Calendar.getInstance(JapaneseChronology.LOCALE);
        r0.set(0, this.era.getValue() + 2);
        r0.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return r0.getActualMaximum(6);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r2) {
        if (r2 != ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) goto L5;
        return false;
    L5:
        if (r2 != ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) goto L7;
        return false;
    L7:
        if (r2 != ChronoField.ALIGNED_WEEK_OF_MONTH) goto L9;
        return false;
    L9:
        if (r2 != ChronoField.ALIGNED_WEEK_OF_YEAR) goto L12;
        return false;
    L12:
        return super.isSupported(r2);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r4) {
        if ((r4 instanceof ChronoField) == false) goto L19;
        if (isSupported(r4) == false) goto L17;
        ChronoField r5 = (ChronoField) r4;
        int r0 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r5.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        return getChronology().range(r5);
    L13:
        return actualRange(1);
    L15:
        return actualRange(6);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    L19:
        return r4.rangeRefinedBy(this);
    }

    private ValueRange actualRange(int r4) {
        Calendar r0 = Calendar.getInstance(JapaneseChronology.LOCALE);
        r0.set(0, this.era.getValue() + 2);
        r0.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.of(r0.getActualMinimum(r4), r0.getActualMaximum(r4));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L17;
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return this.isoDate.getLong(r3);
    L9:
        return this.era.getValue();
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    L13:
        return this.yearOfEra;
    L15:
        return getDayOfYear();
    L17:
        return r3.getFrom(this);
    }

    private long getDayOfYear() {
        if (this.yearOfEra != 1) goto L7;
        return (this.isoDate.getDayOfYear() - this.era.startDate().getDayOfYear()) + 1;
    L7:
        return this.isoDate.getDayOfYear();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public JapaneseDate with(TemporalAdjuster r1) {
        return (JapaneseDate) super.with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public JapaneseDate with(TemporalField r7, long r8) {
        if ((r7 instanceof ChronoField) == false) goto L25;
        ChronoField r0 = (ChronoField) r7;
        if (getLong(r0) != r8) goto L7;
        return this;
    L7:
        int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L12;
        if (r1 == 7) goto L12;
    L17:
        return with(this.isoDate.with(r7, r8));
    L12:
        int r2 = getChronology().range(r0).checkValidIntValue(r8, r0);
        int r3 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L21;
        if (r3 != 7) goto L17;
        return withYear(JapaneseEra.of(r2), this.yearOfEra);
    L21:
        return withYear(r2);
    L23:
        return with(this.isoDate.plusDays(((long) r2) - getDayOfYear()));
    L25:
        return (JapaneseDate) r7.adjustInto(this, r8);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public JapaneseDate plus(TemporalAmount r1) {
        return (JapaneseDate) super.plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public JapaneseDate plus(long r1, TemporalUnit r3) {
        return (JapaneseDate) super.plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public JapaneseDate minus(TemporalAmount r1) {
        return (JapaneseDate) super.minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public JapaneseDate minus(long r1, TemporalUnit r3) {
        return (JapaneseDate) super.minus(r1, r3);
    }

    private JapaneseDate withYear(JapaneseEra r2, int r3) {
        int r4 = JapaneseChronology.INSTANCE.prolepticYear(r2, r3);
        return with(this.isoDate.withYear(r4));
    }

    private JapaneseDate withYear(int r2) {
        return withYear(getEra(), r2);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    JapaneseDate plusYears(long r2) {
        return with(this.isoDate.plusYears(r2));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    JapaneseDate plusMonths(long r2) {
        return with(this.isoDate.plusMonths(r2));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    JapaneseDate plusDays(long r2) {
        return with(this.isoDate.plusDays(r2));
    }

    private JapaneseDate with(LocalDate r2) {
        if (r2.equals(this.isoDate) == false) goto L6;
        return this;
    L6:
        return new JapaneseDate(r2);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<JapaneseDate> atTime(LocalTime r1) {
        return super.atTime(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate r3) {
        Period r4 = this.isoDate.until(r3);
        return getChronology().period(r4.getYears(), r4.getMonths(), r4.getDays());
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof JapaneseDate) == true) goto L8;
        return false;
    L8:
        return this.isoDate.equals(((JapaneseDate) r2).isoDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int r0 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r0;
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
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
        return JapaneseChronology.INSTANCE.date(r0, r1, r4);
    }
}
