package com.android.wifitrackerlib;

import android.net.wifi.WifiConfiguration;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SavedNetworkTracker$$ExternalSyntheticLambda3 implements Function {
    public /* synthetic */ SavedNetworkTracker$$ExternalSyntheticLambda3() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return new StandardWifiEntry.StandardWifiEntryKey((WifiConfiguration) r1);
    }
}
