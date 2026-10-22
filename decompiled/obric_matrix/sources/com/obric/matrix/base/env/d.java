package com.obric.matrix.base.env;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050!J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u0016\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0005J\u0010\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u0005J&\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050!J\u0018\u0010-\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\n¨\u0006/"}, d2 = {"Lcom/obric/matrix/base/env/BoePpeEnvManager;", "", "()V", "BOE_SWITCH_LISTENER_LIST", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/matrix/base/env/IEnvSwitchListener;", "TAG", "boeEnv", "getBoeEnv", "()Ljava/lang/String;", "setBoeEnv", "(Ljava/lang/String;)V", "envHeaders", "", "isBoeEnable", "", "()Z", "setBoeEnable", "(Z)V", "enable", "isPpeEnable", "setPpeEnable", "path", "getPath", "setPath", "ppeEnv", "getPpeEnv", "addBoeSwitchListener", "", LocationMonitorConst.TAG, "envSwitchListener", "getEnvHeaders", "", "getEnvHeadersForWs", "readFile", "file", "Ljava/io/File;", "removeBoeSwitchListener", "setBoeSwitch", "boeEnable", "evn", "setPpeEvn", "env", "updateEnv", "writeFile", "content", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8839b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8840c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f8841d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f8842e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<String, g> f8843f = null;

    static {
        d r0 = new d();
        f8838a = r0;
        f8842e = new LinkedHashMap();
        f8843f = new ConcurrentHashMap();
        f8840c = com.bytedance.mpaas.app.a.f5245g.getFilesDir().getAbsolutePath() + "/ttnet_boe.flag";
        File r1 = new File(f8840c);
        f8839b = r1.exists();
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "init, isBoeEnable: " + f8839b);
        if (f8839b == false) goto L6;
        f8841d = r0.g(r1);
        return;
    }

    private d() {
    }

    private final String g(File r4) {
        FileReader r3 = null;
        FileReader r0 = new FileReader(r4);     // Catch: Throwable -> L15 Exception -> L27
        goto L20
    L35:
        char[] r5 = new char[50];     // Catch: Throwable -> L12 Exception -> L14
        b0 r6 = new b0();     // Catch: Throwable -> L12 Exception -> L14
        int r1 = r0.read(r5);     // Catch: Throwable -> L12 Exception -> L14
        r6.f18428f = r1;     // Catch: Throwable -> L12 Exception -> L14
        if (r1 == (-1)) goto L10;
        String r2 = new String(r5, 0, r6.f18428f);     // Catch: Throwable -> L12 Exception -> L14
        r0.close();     // Catch: IOException -> L24
    L9:
        return r2;
    L10:
        r0.close();     // Catch: IOException -> L25
    L28:
        return "";
    L14:
        r3 = r0;
    L12:
        Throwable th = th;
    L17:
        if (r0 != null) goto L33;
    L19:
        throw th;
    L33:
        r0.close();     // Catch: IOException -> L26
    L15:
        th = move-exception;
        r0 = null;
        th = th;
    L39:
        return "";
    L20:
        if (r3 == null) goto L38;
        r3.close();     // Catch: IOException -> L25
        goto L28
    L38:
        return "";
    }

    private final void l(File r3, String r4) {
        FileWriter r2 = null;
        FileWriter r0 = new FileWriter(r3, false);     // Catch: Throwable -> L10 IOException -> L20
        r0.write(r4);     // Catch: Throwable -> L7 IOException -> L9
        r0.flush();     // Catch: Throwable -> L7 IOException -> L9
        r0.close();     // Catch: IOException -> L18
    L21:
        return;
    L9:
        r2 = r0;
    L7:
        Throwable th = th;
    L12:
        if (r0 != null) goto L24;
    L14:
        throw th;
    L24:
        r0.close();     // Catch: IOException -> L19
        goto L14
    L10:
        th = move-exception;
        r0 = null;
        th = th;
    L30:
        return;
    L15:
        if (r2 == null) goto L29;
        r2.close();     // Catch: IOException -> L18
        goto L21
    }

    public final void a(String r1, g r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, "envSwitchListener");
        f8843f.put(r1, r2);
    }

    public final String b() {
        return f8841d;
    }

    public final Map<String, String> c() {
        Map<String, String> r1 = f8842e;
        monitor-enter(r1);
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L7
        r0.putAll(r1);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final String d() {
        String r2 = com.obric.matrix.q.e.b.b().d("ppe_env", "");
        o.e(r2, "getInstance().getPref(SP_PPE_ENV, \"\")");
        return r2;
    }

    public final boolean e() {
        return f8839b;
    }

    public final boolean f() {
        return com.obric.matrix.q.e.b.b().e("enable_ppe", Boolean.FALSE);
    }

    public final void h(boolean r5, String r6) {
        o.f(r6, "evn");
        f8839b = r5;
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "setBoeSwitch, isBoeEnable: " + f8839b + ", evn: " + r6);
        f r0 = f.f8844a;
        Application r2 = com.bytedance.mpaas.app.a.f5245g;
        o.e(r2, "sApplication");
        r0.b(r2);
        if (TextUtils.isEmpty(f8840c) == false) goto L23;
    L17:
        Iterator<Map.Entry<String, g>> r4 = f8843f.entrySet().iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        Map.Entry<String, g> r7 = r4.next();
        String r1 = r7.getKey();
        r7.getValue().b(r5);
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "boe switch is changed and boeEnable is " + r5 + ", which has notified " + r1);
        goto L19
    L21:
        return;
    L23:
        File r3 = new File(f8840c);     // Catch: IOException -> L22
        if (r5 == false) goto L11;
        if (r3.exists() == true) goto L9;
        f8839b = r3.createNewFile();     // Catch: IOException -> L22
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "setBoeSwitch, after createNewFile, isBoeEnable: " + f8839b);     // Catch: IOException -> L22
    L9:
        l(r3, r6);     // Catch: IOException -> L22
        goto L17
    L11:
        if (r3.exists() == false) goto L17;
        if (r3.delete() == true) goto L15;
        boolean r8 = true;
    L16:
        f8839b = r8;     // Catch: IOException -> L22
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "setBoeSwitch, after delete, isBoeEnable: " + f8839b);     // Catch: IOException -> L22
        goto L17
    L15:
        r8 = false;
        goto L16
    }

    public final void i(boolean r4) {
        Iterator<Map.Entry<String, g>> r3 = f8843f.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<String, g> r0 = r3.next();
        String r1 = r0.getKey();
        r0.getValue().a(r4);
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "boe switch is changed and ppeEnable is " + r4 + ", which has notified " + r1);
        goto L4
    L6:
        com.obric.matrix.q.e.b.b().g("enable_ppe", r4);
    }

    public final void j(String r2) {
        com.obric.matrix.q.e.b.b().f("ppe_env", r2);
    }

    public final void k(String r3, Map<String, String> r4) {
        o.f(r3, "env");
        o.f(r4, "envHeaders");
        monitor-enter(r4);
        Map<String, String> r2 = f8842e;     // Catch: Throwable -> L7
        r2.clear();     // Catch: Throwable -> L7
        r2.putAll(r4);     // Catch: Throwable -> L7
        com.obric.matrix.r.c.c.b("BoePpeEnvManager", "updateEnv: env: " + r3 + ", envHeaders: " + r4);     // Catch: Throwable -> L7
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r4);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
