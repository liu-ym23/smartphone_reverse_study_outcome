package com.android.settings.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PersistableBundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.settings.network.CarrierConfigCache;
import com.android.settings.overlay.FeatureFactory;
import com.android.wifitrackerlib.MergedCarrierEntry;
import com.android.wifitrackerlib.WifiEntry;
import com.android.wifitrackerlib.WifiPickerTracker;
import com.obric.olog.OLog;
import java.time.Clock;
import java.time.ZoneOffset;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class WifiPickerTrackerHelper implements LifecycleObserver {
    private static final Clock ELAPSED_REALTIME_CLOCK = null;
    private static final long MAX_SCAN_AGE_MILLIS = 15000;
    private static final long SCAN_INTERVAL_MILLIS = 10000;
    private static final String TAG = "WifiPickerTrackerHelper";
    protected final CarrierConfigCache mCarrierConfigCache;
    protected final WifiManager mWifiManager;
    protected WifiPickerTracker mWifiPickerTracker;
    protected HandlerThread mWorkerThread;

    static {
        final ZoneOffset r1 = ZoneOffset.UTC;
        ELAPSED_REALTIME_CLOCK = new AnonymousClass1(r1);
    }

    public WifiPickerTrackerHelper(Lifecycle r13, Context r14, WifiPickerTracker.WifiPickerTrackerCallback r15) {
        if (r13 == null) goto L7;
        r13.addObserver(this);
        HandlerThread r0 = new HandlerThread("WifiPickerTrackerHelper{" + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        this.mWorkerThread = r0;
        r0.start();
        this.mWifiPickerTracker = FeatureFactory.getFeatureFactory().getWifiTrackerLibProvider().createWifiPickerTracker(r13, r14, new Handler(Looper.getMainLooper()), this.mWorkerThread.getThreadHandler(), ELAPSED_REALTIME_CLOCK, 15000, SCAN_INTERVAL_MILLIS, r15);
        this.mWifiManager = (WifiManager) r14.getSystemService(WifiManager.class);
        this.mCarrierConfigCache = CarrierConfigCache.getInstance(r14);
        return;
    L7:
        throw new IllegalArgumentException("lifecycle must be non-null.");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.mWorkerThread.quit();
    }

    public WifiPickerTracker getWifiPickerTracker() {
        return this.mWifiPickerTracker;
    }

    public boolean isCarrierNetworkProvisionEnabled(int r3) {
        PersistableBundle r2 = this.mCarrierConfigCache.getConfigForSubId(r3);
        if (r2 != null) goto L6;
        OLog.e(TAG, "Could not get carrier config, subId:" + r3);
        return false;
    L6:
        boolean r4 = r2.getBoolean("carrier_provisions_wifi_merged_networks_bool");
        OLog.i(TAG, "isCarrierNetworkProvisionEnabled:" + r4);
        return r4;
    }

    public boolean isCarrierNetworkEnabled() {
        MergedCarrierEntry r3 = this.mWifiPickerTracker.getMergedCarrierEntry();
        if (r3 != null) goto L6;
        OLog.e(TAG, "Failed to get MergedCarrierEntry to query enabled status");
        return false;
    L6:
        boolean r4 = r3.isEnabled();
        OLog.i(TAG, "isCarrierNetworkEnabled:" + r4);
        return r4;
    }

    public void setCarrierNetworkEnabled(boolean r4) {
        MergedCarrierEntry r3 = this.mWifiPickerTracker.getMergedCarrierEntry();
        if (r3 != null) goto L6;
        OLog.e(TAG, "Unable to get MergedCarrierEntry to set enabled status");
        return;
    L6:
        OLog.i(TAG, "setCarrierNetworkEnabled:" + r4);
        r3.setEnabled(r4);
    }

    public boolean connectCarrierNetwork(WifiEntry.ConnectCallback r2) {
        MergedCarrierEntry r1 = this.mWifiPickerTracker.getMergedCarrierEntry();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.canConnect() == false) goto L11;
        r1.connect(r2);
        return true;
    L11:
        return false;
    }

    public boolean isCarrierNetworkActive() {
        MergedCarrierEntry r0 = this.mWifiPickerTracker.getMergedCarrierEntry();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isDefaultNetwork() == false) goto L7;
        return true;
    }

    public String getCarrierNetworkSsid() {
        MergedCarrierEntry r0 = this.mWifiPickerTracker.getMergedCarrierEntry();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSsid();
    }

    public int getCarrierNetworkLevel() {
        MergedCarrierEntry r1 = this.mWifiPickerTracker.getMergedCarrierEntry();
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = r1.getLevel();
        if (r2 >= 0) goto L9;
        return 0;
    L9:
        return r2;
    }

    void setWifiPickerTracker(WifiPickerTracker r1) {
        this.mWifiPickerTracker = r1;
    }

    void setWorkerThread(HandlerThread r1) {
        this.mWorkerThread = r1;
    }
}
