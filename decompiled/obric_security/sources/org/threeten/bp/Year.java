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
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public static final TemporalQuery<Year> FROM = null;
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    /* JADX INFO: renamed from: org.threeten.bp.Year$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L23:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L37:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L25:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r3 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r3;
            r3[ChronoField.YEAR_OF_ERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Year r1) {
        return compareTo2(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    static {
        FROM = new AnonymousClass1();
        PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    }

    public static Year now() {
        return now(Clock.systemDefaultZone());
    }

    public static Year now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static Year now(Clock r0) {
        return of(LocalDate.now(r0).getYear());
    }

    public static Year of(int r3) {
        ChronoField.YEAR.checkValidValue(r3);
        return new Year(r3);
    }

    public static Year from(TemporalAccessor r3) {
        if ((r3 instanceof Year) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(Chronology.from(r3)) == true) goto L9;
        r3 = LocalDate.from(r3);     // Catch: DateTimeException -> L11
    L9:
        return of(r3.get(ChronoField.YEAR));
    L12:
        throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    L5:
        return (Year) r3;
    }

    public static Year parse(CharSequence r1) {
        return parse(r1, PARSER);
    }

    public static Year parse(CharSequence r1, DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return (Year) r2.parse(r1, FROM);
    }

    public static boolean isLeap(long r4) {
        if ((3 & r4) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r4 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r4 % 400) != 0) goto L9;
        goto L8
    }

    private Year(int r1) {
        this.year = r1;
    }

    public int getValue() {
        return this.year;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        if ((r4 instanceof ChronoField) == true) goto L5;
        if (r4 == null) goto L18;
        if (r4.isSupportedBy(this) == false) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r4 != ChronoField.YEAR) goto L7;
        return true;
    L7:
        if (r4 != ChronoField.YEAR_OF_ERA) goto L9;
        return true;
    L9:
        if (r4 != ChronoField.ERA) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == true) goto L5;
        if (r4 == null) goto L22;
        if (r4.isSupportedBy(this) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        if (r4 != ChronoUnit.YEARS) goto L7;
        return true;
    L7:
        if (r4 != ChronoUnit.DECADES) goto L9;
        return true;
    L9:
        if (r4 != ChronoUnit.CENTURIES) goto L11;
        return true;
    L11:
        if (r4 != ChronoUnit.MILLENNIA) goto L13;
        return true;
    L13:
        if (r4 != ChronoUnit.ERAS) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        if (r3 != ChronoField.YEAR_OF_ERA) goto L11;
        if (this.year > 0) goto L7;
        long r2 = 1000000000;
    L9:
        return ValueRange.of(1, r2);
    L7:
        r2 = 999999999;
        goto L9
    L11:
        return super.range(r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        return range(r4).checkValidIntValue(getLong(r4), r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        if ((r4 instanceof ChronoField) == false) goto L25;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r4).ordinal()];
        int r1 = 1;
        if (r0 != 1) goto L7;
        int r3 = this.year;
        if (r3 >= 1) goto L23;
        r3 = 1 - r3;
    L23:
        return r3;
    L7:
        if (r0 == 2) goto L18;
        if (r0 != 3) goto L16;
        if (this.year >= 1) goto L14;
        r1 = 0;
    L14:
        return r1;
    L16:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    L18:
        return this.year;
    L25:
        return r4.getFrom(this);
    }

    public boolean isLeap() {
        return isLeap(this.year);
    }

    public boolean isValidMonthDay(MonthDay r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.isValidYear(this.year) == false) goto L6;
        return true;
    }

    public int length() {
        if (isLeap() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalAdjuster r1) {
        return (Year) r1.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalField r5, long r6) {
        if ((r5 instanceof ChronoField) == false) goto L25;
        ChronoField r0 = (ChronoField) r5;
        r0.checkValidValue(r6);
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 != 3) goto L16;
        if (getLong(ChronoField.ERA) != r6) goto L14;
        return this;
    L14:
        return of(1 - this.year);
    L16:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L18:
        return of((int) r6);
    L20:
        if (this.year >= 1) goto L23;
        r6 = 1 - r6;
    L23:
        return of((int) r6);
    L25:
        return (Year) r5.adjustInto(this, r6);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(TemporalAmount r1) {
        return (Year) r1.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(long r3, TemporalUnit r5) {
        if ((r5 instanceof ChronoUnit) == false) goto L27;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) r5).ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L21;
        if (r0 == 4) goto L19;
        if (r0 != 5) goto L17;
        return with(ChronoField.ERA, Jdk8Methods.safeAdd(getLong(ChronoField.ERA), r3));
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r5);
    L19:
        return plusYears(Jdk8Methods.safeMultiply(r3, 1000));
    L21:
        return plusYears(Jdk8Methods.safeMultiply(r3, 100));
    L23:
        return plusYears(Jdk8Methods.safeMultiply(r3, 10));
    L25:
        return plusYears(r3);
    L27:
        return (Year) r5.addTo(this, r3);
    }

    public Year plusYears(long r4) {
        if (r4 != 0) goto L6;
        return this;
    L6:
        return of(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r4));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(TemporalAmount r1) {
        return (Year) r1.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(long r3, TemporalUnit r5) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Year this = plus(Long.MAX_VALUE, r5);
        long r4 = 1;
    L7:
        return this.plus(r4, r5);
    L5:
        r4 = -r3;
        goto L7
    }

    public Year minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Year this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r2 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.YEARS;
    L11:
        if (r2 != TemporalQueries.localDate()) goto L13;
        return null;
    L13:
        if (r2 != TemporalQueries.localTime()) goto L15;
        return null;
    L15:
        if (r2 != TemporalQueries.zone()) goto L17;
        return null;
    L17:
        if (r2 != TemporalQueries.zoneId()) goto L19;
        return null;
    L19:
        if (r2 != TemporalQueries.offset()) goto L22;
        return null;
    L22:
        return (R) super.query(r2);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        if (Chronology.from(r4).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r4.with(ChronoField.YEAR, this.year);
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r5, TemporalUnit r6) {
        Year r7 = from(r5);
        if ((r6 instanceof ChronoUnit) == false) goto L25;
        long r0 = ((long) r7.year) - ((long) this.year);
        int r2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) r6).ordinal()];
        if (r2 != 1) goto L7;
        return r0;
    L7:
        if (r2 == 2) goto L23;
        if (r2 == 3) goto L21;
        if (r2 == 4) goto L19;
        if (r2 != 5) goto L17;
        return r7.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r6);
    L19:
        return r0 / 1000;
    L21:
        return r0 / 100;
    L23:
        return r0 / 10;
    L25:
        return r6.between(this, r7);
    }

    public LocalDate atDay(int r1) {
        return LocalDate.ofYearDay(this.year, r1);
    }

    public YearMonth atMonth(Month r1) {
        return YearMonth.of(this.year, r1);
    }

    public YearMonth atMonth(int r1) {
        return YearMonth.of(this.year, r1);
    }

    public LocalDate atMonthDay(MonthDay r1) {
        return r1.atYear(this.year);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Year r1) {
        return this.year - r1.year;
    }

    public boolean isAfter(Year r1) {
        if (this.year <= r1.year) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Year r1) {
        if (this.year >= r1.year) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Year) == true) goto L8;
        return false;
    L8:
        if (this.year != ((Year) r4).year) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return this.year;
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r1) throws IOException {
        r1.writeInt(this.year);
    }

    static Year readExternal(DataInput r0) throws IOException {
        return of(r0.readInt());
    }
}
