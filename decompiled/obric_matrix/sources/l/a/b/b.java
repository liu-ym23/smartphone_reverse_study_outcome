package l.a.b;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f21492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Character, b> f21493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f21494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f21495e;

    public b() {
        this(0);
    }

    public b(int r2) {
        this.f21493c = new HashMap();
        b r0 = null;
        this.f21494d = null;
        this.f21495e = null;
        this.f21491a = r2;
        if (r2 != 0) goto L5;
        r0 = this;
    L5:
        this.f21492b = r0;
    }

    private b i(Character r2, boolean r3) {
        b r4 = this.f21493c.get(r2);
        if (r3 == true) goto L9;
        if (r4 != null) goto L10;
        b r1 = this.f21492b;
        if (r1 != null) goto L8;
        return r4;
    L8:
        return r1;
    L10:
        return r4;
    L9:
        return r4;
    }

    public void a(String r2) {
        if (this.f21495e != null) goto L5;
        this.f21495e = new TreeSet();
    L5:
        this.f21495e.add(r2);
    }

    public void b(Collection<String> r2) {
        Iterator<String> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        a(r3.next());
        goto L4
    }

    public b c(Character r3) {
        b r0 = j(r3);
        if (r0 != null) goto L6;
        b r1 = new b(this.f21491a + 1);
        this.f21493c.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public Collection<String> d() {
        Set<String> r0 = this.f21495e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Collections.emptyList();
    }

    public b e() {
        return this.f21494d;
    }

    public Collection<b> f() {
        return this.f21493c.values();
    }

    public Collection<Character> g() {
        return this.f21493c.keySet();
    }

    public b h(Character r2) {
        return i(r2, false);
    }

    public b j(Character r2) {
        return i(r2, true);
    }

    public void k(b r1) {
        this.f21494d = r1;
    }
}
