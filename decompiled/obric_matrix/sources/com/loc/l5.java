package com.loc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public final class l5 {
    private static boolean A = false;
    private static int B = -1;
    private static boolean C = false;
    private static int D = -1;
    private static boolean E = false;
    private static volatile d F = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f7527a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f7528b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile boolean f7529c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static String f7530d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7531e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7532f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f7533g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f7534h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f7535i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f7536j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f7537k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static IBinder f7538l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static String r = "";
    private static String s = "";
    static String t = "";
    private static String u = "";
    private static long v = 0;
    private static int w = 0;
    private static String x = null;
    private static String y = "";
    private static String z = "";

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7539g;

        a(Context r1) {
            this.f7539g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            Map<String, String> r1 = l5.f7533g.b();     // Catch: Throwable -> L10
            String r0 = l5.f7533g.a(l5.F(this.f7539g), "", "", l5.U());     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r0) == false) goto L6;
            return;
        L6:
            o0.b();     // Catch: Throwable -> L10
            u0 r2 = o0.c(l5.f7533g.c(r0.getBytes(), r1));     // Catch: Throwable -> L10
            String r5 = l5.f7533g.b(this.f7539g, new String(r2.f7856a));     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r5) == true) goto L13;
            l5.f7528b = r5;     // Catch: Throwable -> L10
            return;
        L13:
            return;
        }
    }

    final class b extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7540g;

        b(Context r1) {
            this.f7540g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            l5.f0(this.f7540g);
            l5.c0();
        }
    }

    public interface c {
        String a();

        String a(String r1, String r2, String r3, String r4);

        String b(Context r1, String r2);

        Map<String, String> b();

        t0 c(byte[] r1, Map<String, String> r2);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static BroadcastReceiver f7541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static ConnectivityManager f7542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static NetworkRequest f7543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f7544d;

        final class a extends BroadcastReceiver {
            a(d r1) {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r1, Intent r2) {
                if (u5.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(r2.getAction()) == false) goto L6;
                l5.a0();
                return;
            }
        }

        final class b extends ConnectivityManager.NetworkCallback {
            b(d r1) {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r1) {
                super.onAvailable(r1);
                l5.a0();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r1) {
                super.onLost(r1);
                l5.a0();
            }
        }

        static {
        }

        public d() {
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
        public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
            return r1.registerReceiver(r2, r3);
        L4:
            e = move-exception;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
            throw e;
        L8:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
        }

        @SuppressLint({"WrongConstant"})
        public final void b(Context r3) {
            if (Build.VERSION.SDK_INT >= 24) goto L10;
            if (r3 != null) goto L6;
            return;
        L6:
            if (f7541a != null) goto L20;
            f7541a = new a(this);
            IntentFilter r2 = new IntentFilter();
            r2.addAction(u5.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
            a(r3, f7541a, r2);
            return;
        L20:
            return;
        L10:
            if (l5.u(r3, u5.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L12;
            return;
        L12:
            if (r3 != null) goto L14;
            return;
        L14:
            if (f7542b != null) goto L22;
            ConnectivityManager r4 = (ConnectivityManager) r3.getSystemService("connectivity");
            f7542b = r4;
            if (r4 == null) goto L23;
            f7543c = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            b r5 = new b(this);
            f7544d = r5;
            f7542b.registerNetworkCallback(f7543c, r5);
            return;
        L23:
            return;
        }
    }

    static class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r1, IBinder r2) {
            l5.n(r2);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    static {
    }

    public static int A(Context r0) {
        return d(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String B() {
        if (Build.VERSION.SDK_INT < 29) goto L13;
        return "";
    L13:
        String r0 = U();     // Catch: Throwable -> L10
        if (r0.length() >= 5) goto L8;
        return "";
    L8:
        return r0.substring(3, 5);
    L10:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String C() {
        return "";
    }

    public static String D(Context r2) {
        if (f7536j == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(f7535i) == true) goto L11;
        return f7535i;
    L11:
        if (m == false) goto L15;
        return f7535i;
    L15:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L17;
        r1.f().d(new b(r2));     // Catch: Throwable -> L21
        goto L20
    L17:
        m = true;     // Catch: Throwable -> L21
        return a(r2);
    L20:
        return f7535i;
    }

    public static String E() {
        return "";
    }

    public static String F(Context r4) {
        if (n == false) goto L38;
        String r5 = f7527a;
        if (r5 != null) goto L7;
        return "";
    L7:
        return r5;
    L38:
        String r2 = f7527a;     // Catch: Throwable -> L31
        if (r2 == null) goto L16;
        if ("".equals(r2) == true) goto L16;
        return f7527a;
    L16:
        if (x(r4, u5.u("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L19;
        f7527a = Settings.System.getString(r4.getContentResolver(), "mqBRboGZkQPcAkyk");     // Catch: Throwable -> L31
    L19:
        if (TextUtils.isEmpty(f7527a) == true) goto L34;
        n = true;     // Catch: Throwable -> L31
        return f7527a;
    L34:
        String r3 = g0(r4);     // Catch: Throwable -> L32
        f7527a = r3;     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r3) == true) goto L36;
        n = true;     // Catch: Throwable -> L32
        return f7527a;
    L36:
        f7527a = h0(r4);     // Catch: Throwable -> L33
        n = true;     // Catch: Throwable -> L33
    L27:
        String r6 = f7527a;
        if (r6 != null) goto L30;
        return "";
    L30:
        return r6;
    }

    public static String G() {
        return "";
    }

    static String H(Context r3) {
        TelephonyManager r4 = g(r3);     // Catch: Throwable -> L13
        if (r4 != null) goto L6;
        return "";
    L6:
        String r5 = r4.getNetworkOperator();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return "";
    L9:
        if (r5.length() < 3) goto L17;
        return r5.substring(0, 3);
    L17:
        return "";
    L18:
        return "";
    }

    public static String I() {
        return o;
    }

    static String J(Context r3) {
        if (q == true) goto L5;
        m(r3);     // Catch: Throwable -> L20
        TelephonyManager r4 = g(r3);     // Catch: Throwable -> L20
        if (r4 == null) goto L9;
        String r5 = r4.getNetworkOperator();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r5) == false) goto L13;
    L16:
        q = true;     // Catch: Throwable -> L20
        return p;
    L13:
        if (r5.length() < 3) goto L16;
        p = r5.substring(3);     // Catch: Throwable -> L20
        q = true;     // Catch: Throwable -> L20
        goto L19
    L9:
        return p;
    L19:
        return p;
    L5:
        return p;
    }

    public static int K(Context r0) {
        return f(r0);
    L4:
        return -1;
    }

    static String[] L() {
        return new String[]{"", ""};
    }

    public static int M(Context r0) {
        return d(r0);
    L4:
        return -1;
    }

    public static String N() {
        return t;
    }

    public static NetworkInfo O(Context r2) {
        if (x(r2, u5.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L5;
        return null;
    L5:
        ConnectivityManager r3 = e(r2);
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getActiveNetworkInfo();
    }

    public static String P() {
        return s;
    }

    static String Q(Context r1) {
        NetworkInfo r2 = O(r1);     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return r2.getExtraInfo();
    L11:
        return null;
    }

    public static void R() {
        r.a();     // Catch: Throwable -> L4
        return;
    }

    public static String S() {
        return "";
    }

    static String T(Context r3) {
        String r0 = r;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L9:
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Throwable -> L21
        WindowManager r4 = (WindowManager) r3.getSystemService("window");     // Catch: Throwable -> L21
        if (r4 != null) goto L12;
        return "";
    L12:
        r4.getDefaultDisplay().getMetrics(r1);     // Catch: Throwable -> L21
        int r5 = r1.widthPixels;     // Catch: Throwable -> L21
        int r2 = r1.heightPixels;     // Catch: Throwable -> L21
        if (r2 <= r5) goto L17;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L21
        r6.append(r5);     // Catch: Throwable -> L21
        r6.append("*");     // Catch: Throwable -> L21
        r6.append(r2);     // Catch: Throwable -> L21
    L18:
        r = r6.toString();     // Catch: Throwable -> L21
        goto L20
    L17:
        r6 = new StringBuilder();     // Catch: Throwable -> L21
        r6.append(r2);     // Catch: Throwable -> L21
        r6.append("*");     // Catch: Throwable -> L21
        r6.append(r5);     // Catch: Throwable -> L21
        goto L18
    L6:
        if ("".equals(r0) == true) goto L9;
        return r;
    L20:
        return r;
    }

    public static String U() {
        return "";
    }

    public static String V(Context r2) {
    L12:
        return "";
    L4:
        if (x(r2, u5.u("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L6;
        TelephonyManager r3 = g(r2);     // Catch: Throwable -> L12
        if (r3 != null) goto L11;
        return "";
    L11:
        return r3.getNetworkOperatorName();
    L6:
        return y;
    }

    public static long W() {
        long r0 = v;
        if (r0 == 0) goto L13;
        return r0;
    L13:
        StatFs r1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L12
        StatFs r2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 18) goto L8;
        long r3 = (r1.getBlockCountLong() * r1.getBlockSizeLong()) / 1048576;     // Catch: Throwable -> L12
        long r6 = (r2.getBlockCountLong() * r2.getBlockSizeLong()) / 1048576;     // Catch: Throwable -> L12
    L9:
        v = r3 + r6;     // Catch: Throwable -> L12
        goto L11
    L8:
        r3 = (((long) r1.getBlockCount()) * ((long) r1.getBlockSize())) / 1048576;     // Catch: Throwable -> L12
        r6 = (((long) r2.getBlockCount()) * ((long) r2.getBlockSize())) / 1048576;     // Catch: Throwable -> L12
    L11:
        return v;
    }

    public static String X(Context r2) {
    L14:
        return "";
    L4:
        if (x(r2, u5.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return "";
    L6:
        ConnectivityManager r3 = e(r2);     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
        return "";
    L9:
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4.getTypeName();
    }

    public static String Y() {
        if (TextUtils.isEmpty(x) == false) goto L5;
        String r0 = System.getProperty("os.arch");
        x = r0;
        return r0;
    L5:
        return x;
    }

    public static String Z(Context r2) {
        String r0 = P();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = p(r2);     // Catch: Throwable -> L21
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = F(r2);     // Catch: Throwable -> L21
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        r0 = D(r2);     // Catch: Throwable -> L21
    L13:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = G();     // Catch: Throwable -> L21
    L16:
        if (TextUtils.isEmpty(r0) == false) goto L26;
        return b(r2);
    L26:
        return r0;
    L28:
        return r0;
    L19:
        return "";
    }

    private static String a(Context r4) {
        String r1 = u5.u("IeGlhb21p");
        String r2 = Build.MANUFACTURER;
        if (r1.equalsIgnoreCase(r2) == true) goto L50;
        String r0 = u5.u("IeGlhb21p");
        String r3 = Build.BRAND;
        if (r0.equalsIgnoreCase(r3) == true) goto L50;
        if (u5.u("IUkVETUk=").equalsIgnoreCase(r2) == true) goto L50;
        if (u5.u("IUkVETUk=").equalsIgnoreCase(r3) == true) goto L50;
        if (u5.u("Idml2bw").equalsIgnoreCase(r2) == true) goto L48;
        if (u5.u("Idml2bw").equalsIgnoreCase(r3) == true) goto L48;
        if (u5.u("IaHVhd2Vp").equalsIgnoreCase(r2) == true) goto L46;
        if (u5.u("IaHVhd2Vp").equalsIgnoreCase(r3) == true) goto L46;
        if (u5.u("ISE9OT1I=").equalsIgnoreCase(r2) == true) goto L46;
        if (u5.u("Mc2Ftc3VuZw").equalsIgnoreCase(r2) == true) goto L44;
        if (u5.u("Mc2Ftc3VuZw").equalsIgnoreCase(r3) == true) goto L44;
        if (u5.u("IT1BQTw").equalsIgnoreCase(r2) == true) goto L42;
        if (u5.u("IT1BQTw").equalsIgnoreCase(r3) == true) goto L42;
        if (u5.u("MT25lUGx1cw").equalsIgnoreCase(r2) == true) goto L42;
        if (u5.u("MT25lUGx1cw").equalsIgnoreCase(r3) == true) goto L42;
        if (u5.u("IUkVBTE1F").equalsIgnoreCase(r3) == true) goto L42;
        f7536j = true;
        return f7535i;
    L42:
        return q(r4, 5);
    L44:
        return q(r4, 4);
    L46:
        return q(r4, 2);
    L48:
        return k0(r4);
    L50:
        return j0(r4);
    }

    public static void a0() {
        B = -1;
        C = false;
        D = -1;
        E = false;
        z = "";
        A = false;
        p = "";
        q = false;
    }

    private static String b(Context r6) {
        if (TextUtils.isEmpty(u) == false) goto L5;
        String r3 = d0.p(r6, "open_common", "a1", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == false) goto L9;
        u = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r7 = d0.d(r6, "open_common");     // Catch: Throwable -> L12
        d0.k(r7, "a1", u5.q(u));     // Catch: Throwable -> L12
        d0.g(r7);     // Catch: Throwable -> L12
    L11:
        return u;
    L9:
        u = u5.u(r3);     // Catch: Throwable -> L12
        goto L11
    L13:
        return u;
    L5:
        return u;
    }

    public static int b0(Context r4) {
        int r0 = w;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if (Build.VERSION.SDK_INT < 16) goto L11;
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");
        if (r5 != null) goto L10;
        return 0;
    L10:
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r5.getMemoryInfo(r1);
        r2 = (int) (r1.totalMem / 1024);
    L18:
        int r3 = r2 / 1024;
        w = r3;
        return r3;
    L11:
        BufferedReader r6 = null;
        BufferedReader r7 = new BufferedReader(new FileReader(new File("/proc/meminfo")));     // Catch: Throwable -> L21
        r2 = Integer.valueOf(r7.readLine().split("\\s+")[1]).intValue();     // Catch: Throwable -> L15
        r7.close();     // Catch: IOException -> L20
    L24:
    L15:
        r6 = r7;
    L16:
        if (r6 == null) goto L18;
        r6.close();     // Catch: IOException -> L20
        goto L24
    }

    private static String c(Context r1) {
        if (A == true) goto L5;
        m(r1);
        TelephonyManager r2 = g(r1);
        if (r2 == null) goto L9;
        String r0 = r2.getSimOperatorName();
        z = r0;
        if (TextUtils.isEmpty(r0) == false) goto L13;
        z = r2.getNetworkOperatorName();
    L13:
        A = true;
        return z;
    L9:
        return z;
    L5:
        return z;
    }

    static /* synthetic */ boolean c0() {
        m = true;
        return true;
    }

    private static int d(Context r1) {
        if (C == true) goto L5;
        m(r1);
        if (r1 == null) goto L22;
        if (x(r1, u5.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L22;
        ConnectivityManager r2 = e(r1);
        if (r2 == null) goto L14;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 != null) goto L19;
        C = true;
        return B;
    L19:
        int r4 = r3.getType();
        B = r4;
        C = true;
        return r4;
    L14:
        return B;
    L22:
        return B;
    L5:
        return B;
    }

    static String d0(Context r0) {
        return c(r0);
    L4:
        return "";
    }

    private static ConnectivityManager e(Context r1) {
        return (ConnectivityManager) r1.getSystemService("connectivity");
    }

    public static String e0(Context r1) {
        if (TextUtils.isEmpty(f7532f) == false) goto L6;
        f7532f = com.loc.e.a(r1);     // Catch: Throwable -> L7
    L6:
        return f7532f;
    }

    private static int f(Context r1) {
        if (E == true) goto L5;
        m(r1);
        if (x(r1, u5.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L9;
        ConnectivityManager r2 = e(r1);
        if (r2 == null) goto L13;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 == null) goto L20;
        if (r3.isAvailable() == false) goto L20;
        D = r3.getSubtype();
        E = true;
    L20:
        return D;
    L13:
        return D;
    L9:
        return D;
    L5:
        return D;
    }

    static /* synthetic */ String f0(Context r0) {
        return a(r0);
    }

    private static TelephonyManager g(Context r1) {
        return (TelephonyManager) r1.getSystemService("phone");
    }

    private static String g0(Context r4) {
        String r2 = d0.p(r4, "Alvin2", "UTDID2", "");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return d0.p(r4, "Alvin2", "UTDID", "");
    L10:
        return r2;
    L7:
        return "";
    }

    private static String h(Context r6) {
        if (f7529c == true) goto L5;
        return "";
    L5:
        String r1 = null;
        r1 = i(r6);     // Catch: Throwable -> L15
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L16;
        f7529c = false;
        return "";
    L16:
        byte[] r7 = u5.u("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");     // Catch: Throwable -> L13
        byte[] r2 = m5.g(r1);     // Catch: Throwable -> L13
        return new String(m5.e(u5.u("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), r2, r7), "UTF-8");
    L13:
        f7529c = false;
        return "";
    }

    private static String h0(Context r8) {
        FileInputStream r0 = null;
        if (u5.l(r8, "android.permission.READ_EXTERNAL_STORAGE") == true) goto L6;
    L37:
        if (r0 != null) goto L49;
        return "";
    L49:
        r0.close();     // Catch: Throwable -> L45
        return "";
    L66:
        return "";
    L6:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L37;
        File r1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L46
        XmlPullParser r9 = Xml.newPullParser();     // Catch: Throwable -> L46
        int r2 = r9.getEventType();     // Catch: Throwable -> L46
        FileInputStream r3 = new FileInputStream(r1);     // Catch: Throwable -> L46
        r9.setInput(r3, "utf-8");     // Catch: Throwable -> L36
        boolean r4 = false;
    L10:
        if (1 == r2) goto L35;
        if (r2 == 2) goto L24;
        if (r2 != 3) goto L16;
        r4 = false;
    L33:
        r2 = r9.next();     // Catch: Throwable -> L36
        goto L10
    L16:
        if (r2 != 4) goto L33;
        if (r4 == false) goto L33;
        String r10 = r9.getText();     // Catch: Throwable -> L36
        r3.close();     // Catch: Throwable -> L44
    L21:
        return r10;
    L24:
        if (r9.getAttributeCount() <= 0) goto L33;
        int r5 = r9.getAttributeCount();     // Catch: Throwable -> L36
        int r6 = 0;
    L26:
        if (r6 >= r5) goto L33;
        String r7 = r9.getAttributeValue(r6);     // Catch: Throwable -> L36
        if ("UTDID2".equals(r7) == false) goto L30;
    L31:
        r4 = true;
    L32:
        r6 = r6 + 1;     // Catch: Throwable -> L36
        goto L26
    L30:
        if ("UTDID".equals(r7) == false) goto L32;
    L35:
        r0 = r3;
    L36:
        r0 = r3;
    L40:
        if (r0 != null) goto L49;
        return "";
    }

    private static String i(Context r3) {
        String r1 = k(r3);     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        return r1;
    L9:
        if (r3 != null) goto L12;
        return "";
    L12:
        return j(r3, u5.u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(p5.a(u5.u("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    L5:
        r1 = "";
        goto L7
    }

    private static String i0(Context r5) {
    L14:
        return "";
    L3:
        if (TextUtils.isEmpty(f7537k) == false) goto L5;
        Signature[] r6 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 64).signatures;     // Catch: Throwable -> L14
        int r0 = 0;
        byte[] r7 = r6[0].toByteArray();     // Catch: Throwable -> L14
        byte[] r8 = MessageDigest.getInstance(u5.u("IU0hBMQ")).digest(r7);     // Catch: Throwable -> L14
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L14
    L8:
        if (r0 >= r8.length) goto L10;
        r1.append(Integer.toHexString((r8[r0] & 255) | 256).substring(1, 3));     // Catch: Throwable -> L14
        r0 = r0 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r9 = r1.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r9) == true) goto L13;
        f7537k = r9;     // Catch: Throwable -> L14
    L13:
        return r9;
    L5:
        return f7537k;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences j(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static String j0(Context r7) {
        Class<?> r1 = Class.forName(u5.u("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));     // Catch: Throwable -> L7
        Object r2 = r1.newInstance();     // Catch: Throwable -> L7
        Object r8 = r1.getMethod(u5.u("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r2, new Object[]{r7});     // Catch: Throwable -> L7
        if (r8 == null) goto L10;
        String r9 = (String) r8;     // Catch: Throwable -> L7
        f7535i = r9;     // Catch: Throwable -> L7
        return r9;
    L10:
        return f7535i;
    L7:
        th = move-exception;
        s.e(th, "oa", "xm");
        f7536j = true;
        goto L10
    }

    private static String k(Context r8) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
    L7:
        String r1 = p5.a(u5.u("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String r9 = l(r8);
        if (TextUtils.isEmpty(r9) == false) goto L10;
        return "";
    L10:
        File r3 = new File(r9 + File.separator + u5.u("KYmFja3Vwcw"), u5.u("MLmFkaXU"));
        if (r3.exists() == true) goto L13;
    L44:
        return "";
    L13:
        if (r3.canRead() == false) goto L44;
        if (r3.length() != 0) goto L19;
        r3.delete();
        return "";
    L19:
        ByteArrayOutputStream r10 = null;
        RandomAccessFile r4 = new RandomAccessFile(r3, "r");     // Catch: Throwable -> L41
        byte[] r5 = new byte[1024];     // Catch: Throwable -> L45
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: Throwable -> L45
    L46:
        int r11 = r4.read(r5);     // Catch: Throwable -> L40
        if (r11 == (-1)) goto L26;
        r6.write(r5, 0, r11);     // Catch: Throwable -> L40
        goto L46
    L26:
        String r12 = new String(r6.toByteArray(), "UTF-8");     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r12) == false) goto L29;
    L39:
        s(r6);
    L43:
        s(r4);
        goto L44
    L29:
        if (r12.contains(u5.u("SIw")) == false) goto L39;
        String[] r13 = r12.split(u5.u("SIw"));     // Catch: Throwable -> L40
        if (r13 == null) goto L39;
        if (r13.length != 2) goto L39;
        if (TextUtils.equals(r1, r13[0]) == false) goto L39;
        String r14 = r13[1];     // Catch: Throwable -> L40
        s(r6);
        s(r4);
        return r14;
    L40:
        r10 = r6;
    L42:
        s(r10);
    L41:
        r4 = null;
        goto L42
    L5:
        if (x(r8, u5.u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == true) goto L7;
        return "";
    }

    private static String k0(Context r6) {
        Cursor r7 = r6.getContentResolver().query(Uri.parse(u5.u("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);     // Catch: Throwable -> L14
        if (r7 == null) goto L17;
    L5:
        if (r7.moveToNext() == false) goto L12;
        int r0 = r7.getColumnCount();     // Catch: Throwable -> L14
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L5;
        if (u5.u("IdmFsdWU").equals(r7.getColumnName(r1)) == true) goto L10;
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        f7535i = r7.getString(r1);     // Catch: Throwable -> L14
        goto L5
    L12:
        r7.close();     // Catch: Throwable -> L14
    L17:
        return f7535i;
    L14:
        th = move-exception;
        f7536j = true;
        s.e(th, "oa", "vivo");
        goto L17
    }

    private static String l(Context r9) {
        if (Build.VERSION.SDK_INT >= 9) goto L13;
        return null;
    L13:
        StorageManager r10 = (StorageManager) r9.getSystemService("storage");     // Catch: Throwable -> L12
        Class<?> r0 = Class.forName(u5.u("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));     // Catch: Throwable -> L12
        Method r2 = r10.getClass().getMethod(u5.u("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);     // Catch: Throwable -> L12
        Method r3 = r0.getMethod(u5.u("FZ2V0UGF0aA"), new Class[0]);     // Catch: Throwable -> L12
        Method r1 = r0.getMethod(u5.u("DaXNSZW1vdmFibGU"), new Class[0]);     // Catch: Throwable -> L12
        Object r11 = r2.invoke(r10, new Object[0]);     // Catch: Throwable -> L12
        int r4 = Array.getLength(r11);     // Catch: Throwable -> L12
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L11;
        Object r6 = Array.get(r11, r5);     // Catch: Throwable -> L12
        String r7 = (String) r3.invoke(r6, new Object[0]);     // Catch: Throwable -> L12
        if (((Boolean) r1.invoke(r6, new Object[0])).booleanValue() == false) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        return r7;
    L11:
        return null;
    }

    private static synchronized d m(Context r2) {
        monitor-enter(l5.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (F != null) goto L11;
        if (r2 == null) goto L8;
        d r1 = new d();     // Catch: Throwable -> L14
        F = r1;     // Catch: Throwable -> L14
        r1.b(r2.getApplicationContext());     // Catch: Throwable -> L14
        goto L11
    L8:
        monitor-exit(l5.class);
        return null;
    L11:
        d r3 = F;     // Catch: Throwable -> L14
        monitor-exit(l5.class);
        return r3;
    }

    static /* synthetic */ IBinder n(IBinder r0) {
        f7538l = r0;
        return r0;
    }

    public static String o() {
        return f7531e;
    }

    public static String p(Context r3) {
        if (TextUtils.isEmpty(f7528b) == false) goto L6;
        if (r3 != null) goto L9;
        return "";
    L9:
        String r1 = h(r3);     // Catch: Throwable -> L21
        f7528b = r1;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1) == true) goto L14;
        return f7528b;
    L14:
        if (z() != null) goto L17;
        return "";
    L17:
        if (f7534h == false) goto L19;
        return "";
    L19:
        f7534h = true;     // Catch: Throwable -> L21
        r1.f().d(new a(r3));     // Catch: Throwable -> L21
        goto L20
    L6:
        return f7528b;
    L20:
        return "";
    }

    private static String q(Context r12, int r13) {
        Intent r1 = new Intent();     // Catch: Throwable -> L46
        if (r13 == 2) goto L11;
        if (r13 == 4) goto L10;
        if (r13 == 5) goto L9;
        f7536j = true;     // Catch: Throwable -> L46
        return f7535i;
    L9:
        r1.setClassName(u5.u("YY29tLmhleXRhcC5vcGVuaWQ"), u5.u("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));     // Catch: Throwable -> L46
        r1.setAction(u5.u("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));     // Catch: Throwable -> L46
    L12:
        e r5 = new e();     // Catch: Throwable -> L46
        if (r12.bindService(r1, r5, 1) == false) goto L45;
        int r6 = 0;
    L16:
        if (r6 >= 100) goto L43;
        if (TextUtils.isEmpty(f7535i) == false) goto L43;
        r6 = r6 + 1;     // Catch: Throwable -> L46
        if (f7538l == null) goto L42;
        Parcel r7 = Parcel.obtain();     // Catch: Throwable -> L46
        Parcel r8 = Parcel.obtain();     // Catch: Throwable -> L46
        if (r13 == 2) goto L29;
        if (r13 == 4) goto L27;
        if (r13 == 5) goto L26;
        boolean r9 = false;
    L31:
        if (r9 == true) goto L51;
    L33:
        r8.recycle();     // Catch: Throwable -> L46
    L34:
        r7.recycle();     // Catch: Throwable -> L46
        goto L42
    L51:
        f7538l.transact(1, r7, r8, 0);     // Catch: Throwable -> L36
        r8.readException();     // Catch: Throwable -> L36
        f7535i = r8.readString();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        s.e(th, "oac", String.valueOf(r13));     // Catch: Throwable -> L39
        r8.recycle();     // Catch: Throwable -> L46
        goto L34
    L39:
        th = move-exception;
        r8.recycle();     // Catch: Throwable -> L46
        r7.recycle();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L26:
        r7.writeInterfaceToken(u5.u("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));     // Catch: Throwable -> L36
        r7.writeString(r12.getPackageName());     // Catch: Throwable -> L36
        r7.writeString(i0(r12));     // Catch: Throwable -> L36
        r7.writeString(u5.u("IT1VJRA"));     // Catch: Throwable -> L36
    L30:
        r9 = true;
        goto L31
    L27:
        String r10 = u5.u("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ");     // Catch: Throwable -> L36
    L28:
        r7.writeInterfaceToken(r10);     // Catch: Throwable -> L36
        goto L30
    L29:
        r10 = u5.u("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U");     // Catch: Throwable -> L36
    L42:
        Thread.sleep(15);     // Catch: Throwable -> L46
    L43:
        r12.unbindService(r5);     // Catch: Throwable -> L46
        f7538l = null;     // Catch: Throwable -> L46
    L45:
        return f7535i;
    L10:
        r1.setClassName(u5.u("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), u5.u("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));     // Catch: Throwable -> L46
        goto L12
    L11:
        r1.setAction(u5.u("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L46
        r1.setPackage(u5.u("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        s.e(th, "oa", String.valueOf(r13));
        f7536j = true;
        return f7535i;
    }

    public static void r(c r1) {
        if (f7533g != null) goto L6;
        f7533g = r1;
        return;
    }

    private static void s(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void t(String r0) {
        f7531e = r0;
    }

    static /* synthetic */ boolean u(Context r0, String r1) {
        return x(r0, r1);
    }

    public static String v() {
        if (TextUtils.isEmpty(f7530d) == false) goto L6;
        c r1 = f7533g;     // Catch: Throwable -> L12
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1.a();
    L6:
        return f7530d;
    L14:
        return "";
    }

    public static String w(Context r0) {
        return c(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static boolean x(Context r0, String r1) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.checkCallingOrSelfPermission(r1) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int y(Context r0) {
        return f(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static c z() {
        return f7533g;
    }
}
