package d.b.r.h0;

import d.b.r.k0.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f14390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f14391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f14392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14394g;

    public d(String r2, int r3, String r4, List<b> r5, i r6) {
        if (r2 == null) goto L17;
        if (r3 < 200) goto L15;
        if (r4 == null) goto L13;
        if (r5 == null) goto L11;
        this.f14388a = r2;
        this.f14389b = r3;
        this.f14390c = Collections.unmodifiableList(new ArrayList(r5));
        this.f14391d = r6;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException("Invalid status code: " + r3);
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public i a() {
        return this.f14391d;
    }

    public Object b() {
        return this.f14392e;
    }

    public b c(String r4) {
        if (r4 == null) goto L13;
        List<b> r3 = this.f14390c;
        if (r3 == null) goto L13;
        Iterator<b> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        b r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.a()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<b> d() {
        return this.f14390c;
    }

    public int e() {
        return this.f14389b;
    }

    public String f() {
        return this.f14393f;
    }

    public String g() {
        return this.f14388a;
    }

    public List<b> h(String r4) {
        ArrayList r0 = null;
        if (r4 == null) goto L15;
        List<b> r3 = this.f14390c;
        if (r3 == null) goto L15;
        Iterator<b> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        b r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.a()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public boolean i() {
        int r1 = this.f14389b;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public String j() {
        return this.f14394g;
    }

    public void k(Object r1) {
        this.f14392e = r1;
    }

    public void l(String r1) {
        this.f14393f = r1;
    }
}
