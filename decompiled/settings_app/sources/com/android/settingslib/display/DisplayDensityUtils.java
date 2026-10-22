package com.android.settingslib.display;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.MathUtils;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class DisplayDensityUtils {
    private static final int HD_RESOLUTION_SIZE = 2709700;
    private static final Predicate<DisplayInfo> INTERNAL_ONLY = null;
    private static final int LARGE_DISPLAY_SIZE = 640;
    private static final String LOG_TAG = "DisplayDensityUtils";
    private static final int MIN_DIMENSION_DP = 320;
    private static final int NORMAL_DISPLAY_SIZE = 560;
    private static final int SMALL_DISPLAY_SIZE = 480;
    private static final int[] SUMMARIES_LARGER = null;
    private static final int[] SUMMARIES_SMALLER = null;
    private static final int SUMMARY_CUSTOM = 0;
    public static final int SUMMARY_DEFAULT = 0;
    private int mCurrentIndex;
    private int mDefaultDensityForDefaultDisplay;
    private String[] mDefaultDisplayDensityEntries;
    private int[] mDefaultDisplayDensityValues;
    private final DisplayManager mDisplayManager;
    private final Predicate<DisplayInfo> mPredicate;
    private final Map<String, int[]> mValuesPerDisplay;

    static {
        SUMMARY_DEFAULT = R.string.screen_zoom_summary_default;
        SUMMARY_CUSTOM = R.string.screen_zoom_summary_custom;
        SUMMARIES_SMALLER = new int[]{R.string.screen_zoom_summary_small};
        SUMMARIES_LARGER = new int[]{R.string.screen_zoom_summary_large, R.string.screen_zoom_summary_very_large, R.string.screen_zoom_summary_extremely_large};
        INTERNAL_ONLY = new DisplayDensityUtils$$ExternalSyntheticLambda1();
    }

    static /* synthetic */ boolean lambda$static$0(DisplayInfo r1) {
        if (r1.type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public DisplayDensityUtils(Context r2) {
        this(r2, INTERNAL_ONLY);
    }

    public DisplayDensityUtils(Context r17, Predicate r18) {
        this.mValuesPerDisplay = new HashMap();
        this.mCurrentIndex = -1;
        this.mPredicate = r18;
        DisplayManager r3 = (DisplayManager) r17.getSystemService(DisplayManager.class);
        this.mDisplayManager = r3;
        Display[] r4 = r3.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");
        int r5 = r4.length;
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L41;
        Display r7 = r4[r6];
        DisplayInfo r8 = new DisplayInfo();
        if (r7.getDisplayInfo(r8) == true) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Cannot fetch display info for display " + r7.getDisplayId());
    L40:
        r6 = r6 + 1;
        goto L3
    L9:
        if (this.mPredicate.test(r8) == false) goto L11;
        int r9 = getDefaultDensityForDisplay(r7.getDisplayId());
        if (r9 > 0) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Cannot fetch default density for display " + r7.getDisplayId());
        goto L40
    L18:
        Resources r10 = r17.getResources();
        int r11 = r8.logicalDensityDpi;
        float r12 = Math.min(r17.getResources().getFraction(R.fraction.display_density_max_scale, 1, 1), ((Math.min(r8.logicalWidth, r8.logicalHeight) * 160) / 320) / r9);
        float r13 = r17.getResources().getFraction(R.fraction.display_density_min_scale, 1, 1);
        float r2 = r17.getResources().getFraction(R.fraction.display_density_min_scale_interval, 1, 1);
        float r14 = 1.0f;
        MathUtils.constrain((r12 - 1.0f) / r2, 0.0f, SUMMARIES_LARGER.length);
        MathUtils.constrain((1.0f - r13) / r2, 0.0f, SUMMARIES_SMALLER.length);
        String[] r15 = new String[3];
        int[] r16 = new int[3];
        WindowManager r19 = (WindowManager) r17.getSystemService("window");
        if ((r19.getCurrentWindowMetrics().getBounds().width() * r19.getCurrentWindowMetrics().getBounds().height()) <= HD_RESOLUTION_SIZE) goto L21;
        boolean r110 = true;
    L22:
        if (r110 == true) goto L25;
        r14 = 0.875f;
    L25:
        int r111 = (int) (480.0f * r14);
        r16[0] = r111;
        int r112 = (int) (560.0f * r14);
        r16[1] = r112;
        int r113 = (int) (r14 * 640.0f);
        r16[2] = r113;
        if (r11 != r111) goto L28;
        int r114 = 0;
    L33:
        if (r114 < 0) goto L35;
        int r115 = r114;
    L37:
        if (r7.getDisplayId() != 0) goto L39;
        this.mDefaultDensityForDefaultDisplay = r9;
        this.mCurrentIndex = r115;
        this.mDefaultDisplayDensityEntries = r15;
        this.mDefaultDisplayDensityValues = r16;
    L39:
        this.mValuesPerDisplay.put(r8.uniqueId, r16);
        goto L40
    L35:
        r16 = Arrays.copyOf(r16, 4);
        r16[0] = r11;
        r15 = (String[]) Arrays.copyOf(r15, 4);
        r15[0] = r10.getString(SUMMARY_CUSTOM, new Object[]{Integer.valueOf(r11)});
        r115 = 0;
        goto L37
    L28:
        if (r11 != r112) goto L30;
        r114 = 1;
        goto L33
    L30:
        if (r11 != r113) goto L32;
        r114 = 2;
        goto L33
    L32:
        r114 = -1;
        goto L33
    L21:
        r110 = false;
        goto L22
    L11:
        if (r7.getDisplayId() != 0) goto L40;
        throw new IllegalArgumentException("Predicate must not filter out the default display.");
    }

    public String[] getDefaultDisplayDensityEntries() {
        return this.mDefaultDisplayDensityEntries;
    }

    public int[] getDefaultDisplayDensityValues() {
        return this.mDefaultDisplayDensityValues;
    }

    public int getCurrentIndexForDefaultDisplay() {
        return this.mCurrentIndex;
    }

    public int getDefaultDensityForDefaultDisplay() {
        return this.mDefaultDensityForDefaultDisplay;
    }

    private static int getDefaultDensityForDisplay(int r1) {
        return WindowManagerGlobal.getWindowManagerService().getInitialDisplayDensity(r1);
    L4:
        return -1;
    }

    public void clearForcedDisplayDensity() {
        final int r0 = UserHandle.myUserId();
        AsyncTask.execute(new DisplayDensityUtils$$ExternalSyntheticLambda0(this, r0));
    }

    /* JADX INFO: renamed from: lambda$clearForcedDisplayDensity$1$com-android-settingslib-display-DisplayDensityUtils, reason: not valid java name */
    /* synthetic */ void m756xdecf53e3(int r8) {
        Display[] r1 = this.mDisplayManager.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");     // Catch: RemoteException -> L13
        int r2 = r1.length;     // Catch: RemoteException -> L13
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L21;
        Display r4 = r1[r3];     // Catch: RemoteException -> L13
        int r5 = r4.getDisplayId();     // Catch: RemoteException -> L13
        DisplayInfo r6 = new DisplayInfo();     // Catch: RemoteException -> L13
        if (r4.getDisplayInfo(r6) == true) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Unable to clear forced display density setting for display " + r5);     // Catch: RemoteException -> L13
    L12:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.mPredicate.test(r6) == false) goto L12;
        WindowManagerGlobal.getWindowManagerService().clearForcedDisplayDensityForUser(r5, r8);     // Catch: RemoteException -> L13
        goto L12
    L21:
        return;
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Unable to clear forced display density setting");
    }

    public void setForcedDisplayDensity(final int r3) {
        final int r0 = UserHandle.myUserId();
        AsyncTask.execute(new DisplayDensityUtils$$ExternalSyntheticLambda2(this, r3, r0));
    }

    /* JADX INFO: renamed from: lambda$setForcedDisplayDensity$2$com-android-settingslib-display-DisplayDensityUtils, reason: not valid java name */
    /* synthetic */ void m757xd1d3f9f9(int r10, int r11) {
        Display[] r1 = this.mDisplayManager.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");     // Catch: RemoteException -> L17
        int r2 = r1.length;     // Catch: RemoteException -> L17
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L26;
        Display r4 = r1[r3];     // Catch: RemoteException -> L17
        int r5 = r4.getDisplayId();     // Catch: RemoteException -> L17
        DisplayInfo r6 = new DisplayInfo();     // Catch: RemoteException -> L17
        if (r4.getDisplayInfo(r6) == true) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Unable to save forced display density setting for display " + r5);     // Catch: RemoteException -> L17
    L16:
        r3 = r3 + 1;
        goto L4
    L10:
        if (this.mPredicate.test(r6) == false) goto L16;
        if (this.mValuesPerDisplay.containsKey(r6.uniqueId) == true) goto L15;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Unable to save forced display density setting for display " + r6.uniqueId);     // Catch: RemoteException -> L17
        goto L16
    L15:
        WindowManagerGlobal.getWindowManagerService().setForcedDisplayDensityForUser(r5, this.mValuesPerDisplay.get(r6.uniqueId)[r10], r11);     // Catch: RemoteException -> L17
        goto L16
    L26:
        return;
    L17:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LOG_TAG, "Unable to save forced display density setting");
    }
}
