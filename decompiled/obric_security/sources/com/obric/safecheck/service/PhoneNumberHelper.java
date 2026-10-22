package com.obric.safecheck.service;

import android.telephony.PhoneNumberUtils;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PhoneNumberHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/safecheck/service/PhoneNumberHelper;", "", "()V", "REGEX_AREA_CODE", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "REGEX_NON_DIGIT", "REGEX_PLUS86", "isPhoneNumberValid", "", AccountConst.KEY_PHONE_NUMBER, "", "isPhoneNumbersEqual", "phone1", "phone2", "normalizePhoneNumber", "safeComparePhoneNumbers", "Lkotlin/Pair;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PhoneNumberHelper {
    public static final PhoneNumberHelper INSTANCE = null;
    private static final Pattern REGEX_AREA_CODE = null;
    private static final Pattern REGEX_NON_DIGIT = null;
    private static final Pattern REGEX_PLUS86 = null;

    static {
        INSTANCE = new PhoneNumberHelper();
        REGEX_PLUS86 = Pattern.compile("^\\+86\\s*");
        REGEX_AREA_CODE = Pattern.compile("^\\(\\d{3,4}\\)|^\\d{3,4}-");
        REGEX_NON_DIGIT = Pattern.compile("\\D");
    }

    private PhoneNumberHelper() {
    }

    public final boolean isPhoneNumberValid(String r1) {
        Intrinsics.checkNotNullParameter(r1, AccountConst.KEY_PHONE_NUMBER);
        if (StringsKt.isBlank(r1) == false) goto L7;
        return false;
    L7:
        return PhoneNumberUtils.isGlobalPhoneNumber(r1);
    }

    public final String normalizePhoneNumber(String r2) {
        Intrinsics.checkNotNullParameter(r2, AccountConst.KEY_PHONE_NUMBER);
        String r3 = r2;
        if (StringsKt.isBlank(r3) == false) goto L5;
        return "";
    L5:
        String r1 = StringsKt.trim(r3).toString();
        String r4 = REGEX_PLUS86.matcher(r1).replaceFirst("");
        Intrinsics.checkNotNullExpressionValue(r4, "matcher86.replaceFirst(\"\")");
        String r5 = REGEX_AREA_CODE.matcher(r4).replaceFirst("");
        Intrinsics.checkNotNullExpressionValue(r5, "matcherArea.replaceFirst(\"\")");
        String r6 = REGEX_NON_DIGIT.matcher(r5).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(r6, "matcherNonDigit.replaceAll(\"\")");
        return r6;
    }

    public final boolean isPhoneNumbersEqual(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "phone1");
        Intrinsics.checkNotNullParameter(r3, "phone2");
        return Intrinsics.areEqual(normalizePhoneNumber(r2), normalizePhoneNumber(r3));
    }

    public final Pair<Boolean, Boolean> safeComparePhoneNumbers(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "phone1");
        Intrinsics.checkNotNullParameter(r5, "phone2");
        boolean r0 = isPhoneNumberValid(r4);
        boolean r1 = isPhoneNumberValid(r5);
        boolean r2 = false;
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        boolean r3 = isPhoneNumbersEqual(r4, r5);
    L8:
        if (r0 == false) goto L12;
        if (r1 == false) goto L12;
        r2 = true;
    L12:
        return new Pair(Boolean.valueOf(r2), Boolean.valueOf(r3));
    L6:
        r3 = false;
        goto L8
    }
}
