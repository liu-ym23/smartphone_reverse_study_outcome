package com.android.settings.applications;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import androidx.preference.Preference;
import com.android.internal.content.PackageMonitor;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.Index;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManageDefaultApps extends SettingsPreferenceFragment implements Preference.OnPreferenceClickListener, Indexable {
    private static final long DELAY_UPDATE_BROWSER_MILLIS = 500;
    private static final String KEY_DEFAULT_BROWSER = "default_browser";
    private static final String KEY_DEFAULT_EMERGENCY_APP = "default_emergency_app";
    private static final String KEY_DEFAULT_PHONE_APP = "default_phone_app";
    private static final String KEY_SMS_APPLICATION = "default_sms_app";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final String TAG = "ManageDefaultApps";
    private DefaultBrowserPreference mDefaultBrowserPreference;
    private final Handler mHandler;
    private final PackageMonitor mPackageMonitor;
    private PackageManager mPm;
    private final Runnable mUpdateRunnable;
    private int myUserId;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ManageDefaultApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r1) {
        return false;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ManageDefaultApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ManageDefaultApps() {
        this.mHandler = new Handler();
        this.mUpdateRunnable = new AnonymousClass1(this);
        this.mPackageMonitor = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(ManageDefaultApps r0) {
        r0.updateDefaultBrowserPreference();
    }

    static /* synthetic */ Runnable access$100(ManageDefaultApps r0) {
        return r0.mUpdateRunnable;
    }

    static /* synthetic */ Handler access$200(ManageDefaultApps r0) {
        return r0.mHandler;
    }

    static /* synthetic */ int access$300(ManageDefaultApps r0) {
        return r0.myUserId;
    }

    static /* synthetic */ PackageManager access$400(ManageDefaultApps r0) {
        return r0.mPm;
    }

    static /* synthetic */ DefaultBrowserPreference access$500(ManageDefaultApps r0) {
        return r0.mDefaultBrowserPreference;
    }

    private void updateDefaultBrowserPreference() {
        this.mDefaultBrowserPreference.refreshBrowserApps();
        PackageManager r0 = getPackageManager();
        String r1 = r0.getDefaultBrowserPackageNameAsUser(UserHandle.myUserId());
        if (TextUtils.isEmpty(r1) == true) goto L8;
        Intent r2 = new Intent();
        r2.setPackage(r1);
        r2.setAction("android.intent.action.VIEW");
        r2.addCategory("android.intent.category.BROWSABLE");
        r2.setData(Uri.parse("http:"));
        ResolveInfo r3 = this.mPm.resolveActivityAsUser(r2, 0, this.myUserId);
        if (r3 == null) goto L7;
        this.mDefaultBrowserPreference.setValue(r1);
        CharSequence r4 = r3.loadLabel(r0);
        this.mDefaultBrowserPreference.setSummary(r4);
        return;
    L7:
        this.mDefaultBrowserPreference.setSummary(R.string.default_browser_title_none);
        return;
    L8:
        this.mDefaultBrowserPreference.setSummary(R.string.default_browser_title_none);
        OLog.d(TAG, "Cannot set empty default Browser value!");
    }

    public void com_android_settings_applications_ManageDefaultApps__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mPm = getPackageManager();
        this.myUserId = UserHandle.myUserId();
        DefaultBrowserPreference r3 = (DefaultBrowserPreference) findPreference(KEY_DEFAULT_BROWSER);
        this.mDefaultBrowserPreference = r3;
        r3.setOnPreferenceChangeListener(new AnonymousClass3(this));
        UserManager.get(getActivity()).getUserInfo(this.myUserId).isRestricted();
        if (DefaultEmergencyPreference.isCapable(getActivity()) == false) goto L6;
        Index.getInstance(getActivity()).updateFromClassNameResource(ManageDefaultApps.class.getName(), true, true);
        return;
    }

    public void com_android_settings_applications_ManageDefaultApps__onResume$___twin___() {
        super.onResume();
        updateDefaultBrowserPreference();
        this.mPackageMonitor.register(getActivity(), getActivity().getMainLooper(), false);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPackageMonitor.unregister();
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass4();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ManageDefaultApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageDefaultApps r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageDefaultApps__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageDefaultApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageDefaultApps r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ManageDefaultApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageDefaultApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageDefaultApps r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageDefaultApps__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
