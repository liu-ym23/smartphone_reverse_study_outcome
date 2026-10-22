package com.android.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAdvancedSettings extends LifeHookActivity2 implements View.OnClickListener, CachedBluetoothDevice.Callback, BluetoothTimerOption.TimerCallback, CompoundButton.OnCheckedChangeListener {
    private static final boolean D = true;
    private static final int MSG_SET_ABS_ENABLED = 0;
    private static final String TAG = "DeviceAdvancedSettings";
    private A2dpProfile mA2dp;
    private OCardListItem mAbs;
    private LinearLayout mAbsContainer;
    private OSwitch mAbsSwitch;
    private LinearLayout mAutoDiscContainer;
    private OCardListItem mAutoDiscTimer;
    private BluetoothTimerOption mBluetoothTimerOption;
    private CachedBluetoothDevice mCachedDevice;
    private LinearLayout mCodecContainer;
    private Context mContext;
    private OCardListItem mDevAddress;
    private CachedBluetoothDeviceManager mDeviceManager;
    private Handler mHandler;
    private HeadsetProfile mHeadSet;
    private LocalBluetoothProfileManager mProfileManager;
    private OCardListItem mQualityItem;
    private BroadcastReceiver mReceiver;
    private boolean mReceiverRegistered;
    private OCardListItem mStableItem;
    private Timer mTimer;

    class Task extends TimerTask {
        long mHasTime;
        final /* synthetic */ DeviceAdvancedSettings this$0;

        public Task(DeviceAdvancedSettings r3, long r4) {
            this.this$0 = r3;
            this.mHasTime = r4 + 60000;
            OLog.d(DeviceAdvancedSettings.TAG, " mHasTime = " + this.mHasTime);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            DeviceAdvancedSettings.access$600(this.this$0).post(new AnonymousClass1(this));
            this.mHasTime -= 1000;
        }
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DeviceAdvancedSettings() {
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mReceiver = new AnonymousClass3(this);
    }

    static /* synthetic */ OCardListItem access$000(DeviceAdvancedSettings r0) {
        return r0.mAbs;
    }

    static /* synthetic */ void access$100(DeviceAdvancedSettings r0) {
        r0.startBluetoothTimerService();
    }

    static /* synthetic */ Context access$200(DeviceAdvancedSettings r0) {
        return r0.mContext;
    }

    static /* synthetic */ CachedBluetoothDevice access$300(DeviceAdvancedSettings r0) {
        return r0.mCachedDevice;
    }

    static /* synthetic */ void access$400(DeviceAdvancedSettings r0) {
        r0.refresh();
    }

    static /* synthetic */ String access$500(DeviceAdvancedSettings r0, long r1) {
        return r0.millisTimeToDotFormat(r1);
    }

    static /* synthetic */ OCardListItem access$600(DeviceAdvancedSettings r0) {
        return r0.mAutoDiscTimer;
    }

    static /* synthetic */ Timer access$700(DeviceAdvancedSettings r0) {
        return r0.mTimer;
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.device_advanced_settings_layout);
        this.mContext = this;
        com.android.settings.Utils.setTranslucentStatusAndNavigation(this, getWindow());
        LocalBluetoothManager r4 = LocalBluetoothManager.getInstance(this.mContext);
        if (r4 != null) goto L5;
        return;
    L5:
        BluetoothDevice r0 = (BluetoothDevice) getIntent().getExtras().getParcelable("device");
        if (r0 != null) goto L9;
        finish();
        return;
    L9:
        this.mDeviceManager = r4.getCachedDeviceManager();
        LocalBluetoothProfileManager r5 = r4.getProfileManager();
        this.mProfileManager = r5;
        this.mHeadSet = r5.getHeadsetProfile();
        this.mA2dp = this.mProfileManager.getA2dpProfile();
        CachedBluetoothDevice r6 = this.mDeviceManager.findDevice(r0);
        this.mCachedDevice = r6;
        if (r6 != null) goto L12;
    L16:
        finish();
        return;
    L12:
        if (r6.getBondState() != 12) goto L16;
        this.mCachedDevice.registerCallback(this);
        IntentFilter r7 = new IntentFilter();
        r7.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, r7, 2);
        this.mReceiverRegistered = true;
        initView();
    }

    private void initView() {
        this.mCodecContainer = (LinearLayout) findViewById(R.id.codec_container);
        OCardListItem r0 = (OCardListItem) findViewById(R.id.quality_check);
        this.mQualityItem = r0;
        r0.setDefaultCustomEndView(2);
        OCardListItem r1 = (OCardListItem) findViewById(R.id.stable_check);
        this.mStableItem = r1;
        r1.setDefaultCustomEndView(2);
        LinearLayout r2 = (LinearLayout) findViewById(R.id.auto_disconnect_container);
        this.mAutoDiscContainer = r2;
        r2.setVisibility(8);
        this.mAutoDiscTimer = (OCardListItem) findViewById(R.id.auto_disconnect_timer);
        this.mAbsContainer = (LinearLayout) findViewById(R.id.abs_container);
        OCardListItem r3 = (OCardListItem) findViewById(R.id.abs_switch);
        this.mAbs = r3;
        r3.setDefaultCustomEndView(1);
        OSwitch r4 = this.mAbs.getEndSwitch();
        this.mAbsSwitch = r4;
        r4.setClickable(true);
        this.mAbsSwitch.setChecked(this.mCachedDevice.getAbsStatus());
        OCardListItem r5 = (OCardListItem) findViewById(R.id.dev_address);
        this.mDevAddress = r5;
        r5.setDefaultCustomEndView(3);
        this.mDevAddress.setEndDetailText(this.mCachedDevice.getDevice().getAddress());
        this.mDevAddress.showCustomEnd(true);
        setViewsClickListener(new OCardListItem[]{this.mQualityItem, this.mStableItem, this.mAutoDiscTimer});
        this.mAbsSwitch.setOnCheckedChangeListener(this);
        ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass2(this));
        this.mBluetoothTimerOption = new BluetoothTimerOption(this.mContext, this);
        refresh();
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(findViewById(R.id.fake_status_bar));
    }

    private void setViewsClickListener(OCardListItem... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        final OCardListItem r2 = r5[r1];
        if (r2 == null) goto L7;
        r2.setOnContentClickListener(new DeviceAdvancedSettings$$ExternalSyntheticLambda0(this, r2));
    L7:
        r1 = r1 + 1;
        goto L3
    }

    /* JADX INFO: renamed from: lambda$setViewsClickListener$0$com-android-settings-bluetooth-DeviceAdvancedSettings, reason: not valid java name */
    /* synthetic */ void m361x7324ca95(OCardListItem r1, View r2) {
        onClick(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.auto_disconnect_timer) goto L5;
        this.mBluetoothTimerOption.show(this, this.mAutoDiscTimer);
        return;
    L5:
        if (r3 != R.id.quality_check) goto L7;
        setHighQualityEnabled(true);
        return;
    L7:
        if (r3 != R.id.stable_check) goto L15;
        setHighQualityEnabled(false);
        return;
    }

    private boolean isOCardItemChecked(OCardListItem r1) {
        return "true".equals(r1.getTag());
    }

    private void setOCardItemChecked(OCardListItem r1, boolean r2) {
        if (r2 == false) goto L4;
        String r0 = "true";
    L5:
        r1.setTag(r0);
        r1.showCustomEnd(r2);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setHighQualityEnabled(boolean r2) {
        if (isOCardItemChecked(this.mQualityItem) == false) goto L6;
        if (r2 == false) goto L6;
        return;
    L6:
        setOCardItemChecked(this.mQualityItem, r2);
        setOCardItemChecked(this.mStableItem, !r2);
        disconnectA2dp();
    }

    private void setAbsEnabled(boolean r2) {
        this.mAbsSwitch.setChecked(r2);
        this.mCachedDevice.setAbsStatus(r2);
        if (r2 == false) goto L5;
        this.mCachedDevice.getDevice().removeDeviceFromDatabase(Utils.ABS_FEATURE_CODE);
        return;
    L5:
        this.mCachedDevice.getDevice().addDeviceToDatabase(Utils.ABS_FEATURE_CODE);
    }

    private void disconnectA2dp() {
        if (this.mCachedDevice.isConnectedProfile(this.mA2dp) == true) goto L5;
        return;
    L5:
        ToastUtils.show(this.mContext, R.string.bluetooth_codec_switch_tips);
        Intent r0 = new Intent(Utils.ACTION_DISCONNECT_DEVICE);
        r0.setClass(this.mContext, BluetoothTimerService.class);
        r0.putExtra("device", this.mCachedDevice.getDevice());
        r0.putExtra(Utils.NEED_RECONNECT, true);
        this.mContext.startService(r0);
    }

    private void refresh() {
        setCodecVisible();
        setAbsVisible();
        refreshDisconnectTimer();
    }

    private void setCodecVisible() {
        A2dpProfile r0 = this.mA2dp;
        if (r0 != null) goto L5;
    L15:
        this.mCodecContainer.setVisibility(8);
        return;
    L5:
        if (r0.isPreferred(this.mCachedDevice.getDevice()) == false) goto L15;
        int r1 = this.mCachedDevice.getProfileConnectionState(this.mA2dp);
        if (r1 != 1) goto L9;
    L12:
        boolean r2 = true;
    L13:
        this.mStableItem.setEnabled(!r2);
        this.mQualityItem.setEnabled(!r2);
        setOCardItemChecked(this.mQualityItem, false);
        setOCardItemChecked(this.mStableItem, true);
        this.mCodecContainer.setVisibility(8);
        return;
    L9:
        if (r1 == 3) goto L12;
        r2 = false;
        goto L13
    }

    private void setAbsVisible() {
        A2dpProfile r0 = this.mA2dp;
        if (r0 != null) goto L5;
    L8:
        this.mAbsContainer.setVisibility(8);
        return;
    L5:
        if (this.mCachedDevice.getProfileConnectionState(r0) != 2) goto L8;
        this.mAbsContainer.setVisibility(0);
        this.mAbsSwitch.setChecked(this.mCachedDevice.getAbsStatus());
        this.mAbs.setEnabled(true);
        this.mHandler.removeMessages(0);
    }

    private void refreshDisconnectTimer() {
        if (this.mCachedDevice.isConnectedProfile(this.mA2dp) == false) goto L5;
    L11:
        refreshRemainTime();
        return;
    L5:
        if (this.mCachedDevice.isConnectedProfile(this.mHeadSet) == true) goto L11;
        Timer r0 = this.mTimer;
        if (r0 == null) goto L13;
        r0.cancel();
        this.mTimer = null;
        return;
    }

    private void refreshRemainTime() {
        long r0 = Utils.getRemainingTime(this);
        if (r0 <= 0) goto L8;
        OLog.d(TAG, "start thread to count");
        String r2 = millisTimeToDotFormat(60000 + r0);
        OLog.d(TAG, "in refreshRemainTime = " + r0 + " ;set item title " + r2);
        this.mAutoDiscTimer.setEndDetailText(r2);
        this.mAutoDiscTimer.showCustomEnd(true);
        Timer r3 = this.mTimer;
        if (r3 == null) goto L7;
        r3.cancel();
        this.mTimer = null;
    L7:
        Timer r5 = new Timer(true);
        this.mTimer = r5;
        r5.schedule(new Task(this, r0), 0, 1000);
        return;
    L8:
        OLog.d(TAG, "remainTime < 0");
        Timer r1 = this.mTimer;
        if (r1 == null) goto L11;
        r1.cancel();
        this.mTimer = null;
    L11:
        this.mAutoDiscTimer.setEndDetailText(getString(R.string.time_no));
        this.mAutoDiscTimer.showCustomEnd(true);
    }

    private String millisTimeToDotFormat(long r9) {
        long r10 = r9 - ((r9 / 86400000) * 86400000);
        long r2 = r10 / 3600000;
        long r11 = (r10 - (3600000 * r2)) / 60000;
        OLog.d(TAG, " hours = " + r2 + "; mins = " + r11);
        if (r2 == 0) goto L5;
    L7:
        if (r2 != 0) goto L9;
    L11:
        if (r2 != 0) goto L13;
    L15:
        return "";
    L13:
        if (r11 == 0) goto L15;
        return getString(R.string.time_hour_min, new Object[]{Long.valueOf(r2), Long.valueOf(r11)});
    L9:
        if (r11 != 0) goto L11;
        return getString(R.string.time_hour, new Object[]{Long.valueOf(r2)});
    L5:
        if (r11 == 0) goto L7;
        return getString(R.string.time_min, new Object[]{Long.valueOf(r11)});
    }

    @Override // com.android.settings.bluetooth.CachedBluetoothDevice.Callback
    public void onDeviceAttributesChanged(boolean r1) {
        refresh();
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__onDestroy$___twin___() {
        super.onDestroy();
        OLog.i(TAG, "onDestroy ...");
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 == null) goto L6;
        r0.unregisterCallback(this);
    L6:
        if (this.mReceiverRegistered == false) goto L8;
        unregisterReceiver(this.mReceiver);
        this.mReceiverRegistered = false;
    L8:
        this.mHandler.removeMessages(0);
    }

    @Override // com.android.settings.bluetooth.BluetoothTimerOption.TimerCallback
    public void onDialogFinished(boolean r1) {
        if (r1 == false) goto L5;
        refresh();
        return;
    }

    @Override // com.android.settings.bluetooth.BluetoothTimerOption.TimerCallback
    public void onStartTiming(final long r3) {
        OLog.d(TAG, "onStartTiming deTimer:" + r3);
        startService(new Intent(this, BluetoothTimerService.class));
        new Handler().postDelayed(new AnonymousClass4(this, r3), 1000);
    }

    @Override // com.android.settings.bluetooth.BluetoothTimerOption.TimerCallback
    public void onStopTiming() {
        OLog.d(TAG, "onStopTiming");
        Utils.StopTiming(this.mContext);
        new Handler().postDelayed(new AnonymousClass5(this), 1000);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        setAbsEnabled(r4);
        this.mAbs.setEnabled(false);
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, 500);
    }

    private void startBluetoothTimerService() {
        startService(new Intent(this, BluetoothTimerService.class));
    }

    public void com_android_settings_bluetooth_DeviceAdvancedSettings__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DeviceAdvancedSettings r1) {
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(DeviceAdvancedSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceAdvancedSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_bluetooth_DeviceAdvancedSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(DeviceAdvancedSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DeviceAdvancedSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DeviceAdvancedSettings r5 = r4;
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
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DeviceAdvancedSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_bluetooth_DeviceAdvancedSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(DeviceAdvancedSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onResume(DeviceAdvancedSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceAdvancedSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceAdvancedSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DeviceAdvancedSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onPause(DeviceAdvancedSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceAdvancedSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceAdvancedSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DeviceAdvancedSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DeviceAdvancedSettings r5 = r3;
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
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onStop(DeviceAdvancedSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceAdvancedSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceAdvancedSettings__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(DeviceAdvancedSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceAdvancedSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceAdvancedSettings__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_bluetooth_DeviceAdvancedSettings_com_obric_hook_lancet_PrivacyHookActivity2_finish(DeviceAdvancedSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceAdvancedSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceAdvancedSettings__finish$___twin___();
    }
}
