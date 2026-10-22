package com.android.wifitrackerlib;

import android.content.Context;
import android.icu.text.MessageFormat;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.sharedconnectivity.app.HotspotNetwork;
import android.net.wifi.sharedconnectivity.app.SharedConnectivityManager;
import android.os.Handler;
import android.text.BidiFormatter;
import android.text.TextUtils;
import android.util.Log;
import com.android.settingslib.R;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HotspotNetworkEntry extends WifiEntry {
    public static final int CONNECTION_STATUS_CONNECTED = 10;
    private static final String DEVICE_TYPE_KEY = "DEVICE_TYPE";
    public static final String EXTRA_KEY_IS_BATTERY_CHARGING = "is_battery_charging";
    public static final String KEY_PREFIX = "HotspotNetworkEntry:";
    private static final String NETWORK_NAME_KEY = "NETWORK_NAME";
    static final String TAG = "HotspotNetworkEntry";
    private boolean mConnectionError;
    private final Context mContext;
    private HotspotNetwork mHotspotNetworkData;
    private final WifiTrackerInjector mInjector;
    private HotspotNetworkEntryKey mKey;
    private int mLastStatus;
    private final SharedConnectivityManager mSharedConnectivityManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceType {
    }

    static class HotspotNetworkEntryKey {
        private static final String KEY_DEVICE_ID_KEY = "DEVICE_ID_KEY";
        private static final String KEY_IS_VIRTUAL_ENTRY_KEY = "IS_VIRTUAL_ENTRY_KEY";
        private static final String KEY_SCAN_RESULT_KEY = "SCAN_RESULT_KEY";
        private long mDeviceId;
        private boolean mIsVirtualEntry;
        private StandardWifiEntry.ScanResultKey mScanResultKey;

        HotspotNetworkEntryKey(HotspotNetwork r4) {
            this.mDeviceId = r4.getDeviceId();
            if (r4.getHotspotSsid() != null) goto L5;
        L8:
            this.mIsVirtualEntry = true;
            this.mScanResultKey = null;
            return;
        L5:
            if (r4.getHotspotSecurityTypes() == null) goto L8;
            this.mIsVirtualEntry = false;
            this.mScanResultKey = new StandardWifiEntry.ScanResultKey(r4.getHotspotSsid(), new ArrayList(r4.getHotspotSecurityTypes()));
        }

        HotspotNetworkEntryKey(String r7) {
            this.mScanResultKey = null;
            if (r7.startsWith(HotspotNetworkEntry.KEY_PREFIX) == true) goto L19;
            Log.e(HotspotNetworkEntry.TAG, "String key does not start with key prefix!");
            return;
        L19:
            JSONObject r3 = new JSONObject(r7.substring(20));     // Catch: JSONException -> L16
            if (r3.has(KEY_IS_VIRTUAL_ENTRY_KEY) == false) goto L10;
            this.mIsVirtualEntry = r3.getBoolean(KEY_IS_VIRTUAL_ENTRY_KEY);     // Catch: JSONException -> L16
        L10:
            if (r3.has(KEY_DEVICE_ID_KEY) == false) goto L13;
            this.mDeviceId = r3.getLong(KEY_DEVICE_ID_KEY);     // Catch: JSONException -> L16
        L13:
            if (r3.has(KEY_SCAN_RESULT_KEY) == false) goto L21;
            this.mScanResultKey = new StandardWifiEntry.ScanResultKey(r3.getString(KEY_SCAN_RESULT_KEY));     // Catch: JSONException -> L16
            return;
        L21:
            return;
        L16:
            e = move-exception;
            Log.e(HotspotNetworkEntry.TAG, "JSONException while converting HotspotNetworkEntryKey to string: " + e);
        }

        public String toString() {
            JSONObject r0 = new JSONObject();
            r0.put(KEY_IS_VIRTUAL_ENTRY_KEY, this.mIsVirtualEntry);     // Catch: JSONException -> L7
            r0.put(KEY_DEVICE_ID_KEY, this.mDeviceId);     // Catch: JSONException -> L7
            StandardWifiEntry.ScanResultKey r4 = this.mScanResultKey;     // Catch: JSONException -> L7
            if (r4 == null) goto L10;
            r0.put(KEY_SCAN_RESULT_KEY, r4.toString());     // Catch: JSONException -> L7
        L10:
            return HotspotNetworkEntry.KEY_PREFIX + r0.toString();
        L7:
            e = move-exception;
            Log.wtf(HotspotNetworkEntry.TAG, "JSONException while converting HotspotNetworkEntryKey to string: " + e);
            goto L10
        }

        public boolean isVirtualEntry() {
            return this.mIsVirtualEntry;
        }

        public long getDeviceId() {
            return this.mDeviceId;
        }

        StandardWifiEntry.ScanResultKey getScanResultKey() {
            return this.mScanResultKey;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    private static String getDeviceTypeId(int r1) {
        if (r1 != 1) goto L5;
        return "PHONE";
    L5:
        if (r1 != 2) goto L7;
        return "TABLET";
    L7:
        if (r1 != 3) goto L9;
        return "COMPUTER";
    L9:
        if (r1 != 4) goto L11;
        return "WATCH";
    L11:
        if (r1 == 5) goto L14;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L14:
        return "VEHICLE";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public int getPrivacy() {
        return 1;
    }

    HotspotNetworkEntry(WifiTrackerInjector r2, Context r3, Handler r4, WifiManager r5, SharedConnectivityManager r6, HotspotNetwork r7) {
        super(r2, r4, r5, false);
        this.mLastStatus = 0;
        this.mConnectionError = false;
        this.mInjector = r2;
        this.mContext = r3;
        this.mSharedConnectivityManager = r6;
        this.mHotspotNetworkData = r7;
        this.mKey = new HotspotNetworkEntryKey(r7);
    }

    HotspotNetworkEntry(WifiTrackerInjector r2, Context r3, Handler r4, WifiManager r5, SharedConnectivityManager r6, HotspotNetworkEntryKey r7) {
        super(r2, r4, r5, false);
        this.mLastStatus = 0;
        this.mConnectionError = false;
        this.mInjector = r2;
        this.mContext = r3;
        this.mSharedConnectivityManager = r6;
        this.mHotspotNetworkData = null;
        this.mKey = r7;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getKey() {
        return this.mKey.toString();
    }

    public HotspotNetworkEntryKey getHotspotNetworkEntryKey() {
        return this.mKey;
    }

    protected synchronized void updateHotspotNetworkData(HotspotNetwork r2) {
        monitor-enter(this);
        this.mHotspotNetworkData = r2;     // Catch: Throwable -> L6
        this.mKey = new HotspotNetworkEntryKey(r2);     // Catch: Throwable -> L6
        notifyOnUpdated();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected synchronized boolean connectionInfoMatches(WifiInfo r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mKey.isVirtualEntry() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r5 = Objects.equals(this.mKey.getScanResultKey(), new StandardWifiEntry.ScanResultKey(WifiInfo.sanitizeSsid(r4.getSSID()), Collections.singletonList(Integer.valueOf(r4.getCurrentSecurityType()))));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public int getLevel() {
        if (getConnectedState() != 0) goto L7;
        return 4;
    L7:
        return super.getLevel();
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getTitle() {
        monitor-enter(this);
        HotspotNetwork r0 = this.mHotspotNetworkData;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        String r1 = r0.getNetworkProviderInfo().getDeviceName();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L6:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSummary(boolean r6) {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L4:
        if (this.mHotspotNetworkData != null) goto L9;
        monitor-exit(this);
        return "";
    L9:
        if (this.mCalledConnect == false) goto L14;
        String r7 = this.mContext.getString(R.string.wifitrackerlib_hotspot_network_connecting);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r7;
    L14:
        if (this.mConnectionError == true) goto L16;
        MessageFormat r8 = new MessageFormat(this.mContext.getString(R.string.wifitrackerlib_hotspot_network_summary_new));     // Catch: Throwable -> L33
        HashMap r0 = new HashMap();     // Catch: Throwable -> L33
        r0.put(DEVICE_TYPE_KEY, getDeviceTypeId(this.mHotspotNetworkData.getNetworkProviderInfo().getDeviceType()));     // Catch: Throwable -> L33
        r0.put(NETWORK_NAME_KEY, this.mHotspotNetworkData.getNetworkName());     // Catch: Throwable -> L33
        String r9 = r8.format(r0);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r9;
    L16:
        switch(this.mLastStatus) {
            case 3: goto L24;
            case 4: goto L24;
            case 5: goto L21;
            case 6: goto L18;
            case 7: goto L18;
            case 8: goto L18;
            case 9: goto L18;
            default: goto L27;
        };     // Catch: Throwable -> L33
    L18:
        MessageFormat r10 = new MessageFormat(this.mContext.getString(R.string.wifitrackerlib_hotspot_network_summary_error_settings));     // Catch: Throwable -> L33
        HashMap r1 = new HashMap();     // Catch: Throwable -> L33
        r1.put(DEVICE_TYPE_KEY, getDeviceTypeId(this.mHotspotNetworkData.getNetworkProviderInfo().getDeviceType()));     // Catch: Throwable -> L33
        String r11 = r10.format(r1);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r11;
    L21:
        String r12 = this.mContext.getString(R.string.wifitrackerlib_hotspot_network_summary_error_carrier_block, new Object[]{BidiFormatter.getInstance().unicodeWrap(this.mHotspotNetworkData.getNetworkName())});     // Catch: Throwable -> L33
        monitor-exit(this);
        return r12;
    L24:
        String r13 = this.mContext.getString(R.string.wifitrackerlib_hotspot_network_summary_error_carrier_incomplete, new Object[]{BidiFormatter.getInstance().unicodeWrap(this.mHotspotNetworkData.getNetworkName())});     // Catch: Throwable -> L33
        monitor-exit(this);
        return r13;
    L27:
        String r14 = this.mContext.getString(R.string.wifitrackerlib_hotspot_network_summary_error_generic);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r14;
    }

    public synchronized String getAlternateSummary() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mHotspotNetworkData == null) goto L6;
        String r0 = this.mContext.getString(R.string.wifitrackerlib_hotspot_network_alternate, new Object[]{BidiFormatter.getInstance().unicodeWrap(this.mHotspotNetworkData.getNetworkName()), BidiFormatter.getInstance().unicodeWrap(this.mHotspotNetworkData.getNetworkProviderInfo().getDeviceName())});     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSsid() {
        monitor-enter(this);
        StandardWifiEntry.ScanResultKey r0 = this.mKey.getScanResultKey();     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        String r1 = r0.getSsid();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getMacAddress() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.mWifiInfo != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        String r0 = this.mWifiInfo.getMacAddress();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r0) == true) goto L15;
        if (TextUtils.equals(r0, "02:00:00:00:00:00") == true) goto L15;
        monitor-exit(this);
        return r0;
    L15:
        if (getPrivacy() == 1) goto L21;
        String[] r1 = this.mWifiManager.getFactoryMacAddresses();     // Catch: Throwable -> L23
        if (r1.length <= 0) goto L21;
        String r2 = r1[0];     // Catch: Throwable -> L23
        monitor-exit(this);
        return r2;
    L21:
        monitor-exit(this);
        return null;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSecurityString(boolean r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mHotspotNetworkData == null) goto L6;
        String r5 = Utils.getSecurityString(this.mContext, new ArrayList(this.mHotspotNetworkData.getHotspotSecurityTypes()), r4);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r5;
    L6:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getStandardString() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L6;
        String r0 = Utils.getStandardString(this.mContext, this.mWifiInfo.getWifiStandard());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getBandString() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L6;
        String r0 = Utils.wifiInfoToBandString(this.mContext, this.mWifiInfo);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return "";
    }

    public synchronized int getUpstreamConnectionStrength() {
        monitor-enter(this);
        HotspotNetwork r0 = this.mHotspotNetworkData;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        int r1 = r0.getNetworkProviderInfo().getConnectionStrength();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int getNetworkType() {
        monitor-enter(this);
        HotspotNetwork r0 = this.mHotspotNetworkData;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        int r1 = r0.getHostNetworkType();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int getDeviceType() {
        monitor-enter(this);
        HotspotNetwork r0 = this.mHotspotNetworkData;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        int r1 = r0.getNetworkProviderInfo().getDeviceType();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int getBatteryPercentage() {
        monitor-enter(this);
        HotspotNetwork r0 = this.mHotspotNetworkData;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        int r1 = r0.getNetworkProviderInfo().getBatteryPercentage();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isBatteryCharging() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mHotspotNetworkData != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (NonSdkApiWrapper.isNetworkProviderBatteryChargingStatusEnabled() == true) goto L11;
    L15:
        boolean r0 = this.mHotspotNetworkData.getNetworkProviderInfo().getExtras().getBoolean(EXTRA_KEY_IS_BATTERY_CHARGING, false);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L11:
        if (this.mHotspotNetworkData.getNetworkProviderInfo().isBatteryCharging() == false) goto L15;
        monitor-exit(this);
        return true;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canConnect() {
        monitor-enter(this);
        if (getConnectedState() != 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(final WifiEntry.ConnectCallback r3) {
        monitor-enter(this);
        this.mConnectCallback = r3;     // Catch: Throwable -> L12
        SharedConnectivityManager r0 = this.mSharedConnectivityManager;     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        if (r3 == null) goto L7;
        this.mCallbackHandler.post(new HotspotNetworkEntry$$ExternalSyntheticLambda2(r3));     // Catch: Throwable -> L12
    L7:
        monitor-exit(this);
        return;
    L9:
        r0.connectHotspotNetwork(this.mHotspotNetworkData);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$connect$0(WifiEntry.ConnectCallback r1) {
        r1.onConnectResult(2);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canDisconnect() {
        monitor-enter(this);
        if (getConnectedState() == 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void disconnect(final WifiEntry.DisconnectCallback r3) {
        monitor-enter(this);
        this.mCalledDisconnect = true;     // Catch: Throwable -> L13
        this.mDisconnectCallback = r3;     // Catch: Throwable -> L13
        SharedConnectivityManager r0 = this.mSharedConnectivityManager;     // Catch: Throwable -> L13
        if (r0 != null) goto L10;
        if (r3 == null) goto L8;
        this.mCallbackHandler.post(new HotspotNetworkEntry$$ExternalSyntheticLambda3(r3));     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);
        return;
    L10:
        r0.disconnectHotspotNetwork(this.mHotspotNetworkData);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$disconnect$1(WifiEntry.DisconnectCallback r1) {
        r1.onDisconnectResult(1);
    }

    public HotspotNetwork getHotspotNetworkData() {
        return this.mHotspotNetworkData;
    }

    public void onConnectionStatusChanged(int r4) {
        this.mLastStatus = r4;
        switch(r4) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L11;
        };
    L5:
        this.mCallbackHandler.post(new HotspotNetworkEntry$$ExternalSyntheticLambda1(this));
        this.mCalledConnect = false;
        this.mConnectionError = false;
        notifyOnUpdated();
        return;
    L6:
        this.mCallbackHandler.post(new HotspotNetworkEntry$$ExternalSyntheticLambda0(this));
        this.mCalledConnect = false;
        this.mConnectionError = true;
        notifyOnUpdated();
        return;
    L7:
        this.mCalledConnect = true;
        this.mConnectionError = false;
        notifyOnUpdated();
        return;
    }

    /* JADX INFO: renamed from: lambda$onConnectionStatusChanged$2$com-android-wifitrackerlib-HotspotNetworkEntry, reason: not valid java name */
    /* synthetic */ void m860x90008d20() {
        WifiEntry.ConnectCallback r1 = this.mConnectCallback;
        if (r1 == null) goto L6;
        r1.onConnectResult(2);
        return;
    }

    /* JADX INFO: renamed from: lambda$onConnectionStatusChanged$3$com-android-wifitrackerlib-HotspotNetworkEntry, reason: not valid java name */
    /* synthetic */ void m861xc9cb2eff() {
        WifiEntry.ConnectCallback r1 = this.mConnectCallback;
        if (r1 == null) goto L6;
        r1.onConnectResult(0);
        return;
    }
}
