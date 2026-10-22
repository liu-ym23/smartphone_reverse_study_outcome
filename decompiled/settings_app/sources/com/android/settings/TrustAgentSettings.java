package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.common.preference.ORestrictedSwitchPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TrustAgentSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {
    private static final String SERVICE_INTERFACE = "android.service.trust.TrustAgentService";
    private final ArraySet<ComponentName> mActiveAgents;
    private ArrayMap<ComponentName, AgentInfo> mAvailableAgents;
    private DevicePolicyManager mDpm;
    private LockPatternUtils mLockPatternUtils;

    public static final class AgentInfo {
        ComponentName component;
        public Drawable icon;
        CharSequence label;
        ORestrictedSwitchPreference preference;

        public AgentInfo() {
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof AgentInfo) == true) goto L5;
            return true;
        L5:
            return this.component.equals(((AgentInfo) r2).component);
        }

        public int compareTo(AgentInfo r1) {
            return this.component.compareTo(r1.component);
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_TrustAgentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_TrustAgentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TrustAgentSettings() {
        this.mActiveAgents = new ArraySet();
    }

    public void com_android_settings_TrustAgentSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mDpm = (DevicePolicyManager) getActivity().getSystemService(DevicePolicyManager.class);
        addPreferencesFromResource(R.xml.trust_agent_settings);
    }

    public void com_android_settings_TrustAgentSettings__onResume$___twin___() {
        super.onResume();
        removePreference("dummy_preference");
        updateAgents();
    }

    private void updateAgents() {
        FragmentActivity r0 = getActivity();
        if (this.mAvailableAgents != null) goto L6;
        this.mAvailableAgents = findAvailableTrustAgents();
    L6:
        if (this.mLockPatternUtils != null) goto L8;
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
    L8:
        loadActiveAgents();
        PreferenceGroup r1 = (PreferenceGroup) NullSafe.nonNull(getPreferenceScreen().findPreference("trust_agents"));
        r1.removeAll();
        RestrictedLockUtils.EnforcedAdmin r2 = MultiSDKAdapterNew.checkIfKeyguardFeaturesDisabled(r0, 16, UserHandle.myUserId());
        int r3 = this.mAvailableAgents.size();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        AgentInfo r5 = this.mAvailableAgents.valueAt(r4);
        ORestrictedSwitchPreference r6 = new ORestrictedSwitchPreference(getPrefContext());
        r6.setKey(r5.component.flattenToString());
        r6.useAdminDisabledSummary(true);
        r6.setCardPosition(r3, r4);
        r5.preference = r6;
        r6.setPersistent(false);
        r6.setTitle(r5.label);
        r6.setIcon(r5.icon);
        r6.setPersistent(false);
        r6.setOnPreferenceChangeListener(this);
        r6.setChecked(this.mActiveAgents.contains(r5.component));
        if (TrustAgentUtils.isDisabledByAdmin(this.mDpm, r2, r5.component) == false) goto L13;
        r6.setChecked(false);
        r6.setDisabledByAdmin(r2);
    L13:
        r1.addPreference(r5.preference);
        r4 = r4 + 1;
        goto L9
    }

    private void loadActiveAgents() {
        this.mActiveAgents.clear();
        List r0 = this.mLockPatternUtils.getEnabledTrustAgents(UserHandle.myUserId());
        if (r0 == null) goto L6;
        this.mActiveAgents.addAll(r0);
        return;
    }

    private void saveActiveAgents() {
        this.mLockPatternUtils.setEnabledTrustAgents(this.mActiveAgents, UserHandle.myUserId());
    }

    ArrayMap<ComponentName, AgentInfo> findAvailableTrustAgents() {
        PackageManager r8 = getActivity().getPackageManager();
        List<ResolveInfo> r0 = r8.queryIntentServices(new Intent(SERVICE_INTERFACE), 128);
        ArrayMap<ComponentName, AgentInfo> r1 = new ArrayMap();
        int r2 = r0.size();
        r1.ensureCapacity(r2);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        ResolveInfo r4 = r0.get(r3);
        if (r4.serviceInfo == null) goto L11;
        if (TrustAgentUtils.checkProvidePermission(r4, r8) == false) goto L11;
        ComponentName r5 = TrustAgentUtils.getComponentName(r4);
        AgentInfo r6 = new AgentInfo();
        r6.label = r4.loadLabel(r8);
        r6.icon = r4.loadIcon(r8);
        r6.component = r5;
        r1.put(r5, r6);
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return r1;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r6, Object r7) {
        if ((r6 instanceof ORestrictedSwitchPreference) == false) goto L17;
        int r0 = this.mAvailableAgents.size();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L17;
        AgentInfo r3 = this.mAvailableAgents.valueAt(r2);
        if (r3.preference == r6) goto L9;
        r2 = r2 + 1;
        goto L5
    L9:
        if (((Boolean) r7).booleanValue() == true) goto L11;
        this.mActiveAgents.remove(r3.component);
    L14:
        saveActiveAgents();
        return true;
    L11:
        if (this.mActiveAgents.contains(r3.component) == true) goto L14;
        this.mActiveAgents.add(r3.component);
    L17:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_TrustAgentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TrustAgentSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_TrustAgentSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TrustAgentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TrustAgentSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_TrustAgentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TrustAgentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TrustAgentSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_TrustAgentSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
