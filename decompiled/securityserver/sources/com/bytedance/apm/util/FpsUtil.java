package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class FpsUtil {
    private static final int DEFAULT_REFRESH_RATE = 60;
    private static final float ONE_SECOND_IN_MILLIS = 1000.0f;
    private static final int REFRESH_RATE_120 = 120;
    private static final int REFRESH_RATE_60 = 60;
    private static final int REFRESH_RATE_90 = 90;
    private static final float ROUNDING_THRESHOLD = 5.1f;
    private static int sCurrentRefreshRate;
    private static int sDeviceMaxRefreshRate;
    private static float sFrameIntervalMillis;
    private static int sRealMaxRate;
    private static int sRealRefreshRate;
    private static boolean sUsingMaxRefreshRate;

    static {
        init();
    }

    public FpsUtil() {
    }

    public static /* synthetic */ void access$000(Activity r0) {
        refreshData(r0);
    }

    public static int getDeviceMaxRefreshRate() {
        return sDeviceMaxRefreshRate;
    }

    public static float getFrameIntervalMillis() {
        return sFrameIntervalMillis;
    }

    public static int getRealMaxRate() {
        return sRealMaxRate;
    }

    public static int getRealRefreshRate() {
        return sRealRefreshRate;
    }

    public static int getRefreshRate() {
        return sCurrentRefreshRate;
    }

    private static int getRoundedRate(float r2) {
        if (Math.abs(r2 - 60.0f) >= ROUNDING_THRESHOLD) goto L7;
        return 60;
    L7:
        if (Math.abs(r2 - 90.0f) >= ROUNDING_THRESHOLD) goto L11;
        return REFRESH_RATE_90;
    L11:
        if (Math.abs(r2 - 120.0f) >= ROUNDING_THRESHOLD) goto L15;
        return 120;
    L15:
        return (int) r2;
    }

    private static void init() {
        Context r0 = ApmContext.getContext();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1());
        float r3 = 0.0f;
        int r5 = 0;
        boolean r6 = false;
        if (ApmContext.supportMultiFrameRate() == false) goto L17;
        if (r0 == null) goto L17;
        Display r1 = ((WindowManager) r0.getSystemService("window")).getDefaultDisplay();
        float r2 = r1.getRefreshRate();
        Display.Mode[] r4 = r1.getSupportedModes();
        int r7 = r4.length;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L12;
        float r9 = r4[r8].getRefreshRate();
        if (r9 <= r3) goto L11;
        r3 = r9;
    L11:
        r8 = r8 + 1;
        goto L7
    L12:
        int r10 = getRoundedRate(r2);
        sCurrentRefreshRate = r10;
        sRealRefreshRate = r10;
        int r11 = getRoundedRate(r3);
        sDeviceMaxRefreshRate = r11;
        int r12 = sCurrentRefreshRate;
        if (r12 != r11) goto L15;
        r6 = true;
    L15:
        sUsingMaxRefreshRate = r6;
        sFrameIntervalMillis = ONE_SECOND_IN_MILLIS / r12;
        return;
    L17:
        sDeviceMaxRefreshRate = 60;
        sCurrentRefreshRate = 60;
        sUsingMaxRefreshRate = true;
        sFrameIntervalMillis = ONE_SECOND_IN_MILLIS / 60;
        sRealMaxRate = 60;
        sRealRefreshRate = 60;
        if (r0 == null) goto L33;
        Display r13 = ((WindowManager) r0.getSystemService("window")).getDefaultDisplay();
        sRealRefreshRate = getRoundedRate(r13.getRefreshRate());
        Display.Mode[] r14 = r13.getSupportedModes();
        int r15 = r14.length;
    L20:
        if (r5 >= r15) goto L25;
        float r16 = r14[r5].getRefreshRate();
        if (r16 <= r3) goto L24;
        r3 = r16;
    L24:
        r5 = r5 + 1;
        goto L20
    L25:
        sRealMaxRate = getRoundedRate(r3);
        return;
    }

    public static boolean isUsingMaxRefreshRate() {
        return sUsingMaxRefreshRate;
    }

    private static void refreshData(Activity r1) {
        float r2 = r1.getWindowManager().getDefaultDisplay().getRefreshRate();
        sRealRefreshRate = getRoundedRate(r2);
        if (ApmContext.supportMultiFrameRate() == true) goto L5;
        return;
    L5:
        int r3 = getRoundedRate(r2);
        sCurrentRefreshRate = r3;
        if (r3 != sDeviceMaxRefreshRate) goto L8;
        boolean r0 = true;
    L9:
        sUsingMaxRefreshRate = r0;
        sFrameIntervalMillis = ONE_SECOND_IN_MILLIS / r3;
        return;
    L8:
        r0 = false;
        goto L9
    }
}
