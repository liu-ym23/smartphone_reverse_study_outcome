package d.c.i.p;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class m implements k0<d.c.c.h.a<d.c.i.l.c>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.c.g.a f16329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f16330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.i.i.c f16331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.i.i.f f16332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f16334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f16335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f16337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f16338j;

    private class a extends c {
        public a(m r1, k<d.c.c.h.a<d.c.i.l.c>> r2, l0 r3, boolean r4, int r5) {
            super(r1, r2, r3, r4, r5);
        }

        @Override // d.c.i.p.m.c
        protected int A(d.c.i.l.e r1) {
            return r1.X();
        }

        @Override // d.c.i.p.m.c
        protected d.c.i.l.i B() {
            return d.c.i.l.g.d(0, false, false);
        }

        @Override // d.c.i.p.m.c
        protected synchronized boolean O(d.c.i.l.e r2, int r3) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (d.c.i.p.b.f(r3) == true) goto L6;
            boolean r4 = super.O(r2, r3);     // Catch: Throwable -> L11
            monitor-exit(this);
            return r4;
        L6:
            monitor-exit(this);
            return false;
        }
    }

    private class b extends c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final d.c.i.i.g f16339j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final d.c.i.i.f f16340k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final d.c.i.i.e f16341l;
        private final l0 m;
        private int n;

        public b(m r7, k<d.c.c.h.a<d.c.i.l.c>> r8, l0 r9, d.c.i.i.g r10, d.c.i.i.f r11, d.c.i.i.e r12, boolean r13, int r14) {
            super(r7, r8, r9, r13, r14);
            d.c.c.d.i.g(r10);
            this.f16339j = r10;
            d.c.c.d.i.g(r11);
            this.f16340k = r11;
            d.c.c.d.i.g(r12);
            this.f16341l = r12;
            d.c.c.d.i.g(r9);
            this.m = r9;
            this.n = 0;
        }

        @Override // d.c.i.p.m.c
        protected int A(d.c.i.l.e r3) {
            if (r3.N() != d.c.h.c.f15819a) goto L7;
            return this.f16339j.c();
        L7:
            if (r3.N() == d.c.h.c.f15828j) goto L9;
            return 0;
        L9:
            return this.f16341l.b();
        }

        @Override // d.c.i.p.m.c
        protected d.c.i.l.i B() {
            return this.f16340k.a(this.f16339j.d());
        }

        @Override // d.c.i.p.m.c
        protected synchronized boolean O(d.c.i.l.e r4, int r5) {
            monitor-enter(this);
            boolean r0 = super.O(r4, r5);     // Catch: Throwable -> L54
            if (d.c.i.p.b.f(r5) == true) goto L8;
            if (d.c.i.p.b.n(r5, 8) == true) goto L8;
        L52:
            monitor-exit(this);
            return r0;
        L8:
            if (d.c.i.p.b.n(r5, 4) == true) goto L52;
            if (d.c.i.l.e.q0(r4) == false) goto L52;
            if (r4.N() != d.c.h.c.f15819a) goto L33;
            if (this.m.c().o() == true) goto L18;
            monitor-exit(this);
            return false;
        L18:
            if (this.f16339j.g(r4) == true) goto L21;
            monitor-exit(this);
            return false;
        L21:
            int r6 = this.f16339j.d();     // Catch: Throwable -> L54
            int r7 = this.n;     // Catch: Throwable -> L54
            if (r6 > r7) goto L26;
            monitor-exit(this);
            return false;
        L26:
            if (r6 < this.f16340k.b(r7)) goto L28;
        L31:
            this.n = r6;     // Catch: Throwable -> L54
            goto L52
        L28:
            if (this.f16339j.e() == true) goto L31;
            monitor-exit(this);
            return false;
        L33:
            if (r4.N() != d.c.h.c.f15828j) goto L47;
            if (this.m.c().n() == true) goto L39;
            monitor-exit(this);
            return false;
        L39:
            if (this.f16341l.d(r4) == true) goto L42;
            monitor-exit(this);
            return false;
        L42:
            r6 = this.f16341l.c();     // Catch: Throwable -> L54
            if (r6 > this.n) goto L31;
            monitor-exit(this);
            return false;
        L47:
            if (d.c.h.c.d(r4.N()) == false) goto L52;
            if (this.m.c().p() == true) goto L52;
            monitor-exit(this);
            return false;
        L54:
            th = move-exception;
            throw th;
        }
    }

    private abstract class c extends n<d.c.i.l.e, d.c.c.h.a<d.c.i.l.c>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final l0 f16342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final n0 f16343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.c.i.f.c f16344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f16345f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private AtomicBoolean f16346g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final v f16347h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ m f16348i;

        class a extends v.h {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l0 f16349b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f16350c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f16351d;

            a(c r1, d.c.i.f.e r2, m r3, l0 r4, int r5) {
                this.f16351d = r1;
                this.f16349b = r4;
                this.f16350c = r5;
                super(r2);
            }

            @Override // d.c.i.p.v.e
            public void a(d.c.i.l.e r4, int r5) {
                if (r4 == null) goto L14;
                c.q(this.f16351d, r4, r5);
                if (m.c(this.f16351d.f16348i) == false) goto L6;
            L7:
                d.c.i.q.b r0 = this.f16349b.c();
                if (m.d(this.f16351d.f16348i) == false) goto L10;
            L11:
                r4.H0(q.b(r0.s(), r0.r(), r4, this.f16350c));
            L12:
                c.r(this.f16351d, r4, r5);
                return;
            L10:
                if (d.c.c.k.f.k(r0.v()) == true) goto L12;
            L6:
                if (d.c.i.p.b.n(r5, 16) == true) goto L12;
            }
        }

        class b extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f16352a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f16353b;

            b(c r1, m r2, boolean r3) {
                this.f16353b = r1;
                this.f16352a = r3;
            }

            @Override // d.c.i.p.m0
            public void a() {
                if (this.f16352a == false) goto L6;
                c.u(this.f16353b);
                return;
            }

            @Override // d.c.i.p.e, d.c.i.p.m0
            public void b() {
                if (c.s(this.f16353b).g() == false) goto L6;
                c.t(this.f16353b).h();
                return;
            }
        }

        public c(m r8, k<d.c.c.h.a<d.c.i.l.c>> r9, l0 r10, boolean r11, int r12) {
            this.f16348i = r8;
            super(r9);
            this.f16346g = new AtomicBoolean(true);
            this.f16342c = r10;
            this.f16343d = r10.f();
            d.c.i.f.c r13 = r10.c().g();
            this.f16344e = r13;
            this.f16345f = false;
            a r0 = new a(this, r10.b(), r8, r10, r12);
            this.f16347h = new v(m.e(r8), r0, r13.f15991a);
            r10.d(new b(this, r8, r11));
        }

        private Rect C(d.c.i.l.e r1, d.c.i.f.c r2) {
            Rect r0 = r1.Q();
            if (r0 == null) goto L10;
            if (r2.m == false) goto L8;
            return r0;
        L8:
            return r2.n;
        L10:
            return r2.n;
        }

        private void D() {
            L(true);
            p().b();
        }

        private void E(Throwable r2) {
            L(true);
            p().a(r2);
        }

        private void F(d.c.i.l.c r2, int r3) {
            d.c.c.h.a<d.c.i.l.c> r4 = d.c.c.h.a.V(r2);
            L(d.c.i.p.b.e(r3));     // Catch: Throwable -> L6
            p().d(r4, r3);     // Catch: Throwable -> L6
            d.c.c.h.a.L(r4);
            return;
        L6:
            th = move-exception;
            d.c.c.h.a.L(r4);
            throw th;
        }

        private boolean G(ArrayList<Integer> r2) {
            Iterator<Integer> r1 = r2.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().intValue() == (-16777216)) goto L4;
            return false;
        L9:
            return true;
        }

        private boolean H(d.c.i.l.e r1, d.c.i.f.c r2) {
            Rect r0 = r1.Q();
            if (r0 != null) goto L5;
        L7:
            r0 = r2.n;
        L8:
            if (r0 == null) goto L10;
            return true;
        L10:
            return false;
        L5:
            if (r2.m == false) goto L7;
            goto L7
        }

        private synchronized boolean I() {
            monitor-enter(this);
            boolean r0 = this.f16345f;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private boolean J(ArrayList<Integer> r1) {
            Iterator<Integer> r0 = r1.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            if (r0.next().intValue() == 0) goto L4;
            return false;
        L9:
            return true;
        }

        private boolean K(ArrayList<Integer> r2) {
            Iterator<Integer> r1 = r2.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().intValue() == (-1)) goto L4;
            return false;
        L9:
            return true;
        }

        private void L(boolean r2) {
            monitor-enter(this);
            if (r2 == true) goto L16;
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L16:
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.f16345f == true) goto L11;
            p().c(1.0f);     // Catch: Throwable -> L13
            this.f16345f = true;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            this.f16347h.c();
        }

        private void N(d.c.i.l.e r3, int r4) {
            boolean r2 = this.f16346g.compareAndSet(true, false);
            boolean r5 = d.c.i.p.b.e(r4);
            if (r2 == false) goto L7;
            if (r5 == false) goto L7;
            r3.z0(0);
            return;
        L7:
            if (r2 == false) goto L11;
            if (r5 == true) goto L11;
            r3.z0(1);
            return;
        L11:
            if (r2 == true) goto L15;
            if (r5 == true) goto L15;
            r3.z0(2);
            return;
        L15:
            if (r2 == true) goto L19;
            if (r5 == false) goto L20;
            r3.z0(3);
            return;
        L20:
            return;
        }

        static /* synthetic */ void q(c r0, d.c.i.l.e r1, int r2) {
            r0.N(r1, r2);
        }

        static /* synthetic */ void r(c r0, d.c.i.l.e r1, int r2) {
            r0.w(r1, r2);
        }

        static /* synthetic */ l0 s(c r0) {
            return r0.f16342c;
        }

        static /* synthetic */ v t(c r0) {
            return r0.f16347h;
        }

        static /* synthetic */ void u(c r0) {
            r0.D();
        }

        private boolean v(d.c.i.l.e r4, int r5) {
            boolean r0 = false;
            if (d.c.i.p.b.e(r5) == false) goto L5;
            return false;
        L5:
            d.c.c.e.a.c("ProgressiveDecoder", "fresco_canParseThumbDataAndSet start");
            d.c.i.q.b r3 = this.f16342c.c();
            if (r3.f() == false) goto L8;
            return false;
        L8:
            boolean r1 = com.facebook.imageutils.d.a(r4);
            boolean r6 = r4.k0();
            r3.E(r6);
            if (r1 == false) goto L12;
            if (r6 == true) goto L12;
            r0 = true;
        L12:
            r3.G(r0);
            d.c.c.e.a.c("ProgressiveDecoder", "fresco_canParseThumbData end hasThumb:" + r1 + " isDecodeThumb:" + r6 + " url:" + r3.v());
            return r6;
        }

        private void w(d.c.i.l.e r22, int r23) {
            int r0 = r23;
            if (r22.N() == d.c.h.c.f15819a) goto L12;
            if (r22.N() == d.c.h.c.f15828j) goto L12;
            if (v(r22, r23) == true) goto L12;
            if (d.c.i.p.b.f(r23) == false) goto L12;
            return;
        L12:
            if (I() == false) goto L14;
            return;
        L14:
            if (d.c.i.l.e.q0(r22) == false) goto L89;
            d.c.h.d r1 = r22.N();
            if (r1 == null) goto L19;
            String r7 = r1.a();
        L20:
            String r8 = r22.Y() + "x" + r22.M();
            String r10 = String.valueOf(r22.V());
            boolean r6 = d.c.i.p.b.e(r23);
            if (r6 == true) goto L23;
        L25:
            boolean r5 = false;
        L26:
            boolean r11 = d.c.i.p.b.n(r0, 4);
            boolean r12 = H(r22, this.f16344e);
            Rect r17 = C(r22, this.f16344e);
            d.c.i.f.f r2 = this.f16342c.c().r();
            if (r2 == null) goto L29;
            String r9 = r2.f16021a + "x" + r2.f16022b;
        L85:
            long r19 = this.f16347h.f();     // Catch: Throwable -> L77
            String r3 = String.valueOf(this.f16342c.c().v());     // Catch: Throwable -> L77
            if (r5 == true) goto L35;
            if (r11 == true) goto L35;
            int r4 = A(r22);     // Catch: Throwable -> L77
        L36:
            if (r5 == true) goto L40;
            if (r11 == true) goto L40;
            d.c.i.l.i r13 = B();     // Catch: Throwable -> L77
        L41:
            d.c.i.l.i r14 = r13;
            this.f16343d.b(this.f16342c.getId(), "DecodeProducer");     // Catch: Throwable -> L77
            d.c.i.l.c r15 = m.f(this.f16348i).a(r22, r4, r14, this.f16344e);     // Catch: OutOfMemoryError -> L61 Exception -> L63 d.c.i.i.a -> L65 Throwable -> L77
            if (r22.V() == 1) goto L81;
            r0 = r0 | 16;
        L81:
            this.f16343d.i(this.f16342c.getId(), "DecodeProducer", y(r15, r19, r14, r6, r7, r8, r9, r10, r12, r17));     // Catch: Throwable -> L55
            if (r15 == null) goto L51;
            d.c.i.l.c r16 = r15;
            r16.g(r22);     // Catch: Throwable -> L77
        L52:
            F(r16, r0);     // Catch: Throwable -> L77
            d.c.i.l.e.g(r22);
            return;
        L51:
            r16 = r15;
        L55:
            th = th;
        L78:
            d.c.i.l.e.g(r22);
            throw th;
        L59:
            e = e;
            d.c.i.l.c r18 = r15;
        L74:
            this.f16343d.j(this.f16342c.getId(), "DecodeProducer", e, y(r18, r19, r14, r6, r7, r8, r9, r10, r12, r17));     // Catch: Throwable -> L77
            E(e);     // Catch: Throwable -> L77
            d.c.i.l.e.g(r22);
            return;
        L57:
            e = e;
            d.c.i.l.c r20 = r15;
        L69:
            if (m.g(this.f16348i) == false) goto L73;
            this.f16343d.j(this.f16342c.getId(), "DecodeProducer", e, y(r20, r19, r14, r6, r7, r8, r9, r10, r12, r17));     // Catch: Throwable -> L77
            E(e);     // Catch: Throwable -> L77
            d.c.i.l.e.g(r22);
            return;
        L73:
            throw e;     // Catch: Throwable -> L77
        L65:
            e = move-exception;
            d.c.i.l.e r21 = e.a();     // Catch: OutOfMemoryError -> L61 Exception -> L63 Throwable -> L77
            d.c.c.e.a.C("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", new Object[]{e.getMessage(), r3, r21.L(10), Integer.valueOf(r21.X())});     // Catch: OutOfMemoryError -> L61 Exception -> L63 Throwable -> L77
            throw e;     // Catch: OutOfMemoryError -> L61 Exception -> L63 Throwable -> L77
        L63:
            e = e;
            r18 = null;
        L61:
            e = e;
            r20 = null;
        L40:
            r13 = d.c.i.l.g.f16188d;     // Catch: Throwable -> L77
        L35:
            r4 = r22.X();     // Catch: Throwable -> L77
        L77:
            th = th;
            goto L78
        L29:
            r9 = EnvironmentCompat.MEDIA_UNKNOWN;
            goto L85
        L23:
            if (d.c.i.p.b.n(r0, 8) == true) goto L25;
            r5 = true;
            goto L26
        L19:
            r7 = EnvironmentCompat.MEDIA_UNKNOWN;
            goto L20
        }

        private ArrayList<Integer> x(Bitmap r9) {
            int r8 = r9.getWidth();
            int r0 = r9.getHeight();
            ArrayList<Integer> r1 = new ArrayList();
            Random r2 = new Random();
            Random r3 = new Random();
            int r4 = d.c.i.g.h.g().a();
            if (d.c.i.r.b.d() == false) goto L5;
            d.c.i.r.b.a("DecodeProducer#getColors");
        L5:
            int r5 = 0;
        L6:
            if (r5 >= r4) goto L9;
            r1.add(Integer.valueOf(r9.getPixel(r2.nextInt(r8), r3.nextInt(r0))));
            r5 = r5 + 1;
            goto L6
        L9:
            if (d.c.i.r.b.d() == false) goto L11;
            d.c.i.r.b.b();
        L11:
            return r1;
        }

        private Map<String, String> y(d.c.i.l.c r21, long r22, d.c.i.l.i r24, boolean r25, String r26, String r27, String r28, String r29, boolean r30, Rect r31) {
            if (this.f16343d.f(this.f16342c.getId()) == true) goto L6;
            return null;
        L6:
            String r6 = String.valueOf(r22);
            String r7 = String.valueOf(r24.b());
            String r8 = String.valueOf(r25);
            if ((r21 instanceof d.c.i.l.d) == false) goto L17;
            Bitmap r9 = ((d.c.i.l.d) r21).E();
            String r1 = r9.getWidth() + "x" + r9.getHeight();
            HashMap r5 = new HashMap(13);
            r5.put("bitmapSize", r1);
            r5.put("queueTime", r6);
            r5.put("hasGoodQuality", r7);
            r5.put("isFinal", r8);
            r5.put("encodedImageSize", r27);
            r5.put("imageFormat", r26);
            r5.put("requestedImageSize", r28);
            r5.put("sampleSize", r29);
            r5.put("bitmapRamSize", String.valueOf(com.facebook.imageutils.b.e(r9)));
            if (r30 == false) goto L11;
            Object r13 = LocationInfoConst.ALLOW_USE_LOCATION;
        L12:
            r5.put("isCrop", r13);
            if (r31 == null) goto L15;
            r5.put("regionToDecode", r31.flattenToString());
        L15:
            r5.put("imageCount", String.valueOf(r21.b()));
            r5.put("imageQuality", z(r9));
            return d.c.c.d.f.a(r5);
        L11:
            r13 = BDLocationException.ERROR_TIMEOUT;
            goto L12
        L17:
            HashMap r10 = new HashMap(11);
            r10.put("queueTime", r6);
            r10.put("hasGoodQuality", r7);
            r10.put("isFinal", r8);
            r10.put("encodedImageSize", r27);
            r10.put("imageFormat", r26);
            r10.put("requestedImageSize", r28);
            r10.put("sampleSize", r29);
            if (r30 == false) goto L20;
            Object r14 = LocationInfoConst.ALLOW_USE_LOCATION;
        L21:
            r10.put("isCrop", r14);
            if (r31 == null) goto L24;
            r10.put("regionToDecode", r31.flattenToString());
        L24:
            if (r21 != null) goto L26;
            String r0 = "-1";
        L27:
            r10.put("imageCount", r0);
            r10.put("imageQuality", "not_static_image");
            return d.c.c.d.f.a(r10);
        L26:
            r0 = String.valueOf(r21.b());
            goto L27
        L20:
            r14 = BDLocationException.ERROR_TIMEOUT;
            goto L21
        }

        private String z(Bitmap r2) {
            ArrayList<Integer> r3 = x(r2);
            if (K(r3) == false) goto L7;
            return "white_suspected";
        L7:
            if (G(r3) == false) goto L11;
            return "black_suspected";
        L11:
            if (J(r3) == false) goto L14;
            return "transparent_suspected";
        L14:
            return "normal";
        }

        protected abstract int A(d.c.i.l.e r1);

        protected abstract d.c.i.l.i B();

        public void M(d.c.i.l.e r3, int r4) {
        L31:
            th = move-exception;
            if (d.c.i.r.b.d() == false) goto L35;
            d.c.i.r.b.b();
        L35:
            throw th;
        L3:
            if (d.c.i.r.b.d() == false) goto L5;
            d.c.i.r.b.a("DecodeProducer#onNewResultImpl");     // Catch: Throwable -> L31
        L5:
            boolean r0 = d.c.i.p.b.e(r4);     // Catch: Throwable -> L31
            if (r0 == false) goto L15;
            if (d.c.i.l.e.q0(r3) == true) goto L15;
            E(new d.c.c.k.a("Encoded image is not valid."));     // Catch: Throwable -> L31
            if (d.c.i.r.b.d() == false) goto L37;
            d.c.i.r.b.b();
            return;
        L37:
            return;
        L15:
            if (O(r3, r4) == true) goto L21;
            if (d.c.i.r.b.d() == false) goto L38;
            d.c.i.r.b.b();
            return;
        L38:
            return;
        L21:
            boolean r5 = d.c.i.p.b.n(r4, 4);     // Catch: Throwable -> L31
            if (r0 == true) goto L26;
            if (r5 == true) goto L26;
            if (this.f16342c.g() == true) goto L26;
        L28:
            if (d.c.i.r.b.d() == false) goto L39;
            d.c.i.r.b.b();
            return;
        L39:
            return;
        L26:
            this.f16347h.h();     // Catch: Throwable -> L31
            goto L28
        }

        protected boolean O(d.c.i.l.e r1, int r2) {
            return this.f16347h.k(r1, r2);
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        public void g() {
            D();
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        public void h(Throwable r1) {
            E(r1);
        }

        @Override // d.c.i.p.b
        public /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            M((d.c.i.l.e) r1, r2);
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void j(float r2) {
            super.j(r2 * 0.99f);
        }
    }

    public m(d.c.c.g.a r1, Executor r2, d.c.i.i.c r3, d.c.i.i.f r4, boolean r5, boolean r6, boolean r7, k0<d.c.i.l.e> r8, int r9, boolean r10) {
        d.c.c.d.i.g(r1);
        this.f16329a = r1;
        d.c.c.d.i.g(r2);
        this.f16330b = r2;
        d.c.c.d.i.g(r3);
        this.f16331c = r3;
        d.c.c.d.i.g(r4);
        this.f16332d = r4;
        this.f16334f = r5;
        this.f16335g = r6;
        d.c.c.d.i.g(r8);
        this.f16333e = r8;
        this.f16336h = r7;
        this.f16337i = r9;
        this.f16338j = r10;
    }

    static /* synthetic */ boolean c(m r0) {
        return r0.f16334f;
    }

    static /* synthetic */ boolean d(m r0) {
        return r0.f16335g;
    }

    static /* synthetic */ Executor e(m r0) {
        return r0.f16330b;
    }

    static /* synthetic */ d.c.i.i.c f(m r0) {
        return r0.f16331c;
    }

    static /* synthetic */ boolean g(m r0) {
        return r0.f16338j;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.c.h.a<d.c.i.l.c>> r11, l0 r12) {
    L14:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("DecodeProducer#produceResults");     // Catch: Throwable -> L14
    L6:
        if (d.c.c.k.f.k(r12.c().v()) == true) goto L8;
        k<d.c.i.l.e> r0 = new a(this, r11, r12, this.f16336h, this.f16337i);     // Catch: Throwable -> L14
    L9:
        this.f16333e.b(r0, r12);     // Catch: Throwable -> L14
        if (d.c.i.r.b.d() == false) goto L21;
        d.c.i.r.b.b();
        return;
    L21:
        return;
    L8:
        d.c.i.i.g r4 = new d.c.i.i.g(this.f16329a);     // Catch: Throwable -> L14
        d.c.i.i.e r6 = new d.c.i.i.e(this.f16329a);     // Catch: Throwable -> L14
        r0 = new b(this, r11, r12, r4, this.f16332d, r6, this.f16336h, this.f16337i);     // Catch: Throwable -> L14
        goto L9
    }
}
