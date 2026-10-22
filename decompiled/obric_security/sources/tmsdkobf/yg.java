package tmsdkobf;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class yg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z6 f642a;
    private ql b;
    private int c;
    private Handler d;
    private ExecutorService e;
    private mj f;
    private final Object g;
    private ArrayList h;
    private Map i;
    private Map j;

    class a extends ti {
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ yg e;

        a(yg r1, String r2, int r3, int r4, long r5) {
            this.e = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            Bundle r0 = new Bundle();
            r0.putInt("s.rt", 2);
            r0.putLong("s.ci", this.d);
            r0.putInt("s.cm", this.b);
            r0.putInt("s.f", this.c);
            yg.a(this.e);
            throw null;
        }
    }

    class b extends ti {
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ yg d;

        b(yg r1, String r2, int r3, int r4) {
            this.d = r1;
            this.b = r3;
            this.c = r4;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            Bundle r0 = new Bundle();
            r0.putInt("s.rt", 3);
            r0.putInt("s.cm", this.b);
            r0.putInt("s.f", this.c);
            yg.a(this.d);
            throw null;
        }
    }

    class c extends ti {
        final /* synthetic */ d b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ byte[] g;

        c(yg r1, d r2, int r3, int r4, int r5, int r6, byte[] r7) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        @Override // tmsdkobf.ti
        public void a() {
            d r0 = this.b;
            w6 r1 = r0.j;
            if ((r1 instanceof v6) == false) goto L5;
            ((v6) r1).a(this.c, this.d, this.e, this.f, this.g);
            return;
        L5:
            JceStruct r8 = z7.a(this.g, r0.h, false);
            this.b.j.onFinish(this.c, this.d, this.e, this.f, r8);
        }
    }

    private class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f643a;
        int b;
        long c;
        int d;
        long e;
        JceStruct f;
        byte[] g;
        JceStruct h;
        int i;
        w6 j;
        long k;
        long l;
        long m;
        int n;

        d(yg r4, int r5, int r6, long r7, long r9, int r11, JceStruct r12, byte[] r13, JceStruct r14, int r15, w6 r16, long r17, long r19) {
            this.m = System.currentTimeMillis();
            this.n = 0;
            this.f643a = r5;
            this.b = r6;
            this.c = r7;
            this.d = r11;
            this.e = r9;
            this.f = r12;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r17;
            this.l = r19;
        }

        boolean a() {
            long r0 = Math.abs(System.currentTimeMillis() - this.m);
            long r2 = this.k;
            if (r2 > 0) goto L7;
            r2 = 605000;
        L7:
            if (r0 < r2) goto L9;
            return true;
        L9:
            return false;
        }
    }

    private class e extends ti {
        private List b;
        final /* synthetic */ yg c;

        private e(yg r1) {
            this.c = r1;
            this.b = new ArrayList();
        }

        void a(List r2) {
            Object r0 = yg.d(this.c);
            monitor-enter(r0);
            this.b.addAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        /* synthetic */ e(yg r1, a r2) {
            this(r1);
        }

        @Override // tmsdkobf.ti
        public void a() {
            boolean r0 = bl.f();
            Iterator r1 = this.b.iterator();
        L4:
            if (r1.hasNext() == false) goto L21;
            d r2 = (d) r1.next();
            if (r0 == false) goto L7;
            if (r2.a() == false) goto L11;
            yg.a(this.c, r2.f643a, 0, r2.d, null, -1000017, 0);
            yg.h(this.c).a(r2.d, -1000017);
            goto L4
        L11:
            long r3 = r2.k;
            if (r3 <= 0) goto L14;
            long r4 = r3 + 5000;
        L15:
            Message r5 = Message.obtain(yg.f(this.c), 2, r2);
            yg.f(this.c).sendMessageDelayed(r5, r4);
            byte[] r6 = r2.g;
            if (r6 != null) goto L19;
            r6 = z7.a(r2.f);
        L19:
            Bundle r7 = new Bundle();
            r7.putInt("s.rt", 1);
            r7.putInt("s.pid", yg.c(this.c));
            r7.putInt("s.cm", r2.d);
            r7.putLong("s.ci", r2.e);
            r7.putInt("s.isn", r2.f643a);
            r7.putInt("s.psn", r2.b);
            r7.putLong("s.phid", r2.c);
            r7.putByteArray("s.rqd", r6);
            r7.putInt("s.f", r2.i);
            r7.putLong("s.t", r2.k);
            r7.putLong("s.pht", r2.l);
            r7.putLong("s.bt", r2.m);
            r7.putInt("s.dt", r2.n);
            yg.a(this.c);
            throw null;
        L14:
            r4 = 605000;
            goto L15
        L7:
            yg.a(this.c, r2.f643a, 0, r2.d, null, -1000002, 0);
            goto L4
        }
    }

    private class f extends ri {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ yg f644a;

        public f(yg r1, Looper r2) {
            this.f644a = r1;
            super(r2, "SharkProcessProxy-WorkHandler");
        }

        @Override // tmsdkobf.ri
        public void a(Message r9) {
            int r0 = r9.what;     // Catch: Exception -> L22
            if (r0 != 1) goto L5;
            e r10 = new e(this.f644a, null);     // Catch: Exception -> L22
            Object r1 = yg.d(this.f644a);     // Catch: Exception -> L22
            monitor-enter(r1);     // Catch: Exception -> L22
            r10.a(yg.e(this.f644a));     // Catch: Throwable -> L18
            Iterator r2 = yg.e(this.f644a).iterator();     // Catch: Throwable -> L18
        L12:
            if (r2.hasNext() == false) goto L14;
            d r3 = (d) r2.next();     // Catch: Throwable -> L18
            yg.g(this.f644a).put(Integer.valueOf(r3.f643a), r3);     // Catch: Throwable -> L18
            goto L12
        L14:
            yg.e(this.f644a).clear();     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
            yg.b(this.f644a).submit(r10);     // Catch: Exception -> L22
            return;
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L5:
            if (r0 != 2) goto L21;
            d r11 = (d) r9.obj;     // Catch: Exception -> L22
            int r6 = j4.d(-2050000);     // Catch: Exception -> L22
            yg.a(this.f644a, r11.f643a, 0, r11.d, null, r6, 0);     // Catch: Exception -> L22
            return;
        L21:
            return;
        }
    }

    public yg(z6 r2, ql r3) {
        this.g = new Object();
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new HashMap();
        this.f642a = r2;
        this.b = r3;
        this.c = Process.myPid();
        this.d = new f(this, this.b.h());
        this.e = uk.a("SharkProcessProxy-WorkQueue");
        this.f = new mj();
        this.b.f460a.getClass();
    }

    static /* synthetic */ l6 a(yg r0) {
        r0.getClass();
        return null;
    }

    static /* synthetic */ ExecutorService b(yg r0) {
        return r0.e;
    }

    static /* synthetic */ int c(yg r0) {
        return r0.c;
    }

    static /* synthetic */ Object d(yg r0) {
        return r0.g;
    }

    static /* synthetic */ ArrayList e(yg r0) {
        return r0.h;
    }

    static /* synthetic */ Handler f(yg r0) {
        return r0.d;
    }

    static /* synthetic */ Map g(yg r0) {
        return r0.i;
    }

    static /* synthetic */ z6 h(yg r0) {
        return r0.f642a;
    }

    static /* synthetic */ void a(yg r0, int r1, int r2, int r3, byte[] r4, int r5, int r6) {
        r0.a(r1, r2, r3, r4, r5, r6);
    }

    public void a(long r20, int r22, long r23, int r25, JceStruct r26, byte[] r27, JceStruct r28, int r29, w6 r30, long r31, long r33, int r35) {
        d r3 = new d(this, this.f.a(), r22, r23, r20, r25, r26, r27, r28, r29, r30, r31, r33);
        r3.n = r35;
        Object r2 = this.g;
        monitor-enter(r2);
        this.h.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        this.d.sendEmptyMessage(1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void a(long r9, int r11, JceStruct r12, int r13, a7 r14) {
        Object r0 = this.g;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.j.containsKey(Integer.valueOf(r11)) == true) goto L7;
        this.j.put(Integer.valueOf(r11), new Pair(r12, r14));     // Catch: Throwable -> L9
        this.e.submit(new a(this, "shark-regpush-fp", r11, r13, r9));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public a7 a(int r5, int r6) {
        Object r0 = this.g;
        monitor-enter(r0);
        Pair r1 = (Pair) this.j.remove(Integer.valueOf(r5));     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        a7 r2 = (a7) r1.second;     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r2 == null) goto L11;
        this.e.submit(new b(this, "shark-unregpush-fp", r5, r6));
    L11:
        return r2;
    L7:
        r2 = null;
    L12:
        th = move-exception;
        throw th;
    }

    private void a(int r10, int r11, int r12, byte[] r13, int r14, int r15) {
        Object r0 = this.g;
        monitor-enter(r0);
        d r16 = (d) this.i.remove(Integer.valueOf(r10));     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (r16 != null) goto L8;
        return;
    L8:
        if (r16.j == null) goto L30;
        this.d.removeMessages(2, r16);
        c r1 = new c(this, r16, r11, r12, r14, r15, r13);
        int r17 = sd.a(r16.i);
        if (r17 != 8) goto L13;
        uk.a(r1);
        return;
    L13:
        if (r17 != 16) goto L15;
        this.b.b(r1, "shark-callback-fp");
        return;
    L15:
        if (sd.b(r16.i) < 96) goto L17;
        uk.b(r1, "shark-callback-fp");
        return;
    L17:
        uk.a(r1, "shark-callback-fp");
        return;
    L30:
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
