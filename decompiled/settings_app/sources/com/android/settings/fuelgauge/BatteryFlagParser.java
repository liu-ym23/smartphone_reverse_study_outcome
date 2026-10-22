package com.android.settings.fuelgauge;

import android.os.BatteryStats;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryFlagParser implements BatteryInfo.BatteryDataParser, BatteryActiveView.BatteryActiveProvider {
    private final int mAccentColor;
    private final SparseBooleanArray mData;
    private final int mFlag;
    private boolean mLastSet;
    private long mLastTime;
    private long mLength;
    private final boolean mState2;

    public BatteryFlagParser(int r2, boolean r3, int r4) {
        this.mData = new SparseBooleanArray();
        this.mAccentColor = r2;
        this.mFlag = r4;
        this.mState2 = r3;
    }

    protected boolean isSet(BatteryStats.HistoryItem r2) {
        if (this.mState2 == false) goto L5;
        int r3 = r2.states2;
    L7:
        if ((this.mFlag & r3) == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = r2.states;
        goto L7
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onParsingStarted(long r1, long r3) {
        this.mLength = r3 - r1;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onDataPoint(long r3, BatteryStats.HistoryItem r5) {
        boolean r6 = isSet(r5);
        if (r6 == this.mLastSet) goto L5;
        this.mData.put((int) r3, r6);
        this.mLastSet = r6;
    L5:
        this.mLastTime = r3;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onDataGap() {
        if (this.mLastSet == false) goto L6;
        this.mData.put((int) this.mLastTime, false);
        this.mLastSet = false;
        return;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onParsingDone() {
        if (this.mLastSet == false) goto L6;
        this.mData.put((int) this.mLastTime, false);
        this.mLastSet = false;
        return;
    }

    @Override // com.android.settings.fuelgauge.BatteryActiveView.BatteryActiveProvider
    public long getPeriod() {
        return this.mLength;
    }

    @Override // com.android.settings.fuelgauge.BatteryActiveView.BatteryActiveProvider
    public boolean hasData() {
        if (this.mData.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.settings.fuelgauge.BatteryActiveView.BatteryActiveProvider
    public SparseIntArray getColorArray() {
        SparseIntArray r0 = new SparseIntArray();
        int r1 = 0;
    L4:
        if (r1 >= this.mData.size()) goto L6;
        r0.put(this.mData.keyAt(r1), getColor(this.mData.valueAt(r1)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private int getColor(boolean r1) {
        if (r1 == true) goto L4;
        return 0;
    L4:
        return this.mAccentColor;
    }
}
