package d.b.s.a.a0.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.a0;
import kotlin.b0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public interface e {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<u<String, Object>> f14643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Throwable f14644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f14646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final e f14647e;

        public a(String r2, e r3) {
            o.g(r2, "recordName");
            o.g(r3, "profiler");
            this.f14646d = r2;
            this.f14647e = r3;
            this.f14643a = new ArrayList();
        }

        public final a a(String r2, Object r3) {
            o.g(r2, "key");
            this.f14643a.add(a0.a(r2, r3));
            return this;
        }

        public final a b() {
            this.f14645c = 2;
            return this;
        }

        public final void c() {
            e r0 = this.f14647e;
            String r1 = this.f14646d;
            int r2 = this.f14645c;
            Throwable r3 = this.f14644b;
            Object[] r5 = this.f14643a.toArray(new u[0]);
            if (r5 == null) goto L7;
            u[] r6 = (u[]) r5;
            r0.d(r1, r2, r3, (u[]) Arrays.copyOf(r6, r6.length));
            return;
        L7:
            throw new b0("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    void a(String r1);

    void b(String r1);

    a c(String r1);

    void d(String r1, int r2, Throwable r3, u<String, ? extends Object>... r4);
}
