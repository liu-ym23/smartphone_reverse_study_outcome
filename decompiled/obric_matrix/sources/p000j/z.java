package p000j;

import com.obric.matrix.common_api.INetworkApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import k.e;
import k.f;
import k.h;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends e0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f18223e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f18224f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f18225g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f18226h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f18227i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f18228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f18229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f18230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f18231d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f18232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private y f18233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<b> f18234c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String r2) {
            this.f18233b = z.f18223e;
            this.f18234c = new ArrayList();
            this.f18232a = h.k(r2);
        }

        public a a(v r1, e0 r2) {
            b(b.a(r1, r2));
            return this;
        }

        public a b(b r2) {
            Objects.requireNonNull(r2, "part == null");
            this.f18234c.add(r2);
            return this;
        }

        public z c() {
            if (this.f18234c.isEmpty() == true) goto L7;
            return new z(this.f18232a, this.f18233b, this.f18234c);
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public a d(y r3) {
            Objects.requireNonNull(r3, "type == null");
            if (r3.f().equals("multipart") == false) goto L7;
            this.f18233b = r3;
            return this;
        L7:
            throw new IllegalArgumentException("multipart != " + r3);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v f18235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e0 f18236b;

        private b(v r1, e0 r2) {
            this.f18235a = r1;
            this.f18236b = r2;
        }

        public static b a(v r1, e0 r2) {
            Objects.requireNonNull(r2, "body == null");
            if (r1 != null) goto L5;
        L9:
            if (r1 == null) goto L16;
            if (r1.d("Content-Length") == null) goto L16;
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        L16:
            return new b(r1, r2);
        L5:
            if (r1.d(INetworkApi.CONTENT_TYPE) == null) goto L9;
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
    }

    static {
        f18223e = y.c("multipart/mixed");
        y.c("multipart/alternative");
        y.c("multipart/digest");
        y.c("multipart/parallel");
        f18224f = y.c("multipart/form-data");
        f18225g = new byte[]{58, 32};
        f18226h = new byte[]{13, 10};
        f18227i = new byte[]{45, 45};
    }

    z(h r3, y r4, List<b> r5) {
        this.f18231d = -1;
        this.f18228a = r3;
        this.f18229b = y.c(r4 + "; boundary=" + r3.F());
        this.f18230c = c.t(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long g(f r13, boolean r14) {
        if (r14 == false) goto L4;
        r13 = new e();
        e r0 = r13;
    L5:
        int r1 = this.f18230c.size();
        long r3 = 0;
        int r5 = 0;
    L6:
        if (r5 >= r1) goto L26;
        b r6 = this.f18230c.get(r5);
        v r7 = r6.f18235a;
        e0 r8 = r6.f18236b;
        r13.U(f18227i);
        r13.W(this.f18228a);
        r13.U(f18226h);
        if (r7 == null) goto L12;
        int r9 = r7.k();
        int r10 = 0;
    L10:
        if (r10 >= r9) goto L12;
        r13.D(r7.f(r10)).U(f18225g).D(r7.m(r10)).U(f18226h);
        r10 = r10 + 1;
    L12:
        y r11 = r8.b();
        if (r11 == null) goto L15;
        r13.D("Content-Type: ").D(r11.toString()).U(f18226h);
    L15:
        long r12 = r8.a();
        if (r12 == (-1)) goto L18;
        r13.D("Content-Length: ").c0(r12).U(f18226h);
    L21:
        byte[] r15 = f18226h;
        r13.U(r15);
        if (r14 == false) goto L24;
        r3 = r3 + r12;
    L25:
        r13.U(r15);
        r5 = r5 + 1;
        goto L6
    L24:
        r8.f(r13);
        goto L25
    L18:
        if (r14 == false) goto L21;
        r0.a();
        return -1;
    L26:
        byte[] r2 = f18227i;
        r13.U(r2);
        r13.W(this.f18228a);
        r13.U(r2);
        r13.U(f18226h);
        if (r14 == false) goto L35;
        long r4 = r3 + r0.k0();
        r0.a();
        return r4;
    L35:
        return r3;
    L4:
        r0 = 0;
        goto L5
    }

    @Override // p000j.e0
    public long a() {
        long r0 = this.f18231d;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        long r1 = g(null, true);
        this.f18231d = r1;
        return r1;
    }

    @Override // p000j.e0
    public y b() {
        return this.f18229b;
    }

    @Override // p000j.e0
    public void f(f r2) {
        g(r2, false);
    }
}
