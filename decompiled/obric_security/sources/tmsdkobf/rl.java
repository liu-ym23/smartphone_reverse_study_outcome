package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.room.RoomDatabase;
import androidx.work.WorkRequest;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class rl implements ol.c, ll.e, hl.f, hl.g, dl.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f487a;
    private z6 b;
    private qg c;
    private tj d;
    private zh.c e;
    private h f;
    private ol g;
    private ll h;
    private hl i;
    private int j;
    private long k;
    private long l;
    private byte m;
    private boolean n;
    private boolean o;
    private boolean p;
    private HandlerThread q;
    private Handler r;
    private Handler s;
    private final Object t;
    private LinkedList u;
    private pl v;

    class a implements Comparator {
        a(rl r1) {
        }

        public int a(j r1, j r2) {
            return sd.b(r2.f493a) - sd.b(r1.f493a);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((j) r1, (j) r2);
        }
    }

    class b extends ri {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rl f488a;

        b(rl r1, Looper r2, String r3) {
            this.f488a = r1;
            super(r2, r3);
        }

        @Override // tmsdkobf.ri
        protected void a(Message r3) {
            if (r3.what != 10) goto L6;
            int r4 = r3.arg1;
            rl.d(this.f488a).b();
            rl.g(this.f488a).a(r4);
            rl.a(this.f488a, System.currentTimeMillis());
            return;
        }
    }

    class c implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rl f489a;

        c(rl r1) {
            this.f489a = r1;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r1, long r2, int r4, JceStruct r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            rl r0 = this.f489a;
            return rl.a(r0, r2, r1, (pc) r5);
        }
    }

    class d implements hi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f490a;
        final /* synthetic */ int b;
        final /* synthetic */ rl c;

        d(rl r1, String r2, int r3) {
            this.c = r1;
            this.f490a = r2;
            this.b = r3;
        }

        @Override // tmsdkobf.hi
        public /* bridge */ /* synthetic */ void a(Object r1) {
            a((Integer) r1);
        }

        public void a(Integer r9) {
            rl.a(this.c, 2, "pull_HIPList:" + this.f490a, this.b, 1, 0, true);
        }
    }

    private class e extends g {
        private int c;
        private String d;
        final /* synthetic */ rl e;

        e(rl r3, int r4, int r5, String r6) {
            this.e = r3;
            super(r3, 10997, 997, r4);
            this.c = r5;
            this.d = r6;
        }

        @Override // tmsdkobf.rl.g
        public void a(ij r10) {
            rl.b(this.e, false);
            rl.a(this.e, (byte) 1);
            rl.c(this.e, false);
            rl.a(this.e).f444a.k().a("TcpNetworkManager", 997, this.b, 62, 0);
            rl.a(this.e).f444a.k().a(this.b);
            rl.a(this.e, 4, null, 0, 0, true);
            rl.a(rl.h(this.e), rl.a(this.e).f444a.f460a.c, rl.a(this.e).f444a.f460a.d, 0);
        }

        @Override // tmsdkobf.rl.g
        public void a(int r18, int r19) {
            int r8 = j4.d(r18);
            if (this.c < 1) goto L5;
        L11:
            boolean r10 = false;
        L12:
            rl.b(this.e, true);
            rl.a(this.e, (byte) 0);
            rl.c(this.e, true);
            rl.a(this.e).f444a.k().a("TcpNetworkManager", 997, this.b, 62, r8);
            rl.a(this.e).f444a.k().a(this.b, !r10);
            rl.a(this.e, 5, null, r8, 0, true);
            if (r10 == false) goto L15;
            rl.f(this.e);
            rl r11 = this.e;
            String r12 = "delay_fp_retry:" + this.d + ":" + r8;
            int r13 = this.c + 1;
            this.c = r13;
            rl.a(r11, 2, r12, r13, ((long) rl.g(this.e).g().h) * 1000, true);
        L15:
            if (r8 != 0) goto L18;
            r8 = r19;
        L18:
            rl.a(rl.h(this.e), rl.a(this.e).f444a.f460a.c, rl.a(this.e).f444a.f460a.d, r8);
            return;
        L5:
            if (j4.e(r8) == false) goto L11;
            if (rl.e(this.e) >= 5) goto L11;
            if (rl.g(this.e).h() <= 0) goto L11;
            r10 = true;
            goto L12
        }
    }

    private class f extends g {
        private int c;
        private String d;
        private byte e;
        final /* synthetic */ rl f;

        f(rl r3, int r4, int r5, String r6, byte r7) {
            this.f = r3;
            super(r3, 10999, RoomDatabase.MAX_BIND_PARAMETER_CNT, r4);
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        @Override // tmsdkobf.rl.g
        public void a(ij r8) {
            rl.a(this.f).f444a.k().a("TcpNetworkManager", RoomDatabase.MAX_BIND_PARAMETER_CNT, this.b, 62, 0, "5/1");
            rl.a(this.f).f444a.k().a(this.b);
            rl.a(this.f).f444a.k().a(this.e);
        }

        @Override // tmsdkobf.rl.g
        public void a(int r11, int r12) {
            boolean r0 = false;
            if (this.c < 1) goto L6;
            rl.b(this.f, true);
            rl.a(this.f, (byte) 0);
        L6:
            if (this.c < 1) goto L8;
        L14:
            rl.a(this.f).f444a.k().a("TcpNetworkManager", RoomDatabase.MAX_BIND_PARAMETER_CNT, this.b, 62, r11);
            rl.a(this.f).f444a.k().a(this.b, !r0);
            rl.a(this.f).f444a.k().a(this.e);
            if (r0 == false) goto L18;
            rl r3 = this.f;
            String r5 = "hb_retry:" + this.d + ":" + r11;
            int r6 = this.c + 1;
            this.c = r6;
            rl.a(r3, 8, r5, r6, 2000, true);
            return;
        L18:
            return;
        L8:
            if (j4.e(r11) == false) goto L14;
            if (rl.e(this.f) >= 5) goto L14;
            if (rl.g(this.f).h() <= 0) goto L14;
            r0 = true;
            goto L14
        }
    }

    private abstract class g implements qg.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f491a;
        protected int b;

        g(rl r1, int r2, int r3, int r4) {
            this.f491a = r3;
            this.b = r4;
        }

        protected abstract void a(int r1, int r2);

        protected abstract void a(ij r1);

        @Override // tmsdkobf.qg.j
        public void a(boolean r2, int r3, int r4, ArrayList r5) {
            if (r3 == 0) goto L7;
            a(r3, -1);
            return;
        L7:
            if (this.f491a != 999) goto L12;
            if (r3 != 0) goto L12;
            a(null);
            return;
        L12:
            if (r5 != null) goto L14;
        L31:
            a(-41002600, -1);
            return;
        L14:
            if (r5.size() == 0) goto L31;
            Iterator r6 = r5.iterator();
        L18:
            if (r6.hasNext() == false) goto L29;
            ij r7 = (ij) r6.next();
            if (r7 == null) goto L18;
            int r8 = r7.d;
            if (r8 == 0) goto L24;
        L27:
            a(r8, r7.e);
            return;
        L24:
            if (r7.e != 0) goto L27;
            a(r7);
            return;
        L29:
            a(-41002600, -1);
        }
    }

    public interface h {
        void a(qg.n r1, int r2);
    }

    private class i extends ri {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rl f492a;

        i(rl r1, Looper r2) {
            this.f492a = r1;
            super(r2, "Tcp-SendHandler");
        }

        @Override // tmsdkobf.ri
        public void a(Message r3) {
            switch(r3.what) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L5;
                default: goto L19;
            };
        L5:
            rl.b(this.f492a, r3);
            return;
        L6:
            rl.a(this.f492a, (String) r3.obj);
            return;
        L7:
            rl.c(this.f492a);
            return;
        L8:
            rl.c(this.f492a, r3);
            return;
        L9:
            rl.b(this.f492a);
            return;
        L10:
            rl.a(this.f492a, false);
            rl.a(this.f492a, r3);
            return;
        L11:
            rl.i(this.f492a);
            return;
        }
    }

    private class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f493a;
        public vd b;
        public qg.n c;

        public j(rl r1, int r2, vd r3, qg.n r4) {
            this.f493a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public rl(z6 r4, tj r5, zh.c r6, h r7, qg r8) {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.t = new Object();
        this.u = new LinkedList();
        this.v = new pl(new a(this));
        Context r1 = rd.e();
        this.f487a = r1;
        this.b = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.c = r8;
        this.g = new ol(r1, this, r5, r8);
        this.i = new hl(this.f487a, this, this);
        this.h = new ll(r4, this);
        HandlerThread r9 = uk.a("TCP-SendHandlerThread", 0);
        this.q = r9;
        r9.start();
        this.r = new i(this, this.q.getLooper());
        this.s = new b(this, this.c.f444a.h(), "extendConnectAndResetHeartBeat");
        o();
        dl.b().a(this);
    }

    static /* synthetic */ qg a(rl r0) {
        return r0.c;
    }

    static /* synthetic */ boolean b(rl r0, boolean r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ void c(rl r0, Message r1) {
        r0.a(r1);
    }

    static /* synthetic */ hl d(rl r0) {
        return r0.i;
    }

    static /* synthetic */ int e(rl r0) {
        return r0.j;
    }

    static /* synthetic */ int f(rl r2) {
        int r0 = r2.j;
        r2.j = r0 + 1;
        return r0;
    }

    static /* synthetic */ ll g(rl r0) {
        return r0.h;
    }

    static /* synthetic */ Context h(rl r0) {
        return r0.f487a;
    }

    static /* synthetic */ void i(rl r0) {
        r0.k();
    }

    private void j() {
        this.b.s();
        Object r0 = this.t;
        monitor-enter(r0);
        LinkedList r1 = this.u;     // Catch: Throwable -> L29
        if (r1 != null) goto L7;
    L9:
        LinkedList r2 = null;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L29
        if (r2 != null) goto L13;
    L27:
        this.i.a("restart_heartbeat");
        this.i.c();
        this.d.a("tcp_fp_succ");
        return;
    L13:
        if (r2.size() <= 0) goto L27;
        Object r3 = this.t;
        monitor-enter(r3);
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L24
    L18:
        if (r4.hasNext() == false) goto L22;
        j r5 = (j) r4.next();     // Catch: Throwable -> L24
        if (r5 == null) goto L18;
        this.v.a(r5);     // Catch: Throwable -> L24
        goto L18
    L22:
        monitor-exit(r3);     // Catch: Throwable -> L24
        a(1, null, 0, 0, true);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (r1.size() <= 0) goto L9;
        r2 = (LinkedList) this.u.clone();     // Catch: Throwable -> L29
        this.u.clear();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    private void k() {
        Object r0 = this.t;
        monitor-enter(r0);
        j r1 = (j) this.v.d();     // Catch: Throwable -> L80
        monitor-exit(r0);     // Catch: Throwable -> L80
        if (r1 == null) goto L79;
        qg.n r2 = r1.c;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.c() == false) goto L14;
        int r3 = -17;
    L44:
        if (r3 == 0) goto L69;
        if (r3 == (-11)) goto L69;
        if (r3 != (-27)) goto L51;
        int r4 = r3 - 40000000;
        this.c.a(r1.c, 42, r4, 0);
        a(r1, r4);
        return;
    L51:
        int r5 = r3 - 40000000;
        this.c.a(r1.c, 41, r5, 0);
        a(r1, r5);
        LinkedList r6 = new LinkedList();
        Object r7 = this.t;
        monitor-enter(r7);
    L83:
        j r8 = (j) this.v.d();     // Catch: Throwable -> L66
        if (r8 == null) goto L56;
        r6.add(r8);     // Catch: Throwable -> L66
        goto L83
    L56:
        monitor-exit(r7);     // Catch: Throwable -> L66
        if (r6.size() <= 0) goto L93;
        Iterator r9 = r6.iterator();
    L61:
        if (r9.hasNext() == false) goto L94;
        j r10 = (j) r9.next();
        vd r11 = r10.b;
        if (r11 == null) goto L65;
        r11.a(2);
    L65:
        a(r10, r5);
        goto L61
    L94:
        return;
    L93:
        return;
    L66:
        th = move-exception;
        throw th;
    L69:
        this.c.a(r1.c, 41, r3, 0);
        Object r12 = this.t;
        monitor-enter(r12);
    L76:
        th = move-exception;
        throw th;
    L72:
        if (this.v.b() == true) goto L74;
        a(1, null, 0, 0, true);     // Catch: Throwable -> L76
    L74:
        monitor-exit(r12);     // Catch: Throwable -> L76
        return;
    L14:
        if (r1.c.a() == false) goto L16;
    L21:
        r3 = a(r1);
    L22:
        if (r3 != 0) goto L44;
        a(r1.c, 35);
        qg r13 = this.c;
        byte[] r14 = r13.a(r1.c, true, r13.b(), this.b);
        if (r14 != null) goto L27;
        r3 = -21;
        goto L44
    L27:
        int r15 = this.c.f444a.f460a.q;
        if (r15 > 0) goto L30;
    L32:
        vd r16 = r1.b;
        if (r16 != null) goto L36;
        r3 = this.g.a(r1.c, r14);
    L39:
        if (r3 != 0) goto L44;
        qg.n r17 = r1.c;
        if (r17 == null) goto L44;
        r17.n = true;
        goto L44
    L36:
        if (r16.a() == false) goto L38;
        r3 = -11;
        goto L44
    L38:
        r16.a(1);
        r3 = this.g.a(r1.c, r14);
        r16.a(2);
        goto L39
    L30:
        if (r14.length < r15) goto L32;
        r3 = -27;
        goto L44
    L16:
        if (r1.c.f == true) goto L21;
        if (b(r1) == false) goto L20;
        return;
    L20:
        r3 = 0;
        goto L22
    L79:
        return;
    L80:
        th = move-exception;
        throw th;
    }

    private void l() {
        if (this.h.h() <= 0) goto L5;
        return;
    L5:
        Object r0 = this.t;
        monitor-enter(r0);
        this.v.a();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.m = 0;
        this.j = 0;
        this.h.k();
        this.i.a("close_connection");
        this.g.a(false, false);
        this.b.r();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void o() {
        c r6 = new c(this);
        this.c.f444a.a(0, 11101, new pc(), 0, r6);
    }

    public boolean m() {
        byte r0 = this.m;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L14;
        long r6 = Math.abs(System.currentTimeMillis() - this.k);
        if (this.k > 0) goto L10;
    L12:
        return false;
    L10:
        if (r6 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L12;
        return true;
    L14:
        if (this.k > 0) goto L17;
        return true;
    L17:
        if (Math.abs(System.currentTimeMillis() - this.k) <= 300000) goto L20;
        return true;
    L20:
        if (this.n == false) goto L22;
        return false;
    L22:
        return true;
    }

    public void n() {
        if (this.m != 0) goto L6;
        b("http_channel_succ");
        return;
    }

    public void p() {
        this.h.l();
    }

    public void q() {
        this.h.m();
    }

    static /* synthetic */ boolean a(rl r0, boolean r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ void b(rl r0, Message r1) {
        r0.b(r1);
    }

    static /* synthetic */ void c(rl r0) {
        r0.l();
    }

    @Override // tmsdkobf.ll.e
    public void d() {
        a(6, null, 0, 0, true);
    }

    @Override // tmsdkobf.ll.e
    public void e() {
        a(2, "strategy_connect", 0, 0, true);
    }

    @Override // tmsdkobf.dl.f
    public void f() {
        b("network_connected");
    }

    @Override // tmsdkobf.hl.g
    public int g() {
        return this.h.g().b;
    }

    @Override // tmsdkobf.dl.f
    public void h() {
        this.h.h();
        this.o = true;
        this.m = 0;
        this.r.removeMessages(7);
    }

    public void i() {
        this.h.a(1000);
    }

    static /* synthetic */ void a(rl r0, Message r1) {
        r0.c(r1);
    }

    @Override // tmsdkobf.hl.f
    public void b() {
        if (this.m != 1) goto L6;
        a(8, "onHeartBeat", 0, 0, true);
        return;
    }

    @Override // tmsdkobf.ll.e
    public void c() {
        a(2, "ensure_connect", 0, 500, true);
    }

    static /* synthetic */ long a(rl r0, long r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ boolean c(rl r0, boolean r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ Cif a(rl r0, long r1, int r3, pc r4) {
        return r0.a(r1, r3, r4);
    }

    static /* synthetic */ void b(rl r0) {
        r0.j();
    }

    private void c(Message r11) {
        int r3 = r11.arg1;
        String r0 = "" + r11.obj;
        if (r11.arg2 != 1) goto L5;
        boolean r12 = true;
    L6:
        byte r2 = this.m;
        if (r2 != 1) goto L9;
        return;
    L9:
        if (r2 == 2) goto L27;
        if (r12 == false) goto L13;
    L16:
        long r4 = System.currentTimeMillis();
        if (Math.abs(r4 - this.k) >= this.c.f444a.f460a.v) goto L20;
        a(2, "delay_too_frequently:" + r0, r3, this.c.f444a.f460a.v, true);
        return;
    L20:
        long r6 = 1000 * ((long) 1);
        if (dl.b().a(r6) == false) goto L24;
        a(2, "delay_waitfor_stable:" + r0, r3, r6, true);
        return;
    L24:
        a(r0, r3, r4);
        return;
    L13:
        if (this.d.f() == false) goto L16;
        this.d.a(this.c.f444a.f460a.j.c(), new d(this, r0, r3), 60000);
        return;
    L27:
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // tmsdkobf.ol.c
    public void a(int r8, Object r9) {
        switch(r8) {
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            default: goto L18;
        };
    L4:
        this.o = true;
        this.m = 0;
        this.i.a("connect_broken");
        if (this.h.h() > 0) goto L7;
        return;
    L7:
        if (this.p == false) goto L10;
        return;
    L10:
        if (this.c.f444a.f460a.D == true) goto L12;
        return;
    L12:
        int r0 = this.j;
        if (r0 >= 5) goto L17;
        this.j = r0 + 1;
        a(2, "delay_fp_for_connect_broken" + r8, 0, ((long) this.h.g().h) * 1000, true);
        return;
    L17:
        return;
    }

    @Override // tmsdkobf.ol.c
    public void b(int r1, Object r2) {
        switch(r1) {
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            default: goto L6;
        };
    L4:
        this.o = true;
        this.m = 0;
        return;
    }

    public void b(qg.n r10) {
        if (bl.f() == true) goto L6;
        this.e.a(true, -40220000, r10);
        return;
    L6:
        j r0 = new j(this, 0, null, r10);
        byte r2 = this.m;
        if (r2 != 1) goto L10;
        a(r10);
        return;
    L10:
        if (r2 == 2) goto L12;
        if (r2 == 0) goto L25;
        return;
    L25:
        if (r10.g == false) goto L28;
        a(r10, 36);
        return;
    L28:
        a(r10, 32);
        Object r11 = this.t;
        monitor-enter(r11);
        this.u.add(r0);     // Catch: Throwable -> L33
        monitor-exit(r11);     // Catch: Throwable -> L33
        a(2, "send_fp_for_others", 0, 0, true);
        return;
    L33:
        th = move-exception;
        throw th;
    L12:
        if (r10.g == false) goto L15;
        a(r10, 36);
        return;
    L15:
        a(r10, 31);
        Object r1 = this.t;
        monitor-enter(r1);
        this.u.add(r0);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(rl r0, int r1, Object r2, int r3, int r4, long r5, boolean r7) {
        r0.a(r1, r2, r3, r4, r5, r7);
    }

    static /* synthetic */ byte a(rl r0, byte r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ void a(rl r0, int r1, Object r2, int r3, long r4, boolean r6) {
        r0.a(r1, r2, r3, r4, r6);
    }

    static /* synthetic */ void a(rl r0, String r1) {
        r0.a(r1);
    }

    @Override // tmsdkobf.ll.e, tmsdkobf.hl.g
    public ql a() {
        return this.c.f444a;
    }

    @Override // tmsdkobf.ol.c
    public void a(byte[] r4) {
        this.j = 0;
        this.e.a(true, 0, r4, null);
    }

    public void a(qg.n r10) {
        if (bl.f() == true) goto L6;
        this.e.a(true, -40220000, r10);
        return;
    L6:
        this.r.removeMessages(6);
        a(r10, 30);
        if (r10.g == true) goto L9;
        a(r10.i);
    L9:
        j r0 = new j(this, 0, null, r10);
        Object r11 = this.t;
        monitor-enter(r11);
        this.v.a(r0);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        a(1, null, 0, 0, true);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void b(String r9) {
        this.n = false;
        if (this.h.h() > 0) goto L6;
        return;
    L6:
        if (this.c.f444a.f460a.D == true) goto L8;
        return;
    L8:
        a(7, r9, 0, 100, true);
    }

    private Cif a(long r1, int r3, pc r4) {
        this.h.b(r4);
        lh r0 = new lh();
        r0.f332a = r4.f417a;
        r0.b = r4.j;
        return new Cif(Long.valueOf(r1), 1101, r0);
    }

    private final void a(int r9, Object r10, int r11, long r12, boolean r14) {
        a(r9, r10, r11, 0, r12, r14);
    }

    private void b(Message r25) {
        int r3 = r25.arg1;
        String r12 = "" + r25.obj;
        ArrayList r7 = new ArrayList();
        pi r8 = new pi();
        r8.f422a = RoomDatabase.MAX_BIND_PARAMETER_CNT;
        r8.b = jl.b().a();
        r7.add(r8);
        cj.a("TMSDK_SK_HB", "doHB");
        byte r10 = jl.a().a();
        if (r3 >= 1) goto L5;
        long r0 = 30;
    L6:
        long r1 = 1000 * r0;
        qg.n r11 = new qg.n(1024, false, true, false, 0, r7, new f(this, r8.b, r3, r12, r10), r1);
        r11.o = r10;
        this.c.f444a.k().a(r8.b, RoomDatabase.MAX_BIND_PARAMETER_CNT, r1, r12);
        this.c.f444a.k().a(r10, r11.f451a);
        this.c.a(r11);
        return;
    L5:
        r0 = 60;
        goto L6
    }

    private final synchronized void a(int r1, Object r2, int r3, int r4, long r5, boolean r7) {
        monitor-enter(this);
        if (r7 == false) goto L8;
        this.r.removeMessages(r1);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    L8:
        if (r1 != 2) goto L10;
        this.p = true;     // Catch: Throwable -> L5
    L10:
        Message r6 = Message.obtain(this.r, r1, r3, r4, r2);     // Catch: Throwable -> L5
        this.r.sendMessageDelayed(r6, r5);     // Catch: Throwable -> L5
        monitor-exit(this);
    }

    private void a(long r9) {
        Message r10 = this.s.obtainMessage(10, (int) r9, 0);
        if (this.l > 0) goto L5;
    L7:
        this.s.removeMessages(10);
        this.s.sendMessageDelayed(r10, 5000);
        return;
    L5:
        if ((System.currentTimeMillis() - this.l) <= 5000) goto L7;
        this.s.sendMessage(r10);
    }

    private void a(qg.n r7, int r8) {
        this.c.f444a.k().a("TcpNetworkManager", r8, r7, 0, 0);
    }

    private void a(String r12, int r13, long r14) {
        this.k = r14;
        this.m = 2;
        ArrayList r7 = new ArrayList();
        pi r15 = new pi();
        r15.f422a = 997;
        r15.b = jl.b().a();
        r7.add(r15);
        this.c.f444a.k().a(r15.b, 997, -1, r12);
        qg.n r16 = new qg.n(1024, false, false, true, 0, r7, new e(this, r15.b, r13, r12), 0);
        this.c.a(r16);
    }

    private boolean b(j r13) {
        byte r0 = this.m;
        if (r0 != 1) goto L20;
        if (this.g.a() == true) goto L47;
        this.m = 0;
        qg.n r1 = r13.c;
        if (r1.g == false) goto L10;
        a(r1, 36);
        return true;
    L10:
        a(r1, 32);
        Object r2 = this.t;
        monitor-enter(r2);
        this.u.add(r13);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        a(2, "conn_broken_didnt_monitored", 0, 0, true);
        return true;
    L16:
        th = move-exception;
        throw th;
    L47:
        return false;
    L20:
        if (r0 != 2) goto L33;
        qg.n r3 = r13.c;
        if (r3.g == false) goto L25;
        a(r3, 36);
        return true;
    L25:
        a(r3, 31);
        Object r5 = this.t;
        monitor-enter(r5);
        this.u.add(r13);     // Catch: Throwable -> L30
        monitor-exit(r5);     // Catch: Throwable -> L30
        return true;
    L30:
        th = move-exception;
        throw th;
    L33:
        if (r0 != 0) goto L47;
        qg.n r4 = r13.c;
        if (r4.g == false) goto L38;
        a(r4, 36);
        return true;
    L38:
        a(r4, 32);
        Object r6 = this.t;
        monitor-enter(r6);
        this.u.add(r13);     // Catch: Throwable -> L44
        monitor-exit(r6);     // Catch: Throwable -> L44
        a(2, "others_depend_on_fp", 0, 0, true);
        return true;
    L44:
        th = move-exception;
        throw th;
    }

    private void a(Message r14) {
        Object r0 = this.t;
        monitor-enter(r0);
        LinkedList r1 = this.u;     // Catch: Throwable -> L34
        if (r1 != null) goto L7;
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L7:
        if (r1.size() <= 0) goto L32;
        LinkedList r2 = (LinkedList) this.u.clone();     // Catch: Throwable -> L34
        this.u.clear();     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L34
        int r15 = r14.arg1;
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L31;
        j r4 = (j) r3.next();
        if (r4 == null) goto L13;
        qg.n r5 = r4.c;
        if (r5 == null) goto L13;
        ArrayList r6 = r5.k;
        if (r6 == null) goto L13;
        if (r6.size() <= 0) goto L13;
        Iterator r7 = r4.c.k.iterator();
    L25:
        if (r7.hasNext() == false) goto L30;
        pi r9 = (pi) r7.next();
        if (r9 == null) goto L25;
        this.c.f444a.k().a("TcpNetworkManager", r9.f422a, r9.b, r9, 33, r15 - 700000000, null);
        goto L25
    L30:
        a(r4, (-700000000) + r15);
        goto L13
    L31:
        return;
    L34:
        th = move-exception;
        throw th;
    }

    private void a(String r12) {
        if (this.h.h() > 0) goto L5;
        return;
    L5:
        int r0 = this.j;
        if (r0 >= 5) goto L9;
        this.j = r0 + 1;
        a(2, r12, 0, ((long) this.h.g().i) * 1000, true);
        return;
    }

    private int a(j r5) {
        if (this.o == false) goto L11;
        this.o = false;
        int r0 = this.g.a(true);
        if (r5.c.f == true) goto L17;
        if (this.m == 2) goto L17;
        this.m = 0;
    L17:
        return r0;
    L11:
        if (this.g.a() == true) goto L18;
        r0 = this.g.a(false);
        if (r5.c.f == true) goto L17;
        if (this.m == 2) goto L17;
        this.m = 0;
        goto L17
    L18:
        return 0;
    }

    private void a(j r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        h r0 = this.f;
        if (r0 == null) goto L8;
        r0.a(r1.c, r2);
        return;
    }

    static void a(Context r4, String r5, String r6, int r7) {
        Intent r1 = new Intent(String.format("action.fp.e:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L5
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L5
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L5
        r1.putExtra("k.s.i", r6);     // Catch: Throwable -> L5
        r1.putExtra("k.rc", r7);     // Catch: Throwable -> L5
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L5
        return;
    }
}
