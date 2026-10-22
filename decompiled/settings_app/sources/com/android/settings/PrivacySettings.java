package com.android.settings;

import android.app.backup.IBackupManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacySettings extends SettingsPreferenceFragment {
    private static final String AUTO_RESTORE = "auto_restore";
    private static final String BACKUP_DATA = "backup_data";
    private static final String BACKUP_INACTIVE = "backup_inactive";
    private static final String COLLECT_DIAGNOSTICS = "collect_diagnostics";
    private static final String CONFIGURE_ACCOUNT = "configure_account";
    private static final String DATA_MANAGEMENT = "data_management";
    private static final String FACTORY_RESET = "factory_reset";
    private static final String GSETTINGS_PROVIDER = "com.google.settings";
    private static final String NETWORK_RESET = "network_reset";
    private static final String TAG = "PrivacySettings";
    private SwitchPreference mAutoRestore;
    private PreferenceScreen mBackup;
    private IBackupManager mBackupManager;
    private PreferenceScreen mConfigure;
    private boolean mEnabled;
    private PreferenceScreen mManageData;
    private Preference.OnPreferenceChangeListener preferenceChangeListener;

    @Override // com.android.settings.SettingsPreferenceFragment
    protected int getHelpResource() {
        return R.string.help_url_backup_reset;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_PrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_PrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrivacySettings() {
        this.preferenceChangeListener = new AnonymousClass1(this);
    }

    static /* synthetic */ SwitchPreference access$000(PrivacySettings r0) {
        return r0.mAutoRestore;
    }

    static /* synthetic */ IBackupManager access$100(PrivacySettings r0) {
        return r0.mBackupManager;
    }

    public void com_android_settings_PrivacySettings__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        boolean r6 = UserManager.get(getActivity()).isAdminUser();
        this.mEnabled = r6;
        if (r6 == true) goto L5;
        return;
    L5:
        addPreferencesFromResource(R.xml.privacy_settings);
        PreferenceScreen r7 = getPreferenceScreen();
        this.mBackupManager = IBackupManager.Stub.asInterface(ServiceManager.getService("backup"));
        this.mBackup = (PreferenceScreen) r7.findPreference(BACKUP_DATA);
        SwitchPreference r0 = (SwitchPreference) r7.findPreference(AUTO_RESTORE);
        this.mAutoRestore = r0;
        r0.setOnPreferenceChangeListener(this.preferenceChangeListener);
        this.mConfigure = (PreferenceScreen) r7.findPreference(CONFIGURE_ACCOUNT);
        this.mManageData = (PreferenceScreen) r7.findPreference(DATA_MANAGEMENT);
        HashSet r1 = new HashSet();
        getNonVisibleKeys(getActivity(), r1);
        int r2 = r7.getPreferenceCount() - 1;
    L6:
        if (r2 < 0) goto L11;
        Preference r3 = r7.getPreference(r2);
        if (r1.contains(r3.getKey()) == false) goto L10;
        r7.removePreference(r3);
    L10:
        r2 = r2 - 1;
        goto L6
    L11:
        updateToggles();
    }

    public void com_android_settings_PrivacySettings__onResume$___twin___() {
        super.onResume();
        if (this.mEnabled == false) goto L6;
        updateToggles();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.preference.PreferenceScreen] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void updateToggles() {
        ContentResolver r0 = getContentResolver();
        boolean r1 = false;
        Intent r2 = null;
        String r3 = null;
        r2 = null;
        boolean r4 = this.mBackupManager.isBackupEnabled();     // Catch: RemoteException -> L19
        String r5 = this.mBackupManager.getCurrentTransport();     // Catch: RemoteException -> L18
        Intent r6 = validatedActivityIntent(this.mBackupManager.getConfigurationIntent(r5), "config");     // Catch: RemoteException -> L18
        String r7 = this.mBackupManager.getDestinationString(r5);     // Catch: RemoteException -> L15
        Intent r8 = validatedActivityIntent(this.mBackupManager.getDataManagementIntent(r5), "management");     // Catch: RemoteException -> L14
        r3 = MultiSDKAdapterNew.getDataManagementLabel(this.mBackupManager, UserHandle.myUserId(), r5);     // Catch: RemoteException -> L13
        PreferenceScreen r9 = this.mBackup;     // Catch: RemoteException -> L13
        if (r4 == false) goto L10;
        int r10 = R.string.accessibility_feature_state_on;
    L11:
        r9.setSummary(r10);     // Catch: RemoteException -> L13
        ?? r11 = r3;
    L21:
        SwitchPreference r12 = this.mAutoRestore;
        if (android.provider.Settings.Secure.getInt(r0, "backup_auto_restore", 1) != 1) goto L24;
        boolean r13 = true;
    L25:
        r12.setChecked(r13);
        this.mAutoRestore.setEnabled(r4);
        if (r6 == null) goto L29;
        if (r4 == false) goto L29;
        boolean r14 = true;
    L30:
        this.mConfigure.setEnabled(r14);
        this.mConfigure.setIntent(r6);
        setConfigureSummary(r7);
        if (r8 == null) goto L34;
        if (r4 == false) goto L34;
        r1 = true;
    L34:
        if (r1 == false) goto L38;
        this.mManageData.setIntent(r8);
        if (r11 == 0) goto L50;
        this.mManageData.setTitle(r11);
        return;
    L50:
        return;
    L38:
        getPreferenceScreen().removePreference(this.mManageData);
        return;
    L29:
        r14 = false;
        goto L30
    L24:
        r13 = false;
        goto L25
    L10:
        r10 = R.string.accessibility_feature_state_off;
    L13:
        Object r15 = r3;
    L17:
        r2 = r6;
        Object r16 = r15;
    L20:
        this.mBackup.setEnabled(false);
        r6 = r2;
        r11 = r16;
        r4 = r4;
    L14:
        r8 = null;
    L16:
        r15 = r8;
    L15:
        r7 = null;
        r8 = null;
    L18:
        r7 = null;
        r8 = null;
        r4 = r4;
        r16 = null;
    L19:
        r4 = false;
        r16 = null;
        r7 = null;
        r8 = null;
        goto L20
    }

    private Intent validatedActivityIntent(Intent r2, String r3) {
        if (r2 == null) goto L9;
        List<ResolveInfo> r1 = getPackageManager().queryIntentActivities(r2, 0);
        if (r1 != null) goto L6;
    L7:
        OLog.e(TAG, "Backup " + r3 + " intent null fails to resolve; ignoring");
        return null;
    L6:
        if (r1.isEmpty() == true) goto L7;
        return r2;
    L9:
        return r2;
    }

    private void setConfigureSummary(String r1) {
        if (r1 == null) goto L4;
        this.mConfigure.setSummary(r1);
        return;
    L4:
        this.mConfigure.setSummary(R.string.backup_configure_account_default_summary);
    }

    private static void getNonVisibleKeys(Context r4, Collection<String> r5) {
        boolean r1 = false;
        boolean r0 = IBackupManager.Stub.asInterface(ServiceManager.getService("backup")).isBackupServiceActive(UserHandle.myUserId());     // Catch: RemoteException -> L5
    L7:
        if (r4.getPackageManager().resolveContentProvider(GSETTINGS_PROVIDER, 0) != null) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        if (r0 == true) goto L11;
    L12:
        if (r1 == true) goto L14;
        if (r0 == false) goto L14;
    L16:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r4, "no_factory_reset", UserHandle.myUserId()) == false) goto L19;
        r5.add(FACTORY_RESET);
    L19:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r4, "no_network_reset", UserHandle.myUserId()) == false) goto L22;
        r5.add(NETWORK_RESET);
    L22:
        if (collectDiagnosticsEnabled(r4) == true) goto L27;
        r5.add(COLLECT_DIAGNOSTICS);
        return;
    L27:
        return;
    L14:
        r5.add(BACKUP_DATA);
        r5.add(AUTO_RESTORE);
        r5.add(CONFIGURE_ACCOUNT);
    L11:
        r5.add(BACKUP_INACTIVE);
    L5:
        OLog.w(TAG, "Failed querying backup manager service activity status. Assuming it is inactive.");
        r0 = false;
        goto L7
    }

    private static boolean collectDiagnosticsEnabled(Context r1) {
        return r1.getResources().getBoolean(R.bool.config_collect_diagnostics_enabled);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_PrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivacySettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PrivacySettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivacySettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_PrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivacySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PrivacySettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
