package com.android.settings.wifi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import com.android.wifitrackerlib.NetworkDetailsTracker;
import com.android.wifitrackerlib.WifiPickerTracker;
import java.time.Clock;

/* JADX INFO: loaded from: classes.dex */
public class WifiTrackerLibProviderImpl implements WifiTrackerLibProvider {
    public WifiTrackerLibProviderImpl() {
    }

    @Override // com.android.settings.wifi.WifiTrackerLibProvider
    public WifiPickerTracker createWifiPickerTracker(Lifecycle r15, Context r16, Handler r17, Handler r18, Clock r19, long r20, long r22, WifiPickerTracker.WifiPickerTrackerCallback r24) {
        return new WifiPickerTracker(r15, r16, (WifiManager) r16.getSystemService(WifiManager.class), (ConnectivityManager) r16.getSystemService(ConnectivityManager.class), r17, r18, r19, r20, r22, r24);
    }

    @Override // com.android.settings.wifi.WifiTrackerLibProvider
    public NetworkDetailsTracker createNetworkDetailsTracker(Lifecycle r13, Context r14, Handler r15, Handler r16, Clock r17, long r18, long r20, String r22) {
        return NetworkDetailsTracker.createNetworkDetailsTracker(r13, r14, (WifiManager) r14.getSystemService(WifiManager.class), (ConnectivityManager) r14.getSystemService(ConnectivityManager.class), r15, r16, r17, r18, r20, r22);
    }
}
