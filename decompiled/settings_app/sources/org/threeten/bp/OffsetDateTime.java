package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes6.dex */
public final class OffsetDateTime extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    public static final TemporalQuery<OffsetDateTime> FROM = null;
    private static final Comparator<OffsetDateTime> INSTANT_COMPARATOR = null;
    public static final OffsetDateTime MAX = null;
    public static final OffsetDateTime MIN = null;
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    /* JADX INFO: renamed from: org.threeten.bp.OffsetDateTime$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OffsetDateTime r1) {
        return compareTo2(r1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
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

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    static {
        MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new AnonymousClass1();
        INSTANT_COMPARATOR = new AnonymousClass2();
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    public static OffsetDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetDateTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static OffsetDateTime now(Clock r1) {
        Jdk8Methods.requireNonNull(r1, "clock");
        Instant r0 = r1.instant();
        return ofInstant(r0, r1.getZone().getRules().getOffset(r0));
    }

    public static OffsetDateTime of(LocalDate r0, LocalTime r1, ZoneOffset r2) {
        return new OffsetDateTime(LocalDateTime.of(r0, r1), r2);
    }

    public static OffsetDateTime of(LocalDateTime r1, ZoneOffset r2) {
        return new OffsetDateTime(r1, r2);
    }

    public static OffsetDateTime of(int r0, int r1, int r2, int r3, int r4, int r5, int r6, ZoneOffset r7) {
        return new OffsetDateTime(LocalDateTime.of(r0, r1, r2, r3, r4, r5, r6), r7);
    }

    public static OffsetDateTime ofInstant(Instant r2, ZoneId r3) {
        Jdk8Methods.requireNonNull(r2, "instant");
        Jdk8Methods.requireNonNull(r3, "zone");
        ZoneOffset r4 = r3.getRules().getOffset(r2);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(r2.getEpochSecond(), r2.getNano(), r4), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [org.threeten.bp.OffsetDateTime] */
    public static OffsetDateTime from(Object r3) {
        if ((r3 instanceof OffsetDateTime) == true) goto L5;
        ZoneOffset r0 = ZoneOffset.from(r3);     // Catch: DateTimeException -> L11
        r3 = of(LocalDateTime.from(r3), r0);     // Catch: DateTimeException -> L9
        return r3;
    L9:
        return ofInstant(Instant.from(r3), r0);
    L12:
        throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    L5:
        return (OffsetDateTime) r3;
    }

    public static OffsetDateTime parse(CharSequence r1) {
        return parse(r1, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static OffsetDateTime parse(CharSequence r1, DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return (OffsetDateTime) r2.parse(r1, FROM);
    }

    private OffsetDateTime(LocalDateTime r2, ZoneOffset r3) {
        this.dateTime = (LocalDateTime) Jdk8Methods.requireNonNull(r2, "dateTime");
        this.offset = (ZoneOffset) Jdk8Methods.requireNonNull(r3, "offset");
    }

    private OffsetDateTime with(LocalDateTime r2, ZoneOffset r3) {
        if (this.dateTime != r2) goto L8;
        if (this.offset.equals(r3) == false) goto L8;
        return this;
    L8:
        return new OffsetDateTime(r2, r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r2) {
        if ((r2 instanceof ChronoField) == true) goto L9;
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == true) goto L5;
        if (r4 == null) goto L16;
        if (r4.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r4.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r4.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L14;
        if (r2 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r2 == ChronoField.OFFSET_SECONDS) goto L12;
        return this.dateTime.range(r2);
    L12:
        return r2.range();
    L14:
        return r2.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L15;
        int r0 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return this.dateTime.get(r3);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new DateTimeException("Field too large for an int: " + r3);
    L15:
        return super.get(r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L15;
        int r0 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return this.dateTime.getLong(r3);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r3.getFrom(this);
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset r2) {
        return with(this.dateTime, r2);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset r3) {
        if (r3.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetDateTime(this.dateTime.plusSeconds(r3.getTotalSeconds() - this.offset.getTotalSeconds()), r3);
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalAdjuster r2) {
        if ((r2 instanceof LocalDate) == true) goto L24;
        if ((r2 instanceof LocalTime) == true) goto L24;
        if ((r2 instanceof LocalDateTime) == true) goto L24;
        if ((r2 instanceof Instant) == false) goto L14;
        return ofInstant((Instant) r2, this.offset);
    L14:
        if ((r2 instanceof ZoneOffset) == false) goto L18;
        return with(this.dateTime, (ZoneOffset) r2);
    L18:
        if ((r2 instanceof OffsetDateTime) == false) goto L22;
        return (OffsetDateTime) r2;
    L22:
        return (OffsetDateTime) r2.adjustInto(this);
    L24:
        return with(this.dateTime.with(r2), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalField r4, long r5) {
        if ((r4 instanceof ChronoField) == false) goto L15;
        ChronoField r0 = (ChronoField) r4;
        int r1 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L11;
        return with(this.dateTime.with(r4, r5), this.offset);
    L11:
        return with(this.dateTime, ZoneOffset.ofTotalSeconds(r0.checkValidIntValue(r5)));
    L13:
        return ofInstant(Instant.ofEpochSecond(r5, getNano()), this.offset);
    L15:
        return (OffsetDateTime) r4.adjustInto(this, r5);
    }

    public OffsetDateTime withYear(int r2) {
        return with(this.dateTime.withYear(r2), this.offset);
    }

    public OffsetDateTime withMonth(int r2) {
        return with(this.dateTime.withMonth(r2), this.offset);
    }

    public OffsetDateTime withDayOfMonth(int r2) {
        return with(this.dateTime.withDayOfMonth(r2), this.offset);
    }

    public OffsetDateTime withDayOfYear(int r2) {
        return with(this.dateTime.withDayOfYear(r2), this.offset);
    }

    public OffsetDateTime withHour(int r2) {
        return with(this.dateTime.withHour(r2), this.offset);
    }

    public OffsetDateTime withMinute(int r2) {
        return with(this.dateTime.withMinute(r2), this.offset);
    }

    public OffsetDateTime withSecond(int r2) {
        return with(this.dateTime.withSecond(r2), this.offset);
    }

    public OffsetDateTime withNano(int r2) {
        return with(this.dateTime.withNano(r2), this.offset);
    }

    public OffsetDateTime truncatedTo(TemporalUnit r2) {
        return with(this.dateTime.truncatedTo(r2), this.offset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(TemporalAmount r1) {
        return (OffsetDateTime) r1.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(long r2, TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == false) goto L7;
        return with(this.dateTime.plus(r2, r4), this.offset);
    L7:
        return (OffsetDateTime) r4.addTo(this, r2);
    }

    public OffsetDateTime plusYears(long r2) {
        return with(this.dateTime.plusYears(r2), this.offset);
    }

    public OffsetDateTime plusMonths(long r2) {
        return with(this.dateTime.plusMonths(r2), this.offset);
    }

    public OffsetDateTime plusWeeks(long r2) {
        return with(this.dateTime.plusWeeks(r2), this.offset);
    }

    public OffsetDateTime plusDays(long r2) {
        return with(this.dateTime.plusDays(r2), this.offset);
    }

    public OffsetDateTime plusHours(long r2) {
        return with(this.dateTime.plusHours(r2), this.offset);
    }

    public OffsetDateTime plusMinutes(long r2) {
        return with(this.dateTime.plusMinutes(r2), this.offset);
    }

    public OffsetDateTime plusSeconds(long r2) {
        return with(this.dateTime.plusSeconds(r2), this.offset);
    }

    public OffsetDateTime plusNanos(long r2) {
        return with(this.dateTime.plusNanos(r2), this.offset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(TemporalAmount r1) {
        return (OffsetDateTime) r1.subtractFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(long r3, TemporalUnit r5) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plus(Long.MAX_VALUE, r5);
        long r4 = 1;
    L7:
        return this.plus(r4, r5);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusWeeks(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusWeeks(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusWeeks(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusHours(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusHours(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusHours(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusMinutes(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusMinutes(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMinutes(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusSeconds(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusSeconds(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusSeconds(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetDateTime minusNanos(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetDateTime this = plusNanos(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusNanos(r4);
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
        return (R) ChronoUnit.NANOS;
    L11:
        if (r2 == TemporalQueries.offset()) goto L30;
        if (r2 == TemporalQueries.zone()) goto L30;
        if (r2 != TemporalQueries.localDate()) goto L20;
        return (R) toLocalDate();
    L20:
        if (r2 != TemporalQueries.localTime()) goto L24;
        return (R) toLocalTime();
    L24:
        if (r2 != TemporalQueries.zoneId()) goto L28;
        return null;
    L28:
        return (R) super.query(r2);
    L30:
        return (R) getOffset();
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return r4.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r2, TemporalUnit r3) {
        OffsetDateTime r4 = from(r2);
        if ((r3 instanceof ChronoUnit) == false) goto L7;
        OffsetDateTime r5 = r4.withOffsetSameInstant(this.offset);
        return this.dateTime.until(r5.dateTime, r3);
    L7:
        return r3.between(this, r4);
    }

    public ZonedDateTime atZoneSameInstant(ZoneId r2) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, r2);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId r2) {
        return ZonedDateTime.ofLocal(this.dateTime, r2, this.offset);
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetTime toOffsetTime() {
        return OffsetTime.of(this.dateTime.toLocalTime(), this.offset);
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.of(this.dateTime, this.offset);
    }

    public Instant toInstant() {
        return this.dateTime.toInstant(this.offset);
    }

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetDateTime r5) {
        if (getOffset().equals(r5.getOffset()) == true) goto L5;
        int r0 = Jdk8Methods.compareLongs(toEpochSecond(), r5.toEpochSecond());
        if (r0 != 0) goto L12;
        int r1 = toLocalTime().getNano() - r5.toLocalTime().getNano();
        if (r1 == 0) goto L11;
        return r1;
    L11:
        return toLocalDateTime().compareTo(r5.toLocalDateTime());
    L12:
        return r0;
    L5:
        return toLocalDateTime().compareTo(r5.toLocalDateTime());
    }

    public boolean isAfter(OffsetDateTime r5) {
        long r0 = toEpochSecond();
        long r2 = r5.toEpochSecond();
        if (r0 > r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(OffsetDateTime r5) {
        long r0 = toEpochSecond();
        long r2 = r5.toEpochSecond();
        if (r0 < r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() >= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(OffsetDateTime r5) {
        if (toEpochSecond() == r5.toEpochSecond()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalTime().getNano() != r5.toLocalTime().getNano()) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OffsetDateTime) == false) goto L14;
        OffsetDateTime r6 = (OffsetDateTime) r5;
        if (this.dateTime.equals(r6.dateTime) == false) goto L13;
        if (this.offset.equals(r6.offset) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.dateTime.hashCode();
        return this.offset.hashCode() ^ r0;
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.toString();
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r2) throws IOException {
        this.dateTime.writeExternal(r2);
        this.offset.writeExternal(r2);
    }

    static OffsetDateTime readExternal(DataInput r1) throws IOException {
        return of(LocalDateTime.readExternal(r1), ZoneOffset.readExternal(r1));
    }
}
