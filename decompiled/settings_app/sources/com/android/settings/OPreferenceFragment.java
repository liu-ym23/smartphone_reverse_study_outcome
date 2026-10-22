package com.android.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OPreferenceFragment extends PreferenceFragment {
    public void com_android_settings_OPreferenceFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OPreferenceFragment__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_OPreferenceFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        com_android_settings_OPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        com_android_settings_OPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    public OPreferenceFragment() {
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        super.onCreateView(r1, r2, r3);
        return r1.inflate(R.layout.o_preference_list_fragment, r2, false);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(OPreferenceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OPreferenceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(OPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OPreferenceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_OPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(OPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OPreferenceFragment__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
