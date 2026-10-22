package org.threeten.bp.format;

import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes6.dex */
public final class DecimalStyle {
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = null;
    public static final DecimalStyle STANDARD = null;
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;

    static {
        STANDARD = new DecimalStyle('0', '+', '-', '.');
        CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    }

    public static Set<Locale> getAvailableLocales() {
        return new HashSet(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));
    }

    public static DecimalStyle ofDefaultLocale() {
        return of(Locale.getDefault());
    }

    public static DecimalStyle of(Locale r2) {
        Jdk8Methods.requireNonNull(r2, "locale");
        ConcurrentMap<Locale, DecimalStyle> r0 = CACHE;
        DecimalStyle r1 = r0.get(r2);
        if (r1 != null) goto L6;
        r0.putIfAbsent(r2, create(r2));
        return r0.get(r2);
    L6:
        return r1;
    }

    private static DecimalStyle create(Locale r4) {
        DecimalFormatSymbols r5 = DecimalFormatSymbols.getInstance(r4);
        char r0 = r5.getZeroDigit();
        char r1 = r5.getMinusSign();
        char r6 = r5.getDecimalSeparator();
        if (r0 != '0') goto L11;
        if (r1 != '-') goto L11;
        if (r6 != '.') goto L11;
        return STANDARD;
    L11:
        return new DecimalStyle(r0, '+', r1, r6);
    }

    private DecimalStyle(char r1, char r2, char r3, char r4) {
        this.zeroDigit = r1;
        this.positiveSign = r2;
        this.negativeSign = r3;
        this.decimalSeparator = r4;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public DecimalStyle withZeroDigit(char r4) {
        if (r4 != this.zeroDigit) goto L6;
        return this;
    L6:
        return new DecimalStyle(r4, this.positiveSign, this.negativeSign, this.decimalSeparator);
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public DecimalStyle withPositiveSign(char r4) {
        if (r4 != this.positiveSign) goto L6;
        return this;
    L6:
        return new DecimalStyle(this.zeroDigit, r4, this.negativeSign, this.decimalSeparator);
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public DecimalStyle withNegativeSign(char r4) {
        if (r4 != this.negativeSign) goto L6;
        return this;
    L6:
        return new DecimalStyle(this.zeroDigit, this.positiveSign, r4, this.decimalSeparator);
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public DecimalStyle withDecimalSeparator(char r4) {
        if (r4 != this.decimalSeparator) goto L6;
        return this;
    L6:
        return new DecimalStyle(this.zeroDigit, this.positiveSign, this.negativeSign, r4);
    }

    int convertToDigit(char r1) {
        int r2 = r1 - this.zeroDigit;
        if (r2 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (r2 > 9) goto L7;
        return r2;
    }

    String convertNumberToI18N(String r3) {
        char r2 = this.zeroDigit;
        if (r2 != '0') goto L5;
        return r3;
    L5:
        int r4 = r2 - '0';
        char[] r5 = r3.toCharArray();
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L10;
        r5[r0] = (char) (r5[r0] + r4);
        r0 = r0 + 1;
        goto L7
    L10:
        return new String(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DecimalStyle) == false) goto L18;
        DecimalStyle r6 = (DecimalStyle) r5;
        if (this.zeroDigit != r6.zeroDigit) goto L17;
        if (this.positiveSign != r6.positiveSign) goto L17;
        if (this.negativeSign != r6.negativeSign) goto L17;
        if (this.decimalSeparator != r6.decimalSeparator) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        return ((this.zeroDigit + this.positiveSign) + this.negativeSign) + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }
}
