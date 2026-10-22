package d.c.i.p;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class z implements c1<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.g.i f16482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f16483c;

    class a extends w0<d.c.i.l.e> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b f16484k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ z f16485l;

        a(z r1, k r2, n0 r3, String r4, String r5, d.c.i.q.b r6) {
            this.f16485l = r1;
            this.f16484k = r6;
            super(r2, r3, r4, r5);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ void c(Object r1) {
            k((d.c.i.l.e) r1);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ Object d() {
            return m();
        }

        @Override // d.c.i.p.w0
        protected /* bridge */ /* synthetic */ Map j(d.c.i.l.e r1) {
            return l(r1);
        }

        protected void k(d.c.i.l.e r1) {
            d.c.i.l.e.g(r1);
        }

        protected Map<String, String> l(d.c.i.l.e r1) {
            if (r1 == null) goto L4;
            boolean r0 = true;
        L6:
            return d.c.c.d.f.of("createdThumbnail", Boolean.toString(r0));
        L4:
            r0 = false;
            goto L6
        }

        protected d.c.i.l.e m() {
            Uri r0 = this.f16484k.v();
            ExifInterface r1 = this.f16485l.g(r0);
            if (r1 != null) goto L5;
            return null;
        L5:
            if (r1.hasThumbnail() == false) goto L11;
            byte[] r2 = r1.getThumbnail();
            d.c.c.g.h r3 = z.c(this.f16485l).b(r2);
            return z.d(this.f16485l, r3, r1);
        L11:
            return null;
        }
    }

    class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w0 f16486a;

        b(z r1, w0 r2) {
            this.f16486a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f16486a.b();
        }
    }

    public z(Executor r1, d.c.c.g.i r2, ContentResolver r3) {
        this.f16481a = r1;
        this.f16482b = r2;
        this.f16483c = r3;
    }

    static /* synthetic */ d.c.c.g.i c(z r0) {
        return r0.f16482b;
    }

    static /* synthetic */ d.c.i.l.e d(z r0, d.c.c.g.h r1, ExifInterface r2) {
        return r0.e(r1, r2);
    }

    private d.c.i.l.e e(d.c.c.g.h r3, ExifInterface r4) {
        Pair<Integer, Integer> r0 = com.facebook.imageutils.b.a(new d.c.c.g.j(r3));
        int r2 = h(r4);
        int r5 = -1;
        if (r0 == null) goto L5;
        int r1 = ((Integer) r0.first).intValue();
    L6:
        if (r0 == null) goto L8;
        r5 = ((Integer) r0.second).intValue();
    L8:
        d.c.c.h.a r6 = d.c.c.h.a.V(r3);
        d.c.i.l.e r7 = new d.c.i.l.e(r6);     // Catch: Throwable -> L12
        d.c.c.h.a.L(r6);
        r7.D0(d.c.h.c.f15819a);
        r7.G0(r2);
        r7.I0(r1);
        r7.C0(r5);
        return r7;
    L12:
        th = move-exception;
        d.c.c.h.a.L(r6);
        throw th;
    L5:
        r1 = -1;
        goto L6
    }

    private int h(ExifInterface r1) {
        return com.facebook.imageutils.f.a(Integer.parseInt(r1.getAttribute("Orientation")));
    }

    @Override // d.c.i.p.c1
    public boolean a(d.c.i.f.f r1) {
        return d1.b(512, 512, r1);
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r9, l0 r10) {
        a r7 = new a(this, r9, r10.f(), "LocalExifThumbnailProducer", r10.getId(), r10.c());
        r10.d(new b(this, r7));
        this.f16481a.execute(r7);
    }

    boolean f(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        File r0 = new File(r2);
        if (r0.exists() == true) goto L8;
        return false;
    L8:
        if (r0.canRead() == false) goto L12;
        return true;
    L12:
        return false;
    }

    ExifInterface g(Uri r2) {
        String r3 = d.c.c.k.f.a(this.f16483c, r2);
    L7:
        d.c.c.e.a.f(z.class, "StackOverflowError in ExifInterface constructor");
        return null;
    L4:
        if (f(r3) == false) goto L13;
        return new ExifInterface(r3);
        goto L14
    L13:
        return null;
    L14:
        return null;
    }
}
