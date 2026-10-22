package tmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public abstract class bl {

    class a implements fl.a {
        a() {
        }

        @Override // tmsdkobf.fl.a
        public void a(boolean r1, boolean r2) {
        }
    }

    public static boolean a(int r2) {
        if (r2 < 300) goto L8;
        if (r2 > 303) goto L8;
        return true;
    L8:
        if (r2 != 307) goto L10;
    L14:
        return true;
    L10:
        if (r2 == 308) goto L14;
        return false;
    }

    public static int b() {
        NetworkInfo r1 = a();     // Catch: Throwable -> L21
        if (r1 != null) goto L8;
        return 0;
    L8:
        if (r1.getType() != 1) goto L12;
        return 2;
    L12:
        if (r1.getType() != 0) goto L24;
        String r2 = c();     // Catch: Throwable -> L21
        if (r2 != null) goto L16;
        return 4;
    L16:
        if (r2.length() <= 0) goto L26;
        if (d() <= 0) goto L27;
        return 3;
    L27:
        return 4;
    L26:
        return 4;
    L24:
        return 4;
    L28:
        return 4;
    }

    public static String c() {
    L7:
        return null;
    L3:
        if (e() == false) goto L5;
        String r0 = System.getProperty("http.proxyHost");     // Catch: Exception -> L7
    L9:
        return r0;
    L5:
        r0 = Proxy.getHost(rd.e());     // Catch: Exception -> L7
        goto L9
    }

    public static int d() {
    L7:
        return -1;
    L3:
        if (e() == false) goto L5;
        int r0 = Integer.parseInt(System.getProperty("http.proxyPort"));     // Catch: Exception -> L7
    L9:
        return r0;
    L5:
        r0 = Proxy.getPort(rd.e());     // Catch: Exception -> L7
        goto L9
    }

    private static boolean e() {
        return true;
    }

    public static boolean f() {
        NetworkInfo r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isConnected();
    }

    public static NetworkInfo a() {
        return ((ConnectivityManager) rd.e().getSystemService("connectivity")).getActiveNetworkInfo();
    L4:
        return null;
    }

    public static boolean a(String r7) {
        boolean r3 = false;
        InetSocketAddress r4 = new InetSocketAddress(InetAddress.getByName("www.qq.com"), 80);     // Catch: Throwable -> L7
        Socket r2 = new Socket();     // Catch: Throwable -> L7
        cj.a("TMSDK_SK_HB", "" + r2 + ":isDeviceNetworkOK");     // Catch: Throwable -> L13
        r2.setSoLinger(false, 0);     // Catch: Throwable -> L13
        r2.connect(r4, 5000);     // Catch: Throwable -> L13
        r3 = true;
        cj.a("TMSDK_SK_HB", "" + r2 + ":isDeviceNetworkOK, close");     // Catch: Throwable -> L12
    L10:
        r2.close();     // Catch: Throwable -> L12
    L8:
        if (r2 == null) goto L11;
        cj.a("TMSDK_SK_HB", "" + r2 + ":isDeviceNetworkOK, close");     // Catch: Throwable -> L12
    L7:
        r2 = null;
    L11:
        return r3;
    }

    public static boolean b(String r1) {
        if (2 == b()) goto L7;
        return false;
    L7:
        return !TextUtils.isEmpty(fl.a(new a()));
    }

    public static int a(Context r2) {
        ik.c = false;
        ik.a(r2);
        if (3 != ik.d) goto L7;
        return 1;
    L7:
        switch(ik.e) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L8;
        };
    L8:
        return 0;
    L9:
        return 10;
    L11:
        return 9;
    L13:
        return 8;
    L15:
        return 7;
    L17:
        return 6;
    L19:
        return 5;
    L21:
        return 4;
    L23:
        return 3;
    L24:
        return 2;
    }

    public static int b(Context r1) {
        ik.c = false;
        ik.a(r1);
        switch(ik.f) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L29;
            case 10: goto L27;
            case 11: goto L25;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L11;
            case 19: goto L9;
            case 20: goto L7;
            case 21: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 21;
    L7:
        return 20;
    L9:
        return 19;
    L11:
        return 18;
    L13:
        return 17;
    L15:
        return 16;
    L17:
        return 15;
    L19:
        return 14;
    L21:
        return 13;
    L23:
        return 12;
    L25:
        return 11;
    L27:
        return 10;
    L29:
        return 9;
    L31:
        return 8;
    L33:
        return 7;
    L35:
        return 6;
    L37:
        return 5;
    L39:
        return 4;
    L41:
        return 3;
    L43:
        return 2;
    L45:
        return 1;
    }
}
