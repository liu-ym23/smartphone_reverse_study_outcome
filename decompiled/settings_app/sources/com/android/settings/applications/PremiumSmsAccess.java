package com.android.settings.applications;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.preference.DropDownPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.DividerPreference;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.notification.EmptyTextSettings;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PremiumSmsAccess extends EmptyTextSettings implements AppStateBaseBridge.Callback, com.android.settingslib.applications.ApplicationsState.Callbacks, Preference.OnPreferenceChangeListener {
    private com.android.settingslib.applications.ApplicationsState mApplicationsState;
    private com.android.settingslib.applications.ApplicationsState.Session mSession;
    private AppStateSmsPremBridge mSmsBackend;

    private class PremiumSmsPreference extends DropDownPreference {
        private final com.android.settingslib.applications.ApplicationsState.AppEntry mAppEntry;
        final /* synthetic */ PremiumSmsAccess this$0;

        static /* synthetic */ com.android.settingslib.applications.ApplicationsState.AppEntry access$000(PremiumSmsPreference r0) {
            return r0.mAppEntry;
        }

        public PremiumSmsPreference(PremiumSmsAccess r3, com.android.settingslib.applications.ApplicationsState.AppEntry r4, Context r5) {
            this.this$0 = r3;
            super(r5);
            this.mAppEntry = r4;
            r4.ensureLabel(r5);
            setTitle(r4.label);
            if (r4.icon == null) goto L5;
            setIcon(r4.icon);
        L5:
            setEntries(R.array.security_settings_premium_sms_values);
            setEntryValues(new CharSequence[]{String.valueOf(1), String.valueOf(2), String.valueOf(3)});
            setValue(String.valueOf(getCurrentValue()));
            setSummary("%s");
        }

        private int getCurrentValue() {
            if ((this.mAppEntry.extraInfo instanceof AppStateSmsPremBridge.SmsState) == true) goto L7;
            return 0;
        L7:
            return ((AppStateSmsPremBridge.SmsState) this.mAppEntry.extraInfo).smsState;
        }

        @Override // androidx.preference.DropDownPreference, androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r3) {
            if (getIcon() != null) goto L5;
            r3.itemView.post(new AnonymousClass1(this));
        L5:
            super.onBindViewHolder(r3);
        }
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PremiumSmsAccess_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
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

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PremiumSmsAccess_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    public PremiumSmsAccess() {
    }

    static /* synthetic */ com.android.settingslib.applications.ApplicationsState access$100(PremiumSmsAccess r0) {
        return r0.mApplicationsState;
    }

    public void com_android_settings_applications_PremiumSmsAccess__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        com.android.settingslib.applications.ApplicationsState r4 = com.android.settingslib.applications.ApplicationsState.getInstance((Application) getContext().getApplicationContext());
        this.mApplicationsState = r4;
        this.mSession = r4.newSession(this);
        this.mSmsBackend = new AppStateSmsPremBridge(getContext(), this.mApplicationsState, this);
    }

    @Override // com.android.settings.notification.EmptyTextSettings, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setLoading(true, false);
    }

    public void com_android_settings_applications_PremiumSmsAccess__onResume$___twin___() {
        super.onResume();
        MultiSDKAdapter.resumeSession(this.mSession);
        this.mSmsBackend.resume();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mSmsBackend.pause();
        MultiSDKAdapter.pauseSession(this.mSession);
        super.onPause();
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        this.mSmsBackend.setSmsState(PremiumSmsPreference.access$000((PremiumSmsPreference) r1).info.packageName, Integer.parseInt((String) r2));
        return true;
    }

    private void updatePrefs(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        setEmptyText(R.string.premium_sms_none);
        setLoading(false, true);
        PreferenceScreen r2 = getPreferenceManager().createPreferenceScreen(getPrefContext());
        r2.setOrderingAsAdded(true);
        int r3 = 0;
    L6:
        if (r3 >= r8.size()) goto L9;
        Preference r4 = new PremiumSmsPreference(this, r8.get(r3), getPrefContext());
        r4.setOnPreferenceChangeListener(this);
        r2.addPreference(r4);
        r3 = r3 + 1;
        goto L6
    L9:
        if (r8.size() == 0) goto L11;
        DividerPreference r9 = new DividerPreference(getPrefContext());
        r9.setSelectable(false);
        r9.setSummary(R.string.premium_sms_warning);
        r9.setDividerAllowedAbove(true);
        r2.addPreference(r9);
    L11:
        setPreferenceScreen(r2);
    }

    private void update() {
        updatePrefs(this.mSession.rebuild(AppStateSmsPremBridge.FILTER_APP_PREMIUM_SMS, com.android.settingslib.applications.ApplicationsState.ALPHA_COMPARATOR));
    }

    @Override // com.android.settings.applications.AppStateBaseBridge.Callback
    public void onExtraInfoUpdated() {
        update();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r1) {
        updatePrefs(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PremiumSmsAccess_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PremiumSmsAccess r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PremiumSmsAccess__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PremiumSmsAccess_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PremiumSmsAccess r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PremiumSmsAccess_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PremiumSmsAccess_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PremiumSmsAccess r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PremiumSmsAccess__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
