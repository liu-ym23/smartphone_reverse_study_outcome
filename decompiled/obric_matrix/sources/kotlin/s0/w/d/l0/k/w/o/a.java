package kotlin.s0.w.d.l0.k.w.o;

import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final e0 f20665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f20666b;

    public a(e0 r1, f r2) {
        if (r1 == null) goto L9;
        this.f20665a = r1;
        if (r2 != null) goto L7;
        r2 = this;
    L7:
        this.f20666b = r2;
        return;
    L9:
        c(0);
        throw null;
    }

    private static /* synthetic */ void c(int r7) {
        if (r7 == 1) goto L6;
        if (r7 == 2) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 1) goto L10;
        if (r7 == 2) goto L10;
        int r3 = 3;
    L11:
        Object[] r4 = new Object[r3];
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L15;
        r4[0] = "receiverType";
    L16:
        if (r7 == 1) goto L20;
        if (r7 == 2) goto L19;
        r4[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L21:
        if (r7 == 1) goto L24;
        if (r7 == 2) goto L24;
        r4[2] = "<init>";
    L24:
        String r5 = String.format(r2, r4);
        if (r7 == 1) goto L29;
        if (r7 == 2) goto L29;
        throw new IllegalArgumentException(r5);
    L29:
        throw new IllegalStateException(r5);
    L19:
        r4[1] = "getOriginal";
        goto L21
    L20:
        r4[1] = "getType";
    L15:
        r4[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L10:
        r3 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.k.w.o.f
    public e0 b() {
        e0 r0 = this.f20665a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        c(1);
        throw null;
    }
}
