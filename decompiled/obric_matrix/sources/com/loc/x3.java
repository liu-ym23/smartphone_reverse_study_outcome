package com.loc;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f7954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, c> f7956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f7957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f7960h;

    final class a implements Comparator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x3 f7961f;

        a(x3 r1) {
            this.f7961f = r1;
        }

        private int a(String r3, String r4) {
            return x3.a(((c) x3.b(this.f7961f).get(r4)).f7965c, ((c) x3.b(this.f7961f).get(r3)).f7965c);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(String r1, String r2) {
            return a(r1, r2);
        }
    }

    final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x3 f7962f;

        b(x3 r1) {
            this.f7962f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (x3.k(this.f7962f) == true) goto L5;
            return;
        L5:
            if (x3.n(this.f7962f) == false) goto L8;
            x3.q(this.f7962f);
            x3.t(this.f7962f);
        L8:
            if (x3.u(this.f7962f) == null) goto L12;
            x3.u(this.f7962f).postDelayed(x3.v(this.f7962f), 60000);
            return;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f7965c;

        public c(int r1, long r2, long r4) {
            this.f7963a = r1;
            this.f7964b = r2;
            this.f7965c = r4;
        }
    }

    public x3(Context r2, String r3, Handler r4) {
        this.f7955c = false;
        this.f7956d = new ConcurrentHashMap();
        this.f7958f = null;
        this.f7960h = new b(this);
        if (r2 != null) goto L5;
        return;
    L5:
        this.f7957e = r4;
        if (TextUtils.isEmpty(r3) == false) goto L8;
        r3 = "unknow";
    L8:
        this.f7953a = r3;
        this.f7958f = a5.d0(r2);
        String r5 = r2.getFilesDir().getPath();
        this.f7954b = new File(r5, this.f7953a);     // Catch: Throwable -> L11
    L13:
        p();
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    public static int a(long r0, long r2) {
        if (r0 >= r2) goto L6;
        return -1;
    L6:
        if (r0 != r2) goto L9;
        return 0;
    L9:
        return 1;
    }

    static /* synthetic */ Map b(x3 r0) {
        return r0.f7956d;
    }

    private void j(T r11, long r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (o(r11) < 0) goto L17;
        String r0 = i(r11);
        c r1 = this.f7956d.get(r0);
        if (r1 != null) goto L10;
        e(r11, r12);
        this.f7956d.put(r0, new c(l(r11), o(r11), r12));
        this.f7959g = true;
        return;
    L10:
        r1.f7965c = r12;
        if (r1.f7963a == l(r11)) goto L14;
        e(r11, r12);
        r1.f7963a = l(r11);
        r1.f7964b = o(r11);
        this.f7959g = true;
        return;
    L14:
        e(r11, r1.f7964b);
        return;
    }

    static /* synthetic */ boolean k(x3 r0) {
        return r0.f7955c;
    }

    static /* synthetic */ boolean n(x3 r0) {
        return r0.f7959g;
    }

    private void p() {
        StringBuilder r0 = new StringBuilder("restore from：\n");     // Catch: Throwable -> L19
        Iterator<String> r1 = a5.k(this.f7954b).iterator();     // Catch: Throwable -> L19
    L3:
        if (r1.hasNext() == false) goto L18;
        String r3 = new String(h4.h(m5.g(r1.next()), this.f7958f), "UTF-8");     // Catch: Throwable -> L12
        r0.append(r3);     // Catch: Throwable -> L12
        r0.append("\n");     // Catch: Throwable -> L12
        String[] r2 = r3.split(",");     // Catch: Throwable -> L12
    L7:
        if (r2.length < 4) goto L9;
        long r4 = Long.parseLong(r2[3]);     // Catch: Throwable -> L12
    L10:
        long r9 = r4;
        this.f7956d.put(r2[0], new c(Integer.parseInt(r2[1]), Long.parseLong(r2[2]), r9));     // Catch: Throwable -> L12
        goto L3
    L9:
        r4 = a5.A();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7954b.exists() == false) goto L16;
        this.f7954b.delete();     // Catch: Throwable -> L19
    L16:
        th.printStackTrace();     // Catch: Throwable -> L19
        goto L3
    L18:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ void q(x3 r0) {
        r0.s();
    }

    private void s() {
        if (m() <= 0) goto L18;
        this.f7956d.size();
        if (h() <= 0) goto L13;
        long r0 = a5.A();
        Iterator<Map.Entry<String, c>> r2 = this.f7956d.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        if ((r0 - this.f7956d.get(r2.next().getKey()).f7965c) <= h()) goto L8;
        r2.remove();
    L13:
        if (this.f7956d.size() <= m()) goto L18;
        ArrayList r1 = new ArrayList(this.f7956d.keySet());
        Collections.sort(r1, new a(this));
        int r3 = (int) m();
    L16:
        if (r3 >= r1.size()) goto L18;
        this.f7956d.remove(r1.get(r3));
        r3 = r3 + 1;
    L18:
        StringBuilder r4 = new StringBuilder();
        Iterator<Map.Entry<String, c>> r5 = this.f7956d.entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L26;
        Map.Entry<String, c> r6 = r5.next();
        r4.append(m5.f(h4.e((r6.getKey() + "," + r6.getValue().f7963a + "," + r6.getValue().f7964b + "," + r6.getValue().f7965c).getBytes("UTF-8"), this.f7958f)) + "\n");     // Catch: UnsupportedEncodingException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L26:
        String r7 = r4.toString();
        if (TextUtils.isEmpty(r7) == true) goto L42;
        a5.l(this.f7954b, r7);
        return;
    }

    static /* synthetic */ boolean t(x3 r1) {
        r1.f7959g = false;
        return false;
    }

    static /* synthetic */ Handler u(x3 r0) {
        return r0.f7957e;
    }

    static /* synthetic */ Runnable v(x3 r0) {
        return r0.f7960h;
    }

    public final void c() {
        if (this.f7955c == true) goto L7;
        Handler r0 = this.f7957e;
        if (r0 == null) goto L7;
        r0.removeCallbacks(this.f7960h);
        this.f7957e.postDelayed(this.f7960h, 60000);
    L7:
        this.f7955c = true;
    }

    public final void d(T r3) {
        j(r3, a5.A());
    }

    abstract void e(T r1, long r2);

    public final void f(List<T> r12) {
        long r6 = a5.A();
        Iterator<T> r0 = r12.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        j(r0.next(), r6);
        goto L4
    L7:
        if (this.f7956d.size() < r12.size()) goto L10;
        this.f7959g = true;
    L10:
        if (this.f7956d.size() <= 16384) goto L12;
    L13:
        this.f7956d.clear();
        Iterator<T> r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L20;
        T r1 = r13.next();
        this.f7956d.put(i(r1), new c(l(r1), o(r1), r6));
        goto L15
    L20:
        return;
    L12:
        if (m() <= 0) goto L13;
    }

    public final void g(boolean r3) {
        Handler r0 = this.f7957e;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.f7960h);
    L5:
        if (r3 == true) goto L7;
        this.f7960h.run();
    L7:
        this.f7955c = false;
    }

    abstract long h();

    public abstract String i(T r1);

    abstract int l(T r1);

    abstract long m();

    abstract long o(T r1);

    public final long r(T r3) {
        return (a5.A() - o(r3)) / 1000;
    }
}
