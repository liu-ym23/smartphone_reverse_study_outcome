package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {
    private static final Comparator<ChronoLocalDate> DATE_COMPARATOR = null;

    public abstract Chronology getChronology();

    public abstract int lengthOfMonth();

    public abstract ChronoLocalDate plus(long r1, TemporalUnit r3);

    public abstract ChronoPeriod until(ChronoLocalDate r1);

    public abstract ChronoLocalDate with(TemporalField r1, long r2);

    public ChronoLocalDate() {
    }

    public /* bridge */ /* synthetic */ int compareTo(Object r1) {
        return compareTo((ChronoLocalDate) r1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    public static Comparator<ChronoLocalDate> timeLineOrder() {
        return DATE_COMPARATOR;
    }

    static {
        DATE_COMPARATOR = new AnonymousClass1();
    }

    public static ChronoLocalDate from(TemporalAccessor r3) {
        Jdk8Methods.requireNonNull(r3, "temporal");
        if ((r3 instanceof ChronoLocalDate) == true) goto L5;
        Chronology r0 = (Chronology) r3.query(TemporalQueries.chronology());
        if (r0 == null) goto L11;
        return r0.date(r3);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + r3.getClass());
    L5:
        return (ChronoLocalDate) r3;
    }

    public Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r2) {
        if ((r2 instanceof ChronoField) == true) goto L5;
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r2.isDateBased();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r2) {
        if ((r2 instanceof ChronoUnit) == true) goto L5;
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r2.isDateBased();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDate with(TemporalAdjuster r2) {
        return getChronology().ensureChronoLocalDate(super.with(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDate plus(TemporalAmount r2) {
        return getChronology().ensureChronoLocalDate(super.plus(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDate minus(TemporalAmount r2) {
        return getChronology().ensureChronoLocalDate(super.minus(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDate minus(long r2, TemporalUnit r4) {
        return getChronology().ensureChronoLocalDate(super.minus(r2, r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.chronology()) goto L7;
        return (R) getChronology();
    L7:
        if (r2 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.DAYS;
    L11:
        if (r2 != TemporalQueries.localDate()) goto L15;
        return (R) LocalDate.ofEpochDay(toEpochDay());
    L15:
        if (r2 != TemporalQueries.localTime()) goto L17;
        return null;
    L17:
        if (r2 != TemporalQueries.zone()) goto L19;
        return null;
    L19:
        if (r2 != TemporalQueries.zoneId()) goto L21;
        return null;
    L21:
        if (r2 != TemporalQueries.offset()) goto L24;
        return null;
    L24:
        return (R) super.query(r2);
    }

    public Temporal adjustInto(Temporal r4) {
        return r4.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    public ChronoLocalDateTime<?> atTime(LocalTime r1) {
        return ChronoLocalDateTimeImpl.of(this, r1);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public int compareTo(ChronoLocalDate r5) {
        int r0 = Jdk8Methods.compareLongs(toEpochDay(), r5.toEpochDay());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return getChronology().compareTo2(r5.getChronology());
    }

    public boolean isAfter(ChronoLocalDate r3) {
        if (toEpochDay() <= r3.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(ChronoLocalDate r3) {
        if (toEpochDay() >= r3.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(ChronoLocalDate r3) {
        if (toEpochDay() != r3.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ChronoLocalDate) == true) goto L8;
        return false;
    L8:
        if (compareTo((ChronoLocalDate) r4) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        long r0 = toEpochDay();
        return getChronology().hashCode() ^ ((int) (r0 ^ (r0 >>> 32)));
    }

    public String toString() {
        long r0 = getLong(ChronoField.YEAR_OF_ERA);
        long r2 = getLong(ChronoField.MONTH_OF_YEAR);
        long r4 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder r6 = new StringBuilder(30);
        StringBuilder r10 = r6.append(getChronology().toString()).append(" ").append(getEra()).append(" ").append(r0);
        String r8 = "-0";
        if (r2 >= 10) goto L5;
        String r7 = "-0";
    L6:
        StringBuilder r11 = r10.append(r7).append(r2);
        if (r4 < 10) goto L10;
        r8 = "-";
    L10:
        r11.append(r8).append(r4);
        return r6.toString();
    L5:
        r7 = "-";
        goto L6
    }
}
