package org.threeten.bp.temporal;

import com.android.settings.utils.HanziToPinyin;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes6.dex */
public final class JulianFields {
    public static final TemporalField JULIAN_DAY = null;
    public static final TemporalField MODIFIED_JULIAN_DAY = null;
    public static final TemporalField RATA_DIE = null;

    private static final enum Field extends Enum<Field> implements TemporalField {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final Field JULIAN_DAY = null;
        public static final Field MODIFIED_JULIAN_DAY = null;
        public static final Field RATA_DIE = null;
        private final TemporalUnit baseUnit;
        private final String name;
        private final long offset;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        public static Field valueOf(String r1) {
            return (Field) Enum.valueOf(Field.class, r1);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        static {
            Field r8 = new Field("JULIAN_DAY", 0, "JulianDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, 2440588);
            JULIAN_DAY = r8;
            Field r0 = new Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, 40587);
            MODIFIED_JULIAN_DAY = r0;
            Field r1 = new Field("RATA_DIE", 2, "RataDie", ChronoUnit.DAYS, ChronoUnit.FOREVER, 719163);
            RATA_DIE = r1;
            $VALUES = new Field[]{r8, r0, r1};
        }

        private Field(String r1, int r2, String r3, TemporalUnit r4, TemporalUnit r5, long r6) {
            super(r1, r2);
            this.name = r3;
            this.baseUnit = r4;
            this.rangeUnit = r5;
            this.range = ValueRange.of((-365243219162L) + r6, 365241780471L + r6);
            this.offset = r6;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor r1) {
            return r1.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor r3) {
            if (isSupportedBy(r3) == false) goto L7;
            return range();
        L7:
            throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long getFrom(TemporalAccessor r3) {
            return r3.getLong(ChronoField.EPOCH_DAY) + this.offset;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r4, long r5) {
            if (range().isValidValue(r5) == false) goto L7;
            return (R) r4.with(ChronoField.EPOCH_DAY, Jdk8Methods.safeSubtract(r5, this.offset));
        L7:
            throw new DateTimeException("Invalid value: " + this.name + HanziToPinyin.Token.SEPARATOR + r5);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale r2) {
            Jdk8Methods.requireNonNull(r2, "locale");
            return toString();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> r3, TemporalAccessor r4, ResolverStyle r5) {
            long r0 = r3.remove(this).longValue();
            return Chronology.from(r4).dateEpochDay(Jdk8Methods.safeSubtract(r0, this.offset));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public JulianFields() {
    }

    static {
        JULIAN_DAY = Field.JULIAN_DAY;
        MODIFIED_JULIAN_DAY = Field.MODIFIED_JULIAN_DAY;
        RATA_DIE = Field.RATA_DIE;
    }
}
