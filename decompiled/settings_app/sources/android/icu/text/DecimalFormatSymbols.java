package android.icu.text;

import android.icu.util.Currency;
import android.icu.util.ULocale;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DecimalFormatSymbols implements Cloneable, Serializable {
    public static final int CURRENCY_SPC_CURRENCY_MATCH = 0;
    public static final int CURRENCY_SPC_INSERT = 2;
    public static final int CURRENCY_SPC_SURROUNDING_MATCH = 1;

    public DecimalFormatSymbols() {
        throw new RuntimeException("Stub!");
    }

    public DecimalFormatSymbols(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public DecimalFormatSymbols(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static DecimalFormatSymbols getInstance() {
        throw new RuntimeException("Stub!");
    }

    public static DecimalFormatSymbols getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static DecimalFormatSymbols getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static DecimalFormatSymbols forNumberingSystem(Locale r0, NumberingSystem r1) {
        throw new RuntimeException("Stub!");
    }

    public static DecimalFormatSymbols forNumberingSystem(ULocale r0, NumberingSystem r1) {
        throw new RuntimeException("Stub!");
    }

    public static Locale[] getAvailableLocales() {
        throw new RuntimeException("Stub!");
    }

    public static ULocale[] getAvailableULocales() {
        throw new RuntimeException("Stub!");
    }

    public char getZeroDigit() {
        throw new RuntimeException("Stub!");
    }

    public char[] getDigits() {
        throw new RuntimeException("Stub!");
    }

    public void setZeroDigit(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String[] getDigitStrings() {
        throw new RuntimeException("Stub!");
    }

    public void setDigitStrings(String[] r1) {
        throw new RuntimeException("Stub!");
    }

    public char getSignificantDigit() {
        throw new RuntimeException("Stub!");
    }

    public void setSignificantDigit(char r1) {
        throw new RuntimeException("Stub!");
    }

    public char getGroupingSeparator() {
        throw new RuntimeException("Stub!");
    }

    public void setGroupingSeparator(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getGroupingSeparatorString() {
        throw new RuntimeException("Stub!");
    }

    public void setGroupingSeparatorString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getDecimalSeparator() {
        throw new RuntimeException("Stub!");
    }

    public void setDecimalSeparator(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDecimalSeparatorString() {
        throw new RuntimeException("Stub!");
    }

    public void setDecimalSeparatorString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getPerMill() {
        throw new RuntimeException("Stub!");
    }

    public void setPerMill(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getPerMillString() {
        throw new RuntimeException("Stub!");
    }

    public void setPerMillString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getPercent() {
        throw new RuntimeException("Stub!");
    }

    public void setPercent(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getPercentString() {
        throw new RuntimeException("Stub!");
    }

    public void setPercentString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getDigit() {
        throw new RuntimeException("Stub!");
    }

    public void setDigit(char r1) {
        throw new RuntimeException("Stub!");
    }

    public char getPatternSeparator() {
        throw new RuntimeException("Stub!");
    }

    public void setPatternSeparator(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getInfinity() {
        throw new RuntimeException("Stub!");
    }

    public void setInfinity(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getNaN() {
        throw new RuntimeException("Stub!");
    }

    public void setNaN(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getMinusSign() {
        throw new RuntimeException("Stub!");
    }

    public void setMinusSign(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getMinusSignString() {
        throw new RuntimeException("Stub!");
    }

    public void setMinusSignString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getPlusSign() {
        throw new RuntimeException("Stub!");
    }

    public void setPlusSign(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getPlusSignString() {
        throw new RuntimeException("Stub!");
    }

    public void setPlusSignString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getCurrencySymbol() {
        throw new RuntimeException("Stub!");
    }

    public void setCurrencySymbol(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getInternationalCurrencySymbol() {
        throw new RuntimeException("Stub!");
    }

    public void setInternationalCurrencySymbol(String r1) {
        throw new RuntimeException("Stub!");
    }

    public Currency getCurrency() {
        throw new RuntimeException("Stub!");
    }

    public void setCurrency(Currency r1) {
        throw new RuntimeException("Stub!");
    }

    public char getMonetaryDecimalSeparator() {
        throw new RuntimeException("Stub!");
    }

    public void setMonetaryDecimalSeparator(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getMonetaryDecimalSeparatorString() {
        throw new RuntimeException("Stub!");
    }

    public void setMonetaryDecimalSeparatorString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getMonetaryGroupingSeparator() {
        throw new RuntimeException("Stub!");
    }

    public void setMonetaryGroupingSeparator(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getMonetaryGroupingSeparatorString() {
        throw new RuntimeException("Stub!");
    }

    public void setMonetaryGroupingSeparatorString(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getExponentMultiplicationSign() {
        throw new RuntimeException("Stub!");
    }

    public void setExponentMultiplicationSign(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getExponentSeparator() {
        throw new RuntimeException("Stub!");
    }

    public void setExponentSeparator(String r1) {
        throw new RuntimeException("Stub!");
    }

    public char getPadEscape() {
        throw new RuntimeException("Stub!");
    }

    public void setPadEscape(char r1) {
        throw new RuntimeException("Stub!");
    }

    public String getPatternForCurrencySpacing(int r1, boolean r2) {
        throw new RuntimeException("Stub!");
    }

    public void setPatternForCurrencySpacing(int r1, boolean r2, String r3) {
        throw new RuntimeException("Stub!");
    }

    public Locale getLocale() {
        throw new RuntimeException("Stub!");
    }

    public ULocale getULocale() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }
}
