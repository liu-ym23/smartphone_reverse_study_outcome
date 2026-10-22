package com.android.settings.fuelgauge;

import android.app.ActivityManager;
import android.app.ApplicationErrorReport;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.settings.AppHeader;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.applications.InstalledAppDetails;
import com.android.settings.applications.LayoutPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PowerUsageDetail extends PowerUsageBase_ implements View.OnClickListener {
    public static final int ACTION_APP_DETAILS = 5;
    public static final int ACTION_BLUETOOTH_SETTINGS = 3;
    public static final int ACTION_DISPLAY_SETTINGS = 1;
    public static final int ACTION_FORCE_STOP = 7;
    public static final int ACTION_LOCATION_SETTINGS = 6;
    public static final int ACTION_REPORT = 8;
    public static final int ACTION_WIFI_SETTINGS = 2;
    public static final int ACTION_WIRELESS_SETTINGS = 4;
    public static final String EXTRA_DETAIL_TYPES = "types";
    public static final String EXTRA_DETAIL_VALUES = "values";
    public static final String EXTRA_DRAIN_TYPE = "drainType";
    public static final String EXTRA_GAUGE = "gauge";
    public static final String EXTRA_ICON_ID = "iconId";
    public static final String EXTRA_ICON_PACKAGE = "iconPackage";
    public static final String EXTRA_NO_COVERAGE = "noCoverage";
    public static final String EXTRA_PERCENT = "percent";
    public static final String EXTRA_REPORT_CHECKIN_DETAILS = "report_checkin_details";
    public static final String EXTRA_REPORT_DETAILS = "report_details";
    public static final String EXTRA_SHOW_LOCATION_BUTTON = "showLocationButton";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_USAGE_DURATION = "duration";
    public static final String EXTRA_USAGE_SINCE = "since";
    private static final String KEY_CONTROLS_PARENT = "controls_parent";
    private static final String KEY_DETAILS_PARENT = "details_parent";
    private static final String KEY_HIGH_POWER = "high_power";
    private static final String KEY_MESSAGES_PARENT = "messages_parent";
    private static final String KEY_PACKAGES_PARENT = "packages_parent";
    private static final String KEY_TWO_BUTTONS = "two_buttons";
    private static final String TAG = "PowerUsageDetail";
    public static final int USAGE_SINCE_RESET = 2;
    public static final int USAGE_SINCE_UNPLUGGED = 1;
    private static int[] sDrainTypeDesciptions;
    ApplicationInfo mApp;
    private final BroadcastReceiver mCheckKillProcessesReceiver;
    private PreferenceCategory mControlsParent;
    private PreferenceCategory mDetailsParent;
    private DevicePolicyManager mDpm;
    private OButton mForceStopButton;
    private Preference mHighPower;
    ComponentName mInstaller;
    private PreferenceCategory mMessagesParent;
    private double mNoCoverage;
    private String[] mPackages;
    private PreferenceCategory mPackagesParent;
    private PackageManager mPm;
    private OButton mReportButton;
    private boolean mShowLocationButton;
    private long mStartTime;
    private int[] mTypes;
    private int mUid;
    private int mUsageSince;
    private boolean mUsesGps;
    private double[] mValues;

    private void doAction(int r1) {
    }

    @Override // com.android.settings.fuelgauge.PowerUsageBase_, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_PowerUsageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.fuelgauge.PowerUsageBase_, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_PowerUsageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PowerUsageDetail() {
        this.mCheckKillProcessesReceiver = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(PowerUsageDetail r0, int r1) {
        r0.doAction(r1);
    }

    static /* synthetic */ OButton access$100(PowerUsageDetail r0) {
        return r0.mForceStopButton;
    }

    static {
        sDrainTypeDesciptions = new int[]{R.string.battery_desc_standby, R.string.battery_desc_radio, R.string.battery_desc_voice, R.string.battery_desc_wifi, R.string.battery_desc_bluetooth, R.string.battery_desc_flashlight, R.string.battery_desc_display, R.string.battery_desc_apps, R.string.battery_desc_users, R.string.battery_desc_unaccounted, R.string.battery_desc_overcounted, R.string.battery_desc_camera};
    }

    public void com_android_settings_fuelgauge_PowerUsageDetail__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L5;
        this.mPm = r3.getPackageManager();
        this.mDpm = (DevicePolicyManager) r3.getSystemService("device_policy");
    L5:
        addPreferencesFromResource(R.xml.power_usage_details);
        this.mDetailsParent = (PreferenceCategory) findPreference(KEY_DETAILS_PARENT);
        this.mControlsParent = (PreferenceCategory) findPreference(KEY_CONTROLS_PARENT);
        this.mMessagesParent = (PreferenceCategory) findPreference(KEY_MESSAGES_PARENT);
        this.mPackagesParent = (PreferenceCategory) findPreference(KEY_PACKAGES_PARENT);
        createDetails();
    }

    public void com_android_settings_fuelgauge_PowerUsageDetail__onResume$___twin___() {
        super.onResume();
        this.mStartTime = Process.getElapsedCpuTime();
        checkForceStop();
        Preference r0 = this.mHighPower;
        if (r0 == null) goto L5;
        r0.setSummary(HighPowerDetail.getSummary(getActivity(), this.mApp.packageName));
    L5:
        setupHeader();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (this.mHighPower == null) goto L10;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L11;
        ApplicationInfo r5 = this.mApp;
        if (r5 == null) goto L12;
        this.mHighPower.setSummary(HighPowerDetail.getSummary(r4, r5.packageName));
        return;
    L12:
        return;
    L11:
        return;
    }

    private void createDetails() {
        Bundle r0 = getArguments();
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        PackageManager r2 = r1.getPackageManager();
        boolean r4 = true;
        this.mUsageSince = r0.getInt(EXTRA_USAGE_SINCE, 1);
        int r3 = r0.getInt("uid", 0);
        this.mUid = r3;
        if (r2 == null) goto L8;
        this.mPackages = r2.getPackagesForUid(r3);
    L8:
        this.mNoCoverage = r0.getDouble(EXTRA_NO_COVERAGE, 0.0d);
        this.mShowLocationButton = r0.getBoolean(EXTRA_SHOW_LOCATION_BUTTON);
        this.mTypes = r0.getIntArray("types");
        this.mValues = r0.getDoubleArray(EXTRA_DETAIL_VALUES);
        LayoutPreference r5 = (LayoutPreference) NullSafe.nonNull(findPreference(KEY_TWO_BUTTONS));
        this.mForceStopButton = (OButton) NullSafe.nonNull(r5.findViewById(R.id.left_button));
        this.mReportButton = (OButton) NullSafe.nonNull(r5.findViewById(R.id.right_button));
        this.mForceStopButton.setEnabled(false);
        if (this.mUid < 10000) goto L34;
        this.mForceStopButton.setText(R.string.force_stop);
        this.mForceStopButton.setTag(7);
        this.mForceStopButton.setOnClickListener(this);
        this.mReportButton.setText(android.R.string.status_bar_battery);
        this.mReportButton.setTag(8);
        this.mReportButton.setOnClickListener(this);
        String[] r6 = this.mPackages;
        if (r6 != null) goto L13;
    L16:
        OLog.d(TAG, "No packages!!");
    L18:
        if (Settings.Global.getInt(r1.getContentResolver(), LibUtil.KEY_ENABLE_BUG_REPORT, 0) == 0) goto L27;
        ApplicationInfo r7 = this.mApp;
        if (r7 == null) goto L22;
        this.mInstaller = ApplicationErrorReport.getErrorReportReceiver(r1, this.mPackages[0], r7.flags);
    L22:
        OButton r8 = this.mReportButton;
        if (this.mInstaller != null) goto L26;
        r4 = false;
    L26:
        r8.setEnabled(r4);
    L29:
        if (this.mApp != null) goto L31;
    L33:
        this.mControlsParent.removePreference(findPreference(KEY_HIGH_POWER));
    L35:
        refreshStats();
        fillDetailsSection();
        fillPackagesSection(this.mUid);
        fillControlsSection(this.mUid);
        fillMessagesSection(this.mUid);
        return;
    L31:
        if (PowerWhitelistBackend.getInstance().isWhitelisted(this.mApp.packageName) == false) goto L33;
        Preference r9 = findPreference(KEY_HIGH_POWER);
        this.mHighPower = r9;
        r9.setOnPreferenceClickListener(new AnonymousClass1(this));
        goto L35
    L27:
        removePreference(KEY_TWO_BUTTONS);
        goto L29
    L13:
        if (r6.length <= 0) goto L16;
        this.mApp = r1.getPackageManager().getApplicationInfo(this.mPackages[0], 0);     // Catch: PackageManager.NameNotFoundException -> L37
        goto L18
    L34:
        removePreference(KEY_TWO_BUTTONS);
        this.mControlsParent.removePreference(findPreference(KEY_HIGH_POWER));
        goto L35
    }

    private void setupHeader() {
        Bundle r0 = getArguments();
        String r4 = r0.getString("title");
        String r1 = r0.getString(EXTRA_ICON_PACKAGE);
        int r2 = r0.getInt(EXTRA_ICON_ID, 0);
        PackageManager r3 = getActivity().getPackageManager();
        Drawable r6 = null;
        int r7 = -1;
        if (TextUtils.isEmpty(r1) == false) goto L26;
        if (r2 == 0) goto L13;
        r6 = getActivity().getDrawable(r2);
    L13:
        if (r6 != null) goto L15;
        Drawable r5 = getActivity().getPackageManager().getDefaultActivityIcon();
    L16:
        if (r1 != null) goto L20;
        String[] r8 = this.mPackages;
        if (r8 == null) goto L20;
        r1 = r8[0];
    L20:
        Drawable r9 = r5;
        AppHeader.createAppHeader(this, r9, r4, r1, r7, 0);
        return;
    L15:
        r5 = r6;
        goto L16
    L26:
        PackageInfo r10 = r3.getPackageInfo(r1, 0);     // Catch: PackageManager.NameNotFoundException -> L23
        if (r10 == null) goto L13;
        ApplicationInfo r11 = r10.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L23
        if (r11 == null) goto L13;
        Drawable r12 = r11.loadIcon(r3);     // Catch: PackageManager.NameNotFoundException -> L23
        r7 = r11.uid;     // Catch: PackageManager.NameNotFoundException -> L22
    L10:
        r6 = r12;
        goto L13
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        doAction(((Integer) r1.getTag()).intValue());
    }

    private void startApplicationDetailsActivity() {
        Bundle r2 = new Bundle();
        r2.putString("package", this.mPackages[0]);
        Fragment r7 = (Fragment) null;
        ((SettingsActivity) getActivity()).startPreferencePanel(InstalledAppDetails.class.getName(), r2, R.string.application_info_label, null, null, 0);
    }

    private void fillDetailsSection() {
        if (this.mTypes != null) goto L5;
        return;
    L5:
        if (this.mValues == null) goto L26;
        int r1 = 0;
    L7:
        int[] r2 = this.mTypes;
        if (r1 >= r2.length) goto L27;
        if (this.mValues[r1] <= 0.0d) goto L21;
        String r3 = getString(r2[r1]);
        switch(this.mTypes[r1]) {
            case 2131959494: goto L18;
            case 2131959497: goto L18;
            case 2131959500: goto L17;
            case 2131959501: goto L17;
            case 2131959502: goto L17;
            case 2131959503: goto L17;
            case 2131959505: goto L16;
            case 2131959506: goto L15;
            case 2131959511: goto L18;
            default: goto L19;
        };
    L15:
        String r4 = com.android.settings.Utils.formatPercentage((int) Math.floor(this.mValues[r1]));
    L20:
        addHorizontalPreference(this.mDetailsParent, r3, r4);
        goto L21
    L16:
        this.mUsesGps = true;
        goto L19
    L17:
        r4 = Long.toString((long) this.mValues[r1]);
        goto L20
    L18:
        r4 = getActivity().getString(R.string.mah, new Object[]{Long.valueOf((long) this.mValues[r1])});
    L19:
        r4 = com.android.settings.Utils.formatElapsedTime(getActivity(), this.mValues[r1], true);
    L21:
        r1 = r1 + 1;
        goto L7
    L27:
        return;
    }

    private void addHorizontalPreference(PreferenceCategory r2, CharSequence r3, CharSequence r4) {
        Preference r0 = new Preference(getPrefContext());
        r0.setLayoutResource(R.layout.horizontal_preference);
        r0.setTitle(r3);
        r0.setSummary(r4);
        r0.setSelectable(false);
        r2.addPreference(r0);
    }

    private void fillControlsSection(int r4) {
        PackageManager r0 = (PackageManager) NullSafe.nonNull(getActivity().getPackageManager());
        String[] r5 = r0.getPackagesForUid(r4);
        if (r5 != null) goto L13;
    L7:
        PackageInfo r6 = null;
    L8:
        if (r6 == null) goto L10;
        ApplicationInfo r7 = r6.applicationInfo;
    L10:
        this.mControlsParent.setTitle(null);
        return;
    L13:
        r6 = r0.getPackageInfo(r5[0], 0);     // Catch: PackageManager.NameNotFoundException -> L12
        goto L8
    }

    private void addControl(int r2, int r3, final int r4) {
        Preference r5 = new Preference(getPrefContext());
        r5.setTitle(r3);
        r5.setLayoutResource(R.layout.horizontal_preference);
        r5.setOnPreferenceClickListener(new AnonymousClass2(this, r4));
        this.mControlsParent.addPreference(r5);
    }

    private void fillMessagesSection(int r1) {
        this.mMessagesParent.setTitle(null);
    }

    private void addMessage(int r3) {
        addHorizontalPreference(this.mMessagesParent, getString(r3), null);
    }

    private void removePackagesSection() {
        getPreferenceScreen().removePreference(this.mPackagesParent);
    }

    private void killProcesses() {
        if (this.mPackages != null) goto L5;
        return;
    L5:
        ActivityManager r0 = (ActivityManager) getActivity().getSystemService("activity");
        int r1 = UserHandle.getUserId(this.mUid);
        int r2 = 0;
    L6:
        String[] r3 = this.mPackages;
        if (r2 >= r3.length) goto L9;
        r0.forceStopPackageAsUser(r3[r2], r1);
        r2 = r2 + 1;
        goto L6
    L9:
        checkForceStop();
    }

    private void checkForceStop() {
        if (this.mPackages != null) goto L5;
    L27:
        this.mForceStopButton.setEnabled(false);
        return;
    L5:
        if (this.mUid < 10000) goto L27;
        int r0 = 0;
    L8:
        String[] r2 = this.mPackages;
        if (r0 >= r2.length) goto L15;
        if (this.mDpm.packageHasActiveAdmins(r2[r0]) == true) goto L12;
        r0 = r0 + 1;
        goto L8
    L12:
        this.mForceStopButton.setEnabled(false);
        return;
    L15:
        int r1 = 0;
    L16:
        String[] r3 = this.mPackages;
        if (r1 >= r3.length) goto L23;
        if ((this.mPm.getApplicationInfo(r3[r1], 0).flags & 2097152) != 0) goto L22;
        this.mForceStopButton.setEnabled(true);     // Catch: PackageManager.NameNotFoundException -> L29
    L22:
        r1 = r1 + 1;
    L23:
        Intent r4 = new Intent("android.intent.action.QUERY_PACKAGE_RESTART", Uri.fromParts("package", this.mPackages[0], null));
        r4.putExtra("android.intent.extra.PACKAGES", this.mPackages);
        r4.putExtra("android.intent.extra.UID", this.mUid);
        r4.putExtra("android.intent.extra.user_handle", UserHandle.getUserId(this.mUid));
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L37;
        r5.sendOrderedBroadcast(r4, null, this.mCheckKillProcessesReceiver, null, 0, null, null);
        return;
    }

    private void reportBatteryUse() {
        if (this.mPackages != null) goto L5;
        return;
    L5:
        ApplicationErrorReport r0 = new ApplicationErrorReport();
        r0.type = 3;
        boolean r2 = false;
        r0.packageName = this.mPackages[0];
        r0.installerPackageName = this.mInstaller.getPackageName();
        r0.processName = this.mPackages[0];
        r0.time = System.currentTimeMillis();
        if ((this.mApp.flags & 1) == 0) goto L8;
        r2 = true;
    L8:
        r0.systemApp = r2;
        Bundle r1 = getArguments();
        ApplicationErrorReport.BatteryInfo r3 = new ApplicationErrorReport.BatteryInfo();
        r3.usagePercent = r1.getInt(EXTRA_PERCENT, 1);
        r3.durationMicros = r1.getLong("duration", 0);
        r3.usageDetails = r1.getString(EXTRA_REPORT_DETAILS);
        r3.checkinDetails = r1.getString(EXTRA_REPORT_CHECKIN_DETAILS);
        r0.batteryInfo = r3;
        Intent r4 = new Intent("android.intent.action.APP_ERROR");
        r4.setComponent(this.mInstaller);
        r4.putExtra(LibUtil.PARCELABLE_EXTRA, r0);
        r4.addFlags(268435456);
        startActivity(r4);
    }

    private void fillPackagesSection(int r6) {
        if (r6 >= 1) goto L6;
        removePackagesSection();
        return;
    L6:
        String[] r7 = this.mPackages;
        if (r7 != null) goto L9;
    L20:
        removePackagesSection();
        return;
    L9:
        if (r7.length < 2) goto L20;
        PackageManager r8 = getPackageManager();
        int r1 = 0;
    L12:
        String[] r2 = this.mPackages;
        if (r1 >= r2.length) goto L19;
        CharSequence r3 = r8.getApplicationInfo(r2[r1], 0).loadLabel(r8);     // Catch: PackageManager.NameNotFoundException -> L22
        if (r3 == null) goto L17;
        this.mPackages[r1] = r3.toString();     // Catch: PackageManager.NameNotFoundException -> L22
    L17:
        addHorizontalPreference(this.mPackagesParent, this.mPackages[r1], null);     // Catch: PackageManager.NameNotFoundException -> L22
    L18:
        r1 = r1 + 1;
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_PowerUsageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PowerUsageDetail r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_PowerUsageDetail__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_PowerUsageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PowerUsageDetail r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_PowerUsageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_PowerUsageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PowerUsageDetail r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_PowerUsageDetail__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
