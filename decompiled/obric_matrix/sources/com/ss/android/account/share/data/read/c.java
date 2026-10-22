package com.ss.android.account.share.data.read;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f11791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.ss.android.account.share.data.read.a f11792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f11793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f11794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Runnable f11795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f11796f = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f11797f = null;

        static {
            f11797f = new a();
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.i.n.a.c r8 = com.ss.android.i.n.a.c.d();
            r8.b("share_sdk_read_time_out");
            r8.c();
            c.a(c.f11796f, new b("", false, "time out", 0, 8, null));
        }
    }

    static {
        f11796f = new c();
        f11793c = new Handler(Looper.getMainLooper());
        f11795e = a.f11797f;
    }

    private c() {
    }

    public static final /* synthetic */ void a(c r0, b r1) {
        r0.b(r1);
    }

    private final void b(b r3) {
        if (f11794d == false) goto L5;
        return;
    L5:
        f11794d = true;
        f11793c.removeCallbacks(f11795e);
        com.ss.android.account.share.data.read.a r2 = f11792b;
        f11792b = null;
        if (r2 == null) goto L8;
        r2.b(r3);
    L8:
        com.ss.android.i.n.a.c r4 = com.ss.android.i.n.a.c.d();
        r4.b("share_sdk_read_result");
        r4.a("is_succ", Boolean.valueOf(r3.e()));
        r4.a(LocationMonitorConst.ERR_MSG, r3.a());
        r4.a("query_type", Integer.valueOf(r3.c()));
        r4.a("pkg_name", r3.b());
        r4.c();
    }

    private final boolean d(b r3) {
        if (f11794d == true) goto L16;
        com.ss.android.account.share.data.read.a r0 = f11792b;
        if (r0 == null) goto L16;
        if (r0 != null) goto L9;
        o.p();
        throw null;
    L9:
        if (r0.a(r3) == false) goto L12;
        b(r3);
        return true;
    L12:
        return false;
    L16:
        return true;
    }

    @SuppressLint({"WrongConstant", "QueryPermissionsNeeded"})
    public final boolean c(String r3) {
        o.g(r3, "pkgName");
        Intent r2 = new Intent();
        r2.setComponent(new ComponentName(r3, "com.ss.android.account.share.data.write.activity.ShareDataActivity"));
        Context r4 = f11791a;
        if (r4 != null) goto L5;
        o.p();
        throw null;
    L5:
        if (r2.resolveActivityInfo(r4.getPackageManager(), 65536) == null) goto L7;
        return true;
    L7:
        return false;
    }

    public final void e(b r2) {
        o.g(r2, "result");
        if (r2.e() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2.d()) == true) goto L9;
        d(r2);
        return;
    }
}
