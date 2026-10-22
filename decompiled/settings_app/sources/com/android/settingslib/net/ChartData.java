package com.android.settingslib.net;

import android.app.usage.NetworkStats;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChartData {
    public List<NetworkStats.Bucket> detail;
    public List<NetworkStats.Bucket> detailDefault;
    public List<NetworkStats.Bucket> detailForeground;
    public List<NetworkStats.Bucket> network;

    public ChartData() {
    }
}
