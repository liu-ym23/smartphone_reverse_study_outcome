package com.obric.matrix.r;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.obric.matrix.r.c.c;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/common_utils/AppGlobals;", "", "()V", "TAG", "", "app", "Landroid/app/Application;", "ttnetInitLatch", "Ljava/util/concurrent/CountDownLatch;", "getTtnetInitLatch", "()Ljava/util/concurrent/CountDownLatch;", "getApplication", "getApplicationContext", "Landroid/content/Context;", "getApplicationReflect", "getResource", "Landroid/content/res/Resources;", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"PrivateApi"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Application f9908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CountDownLatch f9909c = null;

    static {
        f9907a = new a();
        f9909c = new CountDownLatch(1);
    }

    private a() {
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context a(Application r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    public static final synchronized Application b() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f9908b != null) goto L8;
        f9908b = f9907a.d();     // Catch: Throwable -> L13
    L8:
        if (f9908b != null) goto L10;
        f9908b = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L13
        c.s("AppGlobals", "getApplication Reflect failed");     // Catch: Throwable -> L13
    L10:
        Application r1 = f9908b;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r1;
    }

    public static final Context c() {
        Application r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r0);
    }

    private final Application d() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
    }

    public final CountDownLatch e() {
        return f9909c;
    }
}
