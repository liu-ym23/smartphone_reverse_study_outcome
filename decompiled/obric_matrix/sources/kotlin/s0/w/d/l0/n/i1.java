package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes2.dex */
public class i1 extends h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r1 f21028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e0 f21029b;

    public i1(e0 r2) {
        if (r2 == null) goto L5;
        this(r1.f21065h, r2);
        return;
    L5:
        e(2);
        throw null;
    }

    public i1(r1 r2, e0 r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.f21028a = r2;
        this.f21029b = r3;
        return;
    L7:
        e(1);
        throw null;
    L9:
        e(0);
        throw null;
    }

    private static /* synthetic */ void e(int r9) {
        if (r9 == 4) goto L6;
        if (r9 == 5) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 4) goto L11;
        if (r9 == 5) goto L11;
        int r5 = 3;
    L12:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r6[0] = "projection";
    L19:
        if (r9 == 4) goto L23;
        if (r9 == 5) goto L22;
        r6[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
    L24:
        if (r9 == 3) goto L31;
        if (r9 == 4) goto L32;
        if (r9 == 5) goto L32;
        if (r9 == 6) goto L30;
        r6[2] = "<init>";
        goto L32
    L30:
        r6[2] = "refine";
    L32:
        String r3 = String.format(r2, r6);
        if (r9 == 4) goto L37;
        if (r9 == 5) goto L37;
        throw new IllegalArgumentException(r3);
    L37:
        throw new IllegalStateException(r3);
    L31:
        r6[2] = "replaceType";
        goto L32
    L22:
        r6[1] = "getType";
        goto L24
    L23:
        r6[1] = "getProjectionKind";
        goto L24
    L15:
        r6[0] = "kotlinTypeRefiner";
        goto L19
    L16:
        r6[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        goto L19
    L17:
        r6[0] = WsConstants.KEY_CONNECTION_TYPE;
    L11:
        r5 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public r1 a() {
        r1 r0 = this.f21028a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        e(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public e0 b() {
        e0 r0 = this.f21029b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        e(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public g1 c(kotlin.s0.w.d.l0.n.t1.g r3) {
        if (r3 != null) goto L4;
        e(6);
        throw null;
    L4:
        return new i1(this.f21028a, r3.h(this.f21029b));
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public boolean d() {
        return false;
    }
}
