package d.b.s.a.a0.d;

import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14638c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14640b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final b a() {
            return new b(System.currentTimeMillis(), System.nanoTime());
        }
    }

    static {
        f14638c = new a(null);
    }

    public b(long r1, long r3) {
        this.f14639a = r1;
        this.f14640b = r3;
    }

    public final c a(b r6) {
        o.g(r6, "last");
        return new c(this.f14639a - r6.f14639a, this.f14640b - r6.f14640b);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L18:
        return true;
    L5:
        if ((r8 instanceof b) == false) goto L17;
        b r9 = (b) r8;
        if (this.f14639a != r9.f14639a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L17;
        if (this.f14640b != r9.f14640b) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L14:
        r7 = false;
        goto L15
    L9:
        r1 = false;
    L17:
        return false;
    }

    public int hashCode() {
        long r0 = this.f14639a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.f14640b;
        return r1 + ((int) ((r3 >>> 32) ^ r3));
    }

    public String toString() {
        return "EventTime(millis=" + this.f14639a + ", nanos=" + this.f14640b + ")";
    }
}
