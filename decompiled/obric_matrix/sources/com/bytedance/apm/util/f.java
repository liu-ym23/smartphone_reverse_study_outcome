package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f2047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f2049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f2051e;

    static class a implements IActivityLifeObserver {
        a() {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityPause(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityResume(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityStarted(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onBackground(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onChange(Activity r1, Fragment r2) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onFront(Activity r1) {
            f.a(r1);
        }
    }

    static {
        g();
    }

    static /* synthetic */ void a(Activity r0) {
        i(r0);
    }

    public static int b() {
        return f2049c;
    }

    public static float c() {
        return f2047a;
    }

    public static int d() {
        return f2051e;
    }

    public static int e() {
        return f2048b;
    }

    private static int f(float r2) {
        if (Math.abs(r2 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r2 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r2 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r2;
    }

    private static void g() {
        int r0 = Build.VERSION.SDK_INT;
        Context r1 = com.bytedance.apm.d.h();
        ActivityLifeObserver.getInstance().register(new a());
        float r3 = 0.0f;
        int r7 = 0;
        boolean r8 = false;
        if (com.bytedance.apm.d.k0() == false) goto L18;
        if (r0 < 23) goto L18;
        if (r1 == null) goto L18;
        Display r2 = ((WindowManager) r1.getSystemService("window")).getDefaultDisplay();
        float r4 = r2.getRefreshRate();
        Display.Mode[] r5 = r2.getSupportedModes();
        int r6 = r5.length;
        int r9 = 0;
    L8:
        if (r9 >= r6) goto L13;
        float r10 = r5[r9].getRefreshRate();
        if (r10 <= r3) goto L12;
        r3 = r10;
    L12:
        r9 = r9 + 1;
        goto L8
    L13:
        f2048b = f(r4);
        int r11 = f(r3);
        f2049c = r11;
        int r12 = f2048b;
        if (r12 != r11) goto L16;
        r8 = true;
    L16:
        f2050d = r8;
        f2047a = 1000.0f / r12;
        return;
    L18:
        f2049c = 60;
        f2048b = 60;
        f2050d = true;
        f2047a = 1000.0f / 60;
        f2051e = 60;
        if (r0 < 23) goto L35;
        if (r1 == null) goto L36;
        Display r13 = ((WindowManager) r1.getSystemService("window")).getDefaultDisplay();
        f(r13.getRefreshRate());
        Display.Mode[] r14 = r13.getSupportedModes();
        int r15 = r14.length;
    L22:
        if (r7 >= r15) goto L27;
        float r16 = r14[r7].getRefreshRate();
        if (r16 <= r3) goto L26;
        r3 = r16;
    L26:
        r7 = r7 + 1;
        goto L22
    L27:
        f2051e = f(r3);
        return;
    L36:
        return;
    }

    public static boolean h() {
        return f2050d;
    }

    private static void i(Activity r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        float r3 = r2.getWindowManager().getDefaultDisplay().getRefreshRate();
        f(r3);
        if (com.bytedance.apm.d.k0() == true) goto L8;
        return;
    L8:
        int r4 = f(r3);
        f2048b = r4;
        if (r4 != f2049c) goto L11;
        boolean r0 = true;
    L12:
        f2050d = r0;
        f2047a = 1000.0f / r4;
        return;
    L11:
        r0 = false;
        goto L12
    }
}
