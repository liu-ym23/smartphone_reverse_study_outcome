package d.a.a.j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f12491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f12492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<d> f12493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<a> f12494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<u> f12495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected List<c0> f12496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected List<r> f12497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected List<v> f12498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f12500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DateFormat f12501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected IdentityHashMap<Object, w> f12502l;
    protected w m;
    public TimeZone n;
    public Locale o;

    public m(z r3, x r4) {
        this.f12493c = null;
        this.f12494d = null;
        this.f12495e = null;
        this.f12496f = null;
        this.f12497g = null;
        this.f12498h = null;
        this.f12499i = 0;
        this.f12502l = null;
        this.n = d.a.a.a.f12369f;
        this.o = d.a.a.a.f12370g;
        this.f12492b = r3;
        this.f12491a = r4;
        this.n = d.a.a.a.f12369f;
    }

    public static Object o(m r2, Object r3, Object r4, Object r5) {
        List<c0> r6 = r2.f12496f;
        if (r6 == null) goto L12;
        if (r4 != null) goto L6;
    L8:
        Iterator<c0> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r5 = r7.next().a(r3, (String) r4, r5);
        goto L10
    L6:
        if ((r4 instanceof String) == true) goto L8;
        r4 = d.a.a.a.q(r4);
    L12:
        return r5;
    }

    public boolean a(Object r4, Object r5, Object r6) {
        List<u> r3 = this.f12495e;
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
    L9:
        Iterator<u> r7 = r3.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        if (r7.next().b(r4, (String) r5, r6) == true) goto L11;
        return false;
    L16:
        return true;
    L7:
        if ((r5 instanceof String) == true) goto L9;
        r5 = d.a.a.a.q(r5);
        goto L9
    }

    public boolean b(Object r5, Object r6) {
        List<v> r0 = this.f12498h;
        if (r0 != null) goto L5;
        return true;
    L5:
        Iterator<v> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        v r2 = r1.next();
        if (r6 == null) goto L14;
        if ((r6 instanceof String) == true) goto L14;
        r6 = d.a.a.a.q(r6);
    L14:
        if (r2.c(this, r5, (String) r6) == true) goto L7;
        return false;
    L17:
        return true;
    }

    public void c(a0 r1, boolean r2) {
        this.f12492b.l(r1, r2);
    }

    public void d() {
        this.f12499i--;
    }

    public List<a> e() {
        if (this.f12494d != null) goto L6;
        this.f12494d = new ArrayList();
    L6:
        return this.f12494d;
    }

    public List<d> f() {
        if (this.f12493c != null) goto L6;
        this.f12493c = new ArrayList();
    L6:
        return this.f12493c;
    }

    public DateFormat g() {
        if (this.f12501k != null) goto L8;
        if (this.f12500j == null) goto L8;
        SimpleDateFormat r0 = new SimpleDateFormat(this.f12500j, this.o);
        this.f12501k = r0;
        r0.setTimeZone(this.n);
    L8:
        return this.f12501k;
    }

    public List<r> h() {
        if (this.f12497g != null) goto L6;
        this.f12497g = new ArrayList();
    L6:
        return this.f12497g;
    }

    public List<u> i() {
        if (this.f12495e != null) goto L6;
        this.f12495e = new ArrayList();
    L6:
        return this.f12495e;
    }

    public List<v> j() {
        if (this.f12498h != null) goto L6;
        this.f12498h = new ArrayList();
    L6:
        return this.f12498h;
    }

    public List<c0> k() {
        if (this.f12496f != null) goto L6;
        this.f12496f = new ArrayList();
    L6:
        return this.f12496f;
    }

    public void l() {
        this.f12499i++;
    }

    public void m() {
        this.f12492b.write(10);
        int r0 = 0;
    L4:
        if (r0 >= this.f12499i) goto L6;
        this.f12492b.write(9);
        r0 = r0 + 1;
        goto L4
    }

    public Object n(Object r2, Object r3, Object r4) {
        List<r> r1 = this.f12497g;
        if (r1 == null) goto L12;
        if (r3 != null) goto L6;
    L8:
        Iterator<r> r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r3 = r5.next().a(r2, (String) r3, r4);
        goto L10
    L6:
        if ((r3 instanceof String) == true) goto L8;
        r3 = d.a.a.a.q(r3);
    L12:
        return r3;
    }

    public void p(w r3, Object r4, Object r5, int r6) {
        if ((this.f12492b.f12526h & a0.u.f12471f) != 0) goto L9;
        this.m = new w(r3, r4, r5, r6);
        if (this.f12502l != null) goto L7;
        this.f12502l = new IdentityHashMap();
    L7:
        this.f12502l.put(r4, this.m);
        return;
    }

    public void q(String r1) {
        this.f12500j = r1;
        if (this.f12501k == null) goto L6;
        this.f12501k = null;
        return;
    }

    public final void r(Object r3) {
        if (r3 != null) goto L5;
        this.f12492b.Q();
        return;
    L5:
        Class<?> r0 = r3.getClass();
        this.f12491a.a(r0).b(this, r3, null, null);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new d.a.a.d(e.getMessage(), e);
    }

    public final void s(String r3) {
        z r2 = this.f12492b;
        if (r3 != null) goto L10;
        if ((r2.f12526h & a0.m.f12471f) == 0) goto L7;
        r2.S("");
        return;
    L7:
        r2.Q();
        return;
    L10:
        if ((r2.f12526h & a0.f12466h.f12471f) == 0) goto L12;
        r2.X(r3);
        return;
    L12:
        r2.V(r3, 0, true);
    }

    public void t(Object r3) {
        w r0 = this.m;
        if (r3 != r0.f12514b) goto L7;
        z r2 = this.f12492b;
        String r4 = "{\"$ref\":\"@\"}";
    L5:
        r2.write(r4);
        return;
    L7:
        w r1 = r0.f12513a;
        if (r1 == null) goto L12;
        if (r3 != r1.f12514b) goto L12;
        r2 = this.f12492b;
        r4 = "{\"$ref\":\"..\"}";
    L12:
        w r5 = r0.f12513a;
        if (r5 == null) goto L15;
        r0 = r5;
        goto L12
    L15:
        if (r3 != r0.f12514b) goto L17;
        r2 = this.f12492b;
        r4 = "{\"$ref\":\"$\"}";
        goto L5
    L17:
        String r6 = this.f12502l.get(r3).toString();
        this.f12492b.write("{\"$ref\":\"");
        this.f12492b.write(r6);
        r2 = this.f12492b;
        r4 = "\"}";
        goto L5
    }

    public String toString() {
        return this.f12492b.toString();
    }

    public final void u(Object r3, Object r4) {
        v(r3, r4, null, 0);
    }

    public final void v(Object r2, Object r3, Type r4, int r5) {
        if (r2 != null) goto L5;
        this.f12492b.Q();     // Catch: IOException -> L7
        return;
    L5:
        Class<?> r6 = r2.getClass();     // Catch: IOException -> L7
        this.f12491a.a(r6).b(this, r2, r3, r4);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new d.a.a.d(e.getMessage(), e);
    }

    public final void w(Object r3, String r4) {
        if ((r3 instanceof Date) == false) goto L9;
        DateFormat r0 = g();
        if (r0 != null) goto L7;
        r0 = new SimpleDateFormat(r4, this.o);
        r0.setTimeZone(this.n);
    L7:
        String r5 = r0.format((Date) r3);
        this.f12492b.S(r5);
        return;
    L9:
        r(r3);
    }
}
