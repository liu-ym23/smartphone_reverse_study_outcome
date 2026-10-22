package com.android.wifitrackerlib;

import android.net.wifi.ScanResult;
import android.util.ArrayMap;
import android.util.Pair;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ScanResultUpdater {
    private final Clock mClock;
    private final Object mLock;
    private final long mMaxScanAgeMillis;
    private Map<Pair<String, String>, ScanResult> mScanResultsBySsidAndBssid;

    public ScanResultUpdater(Clock r3) {
        this(r3, Long.MAX_VALUE);
    }

    public ScanResultUpdater(Clock r2, long r3) {
        this.mScanResultsBySsidAndBssid = new ArrayMap();
        this.mLock = new Object();
        this.mMaxScanAgeMillis = r3;
        this.mClock = r2;
    }

    public void update(List<ScanResult> r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        evictOldScans();     // Catch: Throwable -> L14
        Iterator<ScanResult> r9 = r8.iterator();     // Catch: Throwable -> L14
    L6:
        if (r9.hasNext() == false) goto L12;
        ScanResult r1 = r9.next();     // Catch: Throwable -> L14
        Pair<String, String> r2 = new Pair(r1.SSID, r1.BSSID);     // Catch: Throwable -> L14
        ScanResult r3 = this.mScanResultsBySsidAndBssid.get(r2);     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        if (r3.timestamp >= r1.timestamp) goto L6;
    L11:
        this.mScanResultsBySsidAndBssid.put(r2, r1);     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public List<ScanResult> getScanResults() {
        return getScanResults(this.mMaxScanAgeMillis);
    }

    public List<ScanResult> getScanResults(long r11) throws IllegalArgumentException {
        if (r11 > this.mMaxScanAgeMillis) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<ScanResult> r2 = this.mScanResultsBySsidAndBssid.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r2.hasNext() == false) goto L12;
        ScanResult r3 = r2.next();     // Catch: Throwable -> L14
        if ((this.mClock.millis() - (r3.timestamp / 1000)) > r11) goto L8;
        r1.add(r3);     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L14:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalArgumentException("maxScanAgeMillis argument cannot be greater than mMaxScanAgeMillis!");
    }

    private void evictOldScans() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mScanResultsBySsidAndBssid.entrySet().removeIf(new ScanResultUpdater$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$evictOldScans$0$com-android-wifitrackerlib-ScanResultUpdater, reason: not valid java name */
    /* synthetic */ boolean m868xaae8eb8b(Map.Entry r7) {
        if ((this.mClock.millis() - (((ScanResult) r7.getValue()).timestamp / 1000)) <= this.mMaxScanAgeMillis) goto L5;
        return true;
    L5:
        return false;
    }
}
