package com.android.settings.applications;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.IntentFilterVerificationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.ArraySet;
import android.view.View;
import androidx.preference.DropDownPreference;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppLaunchSettings extends AppInfoWithHeader implements View.OnClickListener, Preference.OnPreferenceChangeListener {
    private static final String KEY_APP_LINK_STATE = "app_link_state";
    private static final String KEY_CLEAR_DEFAULTS = "app_launch_clear_defaults";
    private static final String KEY_SUPPORTED_DOMAIN_URLS = "app_launch_supported_domain_urls";
    private static final String TAG = "AppLaunchSettings";
    private static final Intent sBrowserIntent = null;
    private AppDomainsPreference mAppDomainUrls;
    private DropDownPreference mAppLinkState;
    private ClearDefaultsPreference mClearDefaultsPreference;
    private boolean mHasDomainUrls;
    private boolean mIsBrowser;
    private PackageManager mPm;

    public void com_android_settings_applications_AppLaunchSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_AppLaunchSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        return true;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_AppLaunchSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppLaunchSettings() {
    }

    static /* synthetic */ boolean access$000(AppLaunchSettings r0, int r1) {
        return r0.updateAppLinkState(r1);
    }

    static {
        sBrowserIntent = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.parse("http:"));
    }

    public void com_android_settings_applications_AppLaunchSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        addPreferencesFromResource(R.xml.installed_app_launch_settings);
        this.mAppDomainUrls = (AppDomainsPreference) findPreference(KEY_SUPPORTED_DOMAIN_URLS);
        this.mClearDefaultsPreference = (ClearDefaultsPreference) findPreference(KEY_CLEAR_DEFAULTS);
        this.mAppLinkState = (DropDownPreference) findPreference(KEY_APP_LINK_STATE);
        this.mPm = getActivity().getPackageManager();
        this.mIsBrowser = isBrowserApp(this.mPackageName);
        if ((this.mAppEntry.info.privateFlags & 16) == 0) goto L5;
        boolean r4 = true;
    L6:
        this.mHasDomainUrls = r4;
        if (this.mIsBrowser == true) goto L9;
        List r5 = this.mPm.getIntentFilterVerifications(this.mPackageName);
        List r0 = this.mPm.getAllIntentFilters(this.mPackageName);
        CharSequence[] r6 = getEntries(this.mPackageName, r5, r0);
        this.mAppDomainUrls.setTitles(r6);
        this.mAppDomainUrls.setValues(new int[r6.length]);
    L9:
        buildStateDropDown();
        return;
    L5:
        r4 = false;
        goto L6
    }

    private boolean isBrowserApp(String r5) {
        Intent r0 = sBrowserIntent;
        r0.setPackage(r5);
        List r4 = this.mPm.queryIntentActivitiesAsUser(r0, 131072, UserHandle.myUserId());
        int r6 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L11;
        ResolveInfo r2 = (ResolveInfo) r4.get(r1);
        if (r2.activityInfo == null) goto L10;
        if (r2.handleAllWebDataURI == false) goto L10;
        return true;
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return false;
    }

    private void buildStateDropDown() {
        if (this.mIsBrowser == false) goto L5;
        this.mAppLinkState.setShouldDisableView(true);
        this.mAppLinkState.setEnabled(false);
        this.mAppDomainUrls.setShouldDisableView(true);
        this.mAppDomainUrls.setEnabled(false);
        return;
    L5:
        this.mAppLinkState.setEntries(new CharSequence[]{getString(R.string.app_link_open_always), getString(R.string.app_link_open_ask), getString(R.string.app_link_open_never)});
        int r2 = 4;
        this.mAppLinkState.setEntryValues(new CharSequence[]{Integer.toString(2), Integer.toString(4), Integer.toString(3)});
        this.mAppLinkState.setEnabled(this.mHasDomainUrls);
        if (this.mHasDomainUrls == false) goto L14;
        int r0 = this.mPm.getIntentVerificationStatusAsUser(this.mPackageName, UserHandle.myUserId());
        DropDownPreference r1 = this.mAppLinkState;
        if (r0 == 0) goto L11;
        r2 = r0;
    L11:
        r1.setValue(Integer.toString(r2));
        this.mAppLinkState.setOnPreferenceChangeListener(new AnonymousClass1(this));
        return;
    }

    private boolean updateAppLinkState(int r5) {
        boolean r1 = false;
        if (this.mIsBrowser == false) goto L5;
        return false;
    L5:
        int r0 = UserHandle.myUserId();
        if (this.mPm.getIntentVerificationStatusAsUser(this.mPackageName, r0) != r5) goto L8;
        return false;
    L8:
        boolean r2 = this.mPm.updateIntentVerificationStatusAsUser(this.mPackageName, r5, r0);
        if (r2 == true) goto L11;
        OLog.e(TAG, "Couldn't update intent verification status!");
        return r2;
    L11:
        if (r5 != this.mPm.getIntentVerificationStatusAsUser(this.mPackageName, r0)) goto L16;
        r1 = true;
    L16:
        return r1;
    }

    private CharSequence[] getEntries(String r1, List<IntentFilterVerificationInfo> r2, List<IntentFilter> r3) {
        ArraySet<String> r0 = Utils.getHandledDomains(this.mPm, r1);
        return (CharSequence[]) r0.toArray(new CharSequence[r0.size()]);
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        this.mClearDefaultsPreference.setPackageName(this.mPackageName);
        this.mClearDefaultsPreference.setAppEntry(this.mAppEntry);
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_AppLaunchSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppLaunchSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AppLaunchSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AppLaunchSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppLaunchSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_AppLaunchSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AppLaunchSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppLaunchSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AppLaunchSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
