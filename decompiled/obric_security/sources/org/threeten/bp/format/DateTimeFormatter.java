package org.threeten.bp.format;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import obric.widget.search.data.GloableSearchConfig;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes5.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter BASIC_ISO_DATE = null;
    public static final DateTimeFormatter ISO_DATE = null;
    public static final DateTimeFormatter ISO_DATE_TIME = null;
    public static final DateTimeFormatter ISO_INSTANT = null;
    public static final DateTimeFormatter ISO_LOCAL_DATE = null;
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME = null;
    public static final DateTimeFormatter ISO_LOCAL_TIME = null;
    public static final DateTimeFormatter ISO_OFFSET_DATE = null;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME = null;
    public static final DateTimeFormatter ISO_OFFSET_TIME = null;
    public static final DateTimeFormatter ISO_ORDINAL_DATE = null;
    public static final DateTimeFormatter ISO_TIME = null;
    public static final DateTimeFormatter ISO_WEEK_DATE = null;
    public static final DateTimeFormatter ISO_ZONED_DATE_TIME = null;
    private static final TemporalQuery<Period> PARSED_EXCESS_DAYS = null;
    private static final TemporalQuery<Boolean> PARSED_LEAP_SECOND = null;
    public static final DateTimeFormatter RFC_1123_DATE_TIME = null;
    private final Chronology chrono;
    private final DecimalStyle decimalStyle;
    private final Locale locale;
    private final DateTimeFormatterBuilder.CompositePrinterParser printerParser;
    private final Set<TemporalField> resolverFields;
    private final ResolverStyle resolverStyle;
    private final ZoneId zone;

    static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final TemporalQuery<?> query;

        public ClassicFormat(DateTimeFormatter r1, TemporalQuery<?> r2) {
            this.formatter = r1;
            this.query = r2;
        }

        @Override // java.text.Format
        public StringBuffer format(Object r2, StringBuffer r3, FieldPosition r4) {
            Jdk8Methods.requireNonNull(r2, "obj");
            Jdk8Methods.requireNonNull(r3, "toAppendTo");
            Jdk8Methods.requireNonNull(r4, "pos");
            if ((r2 instanceof TemporalAccessor) == false) goto L11;
            r4.setBeginIndex(0);
            r4.setEndIndex(0);
            this.formatter.formatTo((TemporalAccessor) r2, r3);     // Catch: RuntimeException -> L7
            return r3;
        L7:
            e = move-exception;
            throw new IllegalArgumentException(e.getMessage(), e);
        L11:
            throw new IllegalArgumentException("Format target must implement TemporalAccessor");
        }

        @Override // java.text.Format
        public Object parseObject(String r3) throws ParseException {
            Jdk8Methods.requireNonNull(r3, "text");
            TemporalQuery<?> r0 = this.query;     // Catch: RuntimeException -> L9 DateTimeParseException -> L12
            if (r0 != null) goto L8;
            return DateTimeFormatter.access$000(this.formatter, r3, null).resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());
        L8:
            return this.formatter.parse(r3, r0);
        L12:
            e = move-exception;
            throw new ParseException(e.getMessage(), e.getErrorIndex());
        L9:
            e = move-exception;
            throw ((ParseException) new ParseException(e.getMessage(), 0).initCause(e));
        }

        @Override // java.text.Format
        public Object parseObject(String r5, ParsePosition r6) {
            Jdk8Methods.requireNonNull(r5, "text");
            DateTimeParseContext.Parsed r7 = DateTimeFormatter.access$100(this.formatter, r5, r6);     // Catch: IndexOutOfBoundsException -> L16
            if (r7 == null) goto L6;
            DateTimeBuilder r8 = r7.toBuilder().resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());     // Catch: RuntimeException -> L14
            TemporalQuery<?> r4 = this.query;     // Catch: RuntimeException -> L14
            if (r4 != null) goto L12;
            return r8;
        L12:
            return r8.build(r4);
        L14:
            r6.setErrorIndex(0);
            return null;
        L6:
            if (r6.getErrorIndex() >= 0) goto L8;
            r6.setErrorIndex(0);
        L8:
            return null;
        L17:
            if (r6.getErrorIndex() >= 0) goto L19;
            r6.setErrorIndex(0);
        L19:
            return null;
        }
    }

    static /* synthetic */ DateTimeBuilder access$000(DateTimeFormatter r0, CharSequence r1, ParsePosition r2) {
        return r0.parseToBuilder(r1, r2);
    }

    static /* synthetic */ DateTimeParseContext.Parsed access$100(DateTimeFormatter r0, CharSequence r1, ParsePosition r2) {
        return r0.parseUnresolved0(r1, r2);
    }

    static {
        DateTimeFormatter r0 = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_LOCAL_DATE = r0;
        ISO_OFFSET_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r0).appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r0).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        DateTimeFormatter r2 = new DateTimeFormatterBuilder().appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).toFormatter(ResolverStyle.STRICT);
        ISO_LOCAL_TIME = r2;
        ISO_OFFSET_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r2).appendOffsetId().toFormatter(ResolverStyle.STRICT);
        ISO_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r2).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT);
        DateTimeFormatter r1 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r0).appendLiteral('T').append(r2).toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_LOCAL_DATE_TIME = r1;
        DateTimeFormatter r3 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(r1).appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_OFFSET_DATE_TIME = r3;
        ISO_ZONED_DATE_TIME = new DateTimeFormatterBuilder().append(r3).optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_DATE_TIME = new DateTimeFormatterBuilder().append(r1).optionalStart().appendOffsetId().optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_ORDINAL_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.DAY_OF_YEAR, 3).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_WEEK_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral("-W").appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_WEEK, 1).optionalStart().appendOffsetId().toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        ISO_INSTANT = new DateTimeFormatterBuilder().parseCaseInsensitive().appendInstant().toFormatter(ResolverStyle.STRICT);
        BASIC_ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(ChronoField.YEAR, 4).appendValue(ChronoField.MONTH_OF_YEAR, 2).appendValue(ChronoField.DAY_OF_MONTH, 2).optionalStart().appendOffset("+HHMMss", "Z").toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE);
        HashMap r4 = new HashMap();
        r4.put(1L, "Mon");
        r4.put(2L, "Tue");
        r4.put(3L, "Wed");
        r4.put(4L, "Thu");
        r4.put(5L, "Fri");
        r4.put(6L, "Sat");
        r4.put(7L, "Sun");
        HashMap r12 = new HashMap();
        r12.put(1L, "Jan");
        r12.put(2L, "Feb");
        r12.put(3L, "Mar");
        r12.put(4L, "Apr");
        r12.put(5L, "May");
        r12.put(6L, "Jun");
        r12.put(7L, "Jul");
        r12.put(8L, "Aug");
        r12.put(9L, "Sep");
        r12.put(10L, "Oct");
        r12.put(11L, "Nov");
        r12.put(12L, "Dec");
        RFC_1123_DATE_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText(ChronoField.DAY_OF_WEEK, r4).appendLiteral(", ").optionalEnd().appendValue(ChronoField.DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE).appendLiteral(' ').appendText(ChronoField.MONTH_OF_YEAR, r12).appendLiteral(' ').appendValue(ChronoField.YEAR, 4).appendLiteral(' ').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalEnd().appendLiteral(' ').appendOffset("+HHMM", "GMT").toFormatter(ResolverStyle.SMART).withChronology(IsoChronology.INSTANCE);
        PARSED_EXCESS_DAYS = new AnonymousClass1();
        PARSED_LEAP_SECOND = new AnonymousClass2();
    }

    public static DateTimeFormatter ofPattern(String r1) {
        return new DateTimeFormatterBuilder().appendPattern(r1).toFormatter();
    }

    public static DateTimeFormatter ofPattern(String r1, Locale r2) {
        return new DateTimeFormatterBuilder().appendPattern(r1).toFormatter(r2);
    }

    public static DateTimeFormatter ofLocalizedDate(FormatStyle r2) {
        Jdk8Methods.requireNonNull(r2, "dateStyle");
        return new DateTimeFormatterBuilder().appendLocalized(r2, null).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedTime(FormatStyle r2) {
        Jdk8Methods.requireNonNull(r2, "timeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(null, r2).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle r1) {
        Jdk8Methods.requireNonNull(r1, "dateTimeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(r1, r1).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle r1, FormatStyle r2) {
        Jdk8Methods.requireNonNull(r1, "dateStyle");
        Jdk8Methods.requireNonNull(r2, "timeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(r1, r2).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static final TemporalQuery<Period> parsedExcessDays() {
        return PARSED_EXCESS_DAYS;
    }

    public static final TemporalQuery<Boolean> parsedLeapSecond() {
        return PARSED_LEAP_SECOND;
    }

    DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser r2, Locale r3, DecimalStyle r4, ResolverStyle r5, Set<TemporalField> r6, Chronology r7, ZoneId r8) {
        this.printerParser = (DateTimeFormatterBuilder.CompositePrinterParser) Jdk8Methods.requireNonNull(r2, "printerParser");
        this.locale = (Locale) Jdk8Methods.requireNonNull(r3, "locale");
        this.decimalStyle = (DecimalStyle) Jdk8Methods.requireNonNull(r4, "decimalStyle");
        this.resolverStyle = (ResolverStyle) Jdk8Methods.requireNonNull(r5, "resolverStyle");
        this.resolverFields = r6;
        this.chrono = r7;
        this.zone = r8;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public DateTimeFormatter withLocale(Locale r10) {
        if (this.locale.equals(r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, r10, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DecimalStyle getDecimalStyle() {
        return this.decimalStyle;
    }

    public DateTimeFormatter withDecimalStyle(DecimalStyle r10) {
        if (this.decimalStyle.equals(r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, this.locale, r10, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public Chronology getChronology() {
        return this.chrono;
    }

    public DateTimeFormatter withChronology(Chronology r10) {
        if (Jdk8Methods.equals(this.chrono, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, r10, this.zone);
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public DateTimeFormatter withZone(ZoneId r10) {
        if (Jdk8Methods.equals(this.zone, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, r10);
    }

    public ResolverStyle getResolverStyle() {
        return this.resolverStyle;
    }

    public DateTimeFormatter withResolverStyle(ResolverStyle r10) {
        Jdk8Methods.requireNonNull(r10, "resolverStyle");
        if (Jdk8Methods.equals(this.resolverStyle, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, r10, this.resolverFields, this.chrono, this.zone);
    }

    public Set<TemporalField> getResolverFields() {
        return this.resolverFields;
    }

    public DateTimeFormatter withResolverFields(TemporalField... r10) {
        if (r10 == null) goto L4;
        HashSet r0 = new HashSet(Arrays.asList(r10));
        if (Jdk8Methods.equals(this.resolverFields, r0) == false) goto L8;
        return this;
    L8:
        Set r6 = Collections.unmodifiableSet(r0);
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, r6, this.chrono, this.zone);
    L4:
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, null, this.chrono, this.zone);
    }

    public DateTimeFormatter withResolverFields(Set<TemporalField> r10) {
        if (r10 != null) goto L6;
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, null, this.chrono, this.zone);
    L6:
        if (Jdk8Methods.equals(this.resolverFields, r10) == false) goto L8;
        return this;
    L8:
        Set r6 = Collections.unmodifiableSet(new HashSet(r10));
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, r6, this.chrono, this.zone);
    }

    public String format(TemporalAccessor r3) {
        StringBuilder r0 = new StringBuilder(32);
        formatTo(r3, r0);
        return r0.toString();
    }

    public void formatTo(TemporalAccessor r3, Appendable r4) {
        Jdk8Methods.requireNonNull(r3, "temporal");
        Jdk8Methods.requireNonNull(r4, "appendable");
        DateTimePrintContext r0 = new DateTimePrintContext(r3, this);     // Catch: IOException -> L8
        if ((r4 instanceof StringBuilder) == false) goto L6;
        this.printerParser.print(r0, (StringBuilder) r4);     // Catch: IOException -> L8
        return;
    L6:
        StringBuilder r5 = new StringBuilder(32);     // Catch: IOException -> L8
        this.printerParser.print(r0, r5);     // Catch: IOException -> L8
        r4.append(r5);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new DateTimeException(e.getMessage(), e);
    }

    public TemporalAccessor parse(CharSequence r4) {
        Jdk8Methods.requireNonNull(r4, "text");
        return parseToBuilder(r4, null).resolve(this.resolverStyle, this.resolverFields);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw createError(r4, e);
    }

    public TemporalAccessor parse(CharSequence r3, ParsePosition r4) {
        Jdk8Methods.requireNonNull(r3, "text");
        Jdk8Methods.requireNonNull(r4, "position");
        return parseToBuilder(r3, r4).resolve(this.resolverStyle, this.resolverFields);
    L8:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw createError(r3, e);
    }

    public <T> T parse(CharSequence r4, TemporalQuery<T> r5) {
        Jdk8Methods.requireNonNull(r4, "text");
        Jdk8Methods.requireNonNull(r5, "type");
        return (T) parseToBuilder(r4, null).resolve(this.resolverStyle, this.resolverFields).build(r5);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw createError(r4, e);
    }

    public TemporalAccessor parseBest(CharSequence r5, TemporalQuery<?>... r6) {
        Jdk8Methods.requireNonNull(r5, "text");
        Jdk8Methods.requireNonNull(r6, GloableSearchConfig.KEY_CONFIGS);
        if (r6.length < 2) goto L19;
        DateTimeBuilder r0 = parseToBuilder(r5, null).resolve(this.resolverStyle, this.resolverFields);     // Catch: RuntimeException -> L13 DateTimeParseException -> L16
        int r2 = 0;
    L6:
        if (r2 >= r6.length) goto L12;
        return (TemporalAccessor) r0.build(r6[r2]);
    L10:
        r2 = r2 + 1;
        goto L6
    L12:
        throw new DateTimeException("Unable to convert parsed text to any specified type: " + Arrays.toString(r6));     // Catch: RuntimeException -> L13 DateTimeParseException -> L16
    L13:
        e = move-exception;
        throw createError(r5, e);
    L16:
        e = move-exception;
        throw e;
    L19:
        throw new IllegalArgumentException("At least two types must be specified");
    }

    private DateTimeParseException createError(CharSequence r5, RuntimeException r6) {
        if (r5.length() <= 64) goto L5;
        String r4 = r5.subSequence(0, 64).toString() + "...";
    L7:
        return new DateTimeParseException("Text '" + r4 + "' could not be parsed: " + r6.getMessage(), r5, 0, r6);
    L5:
        r4 = r5.toString();
        goto L7
    }

    private DateTimeBuilder parseToBuilder(CharSequence r4, ParsePosition r5) {
        if (r5 == null) goto L5;
        ParsePosition r1 = r5;
    L6:
        DateTimeParseContext.Parsed r3 = parseUnresolved0(r4, r1);
        if (r3 == null) goto L17;
        if (r1.getErrorIndex() >= 0) goto L17;
        if (r5 != null) goto L15;
        if (r1.getIndex() < r4.length()) goto L17;
    L15:
        return r3.toBuilder();
    L17:
        if (r4.length() <= 64) goto L19;
        String r6 = r4.subSequence(0, 64).toString() + "...";
    L21:
        if (r1.getErrorIndex() < 0) goto L25;
        throw new DateTimeParseException("Text '" + r6 + "' could not be parsed at index " + r1.getErrorIndex(), r4, r1.getErrorIndex());
    L25:
        throw new DateTimeParseException("Text '" + r6 + "' could not be parsed, unparsed text found at index " + r1.getIndex(), r4, r1.getIndex());
    L19:
        r6 = r4.toString();
        goto L21
    L5:
        r1 = new ParsePosition(0);
        goto L6
    }

    public TemporalAccessor parseUnresolved(CharSequence r1, ParsePosition r2) {
        return parseUnresolved0(r1, r2);
    }

    private DateTimeParseContext.Parsed parseUnresolved0(CharSequence r3, ParsePosition r4) {
        Jdk8Methods.requireNonNull(r3, "text");
        Jdk8Methods.requireNonNull(r4, "position");
        DateTimeParseContext r0 = new DateTimeParseContext(this);
        int r1 = r4.getIndex();
        int r2 = this.printerParser.parse(r0, r3, r1);
        if (r2 >= 0) goto L6;
        r4.setErrorIndex(~r2);
        return null;
    L6:
        r4.setIndex(r2);
        return r0.toParsed();
    }

    DateTimeFormatterBuilder.CompositePrinterParser toPrinterParser(boolean r1) {
        return this.printerParser.withOptional(r1);
    }

    public Format toFormat() {
        return new ClassicFormat(this, null);
    }

    public Format toFormat(TemporalQuery<?> r2) {
        Jdk8Methods.requireNonNull(r2, "query");
        return new ClassicFormat(this, r2);
    }

    public String toString() {
        String r2 = this.printerParser.toString();
        if (r2.startsWith("[") == false) goto L6;
        return r2;
    L6:
        return r2.substring(1, r2.length() - 1);
    }
}
