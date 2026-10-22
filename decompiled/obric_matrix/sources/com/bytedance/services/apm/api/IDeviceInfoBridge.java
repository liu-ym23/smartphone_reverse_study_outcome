package com.bytedance.services.apm.api;

import android.content.Context;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceInfoBridge {
    Enumeration<NetworkInterface> NetworkInterface_getNetworkInterfaces();

    int TelephonyManager_getNetworkType(Context r1);
}
