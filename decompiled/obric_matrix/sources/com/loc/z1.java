package com.loc;

import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a3 f8017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a3 f8018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h3 f8019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f8020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<a3> f8021e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f8022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a3 f8024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a3 f8025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a3 f8026e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<a3> f8027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<a3> f8028g;

        public a() {
            this.f8027f = new ArrayList();
            this.f8028g = new ArrayList();
        }

        public static boolean c(a3 r4, a3 r5) {
            if (r4 == null) goto L48;
            if (r5 == null) goto L48;
            if ((r4 instanceof d3) == false) goto L17;
            if ((r5 instanceof d3) == false) goto L17;
            d3 r6 = (d3) r4;
            d3 r7 = (d3) r5;
            if (r6.o == r7.o) goto L13;
        L15:
            return false;
        L13:
            if (r6.p != r7.p) goto L15;
            return true;
        L17:
            if ((r4 instanceof c3) == false) goto L29;
            if ((r5 instanceof c3) == false) goto L29;
            c3 r8 = (c3) r4;
            c3 r9 = (c3) r5;
            if (r8.q == r9.q) goto L23;
        L27:
            return false;
        L23:
            if (r8.p != r9.p) goto L27;
            if (r8.o != r9.o) goto L27;
            return true;
        L29:
            if ((r4 instanceof e3) == false) goto L39;
            if ((r5 instanceof e3) == false) goto L39;
            e3 r10 = (e3) r4;
            e3 r11 = (e3) r5;
            if (r10.o == r11.o) goto L35;
        L37:
            return false;
        L35:
            if (r10.p != r11.p) goto L37;
            return true;
        L39:
            if ((r4 instanceof f3) == true) goto L41;
        L47:
            return false;
        L41:
            if ((r5 instanceof f3) == false) goto L47;
            f3 r12 = (f3) r4;
            f3 r13 = (f3) r5;
            if (r12.o != r13.o) goto L47;
            if (r12.p != r13.p) goto L47;
            return true;
        L48:
            if (r4 != null) goto L50;
            boolean r14 = true;
        L51:
            if (r5 != null) goto L53;
            boolean r15 = true;
        L54:
            if (r14 != r15) goto L56;
            return true;
        L56:
            return false;
        L53:
            r15 = false;
            goto L54
        L50:
            r14 = false;
            goto L51
        }

        public final void a() {
            this.f8022a = 0;
            this.f8023b = "";
            this.f8024c = null;
            this.f8025d = null;
            this.f8026e = null;
            this.f8027f.clear();
            this.f8028g.clear();
        }

        public final void b(byte r2, String r3, List<a3> r4) {
            a();
            this.f8022a = r2;
            this.f8023b = r3;
            if (r4 == null) goto L16;
            this.f8027f.addAll(r4);
            Iterator<a3> r5 = this.f8027f.iterator();
        L6:
            if (r5.hasNext() == false) goto L16;
            a3 r6 = r5.next();
            boolean r7 = r6.n;
            if (r7 == true) goto L12;
            if (r6.m == false) goto L12;
            this.f8025d = r6;
        L12:
            if (r7 == false) goto L6;
            if (r6.m == false) goto L6;
            this.f8026e = r6;
        L16:
            a3 r8 = this.f8025d;
            if (r8 != null) goto L19;
            r8 = this.f8026e;
        L19:
            this.f8024c = r8;
        }

        public final String toString() {
            return "CellInfo{radio=" + this.f8022a + ", operator='" + this.f8023b + "', mainCell=" + this.f8024c + ", mainOldInterCell=" + this.f8025d + ", mainNewInterCell=" + this.f8026e + ", cells=" + this.f8027f + ", historyMainCellList=" + this.f8028g + '}';
        }
    }

    public z1() {
        this.f8020d = new a();
        this.f8021e = new ArrayList(3);
    }

    private void b(a r5) {
        List<a3> r0 = this.f8021e;
        monitor-enter(r0);
        Iterator<a3> r6 = r5.f8027f.iterator();     // Catch: Throwable -> L15
    L6:
        if (r6.hasNext() == false) goto L12;
        a3 r1 = r6.next();     // Catch: Throwable -> L15
        if (r1 == null) goto L6;
        if (r1.m == false) goto L6;
        a3 r2 = r1.b();     // Catch: Throwable -> L15
        r2.f7143j = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        c(r2);     // Catch: Throwable -> L15
        goto L6
    L12:
        this.f8020d.f8028g.clear();     // Catch: Throwable -> L15
        this.f8020d.f8028g.addAll(this.f8021e);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void c(a3 r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r0 = this.f8021e.size();
        if (r0 != 0) goto L8;
    L6:
        this.f8021e.add(r10);
        return;
    L8:
        long r1 = LocationRequestCompat.PASSIVE_INTERVAL;
        int r3 = 0;
        int r4 = -1;
        int r5 = -1;
    L9:
        if (r3 >= r0) goto L19;
        a3 r6 = this.f8021e.get(r3);
        if (r10.equals(r6) == true) goto L12;
        r1 = Math.min(r1, r6.f7143j);
        if (r1 != r6.f7143j) goto L18;
        r5 = r3;
    L18:
        r3 = r3 + 1;
        goto L9
    L12:
        int r7 = r10.f7141h;
        if (r7 == r6.f7141h) goto L20;
        r6.f7143j = r7;
        r6.f7141h = r7;
    L20:
        if (r4 >= 0) goto L22;
        return;
    L22:
        if (r0 < 3) goto L6;
        if (r10.f7143j <= r1) goto L34;
        if (r4 >= r0) goto L35;
        this.f8021e.remove(r4);
        this.f8021e.add(r10);
        return;
    L35:
        return;
    L34:
        return;
    L19:
        r4 = r5;
        goto L20
    }

    private boolean d(h3 r3) {
        float r0 = r3.f7322f;
        if (r0 <= 10.0f) goto L6;
        float r1 = 2000.0f;
    L10:
        if (r3.a(this.f8019c) <= r1) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r0 <= 2.0f) goto L8;
        r1 = 500.0f;
        goto L10
    L8:
        r1 = 100.0f;
        goto L10
    }

    final a a(h3 r2, boolean r3, byte r4, String r5, List<a3> r6) {
        if (r3 == false) goto L6;
        this.f8020d.a();
        return null;
    L6:
        this.f8020d.b(r4, r5, r6);
        if (this.f8020d.f8024c != null) goto L10;
        return null;
    L10:
        if (this.f8019c != null) goto L12;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == false) goto L23;
        a r8 = this.f8020d;
        this.f8017a = r8.f8025d;
        this.f8018b = r8.f8026e;
        this.f8019c = r2;
        w2.c(r8.f8027f);
        b(this.f8020d);
        return this.f8020d;
    L23:
        return null;
    L12:
        if (d(r2) == true) goto L19;
        if (a.c(this.f8020d.f8025d, this.f8017a) == false) goto L19;
        if (a.c(this.f8020d.f8026e, this.f8018b) == false) goto L19;
        r7 = false;
        goto L20
    }
}
