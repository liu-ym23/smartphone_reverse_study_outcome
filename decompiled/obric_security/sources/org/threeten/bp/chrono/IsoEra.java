package org.threeten.bp.chrono;

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

/* JADX INFO: loaded from: classes5.dex */
public final enum IsoEra extends Enum<IsoEra> implements Era {
    private static final /* synthetic */ IsoEra[] $VALUES = null;
    public static final IsoEra BCE = null;
    public static final IsoEra CE = null;

    private IsoEra(String r1, int r2) {
        super(r1, r2);
    }

    public static IsoEra valueOf(String r1) {
        return (IsoEra) Enum.valueOf(IsoEra.class, r1);
    }

    public static IsoEra[] values() {
        return (IsoEra[]) $VALUES.clone();
    }

    static {
        IsoEra r0 = new IsoEra("BCE", 0);
        BCE = r0;
        IsoEra r1 = new IsoEra("CE", 1);
        CE = r1;
        $VALUES = new IsoEra[]{r0, r1};
    }

    public static IsoEra of(int r3) {
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L8;
        return CE;
    L8:
        throw new DateTimeException("Invalid era: " + r3);
    L10:
        return BCE;
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
        return r3.range();
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
}
