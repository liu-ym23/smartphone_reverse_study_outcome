package com.android.settings.applications.appinfo;

import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.UserHandle;
import android.util.FeatureFlagUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import com.android.internal.app.LocaleHelper;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.applications.AppLocaleUtil;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.EntityHeaderController;
import com.android.settingslib.applications.AppUtils;
import com.android.settingslib.widget.LayoutPreference;
import com.obric.matrix.sdk.network.BuildConfig;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppLocaleDetails extends SettingsPreferenceFragment {
    private static final String KEY_APP_DESCRIPTION = "app_locale_description";
    private static final String KEY_APP_DISCLAIMER = "app_locale_disclaimer";
    private static final String TAG = "AppLocaleDetails";
    private ApplicationInfo mApplicationInfo;
    private boolean mCreated;
    private String mPackageName;
    private LayoutPreference mPrefOfDescription;
    private Preference mPrefOfDisclaimer;

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return BuildConfig.SDK_VERSION_CODE;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_appinfo_AppLocaleDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_appinfo_AppLocaleDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppLocaleDetails() {
        this.mCreated = false;
    }

    public static AppLocaleDetails newInstance(String r3, int r4) {
        AppLocaleDetails r0 = new AppLocaleDetails();
        Bundle r1 = new Bundle();
        r1.putString("package", r3);
        r1.putInt("uid", r4);
        r0.setArguments(r1);
        return r0;
    }

    public void com_android_settings_applications_appinfo_AppLocaleDetails__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        String r0 = r4.getString("package", "");
        this.mPackageName = r0;
        if (r0.isEmpty() == false) goto L5;
        OLog.d(TAG, "There is no package name.");
        finish();
    L5:
        int r5 = r4.getInt("uid", getContext().getUserId());
        addPreferencesFromResource(R.xml.app_locale_details);
        this.mPrefOfDescription = (LayoutPreference) getPreferenceScreen().findPreference(KEY_APP_DESCRIPTION);
        this.mPrefOfDisclaimer = getPreferenceScreen().findPreference(KEY_APP_DISCLAIMER);
        this.mApplicationInfo = getApplicationInfo(this.mPackageName, r5);
        setDisclaimerPreference();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (this.mPackageName.isEmpty() == false) goto L7;
        return r2.inflate(R.layout.manage_applications_apps_unsupported, null);
    L7:
        return super.onCreateView(r2, r3, r4);
    }

    public void com_android_settings_applications_appinfo_AppLocaleDetails__onResume$___twin___() {
        super.onResume();
        refreshUi();
    }

    private void refreshUi() {
        setDescription();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        if (this.mCreated == false) goto L6;
        OLog.w(TAG, "onActivityCreated: ignoring duplicate call");
        return;
    L6:
        this.mCreated = true;
        if (this.mPackageName != null) goto L9;
        return;
    L9:
        LayoutPreference r5 = EntityHeaderController.newInstance(getActivity(), this, null).setIcon(Utils.getBadgedIcon(getContext(), this.mApplicationInfo)).setLabel(this.mApplicationInfo.loadLabel(getContext().getPackageManager())).setIsInstantApp(AppUtils.isInstant(this.mApplicationInfo)).setPackageName(this.mPackageName).setUid(this.mApplicationInfo.uid).setHasAppInfoLink(true).setButtonActions(0, 0).setOrder(10).done(getPrefContext());
        getPreferenceScreen().addPreference(r5);
    }

    private void setDisclaimerPreference() {
        if (FeatureFlagUtils.isEnabled(getContext(), "settings_app_locale_opt_in_enabled") == false) goto L6;
        this.mPrefOfDisclaimer.setVisible(false);
        return;
    }

    private void setDescription() {
        int r0 = getAppDescription();
        if (r0 == (-1)) goto L6;
        this.mPrefOfDescription.setVisible(true);
        ((TextView) this.mPrefOfDescription.findViewById(R.id.description)).setText(getContext().getString(r0));
        return;
    }

    private ApplicationInfo getApplicationInfo(String r2, int r3) {
        return getContext().getPackageManager().getApplicationInfoAsUser(r2, 0, r3);
    L4:
        OLog.w(TAG, "Application info not found for: " + r2);
        return null;
    }

    private int getAppDescription() {
        LocaleList r0 = AppLocaleUtil.getPackageLocales(getContext(), this.mPackageName);
        String[] r2 = AppLocaleUtil.getAssetLocales(getContext(), this.mPackageName);
        if (r0 != null) goto L5;
    L6:
        if (r0 == null) goto L8;
        return -1;
    L8:
        if (r2.length != 0) goto L14;
        return R.string.desc_no_available_supported_locale;
    L14:
        return -1;
    L5:
        if (r0.isEmpty() == false) goto L6;
        return R.string.desc_no_available_supported_locale;
    }

    public static Locale getAppDefaultLocale(Context r3, String r4) {
        LocaleManager r5 = (LocaleManager) r3.getSystemService(LocaleManager.class);
        if (r5 != null) goto L13;
        LocaleList r6 = null;
    L6:
        if (r6 == null) goto L15;
        return r6.get(0);
    L10:
        e = move-exception;
        OLog.w(TAG, "package name : " + r4 + " is not correct. " + e);
        return null;
    L15:
        return null;
    L13:
        r6 = r5.getApplicationLocales(r4);     // Catch: IllegalArgumentException -> L10
        goto L6
    }

    public static CharSequence getSummary(Context r2, ApplicationInfo r3) {
        Locale r4 = getAppDefaultLocale(r2.createContextAsUser(UserHandle.getUserHandleForUid(r3.uid), 0), r3.packageName);
        if (r4 != null) goto L7;
        return r2.getString(R.string.preference_of_system_locale_summary);
    L7:
        return LocaleHelper.getDisplayName(r4.stripExtensions(), r4, true);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_appinfo_AppLocaleDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppLocaleDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_AppLocaleDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_AppLocaleDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppLocaleDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_appinfo_AppLocaleDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_AppLocaleDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppLocaleDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_AppLocaleDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
