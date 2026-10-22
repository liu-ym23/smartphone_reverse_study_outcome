package com.android.settingslib.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.hotspot2.PasspointConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiSavedConfigUtils {
    public WifiSavedConfigUtils() {
    }

    public static List<AccessPoint> getAllConfigs(Context r4, WifiManager r5) {
        ArrayList r0 = new ArrayList();
        Iterator<WifiConfiguration> r1 = r5.getConfiguredNetworks().iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        WifiConfiguration r2 = r1.next();
        if (r2.isPasspoint() == true) goto L4;
        if (r2.isEphemeral() == true) goto L4;
        r0.add(new AccessPoint(r4, r2));
        goto L4
    L21:
        List<PasspointConfiguration> r6 = r5.getPasspointConfigurations();     // Catch: UnsupportedOperationException -> L20
        if (r6 == null) goto L19;
        Iterator<PasspointConfiguration> r7 = r6.iterator();     // Catch: UnsupportedOperationException -> L20
    L16:
        if (r7.hasNext() == false) goto L19;
        r0.add(new AccessPoint(r4, r7.next()));     // Catch: UnsupportedOperationException -> L20
    L19:
        return r0;
    }

    public static int getAllConfigsCount(Context r0, WifiManager r1) {
        return getAllConfigs(r0, r1).size();
    }
}
