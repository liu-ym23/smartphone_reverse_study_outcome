package com.android.settings.wifi.slice;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.android.settings.slices.SliceBackgroundWorker;
import com.android.settings.wifi.WifiPickerTrackerHelper;
import com.android.wifitrackerlib.WifiEntry;
import com.android.wifitrackerlib.WifiPickerTracker;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(forRemoval = true)
public class WifiScanWorker extends SliceBackgroundWorker<WifiSliceItem> implements WifiPickerTracker.WifiPickerTrackerCallback, LifecycleOwner, WifiEntry.WifiEntryCallback {
    private static final String TAG = "WifiScanWorker";
    final LifecycleRegistry mLifecycleRegistry;
    protected WifiPickerTracker mWifiPickerTracker;
    protected WifiPickerTrackerHelper mWifiPickerTrackerHelper;

    protected int getApRowCount() {
        return 3;
    }

    @Override // com.android.wifitrackerlib.WifiPickerTracker.WifiPickerTrackerCallback
    public void onNumSavedNetworksChanged() {
    }

    @Override // com.android.wifitrackerlib.WifiPickerTracker.WifiPickerTrackerCallback
    public void onNumSavedSubscriptionsChanged() {
    }

    public WifiScanWorker(Context r2, Uri r3) {
        super(r2, r3);
        LifecycleRegistry r4 = new LifecycleRegistry(this);
        this.mLifecycleRegistry = r4;
        WifiPickerTrackerHelper r0 = new WifiPickerTrackerHelper(r4, r2, this);
        this.mWifiPickerTrackerHelper = r0;
        this.mWifiPickerTracker = r0.getWifiPickerTracker();
        r4.markState(Lifecycle.State.INITIALIZED);
        r4.markState(Lifecycle.State.CREATED);
    }

    @Override // com.android.settings.slices.SliceBackgroundWorker
    protected void onSlicePinned() {
        this.mLifecycleRegistry.markState(Lifecycle.State.STARTED);
        this.mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
        updateResults();
    }

    @Override // com.android.settings.slices.SliceBackgroundWorker
    protected void onSliceUnpinned() {
        this.mLifecycleRegistry.markState(Lifecycle.State.STARTED);
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker.BaseWifiTrackerCallback
    public void onWifiStateChanged() {
        notifySliceChange();
    }

    @Override // com.android.wifitrackerlib.WifiPickerTracker.WifiPickerTrackerCallback
    public void onWifiEntriesChanged() {
        updateResults();
    }

    @Override // com.android.wifitrackerlib.WifiEntry.WifiEntryCallback
    public void onUpdated() {
        updateResults();
    }

    public WifiEntry getWifiEntry(String r3) {
        WifiEntry r0 = this.mWifiPickerTracker.getConnectedWifiEntry();
        if (r0 != null) goto L5;
    L7:
        Iterator<WifiEntry> r2 = this.mWifiPickerTracker.getWifiEntries().iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        WifiEntry r1 = r2.next();
        if (TextUtils.equals(r3, r1.getKey()) == false) goto L9;
        return r1;
    L13:
        return null;
    L5:
        if (TextUtils.equals(r3, r0.getKey()) == false) goto L7;
        return r0;
    }

    void updateResults() {
        if (this.mWifiPickerTracker.getWifiState() == 3) goto L5;
    L21:
        super.updateResults(null);
        return;
    L5:
        if (this.mLifecycleRegistry.getCurrentState() != Lifecycle.State.RESUMED) goto L21;
        ArrayList r0 = new ArrayList();
        WifiEntry r1 = this.mWifiPickerTracker.getConnectedWifiEntry();
        if (r1 == null) goto L10;
        r1.setListener(this);
        r0.add(new WifiSliceItem(getContext(), r1));
    L10:
        Iterator<WifiEntry> r2 = this.mWifiPickerTracker.getWifiEntries().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        WifiEntry r3 = r2.next();
        if (r0.size() >= getApRowCount()) goto L19;
        if (r3.getLevel() == (-1)) goto L12;
        r3.setListener(this);
        r0.add(new WifiSliceItem(getContext(), r3));
    L19:
        super.updateResults(r0);
    }

    public void setCarrierNetworkEnabledIfNeeded(boolean r2, int r3) {
        if (this.mWifiPickerTrackerHelper.isCarrierNetworkProvisionEnabled(r3) == true) goto L6;
        this.mWifiPickerTrackerHelper.setCarrierNetworkEnabled(r2);
        return;
    }

    public void connectCarrierNetwork() {
        this.mWifiPickerTrackerHelper.connectCarrierNetwork(null);
    }
}
