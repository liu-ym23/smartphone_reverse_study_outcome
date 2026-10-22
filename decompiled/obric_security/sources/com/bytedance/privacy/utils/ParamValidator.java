package com.bytedance.privacy.utils;

import com.bytedance.privacy.exception.BdPrivacyException;

/* JADX INFO: loaded from: classes.dex */
public class ParamValidator {
    public ParamValidator() {
    }

    public static void checkNotNull(String r1, Object r2) throws BdPrivacyException {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new BdPrivacyException(r1 + " is null", -2);
    }

    public static void checkNotEmpty(String r1, String r2) throws BdPrivacyException {
        checkNotNull(r1, r2);
        if (r2.isEmpty() == true) goto L6;
        return;
    L6:
        throw new BdPrivacyException(r1 + " is empty", -3);
    }

    public static void checkLength(String r1, String r2, int r3) throws BdPrivacyException {
        checkNotEmpty(r1, r2);
        if (r2.length() > r3) goto L6;
        return;
    L6:
        throw new BdPrivacyException(r1 + " exceeds max length " + r3, -3);
    }

    public static void checkLength(String r1, String r2, int r3, int r4) throws BdPrivacyException {
        checkNotEmpty(r1, r2);
        int r5 = r2.length();
        if (r5 < r3) goto L7;
        if (r5 > r4) goto L7;
        return;
    L7:
        throw new BdPrivacyException(r1 + " length must be between " + r3 + " and " + r4, -3);
    }
}
