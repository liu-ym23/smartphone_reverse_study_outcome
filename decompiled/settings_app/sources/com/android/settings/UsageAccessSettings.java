package com.android.settings;

import android.app.ActivityThread;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.widget.CompoundButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.content.PackageMonitor;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingSwitchPreference;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UsageAccessSettings extends SettingsPreferenceFragment23 implements Preference.OnPreferenceChangeListener, CompoundButton.OnCheckedChangeListener {
    private static final int[] APP_OPS_OP_CODES = null;
    private static final String[] PM_USAGE_STATS_PERMISSION = null;
    private static final String TAG = "UsageAccessSettings";
    AlertDialog dialog;
    AppOpsManager mAppOpsManager;
    private AppsRequestingAccessFetcher mLastFetcherTask;
    ArrayMap<String, PackageEntry> mPackageEntryMap;
    private final PackageMonitor mPackageMonitor;
    PreferenceScreen mPreferenceScreen;

    private class AppsRequestingAccessFetcher extends AsyncTask<Void, Void, ArrayMap<String, PackageEntry>> {
        private final Context mContext;
        private final IPackageManager mIPackageManager;
        private final PackageManager mPackageManager;
        final /* synthetic */ UsageAccessSettings this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ArrayMap<String, PackageEntry> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(ArrayMap<String, PackageEntry> r1) {
            onPostExecute2(r1);
        }

        public AppsRequestingAccessFetcher(UsageAccessSettings r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mPackageManager = r2.getPackageManager();
            this.mIPackageManager = ActivityThread.getPackageManager();
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ArrayMap<String, PackageEntry> doInBackground2(Void... r10) {
            String[] r1 = this.mIPackageManager.getAppOpPermissionPackages("android.permission.PACKAGE_USAGE_STATS", this.mContext.getUserId());     // Catch: RemoteException -> L49
            if (r1 != null) goto L6;
            return null;
        L6:
            ArrayMap<String, PackageEntry> r0 = new ArrayMap();
            int r2 = r1.length;
            int r4 = 0;
        L7:
            if (r4 >= r2) goto L12;
            String r5 = r1[r4];
            if (shouldIgnorePackage(r5) == true) goto L11;
            r0.put(r5, new PackageEntry(r5));
        L11:
            r4 = r4 + 1;
            goto L7
        L12:
            List<PackageInfo> r3 = this.mPackageManager.getPackagesHoldingPermissions(UsageAccessSettings.access$000(), 0);
            if (r3 == null) goto L15;
            int r6 = r3.size();
        L16:
            int r7 = 0;
        L18:
            if (r7 >= r6) goto L23;
            PackageInfo r8 = r3.get(r7);
            PackageEntry r9 = r0.get(r8.packageName);
            if (r9 == null) goto L22;
            r9.packageInfo = r8;
            r9.permissionGranted = true;
        L22:
            r7 = r7 + 1;
            goto L18
        L23:
            int r11 = r0.size();
            int r12 = 0;
        L24:
            if (r12 >= r11) goto L31;
            PackageEntry r13 = r0.valueAt(r12);
            if (r13.packageInfo != null) goto L30;
            r13.packageInfo = this.mPackageManager.getPackageInfo(r13.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L29
        L29:
            r0.removeAt(r12);
            r12 = r12 - 1;
            r11 = r11 - 1;
        L30:
            r12 = r12 + 1;
            goto L24
        L31:
            List r14 = this.this$0.mAppOpsManager.getPackagesForOps(UsageAccessSettings.access$100());
            if (r14 == null) goto L34;
            int r15 = r14.size();
        L35:
            int r16 = 0;
        L36:
            if (r16 >= r15) goto L48;
            AppOpsManager.PackageOps r17 = (AppOpsManager.PackageOps) r14.get(r16);
            PackageEntry r18 = r0.get(r17.getPackageName());
            if (r18 != null) goto L41;
            OLog.w(UsageAccessSettings.TAG, "AppOp permission exists for package " + r17.getPackageName() + " but package doesn't exist or did not request UsageStats access");
        L47:
            r16 = r16 + 1;
            goto L36
        L41:
            if (r17.getUid() != r18.packageInfo.applicationInfo.uid) goto L47;
            if (r17.getOps().size() >= 1) goto L46;
            OLog.w(UsageAccessSettings.TAG, "No AppOps permission exists for package " + r17.getPackageName());
            goto L47
        L46:
            r18.appOpMode = ((AppOpsManager.OpEntry) r17.getOps().get(0)).getMode();
            goto L47
        L48:
            return r0;
        L34:
            r15 = 0;
            goto L35
        L15:
            r6 = 0;
        L49:
            OLog.w(UsageAccessSettings.TAG, "PackageManager is dead. Can't get list of packages requesting android.permission.PACKAGE_USAGE_STATS");
            return null;
        }

        boolean shouldIgnorePackage(String r1) {
            return Utils.isPackageInstalledAndIsSystemApp(this.this$0.getActivity(), r1);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ArrayMap<String, PackageEntry> r7) {
            UsageAccessSettings.access$202(this.this$0, null);
            if (this.this$0.getActivity() != null) goto L5;
            return;
        L5:
            if (r7 != null) goto L8;
            this.this$0.mPackageEntryMap.clear();
            this.this$0.mPreferenceScreen.removeAll();
            return;
        L8:
            int r0 = this.this$0.mPackageEntryMap.size();
            int r2 = 0;
        L9:
            if (r2 >= r0) goto L15;
            PackageEntry r3 = this.this$0.mPackageEntryMap.valueAt(r2);
            PackageEntry r4 = r7.get(r3.packageName);
            if (r4 != null) goto L13;
            this.this$0.mPreferenceScreen.removePreference(r3.preference);
        L14:
            r2 = r2 + 1;
            goto L9
        L13:
            r4.preference = r3.preference;
            goto L14
        L15:
            int r1 = r7.size();
            int r5 = 0;
        L16:
            if (r5 >= r1) goto L21;
            PackageEntry r6 = r7.valueAt(r5);
            if (r6.preference != null) goto L20;
            r6.preference = new SettingSwitchPreference(this.mContext);
            r6.preference.setTagForSwitch(r6.packageName);
            r6.preference.setPersistent(false);
            r6.preference.setOnCheckedChangeListener(this.this$0);
            this.this$0.mPreferenceScreen.addPreference(r6.preference);
        L20:
            updatePreference(r6);
            r5 = r5 + 1;
            goto L16
        L21:
            this.this$0.mPackageEntryMap.clear();
            this.this$0.mPackageEntryMap = r7;
        }

        private void updatePreference(PackageEntry r4) {
            r4.preference.setIcon(r4.packageInfo.applicationInfo.loadIcon(this.mPackageManager));
            r4.preference.setTitle(r4.packageInfo.applicationInfo.loadLabel(this.mPackageManager));
            r4.preference.setKey(r4.packageName);
            if (r4.appOpMode != 0) goto L6;
            boolean r3 = true;
        L10:
            if (r3 == r4.preference.isChecked()) goto L13;
            r4.preference.setChecked(r3);
            return;
        L13:
            return;
        L6:
            if (r4.appOpMode != 3) goto L8;
            r3 = r4.permissionGranted;
            goto L10
        L8:
            r3 = false;
            goto L10
        }
    }

    private static class PackageEntry {
        int appOpMode;
        PackageInfo packageInfo;
        final String packageName;
        boolean permissionGranted;
        SettingSwitchPreference preference;

        public PackageEntry(String r1) {
            this.packageName = r1;
            this.appOpMode = 3;
        }
    }

    public static class WarningDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
        private static final String ARG_PACKAGE_NAME = "package";

        public void com_android_settings_UsageAccessSettings$WarningDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_UsageAccessSettings$WarningDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_UsageAccessSettings$WarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_UsageAccessSettings$WarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public WarningDialogFragment() {
        }

        public static WarningDialogFragment newInstance(String r3) {
            WarningDialogFragment r0 = new WarningDialogFragment();
            Bundle r1 = new Bundle();
            r1.putString("package", r3);
            r0.setArguments(r1);
            return r0;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r2) {
            return new AlertDialog.Builder(getActivity()).setTitle(R.string.allow_usage_access_title).setMessage(R.string.allow_usage_access_message).setIconAttribute(android.R.attr.alertDialogIcon).setNegativeButton(R.string.cancel, this).setPositiveButton(android.R.string.ok, this).create();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-1)) goto L5;
            ((UsageAccessSettings) getParentFragment()).allowAccess(getArguments().getString("package"));
            return;
        L5:
            r2.cancel();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_UsageAccessSettings$WarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WarningDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_UsageAccessSettings$WarningDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_UsageAccessSettings$WarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WarningDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_UsageAccessSettings$WarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_UsageAccessSettings$WarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WarningDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_UsageAccessSettings$WarningDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_UsageAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_UsageAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UsageAccessSettings() {
        this.mPackageEntryMap = new ArrayMap();
        this.mPackageMonitor = new AnonymousClass4(this);
    }

    static /* synthetic */ String[] access$000() {
        return PM_USAGE_STATS_PERMISSION;
    }

    static /* synthetic */ int[] access$100() {
        return APP_OPS_OP_CODES;
    }

    static /* synthetic */ AppsRequestingAccessFetcher access$202(UsageAccessSettings r0, AppsRequestingAccessFetcher r1) {
        r0.mLastFetcherTask = r1;
        return r1;
    }

    static /* synthetic */ void access$300(UsageAccessSettings r0) {
        r0.updateInterestedApps();
    }

    static {
        PM_USAGE_STATS_PERMISSION = new String[]{"android.permission.PACKAGE_USAGE_STATS"};
        APP_OPS_OP_CODES = new int[]{43};
    }

    public void com_android_settings_UsageAccessSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        addPreferencesFromResource(R.xml.usage_access_settings);
        PreferenceScreen r3 = getPreferenceScreen();
        this.mPreferenceScreen = r3;
        r3.setOrderingAsAdded(false);
        this.mAppOpsManager = (AppOpsManager) getSystemService("appops");
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        RecyclerView r3 = getListView();
        getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin);
        r3.setPadding(0, 0, 0, 0);
    }

    public void com_android_settings_UsageAccessSettings__onResume$___twin___() {
        super.onResume();
        updateInterestedApps();
        this.mPackageMonitor.register(getActivity(), Looper.getMainLooper(), false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPackageMonitor.unregister();
        AppsRequestingAccessFetcher r0 = this.mLastFetcherTask;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mLastFetcherTask = null;
        return;
    }

    private void updateInterestedApps() {
        AppsRequestingAccessFetcher r0 = this.mLastFetcherTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        AppsRequestingAccessFetcher r1 = new AppsRequestingAccessFetcher(this, getActivity());
        this.mLastFetcherTask = r1;
        r1.execute(new Void[0]);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r6, Object r7) {
        String r8 = r6.getKey();
        PackageEntry r0 = this.mPackageEntryMap.get(r8);
        if (r0 != null) goto L7;
        OLog.w(TAG, "Preference change event for package " + r8 + " but that package is no longer valid.");
        return false;
    L7:
        if ((r7 instanceof Boolean) == true) goto L10;
        OLog.w(TAG, "Preference change event for package " + r8 + " had non boolean value of type " + r7.getClass().getName());
        return false;
    L10:
        int r9 = !((Boolean) r7).booleanValue() ? 1 : 0;
        if (r0.appOpMode == r9) goto L20;
        if (r9 == 0) goto L15;
        setNewMode(r0, r9);
        return true;
    L15:
        FragmentTransaction r10 = getChildFragmentManager().beginTransaction();
        Fragment r5 = getChildFragmentManager().findFragmentByTag("warning");
        if (r5 == null) goto L18;
        r10.remove(r5);
    L18:
        WarningDialogFragment.newInstance(r0.packageName).show(r10, "warning");
        return false;
    L20:
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        String r0 = (String) r3.getTag();
        if (r0 != null) goto L5;
        return;
    L5:
        PackageEntry r1 = this.mPackageEntryMap.get(r0);
        if (r1 != null) goto L9;
        OLog.w(TAG, "Preference change event for package " + r0 + " but that package is no longer valid.");
        return;
    L9:
        int r5 = !Boolean.valueOf(r4).booleanValue() ? 1 : 0;
        if (r1.appOpMode == r5) goto L16;
        if (r5 == 0) goto L14;
        setNewMode(r1, r5);
        return;
    L14:
        showWarningDialog(r1, r3);
        return;
    }

    private void showWarningDialog(final PackageEntry r4, final CompoundButton r5) {
        AlertDialog r6 = new AlertDialog.Builder(getActivity()).setTitle(R.string.allow_usage_access_title).setMessage(R.string.allow_usage_access_message).setIconAttribute(android.R.attr.alertDialogIcon).setNegativeButton(R.string.cancel, new AnonymousClass3(this, r5)).setPositiveButton(android.R.string.ok, new AnonymousClass2(this, r4)).setOnCancelListener(new AnonymousClass1(this, r5)).create();
        this.dialog = r6;
        if (r6.isShowing() == true) goto L6;
        this.dialog.show();
        return;
    }

    void setNewMode(PackageEntry r4, int r5) {
        this.mAppOpsManager.setMode(43, r4.packageInfo.applicationInfo.uid, r4.packageName, r5);
        r4.appOpMode = r5;
    }

    void allowAccess(String r2) {
        PackageEntry r0 = this.mPackageEntryMap.get(r2);
        if (r0 != null) goto L6;
        OLog.w(TAG, "Unable to give access to package " + r2 + ": it does not exist.");
        return;
    L6:
        setNewMode(r0, 0);
        r0.preference.setChecked(true);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_UsageAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UsageAccessSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UsageAccessSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UsageAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UsageAccessSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_UsageAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UsageAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UsageAccessSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UsageAccessSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
