package com.bytedance.bdlocation.scan.networklistener;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public interface WifiChangeListener {
    @RequiresApi(api = 21)
    void notifyWifiChanged(@NonNull Network r1, @NonNull NetworkCapabilities r2);

    void notifyWifiChangedTwo(NetworkInfo r1);
}
