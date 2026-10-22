package com.obric.safecheck.service;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/* JADX INFO: loaded from: classes4.dex */
public class UniversalPhoneNumberFormatter {
    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = null;

    public UniversalPhoneNumberFormatter() {
    }

    static {
        PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    }

    public static String getPureCoreDigitNumber(String rawPhoneNumber) {
        if (TextUtils.isEmpty(rawPhoneNumber) == false) goto L5;
    L14:
        return "";
    L5:
        if (rawPhoneNumber.trim().isEmpty() == true) goto L14;
        String r2 = PhoneNumberUtils.stripSeparators(rawPhoneNumber.trim());
        if (TextUtils.isEmpty(r2) == false) goto L15;
        return "";
    L15:
        return extractCoreNumberWithoutAllCodes(PHONE_NUMBER_UTIL.parse(r2, "CN"));
    L13:
        return filterNonDigit(r2);
    }

    private static String extractCoreNumberWithoutAllCodes(Phonenumber.PhoneNumber parsedNumber) {
        String r0 = String.valueOf(parsedNumber.getNationalNumber());
        if (PHONE_NUMBER_UTIL.getNumberType(parsedNumber) != PhoneNumberUtil.PhoneNumberType.FIXED_LINE) goto L10;
        String r2 = getAreaCodeByRule(r0);
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r0.startsWith(r2) == false) goto L10;
        return r0.substring(r2.length());
    L10:
        return r0;
    }

    private static String getAreaCodeByRule(String nationalNumberStr) {
        int r0 = nationalNumberStr.length();
        if (TextUtils.isEmpty(nationalNumberStr) == false) goto L6;
        return "";
    L6:
        if (nationalNumberStr.startsWith("010") == false) goto L9;
        return "010";
    L9:
        if (nationalNumberStr.startsWith("02") == false) goto L14;
        if (r0 < 3) goto L14;
        return nationalNumberStr.substring(0, 3);
    L14:
        if (nationalNumberStr.startsWith("0") == false) goto L20;
        if (r0 < 11) goto L20;
        return nationalNumberStr.substring(0, 4);
    L20:
        if (nationalNumberStr.startsWith("0") == true) goto L22;
    L25:
        return "";
    L22:
        if (r0 != 10) goto L25;
        return nationalNumberStr.substring(0, 3);
    }

    private static String filterNonDigit(String input) {
        StringBuilder r0 = new StringBuilder();
        char[] r5 = input.toCharArray();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        char r3 = r5[r2];
        if (PhoneNumberUtils.isISODigit(r3) == false) goto L7;
        r0.append(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0.toString();
    }
}
