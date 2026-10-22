package com.android.settings.specialaccess.premiumsms;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.applications.AppStateSmsPremBridge;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedDropDownPreference;
import com.android.settingslib.applications.ApplicationsState;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PremiumSmsAccessActivity extends SpecialAccessBaseActivity implements AppStateBaseBridge.Callback, ApplicationsState.Callbacks {
    private static final String ECM_RESTRICTION_KEY = "android:premium_sms_access";
    private final String TAG;
    private PremiumSmsAccessAdapter mApplicationAdapter;
    private ApplicationsState mApplicationsState;
    private PackageManager mPackageManager;
    private ApplicationsState.Session mSession;
    private AppStateSmsPremBridge mSmsBackend;

    private class PremiumSmsPreference extends RestrictedDropDownPreference {
        private final ApplicationsState.AppEntry mAppEntry;
        final /* synthetic */ PremiumSmsAccessActivity this$0;

        static /* synthetic */ ApplicationsState.AppEntry access$100(PremiumSmsPreference r0) {
            return r0.mAppEntry;
        }

        public PremiumSmsPreference(PremiumSmsAccessActivity r4, ApplicationsState.AppEntry r5, Context r6) {
            this.this$0 = r4;
            super(r6);
            this.mAppEntry = r5;
            r5.ensureLabel(r6);
            setTitle(r5.label);
            if (r5.icon == null) goto L5;
            setIcon(r5.icon);
        L5:
            setEntries(R.array.security_settings_premium_sms_values);
            setEntryValues(new CharSequence[]{String.valueOf(1), String.valueOf(2), String.valueOf(3)});
            setValue(String.valueOf(getCurrentValue()));
            setSummary("%s");
            checkEcmRestrictionAndSetDisabled(PremiumSmsAccessActivity.ECM_RESTRICTION_KEY, r5.info.packageName);
        }

        private int getCurrentValue() {
            if ((this.mAppEntry.extraInfo instanceof AppStateSmsPremBridge.SmsState) == true) goto L7;
            return 0;
        L7:
            return ((AppStateSmsPremBridge.SmsState) this.mAppEntry.extraInfo).smsState;
        }

        @Override // com.android.settingslib.RestrictedDropDownPreference, androidx.preference.DropDownPreference, androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r3) {
            if (getIcon() != null) goto L5;
            r3.itemView.post(new AnonymousClass1(this));
        L5:
            super.onBindViewHolder(r3);
        }
    }

    public void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.premium_sms_none;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.premium_sms_warning;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.premium_sms_access;
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLauncherInfoChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLoadEntriesCompleted() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PremiumSmsAccessActivity() {
        this.TAG = "PremiumSmsAccessActivity";
    }

    static /* synthetic */ void access$000(PremiumSmsAccessActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    static /* synthetic */ ApplicationsState access$200(PremiumSmsAccessActivity r0) {
        return r0.mApplicationsState;
    }

    public void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        ApplicationsState r5 = ApplicationsState.getInstance((Application) getApplicationContext());
        this.mApplicationsState = r5;
        this.mSession = r5.newSession(this, getSettingsLifecycle());
        this.mSmsBackend = new AppStateSmsPremBridge(this, this.mApplicationsState, this);
        this.mPackageManager = getPackageManager();
        this.mApplicationAdapter = new PremiumSmsAccessAdapter(this, this.mSmsBackend, this.mPackageManager, new AnonymousClass1(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getPackageIdx(String r4) {
        int r0 = this.mApplicationAdapter.getItemCount();
        if (this.mPackageName == null) goto L13;
        if (r0 <= 0) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L13;
        ApplicationInfo r2 = this.mApplicationAdapter.getApps().get(r1).info;
        if (r2 == null) goto L12;
        if (TextUtils.equals(r4, r2.packageName) == false) goto L12;
    L14:
        OLog.i("PremiumSmsAccessActivity", "jump to: " + r1 + ", package: " + r4);
        return r1;
    L12:
        r1 = r1 + 1;
    L13:
        r1 = -1;
        goto L14
    }

    public void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onResume$___twin___() {
        super.onResume();
        this.mSmsBackend.resume(true);
    }

    public void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onPause$___twin___() {
        this.mSmsBackend.pause();
        super.onPause();
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mSmsBackend.release();
        super.onDestroy();
    }

    private void updatePrefs(ArrayList<ApplicationsState.AppEntry> r2) {
        if (r2 != null) goto L4;
    L8:
        showEmptyView();
        return;
    L4:
        if (r2.isEmpty() == true) goto L8;
        showContent();
        this.mApplicationAdapter.setData(r2);
        updatePositionAfterNotify();
    }

    private void update() {
        updatePrefs(this.mSession.rebuild(AppStateSmsPremBridge.FILTER_APP_PREMIUM_SMS, ApplicationsState.ALPHA_COMPARATOR));
    }

    @Override // com.android.settings.applications.AppStateBaseBridge.Callback
    public void onExtraInfoUpdated() {
        update();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r1) {
        updatePrefs(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PremiumSmsAccessActivity r1) {
        r1.com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PremiumSmsAccessActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PremiumSmsAccessActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PremiumSmsAccessActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PremiumSmsAccessActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PremiumSmsAccessActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PremiumSmsAccessActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PremiumSmsAccessActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_premiumsms_PremiumSmsAccessActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PremiumSmsAccessActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
