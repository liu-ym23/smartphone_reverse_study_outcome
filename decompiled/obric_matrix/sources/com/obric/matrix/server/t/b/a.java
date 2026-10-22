package com.obric.matrix.server.t.b;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.matrix.r.c.d;
import com.obric.matrix.r.c.e;
import com.ss.android.agilelogger.ALog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0018\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/server/thirdapp/log/AlogHelper;", "", "()V", "TAG", "", "isSysALogInitSucc", "", "logd", "Ljava/lang/reflect/Method;", "loge", "logeWithException", "logi", "logv", "logw", "logwWithException", "alogE", "", LocationMonitorConst.TAG, NotificationCompat.CATEGORY_MESSAGE, "throwable", "", "alogProxy", "level", "", "alogW", "chcckSysAppInit", "context", "Landroid/content/Context;", "getLogPath", "init", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f10023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f10024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f10025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f10026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f10027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f10028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f10029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f10030i;

    static {
        f10022a = new a();
    }

    private a() {
    }

    private final boolean d(Context r10) {
        ClassLoader r11 = r10.createPackageContext(r10.getPackageName(), 3).getClassLoader();     // Catch: Throwable -> L5
        Class<?> r3 = Class.forName("com.ss.android.agilelogger.ALog", false, r11);     // Catch: Throwable -> L5
        Log.e("AlogHelper", "chcckSysAppInit: pkgCtxClassLoader = " + r11 + " alogClazz = " + r3);     // Catch: Throwable -> L5
        f10023b = r3.getMethod(BaseSwitches.V, new Class[]{String.class, String.class});     // Catch: Throwable -> L5
        f10024c = r3.getMethod("d", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
        f10025d = r3.getMethod("i", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
        f10026e = r3.getMethod("w", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
        f10027f = r3.getMethod("w", new Class[]{String.class, String.class, Throwable.class});     // Catch: Throwable -> L5
        f10028g = r3.getMethod("e", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
        f10029h = r3.getMethod("e", new Class[]{String.class, String.class, Throwable.class});     // Catch: Throwable -> L5
        Log.d("AlogHelper", "chcckSysAppInit: logv = " + f10023b + " loge = " + f10028g);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public final void a(String r4, String r5, Throwable r6) {
        o.f(r6, "throwable");
        if (f10030i == true) goto L5;
    L9:
        ALog.w(r4, r5, r6);
        return;
    L5:
        if (f10028g == null) goto L9;
        Method r3 = f10029h;
        if (r3 == null) goto L11;
        r3.invoke(null, new Object[]{r4, r5, r6});
        return;
    }

    public final void b(int r5, String r6, String r7) {
        if (r5 == 2) goto L47;
        if (r5 == 3) goto L41;
        if (r5 == 4) goto L34;
        if (r5 == 5) goto L27;
        if (r5 == 6) goto L20;
        if (f10030i == false) goto L18;
        Method r8 = f10024c;     // Catch: Exception -> L54
        if (r8 == null) goto L18;
        if (r8 == null) goto L55;
        r8.invoke(null, new Object[]{r6, r7});     // Catch: Exception -> L54
    L55:
        return;
    L18:
        ALog.d(r6, r7);     // Catch: Exception -> L54
        goto L55
    L20:
        if (f10030i == false) goto L25;
        Method r9 = f10028g;     // Catch: Exception -> L54
        if (r9 == null) goto L25;
        if (r9 == null) goto L55;
        r9.invoke(null, new Object[]{r6, r7});     // Catch: Exception -> L54
    L25:
        ALog.e(r6, r7);     // Catch: Exception -> L54
        goto L55
    L27:
        if (f10030i == false) goto L32;
        Method r10 = f10026e;     // Catch: Exception -> L54
        if (r10 == null) goto L32;
        if (r10 == null) goto L55;
        r10.invoke(null, new Object[]{r6, r7});     // Catch: Exception -> L54
    L32:
        ALog.w(r6, r7);     // Catch: Exception -> L54
        goto L55
    L34:
        if (f10030i == false) goto L39;
        Method r11 = f10025d;     // Catch: Exception -> L54
        if (r11 == null) goto L39;
        if (r11 == null) goto L55;
        r11.invoke(null, new Object[]{r6, r7});     // Catch: Exception -> L54
    L39:
        ALog.i(r6, r7);     // Catch: Exception -> L54
        goto L55
    L41:
        if (f10030i == false) goto L18;
        Method r12 = f10024c;     // Catch: Exception -> L54
        if (r12 == null) goto L18;
        if (r12 == null) goto L55;
        r12.invoke(null, new Object[]{r6, r7});     // Catch: Exception -> L54
        goto L55
    L47:
        if (f10030i == false) goto L52;
        Method r13 = f10023b;     // Catch: Exception -> L54
        if (r13 == null) goto L52;
        if (r13 == null) goto L55;
        r13.invoke(null, new Object[]{r6, r7});     // Catch: Exception -> L54
    L52:
        ALog.v(r6, r7);     // Catch: Exception -> L54
    }

    public final void c(String r4, String r5, Throwable r6) {
        o.f(r6, "throwable");
        if (f10030i == true) goto L5;
    L9:
        ALog.w(r4, r5, r6);
        return;
    L5:
        if (f10026e == null) goto L9;
        Method r3 = f10027f;
        if (r3 == null) goto L11;
        r3.invoke(null, new Object[]{r4, r5, r6});
        return;
    }

    public final void e(Context r3) {
        o.f(r3, "context");
        f10030i = d(r3);
        Log.d("AlogHelper", "init: isSysALogInitSucc = " + f10030i);
        if (f10030i == false) goto L5;
        return;
    L5:
        com.ss.android.agilelogger.a.b r2 = new com.ss.android.agilelogger.a.b(r3.getApplicationContext());
        r2.f(20971520);
        r2.d(r3.getFilesDir().getAbsolutePath() + "/ALOG");
        r2.g(2097152);
        o.e(r2, "Builder(context.applicat…     .setPerSize(2097152)");
        ALog.setDebug(false);
        ALog.init(r2.a());
        e.e(r2.a(), false);
        d.b(r3.getApplicationContext(), false);
    }
}
