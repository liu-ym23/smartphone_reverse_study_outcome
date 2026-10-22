package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class w {
    public static int a(@NonNull Context r1) {
        if (r1 != null) goto L4;
        return -1;
    L4:
        if (r1.getApplicationContext() != null) goto L7;
        return -1;
    L7:
        return ((WindowManager) r1.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static boolean b(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return true;
    L7:
        return Settings.canDrawOverlays(r2);
    }
}
