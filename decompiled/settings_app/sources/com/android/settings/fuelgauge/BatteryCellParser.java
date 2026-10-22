package com.android.settings.fuelgauge;

import android.os.BatteryStats;
import android.util.SparseIntArray;
import com.tencent.wcdb.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryCellParser implements BatteryInfo.BatteryDataParser, BatteryActiveView.BatteryActiveProvider {
    private final SparseIntArray mData;
    private long mLastTime;
    private int mLastValue;
    private long mLength;

    public BatteryCellParser() {
        this.mData = new SparseIntArray();
    }

    protected int getValue(BatteryStats.HistoryItem r3) {
        if (((r3.states & FileUtils.S_IRWXU) >> 6) != 3) goto L6;
        return 0;
    L6:
        if ((r3.states & 2097152) == 0) goto L9;
        return 1;
    L9:
        return ((r3.states & 56) >> 3) + 2;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onParsingStarted(long r1, long r3) {
        this.mLength = r3 - r1;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onDataPoint(long r3, BatteryStats.HistoryItem r5) {
        int r6 = getValue(r5);
        if (r6 == this.mLastValue) goto L5;
        this.mData.put((int) r3, r6);
        this.mLastValue = r6;
    L5:
        this.mLastTime = r3;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onDataGap() {
        if (this.mLastValue == 0) goto L6;
        this.mData.put((int) this.mLastTime, 0);
        this.mLastValue = 0;
        return;
    }

    @Override // com.android.settings.fuelgauge.BatteryInfo.BatteryDataParser
    public void onParsingDone() {
        if (this.mLastValue == 0) goto L6;
        this.mData.put((int) this.mLastTime, 0);
        this.mLastValue = 0;
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

    private int getColor(int r1) {
        return com.android.settings.Utils.BADNESS_COLORS[r1];
    }
}
