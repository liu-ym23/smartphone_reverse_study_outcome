package p000j;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e;
import k.f;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final y f18187c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f18188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f18189b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f18190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f18191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Charset f18192c;

        public a() {
            this(null);
        }

        public a(Charset r2) {
            this.f18190a = new ArrayList();
            this.f18191b = new ArrayList();
            this.f18192c = r2;
        }

        public a a(String r9, String r10) {
            Objects.requireNonNull(r9, "name == null");
            Objects.requireNonNull(r10, "value == null");
            this.f18190a.add(w.c(r9, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f18192c));
            this.f18191b.add(w.c(r10, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f18192c));
            return this;
        }

        public t b() {
            return new t(this.f18190a, this.f18191b);
        }
    }

    static {
        f18187c = y.c("application/x-www-form-urlencoded");
    }

    t(List<String> r1, List<String> r2) {
        this.f18188a = c.t(r1);
        this.f18189b = c.t(r2);
    }

    private long g(f r4, boolean r5) {
        if (r5 == false) goto L4;
        e r6 = new e();
    L5:
        int r0 = 0;
        int r1 = this.f18188a.size();
    L6:
        if (r0 >= r1) goto L10;
        if (r0 <= 0) goto L9;
        r6.s0(38);
    L9:
        r6.B0(this.f18188a.get(r0));
        r6.s0(61);
        r6.B0(this.f18189b.get(r0));
        r0 = r0 + 1;
        goto L6
    L10:
        if (r5 == false) goto L12;
        long r2 = r6.k0();
        r6.a();
        return r2;
    L12:
        return 0;
    L4:
        r6 = r4.c();
        goto L5
    }

    @Override // p000j.e0
    public long a() {
        return g(null, true);
    }

    @Override // p000j.e0
    public y b() {
        return f18187c;
    }

    @Override // p000j.e0
    public void f(f r2) {
        g(r2, false);
    }
}
