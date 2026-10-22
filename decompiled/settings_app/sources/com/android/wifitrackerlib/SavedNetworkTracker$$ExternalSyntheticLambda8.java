package com.android.wifitrackerlib;

import android.net.wifi.ScanResult;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SavedNetworkTracker$$ExternalSyntheticLambda8 implements Function {
    public /* synthetic */ SavedNetworkTracker$$ExternalSyntheticLambda8() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return new StandardWifiEntry.ScanResultKey((ScanResult) r1);
    }
}
