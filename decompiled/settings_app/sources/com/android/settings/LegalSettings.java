package com.android.settings;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceScreen;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LegalSettings extends SettingsPreferenceFragment implements Indexable {
    private static final String KEY_COPYRIGHT = "copyright";
    private static final String KEY_LICENSE = "license";
    private static final String KEY_TERMS = "terms";
    private static final String KEY_WEBVIEW_LICENSE = "webview_license";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;

    public void com_android_settings_LegalSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_LegalSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_LegalSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LegalSettings() {
    }

    public void com_android_settings_LegalSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        addPreferencesFromResource(R.xml.about_legal);
        FragmentActivity r4 = getActivity();
        PreferenceScreen r2 = getPreferenceScreen();
        Utils.updatePreferenceToSpecificActivityOrRemove(r4, r2, KEY_TERMS, 1);
        Utils.updatePreferenceToSpecificActivityOrRemove(r4, r2, KEY_LICENSE, 1);
        Utils.updatePreferenceToSpecificActivityOrRemove(r4, r2, KEY_COPYRIGHT, 1);
        Utils.updatePreferenceToSpecificActivityOrRemove(r4, r2, KEY_WEBVIEW_LICENSE, 1);
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass1();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LegalSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LegalSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LegalSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LegalSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LegalSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_LegalSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LegalSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LegalSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LegalSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
