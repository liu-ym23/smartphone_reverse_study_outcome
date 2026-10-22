package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {
    public static final TemporalQuery<MonthDay> FROM = null;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    /* JADX INFO: renamed from: org.threeten.bp.MonthDay$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MonthDay r1) {
        return compareTo2(r1);
    }

    static {
        FROM = new AnonymousClass1();
        PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    }

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static MonthDay now(Clock r1) {
        LocalDate r2 = LocalDate.now(r1);
        return of(r2.getMonth(), r2.getDayOfMonth());
    }

    public static MonthDay of(Month r3, int r4) {
        Jdk8Methods.requireNonNull(r3, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r4);
        if (r4 > r3.maxLength()) goto L7;
        return new MonthDay(r3.getValue(), r4);
    L7:
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + r4 + " is not valid for month " + r3.name());
    }

    public static MonthDay of(int r0, int r1) {
        return of(Month.of(r0), r1);
    }

    public static MonthDay from(TemporalAccessor r3) {
        if ((r3 instanceof MonthDay) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(Chronology.from(r3)) == true) goto L9;
        r3 = LocalDate.from(r3);     // Catch: DateTimeException -> L11
    L9:
        return of(r3.get(ChronoField.MONTH_OF_YEAR), r3.get(ChronoField.DAY_OF_MONTH));
    L12:
        throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    L5:
        return (MonthDay) r3;
    }

    public static MonthDay parse(CharSequence r1) {
        return parse(r1, PARSER);
    }

    public static MonthDay parse(CharSequence r1, DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return (MonthDay) r2.parse(r1, FROM);
    }

    private MonthDay(int r1, int r2) {
        this.month = r1;
        this.day = r2;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        if ((r4 instanceof ChronoField) == true) goto L5;
        if (r4 == null) goto L16;
        if (r4.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r4 != ChronoField.MONTH_OF_YEAR) goto L7;
        return true;
    L7:
        if (r4 != ChronoField.DAY_OF_MONTH) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r8) {
        if (r8 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r8.range();
    L7:
        if (r8 != ChronoField.DAY_OF_MONTH) goto L11;
        return ValueRange.of(1, getMonth().minLength(), getMonth().maxLength());
    L11:
        return super.range(r8);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        return range(r4).checkValidIntValue(getLong(r4), r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()];
        if (r0 != 1) goto L7;
        int r2 = this.day;
    L10:
        return r2;
    L7:
        if (r0 != 2) goto L12;
        r2 = this.month;
        goto L10
    L12:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    L15:
        return r3.getFrom(this);
    }

    public int getMonthValue() {
        return this.month;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public boolean isValidYear(int r4) {
        if (this.day == 29) goto L5;
    L9:
        boolean r3 = false;
    L11:
        return !r3;
    L5:
        if (this.month != 2) goto L9;
        if (Year.isLeap(r4) == true) goto L9;
        r3 = true;
        goto L11
    }

    public MonthDay withMonth(int r1) {
        return with(Month.of(r1));
    }

    public MonthDay with(Month r3) {
        Jdk8Methods.requireNonNull(r3, "month");
        if (r3.getValue() != this.month) goto L5;
        return this;
    L5:
        int r2 = Math.min(this.day, r3.maxLength());
        return new MonthDay(r3.getValue(), r2);
    }

    public MonthDay withDayOfMonth(int r2) {
        if (r2 != this.day) goto L6;
        return this;
    L6:
        return of(this.month, r2);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        return (R) super.query(r2);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r6) {
        if (Chronology.from(r6).equals(IsoChronology.INSTANCE) == false) goto L7;
        Temporal r7 = r6.with(ChronoField.MONTH_OF_YEAR, this.month);
        return r7.with(ChronoField.DAY_OF_MONTH, Math.min(r7.range(ChronoField.DAY_OF_MONTH).getMaximum(), this.day));
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atYear(int r3) {
        int r0 = this.month;
        if (isValidYear(r3) == false) goto L5;
        int r2 = this.day;
    L7:
        return LocalDate.of(r3, r0, r2);
    L5:
        r2 = 28;
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MonthDay r3) {
        int r0 = this.month - r3.month;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.day - r3.day;
    }

    public boolean isAfter(MonthDay r1) {
        if (compareTo2(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(MonthDay r1) {
        if (compareTo2(r1) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MonthDay) == false) goto L14;
        MonthDay r6 = (MonthDay) r5;
        if (this.month != r6.month) goto L13;
        if (this.day != r6.day) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(10).append("--");
        if (this.month >= 10) goto L5;
        String r2 = "0";
    L6:
        StringBuilder r1 = r0.append(r2).append(this.month);
        if (this.day >= 10) goto L9;
        String r3 = "-0";
    L11:
        return r1.append(r3).append(this.day).toString();
    L9:
        r3 = "-";
        goto L11
    L5:
        r2 = "";
        goto L6
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r2) throws IOException {
        r2.writeByte(this.month);
        r2.writeByte(this.day);
    }

    static MonthDay readExternal(DataInput r1) throws IOException {
        return of(r1.readByte(), r1.readByte());
    }
}
