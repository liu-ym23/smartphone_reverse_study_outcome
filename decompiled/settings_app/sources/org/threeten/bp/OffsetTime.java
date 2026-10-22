package org.threeten.bp;

import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
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

/* JADX INFO: loaded from: classes6.dex */
public final class OffsetTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<OffsetTime>, Serializable {
    public static final TemporalQuery<OffsetTime> FROM = null;
    public static final OffsetTime MAX = null;
    public static final OffsetTime MIN = null;
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;

    /* JADX INFO: renamed from: org.threeten.bp.OffsetTime$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OffsetTime r1) {
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
        MIN = LocalTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new AnonymousClass1();
    }

    public static OffsetTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static OffsetTime now(Clock r1) {
        Jdk8Methods.requireNonNull(r1, "clock");
        Instant r0 = r1.instant();
        return ofInstant(r0, r1.getZone().getRules().getOffset(r0));
    }

    public static OffsetTime of(LocalTime r1, ZoneOffset r2) {
        return new OffsetTime(r1, r2);
    }

    public static OffsetTime of(int r1, int r2, int r3, int r4, ZoneOffset r5) {
        return new OffsetTime(LocalTime.of(r1, r2, r3, r4), r5);
    }

    public static OffsetTime ofInstant(Instant r6, ZoneId r7) {
        Jdk8Methods.requireNonNull(r6, "instant");
        Jdk8Methods.requireNonNull(r7, "zone");
        ZoneOffset r8 = r7.getRules().getOffset(r6);
        long r0 = ((r6.getEpochSecond() % TimeUtils.SECONDS_PER_DAY) + ((long) r8.getTotalSeconds())) % TimeUtils.SECONDS_PER_DAY;
        if (r0 >= 0) goto L6;
        r0 = r0 + TimeUtils.SECONDS_PER_DAY;
    L6:
        return new OffsetTime(LocalTime.ofSecondOfDay(r0, r6.getNano()), r8);
    }

    public static OffsetTime from(TemporalAccessor r3) {
        if ((r3 instanceof OffsetTime) == true) goto L5;
        return new OffsetTime(LocalTime.from(r3), ZoneOffset.from(r3));
    L9:
        throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    L5:
        return (OffsetTime) r3;
    }

    public static OffsetTime parse(CharSequence r1) {
        return parse(r1, DateTimeFormatter.ISO_OFFSET_TIME);
    }

    public static OffsetTime parse(CharSequence r1, DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return (OffsetTime) r2.parse(r1, FROM);
    }

    private OffsetTime(LocalTime r2, ZoneOffset r3) {
        this.time = (LocalTime) Jdk8Methods.requireNonNull(r2, "time");
        this.offset = (ZoneOffset) Jdk8Methods.requireNonNull(r3, "offset");
    }

    private OffsetTime with(LocalTime r2, ZoneOffset r3) {
        if (this.time != r2) goto L8;
        if (this.offset.equals(r3) == false) goto L8;
        return this;
    L8:
        return new OffsetTime(r2, r3);
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
        if (r4.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r4 != ChronoField.OFFSET_SECONDS) goto L10;
        return true;
    L10:
        return false;
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
        return r2.isTimeBased();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L11;
        if (r2 != ChronoField.OFFSET_SECONDS) goto L9;
        return r2.range();
    L9:
        return this.time.range(r2);
    L11:
        return r2.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r1) {
        return super.get(r1);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L11;
        if (r2 != ChronoField.OFFSET_SECONDS) goto L9;
        return getOffset().getTotalSeconds();
    L9:
        return this.time.getLong(r2);
    L11:
        return r2.getFrom(this);
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public OffsetTime withOffsetSameLocal(ZoneOffset r2) {
        if (r2 == null) goto L7;
        if (r2.equals(this.offset) == false) goto L7;
        return this;
    L7:
        return new OffsetTime(this.time, r2);
    }

    public OffsetTime withOffsetSameInstant(ZoneOffset r3) {
        if (r3.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetTime(this.time.plusSeconds(r3.getTotalSeconds() - this.offset.getTotalSeconds()), r3);
    }

    public int getHour() {
        return this.time.getHour();
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getNano() {
        return this.time.getNano();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime with(TemporalAdjuster r2) {
        if ((r2 instanceof LocalTime) == false) goto L7;
        return with((LocalTime) r2, this.offset);
    L7:
        if ((r2 instanceof ZoneOffset) == false) goto L11;
        return with(this.time, (ZoneOffset) r2);
    L11:
        if ((r2 instanceof OffsetTime) == false) goto L15;
        return (OffsetTime) r2;
    L15:
        return (OffsetTime) r2.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime with(TemporalField r2, long r3) {
        if ((r2 instanceof ChronoField) == false) goto L11;
        if (r2 != ChronoField.OFFSET_SECONDS) goto L9;
        return with(this.time, ZoneOffset.ofTotalSeconds(((ChronoField) r2).checkValidIntValue(r3)));
    L9:
        return with(this.time.with(r2, r3), this.offset);
    L11:
        return (OffsetTime) r2.adjustInto(this, r3);
    }

    public OffsetTime withHour(int r2) {
        return with(this.time.withHour(r2), this.offset);
    }

    public OffsetTime withMinute(int r2) {
        return with(this.time.withMinute(r2), this.offset);
    }

    public OffsetTime withSecond(int r2) {
        return with(this.time.withSecond(r2), this.offset);
    }

    public OffsetTime withNano(int r2) {
        return with(this.time.withNano(r2), this.offset);
    }

    public OffsetTime truncatedTo(TemporalUnit r2) {
        return with(this.time.truncatedTo(r2), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(TemporalAmount r1) {
        return (OffsetTime) r1.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(long r2, TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == false) goto L7;
        return with(this.time.plus(r2, r4), this.offset);
    L7:
        return (OffsetTime) r4.addTo(this, r2);
    }

    public OffsetTime plusHours(long r2) {
        return with(this.time.plusHours(r2), this.offset);
    }

    public OffsetTime plusMinutes(long r2) {
        return with(this.time.plusMinutes(r2), this.offset);
    }

    public OffsetTime plusSeconds(long r2) {
        return with(this.time.plusSeconds(r2), this.offset);
    }

    public OffsetTime plusNanos(long r2) {
        return with(this.time.plusNanos(r2), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime minus(TemporalAmount r1) {
        return (OffsetTime) r1.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime minus(long r3, TemporalUnit r5) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetTime this = plus(Long.MAX_VALUE, r5);
        long r4 = 1;
    L7:
        return this.plus(r4, r5);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetTime minusHours(long r2) {
        return with(this.time.minusHours(r2), this.offset);
    }

    public OffsetTime minusMinutes(long r2) {
        return with(this.time.minusMinutes(r2), this.offset);
    }

    public OffsetTime minusSeconds(long r2) {
        return with(this.time.minusSeconds(r2), this.offset);
    }

    public OffsetTime minusNanos(long r2) {
        return with(this.time.minusNanos(r2), this.offset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r2 == TemporalQueries.offset()) goto L27;
        if (r2 == TemporalQueries.zone()) goto L27;
        if (r2 != TemporalQueries.localTime()) goto L16;
        return (R) this.time;
    L16:
        if (r2 != TemporalQueries.chronology()) goto L18;
        return null;
    L18:
        if (r2 != TemporalQueries.localDate()) goto L20;
        return null;
    L20:
        if (r2 != TemporalQueries.zoneId()) goto L23;
        return null;
    L23:
        return (R) super.query(r2);
    L27:
        return (R) getOffset();
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return r4.with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r3, TemporalUnit r4) {
        OffsetTime r5 = from(r3);
        if ((r4 instanceof ChronoUnit) == false) goto L21;
        long r0 = r5.toEpochNano() - toEpochNano();
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) r4).ordinal()]) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L22:
        return r0;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r4);
    L9:
        return r0 / 43200000000000L;
    L11:
        return r0 / 3600000000000L;
    L13:
        return r0 / 60000000000L;
    L15:
        return r0 / 1000000000;
    L17:
        return r0 / 1000000;
    L19:
        return r0 / 1000;
    L21:
        return r4.between(this, r5);
    }

    public OffsetDateTime atDate(LocalDate r2) {
        return OffsetDateTime.of(r2, this.time, this.offset);
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    private long toEpochNano() {
        return this.time.toNanoOfDay() - (((long) this.offset.getTotalSeconds()) * 1000000000);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetTime r5) {
        if (this.offset.equals(r5.offset) == true) goto L5;
        int r0 = Jdk8Methods.compareLongs(toEpochNano(), r5.toEpochNano());
        if (r0 == 0) goto L9;
        return r0;
    L9:
        return this.time.compareTo2(r5.time);
    L5:
        return this.time.compareTo2(r5.time);
    }

    public boolean isAfter(OffsetTime r3) {
        if (toEpochNano() <= r3.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(OffsetTime r3) {
        if (toEpochNano() >= r3.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(OffsetTime r3) {
        if (toEpochNano() != r3.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OffsetTime) == false) goto L14;
        OffsetTime r6 = (OffsetTime) r5;
        if (this.time.equals(r6.time) == false) goto L13;
        if (this.offset.equals(r6.offset) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.time.hashCode();
        return this.offset.hashCode() ^ r0;
    }

    public String toString() {
        return this.time.toString() + this.offset.toString();
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r2) throws IOException {
        this.time.writeExternal(r2);
        this.offset.writeExternal(r2);
    }

    static OffsetTime readExternal(DataInput r1) throws IOException {
        return of(LocalTime.readExternal(r1), ZoneOffset.readExternal(r1));
    }
}
