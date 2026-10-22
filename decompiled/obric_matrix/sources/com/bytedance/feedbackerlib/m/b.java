package com.bytedance.feedbackerlib.m;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    @RequiresApi(api = 17)
    public static int a(@NonNull Context r3) {
        Map<IBinder, ?> r4 = o.e(r3.getApplicationContext());
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<IBinder, ?>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        Activity r1 = (Activity) d.c(r5.next().getValue(), "activity");     // Catch: Throwable -> L16
        if (r1 == null) goto L7;
        if (b(r1) == false) goto L7;
        r0 = r0 + 1;
        goto L7
    L15:
        return r0;
    }

    @RequiresApi(api = 17)
    public static boolean b(@NonNull Activity r2) {
        Boolean r1 = (Boolean) d.c(r2, "mStopped");     // Catch: IllegalAccessException -> L14
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.booleanValue() == false) goto L9;
        return false;
    L9:
        if (r2.isDestroyed() == true) goto L18;
        if (r2.isFinishing() == true) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L20:
        return false;
    }

    @RequiresApi(api = 17)
    public static boolean c(@NonNull Context r0) {
        if (a(r0) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
