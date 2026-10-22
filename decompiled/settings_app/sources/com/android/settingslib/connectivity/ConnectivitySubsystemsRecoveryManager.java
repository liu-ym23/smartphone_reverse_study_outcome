package com.android.settingslib.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.provider.Settings;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivitySubsystemsRecoveryManager {
    private static final long RESTART_TIMEOUT_MS = 15000;
    private static final String TAG = "ConnectivitySubsystemsRecoveryManager";
    private final BroadcastReceiver mApmMonitor;
    private boolean mApmMonitorRegistered;
    private final Context mContext;
    private RecoveryStatusCallback mCurrentRecoveryCallback;
    private final Handler mHandler;
    private RecoveryAvailableListener mRecoveryAvailableListener;
    private final MobileTelephonyCallback mTelephonyCallback;
    private TelephonyManager mTelephonyManager;
    private boolean mTelephonyRestartInProgress;
    private WifiManager mWifiManager;
    private boolean mWifiRestartInProgress;
    private final WifiManager.SubsystemRestartTrackingCallback mWifiSubsystemRestartTrackingCallback;

    private class MobileTelephonyCallback extends TelephonyCallback implements TelephonyCallback.RadioPowerStateListener {
        final /* synthetic */ ConnectivitySubsystemsRecoveryManager this$0;

        private MobileTelephonyCallback(ConnectivitySubsystemsRecoveryManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MobileTelephonyCallback(ConnectivitySubsystemsRecoveryManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void onRadioPowerStateChanged(int r2) {
            if (ConnectivitySubsystemsRecoveryManager.access$400(this.this$0) == true) goto L5;
        L6:
            this.this$0.stopTrackingTelephonyRestart();
        L8:
            if (r2 != 1) goto L11;
            ConnectivitySubsystemsRecoveryManager.access$402(this.this$0, false);
            this.this$0.stopTrackingTelephonyRestart();
            ConnectivitySubsystemsRecoveryManager.access$200(this.this$0);
            return;
        L11:
            return;
        L5:
            if (ConnectivitySubsystemsRecoveryManager.access$500(this.this$0) != null) goto L8;
            goto L6
        }
    }

    public interface RecoveryAvailableListener {
        void onRecoveryAvailableChangeListener(boolean r1);
    }

    public interface RecoveryStatusCallback {
        void onSubsystemRestartOperationBegin();

        void onSubsystemRestartOperationEnd();
    }

    static /* synthetic */ RecoveryAvailableListener access$000(ConnectivitySubsystemsRecoveryManager r0) {
        return r0.mRecoveryAvailableListener;
    }

    static /* synthetic */ boolean access$102(ConnectivitySubsystemsRecoveryManager r0, boolean r1) {
        r0.mWifiRestartInProgress = r1;
        return r1;
    }

    static /* synthetic */ void access$200(ConnectivitySubsystemsRecoveryManager r0) {
        r0.checkIfAllSubsystemsRestartsAreDone();
    }

    static /* synthetic */ boolean access$400(ConnectivitySubsystemsRecoveryManager r0) {
        return r0.mTelephonyRestartInProgress;
    }

    static /* synthetic */ boolean access$402(ConnectivitySubsystemsRecoveryManager r0, boolean r1) {
        r0.mTelephonyRestartInProgress = r1;
        return r1;
    }

    static /* synthetic */ RecoveryStatusCallback access$500(ConnectivitySubsystemsRecoveryManager r0) {
        return r0.mCurrentRecoveryCallback;
    }

    public ConnectivitySubsystemsRecoveryManager(Context r3, Handler r4) {
        this.mRecoveryAvailableListener = null;
        this.mWifiManager = null;
        this.mTelephonyManager = null;
        this.mApmMonitor = new AnonymousClass1(this);
        this.mApmMonitorRegistered = false;
        this.mWifiRestartInProgress = false;
        this.mTelephonyRestartInProgress = false;
        this.mCurrentRecoveryCallback = null;
        this.mWifiSubsystemRestartTrackingCallback = new AnonymousClass2(this);
        this.mTelephonyCallback = new MobileTelephonyCallback(this, null);
        this.mContext = r3;
        this.mHandler = new Handler(r4.getLooper());
        if (r3.getPackageManager().hasSystemFeature("android.hardware.wifi") == false) goto L8;
        WifiManager r5 = (WifiManager) r3.getSystemService(WifiManager.class);
        this.mWifiManager = r5;
        if (r5 != null) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "WifiManager not available!?");
    L8:
        if (r3.getPackageManager().hasSystemFeature("android.hardware.telephony") == false) goto L13;
        TelephonyManager r6 = (TelephonyManager) r3.getSystemService(TelephonyManager.class);
        this.mTelephonyManager = r6;
        if (r6 != null) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "TelephonyManager not available!?");
        return;
    L14:
        return;
    }

    public void setRecoveryAvailableListener(final RecoveryAvailableListener r3) {
        this.mHandler.post(new ConnectivitySubsystemsRecoveryManager$$ExternalSyntheticLambda0(this, r3));
    }

    /* JADX INFO: renamed from: lambda$setRecoveryAvailableListener$0$com-android-settingslib-connectivity-ConnectivitySubsystemsRecoveryManager, reason: not valid java name */
    /* synthetic */ void m750x8f9ba31(RecoveryAvailableListener r1) {
        this.mRecoveryAvailableListener = r1;
        startTrackingRecoveryAvailability();
    }

    public void clearRecoveryAvailableListener() {
        this.mHandler.post(new ConnectivitySubsystemsRecoveryManager$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$clearRecoveryAvailableListener$1$com-android-settingslib-connectivity-ConnectivitySubsystemsRecoveryManager, reason: not valid java name */
    /* synthetic */ void m749xcb7cf47b() {
        this.mRecoveryAvailableListener = null;
        stopTrackingRecoveryAvailability();
    }

    private boolean isApmEnabled() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isWifiEnabled() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isWifiEnabled() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mWifiManager.isWifiApEnabled() == false) goto L9;
        goto L8
    }

    public boolean isRecoveryAvailable() {
        if (isApmEnabled() == true) goto L7;
        return true;
    L7:
        return isWifiEnabled();
    }

    private void startTrackingRecoveryAvailability() {
        if (this.mApmMonitorRegistered == false) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mApmMonitor, new IntentFilter("android.intent.action.AIRPLANE_MODE"), null, this.mHandler);
        this.mApmMonitorRegistered = true;
    }

    private void stopTrackingRecoveryAvailability() {
        if (this.mApmMonitorRegistered == true) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(this.mApmMonitor);
        this.mApmMonitorRegistered = false;
    }

    void startTrackingWifiRestart() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerSubsystemRestartTrackingCallback(new HandlerExecutor(this.mHandler), this.mWifiSubsystemRestartTrackingCallback);
    }

    void stopTrackingWifiRestart() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unregisterSubsystemRestartTrackingCallback(this.mWifiSubsystemRestartTrackingCallback);
    }

    void startTrackingTelephonyRestart() {
        TelephonyManager r0 = this.mTelephonyManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerTelephonyCallback(new HandlerExecutor(this.mHandler), this.mTelephonyCallback);
    }

    void stopTrackingTelephonyRestart() {
        TelephonyManager r0 = this.mTelephonyManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unregisterTelephonyCallback(this.mTelephonyCallback);
    }

    private void checkIfAllSubsystemsRestartsAreDone() {
        if (this.mWifiRestartInProgress == false) goto L5;
        return;
    L5:
        if (this.mTelephonyRestartInProgress == true) goto L11;
        RecoveryStatusCallback r0 = this.mCurrentRecoveryCallback;
        if (r0 == null) goto L12;
        r0.onSubsystemRestartOperationEnd();
        this.mCurrentRecoveryCallback = null;
        return;
    L12:
        return;
    }

    public void triggerSubsystemRestart(String r2, final RecoveryStatusCallback r3) {
        this.mHandler.post(new ConnectivitySubsystemsRecoveryManager$$ExternalSyntheticLambda3(this, r3));
    }

    /* JADX INFO: renamed from: lambda$triggerSubsystemRestart$3$com-android-settingslib-connectivity-ConnectivitySubsystemsRecoveryManager, reason: not valid java name */
    /* synthetic */ void m752xb18e63b6(RecoveryStatusCallback r4) {
        if (this.mWifiRestartInProgress == false) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Wifi restart still in progress");
        return;
    L7:
        if (this.mTelephonyRestartInProgress == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Telephony restart still in progress");
        return;
    L10:
        boolean r1 = true;
        if (isWifiEnabled() == false) goto L13;
        this.mWifiManager.restartWifiSubsystem();
        this.mWifiRestartInProgress = true;
        startTrackingWifiRestart();
        boolean r0 = true;
    L15:
        if (this.mTelephonyManager != null) goto L17;
    L21:
        r1 = r0;
    L22:
        if (r1 == false) goto L25;
        this.mCurrentRecoveryCallback = r4;
        r4.onSubsystemRestartOperationBegin();
        this.mHandler.postDelayed(new ConnectivitySubsystemsRecoveryManager$$ExternalSyntheticLambda2(this), 15000);
        return;
    L25:
        return;
    L17:
        if (isApmEnabled() == true) goto L21;
        if (this.mTelephonyManager.rebootRadio() == false) goto L21;
        this.mTelephonyRestartInProgress = true;
        startTrackingTelephonyRestart();
        goto L22
    L13:
        r0 = false;
        goto L15
    }

    /* JADX INFO: renamed from: lambda$triggerSubsystemRestart$2$com-android-settingslib-connectivity-ConnectivitySubsystemsRecoveryManager, reason: not valid java name */
    /* synthetic */ void m751x6f773657() {
        stopTrackingWifiRestart();
        stopTrackingTelephonyRestart();
        this.mWifiRestartInProgress = false;
        this.mTelephonyRestartInProgress = false;
        RecoveryStatusCallback r0 = this.mCurrentRecoveryCallback;
        if (r0 == null) goto L6;
        r0.onSubsystemRestartOperationEnd();
        this.mCurrentRecoveryCallback = null;
        return;
    }
}
