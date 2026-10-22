package com.bytedance.privacy.utils;

import com.bytedance.privacy.exception.BdPrivacyException;

/* JADX INFO: loaded from: classes.dex */
public class ParamValidator {
    public static void a(int r2, String r3) {
        if (20 > r2) goto L6;
        return;
    L6:
        throw new BdPrivacyException(r3 + " exceeds max length " + r2, -3);
    }
}
