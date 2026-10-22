package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes6.dex */
final class ChronoPeriodImpl extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final Chronology chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(Chronology r1, int r2, int r3, int r4) {
        this.chronology = r1;
        this.years = r2;
        this.months = r3;
        this.days = r4;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit r3) {
        if (r3 != ChronoUnit.YEARS) goto L8;
        int r2 = this.years;
    L6:
        return r2;
    L8:
        if (r3 != ChronoUnit.MONTHS) goto L11;
        r2 = this.months;
        goto L6
    L11:
        if (r3 != ChronoUnit.DAYS) goto L14;
        r2 = this.days;
        goto L6
    L14:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r3);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Chronology getChronology() {
        return this.chronology;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod plus(TemporalAmount r6) {
        if ((r6 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r0 = (ChronoPeriodImpl) r6;
        if (r0.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeAdd(this.years, r0.years), Jdk8Methods.safeAdd(this.months, r0.months), Jdk8Methods.safeAdd(this.days, r0.days));
    L9:
        throw new DateTimeException("Unable to add amount: " + r6);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod minus(TemporalAmount r6) {
        if ((r6 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r0 = (ChronoPeriodImpl) r6;
        if (r0.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeSubtract(this.years, r0.years), Jdk8Methods.safeSubtract(this.months, r0.months), Jdk8Methods.safeSubtract(this.days, r0.days));
    L9:
        throw new DateTimeException("Unable to subtract amount: " + r6);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod multipliedBy(int r5) {
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeMultiply(this.years, r5), Jdk8Methods.safeMultiply(this.months, r5), Jdk8Methods.safeMultiply(this.days, r5));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod normalized() {
        if (this.chronology.range(ChronoField.MONTH_OF_YEAR).isFixed() == false) goto L6;
        long r0 = (this.chronology.range(ChronoField.MONTH_OF_YEAR).getMaximum() - this.chronology.range(ChronoField.MONTH_OF_YEAR).getMinimum()) + 1;
        long r2 = (((long) this.years) * r0) + ((long) this.months);
        int r4 = Jdk8Methods.safeToInt(r2 / r0);
        int r1 = Jdk8Methods.safeToInt(r2 % r0);
        return new ChronoPeriodImpl(this.chronology, r4, r1, this.days);
    L6:
        return this;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal r4) {
        Jdk8Methods.requireNonNull(r4, "temporal");
        Chronology r0 = (Chronology) r4.query(TemporalQueries.chronology());
        if (r0 != null) goto L5;
    L9:
        int r1 = this.years;
        if (r1 == 0) goto L12;
        r4 = r4.plus(r1, ChronoUnit.YEARS);
    L12:
        int r2 = this.months;
        if (r2 == 0) goto L15;
        r4 = r4.plus(r2, ChronoUnit.MONTHS);
    L15:
        int r3 = this.days;
        if (r3 != 0) goto L18;
        return r4;
    L18:
        return r4.plus(r3, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r0) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r0.getId());
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal r4) {
        Jdk8Methods.requireNonNull(r4, "temporal");
        Chronology r0 = (Chronology) r4.query(TemporalQueries.chronology());
        if (r0 != null) goto L5;
    L9:
        int r1 = this.years;
        if (r1 == 0) goto L12;
        r4 = r4.minus(r1, ChronoUnit.YEARS);
    L12:
        int r2 = this.months;
        if (r2 == 0) goto L15;
        r4 = r4.minus(r2, ChronoUnit.MONTHS);
    L15:
        int r3 = this.days;
        if (r3 != 0) goto L18;
        return r4;
    L18:
        return r4.minus(r3, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r0) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r0.getId());
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChronoPeriodImpl) == false) goto L18;
        ChronoPeriodImpl r6 = (ChronoPeriodImpl) r5;
        if (this.years != r6.years) goto L17;
        if (this.months != r6.months) goto L17;
        if (this.days != r6.days) goto L17;
        if (this.chronology.equals(r6.chronology) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public int hashCode() {
        return ((this.chronology.hashCode() + Integer.rotateLeft(this.years, 16)) + Integer.rotateLeft(this.months, 8)) + this.days;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public String toString() {
        if (isZero() == true) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.chronology).append(" P");
        int r1 = this.years;
        if (r1 == 0) goto L9;
        r0.append(r1).append('Y');
    L9:
        int r2 = this.months;
        if (r2 == 0) goto L12;
        r0.append(r2).append('M');
    L12:
        int r3 = this.days;
        if (r3 == 0) goto L16;
        r0.append(r3).append('D');
    L16:
        return r0.toString();
    L5:
        return this.chronology + " P0D";
    }
}
