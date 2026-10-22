package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.Settings;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class fb {
    public static ArrayList a(ArrayList r8, Map r9) {
        if (r8 == null) goto L13;
        if (r9 == null) goto L21;
        ArrayList r0 = new ArrayList();
        Iterator r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        Integer r1 = (Integer) r10.next();
        b r2 = (b) r9.get(r1);
        if (r2 != null) goto L10;
        q8.e("QScanInternalUtils", "[virus_scan]cannot find AD plugin info for id: " + r1);
        goto L7
    L10:
        eb r3 = new eb();
        r3.f177a = r1.intValue();
        r3.b = r2.f104a;
        r3.c = (((long) r2.c) << 32) | ((long) r2.b);
        r3.d = r2.d;
        r3.e = r2.e;
        r3.f = r2.f;
        r0.add(r3);
        goto L7
    L12:
        return r0;
    L21:
        return null;
    L13:
        return null;
    }

    public static int b(Context r3) {
        if (r3 != null) goto L38;
        return 0;
    L38:
        ConnectivityManager r4 = (ConnectivityManager) r3.getSystemService("connectivity");     // Catch: Throwable -> L33
        if (r4 == null) goto L36;
        Network r1 = r4.getActiveNetwork();     // Catch: Throwable -> L33
        if (r1 == null) goto L36;
        NetworkCapabilities r5 = r4.getNetworkCapabilities(r1);     // Catch: Throwable -> L33
        if (r5 == null) goto L36;
        if (r5.hasCapability(12) == false) goto L36;
        if (r5.hasTransport(4) == false) goto L36;
        return 1;
    L36:
        Enumeration<NetworkInterface> r6 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L35
        if (r6 != null) goto L19;
        return 2;
    L19:
        if (r6.hasMoreElements() == false) goto L51;
        NetworkInterface r2 = r6.nextElement();     // Catch: Throwable -> L35
        String r7 = r2.getName();     // Catch: Throwable -> L35
        if (r2.isUp() == false) goto L19;
        if (TextUtils.isEmpty(r7) == true) goto L19;
        if (r7.startsWith("tun") == true) goto L30;
        if (r7.startsWith("ppp") == true) goto L30;
        if (r7.startsWith("wg") == false) goto L19;
    L30:
        return 1;
    L51:
        return 2;
    L50:
        return 2;
    L33:
        return 3;
    }

    private static ArrayList a(List r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList(r7.size() + 1);
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        g r1 = (g) r8.next();
        eb r2 = new eb();
        r2.f177a = r1.f207a;
        r2.b = r1.b;
        r2.c = (((long) r1.d) << 32) | ((long) r1.c);
        r2.d = r1.e;
        r2.e = r1.f;
        r2.f = r1.g;
        r0.add(r2);
        goto L7
    L9:
        return r0;
    }

    public static int a(Context r6) {
        if (r6 != null) goto L53;
        return 0;
    L53:
        Intent r3 = r6.registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"));     // Catch: Throwable -> L42
        if (r3 == null) goto L61;
        if (r3.getBooleanExtra("adb", false) == true) goto L57;
        if (r3.getBooleanExtra("connected", false) == false) goto L61;
        r6.unregisterReceiver(null);     // Catch: Throwable -> L40
        return 4;
    L63:
        return 4;
    L57:
        r6.unregisterReceiver(null);     // Catch: Throwable -> L41
    L11:
        return 1;
    L61:
        r6.unregisterReceiver(null);     // Catch: Throwable -> L43
    L49:
        UsbManager r4 = (UsbManager) r6.getSystemService("usb");     // Catch: Throwable -> L39
        if (r4 != null) goto L22;
    L24:
        int r5 = -1;
        Intent r7 = r6.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L45
        if (r7 == null) goto L47;
        r5 = r7.getIntExtra("plugged", -1);     // Catch: Throwable -> L45
        if (r5 != 2) goto L47;
        r6.unregisterReceiver(null);     // Catch: Throwable -> L44
    L30:
        return 1;
    L47:
        r6.unregisterReceiver(null);     // Catch: Throwable -> L46
    L32:
        if (Settings.Global.getInt(r6.getContentResolver(), "adb_enabled", -10) != 0) goto L35;
        return 2;
    L35:
        if (r5 != 0) goto L37;
        return 2;
    L37:
        return 3;
    L22:
        if (r4.getDeviceList().isEmpty() == true) goto L24;
        return 1;
    L39:
        return 2;
    }

    public static void a(gb r2, hb r3) {
        if (r3 == null) goto L7;
        if (r2 == null) goto L8;
        l r0 = r2.f216a;
        r3.f244a = r0.f313a;
        r3.b = r0.b;
        r3.c = r0.d;
        r3.d = r0.e;
        r3.e = r0.g;
        r3.f = r0.h;
        r3.i = r0.f;
        r3.j = r2.b;
        r3.k = r2.e;
        r3.l = r2.f;
        r3.m = r2.g;
        r3.n = r2.c;
        r3.o = r2.d;
        r3.q = r2.h;
        r3.r = r2.j;
        r3.A = r2.k;
        r3.B = r2.l;
        r3.C = a(r2.m);
        r3.m = r2.g;
        r3.E = r2.o;
        r3.M = r2.p;
        return;
    L8:
        return;
    }

    public static pb a(hb r9, boolean r10, int r11) {
        if (r9 != null) goto L5;
        return null;
    L5:
        pb r1 = new pb();
        r1.f416a = r11;
        r1.b = null;
        r1.c = r9.f244a;
        r1.d = d3.a(r9.g);
        ArrayList r12 = new ArrayList();
        ArrayList r2 = a(r9.h);
        if (r2.size() <= 0) goto L17;
        Iterator r3 = r2.iterator();
        int r4 = 0;
    L9:
        if (r3.hasNext() == false) goto L15;
        ArrayList r6 = (ArrayList) r3.next();
        ArrayList r7 = new ArrayList(r6.size());
        Iterator r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r7.add(d3.a((String) r8.next()));
        r4 = r4 + 1;
        goto L12
    L14:
        r12.add(r7);
        goto L9
    L15:
        if (r4 <= 1) goto L17;
        r1.u = r12;
    L17:
        r1.e = r9.i;
        r1.f = r9.b;
        r1.g = r9.d;
        r1.h = r9.c;
        r1.y = r9.N;
        r1.z = r9.O;
        r1.A = r9.P;
        r1.i = 0;
        if (r10 == true) goto L28;
        int r13 = r9.f;
        if (r13 != 1) goto L22;
        r1.i = 1;
    L22:
        if (r13 == 1) goto L24;
        if (r13 != 0) goto L28;
    L24:
        int r14 = r1.i;
        r1.i = r14 | 2;
        if (r9.f243J == false) goto L28;
        r1.i = r14 | 6;
    L28:
        if (r9.L == false) goto L30;
        r1.i |= 8;
    L30:
        r1.j = r9.B;
        r1.k = r9.r;
        r1.t = r9.j;
        r1.l = r9.l;
        r1.m = r9.E;
        ArrayList r15 = r9.C;
        if (r15 != null) goto L33;
    L39:
        r1.n = null;
    L40:
        r1.o = 0;
        if (r9.w == false) goto L44;
        r1.o = 1;
    L44:
        if (r9.x == false) goto L46;
        r1.o |= 2;
    L46:
        r1.p = r9.H;
        r1.q = r9.A;
        r1.r = r9.D;
        if (TextUtils.isEmpty(r9.Q) == true) goto L49;
        String r16 = r9.Q;
    L50:
        r1.D = r16;
        r1.C = tmsdk.common.module.qscanner.impl.a.f45a.a(r9.R, r9.S);
        r1.x = tmsdk.common.module.qscanner.impl.b.a(r9.e);     // Catch: Throwable -> L53
    L52:
        return r1;
    L49:
        r16 = tmsdk.common.module.qscanner.impl.a.f45a.d(r9.R);
        goto L50
    L33:
        if (r15.size() == 0) goto L39;
        r1.n = new ArrayList(r9.C.size());
        Iterator r17 = r9.C.iterator();
    L37:
        if (r17.hasNext() == false) goto L40;
        r1.n.add(Integer.valueOf(((eb) r17.next()).f177a));
        goto L37
    }

    public static ArrayList a(String r10) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r10) == false) goto L32;
        return r0;
    L32:
        String[] r11 = r10.split(";");     // Catch: Throwable -> L29
        if (r11 != null) goto L8;
    L31:
        return r0;
    L8:
        if (r11.length <= 0) goto L31;
        int r1 = r11.length;     // Catch: Throwable -> L29
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L31;
        String r4 = r11[r3];     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r4) == true) goto L28;
        String[] r5 = r4.split(",");     // Catch: Throwable -> L29
        if (r5 == null) goto L28;
        if (r5.length <= 0) goto L28;
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L29
        int r7 = r5.length;     // Catch: Throwable -> L29
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L26;
        String r9 = r5[r8];     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r9) == true) goto L24;
        r6.add(r9);     // Catch: Throwable -> L29
    L24:
        r8 = r8 + 1;     // Catch: Throwable -> L29
        goto L19
    L26:
        if (r6.size() <= 0) goto L28;
        r0.add(r6);     // Catch: Throwable -> L29
    L28:
        r3 = r3 + 1;
    L29:
        th = move-exception;
        q8.a("QScanInternalUtils", "str2aalStr: " + th, th);
        goto L31
    }
}
