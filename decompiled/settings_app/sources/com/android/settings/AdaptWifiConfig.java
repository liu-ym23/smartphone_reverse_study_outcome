package com.android.settings;

import android.net.wifi.WifiConfiguration;
import android.util.ReflectUtil;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptWifiConfig {
    private WifiConfiguration mConfig;

    public AdaptWifiConfig(WifiConfiguration r1) {
        this.mConfig = r1;
    }

    public boolean getSelfAdded() {
        return ((Boolean) ReflectUtil.acquireField(this.mConfig, "selfAdded")).booleanValue();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
