package tmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class ra {
    private static Object d;
    private static ra e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray f473a;
    HandlerThread b;
    Handler c;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ra f474a;

        /* JADX INFO: renamed from: tmsdkobf.ra$a$a, reason: collision with other inner class name */
        class C0105a implements wa {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ q6 f475a;
            final /* synthetic */ a b;

            C0105a(a r1, q6 r2) {
                this.b = r1;
                this.f475a = r2;
            }

            @Override // tmsdkobf.wa
            public void a(int r2, ArrayList r3, int r4, int r5) {
                if (r4 != 0) goto L7;
                this.f475a.a(this.b.f474a.a(r2, r3));
                if (r2 != 0) goto L8;
                this.f475a.a(r5);
                return;
            L8:
                return;
            }
        }

        a(ra r1, Looper r2) {
            this.f474a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            q8.d("demo", "handler 000 : " + System.currentTimeMillis() + "  msg.what = " + r5.what);
            int r0 = r5.what;
            if (r0 != 1) goto L5;
            ua.a(r5.obj);
            throw null;
        L5:
            if (r0 != 2) goto L7;
            Object r6 = r5.obj;
            if (r6 != null) goto L22;
            return;
        L22:
            if ((r6 instanceof q6) == false) goto L30;
            q6 r7 = (q6) r6;
            ra.m2437$$Nest$fgeta(this.f474a).remove(r7.a());
            ra.m2437$$Nest$fgeta(this.f474a).append(r7.a(), r7);
            r7.a(new C0105a(this, r7));
        L25:
            q8.d("demo", "handler 001 : " + System.currentTimeMillis());
            return;
        L30:
            return;
        L7:
            if (r0 != 3) goto L9;
            Integer r8 = (Integer) r5.obj;
            if (r8 != null) goto L15;
            return;
        L15:
            q6 r4 = (q6) ra.m2437$$Nest$fgeta(this.f474a).get(r8.intValue());
            if (r4 != null) goto L18;
            return;
        L18:
            r4.b();
            goto L25
        L9:
            if (r0 != 4) goto L25;
            ra.m2438$$Nest$ma(this.f474a, (q6) ra.m2437$$Nest$fgeta(this.f474a).get(((Integer) r5.obj).intValue()));
            goto L25
        }
    }

    class b implements q6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q6 f476a;
        final /* synthetic */ ra b;

        b(ra r1, q6 r2) {
            this.b = r1;
            this.f476a = r2;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m2437$$Nest$fgeta(ra r0) {
        return r0.f473a;
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2438$$Nest$ma(ra r0, q6 r1) {
        r0.a(r1);
    }

    static {
        d = new Object();
    }

    private ra() {
        this.f473a = new SparseArray();
        this.b = null;
        this.c = null;
        HandlerThread r0 = ((bf) qd.a(4)).b("ProfileServiceManager");
        this.b = r0;
        r0.start();
        this.c = new a(this, this.b.getLooper());
    }

    public void a(int r2) {
        Message.obtain(this.c, 4, Integer.valueOf(r2)).sendToTarget();
    }

    public void b(q6 r2) {
        if (r2 == null) goto L8;
        Handler r1 = this.c;
        if (r1 == null) goto L9;
        Message.obtain(r1, 2, r2).sendToTarget();
        return;
    L9:
        return;
    }

    private void a(q6 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.a(new b(this, r2));
    }

    public static ra a() {
        if (e != null) goto L15;
        Object r0 = d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new ra();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    protected ArrayList a(int r3, ArrayList r4) {
        ArrayList r2 = new ArrayList();
        if (r4 != null) goto L5;
    L14:
        return r2;
    L5:
        if (r4.size() == 0) goto L14;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        JceStruct r0 = (JceStruct) r5.next();
        if (r0 == null) goto L9;
        q6.a r1 = new q6.a();
        r1.f434a = r0;
        r1.b = r3;
        r2.add(r1);
        goto L9
    }
}
