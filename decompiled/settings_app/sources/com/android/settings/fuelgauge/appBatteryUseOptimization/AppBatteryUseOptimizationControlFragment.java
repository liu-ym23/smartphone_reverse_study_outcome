package com.android.settings.fuelgauge.appBatteryUseOptimization;

import android.app.AlertDialog;
import android.app.SmtOpsManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.NetworkPolicyManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IDeviceIdleController;
import android.os.IPowerAdvisor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bytedanceos.api.SmtOpsManagerSmt;
import com.android.settings.Constants;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.InstalledAppDetails;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse.BatteryPowerViewModel;
import com.android.settings.fuelgauge.appBatteryUseOptimization.highpower.HighPowerAppManager;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppBatteryUseOptimizationControlFragment extends BaseFragment {
    private static final String AUTHORITY = "com.bytedanceos.security.dynamicResolution";
    private static final String COLUMN_ENABLE = "enable";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_INSTALL = "installed";
    private static final String COLUMN_PACKAGE_NAME = "packageName";
    private static final String COLUMN_SM_VERSION = "smversion";
    private static final Uri CONTENT_ID_URI_BASE = null;
    private static final Uri CONTENT_URI = null;
    private static final String DEVICE_IDLE_SERVICE = "deviceidle";
    private static final int DISABLED = 0;
    private static final int ENABLED = 1;
    private static int POLICY_NONE;
    private static int POLICY_REJECT_BACKGROUND;
    private static int SCREEN_OFF;
    private OCardListItem allowBgPowerHigh;
    Observer<Float> batteryPowerObserver;
    private BatteryPowerViewModel batteryPowerViewModel;
    private ApplicationInfo info;
    private boolean isInitAllowBgPowerHigh;
    private boolean isSystemApp;
    private boolean mAllowApp;
    OCardListItem mAllowNetBgText;
    private boolean mAllowSystem;
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    OCardListItem mControl;
    private IDeviceIdleController mDeviceIdleService;
    private int mEnable;
    private AlertDialog mEnableDialog;
    private String mGameVersion;
    private int mId;
    private boolean mIsGameApp;
    private NetworkPolicyManager mNpm;
    private int[] mOpsApp;
    private int[] mOpsSystem;
    private PackageManager mPM;
    private String mPackageName;
    private OPopover mPopover;
    SmtOpsManager mSmtOpsManager;
    OCardListItem mStartBySys;
    OCardListItem mStartByThird;
    private int mUid;
    private OCardListItem percentItem;

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppBatteryUseOptimizationControlFragment() {
        this.mId = -1;
        this.mOpsSystem = new int[]{21};
        this.mOpsApp = new int[]{28};
        this.mSmtOpsManager = null;
        this.mIsGameApp = false;
        this.mGameVersion = "";
        this.isInitAllowBgPowerHigh = false;
        this.isSystemApp = false;
        this.batteryPowerObserver = new AnonymousClass3(this);
        this.mCheckedChangeListener = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(AppBatteryUseOptimizationControlFragment r0) {
        r0.showPopover();
    }

    static /* synthetic */ Uri access$100() {
        return CONTENT_URI;
    }

    static /* synthetic */ void access$1000(AppBatteryUseOptimizationControlFragment r0, int r1) {
        r0.updateDynamicResolution(r1);
    }

    static /* synthetic */ AlertDialog access$1102(AppBatteryUseOptimizationControlFragment r0, AlertDialog r1) {
        r0.mEnableDialog = r1;
        return r1;
    }

    static /* synthetic */ String access$200(AppBatteryUseOptimizationControlFragment r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ int access$300(AppBatteryUseOptimizationControlFragment r0) {
        return r0.mId;
    }

    static /* synthetic */ int access$302(AppBatteryUseOptimizationControlFragment r0, int r1) {
        r0.mId = r1;
        return r1;
    }

    static /* synthetic */ int access$400(AppBatteryUseOptimizationControlFragment r0) {
        return r0.mEnable;
    }

    static /* synthetic */ int access$402(AppBatteryUseOptimizationControlFragment r0, int r1) {
        r0.mEnable = r1;
        return r1;
    }

    static /* synthetic */ String access$502(AppBatteryUseOptimizationControlFragment r0, String r1) {
        r0.mGameVersion = r1;
        return r1;
    }

    static /* synthetic */ int[] access$600(AppBatteryUseOptimizationControlFragment r0) {
        return r0.mOpsSystem;
    }

    static /* synthetic */ int access$700(AppBatteryUseOptimizationControlFragment r0) {
        return r0.mUid;
    }

    static /* synthetic */ int[] access$800(AppBatteryUseOptimizationControlFragment r0) {
        return r0.mOpsApp;
    }

    static /* synthetic */ Uri access$900() {
        return CONTENT_ID_URI_BASE;
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution/");
        POLICY_NONE = 0;
        POLICY_REJECT_BACKGROUND = 1;
        SCREEN_OFF = 2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r0 = 0;
        this.mRootView = r2.inflate(R.layout.app_battery_use_optimization_control_activity, r3, false);
        PackageManager r5 = getPackageManager();
        this.mPM = r5;
        if (r5 != null) goto L6;
        finish();
        return this.mRootView;
    L6:
        this.mNpm = NetworkPolicyManager.from(this.mContext);
        this.mDeviceIdleService = IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE));
        Bundle r6 = getArguments();
        this.mPackageName = r6.getString("package_name");
        this.mUid = r6.getInt("application_uid", 0);
        if ("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS".equals(this._mActivity.getIntent().getAction()) == false) goto L10;
        this.mPackageName = this._mActivity.getIntent().getData().getSchemeSpecificPart();
    L10:
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L13;
        finish();
        return this.mRootView;
    L13:
        SmtOpsManager r7 = (SmtOpsManager) getSystemService(MultiSDKAdapterNew.getSmtOpsService());
        this.mSmtOpsManager = r7;
        if (r7 != null) goto L17;
        finish();
        return this.mRootView;
    L17:
        this.mStartBySys = (OCardListItem) findViewByIdNullable(R.id.switch_start_by_sys);
        this.mStartByThird = (OCardListItem) findViewByIdNullable(R.id.switch_start_by_third);
        this.mControl = (OCardListItem) findViewByIdNullable(R.id.switch_control_background_run);
        this.mAllowNetBgText = (OCardListItem) findViewByIdNullable(R.id.id_use_data_background);
        this.percentItem = (OCardListItem) findViewByIdNullable(R.id.percent);
        refreshPowerUsage(r6.getDoubleArray(InstalledAppDetails.POWER_USAGE), this.mPackageName);
        this.info = this.mPM.getApplicationInfo(this.mPackageName, 0);     // Catch: PackageManager.NameNotFoundException -> L31
    L19:
        ApplicationInfo r8 = this.info;
        if (r8 == null) goto L24;
        boolean r9 = true;
        if ((r8.flags & 1) == 0) goto L24;
    L25:
        this.isSystemApp = r9;
        OCardListItem r10 = this.mControl;
        if (this.mIsGameApp == true) goto L29;
        r0 = 8;
    L29:
        r10.setVisibility(r0);
        Utils.setAppLabelAndIconViews(this.mRootView, this.mPackageName, this.mUid);
        this.mAllowNetBgText.setOnContentClickListener(new AnonymousClass1(this));
        initOps();
        initAllowBgPowerHigh();
        return this.mRootView;
    L24:
        r9 = false;
        goto L25
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        UIUtils.fitMaskSmallTitle(this, (ScrollView) findViewByIdNullable(R.id.page_scrollview));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        OCardListItemUtils.setChecked(this.mStartBySys, this.mAllowSystem);
        OCardListItemUtils.setOnCheckedChangeListener(this.mStartBySys, this.mCheckedChangeListener);
        OCardListItemUtils.setChecked(this.mStartByThird, this.mAllowApp);
        OCardListItemUtils.setOnCheckedChangeListener(this.mStartByThird, this.mCheckedChangeListener);
        OCardListItemUtils.setOnCheckedChangeListener(this.allowBgPowerHigh, new AppBatteryUseOptimizationControlFragment$$ExternalSyntheticLambda1(this));
        OCardListItemUtils.setOnCheckedChangeListener(this.mControl, this.mCheckedChangeListener);
        updateViews();
    }

    /* JADX INFO: renamed from: lambda$onViewStateRestored$0$com-android-settings-fuelgauge-appBatteryUseOptimization-AppBatteryUseOptimizationControlFragment, reason: not valid java name */
    /* synthetic */ void m478x64bda6c2(CompoundButton r3, boolean r4) {
        sendBroadcast(new Intent("intent.highpower.manual.change").setPackage(Constants.PKG_SECURITY).putExtra("packageName", this.mPackageName));
        if (r4 == false) goto L5;
        HighPowerAppManager.Companion.addHighPowerApp(this.mPackageName);
        return;
    L5:
        HighPowerAppManager.Companion.removeHighPowerApp(this.mPackageName);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void showPopover() {
        if (this._mActivity != null) goto L6;
        return;
    L6:
        if (RiskPermissionControlGuard.intercept(this._mActivity, this.mPackageName, UserHandle.getUserId(this.mUid), 3) == false) goto L8;
        return;
    L8:
        int r0 = this.mNpm.getUidPolicy(this.mUid);
        if (r0 == 0) goto L11;
    L13:
        if (r0 != 0) goto L16;
        int r1 = POLICY_NONE;
    L19:
        ArrayList r2 = new ArrayList();
        String r3 = this._mActivity.getString(R.string.background_network_allow);
        boolean r5 = true;
        if (r1 != POLICY_NONE) goto L22;
        boolean r4 = true;
    L23:
        r2.add(new Item(r3, r4));
        String r6 = this._mActivity.getString(R.string.background_network_reject_screen_off);
        if (r1 == SCREEN_OFF) goto L27;
        r5 = false;
    L27:
        r2.add(new Item(r6, r5));
        this.mPopover = OPopoverHelper.showPopoverList(this._mActivity, this.mAllowNetBgText, r2, new AppBatteryUseOptimizationControlFragment$$ExternalSyntheticLambda0(this));
        return;
    L22:
        r4 = false;
        goto L23
    L16:
        if (r0 != 16) goto L18;
        r1 = POLICY_REJECT_BACKGROUND;
        goto L19
    L18:
        r1 = SCREEN_OFF;
        goto L19
    L11:
        if (isWhileListApp(this.mPackageName) == true) goto L13;
        r0 = 8;
        goto L13
    }

    /* JADX INFO: renamed from: lambda$showPopover$1$com-android-settings-fuelgauge-appBatteryUseOptimization-AppBatteryUseOptimizationControlFragment, reason: not valid java name */
    /* synthetic */ void m479x27af3368(View r1, int r2) {
        if (r2 != 0) goto L7;
        saveNetworkPolicyStatus(0);
        refreshNetUI();
        OPopover r3 = this.mPopover;
        if (r3 == null) goto L9;
        r3.dismiss();
    L9:
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L13;
        r0.dismiss();
        return;
    L13:
        return;
    L7:
        if (r2 != 1) goto L9;
        saveNetworkPolicyStatus(8);
        refreshNetUI();
        goto L9
    }

    private void initCard(OCardListItem r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.setCustomStartView(R.layout.o_card_list_item_custom_start_mark);
        r3.showCustomStart(true);
        r3.setCardType(0);
        View r0 = r3.findViewById(R.id.card_container);
        r3.findViewById(R.id.content_container).setPadding(0, 0, 0, 0);
        r0.setPadding(0, 0, 0, 0);
        r3.findViewById(R.id.title_container).setVisibility(0);
        r3.findViewById(R.id.title).setVisibility(0);
    }

    private void refreshNetUI() {
        if (this._mActivity != null) goto L5;
        return;
    L5:
        if (isAdded() == true) goto L8;
        return;
    L8:
        if (this.mAllowNetBgText == null) goto L27;
        int r0 = this.mNpm.getUidPolicy(this.mUid);
        if (r0 != 0) goto L15;
        if (isWhileListApp(this.mPackageName) == true) goto L15;
        r0 = 8;
    L15:
        if (isPermManagerEnable() == false) goto L17;
        OCardListItemUtils.setEnabled(this.mAllowNetBgText, true);
    L18:
        if (r0 != 0) goto L21;
        String r1 = getResources().getString(R.string.background_network_allow);
    L24:
        OCardListItemUtils.setTrailingText(this.mAllowNetBgText, r1);
        return;
    L21:
        if (r0 != 16) goto L23;
        r1 = getResources().getString(R.string.background_network_reject);
        goto L24
    L23:
        r1 = getResources().getString(R.string.background_network_reject_screen_off);
        goto L24
    L17:
        OCardListItemUtils.setEnabled(this.mAllowNetBgText, false);
        goto L18
    }

    private void initAllowBgPowerHigh() {
        this.isInitAllowBgPowerHigh = false;
        OCardListItem r1 = (OCardListItem) findViewByIdNullable(R.id.allow_bg_power_high);
        this.allowBgPowerHigh = r1;
        if (this.isSystemApp == false) goto L6;
        r1.setVisibility(8);
        this.percentItem.setCardPosition(0);
        this.isInitAllowBgPowerHigh = true;
        return;
    L6:
        r1.setVisibility(0);
        this.percentItem.setCardPosition(1);
    }

    private void updateAllowBgPowerHigh() {
        if (this.isSystemApp == false) goto L6;
        return;
    L6:
        if (this.isInitAllowBgPowerHigh == false) goto L8;
        return;
    L8:
        boolean r0 = HighPowerAppManager.Companion.isAllowBgHighPower(this.mPackageName);
        if (OCardListItemUtils.isChecked(this.allowBgPowerHigh) == r0) goto L11;
        OCardListItemUtils.setChecked(this.allowBgPowerHigh, r0);
    L11:
        this.isInitAllowBgPowerHigh = true;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.android.settings.fuelgauge.appBatteryUseOptimization.AppBatteryUseOptimizationControlFragment$2] */
    public void updateViews() {
        if (this.mAllowNetBgText == null) goto L21;
        int r0 = this.mNpm.getUidPolicy(this.mUid);
        if (r0 != 0) goto L10;
        if (isWhileListApp(this.mPackageName) == true) goto L10;
        r0 = 8;
    L10:
        if (isPermManagerEnable() == false) goto L12;
        OCardListItemUtils.setEnabled(this.mAllowNetBgText, true);
    L13:
        if (r0 != 0) goto L16;
        String r1 = getResources().getString(R.string.background_network_allow);
    L19:
        OCardListItemUtils.setTrailingText(this.mAllowNetBgText, r1);
        goto L21
    L16:
        if (r0 != 16) goto L18;
        r1 = getResources().getString(R.string.background_network_reject);
        goto L19
    L18:
        r1 = getResources().getString(R.string.background_network_reject_screen_off);
        goto L19
    L12:
        OCardListItemUtils.setEnabled(this.mAllowNetBgText, false);
    L21:
        if (Utils.isPackageInstalled(this.mContext, this.mPackageName) == true) goto L23;
        finish();
    L23:
        updateAllowBgPowerHigh();
        if (this.mIsGameApp == false) goto L27;
        new AnonymousClass2(this).execute(new Void[0]);
        return;
    }

    private void refreshPowerUsage(double[] r3, String r4) {
        if (r3 == null) goto L6;
        updateBattery(r3[0]);
        return;
    L6:
        if (this.batteryPowerViewModel != null) goto L8;
        BatteryPowerViewModel r5 = (BatteryPowerViewModel) new ViewModelProvider(getActivity()).get(BatteryPowerViewModel.class);
        this.batteryPowerViewModel = r5;
        r5.getPercent().observe(getActivity(), this.batteryPowerObserver);
    L8:
        this.batteryPowerViewModel.getPowerPercent(getActivity(), r4);
    }

    void updateBattery(double r3) {
        this.percentItem.setVisibility(0);
        DecimalFormat r0 = new DecimalFormat("0.0");
        r0.setRoundingMode(RoundingMode.HALF_UP);
        OCardListItemUtils.setTrailingText(this.percentItem, r0.format(r3) + "%");
    }

    private void initOps() {
        List r0 = this.mSmtOpsManager.getOpsForPackage(this.mUid, this.mPackageName, this.mOpsSystem);
        if (r0 == null) goto L11;
        if (r0.size() <= 0) goto L11;
        if (((SmtOpsManager.OpEntry) ((SmtOpsManager.PackageOps) r0.get(0)).getOps().get(0)).getMode() != 0) goto L9;
        this.mAllowSystem = true;
    L14:
        List r1 = this.mSmtOpsManager.getOpsForPackage(this.mUid, this.mPackageName, this.mOpsApp);
        if (r1 == null) goto L23;
        if (r1.size() <= 0) goto L23;
        if (((SmtOpsManager.OpEntry) ((SmtOpsManager.PackageOps) r1.get(0)).getOps().get(0)).getMode() != 0) goto L21;
        this.mAllowApp = true;
        return;
    L21:
        this.mAllowApp = false;
        return;
    L23:
        if (SmtOpsManagerSmt.getInstance().getOpDefaultMode(this.mContext, this.mOpsApp[0], this.mUid, this.mPackageName) != 0) goto L25;
        this.mAllowApp = true;
        return;
    L25:
        this.mAllowApp = false;
        return;
    L9:
        this.mAllowSystem = false;
    L11:
        if (SmtOpsManagerSmt.getInstance().getOpDefaultMode(this.mContext, this.mOpsSystem[0], this.mUid, this.mPackageName) != 0) goto L13;
        this.mAllowSystem = true;
        goto L14
    L13:
        this.mAllowSystem = false;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BatteryPowerViewModel r0 = this.batteryPowerViewModel;
        if (r0 == null) goto L6;
        r0.getPercent().removeObserver(this.batteryPowerObserver);
    L6:
        if (this.mId == (-1)) goto L8;
        return;
    L8:
        if (this.mIsGameApp == false) goto L12;
        AsyncTask.execute(new AnonymousClass5(this));
        return;
    }

    private boolean isPermManagerEnable() {
        return SmtOpsManagerSmt.getInstance().getEnabled(this.mContext);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AlertDialog r0 = this.mEnableDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mEnableDialog.dismiss();
        return;
    }

    private void showEnableDialog() {
        if (this._mActivity != null) goto L5;
        return;
    L5:
        if (this._mActivity.isFinishing() == true) goto L10;
        DialogInterface.OnClickListener r0 = new AnonymousClass6(this);
        AlertDialog r1 = new AlertDialog.Builder(this._mActivity).setTitle(R.string.dlg_dynamic_resolution_tip).setMessage(getString(R.string.dlg_dynamic_resolution_message)).setPositiveButton(getString(R.string.dlg_dynamic_resolution_okay), r0).setNegativeButton(R.string.cancel, r0).create();
        this.mEnableDialog = r1;
        r1.show();
        this.mEnableDialog.getButton(-1).setSingleLine();
        this.mEnableDialog.getButton(-1).setEllipsize(TextUtils.TruncateAt.END);
        this.mEnableDialog.setOnDismissListener(new AnonymousClass7(this));
        return;
    }

    private void updateDynamicResolution(final int r2) {
        AsyncTask.execute(new AnonymousClass8(this, r2));
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isInitAllowBgPowerHigh = false;
    }

    public boolean isWhileListApp(String r2) {
        IDeviceIdleController r1 = this.mDeviceIdleService;
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.isPowerSaveWhitelistApp(r2);
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L9:
        return false;
    }

    private void saveNetworkPolicyStatus(int r4) {
        NetworkPolicyManager r0 = NetworkPolicyManager.from(this.mContext);
        if (r4 != 8) goto L5;
        r0.setUidPolicy(this.mUid, 0);
    L6:
        if (r4 != 0) goto L8;
        addApp(this.mPackageName);
    L9:
        IPowerAdvisor r1 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));
        if (r1 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L21;
        r1.userSelectedWhitelistApp(this.mPackageName, r4);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        OLog.e(this.TAG, "saveNetworkPolicyStatus e: " + e);
        return;
    L21:
        return;
    L8:
        removeApp(this.mPackageName);
        goto L9
    L5:
        r0.setUidPolicy(this.mUid, r4);
        goto L6
    }

    public void addApp(String r1) {
        IDeviceIdleController r0 = this.mDeviceIdleService;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.addPowerSaveWhitelistApp(r1);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void removeApp(String r1) {
        IDeviceIdleController r0 = this.mDeviceIdleService;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.removePowerSaveWhitelistApp(r1);     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppBatteryUseOptimizationControlFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppBatteryUseOptimizationControlFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppBatteryUseOptimizationControlFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationControlFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
