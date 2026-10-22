package com.bytedance.memory.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4998a = -1;

    static {
    }

    public static void a(@NonNull File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == true) goto L7;
        return;
    L7:
        if (r5.isDirectory() == false) goto L17;
        File[] r0 = r5.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L17;
        File r3 = r0[r2];
        if (r3.isFile() == false) goto L14;
        r3.delete();
    L16:
        r2 = r2 + 1;
        goto L9
    L14:
        if (r5.isDirectory() == false) goto L16;
        a(r3);
    L17:
        r5.delete();
    }

    private static long b() {
        long r0 = f4998a;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        long r1 = Runtime.getRuntime().maxMemory();
        f4998a = r1;
        return r1;
    }

    public static float c() {
        float r0 = ((float) new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()).divide(new BigDecimal(b()), 4, 4).doubleValue()) * 100.0f;
        c.c("currentRate %f", new Object[]{Float.valueOf(r0)});
        return r0;
    }

    public static boolean d(Context r1) {
        if ((r1.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static void e(Context r1, Class<?> r2, boolean r3) {
        if (r2 == null) goto L9;
        ComponentName r0 = new ComponentName(r1, r2);
        PackageManager r4 = r1.getPackageManager();
        if (r3 == false) goto L6;
        int r5 = 1;
    L7:
        r4.setComponentEnabledSetting(r0, r5, 1);
        return;
    L6:
        r5 = 2;
        goto L7
    }
}
