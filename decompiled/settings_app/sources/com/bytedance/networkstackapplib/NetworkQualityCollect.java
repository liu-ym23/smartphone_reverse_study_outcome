package com.bytedance.networkstackapplib;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.settings.MultiSimAdapter;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.api.KeyEventSmt;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkQualityCollect {
    private static final int BEST_RSSI_LEVEL = 4;
    private static final int MAX_RSSI = -55;
    private static final int MIN_RSSI = -88;
    private static NetworkQualityCollect sInstance;
    private static final Object sLock = null;
    private ConnectivityManager cm;
    private boolean is5GAvailable;
    private int lastDataSim;
    private MyBroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private int mDataLevel;
    private final Object mGSMLevelLock;
    private String mGSMType;
    private final Object mGSMTypeUpdateLock;
    private String mNetworkType;
    private final Object mNetworkTypeUpdateLock;
    private MyPhoneStateChange mPhoneStateListener;
    private final Object mServiveStateUpdateLock;
    public int mSimNetworkType;
    private int mWifiLevel;
    private final Object mWifiLevelUpdateLock;
    private Handler myHandler;
    private TelephonyManager tm;
    private WifiManager wm;

    class MyBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkQualityCollect this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        MyBroadcastReceiver(NetworkQualityCollect r1) {
            this.this$0 = r1;
        }

        public void com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver__onReceive$___twin___(Context r3, Intent r4) {
        L38:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r4.getAction()) == false) goto L29;
            NetworkInfo r5 = NetworkQualityCollect.access$500(this.this$0).getActiveNetworkInfo();     // Catch: Exception -> L38
            Object r6 = NetworkQualityCollect.access$600(this.this$0);     // Catch: Exception -> L38
            monitor-enter(r6);     // Catch: Exception -> L38
            if (r5 == null) goto L45;
        L10:
            if (r5 != null) goto L12;
        L14:
            NetworkQualityCollect.access$702(this.this$0, NetworkStackConstant.ERR_DISCONNECTED);     // Catch: Throwable -> L8
        L15:
            monitor-exit(r6);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Exception -> L38
        L17:
            if (NetworkStackConstant.ERR_DISCONNECTED.equals(NetworkQualityCollect.access$700(this.this$0)) == false) goto L48;
            Object r7 = NetworkQualityCollect.access$900(this.this$0);     // Catch: Exception -> L38
            monitor-enter(r7);     // Catch: Exception -> L38
            NetworkQualityCollect.access$1002(this.this$0, -1);     // Catch: Throwable -> L23
            monitor-exit(r7);     // Catch: Throwable -> L23
        L49:
            return;
        L23:
            th = move-exception;
            throw th;     // Catch: Exception -> L38
        L48:
            return;
        L12:
            if (r5.isConnected() == false) goto L14;
            NetworkQualityCollect.access$800(this.this$0);     // Catch: Throwable -> L8
            NetworkQualityCollect.access$702(this.this$0, r5.getTypeName());     // Catch: Throwable -> L8
            goto L15
        L45:
            NetworkQualityCollect.access$702(this.this$0, NetworkStackConstant.ERR_DISCONNECTED);     // Catch: Throwable -> L8
            goto L10
        L29:
            if ("android.net.wifi.RSSI_CHANGED".equals(r4.getAction()) == false) goto L50;
            Object r8 = NetworkQualityCollect.access$900(this.this$0);     // Catch: Exception -> L38
            monitor-enter(r8);     // Catch: Exception -> L38
            int r9 = r4.getIntExtra("newRssi", -70);     // Catch: Throwable -> L35
            NetworkQualityCollect r2 = this.this$0;     // Catch: Throwable -> L35
            NetworkQualityCollect.access$1002(r2, NetworkQualityCollect.access$1100(r2, r9));     // Catch: Throwable -> L35
            monitor-exit(r8);     // Catch: Throwable -> L35
        L51:
            return;
        L35:
            th = move-exception;
            throw th;     // Catch: Exception -> L38
        }

        @Insert("onReceive")
        public static void com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(MyBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            MyBroadcastReceiver r1 = r7;
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
            r7.com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_bytedance_networkstackapplib_NetworkQualityCollect$MyBroadcastReceiver__onReceive$___twin___(r8, r9);
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

    class MyPhoneStateChange extends PhoneStateListener {
        final /* synthetic */ NetworkQualityCollect this$0;

        MyPhoneStateChange(NetworkQualityCollect r1) {
            this.this$0 = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int r2, int r3) {
            super.onDataConnectionStateChanged(r2, r3);
            Object r4 = NetworkQualityCollect.access$000(this.this$0);
            monitor-enter(r4);
            this.this$0.mSimNetworkType = r3;     // Catch: Throwable -> L6 Exception -> L8
            NetworkQualityCollect.access$102(this.this$0, NetworkQualityCollect.getNetworkTypeName(r3));     // Catch: Throwable -> L6 Exception -> L8
        L10:
            monitor-exit(r4);     // Catch: Throwable -> L6
            return;
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState r1) {
            super.onServiceStateChanged(r1);
            NetworkQualityCollect.access$200(this.this$0, r1.toString());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r2) {
            super.onSignalStrengthsChanged(r2);
            Object r0 = NetworkQualityCollect.access$300(this.this$0);
            monitor-enter(r0);
            NetworkQualityCollect.access$402(this.this$0, r2.getLevel());     // Catch: Throwable -> L6
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L6:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }
    }

    public static String getNetworkTypeName(int r0) {
        switch(r0) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L5:
        return "NR";
    L7:
        return "LTE_CA";
    L9:
        return "IWLAN";
    L11:
        return "TD_SCDMA";
    L13:
        return "GSM";
    L15:
        return "HSPA+";
    L17:
        return "CDMA - eHRPD";
    L19:
        return "LTE";
    L21:
        return "CDMA - EvDo rev. B";
    L23:
        return "iDEN";
    L25:
        return "HSPA";
    L27:
        return "HSUPA";
    L29:
        return "HSDPA";
    L31:
        return "CDMA - 1xRTT";
    L33:
        return "CDMA - EvDo rev. A";
    L35:
        return "CDMA - EvDo rev. 0";
    L37:
        return "CDMA";
    L39:
        return "UMTS";
    L41:
        return "EDGE";
    L43:
        return "GPRS";
    }

    static /* synthetic */ Object access$000(NetworkQualityCollect r0) {
        return r0.mGSMTypeUpdateLock;
    }

    static /* synthetic */ int access$1002(NetworkQualityCollect r0, int r1) {
        r0.mWifiLevel = r1;
        return r1;
    }

    static /* synthetic */ String access$102(NetworkQualityCollect r0, String r1) {
        r0.mGSMType = r1;
        return r1;
    }

    static /* synthetic */ int access$1100(NetworkQualityCollect r0, int r1) {
        return r0.calculateWifiSignalLevel(r1);
    }

    static /* synthetic */ MyPhoneStateChange access$1202(NetworkQualityCollect r0, MyPhoneStateChange r1) {
        r0.mPhoneStateListener = r1;
        return r1;
    }

    static /* synthetic */ MyBroadcastReceiver access$1300(NetworkQualityCollect r0) {
        return r0.mBroadcastReceiver;
    }

    static /* synthetic */ MyBroadcastReceiver access$1302(NetworkQualityCollect r0, MyBroadcastReceiver r1) {
        r0.mBroadcastReceiver = r1;
        return r1;
    }

    static /* synthetic */ Context access$1400(NetworkQualityCollect r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$200(NetworkQualityCollect r0, String r1) {
        return r0.isServiceStateFiveGAvailable(r1);
    }

    static /* synthetic */ Object access$300(NetworkQualityCollect r0) {
        return r0.mGSMLevelLock;
    }

    static /* synthetic */ int access$402(NetworkQualityCollect r0, int r1) {
        r0.mDataLevel = r1;
        return r1;
    }

    static /* synthetic */ ConnectivityManager access$500(NetworkQualityCollect r0) {
        return r0.cm;
    }

    static /* synthetic */ Object access$600(NetworkQualityCollect r0) {
        return r0.mNetworkTypeUpdateLock;
    }

    static /* synthetic */ String access$700(NetworkQualityCollect r0) {
        return r0.mNetworkType;
    }

    static /* synthetic */ String access$702(NetworkQualityCollect r0, String r1) {
        r0.mNetworkType = r1;
        return r1;
    }

    static /* synthetic */ boolean access$800(NetworkQualityCollect r0) {
        return r0.listenDataSim();
    }

    static /* synthetic */ Object access$900(NetworkQualityCollect r0) {
        return r0.mWifiLevelUpdateLock;
    }

    static {
        sLock = new Object();
    }

    private NetworkQualityCollect(Context r4) {
        this.mSimNetworkType = -1;
        this.mContext = null;
        this.mGSMType = NetworkStackConstant.ERR_NOT_REGISTERED;
        this.mNetworkType = NetworkStackConstant.ERR_NOT_REGISTERED;
        this.mDataLevel = -1;
        this.mWifiLevel = -1;
        this.is5GAvailable = false;
        this.mGSMTypeUpdateLock = new Object();
        this.mGSMLevelLock = new Object();
        this.mNetworkTypeUpdateLock = new Object();
        this.mWifiLevelUpdateLock = new Object();
        this.mServiveStateUpdateLock = new Object();
        this.tm = null;
        this.cm = null;
        this.wm = null;
        this.mPhoneStateListener = null;
        this.mBroadcastReceiver = null;
        this.lastDataSim = -1;
        this.myHandler = null;
        this.mContext = r4;     // Catch: Exception -> L5
        this.tm = (TelephonyManager) r4.getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Exception -> L5
        this.cm = (ConnectivityManager) this.mContext.getSystemService("connectivity");     // Catch: Exception -> L5
        this.wm = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L5
        initForRegister();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean isServiceStateFiveGAvailable(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Object r1 = this.mServiveStateUpdateLock;
        monitor-enter(r1);
        this.is5GAvailable = false;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return this.is5GAvailable;
    L10:
        if (r3.contains("nrState=NOT_RESTRICTED") == false) goto L12;
    L13:
        this.is5GAvailable = true;     // Catch: Throwable -> L17
        goto L14
    L12:
        if (r3.contains("nrState=CONNECTED") == false) goto L14;
    L17:
        th = move-exception;
        throw th;
    }

    private int calculateWifiSignalLevel(int r3) {
        if (r3 > MIN_RSSI) goto L7;
        return 0;
    L7:
        if (r3 < MAX_RSSI) goto L10;
        return 4;
    L10:
        return ((r3 - MIN_RSSI) * 4) / 33;
    }

    public static NetworkQualityCollect getInstance(Context r2) {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NetworkQualityCollect(r2);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return sInstance;
    }

    private boolean listenDataSim() {
        int r0 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L7
        if (this.lastDataSim == r0) goto L12;
        TelephonyManager r1 = this.tm.createForSubscriptionId(r0);     // Catch: Exception -> L7
        this.tm = r1;     // Catch: Exception -> L7
        r1.listen(this.mPhoneStateListener, KeyEventSmt.KEYCODE_F20);     // Catch: Exception -> L7
        this.lastDataSim = r0;     // Catch: Exception -> L7
        return true;
    L12:
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private void initForRegister() {
        HandlerThread r0 = new HandlerThread("listener_thread");
        r0.start();
        final Looper r1 = r0.getLooper();
        Handler r2 = new AnonymousClass1(this, r1);
        this.myHandler = r2;
        r2.sendEmptyMessage(0);
    }

    public void stopAllWork() {
        this.tm.listen(this.mPhoneStateListener, 0);     // Catch: Exception -> L4
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public int getDataLevel() {
        Object r0 = this.mGSMLevelLock;
        monitor-enter(r0);
        int r1 = this.mDataLevel;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getWifiLevel() {
        Object r0 = this.mWifiLevelUpdateLock;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L5:
        if ("WIFI".equals(this.mNetworkType) == true) goto L7;
    L11:
        int r3 = this.mWifiLevel;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    L7:
        if (this.mWifiLevel != (-1)) goto L11;
        WifiInfo r1 = this.wm.getConnectionInfo();     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        this.mWifiLevel = calculateWifiSignalLevel(r1.getRssi());     // Catch: Throwable -> L14
    L17:
        return -2;
    }

    public String getDataType() {
        Object r0 = this.mGSMTypeUpdateLock;
        monitor-enter(r0);
        String r1 = this.mGSMType;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getNetworkType() {
        Object r0 = this.mNetworkTypeUpdateLock;
        monitor-enter(r0);
        String r1 = this.mNetworkType;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean is5G() {
        if (this.is5GAvailable == false) goto L5;
        return true;
    L5:
        if ("NR".equals(this.mGSMType) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String toString() {
        return "NetworkQualityCollect{mGSMType='" + this.mGSMType + "', mNetworkType='" + this.mNetworkType + "', mDataLevel=" + this.mDataLevel + ", mWifiLevel=" + this.mWifiLevel + ", lastDataSim=" + this.lastDataSim + ", getIpAvailableType=" + TTNetworkStackUtils.getIpAvailableType(this.mContext) + '}';
    }
}
