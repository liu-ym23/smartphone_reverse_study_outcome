package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7362d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static i f7363e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f7364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7366c;

    final class a extends Thread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f7367f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7368g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i f7369h;

        a(i r1, String r2, int r3) {
            this.f7369h = r1;
            this.f7367f = r2;
            this.f7368g = r3;
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r0 = Build.VERSION.SDK_INT;
            String r1 = o.h(this.f7367f);
            if (TextUtils.isEmpty(r1) == false) goto L5;
            return;
        L5:
            if ((this.f7368g & 1) <= 0) goto L15;
            if (r0 >= 23) goto L9;
            ContentResolver r2 = i.b(this.f7369h).getContentResolver();     // Catch: Exception -> L25
            i r3 = this.f7369h;     // Catch: Exception -> L25
        L11:
            Settings.System.putString(r2, i.g(r3), r1);     // Catch: Exception -> L25
            goto L15
        L9:
            if (Settings.System.canWrite(i.b(this.f7369h)) == false) goto L15;
            r2 = i.b(this.f7369h).getContentResolver();     // Catch: Exception -> L25
            r3 = this.f7369h;     // Catch: Exception -> L25
        L15:
            if ((this.f7368g & 16) <= 0) goto L18;
            k.b(i.b(this.f7369h), i.g(this.f7369h), r1);
        L18:
            if ((this.f7368g & 256) <= 0) goto L29;
            SharedPreferences.Editor r4 = a(i.b(this.f7369h), i.f7362d, 0).edit();
            r4.putString(i.g(this.f7369h), r1);
            if (r0 < 9) goto L23;
            r4.apply();
            return;
        L23:
            r4.commit();
            return;
        }
    }

    private static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<i> f7370a;

        b(Looper r1, i r2) {
            super(r1);
            this.f7370a = new WeakReference(r2);
        }

        b(i r2) {
            this.f7370a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            i r1 = this.f7370a.get();
            if (r1 != null) goto L5;
            return;
        L5:
            if (r2 == null) goto L11;
            Object r0 = r2.obj;
            if (r0 == null) goto L12;
            i.d(r1, (String) r0, r2.what);
            return;
        L12:
            return;
        }
    }

    static {
        f7362d = u5.u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    private i(Context r2) {
        this.f7366c = r2.getApplicationContext();
        if (Looper.myLooper() != null) goto L6;
        new b(Looper.getMainLooper(), this);
        return;
    L6:
        new b(this);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ Context b(i r0) {
        return r0.f7366c;
    }

    public static i c(Context r2) {
        if (f7363e != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7363e != null) goto L9;
        f7363e = new i(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f7363e;
    }

    static /* synthetic */ void d(i r0, String r1, int r2) {
        r0.f(r1, r2);
    }

    private synchronized void f(String r4, int r5) {
        int r0 = Build.VERSION.SDK_INT;
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        new a(this, r4, r5).start();     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L9:
        String r6 = o.h(r4);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r6) == false) goto L12;
    L30:
        monitor-exit(this);
        return;
    L12:
        if ((r5 & 1) <= 0) goto L20;
        if (r0 < 23) goto L17;
        ContentResolver r1 = this.f7366c.getContentResolver();     // Catch: Exception -> L35 Throwable -> L32
        String r2 = this.f7365b;     // Catch: Exception -> L35 Throwable -> L32
    L16:
        Settings.System.putString(r1, r2, r6);     // Catch: Exception -> L35 Throwable -> L32
        goto L20
    L17:
        r1 = this.f7366c.getContentResolver();     // Catch: Exception -> L35 Throwable -> L32
        r2 = this.f7365b;     // Catch: Exception -> L35 Throwable -> L32
    L20:
        if ((r5 & 16) <= 0) goto L23;
        k.b(this.f7366c, this.f7365b, r6);     // Catch: Throwable -> L32
    L23:
        if ((r5 & 256) <= 0) goto L30;
        SharedPreferences.Editor r7 = a(this.f7366c, f7362d, 0).edit();     // Catch: Throwable -> L32
        r7.putString(this.f7365b, r6);     // Catch: Throwable -> L32
        if (r0 < 9) goto L29;
        r7.apply();     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L29:
        r7.commit();     // Catch: Throwable -> L32
        goto L30
    }

    static /* synthetic */ String g(i r0) {
        return r0.f7365b;
    }

    public final void e(String r1) {
        this.f7365b = r1;
    }

    public final void h(String r2) {
        List<String> r0 = this.f7364a;
        if (r0 == null) goto L5;
        r0.clear();
        this.f7364a.add(r2);
    L5:
        f(r2, 273);
    }
}
