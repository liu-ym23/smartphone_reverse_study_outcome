package d.b.i.a.c;

import android.content.Context;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static d f13921f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, a> f13923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f13924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f13925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedList<b> f13926e;

    private d(Context r4) {
        AtomicBoolean r0 = new AtomicBoolean(false);
        this.f13925d = r0;
        LinkedList<b> r1 = new LinkedList();
        this.f13926e = r1;
        Context r5 = r4.getApplicationContext();
        this.f13922a = r5;
        this.f13923b = new ConcurrentHashMap();
        f r2 = new f(r5, this, r1, r0);
        this.f13924c = r2;
        r2.start();
    }

    public static d c(Context r2) {
        if (f13921f != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13921f != null) goto L9;
        f13921f = new d(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f13921f;
    }

    static void f(String r0) {
    }

    static void g(String r0, String r1) {
    }

    boolean a(String r4, byte[] r5) {
        if (e() == true) goto L26;
        if (r5 == null) goto L26;
        if (r5.length <= 0) goto L26;
        if (d(r4) != null) goto L11;
        return false;
    L11:
        LinkedList<b> r0 = this.f13926e;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L14:
        if (this.f13925d.get() == false) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L18:
        if (this.f13926e.size() < 2000) goto L20;
        this.f13926e.poll();     // Catch: Throwable -> L23
    L20:
        boolean r6 = this.f13926e.add(new b(r4, r5));     // Catch: Throwable -> L23
        this.f13924c.b();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r6;
    L26:
        return false;
    }

    Map<String, a> b() {
        return this.f13923b;
    }

    a d(String r1) {
        return this.f13923b.get(r1);
    }

    boolean e() {
        return this.f13925d.get();
    }

    public void h(String r2, a r3) {
        if (e() == true) goto L8;
        if (r3 == null) goto L9;
        this.f13923b.put(r2, r3);
        return;
    L9:
        return;
    }
}
