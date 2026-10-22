package com.android.settings.wifi;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import com.android.wifitrackerlib.NetworkDetailsTracker;
import com.android.wifitrackerlib.WifiPickerTracker;
import java.time.Clock;

/* JADX INFO: loaded from: classes.dex */
public interface WifiTrackerLibProvider {
    NetworkDetailsTracker createNetworkDetailsTracker(Lifecycle r1, Context r2, Handler r3, Handler r4, Clock r5, long r6, long r8, String r10);

    WifiPickerTracker createWifiPickerTracker(Lifecycle r1, Context r2, Handler r3, Handler r4, Clock r5, long r6, long r8, WifiPickerTracker.WifiPickerTrackerCallback r10);
}
