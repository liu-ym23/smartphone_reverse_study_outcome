package org.apache.commons.math3.util;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeFormat {
    private CompositeFormat() {
    }

    public static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    public static NumberFormat getDefaultNumberFormat(Locale r1) {
        NumberFormat r2 = NumberFormat.getInstance(r1);
        r2.setMaximumFractionDigits(10);
        return r2;
    }

    public static void parseAndIgnoreWhitespace(String r0, ParsePosition r1) {
        parseNextCharacter(r0, r1);
        r1.setIndex(r1.getIndex() - 1);
    }

    public static char parseNextCharacter(String r4, ParsePosition r5) {
        int r0 = r5.getIndex();
        int r1 = r4.length();
        if (r0 >= r1) goto L12;
    L4:
        int r2 = r0 + 1;
        char r3 = r4.charAt(r0);
        if (Character.isWhitespace(r3) == false) goto L9;
        if (r2 >= r1) goto L9;
        r0 = r2;
    L9:
        r5.setIndex(r2);
        if (r2 >= r1) goto L12;
        return r3;
    L12:
        return 0;
    }

    private static Number parseNumber(String r4, double r5, ParsePosition r7) {
        StringBuilder r0 = new StringBuilder();
        r0.append('(');
        r0.append(r5);
        r0.append(')');
        int r1 = r0.length();
        int r2 = r7.getIndex();
        int r3 = r1 + r2;
        if (r3 < r4.length()) goto L5;
    L7:
        return null;
    L5:
        if (r4.substring(r2, r3).compareTo(r0.toString()) != 0) goto L7;
        Double r6 = Double.valueOf(r5);
        r7.setIndex(r3);
        return r6;
    }

    public static Number parseNumber(String r5, NumberFormat r6, ParsePosition r7) {
        int r0 = r7.getIndex();
        Number r8 = r6.parse(r5, r7);
        if (r0 != r7.getIndex()) goto L10;
        double[] r1 = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        int r2 = 0;
    L5:
        if (r2 >= 3) goto L10;
        r8 = parseNumber(r5, r1[r2], r7);
        if (r8 != null) goto L10;
        r2 = r2 + 1;
    L10:
        return r8;
    }

    public static boolean parseFixedstring(String r3, String r4, ParsePosition r5) {
        int r0 = r5.getIndex();
        int r1 = r4.length() + r0;
        if (r0 < r3.length()) goto L5;
    L11:
        r5.setIndex(r0);
        r5.setErrorIndex(r0);
        return false;
    L5:
        if (r1 > r3.length()) goto L11;
        if (r3.substring(r0, r1).compareTo(r4) != 0) goto L11;
        r5.setIndex(r1);
        return true;
    }

    public static StringBuffer formatDouble(double r1, NumberFormat r3, StringBuffer r4, FieldPosition r5) {
        if (Double.isNaN(r1) == false) goto L5;
    L8:
        r4.append('(');
        r4.append(r1);
        r4.append(')');
    L9:
        return r4;
    L5:
        if (Double.isInfinite(r1) == true) goto L8;
        r3.format(r1, r4, r5);
        goto L9
    }
}
