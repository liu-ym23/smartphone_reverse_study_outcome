package com.loc;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<d4> f7268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f7269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f7271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f7274g;

    final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e4 f7275f;

        a(e4 r1) {
            this.f7275f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e4.e(this.f7275f) == false) goto L5;
            return;
        L5:
            if (e4.h(this.f7275f) == false) goto L8;
            e4.j(this.f7275f);
            e4.k(this.f7275f);
        L8:
            if (e4.l(this.f7275f) == null) goto L12;
            e4.l(this.f7275f).postDelayed(e4.m(this.f7275f), 60000);
            return;
        }
    }

    public e4(Context r3, Handler r4) {
        this.f7268a = new LinkedList();
        this.f7270c = false;
        this.f7272e = null;
        this.f7274g = new a(this);
        this.f7271d = r4;
        String r5 = r3.getFilesDir().getPath();
        if (this.f7272e != null) goto L13;
        this.f7272e = a5.d0(r3);
    L13:
        this.f7269b = new File(r5, "hisloc");     // Catch: Throwable -> L7
    L9:
        b();
        Handler r6 = this.f7271d;
        if (r6 == null) goto L15;
        r6.removeCallbacks(this.f7274g);
        this.f7271d.postDelayed(this.f7274g, 60000);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        l3.a(th);
        goto L9
    }

    private void b() {
        LinkedList<d4> r0 = this.f7268a;
        if (r0 != null) goto L5;
    L7:
        Iterator<String> r1 = a5.k(this.f7269b).iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        String r2 = new String(h4.h(m5.g(r1.next()), this.f7272e), "UTF-8");     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
        d4 r3 = new d4();     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
        r3.b(new JSONObject(r2));     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
        this.f7268a.add(r3);     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L17:
        return;
    L5:
        if (r0.size() <= 0) goto L7;
    }

    static /* synthetic */ boolean e(e4 r0) {
        return r0.f7270c;
    }

    private void f() {
        StringBuilder r0 = new StringBuilder();
        Iterator<d4> r1 = this.f7268a.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        r0.append(m5.f(h4.e(r1.next().a().getBytes("UTF-8"), this.f7272e)) + "\n");     // Catch: UnsupportedEncodingException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        String r2 = r0.toString();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        a5.l(this.f7269b, r2);
        return;
    }

    static /* synthetic */ boolean h(e4 r0) {
        return r0.f7273f;
    }

    private static boolean i(ArrayList<b4> r5, ArrayList<i3> r6) {
        if (r5 != null) goto L5;
    L17:
        return true;
    L5:
        if (r5.size() <= 0) goto L17;
        if (r6 == null) goto L17;
        if (r6.size() <= 0) goto L17;
        if (r5.size() < 4) goto L15;
        return false;
    L15:
        if (r6.size() < 20) goto L17;
        return false;
    }

    static /* synthetic */ void j(e4 r0) {
        r0.f();
    }

    static /* synthetic */ boolean k(e4 r1) {
        r1.f7273f = false;
        return false;
    }

    static /* synthetic */ Handler l(e4 r0) {
        return r0.f7271d;
    }

    static /* synthetic */ Runnable m(e4 r0) {
        return r0.f7274g;
    }

    public final List<d4> a(ArrayList<b4> r8, ArrayList<i3> r9) {
        if (i(r8, r9) == false) goto L13;
        long r10 = System.currentTimeMillis();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        Iterator<d4> r7 = this.f7268a.iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        d4 r2 = r7.next();
        if ((r10 - r2.f7243d) >= 21600000000L) goto L11;
        r0.add(r2);
        r1 = r1 + 1;
    L11:
        if (r1 != 10) goto L6;
    L12:
        return r0;
    L13:
        return null;
    }

    public final void c(d4 r12) {
        Iterator<d4> r0 = this.f7268a.iterator();
        d4 r2 = null;
        int r4 = 0;
        d4 r3 = null;
    L4:
        if (r0.hasNext() == false) goto L10;
        d4 r5 = r0.next();
        if (r5.f7240a != 1) goto L4;
        if (r3 != null) goto L9;
        r3 = r5;
    L9:
        r4 = r4 + 1;
        r2 = r5;
        goto L4
    L10:
        if (r2 == null) goto L17;
        new Location("gps");
        if ((r12.f7243d - r2.f7243d) >= 20000) goto L17;
        if (a5.d(new double[]{r12.f7241b, r12.f7242c, r2.f7241b, r2.f7242c}) >= 20.0f) goto L17;
        return;
    L17:
        if (r4 < 5) goto L20;
        this.f7268a.remove(r3);
    L20:
        if (this.f7268a.size() < 10) goto L22;
        this.f7268a.removeFirst();
    L22:
        this.f7268a.add(r12);
        this.f7273f = true;
    }

    public final void d(boolean r2) {
        if (r2 == true) goto L4;
        this.f7274g.run();
    L4:
        Handler r3 = this.f7271d;
        if (r3 == null) goto L7;
        r3.removeCallbacks(this.f7274g);
    L7:
        this.f7270c = true;
    }

    public final void g(d4 r10) {
        if (this.f7268a.size() <= 0) goto L26;
        int r0 = r10.f7240a;
        if (r0 != 6) goto L7;
    L15:
        d4 r1 = this.f7268a.getLast();
        if (r1.f7242c != r10.f7242c) goto L22;
        if (r1.f7241b != r10.f7241b) goto L22;
        if (r1.f7244e != r10.f7244e) goto L22;
        return;
    L22:
        if (this.f7268a.size() < 10) goto L24;
        this.f7268a.removeFirst();
    L24:
        this.f7268a.add(r10);
        this.f7273f = true;
        return;
    L7:
        if (r0 == 5) goto L15;
        if (this.f7268a.contains(r10) == false) goto L12;
        return;
    L12:
        if (this.f7268a.size() < 10) goto L14;
        this.f7268a.removeFirst();
    L14:
        this.f7268a.add(r10);
        this.f7273f = true;
        return;
    }
}
