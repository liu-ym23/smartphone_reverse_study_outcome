package com.android.settings;

import android.net.wifi.WifiConfiguration;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptWifiAp {
    public static final int AP_BAND_2GHZ = 0;
    public static final int AP_BAND_5GHZ = 1;
    private Field mApBandField;
    private WifiConfiguration mConfig;

    public AdaptWifiAp(WifiConfiguration r2) {
        this.mConfig = r2;
        this.mApBandField = WifiConfiguration.class.getDeclaredField("apBand");     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setApBand(int r3) {
        this.mApBandField.setAccessible(true);
        this.mApBandField.set(this.mConfig, Integer.valueOf(r3));     // Catch: IllegalAccessException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public int getApBand() {
        return this.mApBandField.getInt(this.mConfig);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
