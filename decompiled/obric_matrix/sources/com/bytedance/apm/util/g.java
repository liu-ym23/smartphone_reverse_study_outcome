package com.bytedance.apm.util;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import com.bytedance.common.utility.reflect.Reflect;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(PendingIntent r2) {
        if (Build.VERSION.SDK_INT > 23) goto L7;
        if (r2 != null) goto L6;
        return "";
    L6:
        return ((Intent) Reflect.on(r2).call("getIntent").get()).toString();
    L7:
        return "";
    }
}
