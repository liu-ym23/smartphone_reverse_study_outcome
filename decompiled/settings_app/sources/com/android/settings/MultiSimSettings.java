package com.android.settings;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import bytedanceos.util.Features;
import com.GlobalProxyLancet;
import com.android.internal.telephony.ITelephony;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseActivity;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.sim.DataDuringCallsPreferenceController;
import com.android.settings.sim.SIMUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimSettings extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int DELAY_TIME_UPDATE_UI = 50;
    private static final int DIALOG_SET_DATA_SUBSCRIPTION_IN_PROGRESS = 100;
    public static final String EXTRA_SIM_INDEX = "extra_sim_index";
    public static final String EXTRA_SUBSCRIPTION_TYPE = "extra_subscription_type";
    private static final int MAX_SUBSCRIPTIONS = 0;
    private static final int MSG_UPDATE_UI = 100;
    public static final String RADIO_SMART_DATA_SWITCH_ENABLE = "radio_smart_data_switch_enable";
    private static final String SETTING_USER_PREF_DATA_SUB = "user_preferred_data_sub";
    public static final int SIM_1_INDEX = 0;
    public static final int SIM_2_INDEX = 1;
    public static final int SUBSCRIPTION_DATA = 2;
    public static final int SUBSCRIPTION_DIAL = 0;
    public static final int SUBSCRIPTION_SMS = 1;
    private static final String TAG = "MultiSimSettings";
    private final int SUB_ID_1;
    private final int SUB_ID_2;
    private OCardListItem dialItem;
    private OListItemSettings habitDualSim;
    private OListItemSettings habitSingleSim;
    private TextView habitTips;
    private SubscriptionManager.OnSubscriptionsChangedListener listener;
    private TextView mHabitDialLabel;
    private ImageView mHabitDialPic;
    private ImageView mHabitSmsPic;
    private Handler mHandler;
    private int mIccCardCount;
    IntentFilter mIntentFilter;
    private boolean mIsLeftHandDialMode;
    private OCardListItem mNetIntelligentDualSim;
    private OCardListItem mNetNonDataSim;
    private OPopover mNetworkPopover;
    private int mPhone1CallState;
    private int mPhone2CallState;
    private PhoneStateListener mPhoneStateListener1;
    private PhoneStateListener mPhoneStateListener2;
    private AirplaneModeBroadcastReceiver mReceiver;
    private OPopover mSMSPopover;
    private INetworkStatsService mService;
    private INetworkStatsSession mSession;
    private SimStateChangeHandler mSimStateChangeHandler;
    SubscriptionManager mSubManager;
    private TelephonyManager mTelephonyManager;
    private final DataDuringCallsPreferenceController mTempDDSController;
    private int mTitleRes;
    private BroadcastReceiver mtkSimActiveStateChangeReceiver;
    private OCardListItem networkItem;
    private OCardListItem pinItem;
    private int[] simDefNameRes;
    private OCardListItem smsItem;
    private OCardListItem sub1Item;
    private OCardListItem sub2Item;

    private class AirplaneModeBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ MultiSimSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private AirplaneModeBroadcastReceiver(MultiSimSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AirplaneModeBroadcastReceiver(MultiSimSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver__onReceive$___twin___(Context r2, Intent r3) {
            if ("android.intent.action.AIRPLANE_MODE".equals(r3.getAction()) == false) goto L8;
            OLog.d(MultiSimSettings.TAG, "Intent ACTION_AIRPLANE_MODE_CHANGED received");
            if (MultiSimSettings.access$1500(this.this$0, r2) == false) goto L9;
            this.this$0.finish();
            return;
        L9:
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AirplaneModeBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            AirplaneModeBroadcastReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_MultiSimSettings$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    public void com_android_settings_MultiSimSettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_MultiSimSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public MultiSimSettings() {
        this.mReceiver = null;
        this.mIntentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        this.mIccCardCount = 0;
        this.simDefNameRes = new int[]{R.string.multi_sim_sub_1_title, R.string.multi_sim_sub_2_title};
        this.mPhone1CallState = 0;
        this.mPhone2CallState = 0;
        this.mNetworkPopover = null;
        this.mSMSPopover = null;
        this.mSimStateChangeHandler = new AnonymousClass1(this, this);
        this.SUB_ID_1 = getSubIdBySlotId(this.mSubManager, 0);
        this.mPhoneStateListener1 = new AnonymousClass2(this);
        this.SUB_ID_2 = getSubIdBySlotId(this.mSubManager, 1);
        this.mPhoneStateListener2 = new AnonymousClass3(this);
        this.listener = new AnonymousClass4(this);
        this.mtkSimActiveStateChangeReceiver = new AnonymousClass5(this);
        this.mHandler = new AnonymousClass6(this);
        this.mTempDDSController = new DataDuringCallsPreferenceController(this);
    }

    static /* synthetic */ void access$000(MultiSimSettings r0) {
        r0.scheduleUpdateUI();
    }

    static /* synthetic */ void access$1000(MultiSimSettings r0, int r1, int r2) {
        r0.setSIMSubscription(r1, r2);
    }

    static /* synthetic */ int access$102(MultiSimSettings r0, int r1) {
        r0.mPhone1CallState = r1;
        return r1;
    }

    static /* synthetic */ OPopover access$1100(MultiSimSettings r0) {
        return r0.mNetworkPopover;
    }

    static /* synthetic */ OPopover access$1102(MultiSimSettings r0, OPopover r1) {
        r0.mNetworkPopover = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(MultiSimSettings r0, int r1) {
        r0.startPinActivity(r1);
    }

    static /* synthetic */ OCardListItem access$1300(MultiSimSettings r0) {
        return r0.smsItem;
    }

    static /* synthetic */ OPopover access$1400(MultiSimSettings r0) {
        return r0.mSMSPopover;
    }

    static /* synthetic */ OPopover access$1402(MultiSimSettings r0, OPopover r1) {
        r0.mSMSPopover = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1500(MultiSimSettings r0, Context r1) {
        return r0.isAirplaneModeOn(r1);
    }

    static /* synthetic */ boolean access$200(MultiSimSettings r0) {
        return r0.isInCallingState();
    }

    static /* synthetic */ void access$300(MultiSimSettings r0, boolean r1) {
        r0.updateDataSimItemEnabledState(r1);
    }

    static /* synthetic */ int access$402(MultiSimSettings r0, int r1) {
        r0.mPhone2CallState = r1;
        return r1;
    }

    static /* synthetic */ void access$500(MultiSimSettings r0) {
        r0.updateUi();
    }

    static /* synthetic */ void access$600(MultiSimSettings r0) {
        r0.showNetworkPopMenu();
    }

    static /* synthetic */ INetworkStatsService access$800(MultiSimSettings r0) {
        return r0.mService;
    }

    static /* synthetic */ OCardListItem access$900(MultiSimSettings r0) {
        return r0.networkItem;
    }

    static {
        MAX_SUBSCRIPTIONS = MultiSimAdapter.getPhoneCount();
    }

    public void com_android_settings_MultiSimSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.multi_sim_settings_layout);
        this.mSubManager = SubscriptionManager.from(this);
        OCardListItem r5 = (OCardListItem) findViewById(R.id.sim_sub_1);
        this.sub1Item = r5;
        r5.setOnContentClickListener(this);
        OCardListItem r6 = (OCardListItem) findViewById(R.id.sim_sub_2);
        this.sub2Item = r6;
        r6.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewById(R.id.dial_setting);
        this.dialItem = r7;
        r7.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) findViewById(R.id.mms_setting);
        this.smsItem = r8;
        r8.setOnContentClickListener(this);
        this.networkItem = (OCardListItem) findViewById(R.id.network_setting);
        if (isSIMForDataChecked(0) == false) goto L6;
        OCardListItemUtils.setCustomEndTipTextView(this.networkItem, getString(R.string.multi_sim_sub_1_title));
    L8:
        this.networkItem.setOnContentClickListener(new AnonymousClass7(this));
        OCardListItem r0 = (OCardListItem) findViewById(R.id.net_on_non_data_sim);
        this.mNetNonDataSim = r0;
        r0.getContentContainer().setClickable(false);
        if (SettingsFeature.isSupportNetOnNonDataSim() == false) goto L11;
        this.mNetNonDataSim.setVisibility(0);
        ((OSwitch) this.mNetNonDataSim.getCustomEndView()).setOnCheckedChangeListener(this);
    L11:
        OCardListItem r9 = (OCardListItem) findViewById(R.id.net_intelligent_dual_sim);
        this.mNetIntelligentDualSim = r9;
        r9.getEndSwitch().setChecked(isNetIntelligentDualSimChecked());
        ((OSwitch) this.mNetIntelligentDualSim.getCustomEndView()).setOnCheckedChangeListener(this);
        OCardListItem r10 = (OCardListItem) findViewById(R.id.pin);
        this.pinItem = r10;
        r10.setOnContentClickListener(this);
        OListItemSettings r11 = (OListItemSettings) findViewById(R.id.habit_dual_sim);
        this.habitDualSim = r11;
        r11.setOnClickListener(this);
        OListItemSettings r12 = (OListItemSettings) findViewById(R.id.habit_single_sim);
        this.habitSingleSim = r12;
        r12.setOnClickListener(this);
        this.habitTips = (TextView) findViewById(R.id.multi_sim_using_habit_tips);
        this.mHabitSmsPic = (ImageView) findViewById(R.id.iv_sim_setting_sms);
        this.mHabitDialPic = (ImageView) findViewById(R.id.iv_sim_setting_dial_pad);
        this.mHabitDialLabel = (TextView) findViewById(R.id.label_of_dial_pad);
        this.mTitleRes = R.string.multi_sim_settings_title;
        INetworkStatsService r13 = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mService = r13;
        this.mSession = r13.openSession();     // Catch: RemoteException -> L14
    L16:
        this.mReceiver = new AirplaneModeBroadcastReceiver(this, null);
        setupBackBtnOnTitle();
        TelephonyManager r14 = TelephonyManager.from(this);
        this.mTelephonyManager = r14;
        r14.createForSubscriptionId(this.SUB_ID_1).listen(this.mPhoneStateListener1, 32);
        this.mTelephonyManager.createForSubscriptionId(this.SUB_ID_2).listen(this.mPhoneStateListener2, 32);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewById(R.id.page_container));
        if (getMultiSimUsingHabit() == 1) goto L19;
        setMultiSimUsingHabit(1);
        DatabaseHelper.getInstance(this.mContext).updateMultiSimSetting();
    L19:
        this.mTitle.post(new AnonymousClass8(this));
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L6:
        if (isSIMForDataChecked(1) == false) goto L8;
        OCardListItemUtils.setCustomEndTipTextView(this.networkItem, getString(R.string.multi_sim_sub_2_title));
        goto L8
    }

    private boolean isNetIntelligentDualSimChecked() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), RADIO_SMART_DATA_SWITCH_ENABLE, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void updateNetIntelligentDualSimChecked(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), RADIO_SMART_DATA_SWITCH_ENABLE, r2 ? 1 : 0);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void setTitle(CharSequence r1) {
        if (this.mTitle == null) goto L6;
        this.mTitle.setCenterTitle(this.mTitleRes);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.MultiSimSettings$9] */
    public void com_android_settings_MultiSimSettings__onStart$___twin___() {
        super.onStart();
        new AnonymousClass9(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void com_android_settings_MultiSimSettings__onResume$___twin___() {
        super.onResume();
        this.mSimStateChangeHandler.register();
        if (SettingsFeature.isMtkDevice() == true) goto L5;
        this.mSubManager.addOnSubscriptionsChangedListener(this.listener);
    L6:
        registerForAirplaneMode();
        if (isAirplaneModeOn(this) == false) goto L10;
        finish();
        return;
    L10:
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_dialpad_left_mode", 1) == 1) goto L14;
        r2 = false;
    L14:
        this.mIsLeftHandDialMode = r2;
        scheduleUpdateUI();
        return;
    L5:
        registerSimActiveStateReceiverForMtk();
        goto L6
    }

    public void com_android_settings_MultiSimSettings__onDestroy$___twin___() {
        super.onDestroy();
        this.mSession.close();     // Catch: RemoteException -> L5
    L7:
        this.mTelephonyManager.createForSubscriptionId(this.SUB_ID_1).listen(this.mPhoneStateListener1, 0);
        this.mTelephonyManager.createForSubscriptionId(this.SUB_ID_2).listen(this.mPhoneStateListener2, 0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void scheduleUpdateUI() {
        this.mHandler.removeMessages(100);
        this.mHandler.sendEmptyMessageDelayed(100, 50);
    }

    private void registerSimActiveStateReceiverForMtk() {
        if (SettingsFeature.isMtkDevice() == false) goto L6;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mtkSimActiveStateChangeReceiver, new IntentFilter(""), 2);
        return;
    }

    private void unregisterSimActiveStateReceiverForMtk() {
        if (SettingsFeature.isMtkDevice() == false) goto L6;
        unregisterReceiver(this.mtkSimActiveStateChangeReceiver);
        return;
    }

    public void com_android_settings_MultiSimSettings__onPause$___twin___() {
        super.onPause();
        this.mSimStateChangeHandler.unregister();
        if (SettingsFeature.isMtkDevice() == true) goto L5;
        this.mSubManager.removeOnSubscriptionsChangedListener(this.listener);
    L6:
        unregisterForAirplaneMode();
        return;
    L5:
        unregisterSimActiveStateReceiverForMtk();
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.sub1Item.getContentContainer()) goto L6;
        activeSim(0);
        SettingsTracker.onItemClick(601);
        return;
    L6:
        if (r5 != this.sub2Item.getContentContainer()) goto L9;
        activeSim(1);
        SettingsTracker.onItemClick(602);
        return;
    L9:
        if (r5 != this.dialItem.getContentContainer()) goto L12;
        subscriptionSimConfig(0, this.dialItem.getTitle());
        SettingsTracker.onItemClick(603);
        return;
    L12:
        if (r5 != this.smsItem.getContentContainer()) goto L15;
        showSMSPopMenu();
        SettingsTracker.onItemClick(604);
        return;
    L15:
        if (r5 != this.pinItem.getContentContainer()) goto L18;
        showPinSettings();
        SettingsTracker.onItemClick(607);
        return;
    L18:
        if (r5.getId() != R.id.habit_dual_sim) goto L21;
        setMultiSimUsingHabit(0);
        DatabaseHelper.getInstance(this.mContext).updateMultiSimSetting();
        return;
    L21:
        if (r5.getId() != R.id.habit_single_sim) goto L30;
        setMultiSimUsingHabit(1);
        DatabaseHelper.getInstance(this.mContext).updateMultiSimSetting();
        return;
    }

    private void showNetworkPopMenu() {
        final ArrayList r0 = new ArrayList();
        String r2 = MultiSimUtil.getSimName(this, 0);
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.add(r2);
    L6:
        String r3 = MultiSimUtil.getSimName(this, 1);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.add(r3);
    L10:
        ArrayList r4 = new ArrayList();
        r4.add(new Item((String) r0.get(0), isSIMForDataChecked(0)));
        r4.add(new Item((String) r0.get(1), isSIMForDataChecked(1)));
        this.mNetworkPopover = OPopoverHelper.showPopoverList(this.mActivity, this.networkItem.getCardContainer(), r4, new AnonymousClass10(this, r0), true);
        return;
    L9:
        r0.add(getString(R.string.multi_sim_sub_2_title));
        goto L10
    L5:
        r0.add(getString(R.string.multi_sim_sub_1_title));
        goto L6
    }

    private void setUserPrefDataSubIdInDb(int r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_USER_PREF_DATA_SUB, r2);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != ((OSwitch) this.mNetNonDataSim.getCustomEndView())) goto L6;
        setTempDDSEnabled(r3);
        SettingsTracker.onSwitchStatus("A131004", "undata_sim", r3);
        return;
    L6:
        if (r2 != this.mNetIntelligentDualSim.getEndSwitch()) goto L10;
        updateNetIntelligentDualSimChecked(r3);
        return;
    }

    private void setSIMSubscription(int r7, int r8) {
        int r0 = getSubIdBySlotId(this.mSubManager, r8);
        if (r7 == 2) goto L5;
        if (r7 != 1) goto L16;
        getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.SET_SIM_SUBSCRIPTION_FOR_SMS, Integer.toString(r0), null);
        this.mSubManager.setDefaultSmsSubId(r0);
        return;
    L16:
        return;
    L5:
        if (isPhoneSimLocked(r8) == false) goto L7;
        showPinLockedDialog(r8);
        return;
    L7:
        getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.SET_SIM_SUBSCRIPTION_FOR_DATA, Integer.toString(r0), null);
        if (Features.isFeatureCMCCEnabled(this).booleanValue() == false) goto L10;
        ToastUtils.show(this, getResources().getString(R.string.set_dds_success, new Object[]{Integer.toString(r8 + 1)}));
    L10:
        this.mSubManager.setDefaultDataSubId(r0);
        setUserPrefDataSubIdInDb(r0);
    }

    private boolean isPhoneSimLocked(int r3) {
        if (TelephonyManager.getDefault().isMultiSimEnabled() == false) goto L12;
        TelephonyManager r2 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r2 == null) goto L13;
        int r4 = r2.getSimState(r3);
        if (2 != r4) goto L9;
    L10:
        return true;
    L9:
        if (3 == r4) goto L10;
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    private void showPinLockedDialog(final int r7) {
        int r1 = r7 + 1;
        String r0 = getString(R.string.default_sim_name) + HanziToPinyin.Token.SEPARATOR + r1;
        String r2 = MultiSimUtil.getSimName(this, r7);
        if (r0.equals(r2) == false) goto L5;
        r2 = String.valueOf(r1);
    L5:
        new AlertDialog.Builder(this).setTitle(getString(R.string.dialog_sim_locked_title, new Object[]{r2})).setMessage(getString(R.string.dialog_sim_locked_content, new Object[]{r2})).setPositiveButton(R.string.ok, new AnonymousClass11(this, r7)).setNegativeButton(R.string.cancel, null).create().show();
    }

    private void startActivityAcrossApp(Intent r1) {
        startActivity(r1);
    }

    private void startActivityInternal(Intent r1) {
        Utils.startActivity(this, r1);
    }

    private void startPinActivity(int r4) {
        Intent r0 = new Intent();
        r0.setClassName("com.android.phone", "com.bytedanceos.phone.settings.settings.EnableIccPinScreen");
        r0.putExtra("show_input_dialog_on_start", true);
        r0.putExtra("subscription", r4);
        r0.putExtra("back_text", getIntent().getStringExtra("title"));
        startActivityAcrossApp(r0);
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

    private int getMultiSimUsingHabit() {
        return MultiSimUtil.getMultiSimUsingHabit(this);
    }

    private boolean isClassicDialPad() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_dialpad_change_layout", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setMultiSimUsingHabit(int r2) {
        MultiSimUtil.setMultiSimUsingHabit(this, r2);
        updateUi();
        SettingsTracker.onStatus("A131004", "double_sim", Integer.valueOf(r2));
    }

    public static int getSubIdBySlotId(SubscriptionManager r1, int r2) {
        int[] r3 = SubscriptionManager.getSubId(r2);
        if (r3 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r3.length <= 0) goto L8;
        return r3[0];
    }

    private float caculateTextWidth(TextView r2) {
        Paint r1 = new Paint();
        r1.setTextSize(r2.getTextSize());
        if (r2.getText() != null) goto L7;
        return 0.0f;
    L7:
        return r1.measureText(r2.getText().toString());
    }

    private void updateUi() {
        if (Utils.hasMultiSimInDevice() == true) goto L6;
        finish();
        return;
    L6:
        String r0 = getResources().getString(R.string.multi_sim_state_none);
        OCardListItem r1 = this.sub1Item;
        if (isCardAbsentOrError(0) == false) goto L9;
    L11:
        boolean r3 = false;
    L12:
        r1.setEnabled(r3);
        this.sub1Item.setTitle(MultiSimUtil.getSimName(this, 0));
        Bundle r2 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_NUM, null, null);
        boolean r4 = this.sub1Item.isEnabled();
        int r5 = R.string.multi_sim_state_on;
        if (r4 == false) goto L15;
    L18:
        OCardListItem r6 = this.sub1Item;
        if (SIMUtils.isSubActive(this, 0) == false) goto L21;
        int r7 = R.string.multi_sim_state_on;
    L22:
        OCardListItemUtils.setCustomEndTipTextView(r6, getString(r7));
        if (r2 == null) goto L25;
        this.sub1Item.setSubTitle(r2.getString(String.valueOf(0)));
        this.sub1Item.showSubTitle(true);
    L25:
        OCardListItem r8 = this.sub2Item;
        if (isCardAbsentOrError(1) == false) goto L28;
    L30:
        boolean r9 = false;
    L31:
        r8.setEnabled(r9);
        this.sub2Item.setTitle(MultiSimUtil.getSimName(this, 1));
        if (this.sub2Item.isEnabled() == false) goto L34;
    L37:
        OCardListItem r10 = this.sub2Item;
        if (SIMUtils.isSubActive(this, 1) == true) goto L41;
        r5 = R.string.multi_sim_state_off;
    L41:
        OCardListItemUtils.setCustomEndTipTextView(r10, getString(r5));
        if (r2 == null) goto L45;
        this.sub2Item.setSubTitle(r2.getString(String.valueOf(1)));
        this.sub2Item.showSubTitle(true);
    L45:
        if (getMultiSimUsingHabit() != 0) goto L47;
        boolean r11 = true;
    L48:
        updateHabitView(r11);
        this.mIccCardCount = 0;
        TelephonyManager r12 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L49:
        int r16 = MAX_SUBSCRIPTIONS;
        if (r13 >= r16) goto L68;
        if (isCardAbsentOrError(r13) == true) goto L55;
        this.mIccCardCount++;
    L55:
        if (SIMUtils.isSubActive(this, r13) == false) goto L58;
        r14 = r14 + 1;
    L58:
        if (Features.isFeatureCMCCEnabled(this).booleanValue() == false) goto L67;
        if (r12 == null) goto L67;
        String r17 = r12.getSimOperatorNumericForPhone(r13);
        if ("46000".equals(r17) == false) goto L63;
    L66:
        r15 = r15 + 1;
        goto L67
    L63:
        if ("46002".equals(r17) == true) goto L66;
        if ("46007".equals(r17) == true) goto L66;
    L67:
        r13 = r13 + 1;
        goto L49
    L68:
        int r18 = this.mIccCardCount;
        if (r18 != 0) goto L73;
        finish();
        return;
    L73:
        if (r18 != 1) goto L75;
        this.dialItem.setEnabled(false);
        this.smsItem.setEnabled(false);
        this.habitDualSim.setEnabled(false);
        this.habitSingleSim.setEnabled(false);
    L95:
        int r19 = 3;
        int r20 = 8;
        if (Features.isFeatureCMCCEnabled(this).booleanValue() == false) goto L112;
        OLog.d(TAG, "cmccSimCount = " + r15);
        OCardListItem r21 = this.networkItem;
        if (r14 < 2) goto L102;
        if (r15 == 1) goto L102;
        int r22 = 0;
    L103:
        r21.setVisibility(r22);
        OCardListItem r23 = this.smsItem;
        if (this.networkItem.getVisibility() != 0) goto L106;
        r19 = 2;
    L106:
        r23.setCardPosition(r19);
        OCardListItem r24 = this.mNetIntelligentDualSim;
        if (r14 < 2) goto L111;
        if (r15 == 1) goto L111;
        r20 = 0;
    L111:
        r24.setVisibility(r20);
    L125:
        if (SettingsFeature.isSupportNetOnNonDataSim() == false) goto L127;
        this.mNetNonDataSim.setVisibility(this.networkItem.getVisibility());
    L127:
        setSubscriptionSubtitle(0);
        setSubscriptionSubtitle(1);
        setSubscriptionSubtitle(2);
        ((OSwitch) this.mNetNonDataSim.getCustomEndView()).setChecked(isTempDDSEnabled());
        return;
    L102:
        r22 = 8;
        goto L103
    L112:
        OCardListItem r25 = this.networkItem;
        if (r14 >= 2) goto L115;
        int r26 = 8;
    L116:
        r25.setVisibility(r26);
        OCardListItem r27 = this.smsItem;
        if (this.networkItem.getVisibility() != 0) goto L119;
        r19 = 2;
    L119:
        r27.setCardPosition(r19);
        OCardListItem r28 = this.mNetIntelligentDualSim;
        if (r14 < 2) goto L123;
        r20 = 0;
    L123:
        r28.setVisibility(r20);
        goto L125
    L115:
        r26 = 0;
        goto L116
    L75:
        if (r18 <= 1) goto L94;
        if (r18 > r16) goto L94;
        if (SIMUtils.isSubActive(this, 0) == true) goto L80;
    L82:
        boolean r29 = false;
    L83:
        OCardListItem r30 = this.dialItem;
        if (r29 == false) goto L87;
        if (r11 == true) goto L87;
        boolean r31 = true;
    L88:
        r30.setEnabled(r31);
        OCardListItem r32 = this.smsItem;
        if (r29 == false) goto L92;
        if (r11 == true) goto L92;
        boolean r33 = true;
    L93:
        r32.setEnabled(r33);
        this.habitDualSim.setEnabled(r29);
        this.habitSingleSim.setEnabled(r29);
    L92:
        r33 = false;
    L87:
        r31 = false;
        goto L88
    L80:
        if (SIMUtils.isSubActive(this, 1) == false) goto L82;
        r29 = true;
    L94:
        OLog.d(TAG, "Invalid card count");
        goto L95
    L47:
        r11 = false;
        goto L48
    L34:
        if (isInCallingState() == true) goto L37;
        this.sub2Item.showSubTitle(false);
        OCardListItemUtils.setCustomEndTipTextView(this.sub2Item, r0);
        goto L45
    L28:
        if (isInCallingState() == true) goto L30;
        r9 = true;
        goto L31
    L21:
        r7 = R.string.multi_sim_state_off;
        goto L22
    L15:
        if (isInCallingState() == true) goto L18;
        this.sub1Item.showSubTitle(false);
        OCardListItemUtils.setCustomEndTipTextView(this.sub1Item, r0);
        goto L25
    L9:
        if (isInCallingState() == true) goto L11;
        r3 = true;
        goto L12
    }

    private void updateHabitView(boolean r5) {
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageResource(R.drawable.o_card_list_item_tail_icon_mark);
        if (r5 == false) goto L5;
        this.habitDualSim.setTrailingView(r0);
        this.habitDualSim.mTrailingElement.setVisibility(0);
        this.habitSingleSim.mTrailingElement.setVisibility(4);
    L6:
        boolean r1 = isClassicDialPad();
        TextView r2 = this.mHabitDialLabel;
        if (r1 == false) goto L9;
        int r3 = R.string.sim_settings_dialpad_symmetry;
    L10:
        r2.setText(r3);
        if (r5 == false) goto L20;
        this.habitTips.setText(R.string.multi_sim_using_habit_tips);
        this.mHabitSmsPic.setImageResource(R.drawable.sim_card_b_message);
        if (r1 == false) goto L15;
        this.mHabitDialPic.setImageResource(R.drawable.sim_card_b_classic);
        return;
    L15:
        ImageView r6 = this.mHabitDialPic;
        if (this.mIsLeftHandDialMode == false) goto L18;
        int r4 = R.drawable.sim_card_b_singlehand_left;
    L19:
        r6.setImageResource(r4);
        return;
    L18:
        r4 = R.drawable.sim_card_b_singlehand_right;
        goto L19
    L20:
        this.habitTips.setText(R.string.single_sim_using_habit_tips);
        this.mHabitSmsPic.setImageResource(R.drawable.sim_card_a_message);
        if (r1 == false) goto L23;
        this.mHabitDialPic.setImageResource(R.drawable.sim_card_a_classic);
        return;
    L23:
        ImageView r7 = this.mHabitDialPic;
        if (this.mIsLeftHandDialMode == false) goto L26;
        int r8 = R.drawable.sim_card_a_singlehand_left;
    L27:
        r7.setImageResource(r8);
        return;
    L26:
        r8 = R.drawable.sim_card_a_singlehand_right;
        goto L27
    L9:
        r3 = R.string.sim_settings_dialpad_single_hand;
        goto L10
    L5:
        this.habitSingleSim.setTrailingView(r0);
        this.habitSingleSim.mTrailingElement.setVisibility(0);
        this.habitDualSim.mTrailingElement.setVisibility(4);
        goto L6
    }

    private boolean isSIMForDataChecked(int r2) {
        if (MultiSimSelectSubscription.getPhoneIdFor(this.mSubManager, 2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    private void setSubscriptionSubtitle(int r4) {
        int r0 = MultiSimSelectSubscription.getPhoneIdFor(this.mSubManager, r4);
        OLog.d(TAG, "getSubscriptionSubtitle type:" + r4 + "  subscription:" + r0);
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L11;
        if (r0 != (-1)) goto L21;
        if (r4 != 0) goto L25;
        OCardListItemUtils.setCustomEndTipTextView(this.dialItem, getString(R.string.multi_sim_ask_every_time));
        return;
    L25:
        return;
    L21:
        return;
    L11:
        String r1 = getSimName(this, r0);
        if (r4 == 0) goto L19;
        if (r4 != 1) goto L15;
        OCardListItemUtils.setCustomEndTipTextView(this.smsItem, r1);
        return;
    L15:
        if (r4 != 2) goto L26;
        OCardListItemUtils.setCustomEndTipTextView(this.networkItem, r1);
        return;
    L26:
        return;
    L19:
        OCardListItemUtils.setCustomEndTipTextView(this.dialItem, r1);
    }

    public static String getSimName(Context r0, int r1) {
        return MultiSimUtil.getSimName(r0, r1);
    }

    public static boolean isCardAbsentOrError(int r2) {
        if (r2 >= MAX_SUBSCRIPTIONS) goto L10;
        if (r2 >= 0) goto L6;
        return true;
    L6:
        if (MultiSimAdapter.getSimState(r2) == 1) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    private static ITelephony getTelephony() {
        return ITelephony.Stub.asInterface(ServiceManager.checkService(MultiSimAdapter.PHONE_KEY));
    }

    public static boolean isSlotActive(int r3) {
        boolean r1 = true;
        if (MultiSimAdapter.isMultiSimEnabled() == false) goto L11;
        ITelephony r0 = getTelephony();     // Catch: RemoteException -> L9
        if (r0 == null) goto L18;
        if (r0.getISmtEx().getCurrentUiccCardProvisioningStatus(r3) != 0) goto L15;
    L13:
        r1 = false;
    L15:
        return r1;
    L18:
        return false;
    L9:
        OLog.e("MultiSimAdapter", "Failed to call getCurrentUiccCardProvisioningStatus due to remote exception");
        return false;
    L11:
        if (MultiSimAdapter.getSimState(r3) == 1) goto L13;
        goto L13
    }

    public static boolean isCardActivate(int r3) {
        if (r3 >= MAX_SUBSCRIPTIONS) goto L11;
        if (r3 >= 0) goto L6;
        return false;
    L6:
        if (MultiSimAdapter.getSimState(r3) != 1) goto L8;
        return false;
    L8:
        if (isSlotActive(r3) == true) goto L10;
        return false;
    L10:
        return true;
    L11:
        return false;
    }

    private void activeSim(int r4) {
        Intent r0 = new Intent(this, MultiSimSubscription.class);
        r0.putExtra(EXTRA_SIM_INDEX, r4);
        r0.putExtra("back_text", getString(this.mTitleRes));
        r0.putExtra("title", getString(this.simDefNameRes[r4]));
        startActivityInternal(r0);
    }

    private void subscriptionSimConfig(int r3, CharSequence r4) {
        Intent r0 = new Intent(this, MultiSimSelectSubscription.class);
        r0.putExtra(EXTRA_SUBSCRIPTION_TYPE, r3);
        r0.putExtra("back_text", getString(this.mTitleRes));
        r0.putExtra("title", r4);
        startActivityInternal(r0);
    }

    private boolean isSIMFForSMSChecked(int r2) {
        if (MultiSimSelectSubscription.getPhoneIdFor(this.mSubManager, 1) == r2) goto L7;
        return false;
    L7:
        return true;
    }

    private void showSMSPopMenu() {
        final ArrayList r0 = new ArrayList();
        String r2 = MultiSimUtil.getSimName(this, 0);
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.add(r2);
    L6:
        String r3 = MultiSimUtil.getSimName(this, 1);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.add(r3);
    L10:
        ArrayList r4 = new ArrayList();
        r4.add(new Item((String) r0.get(0), isSIMFForSMSChecked(0)));
        r4.add(new Item((String) r0.get(1), isSIMFForSMSChecked(1)));
        this.mSMSPopover = OPopoverHelper.showPopoverList(this.mActivity, this.smsItem.getCardContainer(), r4, new AnonymousClass12(this, r0), true);
        return;
    L9:
        r0.add(getString(R.string.multi_sim_sub_2_title));
        goto L10
    L5:
        r0.add(getString(R.string.multi_sim_sub_1_title));
        goto L6
    }

    private void registerForAirplaneMode() {
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, this.mIntentFilter);
    }

    private void unregisterForAirplaneMode() {
        unregisterReceiver(this.mReceiver);
    }

    private void showPinSettings() {
        Intent r0 = new Intent();
        boolean r1 = false;
        if (SIMUtils.isSubActive(this, 0) == true) goto L5;
    L7:
        if (r1 == false) goto L9;
        String r2 = "com.bytedanceos.phone.settings.settings.msim.MSimPinSimSelection";
    L10:
        r0.setClassName("com.android.phone", r2);
        r0.putExtra("back_text", getString(R.string.multi_sim_settings_title));
        startActivityAcrossApp(r0);
        return;
    L9:
        r2 = "com.bytedanceos.phone.settings.settings.EnableIccPinScreen";
        goto L10
    L5:
        if (SIMUtils.isSubActive(this, 1) == false) goto L7;
        r1 = true;
        goto L7
    }

    private boolean isAirplaneModeOn(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isInCallingState() {
        if (this.mPhone1CallState == 0) goto L5;
    L8:
        return true;
    L5:
        if (this.mPhone2CallState != 0) goto L8;
        return false;
    }

    private void updateDataSimItemEnabledState(boolean r3) {
        this.sub1Item.setEnabled(!r3);
        this.sub2Item.setEnabled(!r3);
    }

    private boolean isTempDDSEnabled() {
        return this.mTempDDSController.isChecked();
    }

    private void setTempDDSEnabled(boolean r1) {
        this.mTempDDSController.setChecked(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MultiSimSettings r1) {
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onCreate(MultiSimSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MultiSimSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(MultiSimSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(MultiSimSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        MultiSimSettings r5 = r4;
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
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(MultiSimSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_MultiSimSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(MultiSimSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_MultiSimSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onStart(MultiSimSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_MultiSimSettings__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onResume(MultiSimSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_MultiSimSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(MultiSimSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onPause(MultiSimSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_MultiSimSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(MultiSimSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        MultiSimSettings r5 = r3;
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
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onStop(MultiSimSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_MultiSimSettings__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_MultiSimSettings_com_obric_hook_lancet_PrivacyHook_onDestroy(MultiSimSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_MultiSimSettings__onDestroy$___twin___();
    }
}
