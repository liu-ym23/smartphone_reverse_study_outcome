package tmsdkobf;

import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class w2 {
    private static w2 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f589a;
    private SparseArray b;
    private List c;
    private long d;
    private za e;
    private a7 f;

    class a implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w2 f590a;

        a(w2 r1) {
            this.f590a = r1;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r19, long r20, int r22, JceStruct r23) {
            if (r22 != 10010) goto L42;
            if (r23 == null) goto L42;
            ArrayList r1 = ((nc) r23).f371a;
            if (r1 == null) goto L42;
            if (r1.size() == 0) goto L42;
            v0 r4 = new v0();
            r4.f562a = new ArrayList();
            StringBuilder r5 = new StringBuilder();
            boolean r7 = false;
            w2.m2476$$Nest$fputd(this.f590a, ((y2) r1.get(0)).f630a);
            Iterator r2 = r1.iterator();
        L13:
            if (r2.hasNext() == false) goto L38;
            y2 r6 = (y2) r2.next();
            ArrayList r8 = r6.c;
            if (r8 == null) goto L36;
            if (r8.size() == 0) goto L36;
            Iterator r9 = r6.c.iterator();
        L21:
            if (r9.hasNext() == false) goto L13;
            r2 r10 = (r2) r9.next();
            v2.a r15 = new v2.a(r6.f630a, r6.b, r10);
            r15.d = null;
            if (r10.f465a != 1701) goto L27;
            boolean r16 = false;
            l2 r11 = (l2) z7.a(r10.b, new l2(), false);
            if (r11 == null) goto L28;
            r15.d = new v2.c(d3.c(r11.c), d3.c(r11.d));
        L28:
            r5.append(r10.f465a + ";");
            SparseArray r12 = w2.m2473$$Nest$fgetb(this.f590a);
            v2.c r13 = r15.d;
            if (r13 != null) goto L31;
            int r14 = r10.f465a;
        L33:
            if (((v2.b) r12.get(r14)) != null) goto L34;
            r7 = r16;
            goto L21
        L34:
            w2.m2478$$Nest$ma(this.f590a, r15);
            r4.f562a.add(w2.m2477$$Nest$ma(this.f590a, r6.f630a, r6.b, r10, 1));
            r7 = r16;
            goto L21
        L31:
            r14 = r13.f566a;
            goto L33
        L27:
            r16 = false;
        L36:
            r4.f562a.add(w2.m2477$$Nest$ma(this.f590a, r6.f630a, r6.b, null, 3));
            r7 = r7;
            goto L13
        L38:
            if (qe.c(r5.toString()) == false) goto L41;
            f.a(1320064, r5.toString());
        L41:
            return new Cif(Long.valueOf(r20), Integer.valueOf(r22), r4);
        L42:
            return null;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v2.a f591a;
        final /* synthetic */ w2 b;

        b(w2 r1, v2.a r2) {
            this.b = r1;
            this.f591a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            v2.a r0 = this.f591a;
            int r1 = r0.c.f465a;
            SparseArray r3 = w2.m2473$$Nest$fgetb(this.b);
            v2.c r2 = r0.d;
            if (r2 == null) goto L6;
            r1 = r2.f566a;
        L6:
            v2.b r4 = (v2.b) r3.get(r1);
            if (r4 == null) goto L13;
            r4.a(r0);     // Catch: Throwable -> L10
            return;
        L14:
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w2 f592a;

        class a implements w6 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f593a;

            a(c r1) {
                this.f593a = r1;
            }

            @Override // tmsdkobf.w6
            public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            }
        }

        c(w2 r1) {
            this.f592a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] r0 = w2.m2472$$Nest$fgeta(this.f592a);
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (w2.m2474$$Nest$fgetc(this.f592a).size() <= 0) goto L7;
            w0 r1 = new w0();     // Catch: Throwable -> L15
            r1.f588a = new ArrayList(w2.m2474$$Nest$fgetc(this.f592a));     // Catch: Throwable -> L15
            w2.m2474$$Nest$fgetc(this.f592a).clear();     // Catch: Throwable -> L15
        L8:
            w0 r4 = r1;
            monitor-exit(r0);     // Catch: Throwable -> L15
            if (r4 != null) goto L12;
            return;
        L12:
            if (r4.f588a == null) goto L21;
            w2.m2475$$Nest$fgete(this.f592a).a(21, r4, new hc(), 2, new a(this));
            return;
        L21:
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m2472$$Nest$fgeta(w2 r0) {
        return r0.f589a;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m2473$$Nest$fgetb(w2 r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2474$$Nest$fgetc(w2 r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgete, reason: not valid java name */
    static /* bridge */ /* synthetic */ za m2475$$Nest$fgete(w2 r0) {
        return r0.e;
    }

    /* JADX INFO: renamed from: -$$Nest$fputd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2476$$Nest$fputd(w2 r0, long r1) {
        r0.d = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ t2 m2477$$Nest$ma(w2 r0, long r1, long r3, r2 r5, int r6) {
        return r0.a(r1, r3, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2478$$Nest$ma(w2 r0, v2.a r1) {
        r0.a(r1);
    }

    private w2() {
        this.f589a = new byte[0];
        this.c = new ArrayList();
        this.d = -1;
        this.f = new a(this);
        this.d = -1;
        this.b = new SparseArray();
        this.e = ve.e();
        c();
    }

    private t2 a(long r1, long r3, r2 r5, int r6) {
        t2 r0 = new t2();
        r0.f522a = r1;
        r0.b = r3;
        if (r5 == null) goto L5;
        r0.d = r5.f465a;
        r0.c = r5.c;
    L5:
        r0.e = r6;
        return r0;
    }

    public static w2 b() {
        if (g != null) goto L15;
        monitor-enter(w2.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new w2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(w2.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public void c() {
        this.e.a(10010, new nc(), 2, this.f);
    }

    private synchronized void a(v2.a r3) {
        monitor-enter(this);
        ve.f().a(new b(this, r3), "conchP");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void a() {
        monitor-enter(this);
        ve.f().a(new c(this), "conchRet");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(long r1, int r3, v2.b r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        byte[] r2 = this.f589a;
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.b.get(r3) != null) goto L9;
        this.b.put(r3, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L11
    }

    public void a(long r1, long r3, long r5, int r7, int r8, int r9, int r10) {
        u2 r2 = new u2();
        r2.f546a = r3;
        r2.b = r5;
        r2.e = r7;
        r2.d = r8;
        r2.f = r9;
        if (r9 != 1) goto L5;
        r2.c = r10;
    L9:
        byte[] r4 = this.f589a;
        monitor-enter(r4);
        this.c.add(r2);     // Catch: Throwable -> L15
        monitor-exit(r4);     // Catch: Throwable -> L15
        a();
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r9 == 2) goto L7;
        r2.g = r10;
        goto L9
    L7:
        r2.h = r10;
        goto L9
    }
}
