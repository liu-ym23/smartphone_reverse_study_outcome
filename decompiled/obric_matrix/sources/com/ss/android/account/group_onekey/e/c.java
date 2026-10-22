package com.ss.android.account.group_onekey.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static List<String> a(Context r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L16;
        return null;
    L16:
        PackageInfo r5 = r3.getPackageManager().getPackageInfo(r4, 64);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r5 != null) goto L8;
        return null;
    L8:
        ArrayList r6 = new ArrayList();
        Signature[] r7 = r5.signatures;
        if (r7 == null) goto L14;
        int r0 = r7.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r6.add(b.a(r7[r1].toByteArray()));
        r1 = r1 + 1;
        goto L11
    L13:
        return r6;
    L14:
        return null;
    }

    public static String b(List<String> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L18;
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r3.size()) goto L12;
        if (r1 == 0) goto L10;
        r0.append(",");
    L10:
        r0.append(r3.get(r1));
        r1 = r1 + 1;
        goto L7
    L12:
        return r0.toString();
    L18:
        return null;
    }
}
