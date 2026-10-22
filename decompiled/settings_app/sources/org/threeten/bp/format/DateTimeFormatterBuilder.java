package org.threeten.bp.format;

import android.icu.util.ULocale;
import com.android.settings.CustomKeyUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.android.settingslib.utils.StringUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import cz.msebera.android.httpclient.message.TokenParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: loaded from: classes6.dex */
public final class DateTimeFormatterBuilder {
    private static final Map<Character, TemporalField> FIELD_MAP = null;
    static final Comparator<String> LENGTH_SORT = null;
    private static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = null;
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List<DateTimePrinterParser> printerParsers;
    private int valueParserIndex;

    /* JADX INFO: renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$format$SignStyle = null;

        static {
            int[] r0 = new int[SignStyle.values().length];
            $SwitchMap$org$threeten$bp$format$SignStyle = r0;
            r0[SignStyle.EXCEEDS_PAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char r1) {
            this.literal = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            r2.append(this.literal);
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r2, CharSequence r3, int r4) {
            if (r4 == r3.length()) goto L5;
            char r5 = r3.charAt(r4);
            if (r2.charEquals(this.literal, r5) == true) goto L11;
            return ~r4;
        L11:
            return r4 + 1;
        L5:
            return ~r4;
        }

        public String toString() {
            if (this.literal != '\'') goto L7;
            return "''";
        L7:
            return "'" + this.literal + "'";
        }
    }

    static final class ChronoPrinterParser implements DateTimePrinterParser {
        private final TextStyle textStyle;

        ChronoPrinterParser(TextStyle r1) {
            this.textStyle = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r3, StringBuilder r4) {
            Chronology r0 = (Chronology) r3.getValue(TemporalQueries.chronology());
            if (r0 != null) goto L7;
            return false;
        L7:
            if (this.textStyle != null) goto L9;
            r4.append(r0.getId());
            return true;
        L9:
            ResourceBundle r2 = ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", r3.getLocale(), DateTimeFormatterBuilder.class.getClassLoader());
            r4.append(r2.getString(r0.getId()));     // Catch: MissingResourceException -> L12
            return true;
        L12:
            r4.append(r0.getId());
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r11, CharSequence r12, int r13) {
            if (r13 < 0) goto L19;
            if (r13 > r12.length()) goto L19;
            Iterator<Chronology> r10 = Chronology.getAvailableChronologies().iterator();
            Chronology r0 = null;
            int r1 = -1;
        L7:
            if (r10.hasNext() == false) goto L13;
            Chronology r2 = r10.next();
            String r6 = r2.getId();
            int r9 = r6.length();
            if (r9 <= r1) goto L7;
            if (r11.subSequenceEquals(r12, r13, r6, 0, r9) == false) goto L7;
            r0 = r2;
            r1 = r9;
            goto L7
        L13:
            if (r0 == null) goto L15;
            r11.setParsed(r0);
            return r13 + r1;
        L15:
            return ~r13;
        L19:
            throw new IndexOutOfBoundsException();
        }
    }

    static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List<DateTimePrinterParser> r2, boolean r3) {
            this((DateTimePrinterParser[]) r2.toArray(new DateTimePrinterParser[r2.size()]), r3);
        }

        CompositePrinterParser(DateTimePrinterParser[] r1, boolean r2) {
            this.printerParsers = r1;
            this.optional = r2;
        }

        public CompositePrinterParser withOptional(boolean r2) {
            if (r2 != this.optional) goto L6;
            return this;
        L6:
            return new CompositePrinterParser(this.printerParsers, r2);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r7, StringBuilder r8) {
            int r0 = r8.length();
            if (this.optional == false) goto L25;
            r7.startOptional();
        L25:
            DateTimePrinterParser[] r1 = this.printerParsers;     // Catch: Throwable -> L20
            int r2 = r1.length;     // Catch: Throwable -> L20
            int r3 = 0;
        L7:
            if (r3 >= r2) goto L17;
            if (r1[r3].print(r7, r8) == false) goto L10;
            r3 = r3 + 1;
            goto L7
        L10:
            r8.setLength(r0);     // Catch: Throwable -> L20
            if (this.optional == false) goto L14;
            r7.endOptional();
        L14:
            return true;
        L17:
            if (this.optional == false) goto L19;
            r7.endOptional();
        L19:
            return true;
        L20:
            th = move-exception;
            if (this.optional == false) goto L24;
            r7.endOptional();
        L24:
            throw th;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r6, CharSequence r7, int r8) {
            int r1 = 0;
            if (this.optional == false) goto L13;
            r6.startOptional();
            DateTimePrinterParser[] r5 = this.printerParsers;
            int r0 = r5.length;
            int r3 = r8;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L11;
            r3 = r5[r2].parse(r6, r7, r3);
            if (r3 < 0) goto L8;
            r2 = r2 + 1;
            goto L5
        L8:
            r6.endOptional(false);
            return r8;
        L11:
            r6.endOptional(true);
            return r3;
        L13:
            DateTimePrinterParser[] r9 = this.printerParsers;
            int r4 = r9.length;
        L14:
            if (r1 >= r4) goto L19;
            r8 = r9[r1].parse(r6, r7, r8);
            if (r8 < 0) goto L19;
            r1 = r1 + 1;
        L19:
            return r8;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.printerParsers == null) goto L17;
            if (this.optional == false) goto L7;
            String r1 = "[";
        L8:
            r0.append(r1);
            DateTimePrinterParser[] r2 = this.printerParsers;
            int r3 = r2.length;
            int r4 = 0;
        L9:
            if (r4 >= r3) goto L12;
            r0.append(r2[r4]);
            r4 = r4 + 1;
            goto L9
        L12:
            if (this.optional == false) goto L14;
            String r5 = "]";
        L15:
            r0.append(r5);
            goto L17
        L14:
            r5 = ")";
            goto L15
        L7:
            r1 = "(";
        L17:
            return r0.toString();
        }
    }

    interface DateTimePrinterParser {
        int parse(DateTimeParseContext r1, CharSequence r2, int r3);

        boolean print(DateTimePrintContext r1, StringBuilder r2);
    }

    static class DefaultingParser implements DateTimePrinterParser {
        private final TemporalField field;
        private final long value;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            return true;
        }

        DefaultingParser(TemporalField r1, long r2) {
            this.field = r1;
            this.value = r2;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r7, CharSequence r8, int r9) {
            if (r7.getParsed(this.field) != null) goto L5;
            r7.setParsedField(this.field, this.value, r9, r9);
        L5:
            return r9;
        }
    }

    static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        FractionPrinterParser(TemporalField r3, int r4, int r5, boolean r6) {
            Jdk8Methods.requireNonNull(r3, "field");
            if (r3.range().isFixed() == false) goto L20;
            if (r4 < 0) goto L18;
            if (r4 > 9) goto L18;
            if (r5 < 1) goto L16;
            if (r5 > 9) goto L16;
            if (r5 < r4) goto L14;
            this.field = r3;
            this.minWidth = r4;
            this.maxWidth = r5;
            this.decimalPoint = r6;
            return;
        L14:
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + r5 + " < " + r4);
        L16:
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + r5);
        L18:
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + r4);
        L20:
            throw new IllegalArgumentException("Field must have a fixed set of values: " + r3);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r5, StringBuilder r6) {
            Long r0 = r5.getValue(this.field);
            int r1 = 0;
            if (r0 != null) goto L5;
            return false;
        L5:
            DecimalStyle r7 = r5.getSymbols();
            BigDecimal r2 = convertToFraction(r0.longValue());
            if (r2.scale() == 0) goto L8;
            String r3 = r7.convertNumberToI18N(r2.setScale(Math.min(Math.max(r2.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
            if (this.decimalPoint == false) goto L18;
            r6.append(r7.getDecimalSeparator());
        L18:
            r6.append(r3);
            return true;
        L8:
            if (this.minWidth > 0) goto L10;
            return true;
        L10:
            if (this.decimalPoint == false) goto L13;
            r6.append(r7.getDecimalSeparator());
        L13:
            if (r1 >= this.minWidth) goto L24;
            r6.append(r7.getZeroDigit());
            r1 = r1 + 1;
            goto L13
        L24:
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r11, CharSequence r12, int r13) {
            int r1 = 0;
            if (r11.isStrict() == false) goto L5;
            int r0 = this.minWidth;
        L7:
            if (r11.isStrict() == false) goto L9;
            int r2 = this.maxWidth;
        L10:
            int r3 = r12.length();
            if (r13 != r3) goto L16;
            if (r0 > 0) goto L14;
            return r13;
        L14:
            return ~r13;
        L16:
            if (this.decimalPoint == true) goto L18;
        L23:
            int r8 = r13;
            int r4 = r0 + r8;
            if (r4 > r3) goto L26;
            int r14 = Math.min(r2 + r8, r3);
            int r5 = r8;
        L28:
            if (r5 >= r14) goto L36;
            int r6 = r5 + 1;
            int r7 = r11.getSymbols().convertToDigit(r12.charAt(r5));
            if (r7 < 0) goto L31;
            r1 = (r1 * 10) + r7;
            r5 = r6;
            goto L28
        L31:
            if (r6 < r4) goto L33;
            int r9 = r6 - 1;
        L38:
            return r11.setParsedField(this.field, convertFromFraction(new BigDecimal(r1).movePointLeft(r9 - r8)), r8, r9);
        L33:
            return ~r8;
        L36:
            r9 = r5;
            goto L38
        L26:
            return ~r8;
        L18:
            if (r12.charAt(r13) == r11.getSymbols().getDecimalSeparator()) goto L22;
            if (r0 > 0) goto L21;
            return r13;
        L21:
            return ~r13;
        L22:
            r13 = r13 + 1;
            goto L23
        L9:
            r2 = 9;
            goto L10
        L5:
            r0 = 0;
            goto L7
        }

        private BigDecimal convertToFraction(long r4) {
            ValueRange r0 = this.field.range();
            r0.checkValidValue(r4, this.field);
            BigDecimal r3 = BigDecimal.valueOf(r0.getMinimum());
            BigDecimal r1 = BigDecimal.valueOf(r0.getMaximum()).subtract(r3).add(BigDecimal.ONE);
            BigDecimal r5 = BigDecimal.valueOf(r4).subtract(r3).divide(r1, 9, RoundingMode.FLOOR);
            if (r5.compareTo(BigDecimal.ZERO) != 0) goto L6;
            return BigDecimal.ZERO;
        L6:
            return r5.stripTrailingZeros();
        }

        private long convertFromFraction(BigDecimal r4) {
            ValueRange r3 = this.field.range();
            BigDecimal r0 = BigDecimal.valueOf(r3.getMinimum());
            return r4.multiply(BigDecimal.valueOf(r3.getMaximum()).subtract(r0).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(r0).longValueExact();
        }

        public String toString() {
            if (this.decimalPoint == false) goto L5;
            String r0 = ",DecimalPoint";
        L7:
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + r0 + ")";
        L5:
            r0 = "";
            goto L7
        }
    }

    static final class InstantPrinterParser implements DateTimePrinterParser {
        private static final long SECONDS_0000_TO_1970 = 62167219200L;
        private static final long SECONDS_PER_10000_YEARS = 315569520000L;
        private final int fractionalDigits;

        public String toString() {
            return "Instant()";
        }

        InstantPrinterParser(int r1) {
            this.fractionalDigits = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r17, StringBuilder r18) {
            Long r2 = r17.getValue(ChronoField.INSTANT_SECONDS);
            Long r6 = 0L;
            if (r17.getTemporal().isSupported(ChronoField.NANO_OF_SECOND) == false) goto L5;
            r6 = Long.valueOf(r17.getTemporal().getLong(ChronoField.NANO_OF_SECOND));
        L5:
            int r3 = 0;
            if (r2 != null) goto L8;
            return false;
        L8:
            long r7 = r2.longValue();
            int r4 = ChronoField.NANO_OF_SECOND.checkValidIntValue(r6.longValue());
            if (r7 < (-62167219200L)) goto L16;
            long r8 = (r7 - SECONDS_PER_10000_YEARS) + SECONDS_0000_TO_1970;
            long r5 = Jdk8Methods.floorDiv(r8, SECONDS_PER_10000_YEARS) + 1;
            LocalDateTime r9 = LocalDateTime.ofEpochSecond(Jdk8Methods.floorMod(r8, SECONDS_PER_10000_YEARS) - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
            if (r5 <= 0) goto L13;
            r18.append('+').append(r5);
        L13:
            r18.append(r9);
            if (r9.getSecond() != 0) goto L28;
            r18.append(":00");
        L28:
            int r10 = this.fractionalDigits;
            if (r10 != (-2)) goto L39;
            if (r4 == 0) goto L48;
            r18.append('.');
            if ((r4 % 1000000) != 0) goto L35;
            r18.append(Integer.toString((r4 / 1000000) + 1000).substring(1));
            goto L48
        L35:
            if ((r4 % 1000) != 0) goto L37;
            r18.append(Integer.toString((r4 / 1000) + 1000000).substring(1));
            goto L48
        L37:
            r18.append(Integer.toString(r4 + 1000000000).substring(1));
        L48:
            r18.append('Z');
            return true;
        L39:
            if (r10 > 0) goto L42;
            if (r10 != (-1)) goto L48;
            if (r4 <= 0) goto L48;
        L42:
            r18.append('.');
            int r11 = 100000000;
        L43:
            int r12 = this.fractionalDigits;
            if (r12 != (-1)) goto L46;
            if (r4 <= 0) goto L46;
        L47:
            int r13 = r4 / r11;
            r18.append((char) (r13 + 48));
            r4 = r4 - (r13 * r11);
            r11 = r11 / 10;
            r3 = r3 + 1;
        L46:
            if (r3 >= r12) goto L48;
        L16:
            long r14 = r7 + SECONDS_0000_TO_1970;
            long r15 = r14 / SECONDS_PER_10000_YEARS;
            long r16 = r14 % SECONDS_PER_10000_YEARS;
            LocalDateTime r19 = LocalDateTime.ofEpochSecond(r16 - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
            int r110 = r18.length();
            r18.append(r19);
            if (r19.getSecond() != 0) goto L20;
            r18.append(":00");
        L20:
            if (r15 >= 0) goto L28;
            if (r19.getYear() != (-10000)) goto L25;
            r18.replace(r110, r110 + 2, Long.toString(r15 - 1));
            goto L28
        L25:
            if (r16 != 0) goto L27;
            r18.insert(r110, r15);
            goto L28
        L27:
            r18.insert(r110 + 1, Math.abs(r15));
            goto L28
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r17, CharSequence r18, int r19) {
            DateTimeParseContext r0 = r17.copy();
            int r1 = this.fractionalDigits;
            int r2 = 0;
            if (r1 >= 0) goto L5;
            int r3 = 0;
        L6:
            if (r1 >= 0) goto L8;
            r1 = 9;
        L8:
            int r5 = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).appendValue(ChronoField.MINUTE_OF_HOUR, 2).appendLiteral(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).appendValue(ChronoField.SECOND_OF_MINUTE, 2).appendFraction(ChronoField.NANO_OF_SECOND, r3, r1, true).appendLiteral('Z').toFormatter().toPrinterParser(false).parse(r0, r18, r19);
            if (r5 >= 0) goto L11;
            return r5;
        L11:
            long r4 = r0.getParsed(ChronoField.YEAR).longValue();
            int r9 = r0.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int r10 = r0.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int r6 = r0.getParsed(ChronoField.HOUR_OF_DAY).intValue();
            int r12 = r0.getParsed(ChronoField.MINUTE_OF_HOUR).intValue();
            Long r8 = r0.getParsed(ChronoField.SECOND_OF_MINUTE);
            Long r7 = r0.getParsed(ChronoField.NANO_OF_SECOND);
            if (r8 == null) goto L14;
            int r11 = r8.intValue();
        L15:
            if (r7 == null) goto L17;
            int r15 = r7.intValue();
        L18:
            int r13 = ((int) r4) % 10000;
            if (r6 != 24) goto L25;
            if (r12 != 0) goto L25;
            if (r11 != 0) goto L25;
            if (r15 != 0) goto L25;
            int r14 = 0;
            r2 = 1;
        L32:
            int r16 = r11;
        L39:
            return r17.setParsedField(ChronoField.NANO_OF_SECOND, r15, r19, r17.setParsedField(ChronoField.INSTANT_SECONDS, Jdk8Methods.safeMultiply(r4 / 10000, SECONDS_PER_10000_YEARS) + LocalDateTime.of(r13, r9, r10, r14, r12, r16, 0).plusDays(r2).toEpochSecond(ZoneOffset.UTC), r19, r5));
        L38:
            return ~r19;
        L25:
            if (r6 == 23) goto L27;
        L31:
            r14 = r6;
            goto L32
        L27:
            if (r12 != 59) goto L31;
            if (r11 != 60) goto L31;
            r17.setParsedLeapSecond();
            r14 = r6;
            r16 = 59;
            goto L39
        L17:
            r15 = 0;
            goto L18
        L14:
            r11 = 0;
            goto L15
        L5:
            r3 = r1;
            goto L6
        }
    }

    static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        public LocalizedOffsetPrinterParser(TextStyle r1) {
            this.style = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r4, StringBuilder r5) {
            Long r0 = r4.getValue(ChronoField.OFFSET_SECONDS);
            if (r0 != null) goto L6;
            return false;
        L6:
            r5.append("GMT");
            if (this.style == TextStyle.FULL) goto L9;
            int r3 = Jdk8Methods.safeToInt(r0.longValue());
            if (r3 == 0) goto L24;
            int r6 = Math.abs((r3 / StringUtil.SECONDS_PER_HOUR) % 100);
            int r1 = Math.abs((r3 / 60) % 60);
            int r2 = Math.abs(r3 % 60);
            if (r3 >= 0) goto L15;
            String r7 = "-";
        L16:
            r5.append(r7).append(r6);
            if (r1 > 0) goto L19;
            if (r2 > 0) goto L19;
            return true;
        L19:
            r5.append(":").append((char) ((r1 / 10) + 48)).append((char) ((r1 % 10) + 48));
            if (r2 <= 0) goto L26;
            r5.append(":").append((char) ((r2 / 10) + 48)).append((char) ((r2 % 10) + 48));
            return true;
        L26:
            return true;
        L15:
            r7 = CustomKeyUtils.KEY_SEPARATE_FOR_SHOW;
            goto L16
        L24:
            return true;
        L9:
            return new OffsetIdPrinterParser("", "+HH:MM:ss").print(r4, r5);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r14, CharSequence r15, int r16) {
            if (r14.subSequenceEquals(r15, r16, "GMT", 0, 3) == false) goto L5;
            int r0 = r16 + 3;
            if (this.style == TextStyle.FULL) goto L9;
            int r1 = r15.length();
            if (r0 == r1) goto L13;
            char r3 = r15.charAt(r0);
            if (r3 == '+') goto L20;
            if (r3 == '-') goto L20;
            return r14.setParsedField(ChronoField.OFFSET_SECONDS, 0, r0, r0);
        L20:
            if (r3 != '-') goto L22;
            int r4 = -1;
        L23:
            if (r0 == r1) goto L25;
            int r2 = r0 + 1;
            char r5 = r15.charAt(r2);
            if (r5 < '0') goto L97;
            if (r5 > '9') goto L97;
            int r6 = r2 + 1;
            int r7 = r5 - '0';
            if (r6 == r1) goto L41;
            char r9 = r15.charAt(r6);
            if (r9 < '0') goto L41;
            if (r9 > '9') goto L41;
            r7 = (r7 * 10) + (r9 - '0');
            if (r7 > 23) goto L39;
            r6 = r6 + 1;
            goto L41
        L39:
            return ~r6;
        L41:
            int r10 = r6;
            if (r10 == r1) goto L95;
            if (r15.charAt(r10) != ':') goto L95;
            int r11 = r10 + 1;
            int r8 = r1 - 2;
            if (r11 > r8) goto L49;
            char r12 = r15.charAt(r11);
            if (r12 < '0') goto L93;
            if (r12 > '9') goto L93;
            int r13 = r11 + 1;
            int r17 = r12 - '0';
            char r18 = r15.charAt(r13);
            if (r18 < '0') goto L91;
            if (r18 > '9') goto L91;
            int r19 = r13 + 1;
            int r110 = (r17 * 10) + (r18 - '0');
            if (r110 > 59) goto L61;
            if (r19 == r1) goto L89;
            if (r15.charAt(r19) != ':') goto L89;
            int r20 = r19 + 1;
            if (r20 > r8) goto L69;
            char r21 = r15.charAt(r20);
            if (r21 < '0') goto L87;
            if (r21 > '9') goto L87;
            int r22 = r20 + 1;
            int r23 = r21 - '0';
            char r24 = r15.charAt(r22);
            if (r24 < '0') goto L85;
            if (r24 > '9') goto L85;
            int r25 = r22 + 1;
            int r26 = (r23 * 10) + (r24 - '0');
            if (r26 <= 59) goto L83;
            return ~r25;
        L83:
            return r14.setParsedField(ChronoField.OFFSET_SECONDS, r4 * (((r7 * StringUtil.SECONDS_PER_HOUR) + (r110 * 60)) + r26), r25, r25);
        L85:
            return ~r22;
        L87:
            return ~r20;
        L69:
            return ~r20;
        L89:
            return r14.setParsedField(ChronoField.OFFSET_SECONDS, r4 * ((r7 * StringUtil.SECONDS_PER_HOUR) + (r110 * 60)), r19, r19);
        L61:
            return ~r19;
        L91:
            return ~r13;
        L93:
            return ~r11;
        L49:
            return ~r11;
        L95:
            return r14.setParsedField(ChronoField.OFFSET_SECONDS, (r4 * StringUtil.SECONDS_PER_HOUR) * r7, r10, r10);
        L97:
            return ~r2;
        L25:
            return ~r0;
        L22:
            r4 = 1;
            goto L23
        L13:
            return r14.setParsedField(ChronoField.OFFSET_SECONDS, 0, r0, r0);
        L9:
            return new OffsetIdPrinterParser("", "+HH:MM:ss").parse(r14, r15, r0);
        L5:
            return ~r16;
        }
    }

    static final class LocalizedPrinterParser implements DateTimePrinterParser {
        private final FormatStyle dateStyle;
        private final FormatStyle timeStyle;

        LocalizedPrinterParser(FormatStyle r1, FormatStyle r2) {
            this.dateStyle = r1;
            this.timeStyle = r2;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r3, StringBuilder r4) {
            Chronology r0 = Chronology.from(r3.getTemporal());
            return formatter(r3.getLocale(), r0).toPrinterParser(false).print(r3, r4);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r3, CharSequence r4, int r5) {
            Chronology r0 = r3.getEffectiveChronology();
            return formatter(r3.getLocale(), r0).toPrinterParser(false).parse(r3, r4, r5);
        }

        private DateTimeFormatter formatter(Locale r3, Chronology r4) {
            return DateTimeFormatStyleProvider.getInstance().getFormatter(this.dateStyle, this.timeStyle, r4, r3);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Localized(");
            Object r1 = this.dateStyle;
            Object r2 = "";
            if (r1 != null) goto L6;
            r1 = "";
        L6:
            StringBuilder r3 = r0.append(r1).append(",");
            FormatStyle r4 = this.timeStyle;
            if (r4 == null) goto L10;
            r2 = r4;
        L10:
            return r3.append(r2).append(")").toString();
        }
    }

    static class NumberPrinterParser implements DateTimePrinterParser {
        static final int[] EXCEED_POINTS = null;
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        final SignStyle signStyle;
        final int subsequentWidth;

        long getValue(DateTimePrintContext r1, long r2) {
            return r2;
        }

        /* synthetic */ NumberPrinterParser(TemporalField r1, int r2, int r3, SignStyle r4, int r5, AnonymousClass1 r6) {
            this(r1, r2, r3, r4, r5);
        }

        static {
            EXCEED_POINTS = new int[]{0, 10, 100, 1000, 10000, 100000, 1000000, PoissonDistribution.DEFAULT_MAX_ITERATIONS, 100000000, 1000000000};
        }

        NumberPrinterParser(TemporalField r1, int r2, int r3, SignStyle r4) {
            this.field = r1;
            this.minWidth = r2;
            this.maxWidth = r3;
            this.signStyle = r4;
            this.subsequentWidth = 0;
        }

        private NumberPrinterParser(TemporalField r1, int r2, int r3, SignStyle r4, int r5) {
            this.field = r1;
            this.minWidth = r2;
            this.maxWidth = r3;
            this.signStyle = r4;
            this.subsequentWidth = r5;
        }

        NumberPrinterParser withFixedWidth() {
            if (this.subsequentWidth != (-1)) goto L6;
            return this;
        L6:
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        NumberPrinterParser withSubsequentWidth(int r8) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + r8);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r11, StringBuilder r12) {
            Long r0 = r11.getValue(this.field);
            int r1 = 0;
            if (r0 != null) goto L5;
            return false;
        L5:
            long r2 = getValue(r11, r0.longValue());
            DecimalStyle r13 = r11.getSymbols();
            if (r2 != Long.MIN_VALUE) goto L8;
            String r3 = "9223372036854775808";
        L10:
            if (r3.length() > this.maxWidth) goto L40;
            String r4 = r13.convertNumberToI18N(r3);
            if (r2 < 0) goto L23;
            int r5 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
            if (r5 == 1) goto L18;
            if (r5 != 2) goto L35;
            r12.append(r13.getPositiveSign());
        L35:
            if (r1 >= (this.minWidth - r4.length())) goto L37;
            r12.append(r13.getZeroDigit());
            r1 = r1 + 1;
            goto L35
        L37:
            r12.append(r4);
            return true;
        L18:
            int r6 = this.minWidth;
            if (r6 >= 19) goto L35;
            if (r2 < EXCEED_POINTS[r6]) goto L35;
            r12.append(r13.getPositiveSign());
            goto L35
        L23:
            int r7 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
            if (r7 == 1) goto L33;
            if (r7 == 2) goto L33;
            if (r7 == 3) goto L33;
            if (r7 != 4) goto L35;
            throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + r2 + " cannot be negative according to the SignStyle");
        L33:
            r12.append(r13.getNegativeSign());
            goto L35
        L40:
            throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + r2 + " exceeds the maximum print width of " + this.maxWidth);
        L8:
            r3 = Long.toString(Math.abs(r2));
            goto L10
        }

        boolean isFixedWidth(DateTimeParseContext r2) {
            int r3 = this.subsequentWidth;
            if (r3 == (-1)) goto L11;
            if (r3 > 0) goto L6;
        L10:
            return false;
        L6:
            if (this.minWidth != this.maxWidth) goto L10;
            if (this.signStyle != SignStyle.NOT_NEGATIVE) goto L10;
        L11:
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r20, CharSequence r21, int r22) {
            int r2 = r21.length();
            if (r22 == r2) goto L5;
            char r3 = r21.charAt(r22);
            int r5 = 0;
            if (r3 != r20.getSymbols().getPositiveSign()) goto L18;
            SignStyle r4 = this.signStyle;
            boolean r6 = r20.isStrict();
            if (this.minWidth != this.maxWidth) goto L11;
            boolean r7 = true;
        L13:
            if (r4.parse(true, r6, r7) == false) goto L15;
            int r8 = r22 + 1;
            boolean r1 = false;
            boolean r9 = true;
        L36:
            if (r20.isStrict() == false) goto L38;
        L41:
            int r10 = this.minWidth;
        L42:
            int r11 = r8 + r10;
            if (r11 <= r2) goto L47;
            return ~r8;
        L47:
            if (r20.isStrict() == false) goto L49;
        L52:
            int r12 = this.maxWidth;
        L53:
            int r13 = r12 + Math.max(this.subsequentWidth, 0);
        L54:
            BigInteger r14 = null;
            if (r5 >= 2) goto L77;
            int r15 = Math.min(r13 + r8, r2);
            int r16 = r8;
            long r17 = 0;
        L57:
            if (r16 >= r15) goto L72;
            int r18 = r16 + 1;
            int r19 = r20.getSymbols().convertToDigit(r21.charAt(r16));
            if (r19 < 0) goto L60;
            if ((r18 - r8) <= 18) goto L69;
            if (r14 != null) goto L68;
            r14 = BigInteger.valueOf(r17);
        L68:
            r14 = r14.multiply(BigInteger.TEN).add(BigInteger.valueOf(r19));
        L70:
            r15 = r15;
            r11 = r11;
            r16 = r18;
            goto L57
        L69:
            r17 = (r17 * 10) + ((long) r19);
            goto L70
        L60:
            r16 = r18 - 1;
            if (r16 >= r11) goto L72;
            return ~r8;
        L72:
            int r23 = r11;
            int r24 = this.subsequentWidth;
            if (r24 <= 0) goto L76;
            if (r5 != 0) goto L76;
            r13 = Math.max(r10, (r16 - r8) - r24);
            r5 = r5 + 1;
            r11 = r23;
        L76:
            int r25 = r16;
        L78:
            if (r1 == false) goto L95;
            if (r14 == null) goto L88;
            if (r14.equals(BigInteger.ZERO) == true) goto L83;
        L86:
            r14 = r14.negate();
        L108:
            long r26 = r17;
        L109:
            if (r14 == null) goto L116;
            if (r14.bitLength() <= 63) goto L114;
            r14 = r14.divide(BigInteger.TEN);
            r25 = r25 - 1;
        L114:
            return setValue(r20, r14.longValue(), r8, r25);
        L116:
            return setValue(r20, r26, r8, r25);
        L83:
            if (r20.isStrict() == false) goto L86;
            return ~(r8 - 1);
        L88:
            if (r17 == 0) goto L90;
        L93:
            r26 = -r17;
            goto L109
        L90:
            if (r20.isStrict() == false) goto L93;
            return ~(r8 - 1);
        L95:
            if (this.signStyle != SignStyle.EXCEEDS_PAD) goto L108;
            if (r20.isStrict() == false) goto L108;
            int r27 = r25 - r8;
            if (r9 == false) goto L105;
            if (r27 > this.minWidth) goto L108;
            return ~(r8 - 1);
        L105:
            if (r27 <= this.minWidth) goto L108;
            return ~r8;
        L77:
            r25 = r8;
            r17 = 0;
            goto L78
        L49:
            if (isFixedWidth(r20) == true) goto L52;
            r12 = 9;
            goto L53
        L38:
            if (isFixedWidth(r20) == true) goto L41;
            r10 = 1;
            goto L42
        L15:
            return ~r22;
        L11:
            r7 = false;
            goto L13
        L18:
            if (r3 != r20.getSymbols().getNegativeSign()) goto L29;
            SignStyle r28 = this.signStyle;
            boolean r29 = r20.isStrict();
            if (this.minWidth != this.maxWidth) goto L22;
            boolean r30 = true;
        L24:
            if (r28.parse(false, r29, r30) == false) goto L26;
            r8 = r22 + 1;
            r9 = false;
            r1 = true;
            goto L36
        L26:
            return ~r22;
        L22:
            r30 = false;
            goto L24
        L29:
            if (this.signStyle == SignStyle.ALWAYS) goto L31;
        L34:
            r8 = r22;
            r1 = false;
            r9 = false;
            goto L36
        L31:
            if (r20.isStrict() == false) goto L34;
            return ~r22;
        L5:
            return ~r22;
        }

        int setValue(DateTimeParseContext r7, long r8, int r10, int r11) {
            return r7.setParsedField(this.field, r8, r10, r11);
        }

        public String toString() {
            if (this.minWidth != 1) goto L11;
            if (this.maxWidth != 19) goto L11;
            if (this.signStyle != SignStyle.NORMAL) goto L11;
            return "Value(" + this.field + ")";
        L11:
            if (this.minWidth != this.maxWidth) goto L17;
            if (this.signStyle != SignStyle.NOT_NEGATIVE) goto L17;
            return "Value(" + this.field + "," + this.minWidth + ")";
        L17:
            return "Value(" + this.field + "," + this.minWidth + "," + this.maxWidth + "," + this.signStyle + ")";
        }
    }

    static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        static final OffsetIdPrinterParser INSTANCE_ID = null;
        static final String[] PATTERNS = null;
        private final String noOffsetText;
        private final int type;

        static {
            PATTERNS = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
            INSTANCE_ID = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        }

        OffsetIdPrinterParser(String r2, String r3) {
            Jdk8Methods.requireNonNull(r2, "noOffsetText");
            Jdk8Methods.requireNonNull(r3, "pattern");
            this.noOffsetText = r2;
            this.type = checkPattern(r3);
        }

        private int checkPattern(String r3) {
            int r2 = 0;
        L3:
            String[] r0 = PATTERNS;
            if (r2 >= r0.length) goto L10;
            if (r0[r2].equals(r3) == true) goto L7;
            r2 = r2 + 1;
            goto L3
        L7:
            return r2;
        L10:
            throw new IllegalArgumentException("Invalid zone offset pattern: " + r3);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r9, StringBuilder r10) {
            Long r11 = r9.getValue(ChronoField.OFFSET_SECONDS);
            if (r11 != null) goto L6;
            return false;
        L6:
            int r12 = Jdk8Methods.safeToInt(r11.longValue());
            if (r12 != 0) goto L9;
            r10.append(this.noOffsetText);
        L33:
            return true;
        L9:
            int r1 = Math.abs((r12 / StringUtil.SECONDS_PER_HOUR) % 100);
            int r2 = Math.abs((r12 / 60) % 60);
            int r3 = Math.abs(r12 % 60);
            int r4 = r10.length();
            if (r12 >= 0) goto L12;
            String r13 = "-";
        L13:
            r10.append(r13).append((char) ((r1 / 10) + 48)).append((char) ((r1 % 10) + 48));
            int r14 = this.type;
            if (r14 >= 3) goto L17;
            if (r14 < 1) goto L31;
            if (r2 > 0) goto L17;
        L31:
            if (r1 != 0) goto L33;
            r10.setLength(r4);
            r10.append(this.noOffsetText);
        L17:
            String r5 = ":";
            if ((r14 % 2) != 0) goto L20;
            String r15 = ":";
        L21:
            r10.append(r15).append((char) ((r2 / 10) + 48)).append((char) ((r2 % 10) + 48));
            r1 = r1 + r2;
            int r16 = this.type;
            if (r16 >= 7) goto L27;
            if (r16 < 5) goto L31;
            if (r3 <= 0) goto L31;
        L27:
            if ((r16 % 2) == 0) goto L30;
            r5 = "";
        L30:
            r10.append(r5).append((char) ((r3 / 10) + 48)).append((char) ((r3 % 10) + 48));
            r1 = r1 + r3;
            goto L31
        L20:
            r15 = "";
            goto L21
        L12:
            r13 = CustomKeyUtils.KEY_SEPARATE_FOR_SHOW;
            goto L13
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r16, CharSequence r17, int r18) {
            int r1 = r17.length();
            int r9 = this.noOffsetText.length();
            if (r9 != 0) goto L7;
            if (r18 == r1) goto L6;
        L14:
            char r2 = r17.charAt(r18);
            if (r2 == '+') goto L18;
            if (r2 == '-') goto L18;
        L37:
            if (r9 != 0) goto L41;
            return r16.setParsedField(ChronoField.OFFSET_SECONDS, 0, r18, r18 + r9);
        L41:
            return ~r18;
        L18:
            if (r2 != '-') goto L20;
            int r3 = -1;
        L21:
            int[] r4 = new int[4];
            r4[0] = r18 + 1;
            if (parseNumber(r4, 1, r17, true) == false) goto L24;
        L33:
            boolean r0 = true;
        L34:
            if (r0 == true) goto L37;
            return r16.setParsedField(ChronoField.OFFSET_SECONDS, ((long) r3) * (((((long) r4[1]) * TimeUtils.SECONDS_PER_HOUR) + (((long) r4[2]) * 60)) + ((long) r4[3])), r18, r4[0]);
        L24:
            if (this.type < 3) goto L26;
            boolean r5 = true;
        L28:
            if (parseNumber(r4, 2, r17, r5) == true) goto L33;
            if (parseNumber(r4, 3, r17, false) == true) goto L33;
            r0 = false;
            goto L34
        L26:
            r5 = false;
            goto L28
        L20:
            r3 = 1;
            goto L21
        L6:
            return r16.setParsedField(ChronoField.OFFSET_SECONDS, 0, r18, r18);
        L7:
            if (r18 != r1) goto L11;
            return ~r18;
        L11:
            if (r16.subSequenceEquals(r17, r18, this.noOffsetText, 0, r9) == false) goto L14;
            return r16.setParsedField(ChronoField.OFFSET_SECONDS, 0, r18, r18 + r9);
        }

        private boolean parseNumber(int[] r5, int r6, CharSequence r7, boolean r8) {
            int r4 = this.type;
            if (((r4 + 3) / 2) >= r6) goto L5;
            return false;
        L5:
            int r0 = r5[0];
            if ((r4 % 2) != 0) goto L17;
            if (r6 <= 1) goto L17;
            int r9 = r0 + 1;
            if (r9 <= r7.length()) goto L12;
        L15:
            return r8;
        L12:
            if (r7.charAt(r0) != ':') goto L15;
            r0 = r9;
        L17:
            if ((r0 + 2) <= r7.length()) goto L19;
            return r8;
        L19:
            int r10 = r0 + 1;
            char r1 = r7.charAt(r0);
            int r2 = r10 + 1;
            char r11 = r7.charAt(r10);
            if (r1 >= '0') goto L22;
        L33:
            return r8;
        L22:
            if (r1 > '9') goto L33;
            if (r11 < '0') goto L33;
            if (r11 > '9') goto L33;
            int r3 = ((r1 - '0') * 10) + (r11 - '0');
            if (r3 < 0) goto L33;
            if (r3 > 59) goto L33;
            r5[r6] = r3;
            r5[0] = r2;
            return false;
        }

        public String toString() {
            return "Offset(" + PATTERNS[this.type] + ",'" + this.noOffsetText.replace("'", "''") + "')";
        }
    }

    static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser r1, int r2, char r3) {
            this.printerParser = r1;
            this.padWidth = r2;
            this.padChar = r3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r4, StringBuilder r5) {
            int r0 = r5.length();
            int r1 = 0;
            if (this.printerParser.print(r4, r5) == true) goto L5;
            return false;
        L5:
            int r6 = r5.length() - r0;
            if (r6 > this.padWidth) goto L13;
        L8:
            if (r1 >= (this.padWidth - r6)) goto L10;
            r5.insert(r0, this.padChar);
            r1 = r1 + 1;
            goto L8
        L10:
            return true;
        L13:
            throw new DateTimeException("Cannot print as output of " + r6 + " characters exceeds pad width of " + this.padWidth);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r7, CharSequence r8, int r9) {
            boolean r0 = r7.isStrict();
            boolean r1 = r7.isCaseSensitive();
            if (r9 > r8.length()) goto L29;
            if (r9 == r8.length()) goto L7;
            int r2 = this.padWidth + r9;
            if (r2 <= r8.length()) goto L14;
            if (r0 == true) goto L12;
            r2 = r8.length();
            goto L14
        L12:
            return ~r9;
        L14:
            int r3 = r9;
        L15:
            if (r3 >= r2) goto L23;
            char r4 = r8.charAt(r3);
            char r5 = this.padChar;
            if (r1 == false) goto L21;
            if (r4 != r5) goto L23;
        L22:
            r3 = r3 + 1;
            goto L15
        L21:
            if (r7.charEquals(r4, r5) == true) goto L22;
        L23:
            CharSequence r10 = r8.subSequence(0, r2);
            int r6 = this.printerParser.parse(r7, r10, r3);
            if (r6 == r2) goto L35;
            if (r0 == true) goto L27;
            return r6;
        L27:
            return ~(r9 + r3);
        L35:
            return r6;
        L7:
            return ~r9;
        L29:
            throw new IndexOutOfBoundsException();
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Pad(").append(this.printerParser).append(",").append(this.padWidth);
            if (this.padChar != ' ') goto L5;
            String r3 = ")";
        L7:
            return r0.append(r3).toString();
        L5:
            r3 = ",'" + this.padChar + "')";
            goto L7
        }
    }

    static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = null;
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        /* bridge */ /* synthetic */ NumberPrinterParser withSubsequentWidth(int r1) {
            return withSubsequentWidth(r1);
        }

        static {
            BASE_DATE = LocalDate.of(2000, 1, 1);
        }

        ReducedPrinterParser(TemporalField r3, int r4, int r5, int r6, ChronoLocalDate r7) {
            super(r3, r4, r5, SignStyle.NOT_NEGATIVE);
            if (r4 < 1) goto L26;
            if (r4 > 10) goto L26;
            if (r5 < 1) goto L24;
            if (r5 > 10) goto L24;
            if (r5 < r4) goto L22;
            if (r7 != null) goto L19;
            long r0 = r6;
            if (r3.range().isValidValue(r0) == false) goto L18;
            if ((r0 + ((long) EXCEED_POINTS[r4])) <= 2147483647L) goto L19;
            throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
        L18:
            throw new IllegalArgumentException("The base value must be within the range of the field");
        L19:
            this.baseValue = r6;
            this.baseDate = r7;
            return;
        L22:
            throw new IllegalArgumentException("The maxWidth must be greater than the width");
        L24:
            throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + r5);
        L26:
            throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + r4);
        }

        private ReducedPrinterParser(TemporalField r8, int r9, int r10, int r11, ChronoLocalDate r12, int r13) {
            super(r8, r9, r10, SignStyle.NOT_NEGATIVE, r13, null);
            this.baseValue = r11;
            this.baseDate = r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        long getValue(DateTimePrintContext r6, long r7) {
            long r0 = Math.abs(r7);
            int r2 = this.baseValue;
            if (this.baseDate == null) goto L6;
            r2 = Chronology.from(r6.getTemporal()).date(this.baseDate).get(this.field);
        L6:
            if (r7 < r2) goto L12;
            if (r7 >= (r2 + EXCEED_POINTS[this.minWidth])) goto L12;
            return r0 % ((long) EXCEED_POINTS[this.minWidth]);
        L12:
            return r0 % ((long) EXCEED_POINTS[this.maxWidth]);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        int setValue(DateTimeParseContext r8, long r9, int r11, int r12) {
            int r0 = this.baseValue;
            if (this.baseDate == null) goto L6;
            r0 = r8.getEffectiveChronology().date(this.baseDate).get(this.field);
            r8.addChronologyChangedParser(this, r9, r11, r12);
        L6:
            if ((r12 - r11) != this.minWidth) goto L17;
            if (r9 < 0) goto L17;
            long r1 = EXCEED_POINTS[this.minWidth];
            long r3 = r0;
            long r5 = r3 - (r3 % r1);
            if (r0 <= 0) goto L12;
            long r6 = r5 + r9;
        L13:
            r9 = r6;
            if (r9 >= r3) goto L17;
            r9 = r9 + r1;
            goto L17
        L12:
            r6 = r5 - r9;
        L17:
            return r8.setParsedField(this.field, r9, r11, r12);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        NumberPrinterParser withFixedWidth() {
            if (this.subsequentWidth != (-1)) goto L6;
            return this;
        L6:
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        ReducedPrinterParser withSubsequentWidth(int r9) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + r9);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext r2) {
            if (r2.isStrict() == true) goto L7;
            return false;
        L7:
            return super.isFixedWidth(r2);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder r0 = new StringBuilder("ReducedValue(").append(this.field).append(",").append(this.minWidth).append(",").append(this.maxWidth).append(",");
            Object r1 = this.baseDate;
            if (r1 != null) goto L7;
            r1 = Integer.valueOf(this.baseValue);
        L7:
            return r0.append(r1).append(")").toString();
        }
    }

    static final enum SettingsParser extends Enum<SettingsParser> implements DateTimePrinterParser {
        private static final /* synthetic */ SettingsParser[] $VALUES = null;
        public static final SettingsParser INSENSITIVE = null;
        public static final SettingsParser LENIENT = null;
        public static final SettingsParser SENSITIVE = null;
        public static final SettingsParser STRICT = null;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            return true;
        }

        private SettingsParser(String r1, int r2) {
            super(r1, r2);
        }

        public static SettingsParser valueOf(String r1) {
            return (SettingsParser) Enum.valueOf(SettingsParser.class, r1);
        }

        public static SettingsParser[] values() {
            return (SettingsParser[]) $VALUES.clone();
        }

        static {
            SettingsParser r0 = new SettingsParser("SENSITIVE", 0);
            SENSITIVE = r0;
            SettingsParser r1 = new SettingsParser("INSENSITIVE", 1);
            INSENSITIVE = r1;
            SettingsParser r3 = new SettingsParser("STRICT", 2);
            STRICT = r3;
            SettingsParser r5 = new SettingsParser("LENIENT", 3);
            LENIENT = r5;
            $VALUES = new SettingsParser[]{r0, r1, r3, r5};
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r3, CharSequence r4, int r5) {
            int r2 = ordinal();
            if (r2 != 0) goto L5;
            r3.setCaseSensitive(true);
        L15:
            return r5;
        L5:
            if (r2 != 1) goto L7;
            r3.setCaseSensitive(false);
            goto L15
        L7:
            if (r2 != 2) goto L9;
            r3.setStrict(true);
            goto L15
        L9:
            if (r2 != 3) goto L15;
            r3.setStrict(false);
            goto L15
        }

        @Override // java.lang.Enum
        public String toString() {
            int r1 = ordinal();
            if (r1 != 0) goto L5;
            return "ParseCaseSensitive(true)";
        L5:
            if (r1 != 1) goto L7;
            return "ParseCaseSensitive(false)";
        L7:
            if (r1 != 2) goto L9;
            return "ParseStrict(true)";
        L9:
            if (r1 != 3) goto L13;
            return "ParseStrict(false)";
        L13:
            throw new IllegalStateException("Unreachable");
        }
    }

    static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        StringLiteralPrinterParser(String r1) {
            this.literal = r1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            r2.append(this.literal);
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r8, CharSequence r9, int r10) {
            if (r10 > r9.length()) goto L12;
            if (r10 < 0) goto L12;
            String r4 = this.literal;
            if (r8.subSequenceEquals(r9, r10, r4, 0, r4.length()) == true) goto L10;
            return ~r10;
        L10:
            return r10 + this.literal.length();
        L12:
            throw new IndexOutOfBoundsException();
        }

        public String toString() {
            return "'" + this.literal.replace("'", "''") + "'";
        }
    }

    static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField r1, TextStyle r2, DateTimeTextProvider r3) {
            this.field = r1;
            this.textStyle = r2;
            this.provider = r3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r8, StringBuilder r9) {
            Long r0 = r8.getValue(this.field);
            if (r0 != null) goto L6;
            return false;
        L6:
            String r1 = this.provider.getText(this.field, r0.longValue(), this.textStyle, r8.getLocale());
            if (r1 == null) goto L9;
            r9.append(r1);
            return true;
        L9:
            return numberPrinterParser().print(r8, r9);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r11, CharSequence r12, int r13) {
            int r0 = r12.length();
            if (r13 < 0) goto L24;
            if (r13 > r0) goto L24;
            if (r11.isStrict() == false) goto L8;
            TextStyle r1 = this.textStyle;
        L9:
            Iterator<Map.Entry<String, Long>> r2 = this.provider.getTextIterator(this.field, r1, r11.getLocale());
            if (r2 == null) goto L22;
        L12:
            if (r2.hasNext() == false) goto L18;
            Map.Entry<String, Long> r3 = r2.next();
            String r4 = r3.getKey();
            if (r11.subSequenceEquals(r4, 0, r12, r13, r4.length()) == false) goto L12;
            return r11.setParsedField(this.field, r3.getValue().longValue(), r13, r13 + r4.length());
        L18:
            if (r11.isStrict() == false) goto L22;
            return ~r13;
        L22:
            return numberPrinterParser().parse(r11, r12, r13);
        L8:
            r1 = null;
        L24:
            throw new IndexOutOfBoundsException();
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser != null) goto L6;
            this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
        L6:
            return this.numberPrinterParser;
        }

        public String toString() {
            if (this.textStyle != TextStyle.FULL) goto L7;
            return "Text(" + this.field + ")";
        L7:
            return "Text(" + this.field + "," + this.textStyle + ")";
        }
    }

    static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final int count;
        private final char letter;

        public WeekFieldsPrinterParser(char r1, int r2) {
            this.letter = r1;
            this.count = r2;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r2, StringBuilder r3) {
            return evaluate(WeekFields.of(r2.getLocale())).print(r2, r3);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r2, CharSequence r3, int r4) {
            return evaluate(WeekFields.of(r2.getLocale())).parse(r2, r3, r4);
        }

        private DateTimePrinterParser evaluate(WeekFields r18) {
            char r1 = this.letter;
            if (r1 == 'W') goto L26;
            if (r1 == 'Y') goto L18;
            if (r1 != 'c') goto L9;
            NumberPrinterParser r2 = new NumberPrinterParser(r18.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
        L28:
            return r2;
        L9:
            if (r1 != 'e') goto L11;
            r2 = new NumberPrinterParser(r18.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
            goto L28
        L11:
            if (r1 == 'w') goto L13;
            return null;
        L13:
            r2 = new NumberPrinterParser(r18.weekOfWeekBasedYear(), this.count, 2, SignStyle.NOT_NEGATIVE);
            goto L28
        L18:
            if (this.count == 2) goto L29;
            TemporalField r11 = r18.weekBasedYear();
            int r12 = this.count;
            int r13 = 19;
            if (r12 >= 4) goto L23;
            SignStyle r0 = SignStyle.NORMAL;
        L24:
            r2 = new NumberPrinterParser(r11, r12, r13, r0, -1, null);
            goto L28
        L23:
            r0 = SignStyle.EXCEEDS_PAD;
            goto L24
        L29:
            return new ReducedPrinterParser(r18.weekBasedYear(), 2, 2, 0, ReducedPrinterParser.BASE_DATE);
        L26:
            return new NumberPrinterParser(r18.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(30);
            r0.append("Localized(");
            char r1 = this.letter;
            if (r1 != 'Y') goto L16;
            int r2 = this.count;
            if (r2 != 1) goto L8;
            r0.append("WeekBasedYear");
        L28:
            r0.append(")");
            return r0.toString();
        L8:
            if (r2 != 2) goto L10;
            r0.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
            goto L28
        L10:
            StringBuilder r3 = r0.append("WeekBasedYear,").append(this.count).append(",19,");
            if (this.count >= 4) goto L13;
            SignStyle r4 = SignStyle.NORMAL;
        L14:
            r3.append(r4);
            goto L28
        L13:
            r4 = SignStyle.EXCEEDS_PAD;
            goto L14
        L16:
            if (r1 != 'c') goto L18;
        L26:
            r0.append("DayOfWeek");
        L27:
            r0.append(",");
            r0.append(this.count);
            goto L28
        L18:
            if (r1 == 'e') goto L26;
            if (r1 != 'w') goto L24;
            r0.append("WeekOfWeekBasedYear");
            goto L27
        L24:
            if (r1 != 'W') goto L27;
            r0.append("WeekOfMonth");
            goto L27
        }
    }

    static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, SubstringTree> cachedSubstringTree;
        private final String description;
        private final TemporalQuery<ZoneId> query;

        private static final class SubstringTree {
            final int length;
            private final Map<CharSequence, SubstringTree> substringMap;
            private final Map<String, SubstringTree> substringMapCI;

            /* synthetic */ SubstringTree(int r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ SubstringTree access$100(SubstringTree r0, CharSequence r1, boolean r2) {
                return r0.get(r1, r2);
            }

            static /* synthetic */ void access$300(SubstringTree r0, String r1) {
                r0.add(r1);
            }

            private SubstringTree(int r2) {
                this.substringMap = new HashMap();
                this.substringMapCI = new HashMap();
                this.length = r2;
            }

            private SubstringTree get(CharSequence r1, boolean r2) {
                if (r2 == false) goto L6;
                return this.substringMap.get(r1);
            L6:
                return this.substringMapCI.get(r1.toString().toLowerCase(Locale.ENGLISH));
            }

            private void add(String r4) {
                int r0 = r4.length();
                int r1 = this.length;
                if (r0 != r1) goto L5;
                this.substringMap.put(r4, null);
                this.substringMapCI.put(r4.toLowerCase(Locale.ENGLISH), null);
                return;
            L5:
                if (r0 <= r1) goto L12;
                String r2 = r4.substring(0, r1);
                SubstringTree r3 = this.substringMap.get(r2);
                if (r3 != null) goto L9;
                r3 = new SubstringTree(r0);
                this.substringMap.put(r2, r3);
                this.substringMapCI.put(r2.toLowerCase(Locale.ENGLISH), r3);
            L9:
                r3.add(r4);
                return;
            }
        }

        ZoneIdPrinterParser(TemporalQuery<ZoneId> r1, String r2) {
            this.query = r1;
            this.description = r2;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r1, StringBuilder r2) {
            ZoneId r0 = (ZoneId) r1.getValue(this.query);
            if (r0 != null) goto L6;
            return false;
        L6:
            r2.append(r0.getId());
            return true;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r9, CharSequence r10, int r11) {
            int r0 = r10.length();
            if (r11 > r0) goto L75;
            if (r11 == r0) goto L6;
            char r1 = r10.charAt(r11);
            if (r1 != '+') goto L10;
        L69:
            DateTimeParseContext r8 = r9.copy();
            int r12 = OffsetIdPrinterParser.INSTANCE_ID.parse(r8, r10, r11);
            if (r12 >= 0) goto L72;
            return r12;
        L72:
            r9.setParsed(ZoneOffset.ofTotalSeconds((int) r8.getParsed(ChronoField.OFFSET_SECONDS).longValue()));
            return r12;
        L10:
            if (r1 == '-') goto L69;
            int r2 = r11 + 2;
            if (r0 < r2) goto L36;
            char r3 = r10.charAt(r11 + 1);
            if (r9.charEquals(r1, 'U') == false) goto L27;
            if (r9.charEquals(r3, 'T') == false) goto L27;
            int r4 = r11 + 3;
            if (r0 < r4) goto L25;
            if (r9.charEquals(r10.charAt(r2), 'C') == false) goto L25;
            return parsePrefixedOffset(r9, r10, r11, r4);
        L25:
            return parsePrefixedOffset(r9, r10, r11, r2);
        L27:
            if (r9.charEquals(r1, 'G') == false) goto L36;
            int r5 = r11 + 3;
            if (r0 < r5) goto L36;
            if (r9.charEquals(r3, 'M') == false) goto L36;
            if (r9.charEquals(r10.charAt(r2), 'T') == false) goto L36;
            return parsePrefixedOffset(r9, r10, r11, r5);
        L36:
            Set<String> r6 = ZoneRulesProvider.getAvailableZoneIds();
            int r7 = r6.size();
            Map.Entry<Integer, SubstringTree> r13 = cachedSubstringTree;
            if (r13 != null) goto L39;
        L40:
            monitor-enter(this);
            r13 = cachedSubstringTree;     // Catch: Throwable -> L66
            if (r13 != null) goto L44;
        L45:
            r13 = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(r7), prepareParser(r6));     // Catch: Throwable -> L66
            cachedSubstringTree = r13;     // Catch: Throwable -> L66
        L46:
            monitor-exit(this);     // Catch: Throwable -> L66
        L47:
            SubstringTree r14 = r13.getValue();
            String r15 = null;
            String r16 = null;
        L48:
            if (r14 == null) goto L53;
            int r17 = r14.length + r11;
            if (r17 > r0) goto L53;
            String r18 = r10.subSequence(r11, r17).toString();
            r14 = SubstringTree.access$100(r14, r18, r9.isCaseSensitive());
            r16 = r15;
            r15 = r18;
        L53:
            ZoneId r19 = convertToZone(r6, r15, r9.isCaseSensitive());
            if (r19 != null) goto L64;
            r19 = convertToZone(r6, r16, r9.isCaseSensitive());
            if (r19 == null) goto L58;
            r15 = r16;
            goto L64
        L58:
            if (r9.charEquals(r1, 'Z') == false) goto L62;
            r9.setParsed(ZoneOffset.UTC);
            return r11 + 1;
        L62:
            return ~r11;
        L64:
            r9.setParsed(r19);
            return r11 + r15.length();
        L44:
            if (r13.getKey().intValue() == r7) goto L46;
        L66:
            th = move-exception;
            throw th;
        L39:
            if (r13.getKey().intValue() == r7) goto L47;
        L6:
            return ~r11;
        L75:
            throw new IndexOutOfBoundsException();
        }

        private ZoneId convertToZone(Set<String> r2, String r3, boolean r4) {
            if (r3 != null) goto L5;
            return null;
        L5:
            if (r4 == true) goto L7;
            Iterator<String> r5 = r2.iterator();
        L12:
            if (r5.hasNext() == false) goto L21;
            String r6 = r5.next();
            if (r6.equalsIgnoreCase(r3) == false) goto L12;
            return ZoneId.of(r6);
        L21:
            return null;
        L7:
            if (r2.contains(r3) == true) goto L9;
            return null;
        L9:
            return ZoneId.of(r3);
        }

        private int parsePrefixedOffset(DateTimeParseContext r3, CharSequence r4, int r5, int r6) {
            String r2 = r4.subSequence(r5, r6).toString().toUpperCase();
            DateTimeParseContext r7 = r3.copy();
            if (r6 < r4.length()) goto L5;
        L8:
            int r8 = OffsetIdPrinterParser.INSTANCE_ID.parse(r7, r4, r6);
            if (r8 >= 0) goto L12;
            r3.setParsed(ZoneId.ofOffset(r2, ZoneOffset.UTC));
            return r6;
        L12:
            r3.setParsed(ZoneId.ofOffset(r2, ZoneOffset.ofTotalSeconds((int) r7.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
            return r8;
        L5:
            if (r3.charEquals(r4.charAt(r6), 'Z') == false) goto L8;
            r3.setParsed(ZoneId.ofOffset(r2, ZoneOffset.UTC));
            return r6;
        }

        private static SubstringTree prepareParser(Set<String> r3) {
            ArrayList r0 = new ArrayList(r3);
            Collections.sort(r0, DateTimeFormatterBuilder.LENGTH_SORT);
            SubstringTree r4 = new SubstringTree(((String) r0.get(0)).length(), null);
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            SubstringTree.access$300(r4, (String) r1.next());
            goto L4
        L6:
            return r4;
        }

        public String toString() {
            return this.description;
        }
    }

    static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> LENGTH_COMPARATOR = null;
        private final TextStyle textStyle;

        static {
            LENGTH_COMPARATOR = new AnonymousClass1();
        }

        ZoneTextPrinterParser(TextStyle r2) {
            this.textStyle = (TextStyle) Jdk8Methods.requireNonNull(r2, "textStyle");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext r7, StringBuilder r8) {
            ZoneId r0 = (ZoneId) r7.getValue(TemporalQueries.zoneId());
            int r1 = 0;
            if (r0 != null) goto L6;
            return false;
        L6:
            if ((r0.normalized() instanceof ZoneOffset) == false) goto L9;
            r8.append(r0.getId());
            return true;
        L9:
            TemporalAccessor r2 = r7.getTemporal();
            if (r2.isSupported(ChronoField.INSTANT_SECONDS) == false) goto L12;
            boolean r3 = r0.getRules().isDaylightSavings(Instant.ofEpochSecond(r2.getLong(ChronoField.INSTANT_SECONDS)));
        L13:
            TimeZone r4 = TimeZone.getTimeZone(r0.getId());
            if (this.textStyle.asNormal() != TextStyle.FULL) goto L16;
            r1 = 1;
        L16:
            r8.append(r4.getDisplayName(r3, r1, r7.getLocale()));
            return true;
        L12:
            r3 = false;
            goto L13
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext r9, CharSequence r10, int r11) {
            TreeMap r0 = new TreeMap(LENGTH_COMPARATOR);
            Iterator<String> r1 = ZoneId.getAvailableZoneIds().iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            String r2 = r1.next();
            r0.put(r2, r2);
            TimeZone r3 = TimeZone.getTimeZone(r2);
            if (this.textStyle.asNormal() != TextStyle.FULL) goto L8;
            int r4 = 1;
        L9:
            r0.put(r3.getDisplayName(false, r4, r9.getLocale()), r2);
            r0.put(r3.getDisplayName(true, r4, r9.getLocale()), r2);
            goto L4
        L8:
            r4 = 0;
            goto L9
        L10:
            Iterator r8 = r0.entrySet().iterator();
        L12:
            if (r8.hasNext() == false) goto L18;
            Map.Entry r5 = (Map.Entry) r8.next();
            String r6 = (String) r5.getKey();
            if (r9.subSequenceEquals(r10, r11, r6, 0, r6.length()) == false) goto L12;
            r9.setParsed(ZoneId.of((String) r5.getValue()));
            return r11 + r6.length();
        L18:
            return ~r11;
        }

        public String toString() {
            return "ZoneText(" + this.textStyle + ")";
        }
    }

    static {
        QUERY_REGION_ONLY = new AnonymousClass1();
        HashMap r0 = new HashMap();
        FIELD_MAP = r0;
        r0.put('G', ChronoField.ERA);
        r0.put('y', ChronoField.YEAR_OF_ERA);
        r0.put(Character.valueOf(ULocale.UNICODE_LOCALE_EXTENSION), ChronoField.YEAR);
        r0.put('Q', IsoFields.QUARTER_OF_YEAR);
        r0.put('q', IsoFields.QUARTER_OF_YEAR);
        r0.put('M', ChronoField.MONTH_OF_YEAR);
        r0.put('L', ChronoField.MONTH_OF_YEAR);
        r0.put('D', ChronoField.DAY_OF_YEAR);
        r0.put('d', ChronoField.DAY_OF_MONTH);
        r0.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        r0.put('E', ChronoField.DAY_OF_WEEK);
        r0.put('c', ChronoField.DAY_OF_WEEK);
        r0.put('e', ChronoField.DAY_OF_WEEK);
        r0.put('a', ChronoField.AMPM_OF_DAY);
        r0.put('H', ChronoField.HOUR_OF_DAY);
        r0.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        r0.put('K', ChronoField.HOUR_OF_AMPM);
        r0.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        r0.put('m', ChronoField.MINUTE_OF_HOUR);
        r0.put('s', ChronoField.SECOND_OF_MINUTE);
        r0.put('S', ChronoField.NANO_OF_SECOND);
        r0.put('A', ChronoField.MILLI_OF_DAY);
        r0.put('n', ChronoField.NANO_OF_SECOND);
        r0.put('N', ChronoField.NANO_OF_DAY);
        LENGTH_SORT = new AnonymousClass3();
    }

    public static String getLocalizedDateTimePattern(FormatStyle r1, FormatStyle r2, Chronology r3, Locale r4) {
        Jdk8Methods.requireNonNull(r4, "locale");
        Jdk8Methods.requireNonNull(r3, "chrono");
        if (r1 != null) goto L8;
        if (r2 != null) goto L8;
        throw new IllegalArgumentException("Either dateStyle or timeStyle must be non-null");
    L8:
        if (r1 == null) goto L12;
        if (r2 == null) goto L11;
        DateFormat r5 = DateFormat.getDateTimeInstance(r1.ordinal(), r2.ordinal(), r4);
    L14:
        if ((r5 instanceof SimpleDateFormat) == false) goto L18;
        return ((SimpleDateFormat) r5).toPattern();
    L18:
        throw new IllegalArgumentException("Unable to determine pattern");
    L11:
        r5 = DateFormat.getDateInstance(r1.ordinal(), r4);
        goto L14
    L12:
        r5 = DateFormat.getTimeInstance(r2.ordinal(), r4);
        goto L14
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder r2, boolean r3) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = r2;
        this.optional = r3;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseStrict() {
        appendInternal(SettingsParser.STRICT);
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatterBuilder parseDefaulting(TemporalField r2, long r3) {
        Jdk8Methods.requireNonNull(r2, "field");
        appendInternal(new DefaultingParser(r2, r3));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField r5) {
        Jdk8Methods.requireNonNull(r5, "field");
        appendValue(new NumberPrinterParser(r5, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField r3, int r4) {
        Jdk8Methods.requireNonNull(r3, "field");
        if (r4 < 1) goto L9;
        if (r4 > 19) goto L9;
        appendValue(new NumberPrinterParser(r3, r4, r4, SignStyle.NOT_NEGATIVE));
        return this;
    L9:
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + r4);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField r3, int r4, int r5, SignStyle r6) {
        if (r4 == r5) goto L4;
    L7:
        Jdk8Methods.requireNonNull(r3, "field");
        Jdk8Methods.requireNonNull(r6, "signStyle");
        if (r4 < 1) goto L21;
        if (r4 > 19) goto L21;
        if (r5 < 1) goto L19;
        if (r5 > 19) goto L19;
        if (r5 < r4) goto L17;
        appendValue(new NumberPrinterParser(r3, r4, r5, r6));
        return this;
    L17:
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + r5 + " < " + r4);
    L19:
        throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + r5);
    L21:
        throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + r4);
    L4:
        if (r6 != SignStyle.NOT_NEGATIVE) goto L7;
        return appendValue(r3, r5);
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField r8, int r9, int r10, int r11) {
        Jdk8Methods.requireNonNull(r8, "field");
        appendValue(new ReducedPrinterParser(r8, r9, r10, r11, null));
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField r8, int r9, int r10, ChronoLocalDate r11) {
        Jdk8Methods.requireNonNull(r8, "field");
        Jdk8Methods.requireNonNull(r11, "baseDate");
        appendValue(new ReducedPrinterParser(r8, r9, r10, 0, r11));
        return this;
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser r5) {
        DateTimeFormatterBuilder r0 = this.active;
        int r1 = r0.valueParserIndex;
        if (r1 >= 0) goto L5;
    L13:
        DateTimeFormatterBuilder r2 = this.active;
        r2.valueParserIndex = appendInternal(r5);
    L14:
        return this;
    L5:
        if ((r0.printerParsers.get(r1) instanceof NumberPrinterParser) == false) goto L13;
        DateTimeFormatterBuilder r3 = this.active;
        int r4 = r3.valueParserIndex;
        NumberPrinterParser r6 = (NumberPrinterParser) r3.printerParsers.get(r4);
        if (r5.minWidth == r5.maxWidth) goto L9;
    L11:
        NumberPrinterParser r7 = r6.withFixedWidth();
        DateTimeFormatterBuilder r8 = this.active;
        r8.valueParserIndex = appendInternal(r5);
    L12:
        this.active.printerParsers.set(r4, r7);
        goto L14
    L9:
        if (r5.signStyle != SignStyle.NOT_NEGATIVE) goto L11;
        r7 = r6.withSubsequentWidth(r5.maxWidth);
        appendInternal(r5.withFixedWidth());
        this.active.valueParserIndex = r4;
        goto L12
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField r2, int r3, int r4, boolean r5) {
        appendInternal(new FractionPrinterParser(r2, r3, r4, r5));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField r2) {
        return appendText(r2, TextStyle.FULL);
    }

    public DateTimeFormatterBuilder appendText(TemporalField r3, TextStyle r4) {
        Jdk8Methods.requireNonNull(r3, "field");
        Jdk8Methods.requireNonNull(r4, "textStyle");
        appendInternal(new TextPrinterParser(r3, r4, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField r3, Map<Long, String> r4) {
        Jdk8Methods.requireNonNull(r3, "field");
        Jdk8Methods.requireNonNull(r4, "textLookup");
        LinkedHashMap r0 = new LinkedHashMap(r4);
        final SimpleDateTimeTextProvider.LocaleStore r1 = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(TextStyle.FULL, r0));
        DateTimeTextProvider r5 = new AnonymousClass2(this, r1);
        appendInternal(new TextPrinterParser(r3, TextStyle.FULL, r5));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant(int r3) {
        if (r3 < (-1)) goto L9;
        if (r3 > 9) goto L9;
        appendInternal(new InstantPrinterParser(r3));
        return this;
    L9:
        throw new IllegalArgumentException("Invalid fractional digits: " + r3);
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID);
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String r2, String r3) {
        appendInternal(new OffsetIdPrinterParser(r3, r2));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle r2) {
        Jdk8Methods.requireNonNull(r2, "style");
        if (r2 != TextStyle.FULL) goto L5;
    L9:
        appendInternal(new LocalizedOffsetPrinterParser(r2));
        return this;
    L5:
        if (r2 == TextStyle.SHORT) goto L9;
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneOrOffsetId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zone(), "ZoneOrOffsetId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle r2) {
        appendInternal(new ZoneTextPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle r2, Set<ZoneId> r3) {
        Jdk8Methods.requireNonNull(r3, "preferredZones");
        appendInternal(new ZoneTextPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyId() {
        appendInternal(new ChronoPrinterParser(null));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyText(TextStyle r2) {
        Jdk8Methods.requireNonNull(r2, "textStyle");
        appendInternal(new ChronoPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalized(FormatStyle r2, FormatStyle r3) {
        if (r2 != null) goto L7;
        if (r3 != null) goto L7;
        throw new IllegalArgumentException("Either the date or time style must be non-null");
    L7:
        appendInternal(new LocalizedPrinterParser(r2, r3));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char r2) {
        appendInternal(new CharLiteralPrinterParser(r2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String r3) {
        Jdk8Methods.requireNonNull(r3, "literal");
        if (r3.length() > 0) goto L5;
    L8:
        return this;
    L5:
        if (r3.length() != 1) goto L7;
        appendInternal(new CharLiteralPrinterParser(r3.charAt(0)));
        goto L8
    L7:
        appendInternal(new StringLiteralPrinterParser(r3));
        goto L8
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        appendInternal(r2.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        appendInternal(r2.toPrinterParser(true));
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String r2) {
        Jdk8Methods.requireNonNull(r2, "pattern");
        parsePattern(r2);
        return this;
    }

    private void parsePattern(String r13) {
        int r1 = 0;
    L4:
        if (r1 >= r13.length()) goto L158;
        char r2 = r13.charAt(r1);
        if (r2 < 'A') goto L8;
        if (r2 > 'Z') goto L8;
    L10:
        int r8 = r1 + 1;
    L12:
        if (r8 >= r13.length()) goto L16;
        if (r13.charAt(r8) != r2) goto L16;
        r8 = r8 + 1;
    L16:
        int r3 = r8 - r1;
        if (r2 == 'p') goto L19;
    L37:
        TemporalField r4 = FIELD_MAP.get(Character.valueOf(r2));
        if (r4 == null) goto L41;
        parseField(r2, r3, r4);
    L113:
        r1 = r8 - 1;
    L155:
        r1 = r1 + 1;
        goto L4
    L41:
        if (r2 != 'z') goto L49;
        if (r3 > 4) goto L47;
        if (r3 != 4) goto L45;
        appendZoneText(TextStyle.FULL);
        goto L113
    L45:
        appendZoneText(TextStyle.SHORT);
        goto L113
    L47:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L49:
        if (r2 != 'V') goto L54;
        if (r3 != 2) goto L53;
        appendZoneId();
        goto L113
    L53:
        throw new IllegalArgumentException("Pattern letter count must be 2: " + r2);
    L54:
        String r10 = "+0000";
        if (r2 != 'Z') goto L65;
        if (r3 >= 4) goto L58;
        appendOffset("+HHMM", "+0000");
        goto L113
    L58:
        if (r3 != 4) goto L60;
        appendLocalizedOffset(TextStyle.FULL);
        goto L113
    L60:
        if (r3 != 5) goto L63;
        appendOffset("+HH:MM:ss", "Z");
        goto L113
    L63:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L65:
        if (r2 != 'O') goto L73;
        if (r3 != 1) goto L68;
        appendLocalizedOffset(TextStyle.SHORT);
        goto L113
    L68:
        if (r3 != 4) goto L71;
        appendLocalizedOffset(TextStyle.FULL);
        goto L113
    L71:
        throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + r2);
    L73:
        if (r2 != 'X') goto L83;
        if (r3 > 5) goto L81;
        String[] r5 = OffsetIdPrinterParser.PATTERNS;
        if (r3 != 1) goto L78;
        int r6 = 0;
    L79:
        appendOffset(r5[r3 + r6], "Z");
        goto L113
    L78:
        r6 = 1;
        goto L79
    L81:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L83:
        if (r2 != 'x') goto L99;
        if (r3 > 5) goto L97;
        if (r3 != 1) goto L88;
        r10 = "+00";
    L91:
        String[] r7 = OffsetIdPrinterParser.PATTERNS;
        if (r3 != 1) goto L94;
        int r9 = 0;
    L95:
        appendOffset(r7[r3 + r9], r10);
        goto L113
    L94:
        r9 = 1;
        goto L95
    L88:
        if ((r3 % 2) == 0) goto L91;
        r10 = "+00:00";
        goto L91
    L97:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L99:
        if (r2 != 'W') goto L105;
        if (r3 > 1) goto L103;
        appendInternal(new WeekFieldsPrinterParser('W', r3));
        goto L113
    L103:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L105:
        if (r2 != 'w') goto L111;
        if (r3 > 2) goto L109;
        appendInternal(new WeekFieldsPrinterParser('w', r3));
        goto L113
    L109:
        throw new IllegalArgumentException("Too many pattern letters: " + r2);
    L111:
        if (r2 != 'Y') goto L115;
        appendInternal(new WeekFieldsPrinterParser('Y', r3));
        goto L113
    L115:
        throw new IllegalArgumentException("Unknown pattern letter: " + r2);
    L19:
        if (r8 >= r13.length()) goto L32;
        r2 = r13.charAt(r8);
        if (r2 < 'A') goto L23;
        if (r2 > 'Z') goto L23;
    L25:
        int r11 = r8 + 1;
    L27:
        if (r11 >= r13.length()) goto L31;
        if (r13.charAt(r11) != r2) goto L31;
        r11 = r11 + 1;
    L31:
        int r12 = r11 - r8;
        r8 = r11;
    L33:
        if (r3 == 0) goto L36;
        padNext(r3);
        r3 = r12;
        goto L37
    L36:
        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + r13);
    L23:
        if (r2 < 'a') goto L32;
        if (r2 <= 'z') goto L25;
    L32:
        r12 = r3;
        r3 = 0;
    L8:
        if (r2 < 'a') goto L117;
        if (r2 <= 'z') goto L10;
    L117:
        if (r2 != '\'') goto L139;
        int r14 = r1 + 1;
        int r15 = r14;
    L120:
        if (r15 >= r13.length()) goto L130;
        if (r13.charAt(r15) != '\'') goto L128;
        int r16 = r15 + 1;
        if (r16 >= r13.length()) goto L130;
        if (r13.charAt(r16) != '\'') goto L130;
        r15 = r16;
    L128:
        r15 = r15 + 1;
    L130:
        if (r15 >= r13.length()) goto L137;
        String r17 = r13.substring(r14, r15);
        if (r17.length() != 0) goto L134;
        appendLiteral('\'');
    L135:
        r1 = r15;
        goto L155
    L134:
        appendLiteral(r17.replace("''", "'"));
        goto L135
    L137:
        throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + r13);
    L139:
        if (r2 != '[') goto L142;
        optionalStart();
        goto L155
    L142:
        if (r2 != ']') goto L149;
        if (this.active.parent == null) goto L147;
        optionalEnd();
        goto L155
    L147:
        throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
    L149:
        if (r2 == '{') goto L157;
        if (r2 == '}') goto L157;
        if (r2 == '#') goto L157;
        appendLiteral(r2);
    L157:
        throw new IllegalArgumentException("Pattern includes reserved character: '" + r2 + "'");
    }

    private void parseField(char r8, int r9, TemporalField r10) {
        if (r8 != 'Q') goto L5;
    L101:
        if (r9 == 1) goto L112;
        if (r9 == 2) goto L111;
        if (r9 == 3) goto L110;
        if (r9 == 4) goto L109;
        if (r9 != 5) goto L108;
        appendText(r10, TextStyle.NARROW);
        return;
    L108:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L109:
        appendText(r10, TextStyle.FULL);
        return;
    L110:
        appendText(r10, TextStyle.SHORT);
        return;
    L111:
        appendValue(r10, 2);
        return;
    L112:
        appendValue(r10);
        return;
    L5:
        if (r8 != 'S') goto L7;
        appendFraction(ChronoField.NANO_OF_SECOND, r9, r9, false);
        return;
    L7:
        if (r8 != 'a') goto L9;
        if (r9 != 1) goto L99;
        appendText(r10, TextStyle.SHORT);
        return;
    L99:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L9:
        if (r8 != 'h') goto L11;
    L90:
        if (r9 != 1) goto L92;
        appendValue(r10);
        return;
    L92:
        if (r9 != 2) goto L95;
        appendValue(r10, r9);
        return;
    L95:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L11:
        if (r8 == 'k') goto L90;
        if (r8 == 'm') goto L90;
        if (r8 != 'q') goto L17;
    L78:
        if (r9 == 1) goto L89;
        if (r9 == 2) goto L88;
        if (r9 == 3) goto L87;
        if (r9 == 4) goto L86;
        if (r9 != 5) goto L85;
        appendText(r10, TextStyle.NARROW_STANDALONE);
        return;
    L85:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L86:
        appendText(r10, TextStyle.FULL_STANDALONE);
        return;
    L87:
        appendText(r10, TextStyle.SHORT_STANDALONE);
        return;
    L88:
        appendValue(r10, 2);
        return;
    L89:
        appendValue(r10);
        return;
    L17:
        if (r8 == 's') goto L90;
        if (r8 != 'u') goto L21;
    L72:
        if (r9 != 2) goto L75;
        appendValueReduced(r10, 2, 2, ReducedPrinterParser.BASE_DATE);
        return;
    L75:
        if (r9 >= 4) goto L77;
        appendValue(r10, r9, 19, SignStyle.NORMAL);
        return;
    L77:
        appendValue(r10, r9, 19, SignStyle.EXCEEDS_PAD);
        return;
    L21:
        if (r8 == 'y') goto L72;
        switch(r8) {
            case 68: goto L66;
            case 69: goto L56;
            case 70: goto L52;
            case 71: goto L56;
            case 72: goto L90;
            default: goto L23;
        };
    L23:
        switch(r8) {
            case 75: goto L90;
            case 76: goto L78;
            case 77: goto L101;
            default: goto L24;
        };
    L24:
        switch(r8) {
            case 99: goto L39;
            case 100: goto L90;
            case 101: goto L28;
            default: goto L25;
        };
    L25:
        if (r9 != 1) goto L27;
        appendValue(r10);
        return;
    L27:
        appendValue(r10, r9);
        return;
    L28:
        if (r9 == 1) goto L38;
        if (r9 == 2) goto L38;
        if (r9 == 3) goto L37;
        if (r9 == 4) goto L36;
        if (r9 != 5) goto L35;
        appendText(r10, TextStyle.NARROW);
        return;
    L35:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L36:
        appendText(r10, TextStyle.FULL);
        return;
    L37:
        appendText(r10, TextStyle.SHORT);
        return;
    L38:
        appendInternal(new WeekFieldsPrinterParser('e', r9));
        return;
    L39:
        if (r9 == 1) goto L51;
        if (r9 == 2) goto L50;
        if (r9 == 3) goto L48;
        if (r9 == 4) goto L47;
        if (r9 != 5) goto L46;
        appendText(r10, TextStyle.NARROW_STANDALONE);
        return;
    L46:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L47:
        appendText(r10, TextStyle.FULL_STANDALONE);
        return;
    L48:
        appendText(r10, TextStyle.SHORT_STANDALONE);
        return;
    L50:
        throw new IllegalArgumentException("Invalid number of pattern letters: " + r8);
    L51:
        appendInternal(new WeekFieldsPrinterParser('c', r9));
        return;
    L52:
        if (r9 != 1) goto L55;
        appendValue(r10);
        return;
    L55:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L56:
        if (r9 == 1) goto L65;
        if (r9 == 2) goto L65;
        if (r9 == 3) goto L65;
        if (r9 == 4) goto L64;
        if (r9 != 5) goto L63;
        appendText(r10, TextStyle.NARROW);
        return;
    L63:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    L64:
        appendText(r10, TextStyle.FULL);
        return;
    L65:
        appendText(r10, TextStyle.SHORT);
        return;
    L66:
        if (r9 != 1) goto L68;
        appendValue(r10);
        return;
    L68:
        if (r9 > 3) goto L71;
        appendValue(r10, r9);
        return;
    L71:
        throw new IllegalArgumentException("Too many pattern letters: " + r8);
    }

    public DateTimeFormatterBuilder padNext(int r2) {
        return padNext(r2, TokenParser.SP);
    }

    public DateTimeFormatterBuilder padNext(int r2, char r3) {
        if (r2 < 1) goto L7;
        DateTimeFormatterBuilder r0 = this.active;
        r0.padNextWidth = r2;
        r0.padNextChar = r3;
        r0.valueParserIndex = -1;
        return this;
    L7:
        throw new IllegalArgumentException("The pad width must be at least one but was " + r2);
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder r0 = this.active;
        r0.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(r0, true);
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder r0 = this.active;
        if (r0.parent == null) goto L10;
        if (r0.printerParsers.size() <= 0) goto L7;
        DateTimeFormatterBuilder r1 = this.active;
        CompositePrinterParser r2 = new CompositePrinterParser(r1.printerParsers, r1.optional);
        this.active = this.active.parent;
        appendInternal(r2);
    L8:
        return this;
    L7:
        this.active = this.active.parent;
        goto L8
    L10:
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    private int appendInternal(DateTimePrinterParser r4) {
        Jdk8Methods.requireNonNull(r4, "pp");
        if (this.active.padNextWidth <= 0) goto L7;
        if (r4 == null) goto L6;
        DateTimeFormatterBuilder r1 = this.active;
        r4 = new PadPrinterParserDecorator(r4, r1.padNextWidth, r1.padNextChar);
    L6:
        DateTimeFormatterBuilder r0 = this.active;
        r0.padNextWidth = 0;
        r0.padNextChar = 0;
    L7:
        this.active.printerParsers.add(r4);
        DateTimeFormatterBuilder r3 = this.active;
        r3.valueParserIndex = -1;
        return r3.printerParsers.size() - 1;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    public DateTimeFormatter toFormatter(Locale r10) {
        Jdk8Methods.requireNonNull(r10, "locale");
    L4:
        if (this.active.parent == null) goto L7;
        optionalEnd();
        goto L4
    L7:
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), r10, DecimalStyle.STANDARD, ResolverStyle.SMART, null, null, null);
    }

    DateTimeFormatter toFormatter(ResolverStyle r1) {
        return toFormatter().withResolverStyle(r1);
    }
}
