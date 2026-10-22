package kotlin.s0.w.d.l0.e.b;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a0 f19680k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a0 f19681l = null;
    public static final a0 m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a0 f19687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f19688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a0 f19689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a0 f19690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f19691j;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19692a = null;

        static {
            int[] r0 = new int[r1.values().length];
            r0[r1.f21066i.ordinal()] = 1;
            r0[r1.f21065h.ordinal()] = 2;
            f19692a = r0;
        }
    }

    static {
        boolean r1 = false;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
        boolean r7 = false;
        a0 r8 = null;
        a0 r9 = null;
        boolean r10 = false;
        kotlin.n0.d.g r12 = null;
        a0 r13 = new a0(r1, r2, r3, r4, r5, null, r7, r8, r9, r10, 1023, r12);
        f19680k = r13;
        f19681l = new a0(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        m = new a0(r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, 988, r12);
    }

    public a0(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, a0 r6, boolean r7, a0 r8, a0 r9, boolean r10) {
        this.f19682a = r1;
        this.f19683b = r2;
        this.f19684c = r3;
        this.f19685d = r4;
        this.f19686e = r5;
        this.f19687f = r6;
        this.f19688g = r7;
        this.f19689h = r8;
        this.f19690i = r9;
        this.f19691j = r10;
    }

    public /* synthetic */ a0(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, a0 r8, boolean r9, a0 r10, a0 r11, boolean r12, int r13, kotlin.n0.d.g r14) {
        if ((r13 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = false;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = true;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r10 = r8;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r11 = r8;
    L30:
        if ((r13 & 512) == 0) goto L32;
        r12 = false;
    L32:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public final boolean a() {
        return this.f19688g;
    }

    public final boolean b() {
        return this.f19691j;
    }

    public final boolean c() {
        return this.f19683b;
    }

    public final boolean d() {
        return this.f19682a;
    }

    public final boolean e() {
        return this.f19684c;
    }

    public final a0 f(r1 r2, boolean r3) {
        kotlin.n0.d.o.f(r2, "effectiveVariance");
        if (r3 == true) goto L5;
    L7:
        int r4 = a.f19692a[r2.ordinal()];
        if (r4 != 1) goto L10;
        a0 r5 = this.f19689h;
        if (r5 != null) goto L21;
        return this;
    L21:
        return r5;
    L10:
        if (r4 == 2) goto L14;
        r5 = this.f19687f;
        if (r5 != null) goto L21;
        return this;
    L14:
        r5 = this.f19690i;
        if (r5 != null) goto L21;
        return this;
    L5:
        if (this.f19684c == false) goto L7;
        return this;
    }

    public final a0 g() {
        boolean r2 = true;
        return new a0(this.f19682a, r2, this.f19684c, this.f19685d, this.f19686e, this.f19687f, this.f19688g, this.f19689h, this.f19690i, false, 512, null);
    }
}
