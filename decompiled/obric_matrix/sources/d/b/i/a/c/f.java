package d.b.i.a.c;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class f extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f13930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f13931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f13932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e f13933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f13934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13936l;
    private d m;
    private final LinkedList<b> n;
    private int o;

    f(Context r3, d r4, LinkedList<b> r5, AtomicBoolean r6) {
        super("LogSender");
        this.f13931g = new Object();
        this.f13934j = -1;
        this.f13935k = 0;
        this.f13936l = 120000;
        this.m = r4;
        this.f13930f = r3;
        this.n = r5;
        this.f13932h = r6;
        this.f13933i = e.c(r3);
    }

    private void c() {
        if (d() == false) goto L5;
        return;
    L5:
        Map<String, a> r0 = this.m.b();
        if (r0 != null) goto L8;
    L22:
        this.f13933i.a(null, -1, 864000000);
        return;
    L8:
        if (r0.isEmpty() == true) goto L22;
        Iterator<String> r1 = r0.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L22;
        String r2 = r1.next();
        if (d() == true) goto L22;
        a r3 = r0.get(r2);
        if (r3 == null) goto L11;
        a.b r4 = r3.c();
        if (r4 == null) goto L11;
        this.f13933i.a(r2, r4.d(), r4.e());
        goto L11
    }

    private boolean d() {
        return this.f13932h.get();
    }

    private boolean e() {
        boolean r1 = false;
        if (d() == false) goto L5;
        return false;
    L5:
        b r0 = null;
        LinkedList<b> r2 = this.n;
        monitor-enter(r2);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (d() == false) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L25
        return false;
    L12:
        if (this.n.isEmpty() == true) goto L15;
        r0 = this.n.poll();     // Catch: Throwable -> L25
    L15:
        if (this.n.isEmpty() == true) goto L17;
        r1 = true;
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L25
        if (r0 != null) goto L28;
    L24:
        return r1;
    L28:
    L23:
        this.f13933i.h();
        goto L24
    L20:
        if (this.f13933i.e(r0.f13918e, r0.f13915b) < LocationRequestCompat.PASSIVE_INTERVAL) goto L24;
        this.f13933i.h();     // Catch: SQLiteFullException -> L23
        goto L24
    }

    private boolean f() {
        boolean r2 = false;
        if (d() == false) goto L6;
        return false;
    L6:
        if (this.f13934j >= 0) goto L11;
        if ((System.currentTimeMillis() - this.f13935k) <= 600000) goto L11;
        this.f13934j = 0;
        c();
        this.f13935k = System.currentTimeMillis();
    L11:
        if (c.b(this.f13930f) == true) goto L14;
        this.f13936l = 120000;
        return false;
    L14:
        b r7 = this.f13933i.d(this.f13934j);
        a.b r0 = null;
        if (r7 == null) goto L17;
        long r8 = this.f13934j;
        long r10 = r7.f13914a;
        if (r8 >= r10) goto L30;
        this.f13934j = r10;
    L31:
        byte[] r9 = r7.f13915b;
        if (r9 != null) goto L34;
    L90:
        a r11 = null;
        boolean r3 = false;
        r2 = true;
    L92:
        if (d() == false) goto L94;
        return true;
    L94:
        if (r2 == false) goto L97;
        this.f13933i.g(r7.f13914a, true, 0, 0);
    L104:
        return true;
    L97:
        if (this.f13933i.g(r7.f13914a, r3, r0.e(), r0.d()) == false) goto L102;
        long r4 = r0.f() * ((long) (r7.f13916c + 1));
        if (r4 <= 0) goto L101;
        this.f13936l = r4;
    L101:
        this.f13936l = Math.min(120000, this.f13936l);
    L103:
        r11.g(r7.f13915b, r3);
        goto L104
    L102:
        this.f13936l = 120000;
        goto L103
    L34:
        if (r9.length <= 0) goto L90;
        r11 = this.m.d(r7.f13918e);
        if (r11 != null) goto L39;
        return true;
    L39:
        a.b r12 = r11.c();
        a.c r1 = r11.f();
        long r13 = System.currentTimeMillis();
        long r14 = r12.f();
        if (r1 == null) goto L52;
        if (r1.a() == false) goto L45;
        r3 = true;
    L44:
        r0 = r12;
        goto L92
    L45:
        long r15 = r1.b();
        if (r15 > 0) goto L48;
    L50:
        r11.i(System.currentTimeMillis());
        goto L52
    L48:
        if ((r13 - r11.d()) >= r15) goto L50;
        return true;
    L52:
        if (r14 <= 0) goto L58;
        int r5 = r7.f13916c;
        if (r5 <= 0) goto L58;
        if ((r13 - r7.f13917d) >= (r14 * ((long) r5))) goto L58;
        return true;
    L58:
        String r6 = r11.e();
        List<String> r16 = r12.c();
        if (r16 != null) goto L107;
        return true;
    L107:
        String r17 = r12.b();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r17) == true) goto L65;
        boolean r18 = g(r11, r17, r7.f13915b);     // Catch: Throwable -> L87
    L86:
        r3 = r18;
        goto L44
    L65:
        if (TextUtils.isEmpty(r6) == true) goto L75;
        r3 = g(r11, r6, r7.f13915b);     // Catch: Throwable -> L87
        if (r3 == true) goto L73;
        String r19 = "";
    L105:
        r11.j(r19);     // Catch: Throwable -> L71
    L71:
        th = th;
    L89:
        d.g("LogSender", "send log exception: " + th);
    L73:
        r18 = r3;
        goto L86
    L75:
        if (r1.c() == false) goto L77;
        this.o++;     // Catch: Throwable -> L87
    L77:
        int r20 = r16.size();     // Catch: Throwable -> L87
        int r21 = this.o;     // Catch: Throwable -> L87
        if (r20 <= r21) goto L82;
        if (r21 < 0) goto L82;
        String r22 = r16.get(r21);     // Catch: Throwable -> L87
    L81:
        r19 = r22;     // Catch: Throwable -> L87
        r3 = g(r11, r19, r7.f13915b);     // Catch: Throwable -> L87
        if (r3 == false) goto L73;
    L82:
        this.o = 0;     // Catch: Throwable -> L87
        r22 = r16.get(0);     // Catch: Throwable -> L87
    L87:
        th = th;
        r3 = false;
        goto L89
    L30:
        this.f13934j = r8 + 1;
        goto L31
    L17:
        if (this.f13934j != 0) goto L23;
        if (this.f13933i.b(null) != 0) goto L23;
        this.f13936l = 0;
        return false;
    L23:
        if (this.f13934j != (-1)) goto L25;
        this.f13936l = 120000;
    L25:
        this.f13934j = -1;
        return false;
    }

    private boolean g(a r1, String r2, byte[] r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.length <= 0) goto L13;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        return r1.h(r2, r3);
    L13:
        return false;
    }

    void b() {
        Object r0 = this.f13931g;
        monitor-enter(r0);
        this.f13931g.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        d.g("LogSender", "LogSender start");
    L4:
        if (d() == true) goto L32;
        boolean r0 = e();
        if (d() == true) goto L32;
        if (f() == true) goto L13;
        if (r0 == true) goto L13;
        boolean r1 = false;
    L15:
        if (d() == true) goto L32;
        if (r1 == true) goto L4;
        Object r2 = this.f13931g;
        monitor-enter(r2);
        long r3 = this.f13936l;     // Catch: Throwable -> L26 InterruptedException -> L34
        if (r3 != 0) goto L24;
        this.f13931g.wait();     // Catch: Throwable -> L26 InterruptedException -> L34
        goto L28
    L24:
        this.f13931g.wait(r3);     // Catch: Throwable -> L26 InterruptedException -> L34
        goto L28
    L26:
        th = move-exception;
        throw th;
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L26
    L13:
        r1 = true;
    L32:
        d.g("LogSender", "LogSender quit");
    }
}
