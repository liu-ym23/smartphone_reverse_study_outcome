package com.obric.matrix.base.env;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.webkit.CookieManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/base/env/EnvironmentHelper;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "cleanUp", "", "context", "Landroid/content/Context;", "deleteSharedPrefs", "getSDCard", "Ljava/io/File;", "getSDCardPath", "", "restartApp", "activity", "Landroid/app/Activity;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f8845b;

    static {
        f8844a = new f();
        f8845b = new Handler(Looper.getMainLooper());
    }

    private f() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static final void c() {
        CookieManager.getInstance().removeAllCookies(c.f8837a);     // Catch: Exception -> L4
        return;
    }

    private static final void d(Boolean r0) {
    }

    private final void e(Context r7) {
        File r6 = new File("/data/data/" + r7.getPackageName() + "/shared_prefs");
        if (r6.isDirectory() == false) goto L12;
        File[] r8 = r6.listFiles();
        if (r8 == null) goto L16;
        int r0 = r8.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L17;
        File r3 = r8[r2];
        if (r3.isFile() == false) goto L11;
        String r4 = r3.getName();
        o.e(r4, "f.name");
        String r5 = r4.substring(0, r3.getName().length() - 4);
        o.e(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        r3.delete();
        a(r7, r5, 0).edit().clear().commit();
    L11:
        r2 = r2 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    }

    public static /* synthetic */ void f() {
        c();
    }

    public static /* synthetic */ void g() {
        j();
    }

    public static /* synthetic */ void h(Boolean r0) {
        d(r0);
    }

    private static final void j() {
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.matrix.r.c.c.h("restartApp, failed", th);
    }

    public final void b(Context r2) {
        o.f(r2, "context");
        com.obric.matrix.r.e.d.a(r2.getCacheDir());
        e(r2);
        com.bytedance.common.utility.n.a.b(r2.getCacheDir().getAbsolutePath());
        com.bytedance.common.utility.n.a.b("/data/data/" + r2.getPackageName() + "/databases/");
        File r1 = r2.getExternalCacheDir();
        if (r1 == null) goto L5;
        String r3 = r1.getAbsolutePath();
    L6:
        com.bytedance.common.utility.n.a.b(r3);
        if (Build.VERSION.SDK_INT < 21) goto L10;
        f8845b.post(a.f8835f);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void i(Activity r3) {
        if (r3 != null) goto L7;
        return;
    L7:
        r3.getWindow().getDecorView().postDelayed(b.f8836f, 2000);     // Catch: Throwable -> L6
        return;
    }
}
