package tmsdkobf;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.qq.taf.jce.JceStruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tmsdk.bg.creator.BaseManagerB;
import tmsdk.bg.module.wifidetect.IWifiBatchDetectListener;
import tmsdk.bg.module.wifidetect.IWifiDetectListener;
import tmsdk.bg.module.wifidetect.WifiDetectManager;

/* JADX INFO: loaded from: classes5.dex */
public class jg extends BaseManagerB {
    private Context b;
    private WifiManager c;
    private Handler d;
    volatile AtomicBoolean e;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ jg f289a;

        a(jg r1, Looper r2) {
            this.f289a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            int r1 = r2.what;
            if (r1 != 4097) goto L8;
            q8.a("WifiDetectManager", "onResult-CLOUND_CHECK:[" + r2.arg1 + "]");
            IWifiDetectListener r3 = (IWifiDetectListener) r2.obj;
            if (r3 == null) goto L13;
            r3.onResult(r2.arg1);
            return;
        L13:
            return;
        L8:
            if (r1 != 4098) goto L15;
            IWifiBatchDetectListener r4 = (IWifiBatchDetectListener) r2.obj;
            if (r4 == null) goto L16;
            r4.onResult(r2.getData().getIntArray("RET"));
            return;
        L16:
            return;
        }
    }

    class b implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IWifiDetectListener f290a;
        final /* synthetic */ jg b;

        b(jg r1, IWifiDetectListener r2) {
            this.b = r1;
            this.f290a = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r3, int r4, int r5, int r6, JceStruct r7) {
            q8.a("WifiDetectManager", "onFinish retCode:[" + r5 + "]dataRetCode:[" + r6 + "]");
            q8.b("WifiDetectManager", "[WifiDetectManager] disconnect for detectDnsAndPhishing");
            Message r8 = jg.m2390$$Nest$fgetd(this.b).obtainMessage(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            if (r5 != 0) goto L17;
            if (r7 == null) goto L17;
            if ((r7 instanceof lc) == false) goto L17;
            lc r9 = (lc) r7;
            q8.c("WifiDetectManager", "detectDnsAndPhishing result=" + r9.f328a);
            int r10 = r9.f328a;
            if (r10 != 2) goto L11;
            q8.a("WifiDetectManager", "[CLOUND_CHECK_DNS_FAKE]ESafeType.EST_DnsException");
            f.a(1320068, "CLOUND_DNS_FAKE");
            int r11 = 18;
        L18:
            r8.arg1 = r11;
            r8.obj = this.f290a;
            jg.m2390$$Nest$fgetd(this.b).sendMessage(r8);
            return;
        L11:
            if (r10 != 3) goto L14;
            q8.a("WifiDetectManager", "[CLOUND_CHECK_PHISHING_FAKE]ESafeType.EST_Phishing");
            f.a(1320068, "CLOUND_PHISHING_FAKE");
            r11 = 19;
            goto L18
        L14:
            if (r10 != 4) goto L16;
            q8.a("WifiDetectManager", "[CLOUND_CHECK_PASSWORD_LEAK_RISK]ESafeType.EST_PasswordLeak");
            f.a(1320068, "CLOUND_PASSWORD_LEAK_RISK");
            r11 = 20;
            goto L18
        L16:
            q8.a("WifiDetectManager", "[CLOUND_CHECK_NO_FAKE]safeType:[" + r9.f328a + "]");
            f.a(1320068, "CLOUND_NO_FAKE");
            r11 = 17;
        L17:
            q8.a("WifiDetectManager", "[CLOUND_CHECK_NETWORK_ERROR]");
            r11 = 16;
            goto L18
        }
    }

    class c implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f291a;
        final /* synthetic */ u0 b;
        final /* synthetic */ int[] c;
        final /* synthetic */ Message d;
        final /* synthetic */ jg e;

        c(jg r1, int r2, u0 r3, int[] r4, Message r5) {
            this.e = r1;
            this.f291a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r2, int r3, int r4, int r5, JceStruct r6) {
            q8.a("WifiDetectManager", "onFinish Cmd_CSBatchGetCloudCheck retCode:[" + r4 + "]dataRetCode:[" + r5 + "]");
            q8.b("WifiDetectManager", "[WifiDetectManager] disconnect for detectPhishingBatch");
            if (r4 != 0) goto L22;
            if (r6 == null) goto L22;
            if ((r6 instanceof ec) == false) goto L22;
            ec r7 = (ec) r6;
            ArrayList r8 = r7.f178a;
            if (r8 != null) goto L10;
        L23:
            jg.m2390$$Nest$fgetd(this.e).sendMessage(this.d);
            return;
        L10:
            if (r8.size() != this.f291a) goto L23;
            int r9 = 0;
        L13:
            if (r9 >= this.f291a) goto L22;
            q8.c("WifiDetectManager", "[" + ((kg) this.b.f541a.get(r9)).f308a + "][" + ((Integer) r7.f178a.get(r9)).intValue() + "]");
            if (((Integer) r7.f178a.get(r9)).intValue() != 3) goto L18;
            this.c[r9] = 19;
        L21:
            r9 = r9 + 1;
            goto L13
        L18:
            if (((Integer) r7.f178a.get(r9)).intValue() != 4) goto L20;
            this.c[r9] = 20;
            goto L21
        L20:
            this.c[r9] = 17;
        L22:
            Bundle r10 = new Bundle();
            r10.putIntArray("RET", this.c);
            this.d.setData(r10);
            goto L23
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetd, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2390$$Nest$fgetd(jg r0) {
        return r0.d;
    }

    public jg() {
        this.e = new AtomicBoolean(false);
    }

    private String a(InputStream r2) {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r2));
        StringBuilder r3 = new StringBuilder();
    L20:
        String r0 = r1.readLine();     // Catch: Throwable -> L7 IOException -> L14
        if (r0 == null) goto L16;
        r3.append(r0);     // Catch: Throwable -> L7 IOException -> L14
    L7:
        th = move-exception;
        r1.close();     // Catch: IOException -> L13
    L9:
        throw th;
    L16:
        r1.close();     // Catch: IOException -> L15
    L12:
        return r3.toString();
    }

    private String b(InputStream r9) {
        String r8 = a(r9);
        q8.a("WifiDetectManager", "parsePage-pageContent:[" + r8 + "]");
        String[] r10 = {"http-equiv\\s*=\\s*[\"']*refresh[\"']*\\s*content\\s*=\\s*[\"']*[^;]*;\\s*url\\s*=\\s*[\"']*([^\"'\\s>]+)", "[^\\w](?:location.href\\s*=|location\\s*=|location.replace\\s*\\()\\s*[\"']*([^\"'>]+)", "<NextURL>([^<]+)", "\\s+action\\s*=\\s*[\"']*([^\"'>]+)[\"'>\\s]*.*submit", "<LoginURL>([^<]+)"};
        int r3 = 0;
        String r4 = null;
    L4:
        if (r3 >= 5) goto L16;
        if (r4 != null) goto L16;
        Matcher r5 = Pattern.compile(r10[r3], 2).matcher(r8);
    L8:
        if (r5.find() == false) goto L15;
        if (r4 != null) goto L15;
        r4 = r5.group(r5.groupCount());
        if (r4 == null) goto L8;
        if (r4.trim().toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L8;
        r4 = null;
    L15:
        r3 = r3 + 1;
    L16:
        q8.a("WifiDetectManager", "parsePage-location:[" + r4 + "]");
        return r4;
    }

    public synchronized int detectARPNoRoot(long r7) {
        monitor-enter(this);
        q8.a("WifiDetectManager", "[Beg]detectARPNoRoot");     // Catch: Throwable -> L17
        f.f(29978);     // Catch: Throwable -> L17
        String r3 = this.c.getConnectionInfo().getBSSID();     // Catch: Throwable -> L7
        r8.c("WIFI_ID", "WifiContext ｜ getSecurity， getBSSID = " + r3);     // Catch: Throwable -> L7
        int r8 = t.a().a(r3, r7);     // Catch: Throwable -> L7
    L10:
        if (r8 != 262) goto L13;
        String r9 = "NOROOT_ARP_FAKE";
    L12:
        f.a(1320068, r9);     // Catch: Throwable -> L17
        q8.a("WifiDetectManager", "[End]detectARPNoRoot-nRetState:[" + r8 + "]");     // Catch: Throwable -> L17
        monitor-exit(this);
        return r8;
    L13:
        r9 = "NOROOT_ARP_OK";
    L7:
        th = move-exception;
        q8.a("WifiDetectManager", "no root detect error:[" + th + "]");     // Catch: Throwable -> L17
        r8 = 261;
    L17:
        th = move-exception;
        throw th;
    }

    public int detectDnsAndPhishing(IWifiDetectListener r19, long r20) {
        f.f(29979);
        if (k9.b(this.b) == false) goto L35;
        q8.a("WifiDetectManager", "[Beg]detectDnsAndPhishinglistener:[" + r19 + "]");
        WifiInfo r2 = ((WifiManager) this.b.getSystemService("wifi")).getConnectionInfo();
        if (r2 != null) goto L8;
        return -2;
    L8:
        String r5 = lg.a(r2.getSSID());
        String r3 = r2.getBSSID();
        r8.c("WIFI_ID", "WifiDetectManagerImpl ｜ detectDnsAndPhishing, getSSID = " + r5 + ", getBSSID = " + r3);
        q8.a("WifiDetectManager", "ssid:[" + r5 + "]bssid:[" + r3 + "]");
        if (qe.b(r5) == false) goto L11;
    L33:
        q8.a("WifiDetectManager", "[End]detectDnsAndPhishing 参数不对");
        return -3;
    L11:
        if (qe.b(r3) == true) goto L33;
        String r6 = null;
        DhcpInfo r8 = this.c.getDhcpInfo();     // Catch: Exception -> L20
        if (r8 == null) goto L19;
        String r9 = gg.a(r8.dns1);     // Catch: Exception -> L20
        r6 = gg.a(r8.dns2);     // Catch: Exception -> L37
    L21:
        String r10 = r6;
        r6 = r9;
    L22:
        q8.a("WifiDetectManager", "dns1:[" + r6 + "]dns2:[" + r10 + "]");
        c1 r12 = new c1();
        kg r11 = new kg();
        r12.f122a = r11;
        r11.f308a = r5;
        r11.b = r3;
        r12.b = new ArrayList();
        if (r6 != null) goto L25;
    L27:
        if (r10 != null) goto L29;
    L31:
        q8.c("WifiDetectManager", "[wifi] ssid=" + r12.f122a.f308a + ", bssid=" + r12.f122a.b);
        za r13 = ve.e();
        q8.a("WifiDetectManager", "[GUID] " + r13.b());
        q8.a("WifiDetectManager", "[WifiDetectManager] connect for detectDnsAndPhishing");
        r13.a(794, r12, new lc(), 0, new b(this, r19), r20);
        d.a();
        q8.a("WifiDetectManager", "[End]detectDnsAndPhishing-ssid:[" + r5 + "]bssid:[" + r3 + "]");
        return 0;
    L29:
        if (r10.length() <= 0) goto L31;
        r12.b.add(r10);
        q8.c("WifiDetectManager", "[wifi] dns2=" + r10);
        goto L31
    L25:
        if (r6.length() <= 0) goto L27;
        r12.b.add(r6);
        q8.c("WifiDetectManager", "[wifi] dns1=" + r6);
        goto L27
    L19:
        r10 = null;
    L20:
        r9 = null;
        goto L21
    L35:
        q8.a("WifiDetectManager", "[WifiConnected false]");
        r19.onResult(-1);
        return -1;
    }

    public int detectNetworkState() {
        String r6 = ig.d();
        f.f(29981);
        q8.a("WifiDetectManager", "[Beg]detectNetworkState-urlApprove:[" + r6 + "]customHeader:[Meri]");
        int r7 = 2;
        HttpURLConnection r9 = null;
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L26
        q8.a("WifiDetectManager", "openConnection");     // Catch: Throwable -> L26
        HttpURLConnection r12 = (HttpURLConnection) new URL(r6).openConnection();     // Catch: Throwable -> L26
    L24:
        th = th;
        r9 = r12;
    L41:
        q8.a("WifiDetectManager", "Throwable:[" + th + "]");     // Catch: Throwable -> L33
        if (r9 == null) goto L31;
        r12 = r9;
    L30:
        r12.disconnect();
    L31:
        q8.a("WifiDetectManager", "[End]detectNetworkState-nRet:[" + r7 + "]");
        return r7;
    L33:
        th = move-exception;
        if (r9 == null) goto L36;
        r9.disconnect();
    L36:
        throw th;
    L5:
        if (vc.a() >= 8) goto L7;
        System.setProperty("http.keepAlive", "false");     // Catch: Throwable -> L24
    L7:
        r12.setUseCaches(false);     // Catch: Throwable -> L24
        r12.setRequestProperty("Pragma", "no-cache");     // Catch: Throwable -> L24
        r12.setRequestProperty("Cache-Control", "no-cache");     // Catch: Throwable -> L24
        r12.setInstanceFollowRedirects(false);     // Catch: Throwable -> L24
        r12.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L24
        r12.setReadTimeout(ActivityLifecycleObserver.BACKGROUND_DELAY_SECOND);     // Catch: Throwable -> L24
        int r1 = r12.getResponseCode();     // Catch: Throwable -> L24
        q8.a("WifiDetectManager", "getResponseCode:[" + r1 + "]timeMillis:[" + (System.currentTimeMillis() - r10) + "]");     // Catch: Throwable -> L24
        if (r1 != 200) goto L10;
    L13:
        String r2 = r12.getHeaderField("Meri");     // Catch: Throwable -> L24
        q8.a("WifiDetectManager", "customHeader: " + r2);     // Catch: Throwable -> L24
        if (r2 != null) goto L16;
    L19:
        String r15 = a(r6, r12);     // Catch: Throwable -> L24
        if (r15 == null) goto L30;
        if (r15.compareToIgnoreCase(ig.b()) == 0) goto L30;
        int r16 = 3;
    L18:
        r7 = r16;
        goto L30
    L16:
        if (r2.compareToIgnoreCase("Meri") != 0) goto L19;
        r16 = 1;
        goto L18
    L10:
        if (r1 < 301) goto L30;
        if (r1 > 305) goto L30;
    L26:
        th = th;
        goto L41
    }

    public int detectPhishingBatch(List r16, List r17, IWifiBatchDetectListener r18, long r19) {
        f.f(29979);
        Message r5 = this.d.obtainMessage(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        r5.obj = r18;
        if (k9.d() == false) goto L9;
        q8.a("WifiDetectManager", "detectPhishingBatchlistener:[" + r18 + "]");
        u0 r8 = new u0();
        r8.f541a = new ArrayList();
        int r2 = r16.size();
        int[] r4 = new int[r2];
        int r0 = 0;
    L5:
        if (r0 >= r2) goto L7;
        kg r6 = new kg();
        r6.f308a = lg.a((String) r16.get(r0));
        r6.b = (String) r17.get(r0);
        r8.f541a.add(r6);
        q8.c("WifiDetectManager", "[wifi] ssid=" + r6.f308a + ", bssid=" + r6.b);
        r4[r0] = 16;
        r0 = r0 + 1;
        goto L5
    L7:
        r8.h = la.e();
        za r7 = ve.e();
        q8.c("WifiDetectManager", "[GUID] " + r7.b());
        q8.a("WifiDetectManager", "[WifiDetectManager] connect for detectPhishingBatch");
        r7.a(800, r8, new ec(), 0, new c(this, r2, r8, r4, r5), r19);
        return 0;
    L9:
        q8.a("WifiDetectManager", "[isNetworkConnected false]");
        this.d.sendMessage(r5);
        return -1;
    }

    public int detectSSLStrip() {
        q8.a("WifiDetectManager", "[Beg]detectSSLStrip");
        f.f(1320084);
        long r5 = System.currentTimeMillis();
        if (k9.b(this.b) == true) goto L6;
        q8.a("WifiDetectManager", "[End]detectSSLStrip-SSLSTRIP_WIFI_NOTAVILABLE");
        return WifiDetectManager.SSLSTRIP_WIFI_NOTAVILABLE;
    L6:
        int r3 = WifiDetectManager.SSLSTRIP_OK;
        HttpURLConnection r7 = null;
        HttpURLConnection r8 = (HttpURLConnection) new URL(ig.a()).openConnection();     // Catch: Throwable -> L22
        r8.setConnectTimeout(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);     // Catch: Throwable -> L20
        r8.setReadTimeout(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);     // Catch: Throwable -> L20
        r8.setInstanceFollowRedirects(false);     // Catch: Throwable -> L20
        int r9 = r8.getResponseCode();     // Catch: Throwable -> L20
        List<String> r10 = r8.getHeaderFields().get("Location");     // Catch: Throwable -> L20
        if (r10 == null) goto L17;
        if (r10.size() != 1) goto L17;
        String r11 = r10.get(0).toLowerCase();     // Catch: Throwable -> L20
        q8.c("WifiDetectManager", "url: " + r11);     // Catch: Throwable -> L20
        if (r11.startsWith(ig.c()) == true) goto L19;
    L26:
        r8.disconnect();
    L27:
        q8.a("WifiDetectManager", "[End]detectSSLStrip-nRetState:[" + r3 + "]time(millis) elapsed:[" + (System.currentTimeMillis() - r5) + "]");
        if (r3 != 272) goto L30;
        String r13 = "SSLSTRIP_ATTACK";
    L31:
        f.a(1320068, r13);
        return r3;
    L30:
        r13 = "SSLSTRIP_OK";
    L19:
        r3 = 272;
    L17:
        if (r9 != 200) goto L26;
        q8.c("WifiDetectManager", "StatusCode 200");     // Catch: Throwable -> L20
    L20:
        th = th;
        r7 = r8;
    L38:
        q8.b("WifiDetectManager", "t:[" + th + "]");     // Catch: Throwable -> L33
        if (r7 == null) goto L27;
        r8 = r7;
    L33:
        th = move-exception;
        if (r7 == null) goto L36;
        r7.disconnect();
    L36:
        throw th;
    L22:
        th = th;
        goto L38
    }

    public int detectSecurity() {
        WifiManager r0 = this.c;
        if (r0 != null) goto L21;
        return -1;
    L21:
        List<ScanResult> r1 = r0.getScanResults();     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
        return -2;
    L9:
        if (r1.isEmpty() == true) goto L27;
        String r2 = this.c.getConnectionInfo().getBSSID();     // Catch: Throwable -> L17
        Iterator<ScanResult> r3 = r1.iterator();     // Catch: Throwable -> L17
    L12:
        if (r3.hasNext() == false) goto L28;
        ScanResult r4 = r3.next();     // Catch: Throwable -> L17
        if (r2.compareTo(r4.BSSID) != 0) goto L12;
        return detectSecurity(r4);
    L28:
        return -2;
    L27:
        return -2;
    L17:
        th = move-exception;
        q8.b("WifiDetectManager", th);
        return -2;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 2;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r3) {
        q8.a("WifiDetectManager", "OnCreate-context:[" + r3 + "]");
        this.b = r3;
        this.c = (WifiManager) r3.getSystemService("wifi");
        this.d = new a(this, Looper.getMainLooper());
    }

    private String a(String r12, HttpURLConnection r13) {
        InputStream r8 = null;
        String r14 = new URL(r12).getHost();     // Catch: Throwable -> L30
        String r9 = r13.getURL().getHost();     // Catch: Throwable -> L30
        q8.a("WifiDetectManager", "urlHost:[" + r14 + "]httpHost:[" + r9 + "]");     // Catch: Throwable -> L30
        if (r14.equals(r9) == true) goto L7;
        String r15 = r13.getURL().toExternalForm();     // Catch: Throwable -> L30
    L8:
        if (r15 == null) goto L42;
    L12:
        if (r15 == null) goto L14;
    L19:
        if (r15 != null) goto L28;
        r8 = r13.getInputStream();     // Catch: Throwable -> L35
        if (r8 == null) goto L24;
        String r11 = b(r8);     // Catch: Throwable -> L35
    L36:
        q8.a("WifiDetectManager", "333location:[" + r11 + "]");     // Catch: Throwable -> L27
        r15 = r11;
    L27:
        r15 = r11;
    L31:
        if (r8 != null) goto L40;
    L33:
        return r15;
    L40:
        r8.close();     // Catch: IOException -> L34
        goto L33
    L24:
        r11 = r15;
    L28:
        if (r8 == null) goto L33;
    L14:
        if (r13.getHeaderField("Refresh") == null) goto L19;
        String[] r0 = r13.getHeaderField("Refresh").split(";");     // Catch: Throwable -> L35
        if (r0.length != 2) goto L18;
        r15 = r0[1].trim();     // Catch: Throwable -> L35
    L18:
        q8.a("WifiDetectManager", "222location:[" + r15 + "]");     // Catch: Throwable -> L35
        goto L19
    L42:
        if (r13.getHeaderField("Location") == null) goto L12;
        r15 = r13.getHeaderField("Location");     // Catch: Throwable -> L35
        q8.a("WifiDetectManager", "111location:[" + r15 + "]");     // Catch: Throwable -> L35
        goto L12
    L7:
        r15 = null;
    L30:
        r15 = null;
        goto L31
    }

    public void b() {
        q8.c("WifiDetectManager", "touch > ArpAdapt.getInstance().stopArpAdapt()");
        t.a().b();
    }

    public int detectSecurity(ScanResult r4) {
        f.f(29980);
        q8.a("WifiDetectManager", "[Beg]detectSecurity-AP:[" + r4 + "]");
        if (r4 == null) goto L22;
        String r3 = r4.capabilities;
        if (r3 != null) goto L8;
        return -2;
    L8:
        if (r3.contains("WEP") == false) goto L11;
        int r5 = 257;
    L20:
        q8.a("WifiDetectManager", "[End]detectSecurity-Ret:[" + r5 + "]");
        return r5;
    L11:
        if (r4.capabilities.contains("PSK") == false) goto L14;
        r5 = 258;
        goto L20
    L14:
        if (r4.capabilities.contains("EAP") == false) goto L17;
        r5 = 259;
        goto L20
    L17:
        if (r4.capabilities.contains("SAE") == false) goto L19;
        r5 = 260;
        goto L20
    L19:
        r5 = 256;
        goto L20
    L22:
        return -2;
    }

    public int detectSecurity(WifiInfo r6) {
        if (r6 == null) goto L35;
        WifiManager r5 = this.c;
        if (r5 == null) goto L46;
        int r1 = 256;
        Iterator<WifiConfiguration> r7 = r5.getConfiguredNetworks().iterator();     // Catch: Throwable -> L32
    L10:
        if (r7.hasNext() == false) goto L34;
        WifiConfiguration r2 = r7.next();     // Catch: Throwable -> L32
        if (r2 == null) goto L10;
        if (r2.networkId != r6.getNetworkId()) goto L10;
        q8.a("WiFi Capabilities", r2.allowedKeyManagement.toString());     // Catch: Throwable -> L32
        if (r2.allowedKeyManagement.get(1) == false) goto L20;
        r1 = 258;
    L20:
        if (r2.allowedKeyManagement.get(2) == false) goto L22;
    L23:
        r1 = 259;
    L25:
        if (r2.allowedKeyManagement.get(8) == false) goto L28;
        r1 = 260;
    L28:
        if (r2.allowedAuthAlgorithms.get(1) == false) goto L30;
        r1 = 257;
    L30:
        q8.a("WifiDetectManager", "[End]detectSecurity-Ret:[" + r1 + "]");     // Catch: Throwable -> L32
        goto L34
    L22:
        if (r2.allowedKeyManagement.get(3) == false) goto L25;
    L34:
        return r1;
    L32:
        th = move-exception;
        q8.b("WifiDetectManager", th);
        goto L34
    L46:
        return -1;
    L35:
        return -1;
    }
}
