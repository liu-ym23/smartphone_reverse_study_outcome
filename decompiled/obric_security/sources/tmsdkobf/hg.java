package tmsdkobf;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f247a = null;

    static {
        f247a = new String[]{"OPEN", "WEP", "WPA_PSK", "WPA_EAP", "WPA_SAE"};
    }

    static int a(Context r4) {
        WifiManager r5 = (WifiManager) r4.getApplicationContext().getSystemService("wifi");
        List<WifiConfiguration> r0 = r5.getConfiguredNetworks();
        if (r0 != null) goto L5;
    L25:
        return 0;
    L5:
        if (r0.isEmpty() == true) goto L25;
        String r6 = r5.getConnectionInfo().getSSID();
        r8.c("WIFI_ID", "WifiContext ｜ getSecurity， getSSID = " + r6);
        int r2 = 0;
    L8:
        if (r2 >= r0.size()) goto L25;
        if (TextUtils.equals(r6, r0.get(r2).SSID) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        WifiConfiguration r7 = r0.get(r2);
        if (r7.allowedKeyManagement.get(1) == false) goto L15;
        return 2;
    L15:
        if (r7.allowedKeyManagement.get(2) == false) goto L17;
    L23:
        return 3;
    L17:
        if (r7.allowedKeyManagement.get(3) == true) goto L23;
        if (r7.wepKeys[0] != null) goto L22;
        return 0;
    L22:
        return 1;
    }
}
