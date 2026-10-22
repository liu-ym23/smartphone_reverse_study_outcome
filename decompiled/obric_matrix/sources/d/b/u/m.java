package d.b.u;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h f15058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<d.b.u.w.m> f15059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<d.b.u.w.g> f15060d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f15061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private h f15062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<d.b.u.w.m> f15063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<d.b.u.w.g> f15064d;

        public a(long r2) {
            this.f15063c = new ArrayList();
            this.f15064d = new ArrayList();
            this.f15061a = r2;
        }

        static /* synthetic */ long a(a r2) {
            return r2.f15061a;
        }

        static /* synthetic */ h b(a r0) {
            return r0.f15062b;
        }

        static /* synthetic */ List c(a r0) {
            return r0.f15063c;
        }

        static /* synthetic */ List d(a r0) {
            return r0.f15064d;
        }

        public a e(d.b.u.w.m r2) {
            this.f15063c.add(r2);
            return this;
        }

        public m f() {
            if (this.f15061a < 0) goto L7;
            return new m(this);
        L7:
            throw new IllegalArgumentException("bizId < 0");
        }
    }

    public m(a r3) {
        this.f15057a = a.a(r3);
        this.f15058b = a.b(r3);
        this.f15059c = a.c(r3);
        this.f15060d = a.d(r3);
    }
}
