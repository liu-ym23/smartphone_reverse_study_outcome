package com.bytedance.android.sdk.bdticketguard.n1;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f918b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f919c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f920a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final long a() {
            return l.a();
        }

        public final long b() {
            long r0 = System.currentTimeMillis();
            l.c(r0);
            return r0;
        }
    }

    static {
        f919c = new a(null);
        c(0);
        f918b = 0;
    }

    private /* synthetic */ l(long r1) {
        this.f920a = r1;
    }

    public static final /* synthetic */ long a() {
        return f918b;
    }

    public static final /* synthetic */ l b(long r1) {
        return new l(r1);
    }

    public static long c(long r0) {
        return r0;
    }

    public static boolean d(long r4, Object r6) {
        if ((r6 instanceof l) == true) goto L5;
    L10:
        return false;
    L5:
        if (r4 != ((l) r6).i()) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        return true;
    L7:
        r5 = false;
        goto L8
    }

    public static int e(long r0) {
        return Long.hashCode(r0);
    }

    public static final boolean f(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final long g(long r1, long r3) {
        if (f(r1) == true) goto L5;
    L7:
        return -1;
    L5:
        if (f(r3) == false) goto L7;
        return r3 - r1;
    }

    public static String h(long r2) {
        return "TimePoint(value=" + r2 + ")";
    }

    public boolean equals(Object r3) {
        return d(this.f920a, r3);
    }

    public int hashCode() {
        return e(this.f920a);
    }

    public final /* synthetic */ long i() {
        return this.f920a;
    }

    public String toString() {
        return h(this.f920a);
    }
}
