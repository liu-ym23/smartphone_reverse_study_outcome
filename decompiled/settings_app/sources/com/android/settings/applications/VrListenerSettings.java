package com.android.settings.applications;

import android.os.Bundle;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ManagedServiceSettings;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VrListenerSettings extends ManagedServiceSettings {
    private static final ManagedServiceSettings.Config CONFIG = null;
    private static final String TAG = "VrListenerSettings";

    public void com_android_settings_applications_VrListenerSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_VrListenerSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.utils.ManagedServiceSettings, com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_VrListenerSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.utils.ManagedServiceSettings, com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_VrListenerSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public VrListenerSettings() {
    }

    static {
        CONFIG = getVrListenerConfig();
    }

    private static final ManagedServiceSettings.Config getVrListenerConfig() {
        ManagedServiceSettings.Config r0 = new ManagedServiceSettings.Config();
        r0.tag = TAG;
        r0.setting = "enabled_vr_listeners";
        r0.intentAction = "android.service.vr.VrListenerService";
        r0.permission = "android.permission.BIND_VR_LISTENER_SERVICE";
        r0.noun = "vr listener";
        r0.warningDialogTitle = R.string.vr_listener_security_warning_title;
        r0.warningDialogSummary = R.string.vr_listener_security_warning_summary;
        r0.emptyText = R.string.no_vr_listeners;
        return r0;
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected ManagedServiceSettings.Config getConfig() {
        return CONFIG;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_VrListenerSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VrListenerSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_VrListenerSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_VrListenerSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VrListenerSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_VrListenerSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_VrListenerSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VrListenerSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_VrListenerSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
