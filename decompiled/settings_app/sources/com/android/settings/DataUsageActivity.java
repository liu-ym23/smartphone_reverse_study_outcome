package com.android.settings;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.NtpTrustedTime;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.internal.telephony.ITelephony;
import com.android.settings.base.BaseActivity;
import com.android.settings.net.ChartData;
import com.android.settings.net.ChartDataLoader;
import com.android.settings.sim.SIMUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedanceos.tencent.ICallback;
import com.bytedanceos.tencent.ITencent;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageActivity extends BaseActivity implements View.OnClickListener {
    private static final int CORRECTION_STATUS_DONE = 1;
    private static final int CORRECTION_STATUS_NONE = -1;
    private static final int CORRECTION_STATUS_NOW = 0;
    private static final int ENABLE_ALL_NET_RESTRICT_BG = 1;
    private static final String EXTRA_RECHARGE_NUMBER_KEY = "phone_number";
    private static final String EXTRA_RECHARGE_TYPE_KEY = "recharge_type";
    private static int FIRST_SIM_INDEX = 0;
    private static final String LAST_SUBSCRIBER_PROP = "persist.radio.last.subscriber";
    private static final int LOADER_CHART_DATA = 2;
    public static final int MSG_REFRESH_BTN = 2;
    public static final int MSG_REFRESH_NETWORK = 3;
    public static final int MSG_SIM_CHANGE = 4;
    public static final int MSG_TRAFfICT_NOTIFY = 1;
    private static final String RECHARGE_ACTIVITY = "com.bytedanceos.recharge.activity.RechargeServiceActivity";
    private static final String RECHARGE_PACKAGE = "com.bytedanceos.recharge";
    private static final String RESTRICT_ALL_NET_BG_STATE = "restrict_all_net_background_state";
    private static int SECOND_SIM_INDEX = 1;
    private static final int SETTING_BTN_ID = 3;
    private static final String SIM1_STATUS = "SIM1_CORRECTION_STATUS";
    private static final String SIM2_STATUS = "SIM2_CORRECTION_STATUS";
    public static final String SUBSCRIPTION_KEY = "slot";
    private static final int TAB1_VIEW = 1;
    private static final int TAB2_VIEW = 2;
    private static String TAG = "dataUsage";
    private static final int TYPE_4G_LEFT = 2;
    private static final int TYPE_MONTH_LEFT = 4;
    private static final int TYPE_MONTH_USED = 1;
    private static final int TYPE_SPARE_TIME_LEFT = 3;
    private static final int TYPE_TODAY_USED = 0;
    public static final int TYPE_WEB_TRAFFIC_ORDER = 1;
    private boolean isSlot1Checked;
    private boolean isSlot1Init;
    private boolean isSlot2Checked;
    private boolean isSlot2Init;
    private boolean isTencentSDKEnabled;
    TextView m4GLeft;
    TextView m4GLeftTitle;
    TextView m4GLeftUnit;
    LinearLayout m4GLeftView;
    ListContentItemText mBgControllItem;
    private ICallback.Stub mCallback;
    private AlertDialog mChargeInstallDialog;
    private ChartData mChartData;
    private final LoaderManager.LoaderCallbacks<ChartData> mChartDataCallbacks;
    private int mCorrectingSlot;
    private int mCurrentSlot;
    TextView mDataUsageCorrect;
    ListContentItemText mDataUsageSettingItem;
    ListContentItemText mDataUsageSortItem;
    TextView mDayToSettlement;
    TextView mDayToSettlementUnit;
    RelativeLayout mDayToSettlementView;
    private boolean mIsFromSecurity;
    TextView mMonthLeft;
    TextView mMonthLeftUnit;
    TextView mMonthUsed;
    TextView mMonthUsedTitle;
    TextView mMonthUsedUnit;
    RelativeLayout mMonthUsedView;
    ListContentItemSwitch mNetworkControl;
    private boolean mNotifyLater;
    ListContentItemText mRechargeItem;
    TextView mSettlementTitle;
    private boolean mSim1Activied;
    private boolean mSim1Exist;
    private long mSim1Month;
    private long mSim1Today;
    TextView mSim1View;
    private boolean mSim2Activied;
    private boolean mSim2Exist;
    private long mSim2Month;
    private long mSim2Today;
    TextView mSim2View;
    OSectionTitleBar mSimCardName;
    private BroadcastReceiver mSimReceiver;
    TextView mSpareTimeLeft;
    TextView mSpareTimeLeftTitle;
    TextView mSpareTimeLeftUnit;
    LinearLayout mSpareTimeLeftView;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;
    LinearLayout mTabView;
    TelephonyManager mTelephonyMgr;
    private NetworkTemplate mTemplate;
    public ITencent mTencentService;
    private final ServiceConnection mTencentServiceConnection;
    TextView mTodayUsed;
    TextView mTodayUsedTitle;
    TextView mTodayUsedUnit;
    RelativeLayout mTodayUsedView;
    RelativeLayout relativeLayout;
    private int[] sim1Data;
    private int[] sim2Data;
    public Handler uiHandler;

    static {
    }

    public void com_android_settings_DataUsageActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_DataUsageActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DataUsageActivity() {
        this.mCurrentSlot = 0;
        this.mTencentService = null;
        this.mCorrectingSlot = -1;
        this.isSlot1Init = false;
        this.isSlot2Init = false;
        this.isSlot1Checked = false;
        this.isSlot2Checked = false;
        this.mNotifyLater = false;
        this.mIsFromSecurity = false;
        this.mSim1Activied = false;
        this.mSim2Activied = false;
        this.mSim1Exist = false;
        this.mSim2Exist = false;
        this.isTencentSDKEnabled = false;
        this.mChartDataCallbacks = new AnonymousClass4(this);
        this.mTencentServiceConnection = new AnonymousClass5(this);
        this.mCallback = new AnonymousClass6(this);
        this.mSimReceiver = new AnonymousClass7(this);
    }

    static /* synthetic */ AlertDialog access$000(DataUsageActivity r0) {
        return r0.mChargeInstallDialog;
    }

    static /* synthetic */ AlertDialog access$002(DataUsageActivity r0, AlertDialog r1) {
        r0.mChargeInstallDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$100(DataUsageActivity r0) {
        r0.refreshUI();
    }

    static /* synthetic */ void access$1000(DataUsageActivity r0) {
        r0.updateDetailData();
    }

    static /* synthetic */ ICallback.Stub access$1100(DataUsageActivity r0) {
        return r0.mCallback;
    }

    static /* synthetic */ int access$1200(DataUsageActivity r0) {
        return r0.mCorrectingSlot;
    }

    static /* synthetic */ int access$1202(DataUsageActivity r0, int r1) {
        r0.mCorrectingSlot = r1;
        return r1;
    }

    static /* synthetic */ int access$1300() {
        return FIRST_SIM_INDEX;
    }

    static /* synthetic */ int access$1400() {
        return SECOND_SIM_INDEX;
    }

    static /* synthetic */ boolean access$1502(DataUsageActivity r0, boolean r1) {
        r0.isSlot1Checked = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1602(DataUsageActivity r0, boolean r1) {
        r0.isSlot2Checked = r1;
        return r1;
    }

    static /* synthetic */ int access$1700(DataUsageActivity r0) {
        return r0.mCurrentSlot;
    }

    static /* synthetic */ void access$200(DataUsageActivity r0) {
        r0.updateBtnStatus();
    }

    static /* synthetic */ void access$300(DataUsageActivity r0, boolean r1) {
        r0.updateSimCardInfo(r1);
    }

    static /* synthetic */ boolean access$400(DataUsageActivity r0) {
        return r0.mNotifyLater;
    }

    static /* synthetic */ boolean access$402(DataUsageActivity r0, boolean r1) {
        r0.mNotifyLater = r1;
        return r1;
    }

    static /* synthetic */ int[] access$500(DataUsageActivity r0) {
        return r0.sim1Data;
    }

    static /* synthetic */ int[] access$502(DataUsageActivity r0, int[] r1) {
        r0.sim1Data = r1;
        return r1;
    }

    static /* synthetic */ int[] access$600(DataUsageActivity r0) {
        return r0.sim2Data;
    }

    static /* synthetic */ int[] access$602(DataUsageActivity r0, int[] r1) {
        r0.sim2Data = r1;
        return r1;
    }

    static /* synthetic */ String access$700() {
        return TAG;
    }

    static /* synthetic */ INetworkStatsSession access$800(DataUsageActivity r0) {
        return r0.mStatsSession;
    }

    static /* synthetic */ ChartData access$902(DataUsageActivity r0, ChartData r1) {
        r0.mChartData = r1;
        return r1;
    }

    public void com_android_settings_DataUsageActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        boolean r8 = Utils.needJumpToSecurity(this, 0);
        int r0 = R.string.data_usage_title;
        if (r8 == false) goto L11;
        Intent r9 = new Intent();
        r9.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.datausage.DataUsageActivity");
        r9.putExtra("title_id", R.string.network_background_control);
        if (isFromSecurityCenter() == false) goto L7;
        String r3 = getString(R.string.data_usage_title);
    L8:
        r9.putExtra("back_text", r3);
        r9.putExtra(BaseActivity.EXTRA_FROM_SECURITY, isFromSecurityCenter());
        startActivity(r9);     // Catch: ActivityNotFoundException -> L25
        finish();     // Catch: ActivityNotFoundException -> L25
        return;
    L7:
        r3 = getString(R.string.data_usage_title_long);
    L11:
        setContentView(R.layout.data_usage_activity_layout_main);
        preloadRechargeProcess();
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        if (this.isTencentSDKEnabled == false) goto L14;
        Intent r4 = new Intent();
        r4.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.datausage.TencentService");
        bindService(r4, this.mTencentServiceConnection, 1);
    L14:
        this.mTelephonyMgr = (TelephonyManager) getApplicationContext().getSystemService(MultiSimAdapter.PHONE_KEY);
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        OFloatingTitleBar r2 = this.mTitle;
        if (isFromSecurityCenter() == true) goto L18;
        r0 = R.string.data_usage_title_long;
    L18:
        r2.setCenterTitle(r0);
        this.mMonthLeft = (TextView) findViewById(R.id.scanning_size);
        this.mMonthLeftUnit = (TextView) findViewById(R.id.scanning_size_unit);
        this.relativeLayout = (RelativeLayout) findViewById(R.id.data_usage_detail);
        this.mTodayUsedTitle = (TextView) findViewById(R.id.today_used_title);
        this.mMonthUsedTitle = (TextView) findViewById(R.id.month_used_title);
        this.mSettlementTitle = (TextView) findViewById(R.id.day_to_settlement_title);
        this.m4GLeftTitle = (TextView) findViewById(R.id.data_4G_left_title);
        this.mSpareTimeLeftTitle = (TextView) findViewById(R.id.data_spare_time_left_title);
        this.mTodayUsedView = (RelativeLayout) findViewById(R.id.today_used_view);
        this.mMonthUsedView = (RelativeLayout) findViewById(R.id.month_used_view);
        this.mDayToSettlementView = (RelativeLayout) findViewById(R.id.day_to_settlement_view);
        this.m4GLeftView = (LinearLayout) findViewById(R.id.data_usage_4G_left_view);
        this.mSpareTimeLeftView = (LinearLayout) findViewById(R.id.spare_time_left_view);
        this.mTodayUsed = (TextView) findViewById(R.id.today_used);
        this.mTodayUsedUnit = (TextView) findViewById(R.id.today_used_unit);
        this.mMonthUsed = (TextView) findViewById(R.id.month_used);
        this.mMonthUsedUnit = (TextView) findViewById(R.id.month_used_unit);
        this.m4GLeft = (TextView) findViewById(R.id.data_usage_4G_left);
        this.mSpareTimeLeft = (TextView) findViewById(R.id.spare_time_left);
        this.mDayToSettlement = (TextView) findViewById(R.id.day_to_settlement);
        this.m4GLeftUnit = (TextView) findViewById(R.id.data_usage_4G_left_unit);
        this.mSpareTimeLeftUnit = (TextView) findViewById(R.id.spare_time_left_unit);
        this.mDayToSettlementUnit = (TextView) findViewById(R.id.day_to_settlement_unit);
        this.mDataUsageCorrect = (TextView) findViewById(R.id.item_datausage_correcting);
        LinearLayout r1 = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tab_view_two_card, null);
        this.mTabView = r1;
        this.mSim1View = (TextView) r1.findViewById(R.id.top_tab_sim1);
        this.mSim2View = (TextView) this.mTabView.findViewById(R.id.top_tab_sim2);
        this.mRechargeItem = (ListContentItemText) findViewById(R.id.item_recharge);
        this.mBgControllItem = (ListContentItemText) findViewById(R.id.network_optimization_settings);
        this.mNetworkControl = (ListContentItemSwitch) findViewById(R.id.network_optimization_control);
        this.mDataUsageSortItem = (ListContentItemText) findViewById(R.id.item_data_usage_sort);
        this.mDataUsageSettingItem = (ListContentItemText) findViewById(R.id.item_data_usage_settings);
        this.mSimCardName = (OSectionTitleBar) findViewById(R.id.sim_card_name);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-2, -2);
        r5.addRule(13);
        this.mTabView.setLayoutParams(r5);
        this.mTitle.addView(this.mTabView);
        this.mSim1View.setId(1);
        this.mSim2View.setId(2);
        this.mSim1View.setSelected(true);
        this.mSim1View.setOnClickListener(this);
        this.mSim2View.setOnClickListener(this);
        this.mRechargeItem.setOnClickListener(this);
        this.mDataUsageCorrect.setOnClickListener(this);
        this.mBgControllItem.setOnClickListener(this);
        this.mDataUsageSortItem.setOnClickListener(this);
        this.mDataUsageSettingItem.setOnClickListener(this);
        this.mNetworkControl.setOnCheckedChangeListener(new AnonymousClass1(this));
        this.mRechargeItem.setOnDisabledClickListener(new AnonymousClass2(this));
        Utils.setMaxTextSizeForTextView(this.mTodayUsedTitle, getResources().getDimensionPixelSize(R.dimen.data_usage_title_max_size));
        Utils.setMaxTextSizeForTextView(this.mMonthUsedTitle, getResources().getDimensionPixelSize(R.dimen.data_usage_title_max_size));
        Utils.setMaxTextSizeForTextView(this.mSettlementTitle, getResources().getDimensionPixelSize(R.dimen.data_usage_title_max_size));
        Utils.setMaxTextSizeForTextView(this.m4GLeftTitle, getResources().getDimensionPixelSize(R.dimen.data_usage_title_max_size));
        Utils.setMaxTextSizeForTextView(this.mSpareTimeLeftTitle, getResources().getDimensionPixelSize(R.dimen.data_usage_title_max_size));
        setTitleByIntent();
        INetworkStatsService r10 = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mStatsService = r10;
        this.mStatsSession = r10.openSession();     // Catch: RemoteException -> L22
        this.uiHandler = new AnonymousClass3(this);
        return;
    L22:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void preloadRechargeProcess() {
        new Intent("com.bytedanceos.settings.FAKE_SERVICE").setPackage("com.bytedanceos.recharge");
    }

    public void com_android_settings_DataUsageActivity__onResume$___twin___() {
        super.onResume();
        OLog.d(TAG, "onresume is called");
        this.mIsFromSecurity = isFromSecurityCenter();
        setupBackBtnOnTitle(true);
        refreshUI();
        if (this.mTencentService == null) goto L5;
        updateSimCardInfo(false);
        updateBtnStatus();
    L5:
        UpdataTabView();
        updateNetworkOptimization();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r9) {
        int r10 = r9.getId();
        if (r10 != 1) goto L5;
        this.mSim1View.setSelected(true);
        this.mSim2View.setSelected(false);
        this.mCurrentSlot = FIRST_SIM_INDEX;
        if (this.isSlot1Init == true) goto L57;
        refreshNetworkInfo();
    L57:
        refreshUI();
        updateBtnStatus();
        if (this.mIsFromSecurity == true) goto L72;
        this.mSim1View.setTextColor(getResources().getColorStateList(R.color.title_bar_highlight_button_text_colorlist));
        this.mSim2View.setTextColor(getResources().getColorStateList(R.color.title_bar_button_text_colorlist));
        return;
    L72:
        return;
    L5:
        if (r10 != 2) goto L7;
        this.mSim2View.setSelected(true);
        this.mSim1View.setSelected(false);
        this.mCurrentSlot = SECOND_SIM_INDEX;
        if (this.isSlot2Init == true) goto L51;
        refreshNetworkInfo();
    L51:
        refreshUI();
        updateBtnStatus();
        if (this.mIsFromSecurity == true) goto L70;
        this.mSim1View.setTextColor(getResources().getColorStateList(R.color.title_bar_button_text_colorlist));
        this.mSim2View.setTextColor(getResources().getColorStateList(R.color.title_bar_highlight_button_text_colorlist));
        return;
    L70:
        return;
    L7:
        if (r10 == R.id.item_recharge) goto L47;
        int r5 = R.string.data_usage_title;
        if (r10 == R.id.network_optimization_settings) goto L38;
        switch(r10) {
            case 2131429314: goto L37;
            case 2131429315: goto L32;
            case 2131429316: goto L12;
            default: goto L73;
        };
    L12:
        SettingsTracker.onEvent("A190012");
        if (this.mCorrectingSlot == (-1)) goto L15;
    L30:
        ToastUtils.show(this, R.string.data_usage_try_later);
        return;
    L15:
        if (this.mTencentService == null) goto L30;
        this.mCorrectingSlot = this.mCurrentSlot;
        OLog.d(TAG, "start slot " + this.mCurrentSlot);     // Catch: RemoteException -> L22
        if (this.mTencentService.startCorrection(this.mCurrentSlot) != (-10006)) goto L24;
        ToastUtils.show(this, R.string.sms_correct_error_config);     // Catch: RemoteException -> L22
        this.mCorrectingSlot = -1;     // Catch: RemoteException -> L22
        return;
    L24:
        int r11 = this.mCorrectingSlot;
        if (r11 != 0) goto L27;
        this.sim1Data[9] = 0;
    L29:
        this.mDataUsageCorrect.setText(R.string.datausage_correcting_title_now);
        this.mDataUsageCorrect.setEnabled(false);
        return;
    L27:
        if (r11 != 1) goto L29;
        this.sim2Data[9] = 0;
    L22:
        e = move-exception;
        OLog.e(TAG, "", e);
        goto L24
    L32:
        Intent r12 = new Intent(this, DataUsageDetailActivity.class);
        r12.putExtra("title_id", R.string.datausage_sort_title);
        if (isFromSecurityCenter() == true) goto L36;
        r5 = R.string.data_usage_title_long;
    L36:
        r12.putExtra("back_text_id", r5);
        r12.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mIsFromSecurity);
        r12.putExtra("hidden_setting", true);
        r12.putExtra("slot", this.mCurrentSlot);
        startActivity(r12);
        SettingsTracker.onEvent("A190031");
        return;
    L37:
        LaunchDatausageSetting();
        return;
    L73:
        return;
    L38:
        Intent r13 = new Intent();
        r13.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.securitycenter.NetworkOptimizationSetting");
        r13.putExtra("title_id", R.string.network_background_control);
        if (isFromSecurityCenter() == false) goto L41;
        String r0 = getString(R.string.data_usage_title);
    L42:
        r13.putExtra("back_text", r0);
        r13.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mIsFromSecurity);
        startActivity(r13);     // Catch: ActivityNotFoundException -> L45
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Standard);     // Catch: ActivityNotFoundException -> L45
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        r0 = getString(R.string.data_usage_title_long);
        goto L42
    L47:
        launchRecharge(this);
        SettingsTracker.onEvent("A190014");
    }

    public void refreshNetworkInfo() {
        this.mTemplate = NetworkTemplate.buildTemplateMobileAll(getActiveSubscriberId());
        LoaderManager.getInstance(this).restartLoader(2, ChartDataLoader.buildArgs(this.mTemplate, null), this.mChartDataCallbacks);
    }

    private void refreshUI() {
        if (this.isTencentSDKEnabled == false) goto L62;
        if (this.mTencentService != null) goto L7;
        return;
    L7:
        int r0 = this.mCurrentSlot;
        int r6 = FIRST_SIM_INDEX;
        if (r0 != r6) goto L10;
        int[] r7 = this.sim1Data;
    L11:
        if (r0 == r6) goto L13;
    L17:
        boolean r8 = false;
    L18:
        int r9 = SECOND_SIM_INDEX;
        if (r0 != r9) goto L26;
        if (r0 != r9) goto L26;
        if (this.mSim2Exist == true) goto L24;
    L25:
        r8 = true;
        goto L26
    L24:
        if (this.mSim2Activied == false) goto L25;
    L26:
        int r10 = r7[9];
        if (r10 == (-1)) goto L40;
        if (r8 == true) goto L40;
        if (r10 == 0) goto L31;
    L39:
        formatFileSize(r7[0], 4, true);
        formatFileSize(r7[3], 3, true);
        formatFileSize(r7[6], 2, true);
    L42:
        if (r7[3] == (-1)) goto L44;
        int r1 = 1;
    L46:
        if (r7[6] == (-1)) goto L49;
        r1 = r1 + 2;
    L49:
        if (r1 != 0) goto L52;
        this.m4GLeftView.setVisibility(8);
        this.mSpareTimeLeftView.setVisibility(8);
        findViewById(R.id.extra_data_line).setVisibility(8);
        goto L62
    L52:
        if (r1 == 1) goto L56;
        if (r1 == 2) goto L56;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.m4GLeftView.getLayoutParams();
        r2.setMargins((int) getResources().getDimension(R.dimen.data_usage_view1_left_3), 0, 0, 0);
        this.m4GLeftView.setLayoutParams(r2);
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) this.mSpareTimeLeftView.getLayoutParams();
        r3.setMargins((int) getResources().getDimension(R.dimen.data_usage_view2_left_3), 0, 0, 0);
        this.mSpareTimeLeftView.setLayoutParams(r3);
        this.mSpareTimeLeftView.setVisibility(0);
        this.m4GLeftView.setVisibility(0);
        findViewById(R.id.extra_data_line).setVisibility(0);
    L56:
        if (r1 != 1) goto L58;
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) this.mSpareTimeLeftView.getLayoutParams();
        r11.setMargins((int) getResources().getDimension(R.dimen.data_usage_view1_left_3), 0, 0, 0);
        this.mSpareTimeLeftView.setLayoutParams(r11);
        this.m4GLeftView.setVisibility(8);
        this.mSpareTimeLeftView.setVisibility(0);
    L58:
        if (r1 != 2) goto L60;
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) this.m4GLeftView.getLayoutParams();
        r4.setMargins((int) getResources().getDimension(R.dimen.data_usage_view1_left_3), 0, 0, 0);
        this.m4GLeftView.setLayoutParams(r4);
        this.mSpareTimeLeftView.setVisibility(8);
        this.m4GLeftView.setVisibility(0);
    L60:
        findViewById(R.id.extra_data_line).setVisibility(0);
        goto L62
    L44:
        r1 = 0;
        goto L46
    L31:
        if (r7[0] != (-1)) goto L39;
        if (r0 != 0) goto L37;
        if (this.isSlot1Checked == true) goto L39;
    L37:
        if (this.isSlot2Checked == true) goto L39;
    L40:
        this.mDayToSettlement.setText("--");
        this.mDayToSettlementUnit.setText("");
        this.mMonthUsed.setText("--");
        this.mMonthUsedUnit.setText("");
        this.mTodayUsed.setText("--");
        this.mTodayUsedUnit.setText("");
        this.mMonthLeft.setText("--");
        this.mMonthLeftUnit.setText("");
        this.m4GLeft.setText("--");
        this.m4GLeftUnit.setText("");
        goto L42
    L13:
        if (this.mSim1Exist == true) goto L15;
    L16:
        r8 = true;
        goto L18
    L15:
        if (this.mSim1Activied == true) goto L17;
    L10:
        r7 = this.sim2Data;
    L62:
        if (SettingsFeature.isPhoneChargeSupport(this.mContext) == false) goto L64;
        this.mRechargeItem.setVisibility(0);
        this.mDataUsageSettingItem.setBackgroundStyle(3);
        this.mRechargeItem.setEnabled(SettingsFeature.isPhoneChargeInstalled(this.mContext));
    L65:
        caculateSettlement();
        if (this.mCurrentSlot != FIRST_SIM_INDEX) goto L68;
        long r5 = this.mSim1Month;
    L69:
        formatFileSize(r5, 1, false);
        if (this.mCurrentSlot != FIRST_SIM_INDEX) goto L72;
        long r12 = this.mSim1Today;
    L73:
        formatFileSize(r12, 0, false);
        StringBuilder r13 = new StringBuilder();
        String r14 = getOperationName(this.mCurrentSlot);
        if (TextUtils.isEmpty(r14) == true) goto L76;
        r13.append(r14).append(HanziToPinyin.Token.SEPARATOR);
    L76:
        String r15 = MultiSimAdapter.getLine1Number(this.mCurrentSlot);
        if (TextUtils.isEmpty(r15) == true) goto L79;
        r13.append(PhoneNumberUtils.formatNumber(r15)).toString();
    L80:
        this.mSimCardName.setTitleText(r13.toString());
        return;
    L79:
        r13.append(getString(R.string.unknown_number)).toString();
        goto L80
    L72:
        r12 = this.mSim2Today;
        goto L73
    L68:
        r5 = this.mSim2Month;
        goto L69
    L64:
        this.mRechargeItem.setVisibility(8);
        this.mDataUsageSettingItem.setBackgroundStyle(2);
        goto L65
    }

    private void updateDetailData() {
        OLog.d(TAG, "updateDetailData " + this.mCurrentSlot);
        NtpTrustedTime r1 = NtpTrustedTime.getInstance(this);
        if (r1.hasCache() == false) goto L5;
        long r2 = r1.currentTimeMillis();
    L6:
        Calendar r3 = Calendar.getInstance();
        r3.set(11, 0);
        r3.set(12, 0);
        r3.set(13, 0);
        long r4 = r3.getTimeInMillis();
        ChartData r5 = this.mChartData;
        NetworkStatsHistory.Entry r15 = null;
        if (r5 != null) goto L9;
    L11:
        NetworkStatsHistory.Entry r6 = null;
    L12:
        long r16 = 0;
        if (r6 == null) goto L15;
        long r8 = r6.rxBytes + r6.txBytes;
    L16:
        Calendar r7 = Calendar.getInstance();
        r7.set(11, 0);
        r7.set(12, 0);
        r7.set(13, 0);
        r7.set(5, 1);
        long r9 = r7.getTimeInMillis();
        ChartData r10 = this.mChartData;
        if (r10 == null) goto L22;
        if (r10.network == null) goto L22;
        r15 = this.mChartData.network.getValues(r9, r2, r2, null);
    L22:
        if (r15 == null) goto L24;
        r16 = r15.rxBytes + r15.txBytes;
    L24:
        long r11 = r16;
        int r12 = this.mCurrentSlot;
        if (r12 != FIRST_SIM_INDEX) goto L28;
        this.mSim1Today = r8;
        this.mSim1Month = r11;
        this.isSlot1Init = true;
    L30:
        this.uiHandler.removeMessages(1);
        this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1));
        return;
    L28:
        if (r12 != SECOND_SIM_INDEX) goto L30;
        this.mSim2Today = r8;
        this.mSim2Month = r11;
        this.isSlot2Init = true;
        goto L30
    L15:
        r8 = 0;
        goto L16
    L9:
        if (r5.network == null) goto L11;
        r6 = this.mChartData.network.getValues(r4, r2, r2, null);
        goto L12
    L5:
        r2 = System.currentTimeMillis();
        goto L6
    }

    public void com_android_settings_DataUsageActivity__onStart$___twin___() {
        super.onStart();
        updateSimCardInfo(false);
        refreshNetworkInfo();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mSimReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"), 2);
    }

    public void com_android_settings_DataUsageActivity__onStop$___twin___() {
        unregisterReceiver(this.mSimReceiver);
        super.onStop();
    }

    private String getActiveSubscriberId() {
        String r0 = TelephonyManager.getDefault().getSubscriberId(MultiSimAdapter.slot2Sub(this.mCurrentSlot));
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLastSubscriberId();
    }

    private String getLastSubscriberId() {
        return TelephonyManager.getTelephonyProperty(this.mCurrentSlot, LAST_SUBSCRIBER_PROP, null);
    }

    private void formatFileSize(long r9, int r11, boolean r12) {
        float r0 = r9;
        String r3 = "";
        int r4 = R.string.byteShort;
        if (r9 != (-1)) goto L6;
        String r10 = "--";
        boolean r13 = true;
    L31:
        if (r11 == 0) goto L60;
        if (r11 != 1) goto L34;
        this.mMonthUsed.setText(r10);
        TextView r14 = this.mMonthUsedUnit;
        if (r13 == true) goto L59;
        r3 = getString(r4);
    L59:
        r14.setText(r3);
        return;
    L34:
        if (r11 != 2) goto L36;
        this.m4GLeft.setText(r10);
        TextView r15 = this.m4GLeftUnit;
        if (r13 == true) goto L54;
        r3 = getString(r4);
    L54:
        r15.setText(r3);
        return;
    L36:
        if (r11 != 3) goto L38;
        this.mSpareTimeLeft.setText(r10);
        TextView r16 = this.mSpareTimeLeftUnit;
        if (r13 == true) goto L49;
        r3 = getString(r4);
    L49:
        r16.setText(r3);
        return;
    L38:
        if (r11 != 4) goto L70;
        this.mMonthLeft.setText(r10);
        TextView r17 = this.mMonthLeftUnit;
        if (r13 == true) goto L44;
        r3 = getString(r4);
    L44:
        r17.setText(r3);
        return;
    L70:
        return;
    L60:
        this.mTodayUsed.setText(r10);
        TextView r18 = this.mTodayUsedUnit;
        if (r13 == true) goto L64;
        r3 = getString(r4);
    L64:
        r18.setText(r3);
        return;
    L6:
        if (r12 == false) goto L11;
        if (r9 == 0) goto L15;
    L13:
        r4 = R.string.kilobyteShort;
    L15:
        if (r0 <= 1024.0f) goto L18;
        r0 = r0 / 1024.0f;
        r4 = R.string.megabyteShort;
    L18:
        if (r0 <= 1024.0f) goto L21;
        r0 = r0 / 1024.0f;
        r4 = R.string.gigabyteShort;
    L21:
        if (r0 <= 1024.0f) goto L24;
        r0 = r0 / 1024.0f;
        r4 = R.string.terabyteShort;
    L24:
        if (r0 <= 1024.0f) goto L26;
        r0 = r0 / 1024.0f;
        r4 = R.string.petabyteShort;
    L26:
        r13 = false;
        r10 = String.format("%.1f", new Object[]{Float.valueOf(r0)});
        if (r10 == null) goto L31;
        if (r10.endsWith(".0") == false) goto L31;
        r10 = r10.replace(".0", "");
        goto L31
    L11:
        if (r0 <= 1024.0f) goto L15;
        r0 = r0 / 1024.0f;
        goto L13
    }

    private void caculateSettlement() {
        Calendar r0 = Calendar.getInstance();
        this.mDayToSettlement.setText("" + ((r0.getActualMaximum(5) - r0.get(5)) + 1));
        this.mDayToSettlementUnit.setText(R.string.data_usage_settlement_unit_title);
    }

    public void launchRecharge(Context r5) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.bytedanceos.recharge", RECHARGE_ACTIVITY));
        r0.putExtra(EXTRA_RECHARGE_NUMBER_KEY, MultiSimAdapter.getLine1Number(this.mCurrentSlot));
        r0.putExtra(EXTRA_RECHARGE_TYPE_KEY, 1);
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mIsFromSecurity);
        r0.putExtra("exposure", 4);
        if (isFromSecurityCenter() == false) goto L5;
        String r4 = "data_usage_title";
    L6:
        r0.putExtra("back_text_res_name", r4);
        Utils.startActivity(r5, r0);
        return;
    L5:
        r4 = "data_usage_title_long";
        goto L6
    }

    public void com_android_settings_DataUsageActivity__onDestroy$___twin___() {
        super.onDestroy();
        if (this.isTencentSDKEnabled == false) goto L11;
        ITencent r0 = this.mTencentService;
        if (r0 != null) goto L15;
    L10:
        unbindService(this.mTencentServiceConnection);
        goto L11
    L15:
        r0.unregisterCallback(this.mCallback);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        OLog.e(TAG, "", e);
    L11:
        Handler r3 = this.uiHandler;
        if (r3 == null) goto L17;
        r3.removeCallbacksAndMessages(null);
        return;
    }

    private void updateBtnStatus() {
        if (this.mTencentService != null) goto L5;
        return;
    L5:
        int r0 = this.mCurrentSlot;
        int r1 = FIRST_SIM_INDEX;
        if (r0 != r1) goto L8;
        int[] r2 = this.sim1Data;
    L9:
        int r3 = r2[9];
        if (this.sim1Data[9] != 0) goto L13;
        this.mCorrectingSlot = r1;
    L16:
        if (r3 == (-1)) goto L22;
        if (r3 == 0) goto L21;
        if (r3 != 1) goto L24;
        this.mDataUsageCorrect.setText(R.string.datausage_correcting_title_again);
        this.mDataUsageCorrect.setEnabled(true);
    L24:
        if (MultiSimAdapter.hasIccCard(1) == false) goto L26;
        return;
    L26:
        if (MultiSimAdapter.hasIccCard(0) == true) goto L30;
        this.mDataUsageCorrect.setEnabled(false);
        return;
    L30:
        return;
    L21:
        this.mDataUsageCorrect.setText(R.string.datausage_correcting_title_now);
        this.mDataUsageCorrect.setEnabled(false);
        goto L24
    L22:
        this.mDataUsageCorrect.setText(R.string.datausage_correcting_title);
        this.mDataUsageCorrect.setEnabled(true);
        goto L24
    L13:
        if (this.sim2Data[9] != 0) goto L16;
        this.mCorrectingSlot = SECOND_SIM_INDEX;
        goto L16
    L8:
        r2 = this.sim2Data;
        goto L9
    }

    private void updateSimCardInfo(boolean r5) {
        this.mSim1Activied = SIMUtils.isSubActive(this, FIRST_SIM_INDEX);
        this.mSim2Activied = SIMUtils.isSubActive(this, SECOND_SIM_INDEX);
        boolean r1 = true;
        if (Utils.hasMultiSimInDevice() == true) goto L5;
    L20:
        this.mSim1Exist = MultiSimAdapter.hasIccCard(FIRST_SIM_INDEX);
        boolean r0 = MultiSimAdapter.hasIccCard(SECOND_SIM_INDEX);
        this.mSim2Exist = r0;
        if (r0 == true) goto L23;
    L25:
        this.mCurrentSlot = 0;
    L26:
        this.mTabView.setVisibility(8);
    L27:
        if (r5 == false) goto L29;
        refreshNetworkInfo();
    L29:
        this.isSlot1Init = false;
        this.isSlot2Init = false;
        return;
    L23:
        if (this.mSim2Activied == false) goto L25;
        this.mCurrentSlot = 1;
        goto L26
    L5:
        if (this.mSim1Activied == false) goto L20;
        if (this.mSim2Activied == false) goto L20;
        int r2 = this.mCorrectingSlot;
        if (r2 == (-1)) goto L11;
        this.mCurrentSlot = r2;
    L11:
        this.mSim1Exist = true;
        this.mSim2Exist = true;
        TextView r3 = this.mSim1View;
        if (this.mCurrentSlot != 0) goto L14;
        boolean r4 = true;
    L15:
        r3.setSelected(r4);
        TextView r6 = this.mSim2View;
        if (this.mCurrentSlot == 1) goto L19;
        r1 = false;
    L19:
        r6.setSelected(r1);
        this.mTabView.setVisibility(0);
        goto L27
    L14:
        r4 = false;
        goto L15
    }

    public String getDeviceIMSI(int r1) {
        int r2 = MultiSimAdapter.slot2Sub(r1);
        return this.mTelephonyMgr.getSubscriberId(r2);
    }

    public void UpdataTabView() {
        if (isFromSecurityCenter() == false) goto L6;
        this.mSim1View.setBackgroundResource(R.drawable.top_tab_left_background_blue);
        this.mSim2View.setBackgroundResource(R.drawable.top_tab_right_background_blue);
        this.mSim1View.setTextColor(getResources().getColor(R.color.white));
        this.mSim2View.setTextColor(getResources().getColor(R.color.white));
        return;
    L6:
        if (this.mSim1View.isSelected() == false) goto L9;
        this.mSim1View.setTextColor(getResources().getColorStateList(R.color.title_bar_highlight_button_text_colorlist));
        this.mSim2View.setTextColor(getResources().getColorStateList(R.color.title_bar_button_text_colorlist));
    L9:
        if (this.mSim2View.isSelected() == false) goto L11;
        this.mSim1View.setTextColor(getResources().getColorStateList(R.color.title_bar_button_text_colorlist));
        this.mSim2View.setTextColor(getResources().getColorStateList(R.color.title_bar_highlight_button_text_colorlist));
    L11:
        this.mSim1View.setBackgroundResource(R.drawable.top_tab_left_background);
        this.mSim2View.setBackgroundResource(R.drawable.top_tab_right_background);
    }

    protected void setTitleByIntent() {
        if (getIntent().hasExtra("title") == false) goto L8;
        String r0 = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(r0) == true) goto L18;
        this.mTitle.setCenterTitle(r0);
        return;
    L18:
        return;
    L8:
        if (getIntent().hasExtra("title_id") == false) goto L20;
        int r1 = getIntent().getIntExtra("title_id", -1);
        if (r1 <= 0) goto L21;
        this.mTitle.setCenterTitle(getString(r1));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    private String getOperationName(int r7) {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.checkService(MultiSimAdapter.PHONE_KEY));
        if (r0 != null) goto L13;
    L7:
        String r6 = null;
    L8:
        OLog.d(TAG, "getOperationName " + r6);
        if (r6 != null) goto L15;
        return "";
    L15:
        return r6;
    L13:
        r6 = r0.getDisplayPlmnMsim(null, null, null, false, r7);     // Catch: RemoteException -> L12
        goto L8
    }

    private void LaunchDatausageSetting() {
        Intent r0 = new Intent(this, DataUsageDetailActivity.class);
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mIsFromSecurity);
        r0.putExtra("hidden_list", true);
        r0.putExtra("slot", this.mCurrentSlot);
        r0.putExtra("title_id", R.string.data_usage_alarm);
        if (isFromSecurityCenter() == false) goto L5;
        int r1 = R.string.data_usage_title;
    L6:
        r0.putExtra("back_text_id", r1);
        Utils.startActivity(this, r0);
        return;
    L5:
        r1 = R.string.data_usage_title_long;
        goto L6
    }

    private void updateNetworkOptimization() {
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), RESTRICT_ALL_NET_BG_STATE, 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mNetworkControl.setChecked(r2);
        this.mBgControllItem.setEnabled(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DataUsageActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DataUsageActivity r1) {
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onCreate(DataUsageActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_DataUsageActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DataUsageActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DataUsageActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DataUsageActivity r5 = r4;
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
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DataUsageActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_DataUsageActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DataUsageActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_DataUsageActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onStart(DataUsageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_DataUsageActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onResume(DataUsageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_DataUsageActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DataUsageActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onPause(DataUsageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_DataUsageActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DataUsageActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DataUsageActivity r5 = r3;
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
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onStop(DataUsageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_DataUsageActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_DataUsageActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(DataUsageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_DataUsageActivity__onDestroy$___twin___();
    }
}
