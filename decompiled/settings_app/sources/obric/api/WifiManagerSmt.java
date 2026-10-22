package obric.api;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.ReflectUtil;
import android.util.Singleton;

/* JADX INFO: loaded from: classes5.dex */
public class WifiManagerSmt {
    static final String TAG = "WifiManagerSmt";
    static final Singleton<WifiManagerSmt> sWifiManagerSmt = null;

    /* synthetic */ WifiManagerSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sWifiManagerSmt = new AnonymousClass1();
    }

    public static WifiManagerSmt getInstance() {
        return (WifiManagerSmt) sWifiManagerSmt.get();
    }

    private WifiManagerSmt() {
    }

    public String readConfiguredNetworkKey(WifiManager r4, WifiConfiguration r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return (String) ReflectUtil.invokeMethod(ReflectUtil.acquireField(r4, "mService"), "readConfiguredNetworkKey", new Class[]{WifiConfiguration.class}, new Object[]{r5});
    }
}
