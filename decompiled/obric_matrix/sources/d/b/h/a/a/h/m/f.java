package d.b.h.a.a.h.m;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<URI, List<g>> f13431a;

    public f() {
        this.f13431a = new HashMap();
    }

    private URI c(URI r4) {
        if (r4 != null) goto L8;
        return null;
    L8:
        return new URI("http", r4.getHost(), null, null);
    L7:
        return r4;
    }

    @Override // d.b.h.a.a.h.m.e
    public synchronized void a(URI r3, g r4) {
        monitor-enter(this);
        if (r4 == null) goto L14;
        URI r5 = c(r3);     // Catch: Throwable -> L11
        List<g> r0 = this.f13431a.get(r5);     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
        r0 = new ArrayList();     // Catch: Throwable -> L11
        this.f13431a.put(r5, r0);     // Catch: Throwable -> L11
    L8:
        r0.add(r4);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r0.remove(r4);     // Catch: Throwable -> L11
        goto L8
    L14:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // d.b.h.a.a.h.m.e
    public synchronized List<g> b(URI r7) {
        monitor-enter(this);
        if (r7 == null) goto L37;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L34
        List<g> r1 = this.f13431a.get(r7);     // Catch: Throwable -> L34
        if (r1 == null) goto L13;
        Iterator<g> r2 = r1.iterator();     // Catch: Throwable -> L34
    L8:
        if (r2.hasNext() == false) goto L13;
        g r3 = r2.next();     // Catch: Throwable -> L34
        if (r3.G() == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L34
        goto L8
    L11:
        r2.remove();     // Catch: Throwable -> L34
    L13:
        Iterator<Map.Entry<URI, List<g>>> r4 = this.f13431a.entrySet().iterator();     // Catch: Throwable -> L34
    L15:
        if (r4.hasNext() == false) goto L31;
        Map.Entry<URI, List<g>> r5 = r4.next();     // Catch: Throwable -> L34
        if (r7.equals(r5.getKey()) == true) goto L15;
        Iterator<g> r6 = r5.getValue().iterator();     // Catch: Throwable -> L34
    L21:
        if (r6.hasNext() == false) goto L15;
        g r8 = r6.next();     // Catch: Throwable -> L34
        if (g.v(r8.y(), r7.getHost()) == false) goto L21;
        if (r8.G() == true) goto L27;
        if (r0.contains(r8) == true) goto L21;
        r0.add(r8);     // Catch: Throwable -> L34
        goto L21
    L27:
        r6.remove();     // Catch: Throwable -> L34
        goto L21
    L31:
        List<g> r9 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r9;
    L37:
        throw new NullPointerException("uri == null");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }
}
