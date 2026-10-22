package android.icu.text;

import android.icu.util.Currency;
import android.icu.util.CurrencyAmount;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;

/* JADX INFO: loaded from: classes.dex */
public class DecimalFormat extends NumberFormat {
    public static final int MINIMUM_GROUPING_DIGITS_AUTO = -2;
    public static final int MINIMUM_GROUPING_DIGITS_MIN2 = -3;
    public static final int PAD_AFTER_PREFIX = 1;
    public static final int PAD_AFTER_SUFFIX = 3;
    public static final int PAD_BEFORE_PREFIX = 0;
    public static final int PAD_BEFORE_SUFFIX = 2;

    public DecimalFormat() {
        throw new RuntimeException("Stub!");
    }

    public DecimalFormat(String r1) {
        throw new RuntimeException("Stub!");
    }

    public DecimalFormat(String r1, DecimalFormatSymbols r2) {
        throw new RuntimeException("Stub!");
    }

    public DecimalFormat(String r1, DecimalFormatSymbols r2, CurrencyPluralInfo r3, int r4) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void applyPattern(String r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void applyLocalizedPattern(String r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat, java.text.Format
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public StringBuffer format(double r1, StringBuffer r3, FieldPosition r4) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public StringBuffer format(long r1, StringBuffer r3, FieldPosition r4) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public StringBuffer format(BigInteger r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public StringBuffer format(BigDecimal r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public StringBuffer format(android.icu.math.BigDecimal r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public StringBuffer format(CurrencyAmount r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public Number parse(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public CurrencyAmount parseCurrency(CharSequence r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public synchronized DecimalFormatSymbols getDecimalFormatSymbols() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setDecimalFormatSymbols(DecimalFormatSymbols r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized String getPositivePrefix() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setPositivePrefix(String r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized String getNegativePrefix() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setNegativePrefix(String r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized String getPositiveSuffix() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setPositiveSuffix(String r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized String getNegativeSuffix() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setNegativeSuffix(String r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isSignAlwaysShown() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setSignAlwaysShown(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getMultiplier() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMultiplier(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized BigDecimal getRoundingIncrement() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setRoundingIncrement(BigDecimal r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setRoundingIncrement(android.icu.math.BigDecimal r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setRoundingIncrement(double r1) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized int getRoundingMode() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setRoundingMode(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized MathContext getMathContext() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMathContext(MathContext r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized android.icu.math.MathContext getMathContextICU() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMathContextICU(android.icu.math.MathContext r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized int getMinimumIntegerDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setMinimumIntegerDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized int getMaximumIntegerDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setMaximumIntegerDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized int getMinimumFractionDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setMinimumFractionDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized int getMaximumFractionDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setMaximumFractionDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean areSignificantDigitsUsed() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setSignificantDigitsUsed(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getMinimumSignificantDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMinimumSignificantDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getMaximumSignificantDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMaximumSignificantDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getFormatWidth() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setFormatWidth(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized char getPadCharacter() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setPadCharacter(char r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getPadPosition() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setPadPosition(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isScientificNotation() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setScientificNotation(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized byte getMinimumExponentDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMinimumExponentDigits(byte r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isExponentSignAlwaysShown() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setExponentSignAlwaysShown(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized boolean isGroupingUsed() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setGroupingUsed(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getGroupingSize() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setGroupingSize(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getSecondaryGroupingSize() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setSecondaryGroupingSize(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized int getMinimumGroupingDigits() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setMinimumGroupingDigits(int r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isDecimalSeparatorAlwaysShown() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setDecimalSeparatorAlwaysShown(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized Currency getCurrency() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setCurrency(Currency r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized Currency.CurrencyUsage getCurrencyUsage() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setCurrencyUsage(Currency.CurrencyUsage r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized CurrencyPluralInfo getCurrencyPluralInfo() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setCurrencyPluralInfo(CurrencyPluralInfo r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isParseBigDecimal() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setParseBigDecimal(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Deprecated
    public int getParseMaxDigits() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public void setParseMaxDigits(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.NumberFormat
    public synchronized boolean isParseStrict() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setParseStrict(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized boolean isParseIntegerOnly() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized void setParseIntegerOnly(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isDecimalPatternMatchRequired() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setDecimalPatternMatchRequired(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isParseNoExponent() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setParseNoExponent(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized boolean isParseCaseSensitive() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized void setParseCaseSensitive(boolean r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized boolean equals(Object r2) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    @Override // android.icu.text.NumberFormat
    public synchronized int hashCode() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public synchronized String toPattern() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public synchronized String toLocalizedPattern() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }
}
