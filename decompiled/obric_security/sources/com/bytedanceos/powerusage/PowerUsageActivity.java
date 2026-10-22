package com.bytedanceos.powerusage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import bytedanceos.util.LogTag;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedanceos.batteryusage.BatteryUsageStatsHelper;
import com.bytedanceos.datausage.AppNetworkControlActivity;
import com.bytedanceos.os.BatteryStatsHelper;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.SmtDevice;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.widget.CircleProgressBar;
import com.bytedanceos.utils.BatteryUtil;
import com.bytedanceos.utils.Constants;
import com.obric.olog.OLog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.alert.OViewStyleController;
import com.obric.oui.divider.ODivider;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import com.obric.security.R;
import com.obric.security.battertpower.BatteryPowerActivity;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import obric.util.DisplayHelper;

/* JADX INFO: loaded from: classes2.dex */
public class PowerUsageActivity extends BaseActivity implements View.OnClickListener {
    private static final boolean DEBUG = true;
    private static final int MIN_POWER_THRESHOLD_MILLI_AMP = 5;
    static final int MSG_REFRESH_PROGRESS = 1001;
    static final int MSG_REFRESH_PROGRESS_DELAY_TIME = 1500;
    static final int MSG_REFRESH_STATS = 100;
    static final int MSG_REFRESH_STATS_DELAY = 200;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final String TAG = "PowerUsageActivity";
    private static volatile boolean mRefreshing = false;
    private boolean isUserClick;
    private OListItemSettings mAppOptimizationView;
    private OListItemSwitch mAutoSleepModeView;
    private BroadcastReceiver mBatteryInfoReceiver;
    private TextView mBatteryLeftView;
    private OListItemSwitch mBattryPercentage;
    private OListItemSwitch mFivegOptimizeView;
    private OListItemSettings mGameOptimizationView;
    private MyHandler mHandler;
    private TextView mHardProcessText;
    private LinearLayout mHardwareContainer;
    private boolean mHardwareExpand;
    private int mLinAnim;
    private int mLoutAnim;
    private OListItemSettings mNetworkOptimizationView;
    private OListItemSettings mPowerModeView;
    private TextView mRemainTimeView;
    private TextView mRemainUnitView;
    private int mRinAnim;
    private int mRoutAnim;
    private OListItemSwitch mScreenPowerOptimizeView;
    private final ContentObserver mSettingValueObserver;
    private BroadcastReceiver mSimStateReceiver;
    private TextView mSoftProcessText;
    private CircleProgressBar mSoftWareCircleBar;
    private LinearLayout mSoftwareContainer;
    private boolean mSoftwareExpand;
    private BatteryStatsHelper mStatsHelper;
    private TelephonyManager mTelephonyManager;
    private TextView mTemperatureView;
    private double mTotalUsage;
    private UserManager mUm;
    private SparseArray<Map<String, com.bytedanceos.batteryusage.BatteryEntry>> mUsageMap;
    private SparseArray<com.bytedanceos.batteryusage.BatteryEntry> mUsageMapWithUid;
    private TextView mUsedTimeView;
    private TextView mUsedUnitView;
    private View placeholderWirelessChargeView;
    private OListItemSwitch reverseWirelessChargeSwitch;
    ODivider softwareListDivider;
    private final ContentObserver wirelessChargingObserver;

    private static class MyHandler extends Handler {
        WeakReference<Context> reference;

        public MyHandler(Context context) {
            this.reference = new WeakReference(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            PowerUsageActivity r0 = (PowerUsageActivity) this.reference.get();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = msg.what;
            int r2 = 0;
            if (r1 != 1) goto L8;
            com.bytedanceos.batteryusage.BatteryEntry r3 = (com.bytedanceos.batteryusage.BatteryEntry) msg.obj;
            int r4 = PowerUsageActivity.access$100(r0).getChildCount();
        L18:
            if (r2 >= r4) goto L34;
            View r5 = PowerUsageActivity.access$100(r0).getChildAt(r2);
            if (r5 == null) goto L33;
            if (r3 == null) goto L33;
            if (r5.getTag() == null) goto L33;
            if (r5.getTag().equals(Integer.valueOf(r3.getUid())) == false) goto L33;
            OLog.i(PowerUsageActivity.TAG, "MSG_UPDATE_NAME_ICON ========find =====uid=========" + r3.getUid());
            TextView r6 = (TextView) r5.findViewById(R.id.battery_item_name);
            if (r6 == null) goto L30;
            r6.setText(r3.mName);
        L30:
            ImageView r7 = (ImageView) r5.findViewById(R.id.battery_item_icon);
            if (r7 == null) goto L33;
            r7.setImageDrawable(r3.getIcon());
        L33:
            r2 = r2 + 1;
        L34:
            super.handleMessage(msg);
            return;
        L8:
            if (r1 == 100) goto L14;
            if (r1 != 1001) goto L34;
            int r8 = ((Integer) msg.obj).intValue();
            PowerUsageActivity.access$300(r0).update((r8 * 360) / 100, r8 + "");
            PowerUsageActivity.access$400(r0, r8);
            goto L34
        L14:
            if (PowerUsageActivity.access$200() == false) goto L16;
            return;
        L16:
            PowerUsageActivity.access$202(true);
            new RefreshAsyncTask(r0).execute(new Void[0]);
            goto L34
        }
    }

    private static class RefreshAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> reference;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] params) {
            return doInBackground2(params);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void result) {
            onPostExecute2(result);
        }

        public RefreshAsyncTask(Context context) {
            this.reference = new WeakReference(context);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... params) {
            PowerUsageActivity r0 = (PowerUsageActivity) this.reference.get();
            if (r0 == null) goto L7;
            PowerUsageActivity.access$500(r0);
            return null;
        L7:
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void result) {
            PowerUsageActivity r1 = (PowerUsageActivity) this.reference.get();
            if (r1 == null) goto L5;
            PowerUsageActivity.access$600(r1, r1.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
            PowerUsageActivity.access$700(r1);
        L5:
            PowerUsageActivity.access$202(false);
        }
    }

    static {
    }

    public PowerUsageActivity() {
        this.mSoftwareExpand = false;
        this.mHardwareExpand = false;
        this.mSimStateReceiver = new AnonymousClass1(this);
        this.isUserClick = true;
        this.mBatteryInfoReceiver = new AnonymousClass7(this);
        final MyHandler r1 = this.mHandler;
        this.mSettingValueObserver = new AnonymousClass12(this, r1);
        final Handler r2 = new Handler(Looper.getMainLooper());
        this.wirelessChargingObserver = new AnonymousClass13(this, r2);
    }

    static /* synthetic */ void access$000(PowerUsageActivity r0) {
        r0.updateFivegOptimize();
    }

    static /* synthetic */ LinearLayout access$100(PowerUsageActivity r0) {
        return r0.mSoftwareContainer;
    }

    static /* synthetic */ MyHandler access$1000(PowerUsageActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ boolean access$1102(PowerUsageActivity r0, boolean r1) {
        r0.mSoftwareExpand = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1202(PowerUsageActivity r0, boolean r1) {
        r0.mHardwareExpand = r1;
        return r1;
    }

    static /* synthetic */ void access$1300(PowerUsageActivity r0) {
        r0.updateReverseWirelessChargeSwitch();
    }

    static /* synthetic */ boolean access$200() {
        return mRefreshing;
    }

    static /* synthetic */ boolean access$202(boolean r0) {
        mRefreshing = r0;
        return r0;
    }

    static /* synthetic */ CircleProgressBar access$300(PowerUsageActivity r0) {
        return r0.mSoftWareCircleBar;
    }

    static /* synthetic */ void access$400(PowerUsageActivity r0, int r1) {
        r0.setProcessText(r1);
    }

    static /* synthetic */ void access$500(PowerUsageActivity r0) {
        refreshStats(r0);
    }

    static /* synthetic */ void access$600(PowerUsageActivity r0, Intent r1) {
        initBatteryInfo(r0, r1);
    }

    static /* synthetic */ void access$700(PowerUsageActivity r0) {
        refreshUI(r0);
    }

    static /* synthetic */ boolean access$800(PowerUsageActivity r0) {
        return r0.isUserClick;
    }

    static /* synthetic */ boolean access$802(PowerUsageActivity r0, boolean r1) {
        r0.isUserClick = r1;
        return r1;
    }

    static /* synthetic */ void access$900(PowerUsageActivity r0) {
        r0.showGuideDialog();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, BatteryPowerActivity.class));
        finish();
        setContentView(R.layout.activity_power_usage_layout);
        this.mUm = (UserManager) getSystemService("user");
        this.mStatsHelper = new BatteryStatsHelper(this, true);
        this.mTelephonyManager = (TelephonyManager) getSystemService("phone");
        this.mStatsHelper.create(savedInstanceState);
        this.mHardwareContainer = (LinearLayout) findViewById(R.id.hardware_list_container);
        this.mSoftwareContainer = (LinearLayout) findViewById(R.id.software_list_container);
        this.mTemperatureView = (TextView) findViewById(R.id.battery_temperature_tv);
        this.mBatteryLeftView = (TextView) findViewById(R.id.battery_usage_left_tv);
        this.mUsedTimeView = (TextView) findViewById(R.id.used_time_tv);
        this.mUsedUnitView = (TextView) findViewById(R.id.used_time_unit);
        this.mRemainTimeView = (TextView) findViewById(R.id.remain_time_tv);
        this.mRemainUnitView = (TextView) findViewById(R.id.remain_time_unit);
        this.mHardProcessText = (TextView) findViewById(R.id.hard_process_text);
        this.mSoftProcessText = (TextView) findViewById(R.id.soft_process_text);
        this.mBattryPercentage = (OListItemSwitch) findViewById(R.id.power_usage_battery_percentage);
        this.mPowerModeView = (OListItemSettings) findViewById(R.id.power_usage_save_mode);
        this.mGameOptimizationView = (OListItemSettings) findViewById(R.id.game_battery_use_optimization);
        this.mNetworkOptimizationView = (OListItemSettings) findViewById(R.id.network_optimization_settings);
        this.mAppOptimizationView = (OListItemSettings) findViewById(R.id.app_optimization);
        this.mSoftWareCircleBar = (CircleProgressBar) findViewById(R.id.software_circle_bar);
        this.mScreenPowerOptimizeView = (OListItemSwitch) findViewById(R.id.screen_power_optimize);
        this.mAutoSleepModeView = (OListItemSwitch) findViewById(R.id.auto_sleep_mode);
        this.reverseWirelessChargeSwitch = (OListItemSwitch) findViewById(R.id.reverse_wireless_charging);
        this.mFivegOptimizeView = (OListItemSwitch) findViewById(R.id.fiveg_optimize);
        this.softwareListDivider = (ODivider) findViewById(R.id.software_list_divider);
        OListItemSettings r5 = this.mPowerModeView;
        if (r5 == null) goto L5;
        r5.setOnClickListener(this);
    L5:
        OListItemSettings r6 = this.mGameOptimizationView;
        if (r6 == null) goto L8;
        r6.setOnClickListener(this);
    L8:
        OListItemSettings r7 = this.mNetworkOptimizationView;
        if (r7 == null) goto L11;
        r7.setOnClickListener(this);
    L11:
        OListItemSettings r8 = this.mAppOptimizationView;
        if (r8 == null) goto L14;
        r8.setOnClickListener(this);
    L14:
        initTitleBar(false);
        this.mRinAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", R.anim.slide_in_from_right);
        this.mLoutAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", R.anim.slide_out_to_left);
        this.mLinAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.mRoutAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        OListItemSwitch r9 = this.mBattryPercentage;
        if (r9 == null) goto L17;
        r9.setOnCheckedChangeListener(new AnonymousClass2(this));
    L17:
        OListItemSwitch r10 = this.mScreenPowerOptimizeView;
        if (r10 == null) goto L20;
        r10.setOnCheckedChangeListener(new AnonymousClass3(this));
    L20:
        OListItemSwitch r11 = this.mAutoSleepModeView;
        if (r11 == null) goto L23;
        r11.setOnCheckedChangeListener(new AnonymousClass4(this));
    L23:
        OListItemSwitch r12 = this.reverseWirelessChargeSwitch;
        if (r12 == null) goto L26;
        r12.setOnCheckedChangeListener(new AnonymousClass5(this));
    L26:
        OListItemSwitch r13 = this.mFivegOptimizeView;
        if (r13 == null) goto L30;
        r13.setOnCheckedChangeListener(new AnonymousClass6(this));
    L30:
        if (MultiSdkAdapter.isBeforeP() == false) goto L32;
    L33:
        OListItemSwitch r14 = this.mScreenPowerOptimizeView;
        if (r14 == null) goto L37;
        r14.setVisibility(8);
    L37:
        if (findViewById(R.id.screen_power_optimize_tips) == null) goto L40;
        findViewById(R.id.screen_power_optimize_tips).setVisibility(8);
    L40:
        if (findViewById(R.id.screen_power_optimize_gap) == null) goto L43;
        findViewById(R.id.screen_power_optimize_gap).setVisibility(8);
    L43:
        if (MultiSdkAdapter.isAfterQ() == false) goto L47;
        this.mGameOptimizationView.setVisibility(8);
        if (findViewById(R.id.game_battery_use_optimization_gap) == null) goto L47;
        findViewById(R.id.game_battery_use_optimization_gap).setVisibility(8);
    L47:
        updateViewWidth(R.id.ll_container);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(Constants.SMT_5G_STATUS_KEY), true, this.mSettingValueObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(Constants.FIVEG_POWER_SAVER_ENABLED), true, this.mSettingValueObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.WIRELESS_CHARGING), true, this.wirelessChargingObserver);
        this.mHandler = new MyHandler(this);
        return;
    L32:
        if (Utils.isDeviceType(SmtDevice.DARWIN) == false) goto L43;
        goto L33
    }

    private void showGuideDialog() {
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(this);
        r0.autoDismiss(false).title(R.string.reverse_wireless_charging).message(R.string.reverse_wireless_charging_message).negativeButton(R.string.ok2, new PowerUsageActivity$$ExternalSyntheticLambda0()).body(new OViewStyleController(new PowerUsageActivity$$ExternalSyntheticLambda1(this)));
        r0.show();
    }

    static /* synthetic */ void lambda$showGuideDialog$0(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    static /* synthetic */ Unit lambda$showGuideDialog$1(Context r4, FrameLayout r5) {
        AppCompatImageView r0 = new AppCompatImageView(r4);
        r0.setImageResource(R.drawable.wireless_charge_tip);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(DisplayHelper.dpToPx(296), DisplayHelper.dpToPx(232));
        r6.gravity = 1;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        r1.width = -1;
        r1.height = DisplayHelper.dpToPx(232);
        r1.topMargin = DisplayHelper.dpToPx(20);
        r1.bottomMargin = DisplayHelper.dpToPx(4);
        r5.setPadding(0, 0, 0, 0);
        r5.addView(r0, r6);
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BatteryStatsHelper.dropFile(this, "tmp_bat_history.bin");
        updateDynamicResolutionView();
        updateAppOptimizationView();
        updateScreenPowerOptimize();
        updateBatteryPercent();
        updateAutoSleepMode();
        updateReverseWirelessChargeSwitch();
        updateFivegOptimize();
        registerReceiver(this.mBatteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.AIRPLANE_MODE");
        r0.addAction("android.intent.action.SIM_STATE_CHANGED");
        registerReceiver(this.mSimStateReceiver, r0);
        this.mHandler.removeMessages(100);
        this.mHandler.sendEmptyMessageDelayed(100, 200);
    }

    private void updateReverseWirelessChargeSwitch() {
        boolean r0 = true;
        this.isUserClick = true;
        int r1 = Settings.System.getInt(getContentResolver(), Constants.WIRELESS_CHARGING, 0);
        boolean r2 = this.reverseWirelessChargeSwitch.isChecked();
        if (r1 != 1) goto L5;
        boolean r4 = true;
    L6:
        if (r2 == r4) goto L13;
        this.isUserClick = false;
        OListItemSwitch r5 = this.reverseWirelessChargeSwitch;
        if (r1 == 1) goto L11;
        r0 = false;
    L11:
        r5.setChecked(r0);
        return;
    L13:
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedanceos.batteryusage.BatteryEntry.stopRequestQueue();
        this.mHandler.removeMessages(1);
        unregisterReceiver(this.mBatteryInfoReceiver);
        unregisterReceiver(this.mSimStateReceiver);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mHandler.removeMessages(100);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isChangingConfigurations() == false) goto L5;
        this.mStatsHelper.storeState();
    L5:
        getContentResolver().unregisterContentObserver(this.mSettingValueObserver);
        getContentResolver().unregisterContentObserver(this.wirelessChargingObserver);
    }

    private static void refreshStats(PowerUsageActivity activity) {
        activity.mStatsHelper.clearStats();
        List<UserHandle> r0 = activity.mUm.getUserProfiles();
        activity.mStatsHelper.refreshStats(0, r0);
        Context r1 = activity.getApplicationContext();
        BatteryUsageStats r3 = ((BatteryStatsManager) r1.getSystemService(BatteryStatsManager.class)).getBatteryUsageStats();
        int r4 = r3.getDischargePercentage();
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        BatteryUsageStatsHelper r11 = new BatteryUsageStatsHelper(r1, activity.mHandler);
        List<com.bytedanceos.batteryusage.BatteryEntry> r5 = r11.getCoalescedUsageList(true, true);
        activity.mTotalUsage = r3.getConsumedPower();
        SparseArray<Map<String, com.bytedanceos.batteryusage.BatteryEntry>> r6 = activity.mUsageMap;
        if (r6 == null) goto L8;
        r6.clear();
    L8:
        SparseArray<com.bytedanceos.batteryusage.BatteryEntry> r7 = activity.mUsageMapWithUid;
        if (r7 == null) goto L11;
        r7.clear();
    L11:
        activity.mUsageMap = new SparseArray(r0.size());
        activity.mUsageMapWithUid = new SparseArray();
        Iterator<UserHandle> r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        activity.mUsageMap.put(r2.next().getIdentifier(), new HashMap());
        goto L13
    L15:
        Iterator<com.bytedanceos.batteryusage.BatteryEntry> r8 = r5.iterator();
    L17:
        if (r8.hasNext() == false) goto L32;
        com.bytedanceos.batteryusage.BatteryEntry r9 = r8.next();
        r9.mPercent = r11.calculateBatteryPercent(r9.getConsumedPower(), activity.mTotalUsage, r4);
        if (r9.isAppEntry() == true) goto L20;
        Map<String, com.bytedanceos.batteryusage.BatteryEntry> r10 = activity.mUsageMap.get(r1.getUserId());
        if (r10 == null) goto L17;
        r10.put(r9.getLabel(), r9);
        goto L17
    L20:
        int r12 = UserHandle.getUserId(r9.getUid());
        Map<String, com.bytedanceos.batteryusage.BatteryEntry> r13 = activity.mUsageMap.get(r12);
        if (r13 == null) goto L22;
        r13.put(r9.getDefaultPackageName(), r9);
        int r14 = r9.getUid();
        if (r14 != 1000) goto L27;
        r14 = 0;
    L27:
        if (BatteryEntry.isSplitedSystemPackage(r9.getDefaultPackageName()) == true) goto L17;
        activity.mUsageMapWithUid.put(r14, r9);
        goto L17
    L22:
        LogTag.i(TAG, " sipper userId error " + r9 + " userId is " + r12);
        goto L17
    L32:
        com.bytedanceos.batteryusage.BatteryEntry.startRequestQueue();
        LogTag.i(TAG, " origin mTotalUsage " + activity.mTotalUsage);
    }

    private static void refreshUI(final PowerUsageActivity activity) {
        activity.mHardwareContainer.removeAllViews();
        activity.mSoftwareContainer.removeAllViews();
        LayoutInflater r1 = activity.getLayoutInflater();
        ArrayList r2 = new ArrayList();
        int r3 = activity.mUsageMap.size();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        int r6 = activity.mUsageMap.keyAt(r5);
        if (activity.mUsageMap.get(r6) == null) goto L7;
        r2.addAll(activity.mUsageMap.get(r6).values());
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        BatteryStatsManager r4 = (BatteryStatsManager) activity.getSystemService(BatteryStatsManager.class);
        if (r4.getBatteryUsageStats() != null) goto L11;
        long r7 = 0;
    L12:
        long r8 = System.currentTimeMillis();
        long r9 = r8 - r7;
        long r11 = SystemClock.elapsedRealtime();
        LogTag.d(TAG, "systemTime=" + r8 + ",startClockTime====" + r7 + ", diffTime========" + r9 + ",elapsedRealtime=" + r11);
        if (r9 <= r11) goto L15;
        r9 = r11;
    L15:
        String[] r10 = activity.formatElapsedTime(r9);
        TextView r12 = activity.mUsedTimeView;
        if (TextUtils.isEmpty(r10[0]) == false) goto L18;
        String r13 = "1";
    L19:
        r12.setText(r13);
        int r14 = 1;
        activity.mUsedUnitView.setText(r10[1]);
        Collections.sort(r2);
        LogTag.i(TAG, "totalUsageTmp" + activity.mTotalUsage);
        Iterator r15 = r2.iterator();
    L21:
        if (r15.hasNext() == false) goto L25;
        com.bytedanceos.batteryusage.BatteryEntry r16 = (com.bytedanceos.batteryusage.BatteryEntry) r15.next();
        if (TextUtils.equals(Integer.toString(r16.getUid()), r16.getLabel()) == false) goto L21;
        r16.getConsumedPower();
        r15.remove();
        goto L21
    L25:
        Iterator r17 = r2.iterator();
        double r18 = 0.0d;
    L26:
        double r19 = 5.0d;
        double r110 = 3600.0d;
        double r111 = 0.5d;
        if (r17.hasNext() == false) goto L35;
        com.bytedanceos.batteryusage.BatteryEntry r20 = (com.bytedanceos.batteryusage.BatteryEntry) r17.next();
        if ((r20.getConsumedPower() * 3600.0d) < 5.0d) goto L26;
        if (((int) (r20.mPercent + 0.5d)) < 1) goto L33;
        r18 = r18 + r20.getConsumedPower();
        goto L26
    L33:
        LogTag.i(TAG, "entry" + r20 + "return !!!!!!!!!!!!!!!!!!!!!");
        goto L26
    L35:
        Iterator r21 = r2.iterator();
        float r22 = 0.0f;
        float r23 = 0.0f;
        int r112 = 0;
        int r113 = 0;
    L37:
        if (r21.hasNext() == false) goto L65;
        com.bytedanceos.batteryusage.BatteryEntry r24 = (com.bytedanceos.batteryusage.BatteryEntry) r21.next();
        if ((r24.getConsumedPower() * r110) < r19) goto L43;
        double r114 = (r24.getConsumedPower() / r18) * 100.0d;
        if (((int) (r24.mPercent + r111)) < r14) goto L43;
        UserHandle r115 = new UserHandle(UserHandle.getUserId(r24.getUid()));
        Drawable r116 = activity.mUm.getBadgedIconForUser(r24.getIcon(), r115);
        activity.mUm.getBadgedLabelForUser(r24.getLabel(), r115);
        r24.getConsumedPower();
        activity.mStatsHelper.getMaxPower();
        View r117 = r1.inflate(R.layout.list_item_battery_used, null, false);
        r117.setTag(Integer.valueOf(r24.getUid()));
        OLog.i(TAG, "setTag ======================" + r24.getUid());
        TextView r118 = (TextView) r117.findViewById(R.id.battery_item_name);
        r118.setText(r24.getLabel());
        ((ImageView) r117.findViewById(R.id.battery_item_icon)).setImageDrawable(r116);
        ((TextView) r117.findViewById(R.id.battery_item_percent)).setText(new DecimalFormat("0.0").format(r114) + "%");
        ((OProgressView) r117.findViewById(R.id.battery_item_progress)).setProgress((int) r114);
        r118.setText(r24.getLabel());
        if (r24.isAppEntry() == true) goto L47;
        int r25 = r112;
        if (activity.mHardwareExpand == true) goto L62;
        int r119 = r113;
        if (r119 >= 1) goto L60;
        activity.mHardwareContainer.addView(r117);
    L63:
        r113 = r119 + 1;
        r22 = (float) (((double) r22) + r114);
        r112 = r25;
    L64:
        r14 = 1;
        r19 = 5.0d;
        r110 = 3600.0d;
        r111 = 0.5d;
        goto L37
    L60:
        if (r119 != 1) goto L63;
        View r120 = r1.inflate(R.layout.list_item_battery_unfold, null, false);
        ((ImageView) r120.findViewById(R.id.fold_icon)).setImageResource(R.drawable.oic_data_usage_list_more);
        ((TextView) r120.findViewById(R.id.fold_txt)).setText(R.string.data_usage_list_more);
        activity.mHardwareContainer.addView(r120);
        r120.setOnClickListener(new AnonymousClass9(activity));
        goto L63
    L62:
        r119 = r113;
        activity.mHardwareContainer.addView(r117);
        goto L63
    L47:
        if (activity.mSoftwareExpand == true) goto L53;
        int r26 = r112;
        if (r26 >= 3) goto L51;
        activity.mSoftwareContainer.addView(r117);
    L54:
        r112 = r26 + 1;
        r23 = (float) (((double) r23) + r114);
        goto L64
    L51:
        if (r26 != 3) goto L54;
        View r121 = r1.inflate(R.layout.list_item_battery_unfold, null, false);
        ((ImageView) r121.findViewById(R.id.fold_icon)).setImageResource(R.drawable.oic_data_usage_list_more);
        ((TextView) r121.findViewById(R.id.fold_txt)).setText(R.string.data_usage_list_more);
        activity.mSoftwareContainer.addView(r121);
        r121.setOnClickListener(new AnonymousClass8(activity));
        goto L54
    L53:
        r26 = r112;
        activity.mSoftwareContainer.addView(r117);
    L43:
        r19 = 5.0d;
        r110 = 3600.0d;
        goto L37
    L65:
        int r27 = r112;
        int r122 = r113;
        if (activity.mSoftwareExpand == false) goto L71;
        if (r27 <= 3) goto L71;
        View r123 = r1.inflate(R.layout.list_item_battery_unfold, null, false);
        ((ImageView) r123.findViewById(R.id.fold_icon)).setImageResource(R.drawable.oic_data_usage_list_more_up);
        ((TextView) r123.findViewById(R.id.fold_txt)).setText(R.string.data_usage_list_fold);
        activity.mSoftwareContainer.addView(r123);
        r123.setOnClickListener(new AnonymousClass10(activity));
    L71:
        if (activity.mHardwareExpand == true) goto L73;
    L75:
        int r124 = 0;
    L76:
        int r28 = 8;
        int r29 = 1;
        if (r27 < 1) goto L89;
        LinearLayout r30 = activity.mSoftwareContainer;
        View r31 = r30.getChildAt(r30.getChildCount() - 1);
        if ((r31 instanceof RelativeLayout) == false) goto L84;
        View r32 = r31.findViewById(R.id.divider_line);
        if (r32 == null) goto L88;
        r32.setVisibility(8);
    L88:
        r29 = 1;
        goto L89
    L84:
        if ((r31 instanceof LinearLayout) == false) goto L88;
        LinearLayout r33 = activity.mSoftwareContainer;
        View r34 = r33.getChildAt(r33.getChildCount() - 2).findViewById(R.id.divider_line);
        if (r34 == null) goto L88;
        r34.setVisibility(8);
    L89:
        if (r122 < r29) goto L101;
        LinearLayout r35 = activity.mHardwareContainer;
        View r36 = r35.getChildAt(r35.getChildCount() - r29);
        if ((r36 instanceof RelativeLayout) == false) goto L96;
        View r37 = r36.findViewById(R.id.divider_line);
        if (r37 == null) goto L101;
        r37.setVisibility(8);
        goto L101
    L96:
        if ((r36 instanceof LinearLayout) == false) goto L101;
        LinearLayout r38 = activity.mHardwareContainer;
        View r39 = r38.getChildAt(r38.getChildCount() - 2).findViewById(R.id.divider_line);
        if (r39 == null) goto L101;
        r39.setVisibility(8);
    L101:
        if (activity.findViewById(R.id.software_list_title) == null) goto L112;
        View r40 = activity.findViewById(R.id.software_list_title);
        if (r27 != 0) goto L105;
        int r41 = 8;
    L106:
        r40.setVisibility(r41);
        ODivider r42 = activity.softwareListDivider;
        if (r27 != 0) goto L109;
        int r43 = 8;
    L110:
        r42.setVisibility(r43);
        goto L112
    L109:
        r43 = r124;
        goto L110
    L105:
        r41 = r124;
    L112:
        if (activity.findViewById(R.id.software_list_container) == null) goto L119;
        View r44 = activity.findViewById(R.id.software_list_container);
        if (r27 != 0) goto L116;
        int r45 = 8;
    L117:
        r44.setVisibility(r45);
        goto L119
    L116:
        r45 = r124;
    L119:
        if (activity.findViewById(R.id.data_usage_line_4) == null) goto L126;
        View r46 = activity.findViewById(R.id.data_usage_line_4);
        if (r27 != 0) goto L123;
        int r47 = 8;
    L124:
        r46.setVisibility(r47);
        goto L126
    L123:
        r47 = r124;
    L126:
        if (activity.findViewById(R.id.hardware_list_title) == null) goto L133;
        View r48 = activity.findViewById(R.id.hardware_list_title);
        if (r122 != 0) goto L130;
        int r49 = 8;
    L131:
        r48.setVisibility(r49);
        goto L133
    L130:
        r49 = r124;
    L133:
        if (activity.findViewById(R.id.hardware_list_container) == null) goto L139;
        View r50 = activity.findViewById(R.id.hardware_list_container);
        if (r122 == 0) goto L138;
        r28 = r124;
    L138:
        r50.setVisibility(r28);
    L139:
        int r51 = (int) (((double) r22) + 0.5d);
        int r52 = 100 - r51;
        if (r122 != 0) goto L143;
        if (r27 != 0) goto L143;
        int r53 = r124;
    L145:
        if (r53 <= 100) goto L148;
        r124 = (int) (((double) r23) + 0.5d);
    L148:
        if (activity.mSoftWareCircleBar.isAnim() == false) goto L150;
        activity.mHandler.removeMessages(1001);
        Message r54 = activity.mHandler.obtainMessage(1001);
        r54.obj = Integer.valueOf(r124);
        activity.mHandler.sendMessageDelayed(r54, DimPointEffectTokens.PendingCycleMs);
        return;
    L150:
        activity.mSoftWareCircleBar.update((r124 * 360) / 100, r124 + "");
        activity.setProcessText(r124);
        return;
    L143:
        r53 = r51;
        r124 = r52;
        goto L145
    L73:
        if (r122 <= 1) goto L75;
        r124 = 0;
        View r55 = r1.inflate(R.layout.list_item_battery_unfold, null, false);
        ((ImageView) r55.findViewById(R.id.fold_icon)).setImageResource(R.drawable.oic_data_usage_list_more_up);
        ((TextView) r55.findViewById(R.id.fold_txt)).setText(R.string.data_usage_list_fold);
        activity.mHardwareContainer.addView(r55);
        r55.setOnClickListener(new AnonymousClass11(activity));
        goto L76
    L18:
        r13 = r10[0];
        goto L19
    L11:
        r7 = r4.getBatteryUsageStats().getStatsStartTimestamp();
        goto L12
    }

    private void setProcessText(int softwareShowPercent) {
        this.mSoftProcessText.setText(softwareShowPercent + "%");
        this.mHardProcessText.setText((100 - softwareShowPercent) + "%");
    }

    private static void initBatteryInfo(PowerUsageActivity activity, Intent batteryBroadcast) {
        int r0 = getBatteryLevel(batteryBroadcast);
        int r1 = batteryBroadcast.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 20) / 10;
        activity.mBatteryLeftView.setText("" + r0);
        activity.mTemperatureView.setText("" + r1);
        SystemClock.elapsedRealtime();
        batteryBroadcast.getIntExtra("plugged", 0);
        activity.mStatsHelper.getStats();
        String[] r8 = {"", ""};
        long r3 = BatteryUtil.getBatteryTimeRemainingMs(activity);
        if (r3 <= 0) goto L5;
        r8 = activity.formatElapsedTime(r3);
    L5:
        TextView r2 = activity.mRemainTimeView;
        if (TextUtils.isEmpty(r8[0]) == false) goto L8;
        String r4 = "--";
    L9:
        r2.setText(r4);
        activity.mRemainUnitView.setText(r8[1]);
        setReverseWirelessChargeStatus(activity, r0);
        return;
    L8:
        r4 = r8[0];
        goto L9
    }

    private static void setReverseWirelessChargeStatus(final PowerUsageActivity activity, int batteryLevel) {
        if (batteryLevel >= 20) goto L8;
        View r2 = activity.placeholderWirelessChargeView;
        if (r2 != null) goto L7;
        activity.reverseWirelessChargeSwitch.mTrailingElement.post(new PowerUsageActivity$$ExternalSyntheticLambda2(activity));
        return;
    L7:
        r2.setVisibility(0);
        return;
    L8:
        View r1 = activity.placeholderWirelessChargeView;
        if (r1 == null) goto L14;
        r1.setVisibility(8);
        return;
    }

    static /* synthetic */ void lambda$setReverseWirelessChargeStatus$2(PowerUsageActivity r3) {
        r3.placeholderWirelessChargeView = new View(r3);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r3.reverseWirelessChargeSwitch.mTrailingElement.getWidth(), r3.reverseWirelessChargeSwitch.mTrailingElement.getHeight());
        r3.placeholderWirelessChargeView.setLayoutParams(r0);
        r3.placeholderWirelessChargeView.setOnClickListener(new AnonymousClass14());
        OListItemSwitch r1 = r3.reverseWirelessChargeSwitch;
        r1.addChildToParent(r1.mTrailingElement, r3.placeholderWirelessChargeView);
    }

    public static int getBatteryLevel(Intent batteryChangedIntent) {
        int r0 = batteryChangedIntent.getIntExtra("level", 0);
        int r1 = r0 * 100;
        return r1 / batteryChangedIntent.getIntExtra("scale", 100);
    }

    public static String formatPercentage(int percentage) {
        return formatPercentage(((double) percentage) / 100.0d);
    }

    public static String formatPercentage(double percentage) {
        return NumberFormat.getPercentInstance().format(percentage);
    }

    public String[] formatElapsedTime(long millis) {
        String[] r1 = {"0", getResources().getString(R.string.time_min)};
        long r11 = millis / 1000;
        if (r11 < TimeUtils.SECONDS_PER_DAY) goto L5;
        int r2 = (int) (r11 / TimeUtils.SECONDS_PER_DAY);
        r11 = r11 - ((long) (SECONDS_PER_DAY * r2));
    L7:
        if (r11 < TimeUtils.SECONDS_PER_HOUR) goto L9;
        int r6 = (int) (r11 / TimeUtils.SECONDS_PER_HOUR);
        r11 = r11 - ((long) (r6 * 3600));
    L11:
        if (r11 < 60) goto L13;
        int r7 = (int) (r11 / 60);
        r11 = r11 - ((long) (r7 * 60));
    L14:
        int r12 = (int) r11;
        if (r2 <= 0) goto L19;
        if (r2 < 2) goto L18;
        r2 = r2 + ((r6 + 12) / 24);
    L18:
        r1[0] = String.valueOf(r2);
        r1[1] = getResources().getString(R.string.time_day);
    L27:
        return r1;
    L19:
        if (r6 <= 0) goto L23;
        if (r6 < 2) goto L22;
        r6 = r6 + ((r7 + 30) / 60);
    L22:
        r1[0] = String.valueOf(r6);
        r1[1] = getResources().getString(R.string.time_hour);
        goto L27
    L23:
        if (r7 <= 0) goto L27;
        if (r7 < 2) goto L26;
        r7 = r7 + ((r12 + 30) / 60);
    L26:
        r1[0] = String.valueOf(r7);
        r1[1] = getResources().getString(R.string.time_min);
        goto L27
    L13:
        r7 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.putExtra(Constants.EXTRA_BYTEDANCE_ANIM_RESOURCE_ID, new int[]{this.mLinAnim, this.mRoutAnim});
        r0.putExtra("back_text_id", R.string.power_optimization);
        r0.putExtra(Utils.INTENT_KEY_FROM_CENTER, isFromSecurityCenter());
        if (v != this.mPowerModeView) goto L9;
        r0.setClass(this, PowerSaveModeActivity.class);
    L17:
        startActivity(r0);
        return;
    L9:
        if (v != this.mGameOptimizationView) goto L12;
        r0.setClass(this, DynamicResolutionActivity.class);
        goto L17
    L12:
        if (v != this.mNetworkOptimizationView) goto L15;
        r0.setClass(this, AppNetworkControlActivity.class);
        goto L17
    L15:
        if (v != this.mAppOptimizationView) goto L19;
        r0.setClass(this, AppBatteryUseOptimizationActivity.class);
        goto L17
    }

    private void updateDynamicResolutionView() {
        if (Settings.Global.getInt(getContentResolver(), DynamicResolutionConfig.DYNAMIC_RES_STATE, -1) < 0) goto L5;
        int r0 = R.string.settings_state_on;
    L6:
        String r1 = getString(r0);
        this.mGameOptimizationView.setSubTitleString(r1);
        return;
    L5:
        r0 = R.string.settings_state_off;
        goto L6
    }

    private void updateAppOptimizationView() {
        if (Settings.Global.getInt(getContentResolver(), Constants.OPTIMIZATION_APPS, 1) != 1) goto L5;
        int r0 = R.string.settings_state_on;
    L6:
        String r1 = getString(r0);
        this.mAppOptimizationView.setTrailingText(r1);
        return;
    L5:
        r0 = R.string.settings_state_off;
        goto L6
    }

    private void updateScreenPowerOptimize() {
        boolean r2 = true;
        int r0 = Settings.Global.getInt(getContentResolver(), Constants.POWER_ACL_MODE_ENABLE, 1);
        OListItemSwitch r3 = this.mScreenPowerOptimizeView;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        r3.setChecked(r2);
    }

    private void updateBatteryPercent() {
        boolean r2 = true;
        int r0 = Settings.System.getInt(getContentResolver(), "status_bar_show_battery_percent", 1);
        OListItemSwitch r3 = this.mBattryPercentage;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        r3.setChecked(r2);
    }

    private void updateFivegOptimize() {
        boolean r2 = true;
        if (Settings.Global.getInt(getContentResolver(), Constants.SMT_5G_STATUS_KEY, 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (Utils.support5G() == false) goto L29;
        if (r0 == false) goto L29;
        this.mFivegOptimizeView.setVisibility(0);
        if (findViewById(R.id.fiveg_optimize_tips) == null) goto L14;
        findViewById(R.id.fiveg_optimize_tips).setVisibility(0);
    L14:
        if (findViewById(R.id.fiveg_optimize_gap) == null) goto L17;
        findViewById(R.id.fiveg_optimize_gap).setVisibility(0);
    L17:
        if (hasSimCard() == true) goto L19;
    L22:
        this.mFivegOptimizeView.setEnabled(false);
    L23:
        int r1 = Settings.Global.getInt(getContentResolver(), Constants.FIVEG_POWER_SAVER_ENABLED, 1);
        OListItemSwitch r6 = this.mFivegOptimizeView;
        if (r1 == 1) goto L27;
        r2 = false;
    L27:
        r6.setChecked(r2);
        return;
    L19:
        if (isAirPlaneModeOn() == true) goto L22;
        this.mFivegOptimizeView.setEnabled(true);
    L29:
        this.mFivegOptimizeView.setVisibility(8);
        if (findViewById(R.id.fiveg_optimize_tips) == null) goto L33;
        findViewById(R.id.fiveg_optimize_tips).setVisibility(8);
    L33:
        if (findViewById(R.id.fiveg_optimize_gap) == null) goto L36;
        findViewById(R.id.fiveg_optimize_gap).setVisibility(8);
        return;
    L36:
        return;
    L5:
        r0 = false;
        goto L7
    }

    private void updateAutoSleepMode() {
        boolean r2 = true;
        int r0 = Settings.Global.getInt(getContentResolver(), Constants.POWER_SLEEP_MODE_ENABLE, 1);
        OListItemSwitch r3 = this.mAutoSleepModeView;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        r3.setChecked(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }

    public boolean hasSimCard() {
        int r1 = this.mTelephonyManager.getSimState();
        if (r1 == 1) goto L7;
        if (r1 == 0) goto L9;
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    private boolean isAirPlaneModeOn() {
        if (Settings.Global.getInt(getContentResolver(), "airplane_mode_on") == 1) goto L7;
        return false;
    L7:
        return true;
    L8:
        OLog.d(TAG, " get air plane mode error");
        return false;
    }
}
