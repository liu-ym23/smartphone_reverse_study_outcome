package com.obric.securitycenter.nodisturb.utils;

import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: encryptToMd5.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"calculateMD5", "", "input", "nodisturb_neridaCnRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EncryptToMd5Kt {
    public static final String calculateMD5(String r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        byte[] r9 = r8.getBytes(Charsets.UTF_8);     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L8
        byte[] r10 = r0.digest(r9);     // Catch: Exception -> L8
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r10, "md5Bytes");     // Catch: Exception -> L8
        int r2 = r10.length;     // Catch: Exception -> L8
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L6;
        byte r4 = r10[r3];     // Catch: Exception -> L8
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L8
        String r6 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r4)}, 1));     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r6, "format(format, *args)");     // Catch: Exception -> L8
        r1.append(r6);     // Catch: Exception -> L8
        r3 = r3 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        String r11 = r1.toString();     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r11, "{\n        // 1. 获取MD5算法实…xBuilder.toString()\n    }");     // Catch: Exception -> L8
        return r11;
    L8:
        return "";
    }
}
