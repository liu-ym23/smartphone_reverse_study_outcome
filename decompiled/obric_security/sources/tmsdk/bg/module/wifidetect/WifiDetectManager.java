package tmsdk.bg.module.wifidetect;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.util.Log;
import java.util.List;
import tmsdk.bg.creator.BaseManagerB;
import tmsdkobf.b0;
import tmsdkobf.jg;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class WifiDetectManager extends BaseManagerB {
    public static final int ARP_ERROR = 263;
    public static final int ARP_FAKE = 262;
    public static final int ARP_OK = 261;
    public static final int CLOUND_CHECK_DNS_FAKE = 18;
    public static final int CLOUND_CHECK_NETWORK_ERROR = 16;
    public static final int CLOUND_CHECK_NO_FAKE = 17;
    public static final int CLOUND_CHECK_PASSWORD_LEAK_RISK = 20;
    public static final int CLOUND_CHECK_PHISHING_FAKE = 19;
    public static final int NETWORK_AVILABLE = 1;
    public static final int NETWORK_NOTAVILABLE = 2;
    public static final int NETWORK_NOTAVILABLE_APPROVE = 3;
    public static final int SECURITY_EAP = 259;
    public static final int SECURITY_NONE = 256;
    public static final int SECURITY_PSK = 258;
    public static final int SECURITY_SAE = 260;
    public static final int SECURITY_WEP = 257;
    public static final int SSLSTRIP_ATTACK = 272;
    public static final int SSLSTRIP_OK = 264;
    public static final int SSLSTRIP_WIFI_NOTAVILABLE = 265;
    private jg b;

    public WifiDetectManager() {
    }

    public int detectARPNoRoot(long r3) {
        if (b0.a() == false) goto L7;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L7:
        if (r3 < 0) goto L15;
        jg r2 = this.b;
        if (r2 != null) goto L11;
        return -11;
    L11:
        return r2.detectARPNoRoot(r3);
    L15:
        throw new IllegalArgumentException("maxOverTime less than zero");
    }

    public int detectDnsAndPhishing(IWifiDetectListener r3, long r4) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        if (r3 != null) goto L10;
        return -2;
    L10:
        if (r4 >= 2000) goto L12;
        r4 = 180000;
    L12:
        jg r2 = this.b;
        if (r2 != null) goto L15;
        return -11;
    L15:
        return r2.detectDnsAndPhishing(r3, r4);
    }

    public int detectNetworkState() {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        jg r1 = this.b;
        if (r1 != null) goto L9;
        return -11;
    L9:
        return r1.detectNetworkState();
    }

    public int detectPhishingBatch(List<String> r7, List<String> r8, IWifiBatchDetectListener r9, long r10) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        if (r9 == null) goto L25;
        if (r7 != null) goto L9;
        return -2;
    L9:
        if (r7.size() <= 0) goto L28;
        if (r8 != null) goto L12;
        return -2;
    L12:
        if (r8.size() > 0) goto L14;
        return -2;
    L14:
        if (r7.size() == r8.size()) goto L17;
        return -2;
    L17:
        if (r10 >= 2000) goto L19;
        r10 = 180000;
    L19:
        long r4 = r10;
        jg r0 = this.b;
        if (r0 != null) goto L22;
        return -11;
    L22:
        return r0.detectPhishingBatch(r7, r8, r9, r4);
    L28:
        return -2;
    L25:
        return -2;
    }

    public int detectSSLStrip() {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        jg r1 = this.b;
        if (r1 != null) goto L9;
        return -11;
    L9:
        return r1.detectSSLStrip();
    }

    public int detectSecurity() {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        jg r1 = this.b;
        if (r1 != null) goto L9;
        return -11;
    L9:
        return r1.detectSecurity();
    }

    public int free() {
        q8.c("WifiDetectManager", "free");
        if (b0.a() == false) goto L6;
        return -1;
    L6:
        return 0;
    }

    public int init() {
        q8.c("WifiDetectManager", "init");
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS init failed, missing check Licence SafeState !");
        return -1;
    L6:
        return 0;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        jg r0 = new jg();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void stopArp() {
        if (this.b == null) goto L6;
        q8.c("WifiDetectManager", "touch > mImpl.stopImplArp()");
        this.b.b();
        return;
    }

    public int detectSecurity(ScanResult r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        jg r1 = this.b;
        if (r1 != null) goto L9;
        return -11;
    L9:
        return r1.detectSecurity(r2);
    }

    public int detectSecurity(WifiInfo r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return -1;
    L6:
        jg r1 = this.b;
        if (r1 != null) goto L9;
        return -11;
    L9:
        return r1.detectSecurity(r2);
    }
}
