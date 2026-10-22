package tmsdkobf;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class s9 {

    class a implements i5.a {
        a() {
        }

        @Override // tmsdkobf.i5.a
        public void a(String r1) {
            if (TextUtils.isEmpty(r1) == true) goto L6;
            s9.m2440$$Nest$sma(r1);
            return;
        }

        @Override // tmsdkobf.i5.a
        public void b(String r1) {
        }
    }

    class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f500a;

        b(Context r1) {
            this.f500a = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            s9.m2440$$Nest$sma(ba.a.a(r2).b());     // Catch: Throwable -> L5
        L7:
            this.f500a.unbindService(this);     // Catch: Throwable -> L6
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f501a;

        c(Context r1) {
            this.f501a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            s9.m2440$$Nest$sma(r9.b(this.f501a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f502a;

        d(Context r1) {
            this.f502a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            s9.m2440$$Nest$sma(s7.a(this.f502a));     // Catch: Throwable -> L4
            return;
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f503a;

        class a implements aa.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f504a;

            a(e r1) {
                this.f504a = r1;
            }

            @Override // tmsdkobf.aa.b
            public /* bridge */ /* synthetic */ void a(Object r1, aa r2) {
                a((String) r1, r2);
            }

            public void a(String r1, aa r2) {
                s9.m2440$$Nest$sma(r2.a());     // Catch: Throwable -> L4
                return;
            }
        }

        e(Context r1) {
            this.f503a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            new aa().a(this.f503a, new a(this));     // Catch: Throwable -> L4
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f505a;

        f(Context r1) {
            this.f505a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Constructor<?> r2 = Class.forName("android.app.ZteDeviceIdentifyManager").getDeclaredConstructor(new Class[]{Context.class});     // Catch: Exception -> L5
            r2.setAccessible(true);     // Catch: Exception -> L5
            Object r6 = r2.newInstance(new Object[]{this.f505a});     // Catch: Exception -> L5
        L7:
            if (TextUtils.isEmpty(null) == false) goto L17;
            String r7 = (String) r6.getClass().getMethod("getOAID", new Class[0]).invoke(r6, new Object[0]);     // Catch: Throwable -> L12
            if (TextUtils.isEmpty(r7) == true) goto L18;
            s9.m2440$$Nest$sma(r7);     // Catch: Throwable -> L12
            return;
        L18:
            return;
        L19:
            return;
        L17:
            return;
        L5:
            r6 = null;
            goto L7
        }
    }

    class g implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f506a;

        g(Context r1) {
            this.f506a = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            s9.m2440$$Nest$sma(h6.a.a(r2).getOAID());     // Catch: Throwable -> L5
        L7:
            this.f506a.unbindService(this);     // Catch: Throwable -> L6
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$C0ZJdooOIbXA72K7MTxIld-TiVw, reason: not valid java name */
    public static /* synthetic */ void m2439$r8$lambda$C0ZJdooOIbXA72K7MTxIldTiVw(Context r0) {
        l(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$sma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2440$$Nest$sma(String r0) {
        a(r0);
    }

    public static void a() {
        if (lb.b() == true) goto L5;
        return;
    L5:
        if (b3.c() == true) goto L76;
        Context r0 = TMSDKContext.getApplicaionContext();     // Catch: Throwable -> L73
        if (r0 != null) goto L11;
        return;
    L11:
        if (mb.l() == false) goto L15;
        i(r0);     // Catch: Throwable -> L73
        return;
    L15:
        if (mb.h() == false) goto L17;
    L71:
        f(r0);     // Catch: Throwable -> L73
        return;
    L17:
        if (mb.i() == true) goto L71;
        if (mb.k() == false) goto L24;
        h(r0);     // Catch: Throwable -> L73
        return;
    L24:
        if (mb.f() == false) goto L27;
        return;
    L27:
        if (mb.e() == false) goto L31;
        e(r0);     // Catch: Throwable -> L73
        return;
    L31:
        if (mb.m() == false) goto L35;
        j(r0);     // Catch: Throwable -> L73
        return;
    L35:
        if (mb.j() == false) goto L38;
        g(r0);     // Catch: Throwable -> L73
        return;
    L38:
        String r1 = la.c();     // Catch: Throwable -> L73
        if (r1.equalsIgnoreCase("xiaomi") == false) goto L42;
        i(r0);     // Catch: Throwable -> L73
        return;
    L42:
        if (r1.equalsIgnoreCase("oppo") == false) goto L45;
    L49:
        f(r0);     // Catch: Throwable -> L73
        return;
    L45:
        if (r1.equalsIgnoreCase("vivo") == false) goto L48;
        h(r0);     // Catch: Throwable -> L73
        return;
    L48:
        if (r1.equalsIgnoreCase("OnePlus") == true) goto L49;
        if (r1.equalsIgnoreCase("meizu") == false) goto L54;
        return;
    L54:
        if (r1.equalsIgnoreCase("samsung") == false) goto L57;
        g(r0);     // Catch: Throwable -> L73
        return;
    L57:
        if (r1.equalsIgnoreCase(new String(zc.f)) == false) goto L60;
        c(r0);     // Catch: Throwable -> L73
        return;
    L60:
        if (r1.equalsIgnoreCase(new String(zc.h)) == false) goto L63;
        b(r0);     // Catch: Throwable -> L73
        return;
    L63:
        if (r1.equalsIgnoreCase("zte") == false) goto L66;
        j(r0);     // Catch: Throwable -> L73
        return;
    L66:
        if (i5.d() == false) goto L69;
        a(r0);     // Catch: Throwable -> L73
        return;
    L69:
        if (k(r0) == false) goto L86;
        d(r0);     // Catch: Throwable -> L73
        return;
    L86:
        return;
    L76:
        return;
    }

    public static String b() {
        if (lb.b() == true) goto L6;
        return "";
    L6:
        return new h9("tms").a(new String(zc.j), "");
    }

    private static void c(Context r3) {
        Intent r0 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        r0.setPackage(new String(zc.i));
        r3.bindService(r0, new b(r3), 1);
    }

    private static void d(Context r4) {
        KeyguardManager r5 = (KeyguardManager) r4.getSystemService("keyguard");     // Catch: Throwable -> L6
        Object r6 = r5.getClass().getDeclaredMethod(new String(zc.n), new Class[0]).invoke(r5, new Object[0]);     // Catch: Throwable -> L6
        if (r6 == null) goto L9;
        a(r6.toString());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static void e(Context r3) {
        ve.f().a(new e(r3), new String(zc.j));
    }

    private static void f(Context r3) {
        ve.f().a(new c(r3), new String(zc.j));
    }

    private static void g(Context r3) {
        q8.a("O_D_M", "samsung oaid check");
        Intent r0 = new Intent();
        r0.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        r3.bindService(r0, new g(r3), 1);
    }

    private static void h(Context r3) {
        ve.f().a(new d(r3), new String(zc.j));
    }

    private static void i(Context r0) {
        a(t7.a(r0));
    }

    private static void j(Context r3) {
        ve.f().a(new f(r3), new String(zc.j));
    }

    private static boolean k(Context r4) {
        KeyguardManager r5 = (KeyguardManager) r4.getSystemService("keyguard");     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Objects.requireNonNull(r5.getClass().getDeclaredMethod(new String(zc.m), new Class[0]).invoke(r5, new Object[0]))).booleanValue();
    L8:
        return false;
    }

    private static /* synthetic */ void l(Context r5) {
        z5 r0 = new z5(r5);
        Intent r1 = new Intent();     // Catch: Throwable -> L5
        r1.setAction("com.hihonor.id.HnOaIdService");     // Catch: Throwable -> L5
        r1.setPackage("com.hihonor.id");     // Catch: Throwable -> L5
        r5.bindService(r1, r0, 1);     // Catch: Throwable -> L5
        r0.d.await(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L5
        String r2 = r0.f655a;     // Catch: Throwable -> L5
        r0.a();
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L11:
        c(r5);
        return;
    L9:
        if ("00000000-0000-0000-0000-000000000000".equals(r2) == true) goto L11;
        a(r2);
        return;
    L5:
        r0.a();
        r2 = null;
        goto L7
    }

    private static void a(Context r1) {
        i5.c(r1, new a());
    }

    private static void b(final Context r3) {
        String r0 = Settings.Global.getString(r3.getContentResolver(), new String(zc.j));     // Catch: Throwable -> L4
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L8;
    L10:
        ve.f().a(new s9$$ExternalSyntheticLambda0(r3), "task");
        return;
    L8:
        if ("00000000-0000-0000-0000-000000000000".equals(r0) == true) goto L10;
        a(r0);
        return;
    L4:
        r0 = null;
        goto L6
    }

    private static void a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.equals(b(), r3) == true) goto L13;
        new h9("tms").a(new String(zc.j), r3, true);
        ve.e().e();     // Catch: Throwable -> L10
        return;
    L14:
        return;
    }
}
