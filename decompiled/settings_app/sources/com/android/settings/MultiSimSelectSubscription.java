package com.android.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import bytedanceos.util.Features;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimSelectSubscription extends BaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final int DIALOG_SET_DATA_SUBSCRIPTION_IN_PROGRESS = 100;
    private static final String TAG = "MultiSimSelectSubscription";
    private long lastClick;
    private OCardListItem mAskEveryTimeItem;
    private OCardListItem mAutoSwitchSim;
    private OSectionTitleBar mDefaultSimTitle;
    private boolean mIsFromMobileData;
    private int mOriginalDataSlot;
    private int mSimStateChangeCount;
    private SimStateChangeHandler mSimStateChangeHandler;
    private OCardListItem mSub1Item;
    private OCardListItem mSub2Item;
    SubscriptionManager mSubManager;
    private int subscriptionType;

    static {
    }

    private boolean isCdmaSim(int r1) {
        return false;
    }

    public void com_android_settings_MultiSimSelectSubscription__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_MultiSimSelectSubscription__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public MultiSimSelectSubscription() {
        this.mSimStateChangeHandler = new AnonymousClass1(this, this);
    }

    static /* synthetic */ int access$000(MultiSimSelectSubscription r0) {
        return r0.mSimStateChangeCount;
    }

    static /* synthetic */ int access$008(MultiSimSelectSubscription r2) {
        int r0 = r2.mSimStateChangeCount;
        r2.mSimStateChangeCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ void access$100(MultiSimSelectSubscription r0) {
        r0.updateSubItemView();
    }

    static /* synthetic */ void access$200(MultiSimSelectSubscription r0) {
        r0.returnMobileDataActivity();
    }

    static /* synthetic */ void access$300(MultiSimSelectSubscription r0, int r1) {
        r0.startPinActivity(r1);
    }

    public void com_android_settings_MultiSimSelectSubscription__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.default_sim_config_layout);
        this.subscriptionType = Utils.getIntExtraSafely(getIntent(), MultiSimSettings.EXTRA_SUBSCRIPTION_TYPE, -1);
        OCardListItem r6 = (OCardListItem) findViewById(R.id.ask_every_time);
        this.mAskEveryTimeItem = r6;
        if (this.subscriptionType != 0) goto L5;
        int r0 = 0;
    L6:
        r6.setVisibility(r0);
        OCardListItemUtils.setCustomEndImageView(this.mAskEveryTimeItem);
        this.mAskEveryTimeItem.showCustomEnd(false);
        this.mAskEveryTimeItem.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewById(R.id.sub_1);
        this.mSub1Item = r7;
        if (this.subscriptionType != 0) goto L9;
        int r1 = 2;
    L10:
        r7.setCardPosition(r1);
        OCardListItemUtils.setCustomEndImageView(this.mSub1Item);
        this.mSub1Item.showCustomEnd(false);
        this.mSub1Item.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) findViewById(R.id.sub_2);
        this.mSub2Item = r8;
        OCardListItemUtils.setCustomEndImageView(r8);
        this.mSub2Item.showCustomEnd(false);
        this.mSub2Item.setOnContentClickListener(this);
        OSectionTitleBar r9 = (OSectionTitleBar) findViewById(R.id.default_sim_title);
        this.mDefaultSimTitle = r9;
        r9.setTitleText(getDefaultSimTitle());
        OCardListItem r10 = (OCardListItem) findViewById(R.id.auto_switch);
        this.mAutoSwitchSim = r10;
        r10.getContentContainer().setClickable(false);
        setupUI();
        this.mSubManager = SubscriptionManager.from(this);
        setupBackBtnOnTitle();
        boolean r11 = Utils.getBooleanExtraSafely(getIntent(), "from_mobile_data", false);
        this.mIsFromMobileData = r11;
        if (r11 == false) goto L13;
        this.mOriginalDataSlot = getPhoneIdFor(this.mSubManager, 2);
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass2(this));
    L13:
        this.mTitle.post(new AnonymousClass3(this));
        return;
    L9:
        r1 = 1;
        goto L10
    L5:
        r0 = 8;
        goto L6
    }

    private String getDefaultSimTitle() {
        int r0 = this.subscriptionType;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        return "";
    L14:
        return getString(R.string.default_sim_title_format_data);
    L15:
        return getString(R.string.default_sim_title_format_sms);
    L12:
        return getString(R.string.default_sim_title_format_call);
    }

    public void com_android_settings_MultiSimSelectSubscription__onResume$___twin___() {
        super.onResume();
        updateSubItemView();
        updateSwitchState();
        OCardListItem r0 = this.mAutoSwitchSim;
        if (r0 == null) goto L5;
        ((OSwitch) r0.getCustomEndView()).setOnCheckedChangeListener(this);
    L5:
        this.mSimStateChangeHandler.register();
    }

    private void updateSubItemView() {
        int r0 = getPhoneIdFor(this.mSubManager, this.subscriptionType);
        this.mAskEveryTimeItem.showCustomEnd(false);
        this.mSub1Item.showCustomEnd(false);
        this.mSub2Item.showCustomEnd(false);
        if (this.subscriptionType == 0) goto L5;
    L7:
        if (r0 != 0) goto L9;
        this.mSub1Item.showCustomEnd(true);
    L9:
        this.mSub1Item.setTitle(MultiSimSettings.getSimName(this, 0));
        if (r0 != 1) goto L12;
        this.mSub2Item.showCustomEnd(true);
    L12:
        this.mSub2Item.setTitle(MultiSimSettings.getSimName(this, 1));
        return;
    L5:
        if (r0 != (-1)) goto L7;
        this.mAskEveryTimeItem.showCustomEnd(true);
        goto L7
    }

    private void updateSwitchState() {
        if (this.subscriptionType != 0) goto L10;
        OCardListItem r0 = this.mAutoSwitchSim;
        if (r0 == null) goto L9;
        ((OSwitch) r0.getCustomEndView()).setChecked(MultiSimUtil.isPhoneAutoCallback(this));
        return;
    L9:
        return;
    }

    public void com_android_settings_MultiSimSelectSubscription__onPause$___twin___() {
        super.onPause();
        OCardListItem r0 = this.mAutoSwitchSim;
        if (r0 == null) goto L5;
        ((OSwitch) r0.getCustomEndView()).setOnCheckedChangeListener(null);
    L5:
        this.mSimStateChangeHandler.unregister();
        this.mSimStateChangeCount = 0;
    }

    public void com_android_settings_MultiSimSelectSubscription__onDestroy$___twin___() {
        super.onDestroy();
    }

    private void setupUI() {
        Bundle r0 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_NUM, null, null);
        if (r0 == null) goto L5;
        String r5 = r0.getString(String.valueOf(0));
        String r1 = r0.getString(String.valueOf(1));
    L7:
        if (this.subscriptionType != 2) goto L12;
        Bundle r2 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_DATA_USAGE, null, null);
        if (r2 == null) goto L11;
        String r3 = r2.getString(String.valueOf(0)) + "\n" + r5;
        r1 = r2.getString(String.valueOf(1)) + "\n" + r1;
        r5 = r3;
    L11:
        disableSim2ToBeDataCard();
    L12:
        this.mSub1Item.setSubTitle(r5);
        this.mSub1Item.showSubTitle(true);
        this.mSub2Item.setSubTitle(r1);
        this.mSub2Item.showSubTitle(true);
        int r4 = this.subscriptionType;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L17;
        Log.d(TAG, "unknown subscription type");
        finish();
        return;
    L17:
        this.mAutoSwitchSim.setVisibility(8);
        return;
    L18:
        this.mAutoSwitchSim.setTitle(getString(R.string.multi_sim_auto_choose_sim_dial));
        return;
    L5:
        r5 = "";
        r1 = "";
        goto L7
    }

    private void disableSim2ToBeDataCard() {
        if (SettingsFeature.isSim2CanNotBeDataCardWhenSim1IsCdma() == true) goto L5;
        return;
    L5:
        if (isCdmaSim(0) == true) goto L7;
        return;
    L7:
        if (this.subscriptionType != 2) goto L12;
        OCardListItemUtils.setContentContainerEnabled(this.mSub2Item, false);
        return;
    }

    public static int getPhoneIdFor(SubscriptionManager r0, int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return -1;
    L10:
        return SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultDataSubscriptionId());
    L12:
        return SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultSmsSubscriptionId());
    L14:
        return SubscriptionManager.getDefaultVoicePhoneId();
    }

    private void setSubscriptionFor(int r7, int r8) {
        int r0 = MultiSimSettings.getSubIdBySlotId(this.mSubManager, r8);
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L6;
        getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.SET_SIM_SUBSCRIPTION_FOR_SMS, Integer.toString(r0), null);
        this.mSubManager.setDefaultSmsSubId(r0);
        setSubItemsEnable(true);
        return;
    L6:
        if (r7 == 2) goto L9;
        return;
    L9:
        if (isPhoneSimLocked(r8) == false) goto L11;
        showPinLockedDialog(r8);
        setSubItemsEnable(true);
        return;
    L11:
        getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.SET_SIM_SUBSCRIPTION_FOR_DATA, Integer.toString(r0), null);
        if (Features.isFeatureCMCCEnabled(this).booleanValue() == false) goto L14;
        ToastUtils.show(this, getResources().getString(R.string.set_dds_success, new Object[]{Integer.toString(r8 + 1)}));
    L14:
        setSubItemsEnable(true);
        this.mSubManager.setDefaultDataSubId(r0);
        return;
    L16:
        getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.SET_SIM_SUBSCRIPTION_FOR_DIAL, Integer.toString(r0), null);
        this.mSubManager.setDefaultVoiceSubId(r0);
        setSubItemsEnable(true);
    }

    private void setSubItemsEnable(boolean r2) {
        this.mAskEveryTimeItem.getContentContainer().setClickable(r2);
        this.mAskEveryTimeItem.getContentContainer().setFocusable(r2);
        this.mSub1Item.getContentContainer().setClickable(r2);
        this.mSub1Item.getContentContainer().setFocusable(r2);
        this.mSub2Item.getContentContainer().setClickable(r2);
        this.mSub2Item.getContentContainer().setFocusable(r2);
    }

    private void showPinLockedDialog(final int r7) {
        int r1 = r7 + 1;
        String r0 = getString(R.string.default_sim_name) + HanziToPinyin.Token.SEPARATOR + r1;
        String r2 = MultiSimUtil.getSimName(this, r7);
        if (r0.equals(r2) == false) goto L5;
        r2 = String.valueOf(r1);
    L5:
        new AlertDialog.Builder(this).setTitle(getString(R.string.dialog_sim_locked_title, new Object[]{r2})).setMessage(getString(R.string.dialog_sim_locked_content, new Object[]{r2})).setPositiveButton(R.string.ok, new AnonymousClass4(this, r7)).setNegativeButton(R.string.cancel, null).create().show();
    }

    private void startPinActivity(int r4) {
        Intent r0 = new Intent();
        r0.setClassName("com.android.phone", "com.bytedanceos.phone.settings.settings.EnableIccPinScreen");
        r0.putExtra("show_input_dialog_on_start", true);
        r0.putExtra("subscription", r4);
        r0.putExtra("back_text", getIntent().getStringExtra("title"));
        Utils.startActivity(this, r0, 0);
    }

    private boolean isPhoneSimLocked(int r3) {
        if (TelephonyManager.getDefault().isMultiSimEnabled() == false) goto L13;
        TelephonyManager r2 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r2 != null) goto L7;
        return false;
    L7:
        int r4 = r2.getSimState(r3);
        if (2 != r4) goto L10;
    L11:
        return true;
    L10:
        if (3 == r4) goto L11;
        return false;
    L13:
        return false;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r2) {
        if (r2 != 100) goto L6;
        BytedanceProgressDialog r3 = new BytedanceProgressDialog(this);
        r3.setMessage(getResources().getString(R.string.set_data_subscription_progress));
        r3.setCancelable(false);
        return r3;
    L6:
        return null;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (this.subscriptionType != 0) goto L7;
        MultiSimUtil.setPhoneAutoCallback(this, r2);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastClick) >= 200) goto L5;
        return;
    L5:
        this.lastClick = r0;
        setSubItemsEnable(false);
        if (r7 != this.mAskEveryTimeItem.getContentContainer()) goto L13;
        if (getPhoneIdFor(this.mSubManager, this.subscriptionType) != (-1)) goto L11;
        setSubItemsEnable(true);
        return;
    L11:
        getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.SET_SIM_SUBSCRIPTION_FOR_DIAL, Integer.toString(-1), null);
        this.mSubManager.setDefaultVoiceSubId(-1);
        setSubItemsEnable(true);
    L26:
        updateSubItemView();
        return;
    L13:
        if (r7 != this.mSub1Item.getContentContainer()) goto L20;
        if (getPhoneIdFor(this.mSubManager, this.subscriptionType) != 0) goto L18;
        setSubItemsEnable(true);
        return;
    L18:
        setSubscriptionFor(this.subscriptionType, 0);
        goto L26
    L20:
        if (r7 != this.mSub2Item.getContentContainer()) goto L26;
        if (getPhoneIdFor(this.mSubManager, this.subscriptionType) != 1) goto L25;
        setSubItemsEnable(true);
        return;
    L25:
        setSubscriptionFor(this.subscriptionType, 1);
        goto L26
    }

    private void returnMobileDataActivity() {
        if (this.mIsFromMobileData == true) goto L5;
    L10:
        finish();
        return;
    L5:
        if (this.mOriginalDataSlot == getPhoneIdFor(this.mSubManager, 2)) goto L10;
        Intent r0 = new Intent();     // Catch: Exception -> L8
        r0.setClassName("com.android.phone", "com.bytedanceos.phone.settings.settings.mobilenetwork.MobileNetworkSettings");     // Catch: Exception -> L8
        r0.setAction("android.intent.action.MAIN");     // Catch: Exception -> L8
        Utils.startActivity(this, r0);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        returnMobileDataActivity();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimSelectSubscription_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MultiSimSelectSubscription r1) {
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onCreate(MultiSimSelectSubscription r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSelectSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MultiSimSelectSubscription__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_BatchedActivityLancet_onResume(MultiSimSelectSubscription r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(MultiSimSelectSubscription r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        MultiSimSelectSubscription r5 = r4;
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
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(MultiSimSelectSubscription r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_MultiSimSelectSubscription__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_BatchedActivityLancet_onStop(MultiSimSelectSubscription r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_MultiSimSelectSubscription_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onResume(MultiSimSelectSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSelectSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_MultiSimSelectSubscription__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(MultiSimSelectSubscription r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onPause(MultiSimSelectSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSelectSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_MultiSimSelectSubscription__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(MultiSimSelectSubscription r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        MultiSimSelectSubscription r5 = r3;
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
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onStop(MultiSimSelectSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSelectSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_MultiSimSelectSubscription__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_MultiSimSelectSubscription_com_obric_hook_lancet_PrivacyHook_onDestroy(MultiSimSelectSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSelectSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_MultiSimSelectSubscription__onDestroy$___twin___();
    }
}
