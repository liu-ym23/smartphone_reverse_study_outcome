package com.android.settings;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import bytedanceos.util.DeviceType;
import bytedanceos.util.Features;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.deviceinfo.Status;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.FeedbackLauncher;

/* JADX INFO: loaded from: classes2.dex */
public class AboutFragment extends BaseFragment implements View.OnClickListener {
    static final String CPU_7450 = "Qualcomm® Snapdragon™ 7 Gen 1";
    static final String CPU_855PLUS = "Qualcomm® Snapdragon™ 855 Plus";
    static final String CPU_865 = "Qualcomm® Snapdragon™ 865";
    private static final String FILENAME_MSV = "/sys/board_properties/soc/msv";
    private static final String FILENAME_PROC_CPUINFO = "/proc/cpuinfo";
    private static final String FILENAME_PROC_MEMINFO = "/proc/meminfo";
    private static final String FILENAME_PROC_VERSION = "/proc/version";
    public static final String PREF_FILE = "development";
    public static final String PREF_SHOW = "show";
    private static final int REQUEST_CONFIRM_PWD_CODE = 1;
    static final int TAPS_TO_BE_A_DEVELOPER = 7;
    private static boolean mShowFakeInfo;
    private int count;
    private long lastClickTime;
    private ScrollView mAboutContainer;
    int mDevHitCountdown;
    OToast mDevHitToast;
    private OListItemSettings mDeviceName;
    private OListItemSettings mDeviceStatus;
    private OListItemSettings mLawInfo;
    private ImageView mLogoView;
    private TextView mOSVersionOnLogo;
    private int mTitleStringResId;
    private OListItemSettings mUserFeedback;
    private AboutStaticItem mViewBasebandVersion;
    private AboutStaticItem mViewBuildDate;
    private AboutStaticItem mViewDeviceCpu;
    private AboutStaticItem mViewDeviceMemory;
    private AboutStaticItem mViewDeviceModel;
    private ViewStub mViewDeviceVersionVS;
    private AboutStaticItem mViewFirmwareVersion;
    private ViewStub mViewHarewareVersionVS;
    private AboutStaticItem mViewKernelVersion;
    private AboutStaticItem mViewModVersion;
    private ViewStub mViewSpecialVersionVS;
    private OListItemSettings mWarranty;
    private PreferenceMgr prefMgr;

    private static final class FakeInfo {
        static final String ANDROID_VERSION = "7.1.1";
        static final String BASEBAND_VERSION = "MPSS.TA.2.3.c1-00167-8953_GEN_PACK-1.100667.1.104080.1";
        static final String CPU = "Qualcomm Technologies, Inc MSM8953Pro";
        static final String KERNEL_VERSION = "3.18.31-ge7912c3\nsmartcm@hardcomp2 #1\nTue Jun 27 07:32:14 CST 2017";
        static final String MEMORY = "4 GB";

        private FakeInfo() {
        }
    }

    public void com_android_settings_AboutFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_AboutFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_AboutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_AboutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AboutFragment() {
        super(R.layout.about_settings_layout);
        this.mDevHitCountdown = 7;
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r3, Bundle r4) {
        super.initViews(r3, r4);
        this.prefMgr = PreferenceMgr.getInstance(this.mContext);
        mShowFakeInfo = false;
        this.mTitleStringResId = R.string.about_settings;
        this.mAboutContainer = (ScrollView) findViewByIdNullable(R.id.page_scrollview);
        OListItemSettings r5 = (OListItemSettings) findViewByIdNullable(R.id.item_device_status);
        this.mDeviceStatus = r5;
        r5.setOnClickListener(this);
        OListItemSettings r6 = (OListItemSettings) findViewByIdNullable(R.id.item_device_name);
        this.mDeviceName = r6;
        r6.setImageView(this.mContext.getDrawable(R.drawable.o_icon_down));
        this.mDeviceName.setTrailingText(Utils.getDeviceName(this.mContext));
        this.mDeviceName.setOnClickListener(this);
        OListItemSettings r7 = (OListItemSettings) findViewByIdNullable(R.id.item_law_info);
        this.mLawInfo = r7;
        r7.setOnClickListener(this);
        OListItemSettings r8 = (OListItemSettings) findViewByIdNullable(R.id.item_warranty);
        this.mWarranty = r8;
        r8.setOnClickListener(this);
        OListItemSettings r9 = (OListItemSettings) findViewByIdNullable(R.id.item_user_feedback);
        this.mUserFeedback = r9;
        r9.setOnClickListener(this);
        String r10 = Utils.getPackageString(this.mContext, Constants.PKG_BUG2GO, "user_feedback");
        this.mUserFeedback.setTitleString(r10);
        this.mWarranty.setVisibility(8);
        this.mViewDeviceModel = (AboutStaticItem) findViewByIdNullable(R.id.device_model);
        this.mViewFirmwareVersion = (AboutStaticItem) findViewByIdNullable(R.id.firmware_version);
        this.mViewBasebandVersion = (AboutStaticItem) findViewByIdNullable(R.id.baseband_version);
        this.mViewKernelVersion = (AboutStaticItem) findViewByIdNullable(R.id.kernel_version);
        this.mViewDeviceCpu = (AboutStaticItem) findViewByIdNullable(R.id.device_cpu);
        this.mViewDeviceMemory = (AboutStaticItem) findViewByIdNullable(R.id.device_memory);
        this.mViewHarewareVersionVS = (ViewStub) findViewByIdNullable(R.id.hw_version_vs);
        AboutStaticItem r11 = (AboutStaticItem) findViewByIdNullable(R.id.mod_version);
        this.mViewModVersion = r11;
        r11.setOnClickListener(this);
        this.mViewBuildDate = (AboutStaticItem) findViewByIdNullable(R.id.build_date);
        this.mViewSpecialVersionVS = (ViewStub) findViewByIdNullable(R.id.special_version_vs);
        if (Features.isFeatureCMCCEnabled(this.mContext).booleanValue() == false) goto L5;
        AboutStaticItem r12 = (AboutStaticItem) this.mViewSpecialVersionVS.inflate();
        r12.setTitle(R.string.special_version);
        r12.setSummary(R.string.cmcc_version);
    L5:
        ViewStub r13 = (ViewStub) findViewByIdNullable(R.id.device_version_vs);
        this.mViewDeviceVersionVS = r13;
        AboutStaticItem r14 = (AboutStaticItem) r13.inflate();
        r14.setTitle(R.string.storage_capacity);
        r14.setSummary(Utils.getStorageVersion());
        if (isNeedShowHardwareVersion() == false) goto L8;
        AboutStaticItem r15 = (AboutStaticItem) this.mViewHarewareVersionVS.inflate();
        r15.setTitle(R.string.hardware_version_title);
        r15.setSummary(getHardwareVersion());
    L8:
        ImageView r16 = (ImageView) findViewByIdNullable(R.id.about_logo);
        this.mLogoView = r16;
        r16.setOnClickListener(this);
        if (this.mIsExtDisplaying == false) goto L11;
        this.mAboutContainer.setVerticalScrollBarEnabled(false);
        this.mOSVersionOnLogo = (TextView) findViewByIdNullable(R.id.about_logo_os_vertion_land);
    L12:
        this.mOSVersionOnLogo.setVisibility(0);
        return;
    L11:
        this.mOSVersionOnLogo = (TextView) findViewByIdNullable(R.id.about_logo_os_vertion);
        goto L12
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        if (getSharedPreferences("development", 0).getBoolean("show", false) == false) goto L5;
        int r0 = -1;
    L6:
        this.mDevHitCountdown = r0;
        this.mDevHitToast = null;
        this.mViewDeviceModel.setSummary(Build.MODEL + getMsvSuffix());
        this.mViewFirmwareVersion.setSummary(Build.VERSION.RELEASE);
        this.mViewBasebandVersion.setSummary(getBasebandSummary(LibUtil.SYS_PROPERTY_TAG_CP_VERSION));
        this.mViewKernelVersion.setSummary(getFormattedKernelVersion());
        if (DeviceType.is(DeviceType.DELTA) == false) goto L10;
        String r1 = CPU_855PLUS;
    L16:
        String r2 = (((getMemInfoKBSize() / 1024) / 1024) + 1) + " GB";
        if (r1 == null) goto L19;
        this.mViewDeviceCpu.setSummary(r1);
    L19:
        if (r2 == null) goto L21;
        this.mViewDeviceMemory.setSummary(r2);
    L21:
        String r3 = getShortBytedanceOSVersion();
        AboutStaticItem r4 = this.mViewModVersion;
        if (showRightModVersion() == false) goto L24;
        String r5 = getValueSummary("ro.os.ota.version");
    L25:
        r4.setSummary(r5);
        this.mOSVersionOnLogo.setText(r3);
        this.mViewBuildDate.setSummary(getValueSummary(LibUtil.SYS_PROPERTY_TAG_BUILD_VERSION));
        if (mShowFakeInfo == false) goto L29;
        this.mViewFirmwareVersion.setSummary("7.1.1");
        this.mViewBasebandVersion.setSummary("MPSS.TA.2.3.c1-00167-8953_GEN_PACK-1.100667.1.104080.1");
        this.mViewKernelVersion.setSummary("3.18.31-ge7912c3\nsmartcm@hardcomp2 #1\nTue Jun 27 07:32:14 CST 2017");
        this.mViewDeviceCpu.setSummary("Qualcomm Technologies, Inc MSM8953Pro");
        this.mViewDeviceMemory.setSummary("4 GB");
        return;
    L29:
        return;
    L24:
        r5 = r3;
        goto L25
    L10:
        if (DeviceType.is(DeviceType.DARWIN) == false) goto L13;
        r1 = CPU_865;
        goto L16
    L13:
        if (getValueSummary("ro.soc.model").equals("SM7450") == false) goto L15;
        r1 = CPU_7450;
        goto L16
    L15:
        OLog.d(this.TAG, "CPU ro.soc.model info is" + getValueSummary("ro.soc.model"));
        r1 = getDeviceProcessorInfo();
        goto L16
    L5:
        r0 = 7;
        goto L6
    }

    private String getShortBytedanceOSVersion() {
        String r3 = getValueSummary("ro.os.ota.version");
        if (r3 == null) goto L9;
        String[] r0 = r3.split("-");
        if (r0 == null) goto L9;
        if (r0.length <= 0) goto L9;
        StringBuilder r1 = new StringBuilder("v").append(r0[0]);
    L10:
        if (r1 != null) goto L12;
        return r3;
    L12:
        return r1.toString();
    L9:
        r1 = null;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (this.mDeviceStatus != r8) goto L10;
        Intent r9 = new Intent();     // Catch: Exception -> L6
        r9.setAction("android.intent.action.MAIN");     // Catch: Exception -> L6
        r9.setClass(this._mActivity, Status.class);     // Catch: Exception -> L6
        r9.putExtra("back_text_id", this.mTitleStringResId);     // Catch: Exception -> L6
        Utils.startActivity(this._mActivity, r9);     // Catch: Exception -> L6
    L8:
        SettingsTracker.onItemClick(2901);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        if (this.mDeviceName != r8) goto L16;
        if (Utils.isFastDoubleClick() == false) goto L14;
        return;
    L14:
        new DeviceNameDialogWrapper(this._mActivity).setDeviceName(Utils.getDeviceName(this.mContext)).setListItem(this.mDeviceName).show();
        SettingsTracker.onItemClick(2903);
        return;
    L16:
        if (this.mLawInfo != r8) goto L19;
        Utils.startActivity(this._mActivity, new Intent(this.mContext, LawInfoActivity.class));
        SettingsTracker.onItemClick(2904);
        return;
    L19:
        if (this.mWarranty != r8) goto L22;
        Intent r10 = new Intent();
        r10.setAction("android.intent.action.MAIN");
        r10.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.support.SupportActivity");
        r10.putExtra("bytedance_origin_app_tag", "settings");
        r10.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        Utils.startActivity(this._mActivity, r10);
        SettingsTracker.onItemClick(2905);
        return;
    L22:
        if (R.id.about_logo != r8.getId()) goto L34;
        if (showRightModVersion() == false) goto L26;
        return;
    L26:
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastClickTime) < 300) goto L29;
        this.count = 1;
    L30:
        this.lastClickTime = r0;
        if (this.count != 15) goto L73;
        setShowRightModVersion(true);
        return;
    L73:
        return;
    L29:
        this.count++;
        goto L30
    L34:
        if (this.mViewModVersion != r8) goto L62;
        if (UserHandle.myUserId() == 0) goto L38;
        return;
    L38:
        int r11 = this.mDevHitCountdown;
        if (r11 <= 0) goto L56;
        int r12 = r11 - 1;
        this.mDevHitCountdown = r12;
        if (r12 != 0) goto L49;
        OToast r13 = this.mDevHitToast;
        if (r13 == null) goto L46;
        r13.cancel();
    L46:
        if (new LockPatternUtils(this.mContext).isSecure(UserHandle.myUserId()) == false) goto L48;
        new ChooseLockSettingsHelper(getActivity(), this).launchConfirmationActivity(1, null, 2, true);
        return;
    L48:
        enableDevelopSettings();
        return;
    L49:
        if (r12 > 0) goto L51;
        return;
    L51:
        if (r12 >= 5) goto L78;
        OToast r14 = this.mDevHitToast;
        if (r14 == null) goto L55;
        r14.cancel();
    L55:
        Resources r15 = getResources();
        int r1 = this.mDevHitCountdown;
        this.mDevHitToast = ToastUtils.show(this._mActivity, r15.getQuantityString(R.plurals.show_dev_countdown, r1, new Object[]{Integer.valueOf(r1)}));
        return;
    L78:
        return;
    L56:
        if (r11 >= 0) goto L80;
        OToast r16 = this.mDevHitToast;
        if (r16 == null) goto L60;
        r16.cancel();
    L60:
        this.mDevHitToast = ToastUtils.show(this._mActivity, getResources().getString(R.string.show_dev_already));
        return;
    L80:
        return;
    L62:
        if (this.mUserFeedback != r8) goto L82;
        Bundle r17 = new Bundle();
        r17.putInt("activity", 0);
        r17.putBoolean("start_from_setting", true);
        if (FeedbackLauncher.startFeedback(this.mContext, r17) == true) goto L83;
        showBugReportDialog();
        return;
    L83:
        return;
    }

    private void showBugReportDialog() {
        new AlertDialog.Builder(getActivity()).setTitle(R.string.about_user_feedback).setMessage(android.R.string.carrier_app_notification_title).setPositiveButton(android.R.string.status_bar_battery, new AnonymousClass1(this)).setNegativeButton(R.string.cancel, null).create().show();
    }

    private void enableDevelopSettings() {
        getSharedPreferences("development", 0).edit().putBoolean("show", true).apply();
        DatabaseHelper.getInstance(this.mContext).updateDevelopmentSettingsSearchable(true);
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "development_settings_enabled", 1);
        String r0 = getResources().getString(R.string.show_dev_on);
        this.mDevHitToast = ToastUtils.showLeftIcon(this._mActivity, r0, R.drawable.settings_oic_checkmark_checked);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 1) goto L5;
        return;
    L5:
        if (r2 != RESULT_OK) goto L9;
        enableDevelopSettings();
        return;
    }

    private void setShowRightModVersion(boolean r3) {
        this.prefMgr.putBoolean("show_right_mod_version", r3);
        AboutStaticItem r0 = this.mViewModVersion;
        if (r3 == false) goto L5;
        String r2 = getValueSummary("ro.os.ota.version");
    L6:
        r0.setSummary(r2);
        return;
    L5:
        r2 = getShortBytedanceOSVersion();
        goto L6
    }

    private boolean showRightModVersion() {
        return this.prefMgr.getBoolean("show_right_mod_version", false);
    }

    private String getValueSummary(String r2) {
        return SystemProperties.get(r2, getResources().getString(R.string.device_info_default));
    L4:
        return null;
    }

    private String getBasebandSummary(String r2) {
        String r3 = MultiSDKAdapter.getBasebandInfo(TelephonyManager.from(this.mContext), r2);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        return r3;
    L5:
        return getResources().getString(R.string.device_info_default);
    }

    private static String readLine(String r2) throws IOException {
        BufferedReader r0 = new BufferedReader(new FileReader(r2), 256);
        String r3 = r0.readLine();     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    private String getFormattedKernelVersion() {
        String r4 = readLine(FILENAME_PROC_VERSION);     // Catch: IOException -> L16
        if (r4 != null) goto L6;
        return "Unavailable";
    L6:
        Matcher r5 = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+@[^\\s@]+)\\)+\\s+\\(Android \\([^\\)]+\\) clang version [^\\s]+ \\(https://android\\.googlesource\\.com/toolchain/llvm-project [a-f0-9]+\\), LLD [^\\s]+ \\(/buildbot/src/android/llvm-toolchain/out/llvm-project/lld [a-f0-9]+\\)\\) ([^\\s]+)\\s+SMP PREEMPT (.+)").matcher(r4);     // Catch: IOException -> L16
        if (r5.matches() == true) goto L11;
        OLog.e(this.TAG, "Regex did not match on /proc/version: " + r4);     // Catch: IOException -> L16
        return "Unavailable";
    L11:
        if (r5.groupCount() >= 4) goto L15;
        OLog.e(this.TAG, "Regex match on /proc/version only returned " + r5.groupCount() + " groups");     // Catch: IOException -> L16
        return "Unavailable";
    L15:
        return r5.group(1) + "\n" + r5.group(2) + HanziToPinyin.Token.SEPARATOR + r5.group(3) + "\n" + r5.group(4);
    L16:
        e = move-exception;
        OLog.e(this.TAG, "IO Exception when getting kernel version for Device Info screen", e);
        return "Unavailable";
    }

    public static String getMsvSuffix() {
        String r0 = readLine(FILENAME_MSV);     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        if (Long.parseLong(r0, 16) != 0) goto L13;
        return " (ENGINEERING)";
    L13:
        return "";
    L8:
        return "";
    L14:
        return "";
    }

    private String getMemInfo() {
        return (getMemInfoKBSize() / 1024) + " MB";
    }

    private long getMemInfoKBSize() {
        String r4 = readLine("/proc/meminfo");     // Catch: IOException -> L9
        if (r4 == null) goto L14;
        String[] r5 = r4.split("\\s+");     // Catch: IOException -> L9
        if (r5.length != 3) goto L15;
        return Long.parseLong(r5[1]);
    L15:
        return 0;
    L14:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private String getDeviceProcessorInfo() {
        BufferedReader r1 = new BufferedReader(new FileReader(FILENAME_PROC_CPUINFO));     // Catch: IOException -> L19
    L23:
        String r2 = r1.readLine();     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r2.startsWith("Hardware") == false) goto L23;
        Matcher r3 = Pattern.compile("Hardware\\s*:\\s*(.*)$").matcher(r2);     // Catch: Throwable -> L16
        if (r3.matches() == false) goto L23;
        String r4 = r3.group(1);     // Catch: Throwable -> L16
        r1.close();     // Catch: IOException -> L19
        return r4;
    L13:
        String r5 = getString(R.string.device_info_default);     // Catch: Throwable -> L16
        r1.close();     // Catch: IOException -> L19
        return r5;
    L16:
        th = move-exception;
        r1.close();     // Catch: IOException -> L19
        throw th;     // Catch: IOException -> L19
    L19:
        e = move-exception;
        OLog.e(this.TAG, "IO Exception when getting cpuinfo for Device Info screen", e);
        return getString(R.string.device_info_default);
    }

    private boolean isNeedShowHardwareVersion() {
        return Features.isFeatureCMCCEnabled(this.mContext).booleanValue();
    }

    private String getHardwareVersion() {
        String r2 = SystemProperties.get("ro.product.hw.version", "");
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        String r3 = Build.MODEL;
        if (TextUtils.equals(r3, "OD101") == false) goto L9;
        return "MMR500030";
    L9:
        if (TextUtils.equals(r3, "OD103") == false) goto L12;
        return "MMR500030";
    L12:
        if (TextUtils.equals(r3, "OD105") == false) goto L15;
        return "MMR500032";
    L15:
        if (TextUtils.equals(r3, "OS105") == false) goto L17;
        return "MMR500040";
    L17:
        return "XXXXXXX";
    }

    private void startByActivityStackView(Intent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.setFlags(268468224);
        start(EmptyFragment.class);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AboutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AboutFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AboutFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AboutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AboutFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_AboutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AboutFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AboutFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AboutFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
