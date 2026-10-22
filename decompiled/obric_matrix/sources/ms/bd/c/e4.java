package ms.bd.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f22341a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f22342b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f22343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashMap<Integer, com.bytedance.mobsec.metasec.ml.d.a> f22344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static boolean f22345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HandlerThread f22346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static AtomicBoolean f22347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Handler f22348h;

    static class a implements Runnable {

        /* JADX INFO: renamed from: ms.bd.c.e4$a$a, reason: collision with other inner class name */
        class C0599a implements Application.ActivityLifecycleCallbacks {

            /* JADX INFO: renamed from: ms.bd.c.e4$a$a$a, reason: collision with other inner class name */
            class RunnableC0600a implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Activity f22349f;

                RunnableC0600a(C0599a r1, Activity r2) {
                    this.f22349f = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity r0 = this.f22349f;
                    boolean r1 = e4.f22345e;
                    if (Build.VERSION.SDK_INT >= 22) goto L15;
                L12:
                    e4.a(1);
                    return;
                L15:
                    Field r2 = Class.forName((String) m.a(16777217, 0, 0, "528a1c", new byte[]{37, 62, 79, 7, 1, 125, 50, 93, 104, 33, 52, 126, 106, 22, 26, 125, 32, 26, 125, 40})).getDeclaredField((String) m.a(16777217, 0, 0, "d7588c", new byte[]{120, 7, 67, 74, 2, 102, 117, 19, 118}));     // Catch: Throwable -> L14
                    r2.setAccessible(true);     // Catch: Throwable -> L14
                    String r3 = r2.get(r0).toString();     // Catch: Throwable -> L14
                    String r4 = r0.getComponentName().getClassName();     // Catch: Throwable -> L14
                    if (r4.contains(r3) == true) goto L12;
                    StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L14
                    r5.append(r4);     // Catch: Throwable -> L14
                    r5.append((String) m.a(16777217, 0, 0, "350202", new byte[]{121}));     // Catch: Throwable -> L14
                    r5.append(r3);     // Catch: Throwable -> L14
                    ms.bd.c.b.b(16777222, r5.toString());     // Catch: Throwable -> L14
                    goto L12
                }
            }

            /* JADX INFO: renamed from: ms.bd.c.e4$a$a$b */
            class b implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ C0599a f22350f;

                /* JADX INFO: renamed from: ms.bd.c.e4$a$a$b$a, reason: collision with other inner class name */
                class RunnableC0601a implements Runnable {

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ b f22351f;

                    RunnableC0601a(b r1) {
                        this.f22351f = r1;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C0599a.b(this.f22351f.f22350f);
                    }
                }

                b(C0599a r1) {
                    this.f22350f = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C0599a.b(this.f22350f) == true) goto L6;
                    e4.g().postDelayed(new RunnableC0601a(this), 1000);
                    return;
                }
            }

            C0599a(a r1) {
            }

            private boolean a() {
                if (e4.i() != 0) goto L6;
                e4.a(0);
                e4.f22345e = false;
                return true;
            L6:
                return false;
            }

            static /* synthetic */ boolean b(C0599a r0) {
                return r0.a();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity r1, Bundle r2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity r1) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity r1) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity r3) {
                if (e4.f22345e == true) goto L6;
                e4.f22345e = true;
                e4.g().post(new RunnableC0600a(this, r3));
                return;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity r1) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity r2) {
                if (e4.f22345e == false) goto L6;
                e4.g().post(new b(this));
                return;
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e4.d().getAndSet(false) == false) goto L13;
            e4.f().start();     // Catch: Exception -> L8
            e4.b(new Handler(e4.f().getLooper()));     // Catch: Exception -> L8
        L9:
            e4.k().registerActivityLifecycleCallbacks(new C0599a(this));     // Catch: Throwable -> L7
            return;
        L14:
            return;
        }
    }

    static {
        f22344d = new HashMap(3);
        f22345e = false;
        f22346f = new HandlerThread((String) m.a(16777217, 0, 0, "9650b3", new byte[]{37, 39, 85, 64, 86}));
        f22347g = new AtomicBoolean(true);
        f22348h = null;
    }

    static int a(int r12) {
        HashMap<Integer, com.bytedance.mobsec.metasec.ml.d.a> r0 = f22344d;
        if (r0 != null) goto L5;
    L15:
        String r2 = null;
    L16:
        String r7 = r2;
        if (TextUtils.isEmpty(r7) == true) goto L19;
        long r5 = System.currentTimeMillis();
        int r1 = b.f22318b;
        m.a(16777223, r12, r5, r7, null);
    L19:
        return 0;
    L5:
        if (r0.size() <= 0) goto L15;
        Iterator<Map.Entry<Integer, com.bytedance.mobsec.metasec.ml.d.a>> r3 = f22344d.entrySet().iterator();
        r2 = "";
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L16;
        int r6 = r3.next().getValue().a();
        if (r6 == 0) goto L8;
        if (r4 <= 0) goto L14;
        r2 = r2 + ((String) m.a(16777217, 0, 0, "166b61", new byte[]{31}));
    L14:
        r2 = r2 + r6;
        r4 = r4 + 1;
        goto L8
    }

    static /* synthetic */ Handler b(Handler r0) {
        f22348h = r0;
        return r0;
    }

    public static String c(Context r9) {
        if (TextUtils.isEmpty(f22342b) == false) goto L8;
        f22342b = r9.getPackageManager().getApplicationInfo(r9.getPackageName(), 128).metaData.getString((String) m.a(16777217, 0, 0, "62132e", new byte[]{20, 3, 125, 113, 40, 64, 6, 58, 79, 77, 24, 30, 99, 106, 40}));     // Catch: Throwable -> L9
    L8:
        return f22342b;
    }

    static /* synthetic */ AtomicBoolean d() {
        return f22347g;
    }

    public static int e(Context r2) {
        if (f22341a > 0) goto L6;
        f22341a = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0).versionCode;     // Catch: Throwable -> L7
    L6:
        return f22341a;
    }

    static /* synthetic */ HandlerThread f() {
        return f22346f;
    }

    static /* synthetic */ Handler g() {
        return f22348h;
    }

    public static String h(Context r2) {
        if (TextUtils.isEmpty(f22342b) == false) goto L6;
        f22342b = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0).versionName;     // Catch: Throwable -> L7
    L6:
        return f22342b;
    }

    public static int i() {
        if (l() == null) goto L6;
        return 1;
    L6:
        return 0;
    L8:
        return -1;
    }

    public static String j(Context r12) {
    L12:
        f22343c = "";
    L14:
        return f22343c;
    L4:
        if (f22343c != null) goto L9;
        f22343c = String.valueOf(r12.getPackageManager().getApplicationInfo(r12.getPackageName(), 128).metaData.get((String) m.a(16777217, 0, 0, "ce7212", new byte[]{71, 87, 96, 103, 58, 0, 95, 114, 67, 80, 65, 78, 107, 104, 49, 6, 79, 96, 67})));     // Catch: Throwable -> L12
    L9:
        if (f22343c != null) goto L14;
        f22343c = "";     // Catch: Throwable -> L12
        goto L14
    }

    @SuppressLint({"PrivateApi"})
    public static Application k() {
        return (Application) Class.forName((String) m.a(16777217, 0, 0, "8b9818", new byte[]{40, 110, 78, 94, 1, 38, 63, 13, 105, 120, 57, 46, 107, 79, 26, 38, 45, 74, 124, 113, 29, 104, 88, 73, 15, 43})).getMethod((String) m.a(16777217, 0, 0, "44ea5c", new byte[]{38, 35, 4, 7, 15, 122, 35, 52, 36, 33, 41, 63, 21, 20, 30, 125, 56, 27}), new Class[0]).invoke(null, null);
    L11:
        return null;
    }

    @SuppressLint({"PrivateApi"})
    public static Activity l() {
        Class<?> r0 = Class.forName((String) m.a(16777217, 0, 0, "adbced", new byte[]{113, 104, 21, 5, 85, 122, 102, 11, 50, 35, 96, 40, 48, 20, 78, 122, 116, 76, 39, 42, 68, 110, 3, 18, 91, 119}));     // Catch: Exception -> L25
        Object r1 = r0.getMethod((String) m.a(16777217, 0, 0, "1b4f32", new byte[]{35, 117, 85, 0, 9, 43, 38, 98, 102, 34, 41, 118, 78, 6, 21, 17, 58, 81, 96, 55, 36}), new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L25
        Field r2 = r0.getDeclaredField((String) m.a(16777217, 0, 0, "bcd1ca", new byte[]{126, 64, 20, 81, 85, 96, 104, 86, 60, 100, 96}));     // Catch: Exception -> L25
        r2.setAccessible(true);     // Catch: Exception -> L25
        if (Build.VERSION.SDK_INT >= 19) goto L10;
        Map r3 = (HashMap) r2.get(r1);     // Catch: Exception -> L25
    L12:
        if (r3.size() >= 1) goto L15;
        return null;
    L15:
        Iterator r4 = r3.values().iterator();     // Catch: Exception -> L25
    L17:
        if (r4.hasNext() == false) goto L33;
        Object r5 = r4.next();     // Catch: Exception -> L25
        Class<?> r6 = r5.getClass();     // Catch: Exception -> L25
        Field r7 = r6.getDeclaredField((String) m.a(16777217, 0, 0, "5992f1", new byte[]{55, 47, 69, 86, 73, 35, 50}));     // Catch: Exception -> L25
        r7.setAccessible(true);     // Catch: Exception -> L25
        if (r7.getBoolean(r5) == true) goto L17;
        Field r8 = r6.getDeclaredField((String) m.a(16777217, 0, 0, "df0e8c", new byte[]{116, 103, 87, 24, 17, 125, 115, 94}));     // Catch: Exception -> L25
        r8.setAccessible(true);     // Catch: Exception -> L25
        return (Activity) r8.get(r5);
    L33:
        return null;
    L10:
        r3 = (ArrayMap) r2.get(r1);     // Catch: Exception -> L25
    L25:
        String r9 = (String) m.a(16777217, 0, 0, "bfc63e", new byte[]{114, 109, 47, 69});
        return null;
    }

    public static void m() {
        new Thread(new a()).start();
    }
}
