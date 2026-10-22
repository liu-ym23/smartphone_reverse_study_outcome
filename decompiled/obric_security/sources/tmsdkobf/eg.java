package tmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f183a;
    public String b;
    public String c;
    public WifiManager d;
    String e;
    String f;
    String g;
    ArrayList h;
    private ConnectivityManager i;
    private int j;
    private int k;
    private Context l;

    eg(Context r3) {
        this.f183a = "";
        this.b = "";
        this.c = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = new ArrayList();
        this.j = 0;
        this.k = 0;
        this.d = (WifiManager) r3.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L5
        this.i = (ConnectivityManager) r3.getSystemService("connectivity");     // Catch: Throwable -> L5
        this.l = r3;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q8.a("WSWifiInfo", "WSWifiInfo init error:", th);
    }

    private int a(int r1, int r2) {
        if (r2 != 0) goto L5;
        r2 = 16777215;
    L5:
        return r1 & r2;
    }

    static int b(int r2) {
        int r0 = ((r2 >> 24) & 255) + 1;
        if (r0 <= 255) goto L5;
        return -1;
    L5:
        return (r2 & 16777215) | (r0 << 24);
    }

    ArrayList a() {
        this.h.clear();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new FileReader("/proc/net/arp"));     // Catch: Throwable -> L22 Exception -> L32
        goto L26
    L39:
        r2.readLine();     // Catch: Throwable -> L19 Exception -> L21
    L5:
        String r3 = r2.readLine();     // Catch: Throwable -> L19 Exception -> L21
        if (r3 == null) goto L17;
        q8.a("ArpShield", r3);     // Catch: Throwable -> L19 Exception -> L21
        String[] r4 = r3.split("[ ]+");     // Catch: Throwable -> L19 Exception -> L21
        if (r4.length < 6) goto L5;
        String r5 = r4[0];     // Catch: Throwable -> L19 Exception -> L21
        String r6 = r4[3];     // Catch: Throwable -> L19 Exception -> L21
        if (r5.equals(this.e) == false) goto L14;
        this.f = r6;     // Catch: Throwable -> L19 Exception -> L21
    L14:
        if (r6.equals("00:00:00:00:00:00") == true) goto L5;
        r8.a("ArpShield", "ip:[" + r5 + "]mac:[" + r6 + "]");     // Catch: Throwable -> L19 Exception -> L21
        this.h.add(new String[]{r5, r6, ""});     // Catch: Throwable -> L19 Exception -> L21
        goto L5
    L17:
        r2.close();     // Catch: IOException -> L30
    L35:
        goto L29
    L21:
        r1 = r2;
    L19:
        th = th;
        r1 = r2;
    L23:
        if (r1 != null) goto L33;
    L25:
        throw th;
    L33:
        r1.close();     // Catch: IOException -> L31
    L22:
        th = th;
    L29:
        return this.h;
    L26:
        if (r1 == null) goto L29;
        r1.close();     // Catch: IOException -> L30
        goto L35
    }

    int b() {
        DhcpInfo r3 = this.d.getDhcpInfo();     // Catch: Throwable -> L13
        if (r3 != null) goto L6;
        return 0;
    L6:
        int r1 = r3.netmask;     // Catch: Throwable -> L13
        if (r1 != 0) goto L10;
        r1 = 16777215;
    L10:
        return r3.gateway & r1;
    L13:
        th = move-exception;
        q8.a("WSWifiInfo", "getStartAddress error:", th);
        return 0;
    }

    public boolean c() {
        NetworkInfo r3 = this.i.getNetworkInfo(1);     // Catch: Throwable -> L11
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isConnected() == false) goto L17;
        if (r3.isAvailable() == true) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    L11:
        th = move-exception;
        q8.a("WSWifiInfo", "isWifiConnected error:", th);
        return false;
    }

    public boolean d() {
        WifiInfo r9 = this.d.getConnectionInfo();     // Catch: Throwable -> L32
        DhcpInfo r10 = this.d.getDhcpInfo();     // Catch: Throwable -> L32
        if (this.d.isWifiEnabled() == true) goto L6;
    L30:
        q8.e("WSWifiInfo", " wifiInfo : " + r9 + ", dhcpInfo : " + r10);     // Catch: Throwable -> L32
        return false;
    L6:
        if (c() == false) goto L30;
        q8.a("WSWifiInfo", "wifiManager.isWifiEnabled() && isWifiConnected()");     // Catch: Throwable -> L32
        if (r9 == null) goto L29;
        if (r10 == null) goto L29;
        q8.a("WSWifiInfo", "wifiInfo != null && dhcpInfo != null");     // Catch: Throwable -> L32
        if (r9.getSupplicantState() != SupplicantState.COMPLETED) goto L28;
        q8.a("WSWifiInfo", "wifiInfo.getSupplicantState() == SupplicantState.COMPLETED");     // Catch: Throwable -> L32
        this.f183a = r9.getSSID();     // Catch: Throwable -> L32
        r8.c("WIFI_ID", "WifiContext ｜ getSecurity， getSSID = " + this.f183a);     // Catch: Throwable -> L32
        int r5 = r9.getIpAddress();     // Catch: Throwable -> L32
        if (this.f183a.charAt(0) != '\"') goto L18;
        String r6 = this.f183a;     // Catch: Throwable -> L32
        if (r6.charAt(r6.length() - 1) != '\"') goto L18;
        String r7 = this.f183a;     // Catch: Throwable -> L32
        this.f183a = r7.substring(1, r7.length() - 1);     // Catch: Throwable -> L32
    L18:
        if (c() == true) goto L20;
    L26:
        q8.a("WSWifiInfo", "SSID : " + this.f183a + ",isWifiConnected : " + c() + ", ip : " + r5);     // Catch: Throwable -> L32
        return false;
    L20:
        if (TextUtils.isEmpty(this.f183a) == true) goto L26;
        if ("<unknown ssid>".equalsIgnoreCase(this.f183a) == true) goto L26;
        if (r5 == 0) goto L26;
        this.b = r9.getBSSID();     // Catch: Throwable -> L32
        r8.c("WIFI_ID", "WifiContext ｜ getSecurity， getBSSID = " + this.b);     // Catch: Throwable -> L32
        this.e = a(r10.gateway);     // Catch: Throwable -> L32
        this.g = a(r5);     // Catch: Throwable -> L32
        int r0 = r10.netmask;     // Catch: Throwable -> L32
        this.k = r0;     // Catch: Throwable -> L32
        this.j = a(r10.gateway, r0);     // Catch: Throwable -> L32
        q8.a("WSWifiInfo", "网段IP = " + this.j);     // Catch: Throwable -> L32
        this.c = hg.f247a[hg.a(this.l)];     // Catch: Throwable -> L32
        goto L29
    L28:
        q8.e("WSWifiInfo", " wifiInfo.getSupplicantState() : " + r9.getSupplicantState());     // Catch: Throwable -> L32
    L29:
        return true;
    L32:
        th = move-exception;
        q8.a("WSWifiInfo", "refresh (Throwable)", th);
        return false;
    }

    static String a(int r3) {
        StringBuffer r0 = new StringBuffer();
        r0.append(r3 & 255);
        r0.append(LibrarianImpl.Constants.DOT);
        r0.append((r3 >> 8) & 255);
        r0.append(LibrarianImpl.Constants.DOT);
        r0.append((r3 >> 16) & 255);
        r0.append(LibrarianImpl.Constants.DOT);
        r0.append((r3 >> 24) & 255);
        return r0.toString();
    }

    boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return true;
    L5:
        String[] r6 = r5.split("\\.");
        if (r6 != null) goto L8;
    L15:
        return true;
    L8:
        if (r6.length != 4) goto L15;
        if (a(((Integer.parseInt(r6[0]) + (Integer.parseInt(r6[1]) << 8)) + (Integer.parseInt(r6[2]) << 16)) + (Integer.parseInt(r6[3]) << 24), this.k) != this.j) goto L14;
        return true;
    L14:
        return false;
    }
}
