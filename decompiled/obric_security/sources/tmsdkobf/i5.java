package tmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.android.creator.IdsSupplier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public final class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i5 f264a = null;
    private static boolean b;
    private static boolean c;
    private static IdsSupplier d;
    private static g6 e;
    private static final c f = null;
    private static final b g = null;

    public interface a {
        void a(String r1);

        void b(String r1);
    }

    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            i5 r0 = i5.f264a;
            i5.a(g6.a.a(r2));
            if (i5.a() == null) goto L5;
            boolean r3 = true;
        L6:
            i5.a(r3);
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
            i5.a(null);
            i5.a(false);
        }
    }

    public static final class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            i5 r0 = i5.f264a;
            i5.a(IdsSupplier.Stub.asInterface(r2));
            if (i5.b() == null) goto L5;
            boolean r3 = true;
        L6:
            i5.b(r3);
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
            i5.a(null);
            i5.b(false);
        }
    }

    public static /* synthetic */ void $r8$lambda$1dILffnnYAYqvcFQXxxdO2NXZC8(a r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ex-JvPoMGCtnyFi4AYVv9ADkx3o, reason: not valid java name */
    public static /* synthetic */ void m2388$r8$lambda$ExJvPoMGCtnyFi4AYVv9ADkx3o(Context r0, a r1) {
        e(r0, r1);
    }

    static {
        f264a = new i5();
        f = new c();
        g = new b();
    }

    private i5() {
    }

    public static final /* synthetic */ g6 a() {
        return e;
    }

    public static final /* synthetic */ IdsSupplier b() {
        return d;
    }

    public static final void c(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        i5 r0 = f264a;
        if (r0.e() == false) goto L5;
        r0.a(r2, r3);
        return;
    L5:
        r0.b(r2, r3);
    }

    public static final boolean d() {
        i5 r0 = f264a;
        String r1 = r0.a("ro.build.freeme.label");
        String r2 = r0.a("ro.build.freemeos_label");
        if (r1 != null) goto L5;
    L7:
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (StringsKt.equals(r2, "FreemeOS", true) != true) goto L11;
        return true;
    L5:
        if (StringsKt.equals(r1, "FreemeOS", true) != true) goto L7;
        return true;
    }

    private final boolean e() {
        boolean r0 = d();
        boolean r1 = c();
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static final /* synthetic */ void a(boolean r0) {
        c = r0;
    }

    public static final /* synthetic */ void b(boolean r0) {
        b = r0;
    }

    public static final /* synthetic */ void a(g6 r0) {
        e = r0;
    }

    private final void b(Context r2, a r3) {
        if (b == false) goto L15;
        IdsSupplier r0 = d;
        if (r0 == null) goto L15;
        if (r0 != null) goto L20;
        String r1 = null;
    L11:
        r3.a(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r3.b("Failed to get Creator : " + e.getMessage());
        return;
    L20:
        r1 = r0.getOAID();     // Catch: Exception -> L8
    L15:
        if (b(r2) == true) goto L18;
        r3.b("Failed to bind CreatorService");
        return;
    L18:
        a(r3);
    }

    private final void e(Context r1) {
        if (b == false) goto L9;
        r1.unbindService(f);     // Catch: Exception -> L6
        b = false;     // Catch: Exception -> L6
        d = null;     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static final /* synthetic */ void a(IdsSupplier r0) {
        d = r0;
    }

    private final String a(String r6) {
        Class<?> r5 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L8
        Object r7 = r5.getMethod("get", new Class[]{String.class}).invoke(r5, new Object[]{r6});     // Catch: Exception -> L8
        if ((r7 instanceof String) == false) goto L6;
        return (String) r7;
    L6:
        return null;
    }

    public static final void c(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        i5 r0 = f264a;
        r0.e(r1);
        r0.d(r1);
    }

    private final void d(final Context r2, final a r3) {
        new Thread(new i5$$ExternalSyntheticLambda0(r2, r3)).start();
    }

    private final boolean c() {
        return StringsKt.equals(Build.MANUFACTURER, "Coolpad", true);
    }

    private static final void e(Context r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "$context");
        Intrinsics.checkNotNullParameter(r5, "$callback");
        long r0 = 0;
    L4:
        if (r0 >= 5000) goto L35;
        if (c == false) goto L39;
        g6 r2 = e;
        if (r2 == null) goto L39;
        String r1 = null;
        if (r2 != null) goto L37;
        String r6 = null;
    L15:
        g6 r3 = e;     // Catch: Exception -> L12
        if (r3 == null) goto L18;
        String r7 = r3.a("0");     // Catch: Exception -> L12
    L19:
        g6 r8 = e;     // Catch: Exception -> L12
        if (r8 == null) goto L22;
        r1 = r8.a(Utils.KEY_OA_ID);     // Catch: Exception -> L12
    L22:
        if (r6 != null) goto L26;
        if (r7 != null) goto L25;
        r6 = r1;
        goto L26
    L25:
        r6 = r7;
    L26:
        r5.a(r6);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        r5.b("Failed to get Coolpad : " + e.getMessage());
        return;
    L18:
        r7 = null;
        goto L19
    L37:
        r6 = r2.a(r4.getPackageName());     // Catch: Exception -> L12
    L39:
        Thread.sleep(100);     // Catch: InterruptedException -> L33
        r0 = r0 + 100;
    L33:
        r5.b("Interrupted while waiting for CoolpadService");
        return;
    L35:
        r5.b("Timeout waiting for CoolpadService connection");
    }

    private final void a(final a r2) {
        new Thread(new i5$$ExternalSyntheticLambda1(r2)).start();
    }

    private final boolean b(Context r5) {
        if (a(r5, "com.android.creator") == true) goto L8;
        return false;
    L8:
        Intent r4 = new Intent("android.service.action.msa");     // Catch: Exception -> L7
        r4.setPackage("com.android.creator");     // Catch: Exception -> L7
        r4.setComponent(new ComponentName("com.android.creator", "com.android.creator.CreatorService"));     // Catch: Exception -> L7
        return r5.bindService(r4, f, 1);
    L7:
        return false;
    }

    private static final void b(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$callback");
        long r0 = 0;
    L4:
        if (r0 >= 5000) goto L23;
        if (b == false) goto L27;
        IdsSupplier r2 = d;
        if (r2 == null) goto L27;
        if (r2 != null) goto L25;
        String r1 = null;
    L14:
        r4.a(r1);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        r4.b("Failed to get Creator : " + e.getMessage());
        return;
    L25:
        r1 = r2.getOAID();     // Catch: Exception -> L11
    L27:
        Thread.sleep(100);     // Catch: InterruptedException -> L21
        r0 = r0 + 100;
    L21:
        r4.b("Interrupted while waiting for CreatorService");
        return;
    L23:
        r4.b("Timeout waiting for CreatorService connection");
    }

    private final void a(Context r3, a r4) {
        if (c == false) goto L27;
        g6 r0 = e;
        if (r0 == null) goto L27;
        String r2 = null;
        if (r0 != null) goto L32;
        String r5 = null;
    L12:
        g6 r1 = e;     // Catch: Exception -> L9
        if (r1 == null) goto L15;
        String r6 = r1.a("0");     // Catch: Exception -> L9
    L16:
        g6 r7 = e;     // Catch: Exception -> L9
        if (r7 == null) goto L19;
        r2 = r7.a(Utils.KEY_OA_ID);     // Catch: Exception -> L9
    L19:
        if (r5 != null) goto L23;
        if (r6 != null) goto L22;
        r5 = r2;
        goto L23
    L22:
        r5 = r6;
    L23:
        r4.a(r5);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r4.b("Failed to get Coolpad : " + e.getMessage());
        return;
    L15:
        r6 = null;
        goto L16
    L32:
        r5 = r0.a(r3.getPackageName());     // Catch: Exception -> L9
    L27:
        if (a(r3) == true) goto L30;
        r4.b("Failed to bind CoolpadService");
        return;
    L30:
        d(r3, r4);
    }

    private final void d(Context r1) {
        if (c == false) goto L9;
        r1.unbindService(g);     // Catch: Exception -> L6
        c = false;     // Catch: Exception -> L6
        e = null;     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private final boolean a(Context r4) {
        if (a(r4, "com.coolpad.deviceidsupport") == true) goto L8;
        return false;
    L8:
        ComponentName r3 = new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService");     // Catch: Exception -> L7
        return r4.bindService(new Intent().setComponent(r3), g, 1);
    L7:
        return false;
    }

    private final boolean a(Context r1, String r2) {
        r1.getPackageManager().getPackageInfo(r2, 0);     // Catch: Exception -> L6
        return true;
    L9:
        return false;
    }
}
