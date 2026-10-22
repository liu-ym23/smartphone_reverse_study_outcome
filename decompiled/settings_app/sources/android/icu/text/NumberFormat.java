package android.icu.text;

import android.icu.math.BigDecimal;
import android.icu.util.Currency;
import android.icu.util.CurrencyAmount;
import android.icu.util.ULocale;
import java.io.InvalidObjectException;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberFormat extends UFormat {
    public static final int ACCOUNTINGCURRENCYSTYLE = 7;
    public static final int CASHCURRENCYSTYLE = 8;
    public static final int CURRENCYSTYLE = 1;
    public static final int FRACTION_FIELD = 1;
    public static final int INTEGERSTYLE = 4;
    public static final int INTEGER_FIELD = 0;
    public static final int ISOCURRENCYSTYLE = 5;
    public static final int NUMBERSTYLE = 0;
    public static final int PERCENTSTYLE = 2;
    public static final int PLURALCURRENCYSTYLE = 6;
    public static final int SCIENTIFICSTYLE = 3;
    public static final int STANDARDCURRENCYSTYLE = 9;

    public static class Field extends Format.Field {
        public static final Field COMPACT = null;
        public static final Field CURRENCY = null;
        public static final Field DECIMAL_SEPARATOR = null;
        public static final Field EXPONENT = null;
        public static final Field EXPONENT_SIGN = null;
        public static final Field EXPONENT_SYMBOL = null;
        public static final Field FRACTION = null;
        public static final Field GROUPING_SEPARATOR = null;
        public static final Field INTEGER = null;
        public static final Field MEASURE_UNIT = null;
        public static final Field PERCENT = null;
        public static final Field PERMILLE = null;
        public static final Field SIGN = null;

        static {
        }

        protected Field(String r1) {
            super(null);
            throw new RuntimeException("Stub!");
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        protected Object readResolve() throws InvalidObjectException {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract StringBuffer format(double r1, StringBuffer r3, FieldPosition r4);

    public abstract StringBuffer format(long r1, StringBuffer r3, FieldPosition r4);

    public abstract StringBuffer format(BigDecimal r1, StringBuffer r2, FieldPosition r3);

    public abstract StringBuffer format(java.math.BigDecimal r1, StringBuffer r2, FieldPosition r3);

    public abstract StringBuffer format(BigInteger r1, StringBuffer r2, FieldPosition r3);

    public abstract Number parse(String r1, ParsePosition r2);

    public NumberFormat() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public final Object parseObject(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public final String format(double r1) {
        throw new RuntimeException("Stub!");
    }

    public final String format(long r1) {
        throw new RuntimeException("Stub!");
    }

    public final String format(BigInteger r1) {
        throw new RuntimeException("Stub!");
    }

    public final String format(java.math.BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public final String format(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public final String format(CurrencyAmount r1) {
        throw new RuntimeException("Stub!");
    }

    public StringBuffer format(CurrencyAmount r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    public Number parse(String r1) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    public CurrencyAmount parseCurrency(CharSequence r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public boolean isParseIntegerOnly() {
        throw new RuntimeException("Stub!");
    }

    public void setParseIntegerOnly(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public void setParseStrict(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean isParseStrict() {
        throw new RuntimeException("Stub!");
    }

    public void setContext(DisplayContext r1) {
        throw new RuntimeException("Stub!");
    }

    public DisplayContext getContext(DisplayContext.Type r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getInstance() {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getInstance(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getInstance(Locale r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getNumberInstance() {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getNumberInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getNumberInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getIntegerInstance() {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getIntegerInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getIntegerInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getCurrencyInstance() {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getCurrencyInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getCurrencyInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getPercentInstance() {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getPercentInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getPercentInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static final NumberFormat getScientificInstance() {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getScientificInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getScientificInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static Locale[] getAvailableLocales() {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public boolean isGroupingUsed() {
        throw new RuntimeException("Stub!");
    }

    public void setGroupingUsed(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public int getMaximumIntegerDigits() {
        throw new RuntimeException("Stub!");
    }

    public void setMaximumIntegerDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getMinimumIntegerDigits() {
        throw new RuntimeException("Stub!");
    }

    public void setMinimumIntegerDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getMaximumFractionDigits() {
        throw new RuntimeException("Stub!");
    }

    public void setMaximumFractionDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getMinimumFractionDigits() {
        throw new RuntimeException("Stub!");
    }

    public void setMinimumFractionDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setCurrency(Currency r1) {
        throw new RuntimeException("Stub!");
    }

    public Currency getCurrency() {
        throw new RuntimeException("Stub!");
    }

    public int getRoundingMode() {
        throw new RuntimeException("Stub!");
    }

    public void setRoundingMode(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static NumberFormat getInstance(ULocale r0, int r1) {
        throw new RuntimeException("Stub!");
    }

    protected static String getPattern(ULocale r0, int r1) {
        throw new RuntimeException("Stub!");
    }
}
