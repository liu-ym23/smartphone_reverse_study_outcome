package org.threeten.bp.chrono;

import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
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

/* JADX INFO: loaded from: classes6.dex */
public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    private static final Comparator<ChronoLocalDateTime<?>> DATE_TIME_COMPARATOR = null;

    public abstract ChronoZonedDateTime<D> atZone(ZoneId r1);

    public abstract ChronoLocalDateTime<D> plus(long r1, TemporalUnit r3);

    public abstract D toLocalDate();

    public abstract LocalTime toLocalTime();

    public abstract ChronoLocalDateTime<D> with(TemporalField r1, long r2);

    public ChronoLocalDateTime() {
    }

    public /* bridge */ /* synthetic */ int compareTo(Object r1) {
        return compareTo((ChronoLocalDateTime) r1);
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

    public static Comparator<ChronoLocalDateTime<?>> timeLineOrder() {
        return DATE_TIME_COMPARATOR;
    }

    static {
        DATE_TIME_COMPARATOR = new AnonymousClass1();
    }

    public static ChronoLocalDateTime<?> from(TemporalAccessor r3) {
        Jdk8Methods.requireNonNull(r3, "temporal");
        if ((r3 instanceof ChronoLocalDateTime) == true) goto L5;
        Chronology r0 = (Chronology) r3.query(TemporalQueries.chronology());
        if (r0 == null) goto L11;
        return r0.localDateTime(r3);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + r3.getClass());
    L5:
        return (ChronoLocalDateTime) r3;
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> with(TemporalAdjuster r2) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.with(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> plus(TemporalAmount r2) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.plus(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> minus(TemporalAmount r2) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> minus(long r2, TemporalUnit r4) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r2, r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.chronology()) goto L7;
        return (R) getChronology();
    L7:
        if (r2 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r2 != TemporalQueries.localDate()) goto L15;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L15:
        if (r2 != TemporalQueries.localTime()) goto L19;
        return (R) toLocalTime();
    L19:
        if (r2 != TemporalQueries.zone()) goto L21;
        return null;
    L21:
        if (r2 != TemporalQueries.zoneId()) goto L23;
        return null;
    L23:
        if (r2 != TemporalQueries.offset()) goto L26;
        return null;
    L26:
        return (R) super.query(r2);
    }

    public Temporal adjustInto(Temporal r4) {
        return r4.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    public Instant toInstant(ZoneOffset r3) {
        return Instant.ofEpochSecond(toEpochSecond(r3), toLocalTime().getNano());
    }

    public long toEpochSecond(ZoneOffset r5) {
        Jdk8Methods.requireNonNull(r5, "offset");
        return ((toLocalDate().toEpochDay() * TimeUtils.SECONDS_PER_DAY) + ((long) toLocalTime().toSecondOfDay())) - ((long) r5.getTotalSeconds());
    }

    public int compareTo(ChronoLocalDateTime<?> r3) {
        int r0 = toLocalDate().compareTo(r3.toLocalDate());
        if (r0 != 0) goto L8;
        int r1 = toLocalTime().compareTo2(r3.toLocalTime());
        if (r1 == 0) goto L7;
        return r1;
    L7:
        return getChronology().compareTo2(r3.getChronology());
    L8:
        return r0;
    }

    public boolean isAfter(ChronoLocalDateTime<?> r5) {
        long r0 = toLocalDate().toEpochDay();
        long r2 = r5.toLocalDate().toEpochDay();
        if (r0 > r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() <= r5.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(ChronoLocalDateTime<?> r5) {
        long r0 = toLocalDate().toEpochDay();
        long r2 = r5.toLocalDate().toEpochDay();
        if (r0 < r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() >= r5.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(ChronoLocalDateTime<?> r5) {
        if (toLocalTime().toNanoOfDay() == r5.toLocalTime().toNanoOfDay()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalDate().toEpochDay() != r5.toLocalDate().toEpochDay()) goto L7;
        return true;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ChronoLocalDateTime) == true) goto L8;
        return false;
    L8:
        if (compareTo((ChronoLocalDateTime) r4) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        int r0 = toLocalDate().hashCode();
        return toLocalTime().hashCode() ^ r0;
    }

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }
}
