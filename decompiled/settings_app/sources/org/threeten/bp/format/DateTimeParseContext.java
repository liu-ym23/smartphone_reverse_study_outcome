package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes6.dex */
final class DateTimeParseContext {
    private boolean caseSensitive;
    private Locale locale;
    private Chronology overrideChronology;
    private ZoneId overrideZone;
    private final ArrayList<Parsed> parsed;
    private boolean strict;
    private DecimalStyle symbols;

    /* JADX INFO: renamed from: org.threeten.bp.format.DateTimeParseContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    final class Parsed extends DefaultInterfaceTemporalAccessor {
        List<Object[]> callbacks;
        Chronology chrono;
        Period excessDays;
        final Map<TemporalField, Long> fieldValues;
        boolean leapSecond;
        final /* synthetic */ DateTimeParseContext this$0;
        ZoneId zone;

        /* synthetic */ Parsed(DateTimeParseContext r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Parsed(DateTimeParseContext r1) {
            this.this$0 = r1;
            this.chrono = null;
            this.zone = null;
            this.fieldValues = new HashMap();
            this.excessDays = Period.ZERO;
        }

        protected Parsed copy() {
            Parsed r0 = new Parsed(this.this$0);
            r0.chrono = this.chrono;
            r0.zone = this.zone;
            r0.fieldValues.putAll(this.fieldValues);
            r0.leapSecond = this.leapSecond;
            return r0;
        }

        public String toString() {
            return this.fieldValues.toString() + "," + this.chrono + "," + this.zone;
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField r1) {
            return this.fieldValues.containsKey(r1);
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public int get(TemporalField r3) {
            if (this.fieldValues.containsKey(r3) == false) goto L7;
            return Jdk8Methods.safeToInt(this.fieldValues.get(r3).longValue());
        L7:
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField r3) {
            if (this.fieldValues.containsKey(r3) == false) goto L7;
            return this.fieldValues.get(r3).longValue();
        L7:
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public <R> R query(TemporalQuery<R> r2) {
            if (r2 != TemporalQueries.chronology()) goto L7;
            return (R) this.chrono;
        L7:
            if (r2 == TemporalQueries.zoneId()) goto L14;
            if (r2 == TemporalQueries.zone()) goto L14;
            return (R) super.query(r2);
        L14:
            return (R) this.zone;
        }

        DateTimeBuilder toBuilder() {
            DateTimeBuilder r0 = new DateTimeBuilder();
            r0.fieldValues.putAll(this.fieldValues);
            r0.chrono = this.this$0.getEffectiveChronology();
            ZoneId r1 = this.zone;
            if (r1 == null) goto L5;
            r0.zone = r1;
        L6:
            r0.leapSecond = this.leapSecond;
            r0.excessDays = this.excessDays;
            return r0;
        L5:
            r0.zone = DateTimeParseContext.access$100(this.this$0);
            goto L6
        }
    }

    static /* synthetic */ ZoneId access$100(DateTimeParseContext r0) {
        return r0.overrideZone;
    }

    DateTimeParseContext(DateTimeFormatter r3) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> r0 = new ArrayList();
        this.parsed = r0;
        this.locale = r3.getLocale();
        this.symbols = r3.getDecimalStyle();
        this.overrideChronology = r3.getChronology();
        this.overrideZone = r3.getZone();
        r0.add(new Parsed(this, null));
    }

    DateTimeParseContext(Locale r2, DecimalStyle r3, Chronology r4) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> r0 = new ArrayList();
        this.parsed = r0;
        this.locale = r2;
        this.symbols = r3;
        this.overrideChronology = r4;
        this.overrideZone = null;
        r0.add(new Parsed(this, null));
    }

    DateTimeParseContext(DateTimeParseContext r3) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> r0 = new ArrayList();
        this.parsed = r0;
        this.locale = r3.locale;
        this.symbols = r3.symbols;
        this.overrideChronology = r3.overrideChronology;
        this.overrideZone = r3.overrideZone;
        this.caseSensitive = r3.caseSensitive;
        this.strict = r3.strict;
        r0.add(new Parsed(this, null));
    }

    DateTimeParseContext copy() {
        return new DateTimeParseContext(this);
    }

    Locale getLocale() {
        return this.locale;
    }

    DecimalStyle getSymbols() {
        return this.symbols;
    }

    Chronology getEffectiveChronology() {
        Chronology r0 = currentParsed().chrono;
        if (r0 != null) goto L8;
        Chronology r1 = this.overrideChronology;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return IsoChronology.INSTANCE;
    L8:
        return r0;
    }

    boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    void setCaseSensitive(boolean r1) {
        this.caseSensitive = r1;
    }

    boolean subSequenceEquals(CharSequence r6, int r7, CharSequence r8, int r9, int r10) {
        if ((r7 + r10) <= r6.length()) goto L5;
    L27:
        return false;
    L5:
        if ((r9 + r10) > r8.length()) goto L27;
        if (isCaseSensitive() == false) goto L15;
        int r5 = 0;
    L10:
        if (r5 >= r10) goto L25;
        if (r6.charAt(r7 + r5) != r8.charAt(r9 + r5)) goto L13;
        r5 = r5 + 1;
        goto L10
    L13:
        return false;
    L25:
        return true;
    L15:
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L35;
        char r0 = r6.charAt(r7 + r11);
        char r1 = r8.charAt(r9 + r11);
        if (r0 == r1) goto L24;
        if (Character.toUpperCase(r0) == Character.toUpperCase(r1)) goto L24;
        if (Character.toLowerCase(r0) == Character.toLowerCase(r1)) goto L24;
        return false;
    L24:
        r11 = r11 + 1;
        goto L16
    L35:
        return true;
    }

    boolean charEquals(char r1, char r2) {
        if (isCaseSensitive() == false) goto L9;
        if (r1 != r2) goto L6;
        return true;
    L6:
        return false;
    L9:
        return charEqualsIgnoreCase(r1, r2);
    }

    static boolean charEqualsIgnoreCase(char r2, char r3) {
        if (r2 != r3) goto L4;
    L9:
        return true;
    L4:
        if (Character.toUpperCase(r2) == Character.toUpperCase(r3)) goto L9;
        if (Character.toLowerCase(r2) == Character.toLowerCase(r3)) goto L9;
        return false;
    }

    boolean isStrict() {
        return this.strict;
    }

    void setStrict(boolean r1) {
        this.strict = r1;
    }

    void startOptional() {
        this.parsed.add(currentParsed().copy());
    }

    void endOptional(boolean r1) {
        if (r1 == false) goto L4;
        ArrayList<Parsed> r0 = this.parsed;
        r0.remove(r0.size() - 2);
        return;
    L4:
        ArrayList<Parsed> r2 = this.parsed;
        r2.remove(r2.size() - 1);
    }

    private Parsed currentParsed() {
        ArrayList<Parsed> r1 = this.parsed;
        return r1.get(r1.size() - 1);
    }

    Long getParsed(TemporalField r1) {
        return currentParsed().fieldValues.get(r1);
    }

    int setParsedField(TemporalField r2, long r3, int r5, int r6) {
        Jdk8Methods.requireNonNull(r2, "field");
        Long r1 = currentParsed().fieldValues.put(r2, Long.valueOf(r3));
        if (r1 != null) goto L5;
        return r6;
    L5:
        if (r1.longValue() != r3) goto L7;
        return r6;
    L7:
        return ~r5;
    }

    void setParsed(Chronology r9) {
        Jdk8Methods.requireNonNull(r9, "chrono");
        Parsed r0 = currentParsed();
        r0.chrono = r9;
        if (r0.callbacks == null) goto L8;
        ArrayList r10 = new ArrayList(r0.callbacks);
        r0.callbacks.clear();
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object[] r1 = (Object[]) r11.next();
        ((DateTimeFormatterBuilder.ReducedPrinterParser) r1[0]).setValue(this, ((Long) r1[1]).longValue(), ((Integer) r1[2]).intValue(), ((Integer) r1[3]).intValue());
        goto L6
    L10:
        return;
    }

    void addChronologyChangedParser(DateTimeFormatterBuilder.ReducedPrinterParser r4, long r5, int r7, int r8) {
        Parsed r3 = currentParsed();
        if (r3.callbacks != null) goto L5;
        r3.callbacks = new ArrayList(2);
    L5:
        r3.callbacks.add(new Object[]{r4, Long.valueOf(r5), Integer.valueOf(r7), Integer.valueOf(r8)});
    }

    void setParsed(ZoneId r2) {
        Jdk8Methods.requireNonNull(r2, "zone");
        currentParsed().zone = r2;
    }

    void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    Parsed toParsed() {
        return currentParsed();
    }

    public String toString() {
        return currentParsed().toString();
    }

    void setLocale(Locale r2) {
        Jdk8Methods.requireNonNull(r2, "locale");
        this.locale = r2;
    }
}
