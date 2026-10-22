package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes6.dex */
public final enum HijrahEra extends Enum<HijrahEra> implements Era {
    private static final /* synthetic */ HijrahEra[] $VALUES = null;
    public static final HijrahEra AH = null;
    public static final HijrahEra BEFORE_AH = null;

    private HijrahEra(String r1, int r2) {
        super(r1, r2);
    }

    public static HijrahEra valueOf(String r1) {
        return (HijrahEra) Enum.valueOf(HijrahEra.class, r1);
    }

    public static HijrahEra[] values() {
        return (HijrahEra[]) $VALUES.clone();
    }

    static {
        HijrahEra r0 = new HijrahEra("BEFORE_AH", 0);
        BEFORE_AH = r0;
        HijrahEra r1 = new HijrahEra("AH", 1);
        AH = r1;
        $VALUES = new HijrahEra[]{r0, r1};
    }

    public static HijrahEra of(int r1) {
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L8;
        return AH;
    L8:
        throw new DateTimeException("HijrahEra not valid");
    L10:
        return BEFORE_AH;
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return ordinal();
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
        if (r4 != ChronoField.ERA) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        if (r3 != ChronoField.ERA) goto L7;
        return ValueRange.of(1, 1);
    L7:
        if ((r3 instanceof ChronoField) == true) goto L11;
        return r3.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        if (r4 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        return range(r4).checkValidIntValue(getLong(r4), r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if (r3 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        if ((r3 instanceof ChronoField) == true) goto L11;
        return r3.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return r4.with(ChronoField.ERA, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.ERAS;
    L7:
        if (r2 != TemporalQueries.chronology()) goto L9;
        return null;
    L9:
        if (r2 != TemporalQueries.zone()) goto L11;
        return null;
    L11:
        if (r2 != TemporalQueries.zoneId()) goto L13;
        return null;
    L13:
        if (r2 != TemporalQueries.offset()) goto L15;
        return null;
    L15:
        if (r2 != TemporalQueries.localDate()) goto L17;
        return null;
    L17:
        if (r2 != TemporalQueries.localTime()) goto L20;
        return null;
    L20:
        return r2.queryFrom(this);
    }

    @Override // org.threeten.bp.chrono.Era
    public String getDisplayName(TextStyle r3, Locale r4) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, r3).toFormatter(r4).format(this);
    }

    int prolepticYear(int r2) {
        if (this != AH) goto L6;
        return r2;
    L6:
        return 1 - r2;
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    void writeExternal(DataOutput r1) throws IOException {
        r1.writeByte(getValue());
    }

    static HijrahEra readExternal(DataInput r0) throws IOException {
        return of(r0.readByte());
    }
}
