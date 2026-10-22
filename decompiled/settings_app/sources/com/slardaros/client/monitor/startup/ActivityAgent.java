package com.slardaros.client.monitor.startup;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";
    private static boolean sIsFirstWindowFocusChangedActivity = true;

    static {
    }

    public ActivityAgent() {
    }

    public static void onTrace(String r1, String r2, boolean r3) {
        if (sIsFirstWindowFocusChangedActivity == true) goto L6;
        return;
    L6:
        if (TextUtils.equals("onCreate", r2) == false) goto L11;
        if (r3 == false) goto L9;
        AutoLaunchTraceHelper.launcherActivityOnCreateStart(r1);
        return;
    L9:
        AutoLaunchTraceHelper.launcherActivityOnCreateEnd();
        return;
    L11:
        if (TextUtils.equals("onResume", r2) == false) goto L16;
        if (r3 == false) goto L14;
        AutoLaunchTraceHelper.launcherActivityOnResumeStart(r1);
        return;
    L14:
        AutoLaunchTraceHelper.launcherActivityOnResumeEnd();
        return;
    L16:
        if (TextUtils.equals("onWindowFocusChanged", r2) == false) goto L20;
        if (r3 == false) goto L29;
        AutoLaunchTraceHelper.launcherActivityOnWindowFocusChangedStart(r1);
        sIsFirstWindowFocusChangedActivity = false;
        return;
    L29:
        return;
    L20:
        if (TextUtils.equals("onStart", r2) == false) goto L31;
        if (r3 == false) goto L23;
        AutoLaunchTraceHelper.launcherActivityOnStartStart(r1);
        return;
    L23:
        AutoLaunchTraceHelper.launcherActivityOnStartEnd(r1);
        return;
    }
}
