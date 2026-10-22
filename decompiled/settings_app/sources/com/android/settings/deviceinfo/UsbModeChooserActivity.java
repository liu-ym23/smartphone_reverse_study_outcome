package com.android.settings.deviceinfo;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import bytedanceos.util.Features;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.selection.OSelectionPanelItemView;
import com.obric.oui.selection.OSelectionPanelView;
import com.obric.oui.selection.OSingleSelectionPanelView;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.tablet.widget.BytedanceJustifyTextView;
import obric.view.WindowManagerHelper;

/* JADX INFO: loaded from: classes2.dex */
public class UsbModeChooserActivity extends LifeHookActivity2 {
    public static final int[] DEFAULT_MODES = null;
    private static final String TAG = "UsbModeChooserActivity";
    private static final String USB_FUNCTION_HARDWARE_TEST = "";
    private String USB_FUNCTION_RMNET_CT;
    private String USB_FUNCTION_RNDIS_CT;
    private OSelectionDialog levelDialog;
    private UsbBackend mBackend;
    private OSelectionPanelItemView mChargeOnlyItem;
    private int mCurrentMode;
    private BroadcastReceiver mDisconnectedReceiver;
    private ArrayList<String> mFunctions;
    private boolean mIsUnlocked;
    private boolean mIsUser;
    private int mSelected;
    private boolean mUsbConnected;
    private UsbManager mUsbManager;
    private OSingleSelectionPanelView mUsbModeItems;
    private OSingleSelectionPanelView mUsbModeItemsWithoutChargeOnly;

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public UsbModeChooserActivity() {
        this.mSelected = -1;
        this.mDisconnectedReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(UsbModeChooserActivity r0, Intent r1, String r2) {
        r0.handleUsbStateChange(r1, r2);
    }

    static {
        DEFAULT_MODES = new int[]{0, 2, 4, 6};
    }

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__onCreate$___twin___(Bundle r12) {
        super.onCreate(r12);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        if (Utils.isMonkeyRunning() == false) goto L6;
        finish();
        return;
    L6:
        this.USB_FUNCTION_RNDIS_CT = (String) Utils.getClassField(UsbManager.class, "USB_FUNCTION_RNDIS_CT");
        this.USB_FUNCTION_RMNET_CT = (String) Utils.getClassField(UsbManager.class, "USB_FUNCTION_RMNET_CT");
        Intent r2 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getBaseContext(), null, new IntentFilter("android.hardware.usb.action.USB_STATE"), 2);     // Catch: Exception -> L13
        if (r2 != null) goto L10;
        boolean r3 = false;
    L11:
        this.mIsUnlocked = r3;     // Catch: Exception -> L13
    L14:
        this.mUsbManager = (UsbManager) getSystemService("usb");
        boolean r4 = ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_usb_file_transfer");
        this.mIsUser = Build.TYPE.equals(PickApplicationActivity.EXTRA_USER);
        UsbBackend r5 = new UsbBackend(this);
        this.mBackend = r5;
        this.mCurrentMode = r5.getCurrentDataMode();
        this.mFunctions = new ArrayList();
        ArrayList r6 = new ArrayList();
        this.mFunctions.add("none");
        r6.add(getText(R.string.sm_usb_use_charging_only));
        if (this.mCurrentMode != 0) goto L17;
        int r7 = r6.size() - 1;
    L18:
        if (r4 == true) goto L25;
        this.mFunctions.add("mtp");
        r6.add(getText(R.string.usb_use_file_transfers));
        if (this.mCurrentMode != 2) goto L22;
        r7 = r6.size() - 1;
    L22:
        this.mFunctions.add("ptp");
        r6.add(getText(R.string.usb_use_photo_transfers));
        if (this.mCurrentMode != 4) goto L25;
        r7 = r6.size() - 1;
    L25:
        this.mFunctions.add("midi");
        r6.add(getText(R.string.usb_use_MIDI));
        if (this.mCurrentMode != 6) goto L29;
        r7 = r6.size() - 1;
    L29:
        if (Features.isFeatureCTEnabled(this).booleanValue() == false) goto L31;
    L32:
        String r13 = this.USB_FUNCTION_RNDIS_CT;
        if (r13 == null) goto L35;
        this.mFunctions.add(r13);
        r6.add(getText(R.string.tether_settings_title_usb));
    L35:
        String r14 = this.USB_FUNCTION_RMNET_CT;
        if (r14 == null) goto L38;
        this.mFunctions.add(r14);
        r6.add(getText(R.string.usb_mode_ct_rmnet_test));
    L38:
        final View r15 = LayoutInflater.from(this).inflate(R.layout.usb_mode_chooser_layout, null);
        final LinearLayout r8 = (LinearLayout) r15.findViewById(R.id.item_layout);
        OCardListItem r9 = (OCardListItem) r15.findViewById(R.id.power_source);
        r9.setDefaultCustomEndView(1);
        r9.setShowCardBg(false);
        r9.showDivider(true);
        OSwitch r10 = r9.getEndSwitch();
        r10.setOnCheckedChangeListener(new UsbModeChooserActivity$$ExternalSyntheticLambda0(this, r8));
        if (this.mBackend.getPowerRole() != 1) goto L41;
        boolean r11 = true;
    L42:
        r10.setChecked(r11);
        int r16 = r6.size();
        OLog.d(TAG, "curIndex:" + r7 + "  mCurrentMode:" + this.mCurrentMode);
        int r17 = 0;
    L43:
        if (r17 >= r16) goto L53;
        final OSelectionItemView r18 = UsbModeChooserKotlinKt.createSelectItemView(this);
        r18.setTitle(String.valueOf(r6.get(r17)));
        if (r7 != r17) goto L47;
        boolean r19 = true;
    L48:
        r18.setChecked(r19);
        r18.setTag(this.mFunctions.get(r17));
        if (r17 >= (r16 - 1)) goto L51;
        boolean r110 = true;
    L52:
        r18.showDivider(r110);
        r8.addView(r18);
        r18.setId(r17);
        r18.setOnClickListener(new UsbModeChooserActivity$$ExternalSyntheticLambda1(this, r8, r18));
        r17 = r17 + 1;
        goto L43
    L51:
        r110 = false;
        goto L52
    L47:
        r19 = false;
        goto L48
    L53:
        updateCharge(r8, r10.isChecked());
        OSelectionDialog r111 = new OSelectionDialog(this, new OSelectionDialog.Modifier(getString(R.string.usb_mode_picker_dialog_title), "", new AnonymousClass2(this, r15), null, new OBaseDialog.ButtonConfig(getString(R.string.cancel), new AnonymousClass3(this), null)));
        this.levelDialog = r111;
        r111.setOnCancelListener(new UsbModeChooserActivity$$ExternalSyntheticLambda2(this));
        if (this.levelDialog.getWindow() == null) goto L56;
        this.levelDialog.getWindow().setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);
    L56:
        this.levelDialog.show();
        registerUsbConnectReceiver();
        return;
    L41:
        r11 = false;
        goto L42
    L31:
        if (Features.isFeatureCMCCEnabled(this).booleanValue() == false) goto L38;
    L17:
        r7 = 0;
        goto L18
    L10:
        r3 = r2.getBooleanExtra("unlocked", false);     // Catch: Exception -> L13
    L13:
        this.mIsUnlocked = false;
        goto L14
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-deviceinfo-UsbModeChooserActivity, reason: not valid java name */
    /* synthetic */ void m436x5e1b3e0c(LinearLayout r2, CompoundButton r3, boolean r4) {
        if (r4 == false) goto L4;
        this.mBackend.setPowerMode(1);
    L5:
        updateCharge(r2, r4);
        return;
    L4:
        this.mBackend.setPowerMode(2);
        goto L5
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-deviceinfo-UsbModeChooserActivity, reason: not valid java name */
    /* synthetic */ void m437x5f5190eb(LinearLayout r1, OSelectionItemView r2, View r3) {
        updateSelectView(r1, r3);
        r2.setChecked(true);
        saveUsbMode(r2.getId());
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-deviceinfo-UsbModeChooserActivity, reason: not valid java name */
    /* synthetic */ void m438x6087e3ca(DialogInterface r1) {
        finish();
    }

    private void saveUsbMode(int r4) {
        OLog.d(TAG, "saveUsbMode:" + r4);
        if (ActivityManager.isUserAMonkey() == true) goto L6;
        if (r4 < 0) goto L6;
        setCurrentFunction(r4);
    L6:
        this.levelDialog.dismiss();
        finish();
    }

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__onDestroy$___twin___() {
        OSelectionDialog r0 = this.levelDialog;
        if (r0 != null) goto L5;
    L13:
        unregisterReceiver(this.mDisconnectedReceiver);     // Catch: Exception -> L9
    L11:
        super.onDestroy();
        return;
    L9:
        e = move-exception;
        OLog.e(TAG, "onDestroy, error_msg: " + e);
        goto L11
    L5:
        if (r0.isShowing() == false) goto L13;
        this.levelDialog.dismiss();
        goto L13
    }

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    private int getCurrentFunction() {
        if (this.mIsUnlocked == true) goto L5;
        return -1;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mFunctions.size()) goto L15;
        if (this.mFunctions.get(r0) == null) goto L14;
        if (this.mUsbManager.isFunctionEnabled(this.mFunctions.get(r0)) == false) goto L14;
        return r0;
    L14:
        r0 = r0 + 1;
        goto L7
    L15:
        return -1;
    }

    private void setCurrentFunction(int r5) {
        String r0 = this.mFunctions.get(r5);
        OLog.d(TAG, "setCurrentFunction which:" + r5 + BytedanceJustifyTextView.TWO_BLANK + r0);
        if (r0 != null) goto L6;
        Utils.setUsbCurrentFunction(this.mUsbManager, null, false);
        return;
    L6:
        Utils.setUsbCurrentFunction(this.mUsbManager, r0, true);
    }

    private int getCurrentMode() {
        int r1 = 0;
    L3:
        int[] r2 = DEFAULT_MODES;
        if (r1 >= r2.length) goto L9;
        if (r2[r1] == this.mCurrentMode) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r1;
    L9:
        return 0;
    }

    private void registerUsbConnectReceiver() {
        IntentFilter r0 = new IntentFilter("android.hardware.usb.action.USB_STATE");
        handleUsbStateChange(GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mDisconnectedReceiver, r0), "registerUsbConnectReceiver");
    }

    private void handleUsbStateChange(Intent r6, String r7) {
        if (r6 != null) goto L6;
        OLog.d(TAG, "handleUsbStateChange, source: " + r7 + ", intent is null, return");
        return;
    L6:
        String r1 = r6.getAction();
        String r2 = TAG;
        OLog.d(r2, "handleUsbStateChange, source: " + r7 + ", action: " + r1);
        if ("android.hardware.usb.action.USB_STATE".equals(r1) == false) goto L16;
        boolean r3 = false;
        boolean r4 = r6.getBooleanExtra("connected", false);
        boolean r8 = r6.getBooleanExtra("host_connected", false);
        OLog.d(r2, "handleUsbStateChange, source: " + r7 + ", connected: " + r4 + ", hostConnected: " + r8);
        if (r4 == true) goto L11;
        if (r8 == true) goto L11;
    L12:
        this.mUsbConnected = r3;
        if (r3 == true) goto L17;
        finish();
        return;
    L17:
        return;
    L11:
        r3 = true;
        goto L12
    }

    public void com_android_settings_deviceinfo_UsbModeChooserActivity__onStop$___twin___() {
        super.onStop();
    }

    private List<OSelectionPanelView.SelectionItemData> convertToSelectionItemDataList(ArrayList<CharSequence> r4) {
        ArrayList r3 = new ArrayList();
        Iterator<CharSequence> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r3.add(new OSelectionPanelView.SelectionItemData(null, r5.next().toString(), null));
        goto L4
    L6:
        return r3;
    }

    private List<OSelectionPanelView.SelectionItemData> convertWithoutChargeOnly(ArrayList<CharSequence> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<CharSequence> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        String r1 = r6.next().toString();
        if (r1.equals(getString(R.string.sm_usb_use_charging_only)) == true) goto L4;
        r0.add(new OSelectionPanelView.SelectionItemData(null, r1, null));
        goto L4
    L9:
        return r0;
    }

    private void updateSelectView(LinearLayout r5, View r6) {
        int r4 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L9;
        OSelectionItemView r2 = (OSelectionItemView) r5.getChildAt(r1);
        if (r2 != r6) goto L7;
        boolean r3 = true;
    L8:
        r2.setChecked(r3);
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = false;
        goto L8
    }

    private void updateCharge(LinearLayout r2, boolean r3) {
        if (r2.getChildCount() > 0) goto L5;
        return;
    L5:
        boolean r0 = false;
        OSelectionItemView r4 = (OSelectionItemView) r2.getChildAt(0);
        int r1 = getCurrentMode();
        if (r3 == false) goto L8;
        r4.setEnabled(false);
        r4.setChecked(false);
        r4.setAlpha(0.5f);
        return;
    L8:
        r4.setEnabled(true);
        if (r1 != 0) goto L11;
        r0 = true;
    L11:
        r4.setChecked(r0);
        r4.setAlpha(1.0f);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(UsbModeChooserActivity r1) {
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(UsbModeChooserActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsbModeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_UsbModeChooserActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(UsbModeChooserActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(UsbModeChooserActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        UsbModeChooserActivity r5 = r4;
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
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(UsbModeChooserActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_UsbModeChooserActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(UsbModeChooserActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(UsbModeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsbModeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_UsbModeChooserActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(UsbModeChooserActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(UsbModeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsbModeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_UsbModeChooserActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(UsbModeChooserActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        UsbModeChooserActivity r5 = r3;
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

    @Insert("onStop")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(UsbModeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsbModeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_UsbModeChooserActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(UsbModeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsbModeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_deviceinfo_UsbModeChooserActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_deviceinfo_UsbModeChooserActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(UsbModeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsbModeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_deviceinfo_UsbModeChooserActivity__finish$___twin___();
    }
}
