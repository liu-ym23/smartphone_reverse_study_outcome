package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class x4 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static x4 f7966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f7967i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, Long> f7968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f7969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f7971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f7973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f7974g;

    static {
    }

    private x4(Context r3) {
        this.f7968a = new LinkedHashMap();
        this.f7970c = null;
        this.f7973f = "";
        this.f7974g = null;
        Context r4 = r3.getApplicationContext();
        this.f7971d = r4;
        String r5 = r4.getFilesDir().getPath();
        if (this.f7970c != null) goto L11;
        this.f7970c = a5.d0(this.f7971d);
    L11:
        this.f7969b = new File(r5, "reportRecorder");     // Catch: Throwable -> L7
    L9:
        f();
        return;
    L7:
        th = move-exception;
        l3.a(th);
        goto L9
    }

    public static synchronized x4 a(Context r2) {
        monitor-enter(x4.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f7966h != null) goto L7;
        f7966h = new x4(r2);     // Catch: Throwable -> L10
    L7:
        x4 r3 = f7966h;     // Catch: Throwable -> L10
        monitor-exit(x4.class);
        return r3;
    }

    private boolean e(Context r5) {
        if (this.f7974g != null) goto L6;
        this.f7974g = z4.f(r5, "pref", "lastavedate", BDLocationException.ERROR_TIMEOUT);
    L6:
        if (this.f7974g.equals(this.f7973f) == false) goto L9;
        return false;
    L9:
        SharedPreferences.Editor r6 = z4.d(r5, "pref");
        z4.k(r6, "lastavedate", this.f7973f);
        z4.g(r6);
        this.f7974g = this.f7973f;
        return true;
    }

    private synchronized void f() {
        monitor-enter(this);
        LinkedHashMap<String, Long> r0 = this.f7968a;     // Catch: Throwable -> L30
        if (r0 != null) goto L6;
    L33:
        this.f7973f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L26
        Iterator<String> r1 = a5.k(this.f7969b).iterator();     // Catch: Throwable -> L26
    L10:
        if (r1.hasNext() == false) goto L24;
        String[] r2 = new String(h4.h(m5.g(r1.next()), this.f7970c), "UTF-8").split(",");     // Catch: Throwable -> L19 UnsupportedEncodingException -> L21
        if (r2 == null) goto L10;
        if (r2.length <= 1) goto L10;
        this.f7968a.put(r2[0], Long.valueOf(Long.parseLong(r2[1])));     // Catch: Throwable -> L19 UnsupportedEncodingException -> L21
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        goto L10
    L24:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
        return;
    L6:
        if (r0.size() <= 0) goto L33;
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    private void g() {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, Long>> r1 = this.f7968a.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Long> r2 = r1.next();     // Catch: Throwable -> L14
        r0.append(m5.f(h4.e((r2.getKey() + "," + r2.getValue()).getBytes("UTF-8"), this.f7970c)) + "\n");     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L4
    L10:
        String r3 = r0.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r3) == true) goto L25;
        a5.l(this.f7969b, r3);     // Catch: Throwable -> L14
        return;
    L25:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    }

    public final synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7972e == false) goto L6;
        g();     // Catch: Throwable -> L8
        this.f7972e = false;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void c(AMapLocation r7) {
        monitor-enter(this);
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        throw th;
    L4:
        if (this.f7968a.containsKey(this.f7973f) == true) goto L8;
        if (this.f7968a.size() < 8) goto L8;
    L11:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L48
        Iterator<Map.Entry<String, Long>> r1 = this.f7968a.entrySet().iterator();     // Catch: Throwable -> L48
    L13:
        if (r1.hasNext() == false) goto L21;
        r0.add(r1.next().getKey());     // Catch: Throwable -> L19
    L17:
        if (r0.size() != (this.f7968a.size() - 7)) goto L13;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L48
    L21:
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L48
    L23:
        if (r2.hasNext() == false) goto L26;
        this.f7968a.remove((String) r2.next());     // Catch: Throwable -> L48
    L26:
        if (r7.U() == 0) goto L30;
        monitor-exit(this);
        return;
    L30:
        if (r7.Y() != 6) goto L32;
    L46:
        monitor-exit(this);
        return;
    L32:
        if (r7.Y() == 5) goto L46;
        if (this.f7968a.containsKey(this.f7973f) == false) goto L37;
        long r3 = this.f7968a.get(this.f7973f).longValue() + 1;     // Catch: Throwable -> L48
        f7967i = r3;     // Catch: Throwable -> L48
        this.f7968a.put(this.f7973f, Long.valueOf(r3));     // Catch: Throwable -> L48
    L38:
        long r4 = f7967i;     // Catch: Throwable -> L48
        if (r4 != 0) goto L41;
    L43:
        this.f7972e = true;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        if ((r4 % 100) != 0) goto L43;
        b();     // Catch: Throwable -> L48
        goto L43
    L37:
        this.f7968a.put(this.f7973f, 1L);     // Catch: Throwable -> L48
        f7967i = 1;     // Catch: Throwable -> L48
    L8:
        if (this.f7968a.containsKey(this.f7973f) == false) goto L26;
        if (this.f7968a.size() < 9) goto L26;
        goto L11
    }

    public final synchronized void d() {
        monitor-enter(this);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L4:
        if (e(this.f7971d) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Map.Entry<String, Long>> r0 = this.f7968a.entrySet().iterator();     // Catch: Throwable -> L21
    L8:
        if (r0.hasNext() == false) goto L19;
        Map.Entry<String, Long> r1 = r0.next();     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L8
    L12:
        if (this.f7973f.equals(r1.getKey()) == true) goto L8;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L16
        r2.put("param_long_first", r1.getKey());     // Catch: Throwable -> L16
        r2.put("param_long_second", r1.getValue());     // Catch: Throwable -> L16
        y4.n(this.f7971d, "O023", r2);     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);
    }
}
