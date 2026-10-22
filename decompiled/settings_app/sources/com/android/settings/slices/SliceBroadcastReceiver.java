package com.android.settings.slices;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.core.BasePreferenceController;
import com.android.settings.notification.zen.ZenModeSliceBuilder;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.wifi.calling.WifiCallingSliceHelper;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class SliceBroadcastReceiver extends BroadcastReceiver {
    private static String TAG = "SettSliceBroadcastRec";

    static {
    }

    private void handleSliderAction(Context r1, Uri r2, String r3, int r4) {
    }

    private void handleToggleAction(Context r1, Uri r2, String r3, boolean r4) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_slices_SliceBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public SliceBroadcastReceiver() {
    }

    public void com_android_settings_slices_SliceBroadcastReceiver__onReceive$___twin___(Context r9, Intent r10) {
        String r0 = r10.getAction();
        String r1 = r10.getStringExtra(SettingsSliceProvider.EXTRA_SLICE_KEY);
        if (CustomSliceRegistry.isValidAction(r0) == false) goto L6;
        CustomSliceable.createInstance(r9, CustomSliceRegistry.getSliceClassByUri(Uri.parse(r0))).onNotifyChange(r10);
        return;
    L6:
        Uri r2 = r10.getData();
        switch(r0.hashCode()) {
            case -2075790298: goto L25;
            case -86230637: goto L22;
            case 17552563: goto L19;
            case 176882490: goto L16;
            case 495970216: goto L13;
            case 1913359032: goto L10;
            default: goto L41;
        };
    L41:
        byte r3 = -1;
    L28:
        if (r3 == 0) goto L34;
        if (r3 == 1) goto L33;
        if (r3 != 2) goto L44;
        ZenModeSliceBuilder.handleUriChange(r9, r10);
        return;
    L44:
        return;
    L33:
        handleSliderAction(r9, r2, r1, r10.getIntExtra("android.app.slice.extra.RANGE_VALUE", -1));
        return;
    L34:
        handleToggleAction(r9, r2, r1, r10.getBooleanExtra("android.app.slice.extra.TOGGLE_STATE", false));
        return;
    L10:
        if (r0.equals(ZenModeSliceBuilder.ACTION_ZEN_MODE_SLICE_CHANGED) == false) goto L27;
        r3 = 2;
        goto L28
    L27:
        r3 = -1;
        goto L28
    L13:
        if (r0.equals(WifiCallingSliceHelper.ACTION_WIFI_CALLING_PREFERENCE_CELLULAR_PREFERRED) == false) goto L36;
        r3 = 5;
        goto L28
    L36:
        r3 = -1;
        goto L28
    L16:
        if (r0.equals(WifiCallingSliceHelper.ACTION_WIFI_CALLING_PREFERENCE_WIFI_ONLY) == false) goto L37;
        r3 = 3;
        goto L28
    L37:
        r3 = -1;
        goto L28
    L19:
        if (r0.equals(SettingsSliceProvider.ACTION_SLIDER_CHANGED) == false) goto L38;
        r3 = 1;
        goto L28
    L38:
        r3 = -1;
        goto L28
    L22:
        if (r0.equals(WifiCallingSliceHelper.ACTION_WIFI_CALLING_PREFERENCE_WIFI_PREFERRED) == false) goto L39;
        r3 = 4;
        goto L28
    L39:
        r3 = -1;
        goto L28
    L25:
        if (r0.equals(SettingsSliceProvider.ACTION_TOGGLE_CHANGED) == false) goto L40;
        r3 = 0;
        goto L28
    L40:
        r3 = -1;
        goto L28
    }

    private void logSliceValueChange(Context r7, String r8, int r9) {
        FeatureFactory.getFeatureFactory().getMetricsFeatureProvider().action(0, 1372, 0, r8, r9);
    }

    private BasePreferenceController getPreferenceController(Context r1, String r2) {
        return SliceBuilderUtils.getPreferenceController(r1, new SlicesDatabaseAccessor(r1).getSliceDataFromKey(r2));
    }

    @Insert("onReceive")
    public static void com_android_settings_slices_SliceBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(SliceBroadcastReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        SliceBroadcastReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_android_settings_slices_SliceBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_slices_SliceBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_slices_SliceBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_slices_SliceBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
