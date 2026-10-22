package d.b.h.a.a.h.o.b.x;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.h.a.a.h.s.f<String, a> f13590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, a> f13591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentMap<String, Future<Void>> f13592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentMap<String, Future<Void>> f13593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentSkipListSet<c>> f13594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentSkipListSet<c>> f13595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f13596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f13597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicInteger f13598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.common.utility.i.a f13599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Handler f13600k;

    static {
    }

    public d(Handler r3) {
        this.f13590a = new d.b.h.a.a.h.s.f(100);
        this.f13591b = new ConcurrentHashMap();
        this.f13592c = new ConcurrentHashMap();
        this.f13593d = new ConcurrentHashMap();
        this.f13594e = new ConcurrentHashMap();
        this.f13595f = new ConcurrentHashMap();
        this.f13596g = new ConcurrentSkipListSet();
        this.f13597h = new AtomicInteger(0);
        this.f13598i = new AtomicInteger(0);
        this.f13599j = com.bytedance.common.utility.i.a.f3284h;
        this.f13600k = r3;
    }

    void A() {
        this.f13597h.getAndIncrement();
    }

    public boolean B(String r1) {
        return this.f13594e.containsKey(r1);
    }

    public boolean C(c r3) {
        if (this.f13594e.containsKey(r3.b()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f13594e.get(r3.b()).contains(r3) == false) goto L7;
        return true;
    }

    public boolean D(String r1) {
        return this.f13595f.containsKey(r1);
    }

    public boolean E(c r3) {
        if (this.f13595f.containsKey(r3.b()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f13595f.get(r3.b()).contains(r3) == false) goto L7;
        return true;
    }

    public void a(String r3, a r4) {
        a r0 = i(r3);
        if (r0 == null) goto L9;
        if (e.q().s().get() == false) goto L7;
        r0.h();
        goto L9
    L7:
        r0.i();
    L9:
        if (e.q().s().get() == false) goto L11;
        r4.a();
    L12:
        Map<String, a> r1 = this.f13590a.e();
        monitor-enter(r1);
        this.f13590a.f(r3, r4);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r4.b();
        goto L12
    }

    void b() {
        this.f13598i.getAndIncrement();
        if (this.f13598i.get() < 2) goto L6;
        Message r0 = Message.obtain();
        r0.what = 20;
        r0.obj = this;
        this.f13600k.sendMessageDelayed(r0, 180000);
        return;
    }

    public synchronized void c(String r2, c r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f13594e.containsKey(r2) == false) goto L6;
        this.f13594e.get(r2).add(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<c> r0 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r0.add(r3);     // Catch: Throwable -> L9
        this.f13594e.put(r2, r0);     // Catch: Throwable -> L9
        goto L7
    }

    public void d(String r1, Future<Void> r2) {
        this.f13592c.put(r1, r2);
    }

    public void e(String r2) {
        this.f13596g.add(r2);
        if (this.f13596g.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        r3.addAll(this.f13596g);
        e.q().c(r3);
    }

    public void f(String r2, a r3) {
        a r0 = m(r2);
        if (r0 == null) goto L5;
        r0.j();
    L5:
        r3.c();
        this.f13591b.put(r2, r3);
    }

    public void g(String r1, Future<Void> r2) {
        this.f13593d.put(r1, r2);
    }

    AtomicInteger h() {
        return this.f13597h;
    }

    public a i(String r2) {
        Map<String, a> r0 = this.f13590a.e();
        monitor-enter(r0);
        a r1 = this.f13590a.d(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    AtomicInteger j() {
        return this.f13598i;
    }

    public ConcurrentSkipListSet<c> k(String r1) {
        return this.f13594e.get(r1);
    }

    public Future<Void> l(String r2) {
        if (this.f13592c.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.f13592c.get(r2);
    }

    public a m(String r2) {
        if (this.f13591b.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.f13591b.get(r2);
    }

    public ConcurrentSkipListSet<c> n(String r1) {
        return this.f13595f.get(r1);
    }

    public Future<Void> o(String r2) {
        if (this.f13593d.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.f13593d.get(r2);
    }

    public boolean p(String r1) {
        return this.f13592c.containsKey(r1);
    }

    public boolean q(String r1) {
        return this.f13593d.containsKey(r1);
    }

    public void r(Context r5) {
        com.bytedance.common.utility.i.a r6 = com.bytedance.common.utility.i.i(r5);
        if (r6 == this.f13599j) goto L29;
        Logger.debug();
        Map<String, a> r0 = this.f13590a.e();
        monitor-enter(r0);
        Iterator<Map.Entry<String, a>> r1 = this.f13590a.e().entrySet().iterator();     // Catch: Throwable -> L26
    L8:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, a> r2 = r1.next();     // Catch: Throwable -> L26
        if (r2 == null) goto L8;
        if (e.q().s().get() == true) goto L13;
        r2.getValue().i();     // Catch: Throwable -> L26
        goto L8
    L13:
        r2.getValue().h();     // Catch: Throwable -> L26
        goto L8
    L15:
        this.f13590a.c();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        Iterator<Map.Entry<String, a>> r3 = this.f13591b.entrySet().iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        Map.Entry<String, a> r4 = r3.next();
        if (r4 == null) goto L19;
        r4.getValue().j();
        goto L19
    L23:
        this.f13591b.clear();
        if (r6 == com.bytedance.common.utility.i.a.f3284h) goto L29;
        e.q().e(a.EnumC0360a.f13572i);
        e.q().G();
    L26:
        th = move-exception;
        throw th;
    L29:
        this.f13599j = r6;
    }

    public void s(String r3) {
        a r0 = i(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (e.q().s().get() == false) goto L7;
        r0.h();
    L8:
        Map<String, a> r1 = this.f13590a.e();
        monitor-enter(r1);
        this.f13590a.g(r3);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r0.i();
        goto L8
    }

    public void t(c r3) {
        String r0 = r3.b();
        if (this.f13594e.containsKey(r0) == false) goto L8;
        this.f13594e.get(r0).remove(r3);
        if (this.f13594e.get(r0).isEmpty() == false) goto L9;
        this.f13594e.remove(r0);
        return;
    L9:
        return;
    }

    public void u(String r1) {
        this.f13592c.remove(r1);
    }

    public void v(String r2) {
        if (this.f13596g.contains(r2) == false) goto L6;
        this.f13596g.remove(r2);
        return;
    }

    public void w(String r2) {
        a r0 = m(r2);
        if (r0 == null) goto L6;
        r0.j();
        this.f13591b.remove(r2);
        return;
    }

    public void x(c r3) {
        String r0 = r3.b();
        if (this.f13595f.containsKey(r0) == false) goto L8;
        this.f13595f.get(r0).remove(r3);
        if (this.f13595f.get(r0).isEmpty() == false) goto L9;
        this.f13595f.remove(r0);
        return;
    L9:
        return;
    }

    public void y(String r1) {
        this.f13593d.remove(r1);
    }

    void z() {
        this.f13598i.set(0);
    }
}
