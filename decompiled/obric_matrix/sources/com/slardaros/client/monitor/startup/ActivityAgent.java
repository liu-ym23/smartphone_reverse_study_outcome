package com.slardaros.client.monitor.startup;

import android.text.TextUtils;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";
    private static boolean sIsFirstWindowFocusChangedActivity = true;

    static {
    }

    public ActivityAgent() {
    }

    @Keep
    public static void onTrace(String r1, String r2, boolean r3) {
        if (sIsFirstWindowFocusChangedActivity == true) goto L6;
        return;
    L6:
        if (TextUtils.equals("onCreate", r2) == false) goto L11;
        if (r3 == false) goto L9;
        a.c(r1);
        return;
    L9:
        a.b();
        return;
    L11:
        if (TextUtils.equals("onResume", r2) == false) goto L16;
        if (r3 == false) goto L14;
        a.e(r1);
        return;
    L14:
        a.d();
        return;
    L16:
        if (TextUtils.equals("onWindowFocusChanged", r2) == false) goto L20;
        if (r3 == false) goto L29;
        a.h(r1);
        sIsFirstWindowFocusChangedActivity = false;
        return;
    L29:
        return;
    L20:
        if (TextUtils.equals("onStart", r2) == false) goto L31;
        if (r3 == false) goto L23;
        a.g(r1);
        return;
    L23:
        a.f(r1);
        return;
    }
}
