package kotlin.s0.w.d.l0.e.a;

import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.u a(o r0, kotlin.s0.w.d.l0.g.c r1, boolean r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L7;
            r2 = true;
        L7:
            return r0.c(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f19530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f19531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.e.a.n0.g f19532c;

        public b(kotlin.s0.w.d.l0.g.b r2, byte[] r3, kotlin.s0.w.d.l0.e.a.n0.g r4) {
            kotlin.n0.d.o.f(r2, "classId");
            this.f19530a = r2;
            this.f19531b = r3;
            this.f19532c = r4;
        }

        public /* synthetic */ b(kotlin.s0.w.d.l0.g.b r2, byte[] r3, kotlin.s0.w.d.l0.e.a.n0.g r4, int r5, kotlin.n0.d.g r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r3, r4);
        }

        public final kotlin.s0.w.d.l0.g.b a() {
            return this.f19530a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (kotlin.n0.d.o.a(this.f19530a, r6.f19530a) == true) goto L12;
            return false;
        L12:
            if (kotlin.n0.d.o.a(this.f19531b, r6.f19531b) == true) goto L15;
            return false;
        L15:
            if (kotlin.n0.d.o.a(this.f19532c, r6.f19532c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f19530a.hashCode() * 31;
            byte[] r1 = this.f19531b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            kotlin.s0.w.d.l0.e.a.n0.g r5 = this.f19532c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = Arrays.hashCode(r1);
            goto L6
        }

        public String toString() {
            return "Request(classId=" + this.f19530a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f19531b) + ", outerClass=" + this.f19532c + ')';
        }
    }

    kotlin.s0.w.d.l0.e.a.n0.g a(b r1);

    Set<String> b(kotlin.s0.w.d.l0.g.c r1);

    kotlin.s0.w.d.l0.e.a.n0.u c(kotlin.s0.w.d.l0.g.c r1, boolean r2);
}
