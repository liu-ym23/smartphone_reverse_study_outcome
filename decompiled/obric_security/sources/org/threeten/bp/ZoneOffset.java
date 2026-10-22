package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
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
import org.threeten.bp.zone.ZoneRules;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    public static final TemporalQuery<ZoneOffset> FROM = null;
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = null;
    public static final ZoneOffset MAX = null;
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MIN = null;
    private static final int MINUTES_PER_HOUR = 60;
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = null;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    public static final ZoneOffset UTC = null;
    private static final long serialVersionUID = 2357656521762053153L;
    private final transient String id;
    private final int totalSeconds;

    private static int totalSeconds(int r0, int r1, int r2) {
        return ((r0 * SECONDS_PER_HOUR) + (r1 * 60)) + r2;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffset r1) {
        return compareTo2(r1);
    }

    static {
        FROM = new AnonymousClass1();
        SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
        ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
        UTC = ofTotalSeconds(0);
        MIN = ofTotalSeconds(-64800);
        MAX = ofTotalSeconds(MAX_SECONDS);
    }

    public static ZoneOffset of(String r7) {
        Jdk8Methods.requireNonNull(r7, "offsetId");
        ZoneOffset r0 = ID_CACHE.get(r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = r7.length();
        if (r1 != 2) goto L8;
        r7 = r7.charAt(0) + "0" + r7.charAt(1);
    L25:
        int r2 = parseNumber(r7, 1, false);
        int r3 = 0;
        int r4 = 0;
    L26:
        char r5 = r7.charAt(0);
        if (r5 == '+') goto L32;
        if (r5 == '-') goto L32;
        throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: " + r7);
    L32:
        if (r5 != '-') goto L36;
        return ofHoursMinutesSeconds(-r2, -r3, -r4);
    L36:
        return ofHoursMinutesSeconds(r2, r3, r4);
    L8:
        if (r1 == 3) goto L25;
        if (r1 != 5) goto L12;
        r2 = parseNumber(r7, 1, false);
        r3 = parseNumber(r7, 3, false);
    L23:
        r4 = 0;
        goto L26
    L12:
        if (r1 != 6) goto L14;
        r2 = parseNumber(r7, 1, false);
        r3 = parseNumber(r7, 4, true);
        goto L23
    L14:
        if (r1 != 7) goto L16;
        r2 = parseNumber(r7, 1, false);
        r3 = parseNumber(r7, 3, false);
        r4 = parseNumber(r7, 5, false);
        goto L26
    L16:
        if (r1 != 9) goto L19;
        r2 = parseNumber(r7, 1, false);
        r3 = parseNumber(r7, 4, true);
        r4 = parseNumber(r7, 7, true);
        goto L26
    L19:
        throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: " + r7);
    }

    private static int parseNumber(CharSequence r2, int r3, boolean r4) {
        if (r4 == true) goto L4;
    L8:
        char r5 = r2.charAt(r3);
        char r6 = r2.charAt(r3 + 1);
        if (r5 < '0') goto L17;
        if (r5 > '9') goto L17;
        if (r6 < '0') goto L17;
        if (r6 > '9') goto L17;
        return ((r5 - DeepCleanSAFEngine.DetailPath.KEY) * 10) + (r6 - DeepCleanSAFEngine.DetailPath.KEY);
    L17:
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + r2);
    L4:
        if (r2.charAt(r3 - 1) == ':') goto L8;
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + r2);
    }

    public static ZoneOffset ofHours(int r1) {
        return ofHoursMinutesSeconds(r1, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int r1, int r2) {
        return ofHoursMinutesSeconds(r1, r2, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int r0, int r1, int r2) {
        validate(r0, r1, r2);
        return ofTotalSeconds(totalSeconds(r0, r1, r2));
    }

    public static ZoneOffset from(TemporalAccessor r3) {
        ZoneOffset r0 = (ZoneOffset) r3.query(TemporalQueries.offset());
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    }

    private static void validate(int r4, int r5, int r6) {
        if (r4 < (-18)) goto L44;
        if (r4 > 18) goto L44;
        if (r4 <= 0) goto L12;
        if (r5 < 0) goto L11;
        if (r6 < 0) goto L11;
    L26:
        if (Math.abs(r5) > 59) goto L42;
        if (Math.abs(r6) > 59) goto L40;
        if (Math.abs(r4) == 18) goto L32;
        return;
    L32:
        if (Math.abs(r5) > 0) goto L37;
        if (Math.abs(r6) > 0) goto L37;
        return;
    L37:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    L40:
        throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(r6) + " is not in the range 0 to 59");
    L42:
        throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(r5) + " is not in the range 0 to 59");
    L11:
        throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
    L12:
        if (r4 >= 0) goto L18;
        if (r5 > 0) goto L17;
        if (r6 <= 0) goto L26;
    L17:
        throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
    L18:
        if (r5 <= 0) goto L20;
        if (r6 >= 0) goto L20;
    L24:
        throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
    L20:
        if (r5 >= 0) goto L26;
        if (r6 > 0) goto L24;
    L44:
        throw new DateTimeException("Zone offset hours not in valid range: value " + r4 + " is not in the range -18 to 18");
    }

    public static ZoneOffset ofTotalSeconds(int r3) {
        if (Math.abs(r3) > MAX_SECONDS) goto L13;
        if ((r3 % 900) != 0) goto L11;
        Integer r0 = Integer.valueOf(r3);
        ConcurrentMap<Integer, ZoneOffset> r1 = SECONDS_CACHE;
        ZoneOffset r2 = r1.get(r0);
        if (r2 != null) goto L14;
        r1.putIfAbsent(r0, new ZoneOffset(r3));
        ZoneOffset r4 = r1.get(r0);
        ID_CACHE.putIfAbsent(r4.getId(), r4);
        return r4;
    L14:
        return r2;
    L11:
        return new ZoneOffset(r3);
    L13:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    }

    private ZoneOffset(int r1) {
        this.totalSeconds = r1;
        this.id = buildId(r1);
    }

    private static String buildId(int r7) {
        if (r7 != 0) goto L5;
        return "Z";
    L5:
        int r0 = Math.abs(r7);
        StringBuilder r1 = new StringBuilder();
        int r2 = r0 / SECONDS_PER_HOUR;
        int r3 = (r0 / 60) % 60;
        if (r7 >= 0) goto L8;
        String r8 = "-";
    L9:
        StringBuilder r9 = r1.append(r8);
        if (r2 >= 10) goto L12;
        String r5 = "0";
    L13:
        StringBuilder r10 = r9.append(r5).append(r2);
        String r4 = ":0";
        if (r3 >= 10) goto L16;
        String r6 = ":0";
    L17:
        r10.append(r6).append(r3);
        int r11 = r0 % 60;
        if (r11 == 0) goto L24;
        if (r11 < 10) goto L22;
        r4 = ":";
    L22:
        r1.append(r4).append(r11);
    L24:
        return r1.toString();
    L16:
        r6 = ":";
        goto L17
    L12:
        r5 = "";
        goto L13
    L8:
        r8 = "+";
        goto L9
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        if ((r4 instanceof ChronoField) == true) goto L5;
        if (r4 == null) goto L14;
        if (r4.isSupportedBy(this) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r4 != ChronoField.OFFSET_SECONDS) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        if (r3 != ChronoField.OFFSET_SECONDS) goto L7;
        return r3.range();
    L7:
        if ((r3 instanceof ChronoField) == true) goto L11;
        return r3.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        if (r4 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r4 instanceof ChronoField) == true) goto L11;
        return range(r4).checkValidIntValue(getLong(r4), r4);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if (r3 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r3 instanceof ChronoField) == true) goto L11;
        return r3.getFrom(this);
    L11:
        throw new DateTimeException("Unsupported field: " + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.offset()) goto L5;
        return this;
    L5:
        if (r2 != TemporalQueries.zone()) goto L8;
        return this;
    L8:
        if (r2 != TemporalQueries.localDate()) goto L10;
    L20:
        return null;
    L10:
        if (r2 == TemporalQueries.localTime()) goto L20;
        if (r2 == TemporalQueries.precision()) goto L20;
        if (r2 == TemporalQueries.chronology()) goto L20;
        if (r2 == TemporalQueries.zoneId()) goto L20;
        return r2.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return r4.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffset r1) {
        return r1.totalSeconds - this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ZoneOffset) == true) goto L8;
        return false;
    L8:
        if (this.totalSeconds != ((ZoneOffset) r4).totalSeconds) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.id;
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // org.threeten.bp.ZoneId
    void write(DataOutput r2) throws IOException {
        r2.writeByte(8);
        writeExternal(r2);
    }

    void writeExternal(DataOutput r3) throws IOException {
        int r2 = this.totalSeconds;
        if ((r2 % 900) != 0) goto L5;
        int r0 = r2 / 900;
    L6:
        r3.writeByte(r0);
        if (r0 != 127) goto L10;
        r3.writeInt(r2);
        return;
    L10:
        return;
    L5:
        r0 = 127;
        goto L6
    }

    static ZoneOffset readExternal(DataInput r2) throws IOException {
        byte r0 = r2.readByte();
        if (r0 != 127) goto L6;
        return ofTotalSeconds(r2.readInt());
    L6:
        return ofTotalSeconds(r0 * 900);
    }
}
