package com.android.settingslib.wifi;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TestAccessPointBuilder {
    private static final int MAX_RSSI = -55;
    private static final int MIN_RSSI = -100;
    private String mBssid;
    Context mContext;
    private String mFqdn;
    private int mNetworkId;
    private NetworkInfo mNetworkInfo;
    private String mProviderFriendlyName;
    private int mRssi;
    private ArrayList<ScanResult> mScanResults;
    private ArrayList<TimestampedScoredNetwork> mScoredNetworkCache;
    private int mSecurity;
    private int mSpeed;
    private WifiConfiguration mWifiConfig;
    private WifiInfo mWifiInfo;
    private String ssid;

    public TestAccessPointBuilder(Context r4) {
        this.mBssid = null;
        this.mSpeed = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mNetworkId = -1;
        this.ssid = "TestSsid";
        this.mNetworkInfo = null;
        this.mFqdn = null;
        this.mProviderFriendlyName = null;
        this.mSecurity = 0;
        this.mContext = r4;
    }

    public AccessPoint build() {
        Bundle r0 = new Bundle();
        if (this.mNetworkId == (-1)) goto L5;
        WifiConfiguration r1 = new WifiConfiguration();
        r1.networkId = this.mNetworkId;
        r1.BSSID = this.mBssid;
    L6:
        r0.putString("key_ssid", this.ssid);
        r0.putParcelable("key_config", r1);
        r0.putParcelable("key_networkinfo", this.mNetworkInfo);
        r0.putParcelable("key_wifiinfo", this.mWifiInfo);
        String r2 = this.mFqdn;
        if (r2 == null) goto L9;
        r0.putString("key_passpoint_unique_id", r2);
    L9:
        String r3 = this.mProviderFriendlyName;
        if (r3 == null) goto L12;
        r0.putString("key_provider_friendly_name", r3);
    L12:
        ArrayList<ScanResult> r4 = this.mScanResults;
        if (r4 == null) goto L15;
        r0.putParcelableArray("key_scanresults", (Parcelable[]) r4.toArray(new Parcelable[r4.size()]));
    L15:
        ArrayList<TimestampedScoredNetwork> r5 = this.mScoredNetworkCache;
        if (r5 == null) goto L18;
        r0.putParcelableArrayList("key_scorednetworkcache", r5);
    L18:
        r0.putInt("key_security", this.mSecurity);
        r0.putInt("key_speed", this.mSpeed);
        AccessPoint r6 = new AccessPoint(this.mContext, r0);
        r6.setRssi(this.mRssi);
        return r6;
    L5:
        r1 = null;
        goto L6
    }

    public TestAccessPointBuilder setActive(boolean r3) {
        if (r3 == false) goto L4;
        this.mNetworkInfo = new NetworkInfo(1, 1, "TestNetwork", "TestNetwork");
    L5:
        return this;
    L4:
        this.mNetworkInfo = null;
        goto L5
    }

    public TestAccessPointBuilder setLevel(int r3) {
        int r0 = ((WifiManager) this.mContext.getSystemService(WifiManager.class)).getMaxSignalLevel();
        if (r3 != 0) goto L5;
        this.mRssi = -100;
    L8:
        return this;
    L5:
        if (r3 <= r0) goto L7;
        this.mRssi = MAX_RSSI;
        goto L8
    L7:
        this.mRssi = (int) (((r3 * 45.0f) / r0) - 100.0f);
        goto L8
    }

    public TestAccessPointBuilder setNetworkInfo(NetworkInfo r1) {
        this.mNetworkInfo = r1;
        return this;
    }

    public TestAccessPointBuilder setRssi(int r1) {
        this.mRssi = r1;
        return this;
    }

    public TestAccessPointBuilder setSpeed(int r1) {
        this.mSpeed = r1;
        return this;
    }

    public TestAccessPointBuilder setReachable(boolean r2) {
        if (r2 == true) goto L5;
        this.mRssi = Integer.MIN_VALUE;
    L8:
        return this;
    L5:
        if (this.mRssi != Integer.MIN_VALUE) goto L8;
        this.mRssi = -100;
        goto L8
    }

    public TestAccessPointBuilder setSaved(boolean r1) {
        if (r1 == false) goto L4;
        this.mNetworkId = 1;
    L5:
        return this;
    L4:
        this.mNetworkId = -1;
        goto L5
    }

    public TestAccessPointBuilder setSecurity(int r1) {
        this.mSecurity = r1;
        return this;
    }

    public TestAccessPointBuilder setSsid(String r1) {
        this.ssid = r1;
        return this;
    }

    public TestAccessPointBuilder setFqdn(String r1) {
        this.mFqdn = r1;
        return this;
    }

    public TestAccessPointBuilder setProviderFriendlyName(String r1) {
        this.mProviderFriendlyName = r1;
        return this;
    }

    public TestAccessPointBuilder setWifiInfo(WifiInfo r1) {
        this.mWifiInfo = r1;
        return this;
    }

    public TestAccessPointBuilder setNetworkId(int r1) {
        this.mNetworkId = r1;
        return this;
    }

    public TestAccessPointBuilder setBssid(String r1) {
        this.mBssid = r1;
        return this;
    }

    public TestAccessPointBuilder setScanResults(ArrayList<ScanResult> r1) {
        this.mScanResults = r1;
        return this;
    }

    public TestAccessPointBuilder setScoredNetworkCache(ArrayList<TimestampedScoredNetwork> r1) {
        this.mScoredNetworkCache = r1;
        return this;
    }
}
