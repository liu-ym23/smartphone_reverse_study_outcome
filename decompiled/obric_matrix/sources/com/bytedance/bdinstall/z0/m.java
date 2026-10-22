package com.bytedance.bdinstall.z0;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class m extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2937e;

    m(Context r3) {
        super(true, false);
        this.f2937e = r3;
    }

    private void c(JSONObject r5, DisplayMetrics r6) {
        int r7 = r6.densityDpi;
        if (r7 > 120) goto L6;
        String r8 = "ldpi";
    L21:
        r5.put("display_density_v2", r8);
        int[] r4 = e();
        r5.put("resolution_v2", r4[1] + "x" + r4[0]);
        if (com.bytedance.bdinstall.q.b() == false) goto L25;
        com.bytedance.bdinstall.q.a("resolution " + r4[1] + "x" + r4[0]);
        return;
    L25:
        return;
    L6:
        if (r7 > 160) goto L9;
        r8 = "mdpi";
        goto L21
    L9:
        if (r7 > 240) goto L12;
        r8 = "hdpi";
        goto L21
    L12:
        if (r7 > 320) goto L15;
        r8 = "xhdpi";
        goto L21
    L15:
        if (r7 > 480) goto L18;
        r8 = "xxhdpi";
        goto L21
    L18:
        if (r7 > 640) goto L20;
        r8 = "xxxhdpi";
        goto L21
    L20:
        r8 = "xxxxhdpi";
        goto L21
    }

    private void d(JSONObject r3, DisplayMetrics r4) {
        int r2 = r4.densityDpi;     // Catch: Exception -> L14
        if (r2 != 120) goto L5;
        String r0 = "ldpi";
    L12:
        r3.put("density_dpi", r2);     // Catch: Exception -> L14
        r3.put("display_density", r0);     // Catch: Exception -> L14
        r3.put("resolution", r4.heightPixels + "x" + r4.widthPixels);     // Catch: Exception -> L14
        return;
    L5:
        if (r2 != 240) goto L7;
        r0 = "hdpi";
        goto L12
    L7:
        if (r2 == 320) goto L9;
        r0 = "mdpi";
        goto L12
    L9:
        r0 = "xhdpi";
    }

    private int[] e() {
        WindowManager r5 = (WindowManager) this.f2937e.getSystemService("window");     // Catch: Throwable -> L31
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Throwable -> L31
        Display r6 = r5.getDefaultDisplay();     // Catch: Throwable -> L31
        int r2 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        if (r2 < 17) goto L36;
        r6.getRealMetrics(r1);     // Catch: Throwable -> L31
        int r7 = r1.widthPixels;     // Catch: Throwable -> L31
        int r3 = r1.heightPixels;     // Catch: Throwable -> L35
    L34:
        return new int[]{r7, r3};
    L32:
        r3 = 0;
        goto L34
    L36:
        Method r4 = Display.class.getMethod("getRawHeight", new Class[0]);     // Catch: Throwable -> L31
        int r8 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(r6, new Object[0])).intValue();     // Catch: InvocationTargetException -> L18 IllegalAccessException -> L23 IllegalArgumentException -> L26 Throwable -> L31
        r3 = ((Integer) r4.invoke(r6, new Object[0])).intValue();     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 IllegalArgumentException -> L16 Throwable -> L30
    L22:
        r7 = r8;
        goto L34
    L14:
        e = e;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L30
    L21:
        r3 = 0;
    L16:
        e = e;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L30
    L12:
        e = e;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L30
        goto L21
    L23:
        e = e;
        r8 = 0;
    L26:
        e = e;
        r8 = 0;
    L18:
        e = e;
        r8 = 0;
    L30:
        r7 = r2;
    L31:
        r7 = 0;
        goto L32
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r2) {
        DisplayMetrics r0 = this.f2937e.getResources().getDisplayMetrics();
        d(r2, r0);
        c(r2, r0);
        return true;
    }
}
