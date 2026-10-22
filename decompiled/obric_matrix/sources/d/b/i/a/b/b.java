package d.b.i.a.b;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.b.i.a.b.h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f13822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f13824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONObject f13825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f13826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f13827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f13828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13829k;

    public b(Context r3, String r4) {
        this.f13819a = 0;
        this.f13820b = 120;
        this.f13821c = 100;
        this.f13826h = true;
        this.f13827i = false;
        this.f13824f = r3;
        this.f13822d = c.e(r3);
        this.f13823e = r4;
    }

    private int b(long r2) {
        return this.f13822d.d(this.f13823e, r2);
    }

    private List<d.b.i.a.b.f.a> d(int r2) {
        int r0 = Integer.parseInt(this.f13823e);
        return this.f13822d.i(r0, r2);
    }

    private long e() {
        return this.f13822d.f(this.f13823e);
    }

    private boolean j(JSONArray r3, boolean r4) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L12
        if (d.b.i.a.b.i.b.a(r3) == false) goto L6;
        return false;
    L6:
        r0.put("data", r3);     // Catch: Throwable -> L12
        JSONObject r5 = this.f13825g;     // Catch: Throwable -> L12
        if (r5 == null) goto L10;
        r0.put("header", r5);     // Catch: Throwable -> L12
        return d.b.i.a.b.g.d.c(this.f13823e, r0.toString());
    L10:
        return true;
    L12:
        return false;
    }

    private void l(JSONObject r1) {
        this.f13825g = r1;
    }

    private void m(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.f13821c = r1;
    }

    private void n(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.f13820b = r1;
    }

    public int a() {
        return b(2147483647L);
    }

    public void c() {
        this.f13827i = true;
    }

    public void f() {
        d.b.i.a.b.h.c.e().d(this);
        String r0 = this.f13823e;
        d.b.i.a.b.g.d.e(r0, new d.b.i.a.b.g.a(this.f13824f, r0));
    }

    public boolean g(boolean r9) {
        if (this.f13826h == true) goto L5;
    L20:
        return true;
    L5:
        if (this.f13827i == true) goto L20;
        long r2 = System.currentTimeMillis();
        long r4 = e();
        if (r4 > 0) goto L10;
        return true;
    L10:
        if (r9 == false) goto L12;
    L18:
        this.f13819a = r2;
        return h();
    L12:
        if (r4 > this.f13821c) goto L18;
        if (((r2 - this.f13819a) / 1000) > this.f13820b) goto L18;
        return false;
    }

    public boolean h() {
        List<d.b.i.a.b.f.a> r0 = d(this.f13821c);
        if (d.b.i.a.b.i.c.a(r0) == false) goto L6;
        return true;
    L6:
        long r1 = -1;
        boolean r3 = false;
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L21
        LinkedList r5 = new LinkedList();     // Catch: Throwable -> L21
        Iterator<d.b.i.a.b.f.a> r2 = r0.iterator();     // Catch: Throwable -> L21
    L9:
        if (r2.hasNext() == false) goto L16;
        d.b.i.a.b.f.a r6 = r2.next();     // Catch: Throwable -> L21
        long r7 = r6.f13849a;     // Catch: Throwable -> L21
        if (r7 <= r1) goto L13;
        r1 = r7;
    L13:
        String r9 = r6.f13853e;     // Catch: Throwable -> L21
        r5.add(r6);     // Catch: Throwable -> L21
        JSONObject r8 = new JSONObject(r9);     // Catch: Throwable -> L20
        r8.put("log_id", r7);     // Catch: Throwable -> L20
        r8.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L20
        r4.put(r8);     // Catch: Throwable -> L20
        goto L9
    L16:
        r3 = j(r4, false);     // Catch: Throwable -> L21
        if (r3 == false) goto L19;
        b(r1);     // Catch: Throwable -> L21
    L19:
        return r3;
    }

    public void i() {
        this.f13826h = true;
        this.f13829k = 0;
    }

    public void k(long r3) {
        this.f13826h = false;
        this.f13828j = System.currentTimeMillis();
        this.f13829k = r3;
    }

    public void o() {
        n(d.b.i.a.b.e.c.e(this.f13823e));
        m(d.b.i.a.b.e.c.b(this.f13823e));
        l(d.b.i.a.b.e.c.f(this.f13823e));
        d.b.i.a.b.g.b r1 = d.b.i.a.b.g.d.b(this.f13823e);
        if ((r1 instanceof d.b.i.a.b.g.a) == false) goto L6;
        ((d.b.i.a.b.g.a) r1).s(null);
        return;
    }

    @Override // d.b.i.a.b.h.b
    public void onTimeEvent(long r5) {
        long r0 = this.f13829k;
        if (r0 > 0) goto L5;
    L7:
        g(false);
        return;
    L5:
        if ((r5 - this.f13828j) <= r0) goto L7;
        i();
        goto L7
    }
}
