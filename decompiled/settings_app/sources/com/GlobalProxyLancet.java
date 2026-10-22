package com;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.ApnSettings;
import com.android.settings.ConfirmLockPassword;
import com.android.settings.ConfirmLockPattern;
import com.android.settings.DataUsageActivity;
import com.android.settings.DevelopmentSettings;
import com.android.settings.FallbackHome;
import com.android.settings.LandscapeSettings;
import com.android.settings.MultiSimSettings;
import com.android.settings.MultiSimSubscription;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsApplication;
import com.android.settings.SimPinSettingsActivity;
import com.android.settings.UsbConfigSettingsActivity;
import com.android.settings.activate.ActivateActivity;
import com.android.settings.base.BaseActivity;
import com.android.settings.bluetooth.DeviceAdvancedSettings;
import com.android.settings.bluetooth.DeviceProfilesSettingsSmtActivity;
import com.android.settings.bluetooth.DockService;
import com.android.settings.bluetooth.RequestPermissionActivity;
import com.android.settings.deviceinfo.ExternalManageDetail;
import com.android.settings.deviceinfo.Status;
import com.android.settings.deviceinfo.StoragePathActivity;
import com.android.settings.deviceinfo.StoragePathDetailActivity;
import com.android.settings.deviceinfo.UsbModeChooserActivity;
import com.android.settings.meeting.TabletWifiPickerActivity;
import com.android.settings.settingitemsprovider.SettingsSearchService;
import com.android.settings.wifi.RequestToggleWiFiActivity;
import com.android.settings.wifi.SortNetworkListActivity;
import com.android.settings.wifi.WifiApService;
import com.android.settings.wifi.WifiStatusTest;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.hook.lancet.LogLancet;
import com.obric.olog.OLog;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.NameRegex;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class GlobalProxyLancet {
    private GlobalProxyLancet() {
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(MultiSimSettings r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ActivateActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(DeviceProfilesSettingsSmtActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(DockService r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(RequestPermissionActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ExternalManageDetail r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Status r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(StoragePathActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(StoragePathDetailActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(UsbModeChooserActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(TabletWifiPickerActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SettingsSearchService r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(WifiStatusTest r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Activity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(FragmentActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ApnSettings r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ConfirmLockPassword r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ConfirmLockPattern r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(DataUsageActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(DevelopmentSettings r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(FallbackHome r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(LandscapeSettings r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(MultiSimSettings r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(MultiSimSubscription r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SettingsActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SettingsApplication r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SimPinSettingsActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(UsbConfigSettingsActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(BaseActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(DeviceAdvancedSettings r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(RequestToggleWiFiActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SortNetworkListActivity r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(WifiApService r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(WifiStatusTest r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @JvmStatic
    @Proxy(globalProxyClass = true, value = "d")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_d(String r4, String r5) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L11;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        OLog.d(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===");
        goto L9
    L16:
        return 0;
    L11:
        OLog.d(r4, r5);
        return 0;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
        return r1.registerReceiver(r2, r3, r4, r5);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(FragmentActivity r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
        return r1.registerReceiver(r2, r3, r4, r5);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Status r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
        return r1.registerReceiver(r2, r3, r4, r5);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
    }

    @JvmStatic
    @Proxy("d")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_d(String r4, String r5, Throwable r6) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L14;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L27;
        String r3 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===";
        if (r6 != null) goto L12;
        OLog.d(r4, r3);
        goto L9
    L12:
        OLog.d(r4, r3, r6);
        goto L9
    L27:
        return 0;
    L14:
        if (r6 == null) goto L16;
        OLog.d(r4, r5, r6);
        return 0;
    L16:
        OLog.d(r4, r5);
        return 0;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5, int r6) {
        return r1.registerReceiver(r2, r3, r4, r5, r6);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5, r6);
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_i(String r4, String r5) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L11;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        OLog.i(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===");
        goto L9
    L16:
        return 0;
    L11:
        OLog.i(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_i(String r4, String r5, Throwable r6) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L14;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L27;
        String r3 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===";
        if (r6 != null) goto L12;
        OLog.i(r4, r3);
        goto L9
    L12:
        OLog.i(r4, r3, r6);
        goto L9
    L27:
        return 0;
    L14:
        if (r6 == null) goto L16;
        OLog.i(r4, r5, r6);
        return 0;
    L16:
        OLog.i(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("v")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_v(String r4, String r5) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L11;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        OLog.v(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===");
        goto L9
    L16:
        return 0;
    L11:
        OLog.v(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_e(String r4, String r5) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L11;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        OLog.e(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===");
        goto L9
    L16:
        return 0;
    L11:
        OLog.e(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_e(String r4, String r5, Throwable r6) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L14;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L27;
        String r3 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===";
        if (r6 != null) goto L12;
        OLog.e(r4, r3);
        goto L9
    L12:
        OLog.e(r4, r3, r6);
        goto L9
    L27:
        return 0;
    L14:
        if (r6 == null) goto L16;
        OLog.e(r4, r5, r6);
        return 0;
    L16:
        OLog.e(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_w(String r4, String r5) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L11;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        OLog.w(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===");
        goto L9
    L16:
        return 0;
    L11:
        OLog.w(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(LogLancet.NAME_REGEX)
    @TargetClass(LogLancet.TARGET_CLASS)
    public static int com_obric_hook_lancet_LogLancet_w(String r4, String r5, Throwable r6) {
        LogLancet r0 = LogLancet.INSTANCE;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.length() <= 4096) goto L14;
        LogLancet r1 = LogLancet.INSTANCE;
        Iterator<T> r2 = LogLancet.splitLog(r5).iterator();
    L9:
        if (r2.hasNext() == false) goto L27;
        String r3 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r2.next()) + "===long log fragment tail===";
        if (r6 != null) goto L12;
        OLog.w(r4, r3);
        goto L9
    L12:
        OLog.w(r4, r3, r6);
        goto L9
    L27:
        return 0;
    L14:
        if (r6 == null) goto L16;
        OLog.w(r4, r5, r6);
        return 0;
    L16:
        OLog.w(r4, r5);
        return 0;
    }
}
