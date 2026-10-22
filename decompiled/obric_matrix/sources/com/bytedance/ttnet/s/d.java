package com.bytedance.ttnet.s;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.k;
import d.b.h.a.a.h.s.f;
import d.b.r.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<d.b.r.j0.a> f6620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f<String, v> f6621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f<String, v> f6622c;

    class a implements d.b.r.h0.a.InterfaceC0388a {
        a() {
        }

        @Override // d.b.r.h0.a.InterfaceC0388a
        public d.b.r.h0.a get() {
            return new com.bytedance.ttnet.q.b();
        }
    }

    class b implements d.b.r.h0.a.InterfaceC0388a {
        b() {
        }

        @Override // d.b.r.h0.a.InterfaceC0388a
        public d.b.r.h0.a get() {
            return new com.bytedance.ttnet.q.b();
        }
    }

    static {
        f6620a = new CopyOnWriteArrayList();
        v.s(f6620a);
        f6621b = new f(10);
        f6622c = new f(10);
    }

    public static synchronized void a(d.b.r.j0.a r2) {
        monitor-enter(d.class);
        if (r2 != null) goto L16;
        monitor-exit(d.class);
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f6620a.contains(r2) == true) goto L10;
        f6620a.add(r2);     // Catch: Throwable -> L13
    L10:
        e.j(f6621b, r2);     // Catch: Throwable -> L13
        e.j(f6622c, r2);     // Catch: Throwable -> L13
        monitor-exit(d.class);
    }

    public static synchronized v b(String r3, List<d.b.r.j0.a> r4, d.b.r.f.a r5, d.b.r.c.a r6, d.b.r.h0.a.InterfaceC0388a r7) {
        monitor-enter(d.class);
        ArrayList r1 = null;
        if (r5 != null) goto L17;
        ArrayList r2 = null;
    L10:
        if (r6 == null) goto L12;
        r1 = new ArrayList();     // Catch: Throwable -> L7
        r1.add(r6);     // Catch: Throwable -> L7
    L12:
        v r8 = c(r4, r2, r1, r7, r3);     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    L17:
        r2 = new ArrayList();     // Catch: Throwable -> L7
        r2.add(r5);     // Catch: Throwable -> L7
        goto L10
    }

    public static synchronized v c(List<d.b.r.j0.a> r3, List<d.b.r.f.a> r4, List<d.b.r.c.a> r5, d.b.r.h0.a.InterfaceC0388a r6, String r7) {
        monitor-enter(d.class);
        if (r6 == null) goto L56;
    L6:
        v.b r1 = new v.b();     // Catch: Throwable -> L53
        r1.h(r7);     // Catch: Throwable -> L53
        r1.e(r6);     // Catch: Throwable -> L53
        r1.f(new d.b.h.a.a.h.q.c());     // Catch: Throwable -> L53
        if (r4 != null) goto L10;
        r4 = new ArrayList();     // Catch: Throwable -> L53
    L10:
        if (r4.isEmpty() == false) goto L12;
        r4.add(d.b.h.a.a.h.q.d.a.a.f());     // Catch: Throwable -> L53
    L12:
        Iterator<d.b.r.f.a> r8 = r4.iterator();     // Catch: Throwable -> L53
    L14:
        if (r8.hasNext() == false) goto L16;
        r1.b(r8.next());     // Catch: Throwable -> L53
        goto L14
    L16:
        if (r5 != null) goto L18;
    L23:
        LinkedList r9 = new LinkedList();     // Catch: Throwable -> L53
        if (r3 != null) goto L26;
    L38:
        boolean r10 = false;
    L39:
        if (r10 == true) goto L42;
        r9.add(0, new com.bytedance.ttnet.q.a());     // Catch: Throwable -> L53
    L42:
        if (f6620a != null) goto L44;
    L46:
        r9.add(new d.b.h.a.a.h.q.b());     // Catch: Throwable -> L53
        Iterator r11 = r9.iterator();     // Catch: Throwable -> L53
    L48:
        if (r11.hasNext() == false) goto L50;
        r1.c((d.b.r.j0.a) r11.next());     // Catch: Throwable -> L53
        goto L48
    L50:
        v r12 = r1.d();     // Catch: Throwable -> L53
        monitor-exit(d.class);
        return r12;
    L53:
        th = move-exception;
        throw th;
    L44:
        if (f6620a.size() <= 0) goto L46;
        r9.addAll(f6620a);     // Catch: Throwable -> L53
        goto L46
    L26:
        if (r3.size() <= 0) goto L38;
        Iterator<d.b.r.j0.a> r13 = r3.iterator();     // Catch: Throwable -> L53
        r10 = false;
    L29:
        if (r13.hasNext() == false) goto L39;
        d.b.r.j0.a r14 = r13.next();     // Catch: Throwable -> L53
        if ((r14 instanceof com.bytedance.ttnet.q.a) == true) goto L32;
        if ((r14 instanceof d.b.h.a.a.h.q.b) == true) goto L29;
    L37:
        r9.add(r14);     // Catch: Throwable -> L53
        goto L29
    L32:
        if (r10 == true) goto L29;
        r9.add(r14);     // Catch: Throwable -> L53
        r10 = true;
        goto L37
    L18:
        if (r5.isEmpty() == true) goto L23;
        Iterator<d.b.r.c.a> r15 = r5.iterator();     // Catch: Throwable -> L53
    L21:
        if (r15.hasNext() == false) goto L23;
        r1.a(r15.next());     // Catch: Throwable -> L53
        goto L21
    L56:
        r6 = new b();     // Catch: Throwable -> L53
        goto L6
    }

    public static synchronized <S> S d(v r1, Class<S> r2) {
        monitor-enter(d.class);
        if (r1 == null) goto L12;
        S r3 = (S) r1.e(r2);
        monitor-exit(d.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(d.class);
        return null;
    }

    public static synchronized v e(String r2, List<d.b.r.j0.a> r3, d.b.r.f.a r4, d.b.r.c.a r5) {
        monitor-enter(d.class);
        v r6 = b(r2, r3, r4, r5, new a());     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S f(String r1, Class<S> r2) {
        monitor-enter(d.class);
        S r3 = (S) d(h(r1), r2);
        monitor-exit(d.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static String g(List<d.b.r.h0.b> r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L23;
        Iterator<d.b.r.h0.b> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        d.b.r.h0.b r0 = r4.next();
        if (r3.equalsIgnoreCase(r0.a()) == false) goto L10;
        return r0.b();
    L15:
        return "";
    L23:
        return null;
    }

    public static synchronized v h(String r3) {
        monitor-enter(d.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (k.c(r3) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        v r1 = f6621b.d(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(d.class);
        return r1;
    L13:
        v r2 = e(r3, null, null, null);     // Catch: Throwable -> L16
        f6621b.f(r3, r2);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r2;
    }

    public static Pair<String, String> i(String r3) {
        String r0 = null;
        if (r3 != null) goto L12;
        return null;
    L12:
        d.b.h.a.a.h.p.b r1 = new d.b.h.a.a.h.p.b(r3);     // Catch: Throwable -> L8
        String r4 = r1.a();     // Catch: Throwable -> L8
        r0 = r1.b("charset");     // Catch: Throwable -> L11
    L10:
        return new Pair(r4, r0);
    L8:
        r4 = null;
        goto L10
    }

    public static synchronized void j(d.b.r.j0.a r2) {
        monitor-enter(d.class);
        if (r2 != null) goto L17;
        monitor-exit(d.class);
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (f6620a.contains(r2) == true) goto L11;
        monitor-exit(d.class);
        return;
    L11:
        f6620a.remove(r2);     // Catch: Throwable -> L14
        e.k(f6621b, r2);     // Catch: Throwable -> L14
        e.k(f6622c, r2);     // Catch: Throwable -> L14
        monitor-exit(d.class);
    }
}
