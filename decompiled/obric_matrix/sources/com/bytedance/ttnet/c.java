package com.bytedance.ttnet;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a() {
        String r0 = TTNetInit.getTTNetDepend().l();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("hostSuffix is not init !!!");
    }
}
